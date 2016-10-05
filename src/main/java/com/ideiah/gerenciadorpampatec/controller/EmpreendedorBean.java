/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.controller;

import com.ideiah.gerenciadorpampatec.model.Empreendedor;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import com.ideiah.gerenciadorpampatec.dao.EmpreendedorEmailDao;
import com.ideiah.gerenciadorpampatec.model.EmpreendedorEmail;
import com.ideiah.gerenciadorpampatec.model.GerenteRelacionamento;
import com.ideiah.gerenciadorpampatec.model.Projeto;
import com.ideiah.gerenciadorpampatec.util.CpfUtil;
import com.ideiah.gerenciadorpampatec.util.CriptografiaUtil;
import com.ideiah.gerenciadorpampatec.util.EmailUtil;
import com.ideiah.gerenciadorpampatec.util.FacesUtil;
import com.ideiah.gerenciadorpampatec.util.TelefoneUtil;
import java.io.IOException;
import java.io.Serializable;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.HttpSession;

/**
 *
 * @author AugustoCesar
 */
@ManagedBean(name = "empreendedorBean")
@ViewScoped
public class EmpreendedorBean implements Serializable {

    private String outcome = "LoginEmpreendedor";
    private String userInput = "";
    private String senhaInput = "";
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private String formacao;
    private String experiencia;
    private String competencia;
    private String bairro;
    private String rua;
    private String numero;
    private String complemento;
    private Empreendedor empreendedor;
    private EmpreendedorEmailDao empreendedorEmailDao;
    private EmpreendedorEmail empreendedorEmail;
    private HttpSession session;
    private EmailUtil emailUtil;
    @ManagedProperty(value = "#{userBean}")
    private UserBean userBean;

    public EmpreendedorBean() {
        session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        this.empreendedor = (Empreendedor) session.getAttribute("empreendedorIncompleto");
        if (empreendedor != null) {
            empreendedor.getEmail();
        }
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public String getUserInput() {
        return userInput;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }

    public boolean verificaProjetoEmpreededor(Empreendedor emp) {
        HttpSession sessao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        Projeto projeto = (Projeto) sessao.getAttribute("projetoSelecionado");

        return empreendedor.verificaProjetoEmpreendedor(emp, projeto);
    }
    
       /**
     * metodo que atualiza o e-mail do empreendedor
     */
    public void atualizaEmail() {
        
        GerenteRelacionamento gerente = new GerenteRelacionamento();
        if (empreendedor.buscarPorEmail(email) != null || gerente.buscarPorEmail(email) != null) {
            FacesUtil.addErrorMessage("Email já cadastrado!", "formConfirmaEmail:email");
        } else {
             //gera id unico para o empreendedor, para ser usado na confirmacao de email.
            empreendedor.setIdUnico(geraIdUnico());
            empreendedor.setEmail(email);
            if(empreendedor.atualizarEmpreendedor(empreendedor) != null){
                EmailUtil.mandarEmailConfirmacao(empreendedor.getNome(), empreendedor.getEmail(), empreendedor.getIdUnico());
                session.setAttribute("empreendedorIncompleto", empreendedor);
                FacesUtil.addSuccessMessage("E-mail atualizado e reenviado com sucesso!", "formReenviaEmail:linkEmail");
                email = "";
            }
            
        }
    }

    public void chamaCadastro() {
        empreendedor = new Empreendedor();
        GerenteRelacionamento gerente = new GerenteRelacionamento();
        empreendedor.setNome(nome);
        cpf = FacesUtil.removeCaracteres(cpf);
        if (empreendedor.buscarPorCpf(cpf) != null) {
            FacesUtil.addErrorMessage("CPF já cadastrado!", "formularioCadastro:cpf");
        } else {
            empreendedor.setCpf(cpf);
            empreendedor.setFormacao(formacao);
            if (empreendedor.buscarPorEmail(email) != null || gerente.buscarPorEmail(email) != null) {
                FacesUtil.addErrorMessage("Email já cadastrado!", "formularioCadastro:email");
            } else if (CpfUtil.isValidCPF(cpf) == false) {
                FacesUtil.addErrorMessage("CPF invalido!", "formularioCadastro:cpf");
            } else {
                empreendedor.setEmail(email);
                empreendedor.setTelefone(TelefoneUtil.removeParentesesTelefone(telefone));
                empreendedor.setSenha(CriptografiaUtil.md5(senhaInput));
                empreendedor.setRua(rua);
                empreendedor.setNumero(Integer.parseInt(numero));
                empreendedor.setBairro(bairro);
                empreendedor.setComplemento(complemento);
                empreendedor.setExperiencia(experiencia);

                //gera id unico para o empreendedor, para ser usado na confirmacao de email.
                empreendedor.setIdUnico(geraIdUnico());
                EmailUtil.mandarEmailConfirmacao(nome, email, empreendedor.getIdUnico());

                if (empreendedor.cadastrarEmpreendedor(empreendedor) != null) {
                    FacesUtil.addSuccessMessage("Cadastro realizado com sucesso! Verifique seu E-mail!", "formularioCadastro:botaoEnviar");
//                        depois do processamento, aqui ele coloca os campos que vão ser recuperados para tela
//                        como nulos. Portanto, ele salva no banco depois limpa a tela. (só funciona com refresh)

                    nome = null;
                    cpf = null;
                    rua = null;
                    email = null;
                    senhaInput = null;
                    telefone = null;
                    numero = null;
                    bairro = null;
                    complemento = null;
                    experiencia = null;
                    formacao = null;

                    try {
                        // LoginBean.MudarNome(empreendedor.getNome());
                        UserBean.MudarSenha(empreendedor.getSenha());
                        UserBean.MudarUser(empreendedor.getEmail());
                        empreendedor = empreendedor.buscarPorEmail(empreendedor.getEmail());
                        session.setAttribute("empreendedorIncompleto", empreendedor);
                        FacesContext.getCurrentInstance().getExternalContext().redirect("confirmarEmail.jsf");
                    } catch (IOException ex) {
                        Logger.getLogger(EmpreendedorBean.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    FacesUtil.addErrorMessage("Cadastro não realizado.!", "formularioCadastro:botaoEnviar");
                }
            }
        }
    }

    /**
     * método que reenvia e-mail para o empreededor
     */
    public void reenviaEmail() {

        HttpSession sessao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);

        Empreendedor empreendedor = (Empreendedor) sessao.getAttribute("empreendedorIncompleto");

        if (EmailUtil.mandarEmailConfirmacao(empreendedor.getNome(), empreendedor.getEmail(), empreendedor.getIdUnico())) {
//            FacesUtil.addSuccessMessage("E-mail reenviado!", "formReenviaEmail:linkEmail");
        }

    }

    /**
     * Gera um id Unico para usar na verificacao de email
     *
     * @return idUnico
     */
    private String geraIdUnico() {
        String idUnico;
        idUnico = UUID.randomUUID().toString();
        return idUnico;
    }

    /**
     * Método para salvar a nova senha do usuário a partir da recuperação pelo
     * link submetido para o email
     */
    public void terminarRecuperacaoDeSenha() {
        
        empreendedor = (Empreendedor) session.getAttribute("empreendedor");

        if (empreendedor != null) {

            this.empreendedor.setSenha(CriptografiaUtil.md5(senhaInput));
            empreendedor.setIdUnico(null);
            empreendedor.atualizarEmpreendedor(empreendedor);

            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("loginEmpreendedor.jsf");

            } catch (IOException ex) {
                Logger.getLogger(EmpreendedorBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void terminarCadastro() {
        this.empreendedor.setIdUnico(null);
        this.empreendedor.setNome(nome);
        cpf = FacesUtil.removeCaracteres(cpf);
        if (empreendedor.buscarPorCpf(cpf) != null) {
            FacesUtil.addErrorMessage("CPF já cadastrado!", "formularioCadastro:cpf");
        } else {
            empreendedor.setCpf(cpf);
            empreendedor.setFormacao(formacao);
            if (CpfUtil.isValidCPF(cpf) == false) {
                FacesUtil.addErrorMessage("CPF invalido!", "formularioCadastro:cpf");
            } else {
                empreendedor.setTelefone(TelefoneUtil.removeParentesesTelefone(telefone));
                empreendedor.setSenha(CriptografiaUtil.md5(senhaInput));
                empreendedor.setRua(rua);
                empreendedor.setNumero(Integer.parseInt(numero));
                empreendedor.setBairro(bairro);
                empreendedor.setComplemento(complemento);
                empreendedor.setExperiencia(experiencia);

                if (empreendedor.atualizarEmpreendedor(empreendedor) != null) {
                    FacesUtil.addSuccessMessage("Cadastro finalizado com sucesso!", "formularioCadastro:botaoEnviar");

                    try {
                        // LoginBean.MudarNome(empreendedor.getNome());
                        getUserBean().setNome(nome);
                        UserBean.MudarSenha(empreendedor.getSenha());
                        UserBean.MudarUser(empreendedor.getEmail());
                        session.setAttribute("empreendedorIncompleto", empreendedor);
                        nome = null;
                        cpf = null;
                        rua = null;
                        email = null;
                        senhaInput = null;
                        telefone = null;
                        numero = null;
                        bairro = null;
                        complemento = null;
                        experiencia = null;
                        formacao = null;
                        FacesContext.getCurrentInstance().getExternalContext().dispatch("/loginEmpreendedor.jsf");
                    } catch (IOException ex) {
                        Logger.getLogger(EmpreendedorBean.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    FacesUtil.addErrorMessage("Cadastro não realizado!", "formularioCadastro:botaoEnviar");
                }
            }
        }

    }

    /**
     *
     * @param email
     * @param id
     */
    public void recuperarSenha(String email, String id) {
        empreendedor.buscaPorEmail(email);
        this.empreendedorEmail.setEmpreendedor(empreendedor);
        this.empreendedorEmail.setIdEmpreendedorEmail(id);
        this.empreendedorEmail.setTipo("Recuperação de Senha");
    }

//    public void chamaLogin() {
//        empreendedor.fazLogin();
//    }
    /**
     * @return the senhaInput
     */
    public String getSenhaInput() {
        return senhaInput;
    }

    /**
     * @param senhaInput the senhaInput to set
     */
    public void setSenhaInput(String senhaInput) {
        this.senhaInput = senhaInput;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the formacao
     */
    public String getFormacao() {
        return formacao;
    }

    /**
     * @param formacao the formacao to set
     */
    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    /**
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @return the rua
     */
    public String getRua() {
        return rua;
    }

    /**
     * @param rua the rua to set
     */
    public void setRua(String rua) {
        this.rua = rua;
    }

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return the complemento
     */
    public String getComplemento() {
        return complemento;
    }

    /**
     * @param complemento the complemento to set
     */
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    /**
     * @return the empreendedor
     */
    public Empreendedor getEmpreendedor() {
        return empreendedor;
    }

    /**
     * @param empreendedor the empreendedor to set
     */
    public void setEmpreendedor(Empreendedor empreendedor) {
        this.empreendedor = empreendedor;
    }

    /**
     * @return the experiencia
     */
    public String getExperiencia() {
        return experiencia;
    }

    /**
     * @param experiencia the experiencia to set
     */
    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    /**
     * @return the competencia
     */
    public String getCompetencia() {
        return competencia;
    }

    /**
     * @param competencia the competencia to set
     */
    public void setCompetencia(String competencia) {
        this.competencia = competencia;
    }

    public UserBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }
}
