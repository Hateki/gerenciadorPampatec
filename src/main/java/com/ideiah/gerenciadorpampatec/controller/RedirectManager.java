/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.controller;

import static com.ideiah.gerenciadorpampatec.controller.SessionManager.getFacesContext;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * Classe responsável por manipular os redirecionamentos dentro do sistema, 
 * futuramente ela irá utilizar o mapeamento de URLs também.</p>
 *
 * @author PC Unipampa
 */
@ManagedBean
public class RedirectManager implements Serializable {

    public RedirectManager() {
    }

    /**
     * <p>
     * Método responsável por redirecionar para a página inicial do sistema.</p>
     *
     */
    public static void getLogout() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/GerenciadorPampatec");
        } catch (IOException ex) {
            Logger.getLogger(RedirectManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * <p>
     * Método que redireciona para a página inicial do empreendedor.</p>
     */
    public static void getInicio() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("homeEmpreendedor.jsf");
        } catch (IOException ex) {
            Logger.getLogger(RedirectManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * <p>
     * Método que redireciona para a página de confirmação de email.</p>
     */
    public static void getConfirmaEmail() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("confirmarEmail.jsf");
        } catch (IOException ex) {
            Logger.getLogger(RedirectManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        /**
     * <p>
     * Método que redireciona para a página de confirmação de email.</p>
     */
    public static void getLogoutEdicao() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("../../logoutEdicao.jsf");
        } catch (IOException ex) {
            Logger.getLogger(RedirectManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * <p>
     * Método que redireciona para a página inicial do empreendedor, voltando da
     * página de revisar plano de negócio.</p>
     */
    public void getInicioRevisar() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("../homeEmpreendedor.jsf");
        } catch (IOException ex) {
            Logger.getLogger(RedirectManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * <p>
     * Método que redireciona para a página inicial do empreendedor.</p>
     */
    public static void getInicioEmpreendedor() {
        try {
            SessionManager.getFacesContext().getExternalContext().redirect("view/empreendedor/homeEmpreendedor.jsf");
        } catch (IOException ex) {
            Logger.getLogger(SystemAccessBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * <p>
     * Método que redireciona para a página inicial do gerente.</p>
     */
    public static void getInicioGerente() {
        try {
            SessionManager.getFacesContext().getExternalContext().redirect("view/gerentederelacionamento/homeGerenteDeRelacionamentos.jsf");
        } catch (IOException ex) {
            Logger.getLogger(SystemAccessBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * <p>
     * Método que redireciona para a página inicial do gerente após estar logado.</p>
     */
    public static void getInicioGerenteLogado() {
        try {
            SessionManager.getFacesContext().getExternalContext().redirect("homeGerenteDeRelacionamentos.jsf");
        } catch (IOException ex) {
            Logger.getLogger(SystemAccessBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * <p>
     * Método que redireciona para a página de criar planos de negócio do
     * empreendedor.</p>
     */
    public void getEnviarProjeto() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("empreendedor/enviarProjeto.jsf");
        } catch (IOException ex) {
            Logger.getLogger(RedirectManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * <p>
     * Redireciona para a página que contem a tabela de de plano de negócio, na
     * visão do Gerente de Relacionamento.
     * </p>
     */
    public void getVisualizarPlanosGerente() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("buscarPlanoDeNegocio.jsf");
        } catch (IOException ex) {
            Logger.getLogger(RedirectManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * <p>
     * Redireciona para a página que contem a tabela de de plano de negócio do
     * empreendedor.</p>
     */
    public void getVisualizarPlanos() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("paginaBuscaPlanoDeNegocio.jsf");
        } catch (IOException ex) {
            Logger.getLogger(RedirectManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * <p>
     * </p>
     *
     */
    public void getVisualizarPlanosRevisar() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("../paginaBuscaPlanoDeNegocio.jsf");
        } catch (IOException ex) {
            Logger.getLogger(RedirectManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *<p>Método que redireciona para a página com a Lista de Planos de Negócio. </p>
     */
    public static void enviaBuscaProjeto() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("paginaBuscaPlanoDeNegocio.jsf");
        } catch (IOException ex) {
            Logger.getLogger(RedirectManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        
    /**
     * <p>
     * Método para recuperar o url da pagina do sistema.
     * poderá ser usado em links enviados por email
     * ex.: http://localhost:8080/GerenciadorPampatec/confirmarEmail.jsf
     * ESSE MÉTODO DEVERÁ SER ALTERADO DE ACORDO COM O URL DO SISTEMA
     * </p>
     * @return URL
     */
    
    public static String getURL(){
        String URL;
        HttpServletRequest request = (HttpServletRequest) getFacesContext().getExternalContext().getRequest();
        URL = request.getRequestURL().toString();
        
        return URL;
    }
    
    /**
     * <p>
     * Método para recuperar o url absoluto do sistema.
     * poderá ser usado em links enviados por email
     * ex.: http://localhost:8080/GerenciadorPampatec/  (é importante o / no final do link).
     * ESSE MÉTODO DEVERÁ SER ALTERADO DE ACORDO COM O URL DO SISTEMA
     * </p>
     * @return baseURL
     */
    
    public static String getBaseURL(){
        
        HttpServletRequest request = (HttpServletRequest) getFacesContext().getExternalContext().getRequest();
        String URL = request.getRequestURL().toString();
        String baseURL = URL.substring(0, URL.length() - request.getRequestURI().length()) + request.getContextPath() + "/";
        
        return baseURL;
    }
    
    /**
     * <p>
     * Método para recuperar o patch do sistema.
     * poderá ser usado em links enviados por email
     * ex.: /GerenciadorPampatec
     * </p>
     * @return patchURL
     */
    
    public static String getPatchURL(){
        
        HttpServletRequest request = (HttpServletRequest) getFacesContext().getExternalContext().getRequest();
        String patchURL = request.getContextPath();
        
        return patchURL;
    }
}
