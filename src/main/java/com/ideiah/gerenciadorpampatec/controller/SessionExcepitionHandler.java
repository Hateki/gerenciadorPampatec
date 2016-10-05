/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.controller;

import com.ideiah.gerenciadorpampatec.model.GerenteRelacionamento;
import com.ideiah.gerenciadorpampatec.model.Projeto;
import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Pedro
 */
public class SessionExcepitionHandler extends ExceptionHandlerWrapper {

    private ExceptionHandler wrapped;
    private static final Logger log = Logger.getLogger(SessionExcepitionHandler.class.getCanonicalName());

    public SessionExcepitionHandler(ExceptionHandler wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public ExceptionHandler getWrapped() {
        return wrapped;
    }

    @Override
    public void handle() {
        //Iterate over all unhandeled exceptions
        Iterator i = getUnhandledExceptionQueuedEvents().iterator();
        while (i.hasNext()) {
            ExceptionQueuedEvent event = (ExceptionQueuedEvent) i.next();
            ExceptionQueuedEventContext context
                    = (ExceptionQueuedEventContext) event.getSource();

            //obtain throwable object
            Throwable t = context.getException();
            Throwable tCausa = retornaCausa(t);

            if (getSessao() != null) {
                //here you do what ever you want with exception
                try {
                    /**
                     * Muda o status do projeto caso o usuário seja um gerente.
                     */
                    ProjectSatusManager.tratamentoStatusSendoAvaliado();
                    SessionManager.finalizaSessao();
                } finally {
                    /**
                     * Verifica se a sessão ainda não foi finalizada, caso
                     * positivo mata a sessão após uma exceção ser gerada no
                     * sistema.
                     */
                    if (getSessao() != null) {
                        getSessao().invalidate();
                    }
                    /**
                     * Método que redireciona o usuário para a página de erro
                     * 500.
                     */
                    redirecionaPaginaErro();
                    //after exception is handeled, remove it from queue
                    i.remove();
                }
            } else {
                redirecionaPaginaErro();
            }
        }
        //let the parent handle the rest
        getWrapped().handle();
    }

    /**
     * <p>
     * Redireciona o usuário para uma tela dependendo da excepition que ele
     * recebe.</p>
     *
     * @param nomeExecption
     */
//    private void lidaExcepition(String nomeExecption) {
//        FacesContext facesContext = FacesContext.getCurrentInstance();
//        String errorPageLocation = null;
//        if (nomeExecption.equals("javax.faces.application.ViewExpiredException")) {
//            errorPageLocation = "/WEB-INF/errorpages/expired.xhtml";
//            redirecionaPagina(facesContext, errorPageLocation);
//        } else if (nomeExecption.equals("com.sun.faces.mgbean.ManagedBeanCreationException")) {
//            errorPageLocation = "/WEB-INF/errorpages/expired.xhtml";
//            redirecionaPagina(facesContext, errorPageLocation);
//        } else {
//            try {
//                facesContext.getExternalContext().redirect("loginEmpreendedor.jsf");
//            } catch (IOException ex) {
//                Logger.getLogger(SessionExcepitionHandler.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//    }
    /**
     * <p>
     * Método para redirecionar o usuário para a página de erro 500.</p>
     */
    private void redirecionaPaginaErro() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        String errorPageLocation;
        errorPageLocation = "/WEB-INF/errorpages/500.xhtml";
        redirecionaPagina(facesContext, errorPageLocation);
    }

    /**
     * <p>
     * Redireciona para a página especificada.</p>
     *
     * @param errorPageLocation
     */
    private void redirecionaPagina(FacesContext facesContext, String errorPageLocation) {
        facesContext.setViewRoot(facesContext.getApplication().getViewHandler().createView(facesContext, errorPageLocation));
        facesContext.getPartialViewContext().setRenderAll(true);
        facesContext.renderResponse();
    }

    /**
     * <p>
     * Método que retorna a sessão do usuário logado.</p>
     *
     * @return sessão do tipo HttpSession.
     */
    private HttpSession getSessao() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
        return session;
    }

    /**
     * <p>
     * Muda o status do projeto para em pré-avaliação quando o gerente recebe
     * uma excepition na página de pré-avaliar.</p>
     */
//    private void mudaStatusProjeto() {
//        FacesContext facesContext = FacesContext.getCurrentInstance();
//        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
//        GerenteRelacionamento gerente = (GerenteRelacionamento) session.getAttribute("gerente");
//        Projeto projeto = (Projeto) session.getAttribute("projetoSelecionado");
//
//        if (gerente != null && projeto != null && projeto.getStatus() == Projeto.SENDO_AVALIADO) {
//            projeto.setStatus(Projeto.EM_PRE_AVALIACAO);
//            session.removeAttribute("projetoSelecionado");
//        }
//    }
    /**
     * <p>
     * Procura a causa de uma exceção jogada.</p>
     *
     * @param t
     * @return
     */
    public Throwable retornaCausa(Throwable t) {
        Throwable tCausa = t.getCause();
        if (tCausa == null) {
            return t;
        } else {
            return retornaCausa(tCausa);
        }
    }
}
