package com.ideiah.gerenciadorpampatec.controller;

import java.util.Enumeration;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 * <p>
 * Classe para gerenciar a sessão no sistema.</p>
 *
 * @author unipampa
 * @since 17-06-2016
 */
public abstract class SessionManager {

    /**
     * <p>
     * Método para criar uma nova sessão no sistema caso ela não exista.</p>
     *
     * @return Retorna uma nova sessão. Tipo <code>HttpSession</code>.
     */
    public static HttpSession getCreateSession() {
        HttpSession session = (HttpSession) getFacesContext().getExternalContext().getSession(true);
        return session;
    }

    /**
     * <p>
     * Método que retorna a sessão atual do sistema, isso é, ele não cria uma
     * nova sessão caso não exista uma!</p>
     *
     * @return Retorna a sessão existente no sistema. Tipo
     * <code>HttpSession</code>.
     */
    public static HttpSession getSession() {
        HttpSession session = (HttpSession) getFacesContext().getExternalContext().getSession(false);
        return session;
    }
    
    /**
     * <p>
     * Método que retorna o FacesContext para a sessão.</p>
     *
     * @return Retorna o FacesContext. Tipo <code>FacesContext</code>.
     */
    public static FacesContext getFacesContext() {
        return FacesContext.getCurrentInstance();
    }

    /**
     * <p>
     * Retorna o atributo da sessão referente ao parâmetro recebido.</p>
     *
     * @param attribute - O atributo a ser recuperado da sessão.
     * @return O atributo da sessão. Tipo <code>Object</code>.
     */
    public static Object getAttribute(String attribute) {
        return getSession().getAttribute(attribute);
    }

    /**
     * <p>
     * Método que retorna a lista de atributos da sessão existente no
     * sistema.</p>
     *
     * @return A lista de atributos da sessão. Tipo
     * <code>EnumerationString</code> tipado em <code>String</code>.
     */
    public static Enumeration<String> getAttributeNames() {
        return getSession().getAttributeNames();
    }

    /**
     * <p>
     * Método responsável por retorna o tempo máximo da sessão no sistema.</p>
     *
     * @return O tempo da sessão em segundos. Tipo <code>int</code>.
     */
    public static int getMaxInactiveInterval() {
        return getSession().getMaxInactiveInterval();
    }

    /**
     * <p>Método para remover um atributo da sessão.</p>
     *
     * @param string
     */
    public static void removeAttribute(String string) {
        getSession().removeAttribute(string); 
    }

    /**
     * <p>
     * Método que renova a sessão do usuário, pois ele é chamado pelo botão
     * "Renovar Sessão" presente no relógio da sessão, e ao realizar uma
     * requisição no servidor, a mesma é renovada.</p>
     */
    public static void renovaSessaoUsuario() {
        System.out.println("From: SessionManager \t Method: renovaSessaoUsuario()" + "\t Message: Sess\u00e3o renovada com sucesso!");
    }

    /**
     * <p>
     * Método responsável por invalidar a sessão existente no sistema. ATENÇÃO:
     * Não utilizar este método antes de garantir que o status do projeto foi
     * manipulado deforma correta!</p>
     */
    public static synchronized void finalizaSessao() {
        if (getSession() != null) {
            getSession().invalidate();

            System.out.println("From: SessionManager \t  Method: finalizaSessao(), Message: Finalizou a Sessão");
        } else {
            System.out.println("From: SessionManager \t  Method: finalizaSessao(), Message: Sesssão Já Finalizada");
        }
    }
}
