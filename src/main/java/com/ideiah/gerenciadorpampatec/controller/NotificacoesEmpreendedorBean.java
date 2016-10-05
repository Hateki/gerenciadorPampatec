/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.controller;

import com.ideiah.gerenciadorpampatec.model.Empreendedor;
import com.ideiah.gerenciadorpampatec.model.Notificacao;
import com.ideiah.gerenciadorpampatec.model.Projeto;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.PartialViewContext;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Pedro
 */
@ManagedBean
@SessionScoped
public class NotificacoesEmpreendedorBean implements Observer, Serializable {

    private FacesContext fc = FacesContext.getCurrentInstance();
    private HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);

    private int quantidadeNotificacoes;
    private ArrayList<String> descricoesNotificacoes;
    private static final ArrayList<HttpSession> SESSOES = new ArrayList<>();

    /**
     * Creates a new instance of NotificacoesBean
     */
    public NotificacoesEmpreendedorBean() {
        SESSOES.add(session);
    }

    public void mudaStatusNotificacao() {
        Empreendedor empreendedorSessao = (Empreendedor) session.getAttribute("empreendedor");
        for (Notificacao notificacao : empreendedorSessao.getNotificacoes()) {
            notificacao.setVisualizado(true);
            empreendedorSessao.atualizarEmpreendedor(empreendedorSessao);
        }
    }

    /**
     * Realiza o update das notificações quando o status do projeto mudar.
     *
     * @param o
     * @param arg O objeto que foi mudado.
     */
    @Override
    public void update(Observable o, Object arg) {
        //Atualiza a quantidade de notificações
        Projeto projeto = (Projeto) arg;
        Empreendedor empreendedor;
        Notificacao notificacao;
        for (Object obj : projeto.getEmpreendedores()) {
            empreendedor = (Empreendedor) obj;
            notificacao = criaNotificacao("O status do negocio mudou para " + projeto.getStatusString(projeto.getStatus())
                    + "", empreendedor);
            empreendedor.getNotificacoes().add(notificacao);
            empreendedor.atualizarEmpreendedor(empreendedor);
            quantidadeNotificacoes++;
            atualizaEmpreendedores(empreendedor);
        }
    }

    public void atualizaEmpreendedores(Empreendedor empreendedor) {
        for (HttpSession sessao : SESSOES) {
            atualizaEmpreendedorSessao(empreendedor, sessao);
        }
    }

    /**
     * Atualiza o empreendedor que está na sessão
     *
     * @param empreendedor novo empreendedor para colocar na sessão.
     */
    private void atualizaEmpreendedorSessao(Empreendedor empreendedor, HttpSession sessao) {
        Empreendedor empreendedorSessao = (Empreendedor) sessao.getAttribute("empreendedor");
        if (Objects.equals(empreendedor.getIdUsuario(), empreendedorSessao.getIdUsuario())) {
            sessao.setAttribute("empreendedor", empreendedor);
        }
    }

    private Notificacao criaNotificacao(String descricao, Empreendedor empreendedor) {
        Notificacao notificacao = new Notificacao();
        notificacao.setDescricao(descricao);
        notificacao.setEmpreendedor(empreendedor);
        notificacao.setVisualizado(false);
       // notificacao.setLink("http://localhost:8084/GerenciadorPampatec/faces/view/empreendedor/paginaBuscaPlanoDeNegocio.jsf");
        notificacao.setLink(getNotificacaoLink());
        return notificacao;
    }

    /**
     * @return the quantidadeNotificacoes
     */
    public int getQuantidadeNotificacoes() {
        Empreendedor empreendedor = (Empreendedor) session.getAttribute("empreendedor");
        quantidadeNotificacoes = empreendedor.getQuantidadeDeNotificacoes();
        return quantidadeNotificacoes;
    }

    /**
     * @param quantidadeNotificacoes the quantidadeNotificacoes to set
     */
    public void setQuantidadeNotificacoes(int quantidadeNotificacoes) {
        this.quantidadeNotificacoes = quantidadeNotificacoes;
    }

    /**
     * @return the descricoesNotificacoes
     */
    public ArrayList<String> getDescricoesNotificacoes() {
        Empreendedor empreendedor = (Empreendedor) session.getAttribute("empreendedor");
        descricoesNotificacoes = empreendedor.getDescricaoDasNotificacoes();
        return descricoesNotificacoes;
    }

    public ArrayList<Notificacao> getNotificacoes() {
        Empreendedor empreendedor = (Empreendedor) session.getAttribute("empreendedor");
        ArrayList<Notificacao> listaNotificacoes = new ArrayList<>();
        for (Notificacao notificacao : empreendedor.getNotificacoes()) {
            listaNotificacoes.add(notificacao);
        }
        return listaNotificacoes;
    }

    /**
     * @param descricoesNotificacoes the descricoesNotificacoes to set
     */
    public void setDescricoesNotificacoes(ArrayList<String> descricoesNotificacoes) {
        this.descricoesNotificacoes = descricoesNotificacoes;
    }

    public String getNotificacaoLink() {

        // FacesContext.getCurrentInstance().getExternalContext().redirect("view/empreendedor/paginaBuscaPlanoDeNegocio.jsf");
        String link = FacesContext.getCurrentInstance().getExternalContext().getApplicationContextPath() + "/view/empreendedor/paginaBuscaPlanoDeNegocio.jsf";
        return link;

    }

}
