package com.ideiah.gerenciadorpampatec.controller;

import com.ideiah.gerenciadorpampatec.model.Empreendedor;
import com.ideiah.gerenciadorpampatec.model.EmpreendedorEmail;
import com.ideiah.gerenciadorpampatec.model.GerenteRelacionamento;
import com.ideiah.gerenciadorpampatec.util.CriptografiaUtil;
import com.ideiah.gerenciadorpampatec.util.EmailUtil;
import com.ideiah.gerenciadorpampatec.util.TelefoneUtil;
import com.ideiah.gerenciadorpampatec.util.FacesUtil;
import java.io.IOException;
import java.io.Serializable;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;

@ManagedBean(name = "editarEmpreendedorBean")
@ViewScoped
public class EditarEmpreendedorBean implements Serializable {

    private Empreendedor empreendedor;
    private EmpreendedorEmail empreendedorEmail;
    private HttpSession session;
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
    private String senha;
    private String novaSenha;
    private boolean salvou;
    @ManagedProperty(value = "#{userBean}")
    private UserBean userBean;

    public EditarEmpreendedorBean() {
        
        session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        this.empreendedor = (Empreendedor) session.getAttribute("empreendedor");
        if (empreendedor != null) {
            empreendedor.getEmail();
        }
        this.senha = "";
        this.telefone = empreendedor.getTelefone();
        this.nome = empreendedor.getNome();
        this.bairro = empreendedor.getBairro();
        this.cpf = empreendedor.getCpf();
        this.email = empreendedor.getEmail();
        this.formacao = empreendedor.getFormacao();
        this.rua = empreendedor.getRua();
        this.complemento = empreendedor.getComplemento();
        this.numero = String.valueOf(empreendedor.getNumero());
        this.experiencia = empreendedor.getExperiencia();
        salvou = false;

    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getFormacao() {
        return formacao;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public String getCompetencia() {
        return competencia;
    }

    public String getBairro() {
        return bairro;
    }

    public String getRua() {
        return rua;
    }

    public String getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    public void setCompetencia(String competencia) {
        this.competencia = competencia;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public void setEmpreendedor(Empreendedor empreendedor) {
        this.empreendedor = empreendedor;
    }

    public Empreendedor getEmpreendedor() {
        return empreendedor;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNovaSenha() {
        return novaSenha;
    }

    public void setNovaSenha(String novaSenha) {
        this.novaSenha = novaSenha;
    }

    public void editarEmpreendedor() {
        HttpSession secao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        empreendedor = (Empreendedor) secao.getAttribute("empreendedor");
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("editarDadosEmpreendedor.jsf");
        } catch (IOException ex) {
            Logger.getLogger(EditarEmpreendedorBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void editarEmpreendedorRevisar() {
        HttpSession secao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        empreendedor = (Empreendedor) secao.getAttribute("empreendedor");
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("../editarDadosEmpreendedor.jsf");
        } catch (IOException ex) {
            Logger.getLogger(EditarEmpreendedorBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * <p>
     * A senha atual precisa estar preenchida para salvar os dados. Esta senha
     * precisa coincidir com a senha salva no banco. Se o campo nova senha
     * estiver preenchido, então a senha será alterada. O cpf não poderá ser
     * alterado, pois cada pessoa possui um cpf, e ele é único, e a validação de
     * cpf já foi feita no cadastro do empreendedor
     *
     * </p>
     */
    public void finalizarEdicao() {

        GerenteRelacionamento gerente = new GerenteRelacionamento();
        boolean emailok = false;
        boolean novoEmail = false;

        senha = CriptografiaUtil.md5(senha);

        if (empreendedor.getSenha().equals(senha)) {
            String numeroTelefone;
            this.empreendedor.setNome(nome);
            empreendedor.setRua(rua);
            empreendedor.setNumero(Integer.parseInt(numero));
            empreendedor.setBairro(bairro);
            empreendedor.setComplemento(complemento);
            empreendedor.setExperiencia(experiencia);
            numeroTelefone = String.valueOf(telefone);
            empreendedor.setTelefone(TelefoneUtil.removeParentesesTelefone(numeroTelefone));
            empreendedor.setFormacao(formacao);

            //verifica se o usuario alterou o email para um email que não esteja cadastrado no sistema
            //se sim, o email é alterado e o id unico é setado
            if (!empreendedor.getEmail().equals(email)) {
                if (empreendedor.buscarPorEmail(email) != null || gerente.buscarPorEmail(email) != null) {
                    FacesUtil.addErrorMessage("Email já cadastrado!", "formularioCadastro:email");
                } else {
                    emailok = true;
                    novoEmail = true;
                    empreendedor.setEmail(email);
                    empreendedor.setIdUnico(geraIdUnico());
                }
            } else {
                emailok = true;
            }
            if (!novaSenha.isEmpty()) {
                empreendedor.setSenha(CriptografiaUtil.md5(novaSenha));
            }

            if (emailok && empreendedor.atualizarEmpreendedor(empreendedor) != null) {
                try {

                    getUserBean().setNome(nome);
                    UserBean.MudarSenha(empreendedor.getSenha());
                    UserBean.MudarUser(empreendedor.getEmail());
                    session.setAttribute("empreendedor", empreendedor);
                    salvou = true;

                    if (novoEmail) {
                        //envia email para confirmação pois o email foi alterado laga laga vem comigo vem contigo
                        EmailUtil.mandarEmailConfirmacaoEdicao(empreendedor.getNome(), empreendedor.getEmail(), empreendedor.getIdUnico());
                        SystemAccessBean.fazLogoutEdicao();
                    }
                } catch (NullPointerException e) {
                    System.out.println("Ocorreu um erro ao substituir o empreendedor na sessão" + this.getClass().getName());
                    FacesUtil.addErrorMessage("Cadastro não realizado! Ocorreu um ao tentar salvar as informações", "formularioCadastro:botaoEnviar");
                }
            } else {
                FacesUtil.addErrorMessage("Atualização de cadastro não realizada!", "formularioCadastro:botaoEnviar");
            }
        } else {
            FacesUtil.addErrorMessage("Senha incorreta", "formularioCadastro:senhaAtual");
        }

    }

    public void cancelarEdicao() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("homeEmpreendedor.jsf");
        } catch (IOException ex) {
            Logger.getLogger(EditarEmpreendedorBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void showMessage() {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Edição", "Edição realizda com sucesso!");
        RequestContext.getCurrentInstance().showMessageInDialog(message);
    }

    public UserBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

    /**
     * @return the salvou
     */
    public boolean isSalvou() {
        return salvou;
    }

    /**
     * @param salvou the salvou to set
     */
    public void setSalvou(boolean salvou) {
        this.salvou = salvou;
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
}
