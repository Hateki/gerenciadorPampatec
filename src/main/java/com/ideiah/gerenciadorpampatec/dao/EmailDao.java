/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.dao;

import com.ideiah.gerenciadorpampatec.model.EmailSystemConfig;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author unipampa
 */
public class EmailDao extends Dao implements Serializable {

    public EmailDao() {
    }

    /**
     * <p>
     * Método que retorna todos os emails do sistema.</p>
     *
     * @return a lista de emails do sistema.
     */
    public ArrayList<EmailSystemConfig> buscarTodosEmailsSystema() {
        return (ArrayList<EmailSystemConfig>) buscarObjetos(EmailSystemConfig.class);
    }

    /**
     * 
     * @param id
     * @return 
     */
    public EmailSystemConfig buscarPorId(int id) {
        return (EmailSystemConfig) buscarObjeto(id, EmailSystemConfig.class);
    }
}
