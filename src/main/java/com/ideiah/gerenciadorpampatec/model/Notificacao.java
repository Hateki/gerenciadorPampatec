/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.model;

/**
 *
 * @author Edison Moura
 */
public class Notificacao implements java.io.Serializable {

    private int idNotificacao;
    private String descricao;
    private Empreendedor empreendedor;
    private boolean visualizado;
    private String link;
    
    public Notificacao () {
        
    }
    
    /**
     * 
     * @param idNotificao
     * @param empreendedor 
     */
    public Notificacao (int idNotificao, Empreendedor empreendedor) {
        this.idNotificacao = idNotificao;
        this.empreendedor = empreendedor;
    }
    
    /**
     * 
     * @param idNotificacao
     * @param descricao
     * @param empreendedor 
     */
    public Notificacao (int idNotificacao, String descricao, Empreendedor empreendedor) {
        this.idNotificacao = idNotificacao;
        this.descricao = descricao;
        this.empreendedor = empreendedor;
    }
    

    /**
     * @return the idNotificacao
     */
    public int getIdNotificacao() {
        return idNotificacao;
    }

    /**
     * @param idNotificacao the idNotificacao to set
     */
    public void setIdNotificacao(int idNotificacao) {
        this.idNotificacao = idNotificacao;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the idEmpreendedor
     */
    public Empreendedor getEmpreendedor() {
        return empreendedor;
    }

    /**
     * @param empreendedor the idEmpreendedor to set
     */
    public void setEmpreendedor(Empreendedor empreendedor) {
        this.empreendedor = empreendedor;
    }

    /**
     * @return the visualizado
     */
    public boolean isVisualizado() {
        return visualizado;
    }

    /**
     * @param visualizado the visualizado to set
     */
    public void setVisualizado(boolean visualizado) {
        this.visualizado = visualizado;
    }

    /**
     * @return the link
     */
    public String getLink() {
        return link;
    }

    /**
     * @param link the link to set
     */
    public void setLink(String link) {
        this.link = link;
    }
    
    

}
