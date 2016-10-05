/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.dao;

import com.ideiah.gerenciadorpampatec.model.GerenteRelacionamento;
import java.util.ArrayList;

/**
 *
 * @author GUTO
 */
public class GerenteDao extends Dao{
    
    /**
     * 
     * @param email
     * @return GerenteRelacionamento que possui esse email
     */
    public GerenteRelacionamento buscaPorEmail(String email) {
        return (GerenteRelacionamento) buscarObjetoCriteria("email", email, GerenteRelacionamento.class);
    }  
    /**
     * 
     * @param cpf
     * @return GerenteRelacionamento que possui esse cpf
     */
    public GerenteRelacionamento buscarPorCpf(String cpf) {
        return (GerenteRelacionamento) buscarObjetoCriteria("cpf", cpf, GerenteRelacionamento.class);

    }
     /**
      * Método que busca a lista inteira de gerentes de relacionamento.
      * 
     * @return a lista inteira de gerentes de Relacionamento 
     */
    public ArrayList<?> buscarTodosGerente() {
        return  buscarObjetos(GerenteRelacionamento.class);

    }
}
