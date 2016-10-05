/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.model;

import java.io.Serializable;

/**
 * <p>
 * Classe responsável por manter o objeto email do sistema.</p>
 *
 * @author unipampa
 */
public class EmailSystemConfig implements Serializable {

    private Integer id_systememail;
    /**
     * Variáveis para manipular o email do sistema.
     */
    private String email;
    private String passphrase;

    public EmailSystemConfig() {
        email = "";
        passphrase = "";
    }

    public EmailSystemConfig(String authEmail, String authPassphrase) {
        this.email = authEmail;
        this.passphrase = authPassphrase;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String aAuthEmail) {
        email = aAuthEmail;
    }

    public String getPassphrase() {
        return passphrase;
    }

    public void setPassphrase(String aAuthPassphrase) {
        passphrase = aAuthPassphrase;
    }

    public Integer getId_systememail() {
        return id_systememail;
    }

    public void setId_systememail(Integer id_systememail) {
        this.id_systememail = id_systememail;
    }

}
