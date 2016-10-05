/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.controller;

import com.ideiah.gerenciadorpampatec.model.Empreendedor;
import com.ideiah.gerenciadorpampatec.model.EmpreendedorEmail;
import com.ideiah.gerenciadorpampatec.model.GerenteRelacionamento;
import com.ideiah.gerenciadorpampatec.util.CpfUtil;
import com.ideiah.gerenciadorpampatec.util.CriptografiaUtil;
import com.ideiah.gerenciadorpampatec.util.EmailUtil;
import com.ideiah.gerenciadorpampatec.util.FacesUtil;
import java.io.Serializable;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * <p>
 * Classe responsável por gerenciar o acesso dos usuários ao sistema.
 * </p>
 *
 * @author unipampa
 * @since 16-06-2016
 */
@ManagedBean
@RequestScoped
public class SystemAccessBean implements Serializable {

    private String user;
    private String passphrase;
    private String nome;
    private String emailRecuperarSenha;
    boolean cadastroIncompleto;
    private boolean recuperarSenha;
    private boolean emailEnviado;

    public SystemAccessBean() {
        recuperarSenha = false;
        emailEnviado = false;
    }

    /**
     * <p>
     * Método que executa a chamada para verificar a existência do usuário que
     * está realizando Login no sistema.</p>
     */
    public void submit() {
        try {
            if (loginGerente(user, passphrase)) {
            } else if (loginEmpreendedor(user, passphrase)) {
            }
        } catch (Exception e) {
            System.out.println("Origem: " + this.getClass().getName()
                    + ":: \t Exceção inesperada" + e);
        }
    }

    /**
     * <p>
     * Método que realiza o login do Gerente no sistema.</p>
     *
     * @param user
     * @param senha
     * @return <code>True</code> caso o usuário exista e seja um gerente,
     * <code>False</code> para todos os demais casos.
     */
    private boolean loginGerente(String user, String senha) {
        try {
            GerenteRelacionamento gerente = new GerenteRelacionamento();

            if (soContemNumeros(user)) {
                if (CpfUtil.isValidCPF(user)) {
                    gerente = gerente.buscarPorCpf(user);
                } else {
                    FacesUtil.addErrorMessage(" Usuário ou Senha incorreto(s) ", "formularioDeLogin:botaoLogin");
                }
            } else {
                gerente = gerente.buscarPorEmail(user);
            }
            senha = CriptografiaUtil.md5(senha);
            if (gerente.getSenha().equals(senha)) {
                FacesUtil.addSuccessMessage("Logado");
                SessionManager.getCreateSession().setAttribute("gerente", gerente);
                this.setNome(gerente.getNome());

                try {
                    RedirectManager.getInicioGerente();
                    return true;
                } catch (Exception ex) {
                    Logger.getLogger(SystemAccessBean.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                FacesUtil.addErrorMessage(" Usuário ou Senha incorreto(s) ", "formularioDeLogin:botaoLogin");
                return false;
            }
        } catch (NullPointerException nullpointer) {
            FacesUtil.addErrorMessage(" Usuário ou Senha incorreto(s) ", "formularioDeLogin:botaoLogin");
            return false;
        }
        return false;
    }

    /**
     * <p>
     * Método que realiza o login do empreendedor no sistema.</p>
     *
     * @param user
     * @param senha
     * @return <code>True</code> caso o usuário exista e seja empreendedor,
     * <code>False</code> para todos os demais casos.
     */
    private boolean loginEmpreendedor(String user, String senha) {
        try {
            Empreendedor empreendedor = new Empreendedor();

            if (soContemNumeros(user)) {
                if (CpfUtil.isValidCPF(user)) {
                    empreendedor = empreendedor.buscarPorCpf(user);
                } else {
                    FacesUtil.addErrorMessage(" Usuário ou Senha incorreto(s) ", "formularioDeLogin:botaoLogin");
                }
            } else {
                empreendedor = empreendedor.buscarPorEmail(user);
            }
            senha = CriptografiaUtil.md5(senha);
            if (empreendedor.getSenha().equals(senha)) {
                if (empreendedor.getIdUnico() == null) {

                    FacesUtil.addSuccessMessage("Logado");

                    SessionManager.getCreateSession().setAttribute("empreendedor", empreendedor);

                    this.setNome(empreendedor.getNome());
                    try {
                        RedirectManager.getInicioEmpreendedor();
                        return true;
                    } catch (Exception ex) {
                        Logger.getLogger(SystemAccessBean.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    SessionManager.getCreateSession().setAttribute("empreendedorIncompleto", empreendedor);

                    RedirectManager.getConfirmaEmail();
                    return true;
                }
            } else {
                FacesUtil.addErrorMessage(" Usuário ou Senha incorreto(s) ", "formularioDeLogin:botaoLogin");
                return false;
            }
        } catch (NullPointerException nullpointer) {
            FacesUtil.addErrorMessage(" Usuário ou Senha incorreto(s) ", "formularioDeLogin:botaoLogin");
            return false;
        }
        return false;
    }

    /**
     * <p>
     * Verifica se a <code>String</code> contem apenas números.<p>
     *
     * @param texto
     * @return <code>True</code> caso existam apenas números na frase, e
     * <code>False</code> para todos os demais casos.
     */
    public static boolean soContemNumeros(String texto) {
        if (texto == null) {
            return false;
        }
        for (char letra : texto.toCharArray()) {
            if (letra < '0' || letra > '9') {
                return false;
            }
        }
        return true;
    }

    /**
     * <p>
     * Método que realiza logout do sistema, garantindo o status correto do
     * projeto, finalizando a sessão do usuário e chamando o método para
     * redirecionar para a página inicial do sistema.</p>
     *
     */
    public static void fazLogout() {

        ProjectSatusManager.tratamentoStatusSendoAvaliado();
        SessionManager.finalizaSessao();
        RedirectManager.getLogout();
    }

    /**
     * <p>
     * Método que realiza logout do sistema, garantindo o status correto do
     * projeto, finalizando a sessão do usuário e chamando o método para
     * redirecionar para a página inicial do sistema.</p>
     *
     */
    public static void fazLogoutEdicao() {

        ProjectSatusManager.tratamentoStatusSendoAvaliado();
        SessionManager.finalizaSessao();
        RedirectManager.getLogoutEdicao();
    }

    /**
     * <p>
     * Método para recuperação de senha do usuário. Envia um email para o
     * destino inserido (email) com um link para alterar a senha. Cria um novo
     * empreendedorEmail e seta os valores com tipo (recuperação de senha),
     * idEmpreendedor (chave estrangeira = ID do empreendedor que possui o email
     * inserido e gera um idUnico que é setado no campo de id do
     * empreendedorEmail.</p>
     */
    public void recuperarSenha() {
        Empreendedor empreendedor;
        if (recuperarSenha) {
            if (emailRecuperarSenha == null || emailRecuperarSenha.equals("")) {
                emailEnviado = false;
                FacesUtil.addErrorMessage("Insira um email!", "formularioRecuperarSenha:email");
            } else {
                empreendedor = Empreendedor.buscaPorEmail(emailRecuperarSenha);
                if (empreendedor != null) {
                    if (!Empreendedor.verificaDadosEmpreendedor(empreendedor)) {
                        cadastroIncompleto = true;
                        emailEnviado = true;
                        EmailUtil.mandarEmailConcluirCadastro("Acesse o sistema para visualizar", "Acesse o sistema para visualizar", empreendedor.getEmail(), empreendedor.getIdUnico());
                        FacesUtil.addSuccessMessage("Usuário pré-cadastrado. O e-mail para completar o cadastro foi reenviado com sucesso. ", "formularioRecuperarSenha:email");
                    } else {
                        String idUnico = UUID.randomUUID().toString();
                        EmpreendedorEmail empreendedorEmail = new EmpreendedorEmail();
                        empreendedorEmail.setEmpreendedor(empreendedor);
                        empreendedorEmail.setIdEmpreendedorEmail(idUnico);
                        empreendedorEmail.setTipo("Recuperação de Senha");
                        empreendedorEmail.salvarEmpreendedorEmail(empreendedorEmail);
                        emailEnviado = true;
                        EmailUtil.enviarEmailRecuperarSenha(emailRecuperarSenha, idUnico);
                        FacesUtil.addSuccessMessage("Um e-mail para redefinição de senha foi reenviado com sucesso.", "formularioRecuperarSenha:email");
                    }
                } else {
                    emailEnviado = false;
                    FacesUtil.addErrorMessage("O e-mail inserido não está cadastrado!", "formularioRecuperarSenha:email");
                }
            }
            recuperarSenha = false;
        }
    }

    /**
     * <p>
     * Retorna o valor da variável <code>user</code> para manipulação no sistema
     * de login.</p>
     *
     * @return O valor da variável <code>user</code> do tipo
     * <code>String</code>.
     */
    public String getUser() {
        return user;
    }

    /**
     * <p>
     * Define o valor da variável <code>user</code> para manipulação no sistema
     * de login.</p>
     *
     * @param aUser
     */
    public void setUser(String aUser) {
        user = aUser;
    }

    /**
     * <p>
     * Retorna o valor da variável <code>passphrase</code> para manipulação no
     * sistema de login.</p>
     *
     * @return O valor da variável <code>passphrase</code> do tipo
     * <code>String</code>.
     */
    public String getPassphrase() {
        return passphrase;
    }

    /**
     * <p>
     * Define o valor da variável <code>passphrase</code> para manipulação no
     * sistema de login.</p>
     *
     * @param aSenha
     */
    public void setPassphrase(String aSenha) {
        passphrase = aSenha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmailRecuperarSenha() {
        return emailRecuperarSenha;
    }

    public void setEmailRecuperarSenha(String emailRecuperarSenha) {
        this.emailRecuperarSenha = emailRecuperarSenha;
        recuperarSenha = true;
    }

    /**
     * <p>
     * Verifica se o empreendedor está com o cadastro completo.</p>
     *
     * @return
     */
    public boolean verificaCadastroIncompleto() {
        if (cadastroIncompleto) {
            cadastroIncompleto = false;
            return true;
        } else {
            return false;
        }
    }

    public boolean isCadastroIncompleto() {
        return cadastroIncompleto;
    }

    public void setCadastroIncompleto(boolean cadastroIncompleto) {
        this.cadastroIncompleto = cadastroIncompleto;
    }

    public boolean isRecuperarSenha() {
        return recuperarSenha;
    }

    public void setRecuperarSenha(boolean recuperarSenha) {
        this.recuperarSenha = recuperarSenha;
    }

    public boolean isEmailEnviado() {
        return emailEnviado;
    }

    public void setEmailEnviado(boolean emailEnviado) {
        this.emailEnviado = emailEnviado;
    }

}
