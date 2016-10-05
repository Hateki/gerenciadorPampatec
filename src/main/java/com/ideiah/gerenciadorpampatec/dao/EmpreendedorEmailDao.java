/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.dao;

import com.ideiah.gerenciadorpampatec.model.Empreendedor;
import com.ideiah.gerenciadorpampatec.model.EmpreendedorEmail;
import java.util.ArrayList;

/**
 *
 * @author Jhonatan Moura
 */
public class EmpreendedorEmailDao extends Dao {

    //<editor-fold defaultstate="collapsed" desc="Salvar">
    public EmpreendedorEmail salvar(EmpreendedorEmail empreendedorEmail) {
        return (EmpreendedorEmail) super.salvar(empreendedorEmail);
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Buscar">
    public ArrayList<EmpreendedorEmail> buscar() {
        return (ArrayList<EmpreendedorEmail>) buscarObjetos(EmpreendedorEmail.class);
    }

    public EmpreendedorEmail buscar(int codigo) {
        return (EmpreendedorEmail) buscarObjeto(codigo, EmpreendedorEmail.class);
    }

    public EmpreendedorEmail buscarPorIdUnico(String idUnico) {
        return (EmpreendedorEmail) buscarObjetoCriteria("idEmpreendedorEmail", idUnico, EmpreendedorEmail.class);

    }
    
    /**
     * 
     * @param empreendedorEmail
     * @return O empreendedor que está com a ID inserida na EmpreendedorEmail
     */
    public Empreendedor buscarEmpreendedorPorId(EmpreendedorEmail empreendedorEmail) {
        return empreendedorEmail.getEmpreendedor();
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Deletar">
    public boolean deletar(int codigo) {
        return excluir(codigo, EmpreendedorEmail.class);
    }
    
    public boolean deletarPorIdUnico(String idUnico) {
        return excluir(idUnico, EmpreendedorEmail.class);
    }
//</editor-fold>

}
