/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.controller;

import com.ideiah.gerenciadorpampatec.dao.ProjetoDao;
import com.ideiah.gerenciadorpampatec.model.GerenteRelacionamento;
import com.ideiah.gerenciadorpampatec.model.Projeto;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import org.primefaces.context.RequestContext;

/**
 * Web application lifecycle listener.
 *
 * @author Juliano M.
 */
public class SessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        /**
         * Não é necessário fazer nada aqui.
         */
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        mudaStatusProjetoGerente(session);
    }
    
    /**
     * 
     * @param session 
     */
    public void mudaStatusProjetoGerente(HttpSession session){
        GerenteRelacionamento gdr = (GerenteRelacionamento) session.getAttribute("gerente");
        Projeto projeto;
        
        if (gdr != null) {
            projeto = (Projeto) session.getAttribute("projetoSelecionado");
            if ((projeto != null) && (projeto.getStatus() == Projeto.SENDO_AVALIADO)) {
                projeto.setStatus(Projeto.SUBMETIDO);
                atualizaStatusdProjeto(projeto);
            }
        }
        session.removeAttribute("projetoSelecionado");
    }

    /**
     * Atualiza o Status do projeto conforme as regras do método anterio.
     *
     * @param projeto
     */
    private void atualizaStatusdProjeto(Projeto projeto) {
        ProjetoDao dao = new ProjetoDao();
        dao.update(projeto);
    }
}
