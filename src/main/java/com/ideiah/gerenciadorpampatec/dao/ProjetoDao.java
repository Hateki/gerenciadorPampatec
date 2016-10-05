/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.dao;

import com.ideiah.gerenciadorpampatec.model.Empreendedor;
import com.ideiah.gerenciadorpampatec.model.Projeto;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import org.hibernate.HibernateException;

/**
 *
 * @author Pedro
 */
public class ProjetoDao extends Dao implements Serializable {

    public ProjetoDao() {
        
    }    
    
//<editor-fold defaultstate="collapsed" desc="Salvar">

    public Projeto salvar(Projeto projeto) {
        return (Projeto) super.salvar(projeto);
    }

    public Projeto salvarRetornandoProjeto(Projeto projeto) {
        try {
            setTx(getSession().getTransaction());
            getTx().begin();
            projeto = (Projeto) getSession().merge(projeto);
            getTx().commit();
            return projeto;
        } catch (HibernateException e) {
            e.printStackTrace();
            getSession().getTransaction().rollback();
        }
        return null;
    }

    public Projeto update(Projeto projeto) {
        return (Projeto) super.update(projeto);
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Buscar">
    public ArrayList<Projeto> buscar() {
        return (ArrayList<Projeto>) buscarObjetos(Projeto.class);
    }

    public Projeto buscar(int codigo) {
        return (Projeto) buscarObjeto(codigo, Projeto.class);
    }
    
    public ArrayList<Projeto> buscarListaProjetoPorStatus(int status){
        
        ArrayList<Projeto> listaDeProjeto = new ArrayList<>();
 
        listaDeProjeto = (ArrayList<Projeto>) buscarObjetosCritera("status", status, Projeto.class);
        
        return listaDeProjeto;
    }
    
    
    public boolean verificaEmpreendedor(Empreendedor empreendedor, Projeto projeto) {

        for (Object obj : empreendedor.getProjetos().toArray()) {
            Projeto proj = (Projeto) obj;
            if (proj.getIdProjeto() == projeto.getIdProjeto()) {
                return false;
            }
        }
        return true;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Deletar">
    public boolean deletar(int codigo) {
        return excluir(codigo, Projeto.class);
    }
//</editor-fold>
    
}
