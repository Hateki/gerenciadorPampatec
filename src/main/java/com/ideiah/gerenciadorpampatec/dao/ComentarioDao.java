/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.dao;

import com.ideiah.gerenciadorpampatec.model.AlteracaoCampos;
import com.ideiah.gerenciadorpampatec.model.ComentarioProjeto;
import com.ideiah.gerenciadorpampatec.model.Textocomentario;
import java.io.Serializable;
import org.hibernate.HibernateException;

/**
 *
 * @author MAICON
 */
public class ComentarioDao extends Dao implements Serializable{

    public ComentarioDao() {
    }
    
        
//<editor-fold defaultstate="collapsed" desc="Salvar">
    
    
     
    //salva o objeto comentario inteiro no banco
    public ComentarioProjeto salvarComentarioProjeto(ComentarioProjeto comentarioprojeto){
        return (ComentarioProjeto) super.salvar(comentarioprojeto);
    }
    
    /**
     * Salva o texto comentário no banco.
     * @param comentario comentário a se salvar
     * @return true se foi salvo
     */
    public Textocomentario  salvarTextoComentario(Textocomentario comentario){
        return (Textocomentario) super.salvar(comentario);
    }
    
    /**
     * Salva a alteracao campo no banco.
     * @param alteracao comentário a se salvar
     * @return true se foi salvo
     */
    public AlteracaoCampos  salvarAlteracaoCampos(AlteracaoCampos alteracao){
        return (AlteracaoCampos) super.salvar(alteracao);
    }
    
    public ComentarioProjeto salvarRetornandoComentarioProjeto(ComentarioProjeto comentarioProjeto) {
        try {
            setTx(getSession().getTransaction());
            getTx().begin();
            comentarioProjeto = (ComentarioProjeto) getSession().merge(comentarioProjeto);
            getTx().commit();
            return comentarioProjeto;
        } catch (HibernateException e) {
            e.printStackTrace();
            getSession().getTransaction().rollback();
        }
        return null;
    }
    
//</editor-fold>
     
    
//<editor-fold defaultstate="collapsed" desc="Buscar">
    
    /**
     * <p>busca comentário pelo código.</p>
     * 
     * @param codigo
     * @return 
     */
    public ComentarioProjeto buscar(int codigo) {
        return (ComentarioProjeto) buscarObjeto(codigo, ComentarioProjeto.class);
    }
    
    /**
     * <p>busca comentário pelo status.</p>
     * 
     * @param status
     * @return 
     */
    public ComentarioProjeto buscarPorStatus(int status) {
        return (ComentarioProjeto) buscarObjetoCriteriaINT("status", status, ComentarioProjeto.class);
    }
    
    //busca comentario pelo projeto
    
//</editor-fold>

}
