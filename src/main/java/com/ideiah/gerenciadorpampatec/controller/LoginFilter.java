/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.controller;

import com.ideiah.gerenciadorpampatec.model.Empreendedor;
import java.io.IOException;
import java.util.logging.LogRecord;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Augusto CÃ©sar GÃ¶rgen
 * Funcionalidade: Criar a sessÃ£o para o empreendedor
 * se ele nÃ£o estiver logado, entÃ£o Ã© direcionado para a pagina de login.
 */
public class LoginFilter implements Filter {

    @Override
    public void destroy() { // TODO Auto-generated method stub 

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpSession sess = ((HttpServletRequest) request).getSession(false);
        Empreendedor user = null;

        if (sess != null) {
            user = (Empreendedor) sess.getAttribute("empreendedor");
        }

        if (user == null) {
            String contextPath = ((HttpServletRequest) request).getContextPath();
            ((HttpServletResponse) response).sendRedirect(contextPath + "/loginEmpreendedor.jsf");
            
        } else {
            try{
                chain.doFilter(request, response);
            }catch (NullPointerException e){
                System.out.println("Origem: "+this.getClass().getName()+ ":: \t chain = null");
            }
        }
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException { // TODO Auto-generated method stub 

    }

}
