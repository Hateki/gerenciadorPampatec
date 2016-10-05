/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.model;

import com.ideiah.gerenciadorpampatec.dao.EmpreendedorEmailDao;

/**
 *
 * @author Jhonatan Moura
 */
public class EmpreendedorEmail {

    private String idEmpreendedorEmail;
    private String tipo;
    private Empreendedor empreendedor;

    public EmpreendedorEmail() {

    }

    /**
     * Construtor da classe EmpreendedorEmail
     *
     * @param idEmpreendedorEmail
     * @param tipo
     * @param empreendedor
     */
    public EmpreendedorEmail(String idEmpreendedorEmail, String tipo, Empreendedor empreendedor) {
        this.idEmpreendedorEmail = idEmpreendedorEmail;
        this.tipo = tipo;
        this.empreendedor = empreendedor;
    }

    /**
     * @return the empreededorDao
     */
    public static EmpreendedorEmailDao getEmpreededorEmailDao() {
        return new EmpreendedorEmailDao();
    }

    /**
     * 
     * @param empreendedorEmail
     * @return 
     */
    public EmpreendedorEmail salvarEmpreendedorEmail(EmpreendedorEmail empreendedorEmail) {
        return getEmpreededorEmailDao().salvar(empreendedorEmail);
    }

    /**
     * @return the idEmpreendedorEmail
     */
    public String getIdEmpreendedorEmail() {
        return idEmpreendedorEmail;
    }

    /**
     * @param idEmpreendedorEmail the idEmpreendedorEmail to set
     */
    public void setIdEmpreendedorEmail(String idEmpreendedorEmail) {
        this.idEmpreendedorEmail = idEmpreendedorEmail;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    public static EmpreendedorEmail buscaEmpreendedorMailID(String id) {
        return getEmpreededorEmailDao().buscarPorIdUnico(id);
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
    
    public void apagarDoBanco(EmpreendedorEmail empreendedorEmail){
        EmpreendedorEmailDao empreendedorEmailDao = new EmpreendedorEmailDao();
        empreendedorEmailDao.deletarPorIdUnico(empreendedorEmail.getIdEmpreendedorEmail());
    }

}
