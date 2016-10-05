/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.model;

import com.ideiah.gerenciadorpampatec.dao.GerenteDao;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author GUTO
 */
public class GerenteRelacionamento implements Serializable{
    
    private int idgerente_relacionamento;
    private String senha;
    private String nome;
    private String email;
    private String cpf;
    
    private Set<Notificacao> projetos = new HashSet<>();


     /**
     * @return the gerenteDao
     */
    public static GerenteDao getGerenteDao() {
        return new GerenteDao();
    }
    
    public GerenteRelacionamento() {
    }

    public GerenteRelacionamento(int idgerente_relacionamento, String senha, String nome, String email, String cpf) {
        this.idgerente_relacionamento = idgerente_relacionamento;
        this.senha = senha;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
    }
    /**
     * @return the idgerente_relacionamento
     */
    public int getIdgerente_relacionamento() {
        return idgerente_relacionamento;
    }

    /**
     * @param idgerente_relacionamento the idgerente_relacionamento to set
     */
    public void setIdgerente_relacionamento(int idgerente_relacionamento) {
        this.idgerente_relacionamento = idgerente_relacionamento;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
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
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
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
     * @return the projetos
     */
    public Set<Notificacao> getProjetos() {
        return projetos;
    }

    /**
     * @param projetos the projetos to set
     */
    public void setProjetos(Set<Notificacao> projetos) {
        this.projetos = projetos;
    }
    /**
     * 
     * @param user
     * @return GerenteRelacionamento que possui esse email
     */
    public GerenteRelacionamento buscarPorEmail(String user) {
        return getGerenteDao().buscaPorEmail(user);
    }
    /**
     * 
     * @param user
     * @return  GerenteRelacionamento que possui esse CPF
     */
    public GerenteRelacionamento buscarPorCpf(String user) {
        return getGerenteDao().buscarPorCpf(user);
    }
}
