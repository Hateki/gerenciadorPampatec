package com.ideiah.gerenciadorpampatec.model;
// Generated 31/08/2015 13:49:28 by Hibernate Tools 4.3.1

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Edison Jhonatan
 * @since 10/11/15
 */
public class Planofinanceiro implements java.io.Serializable {

    private int idPlanoFinanceiro;
    private String fontesReceita;
    private String estruturaCusto;
    private String investimentoInicial;
    private Set projetos = new HashSet(0);
    private Set<Custo> custo = new HashSet<>(0);
    private Integer valorTotalFixo;
    private Integer valorTotalVariavel;

    public Planofinanceiro() {
    }

    public Planofinanceiro(int idPlanoFinanceiro, String fontesReceita, String estruturaCusto) {
        this.idPlanoFinanceiro = idPlanoFinanceiro;
        this.fontesReceita = fontesReceita;
        this.estruturaCusto = estruturaCusto;
    }

    public Planofinanceiro(int idPlanoFinanceiro, String fontesReceita, String estruturaCusto, String investimentoInicial) {
        this.idPlanoFinanceiro = idPlanoFinanceiro;
        this.fontesReceita = fontesReceita;
        this.estruturaCusto = estruturaCusto;
        this.investimentoInicial = investimentoInicial;
    }

    /**
     * <p>
     * Método preenche uma lista de custos fixos de um projeto na sessão para
     * ser mostrada na pré-avaliação.</p>
     *
     * @return listaDeCustosFixos
     */
    public ArrayList<Custo> retornaListaCustosFixos() {

        ArrayList<Custo> listaDeCustosFixos = new ArrayList<Custo>();

        for (Custo objCusto : custo) {
            if (objCusto.getTipo() == Custo.CUSTO_FIXO) {
                listaDeCustosFixos.add(objCusto);
            }
        }
        return listaDeCustosFixos;
    }

    /**
     * <p>
     * Método preenche uma lista de custos variáveis de um projeto na sessão
     * para ser mostrada na pré-avaliação.</p>
     *
     * @return listaDeCustosVariaveis
     */
    public ArrayList<Custo> retornaListaCustosVariaveis() {

        ArrayList<Custo> listaDeCustosVariaveis = new ArrayList<Custo>();

        for (Custo objCusto : custo) {
            if (objCusto.getTipo() == Custo.CUSTO_VARIAVEL) {
                listaDeCustosVariaveis.add(objCusto);
            }
        }
        return listaDeCustosVariaveis;
    }

    public int getIdPlanoFinanceiro() {
        return this.idPlanoFinanceiro;
    }

    public void setIdPlanoFinanceiro(int idPlanoFinanceiro) {
        this.idPlanoFinanceiro = idPlanoFinanceiro;
    }

    public String getFontesReceita() {
        return this.fontesReceita;
    }

    public void setFontesReceita(String fontesReceita) {
        this.fontesReceita = fontesReceita;
    }

    public String getEstruturaCusto() {
        return this.estruturaCusto;
    }

    public void setEstruturaCusto(String estruturaCusto) {
        this.estruturaCusto = estruturaCusto;
    }

    public String getInvestimentoInicial() {
        return this.investimentoInicial;
    }

    public void setInvestimentoInicial(String investimentoInicial) {
        this.investimentoInicial = investimentoInicial;
    }

    public Set getProjetos() {
        return this.projetos;
    }

    public void setProjetos(Set projetos) {
        this.projetos = projetos;
    }

    /**
     * @return the custo
     */
    public Set<Custo> getCusto() {
        return custo;
    }

    /**
     * @param custo the custo to set
     */
    public void setCusto(Set<Custo> custo) {
        this.custo = custo;
    }

    public Integer getValorTotalFixo() {
        return valorTotalFixo;
    }

    public void setValorTotalFixo(Integer valorTotalFixo) {
        this.valorTotalFixo = valorTotalFixo;
    }

    public Integer getValorTotalVariavel() {
        return valorTotalVariavel;
    }

    public void setValorTotalVariavel(Integer valorTotalVariavel) {
        this.valorTotalVariavel = valorTotalVariavel;
    }
}
