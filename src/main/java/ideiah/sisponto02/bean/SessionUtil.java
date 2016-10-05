/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideiah.sisponto02.bean;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 * Classe usada para pegar variáveis relacionadas a sessão do usuário
 * @author Pedro
 */

public class SessionUtil {
    
    /**
     * 
     * @return FacesContext do usuário, se existir.
     */
    public static FacesContext getFacesContext(){
        return FacesContext.getCurrentInstance();
    }
    
    /**
     * 
     * @return ExternalContext do usuário, se existir.
     */
    public static ExternalContext getExternalContext(){
        return getFacesContext().getExternalContext();
    }
    
    /**
     * 
     * @param criarSessao variável para determinar se se deve criar
     * uma sessão se mesma não existir.
     * @return HttpSession do usuário, se existir.
     */
    public static HttpSession getSession(boolean criarSessao){
        return (HttpSession) getExternalContext().getSession(criarSessao);
    }
}
