/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.controller;

import com.ideiah.gerenciadorpampatec.model.Empreendedor;
import com.ideiah.gerenciadorpampatec.model.GerenteRelacionamento;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * <p>
 * Classe responsável por manipular as informações do usuário no sistema,
 * principalmente os dados sensíveis do mesmo.
 * </p>
 *
 * @author unipampa
 * @since 20-06-2016
 */
@ManagedBean
@SessionScoped
public class UserBean implements Serializable {

    private static String senha;
    private static String user; //pode ser email ou senha
    private String nome;

    public UserBean() {
    }

    /**
     * <p>
     * Método verifica a pessoa se a pessoa logada na sessão é um empreendedor,
     * se for, retorna seu nome. se não, retorna o nome do gerente logado na
     * sessao.</p>
     *
     * @return usuario Logado
     */
    public String retornaNomeLogado() {
        String usuarioLogado;
        GerenteRelacionamento gerente;
        Empreendedor empreendedor = (Empreendedor) SessionManager.getAttribute("empreendedor");

        if (empreendedor == null) {
            gerente = (GerenteRelacionamento) SessionManager.getAttribute("gerente");
            usuarioLogado = gerente.getNome();
        } else {
            usuarioLogado = empreendedor.getNome();
        }
        return usuarioLogado;
    }


    /**
     * <p>
     * Método que acessa a classe <code>SessioManager</code> para retorna o
     * tempo máximo da sessão no sistema.</p>
     *
     * @return O tempo da sessão em segundos. Tipo <code>int</code>.
     */
    public int tempoMaximoSessao() {
        return SessionManager.getMaxInactiveInterval();
    }

    /**
     * <p>
     * Método que acessa a classe responsável por manipular a sessão, e finaliza
     * a mesma chamando o método <code>finalizaSessao</code>.</p>
     */
    public void finalizaSessao() {
        SessionManager.finalizaSessao();
    }


    /**
     *
     * @param user
     */
    public static void MudarUser(String user) {
        UserBean.user = user;
    }

    /**
     *
     * @param senha
     */
    public static void MudarSenha(String senha) {
        UserBean.senha = senha;
    }

    /**
     *
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     *
     * @param user the user to set
     */
    public void setUser(String user) {
        UserBean.user = user;
    }

    /**
     *
     *
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     *
     * @param nome the value of nome
     */
    public void MudarNome(String nome) {
        this.nome = nome;
    }

    /**
     *
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     *
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        UserBean.senha = senha;
    }

    /**
     *
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
}
