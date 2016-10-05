/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.controller;

import com.ideiah.gerenciadorpampatec.model.Empreendedor;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class VerificarEmailFilter implements Filter {

    private static final boolean debug = true;
    private FilterConfig filterConfig = null;

    public VerificarEmailFilter() {

    }

    private void doBeforeProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {

    }

    private void doAfterProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {

    }

    @Override
    public void init(FilterConfig fc) throws ServletException {

        this.filterConfig = filterConfig;
        if (filterConfig != null) {
            if (debug) {
                log("VerificarEmailFilter:Initializing filter");
            }
        }

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        Empreendedor emp, emp2;
        HttpSession session = ((HttpServletRequest) request).getSession();
        String id = request.getParameter("id");
        emp = Empreendedor.buscaEmpreendedorID(id);
        emp2 = (Empreendedor) session.getAttribute("empreendedorIncompleto");
        if (emp != null) {
            if (emp.getIdUnico().equals(id)) {
                session.removeAttribute("empreendedorIncompleto");
                session.setAttribute("empreendedorIncompleto", emp);

                emp.setIdUnico(null);

                emp.atualizarEmpreendedor(emp);

                request.getRequestDispatcher("/verificarEmail.jsf").forward(request, response);
            }
        } else if ((emp2 != null)) {
            if (emp2.getIdUnico().equals(id)) {
                 emp2.setIdUnico(null);
            
                emp2.atualizarEmpreendedor(emp2);
                
                request.getRequestDispatcher("/verificarEmail.jsf").forward(request, response);
            } else {
                request.getRequestDispatcher("/loginEmpreendedor.jsf").forward(request, response);
            }
        } else {
            request.getRequestDispatcher("/loginEmpreendedor.jsf").forward(request, response);
        }

    }

    @Override
    public void destroy() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Return a String representation of this object.
     */
    @Override
    public String toString() {
        if (filterConfig == null) {
            return ("VerificarEmailFilter()");
        }
        StringBuffer sb = new StringBuffer("VerificarEmailFilter(");
        sb.append(filterConfig);
        sb.append(")");
        return (sb.toString());
    }

    private void sendProcessingError(Throwable t, ServletResponse response) {
        String stackTrace = getStackTrace(t);

        if (stackTrace != null && !stackTrace.equals("")) {
            try {
                response.setContentType("text/html");
                PrintStream ps = new PrintStream(response.getOutputStream());
                PrintWriter pw = new PrintWriter(ps);
                pw.print("<html>\n<head>\n<title>Error</title>\n</head>\n<body>\n"); //NOI18N

                // PENDING! Localize this for next official release
                pw.print("<h1>The resource did not process correctly</h1>\n<pre>\n");
                pw.print(stackTrace);
                pw.print("</pre></body>\n</html>"); //NOI18N
                pw.close();
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        } else {
            try {
                PrintStream ps = new PrintStream(response.getOutputStream());
                t.printStackTrace(ps);
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        }
    }

    public static String getStackTrace(Throwable t) {
        String stackTrace = null;
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            t.printStackTrace(pw);
            pw.close();
            sw.close();
            stackTrace = sw.getBuffer().toString();
        } catch (Exception ex) {
        }
        return stackTrace;
    }

    public void log(String msg) {
        filterConfig.getServletContext().log(msg);
    }

}
