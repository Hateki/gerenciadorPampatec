/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.model;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Pedro
 */
public class Textocomentario implements java.io.Serializable {

    private Integer idtextocomentario;
    private GerenteRelacionamento gerenteRelacionamento;
    private String texto;
    private Date dataAlteracao;
    private Date dataSubmissao;
    private Integer tipo;
    private Set comentarioprojetos = new HashSet(0);
    public static final int SEGMENTO_CLIENTE = 1;
    public static final int PROPOSTA_VALOR = 2;
    public static final int ATIVIDADES_CHAVE = 3;
    public static final int RELACOES_CLIENTE = 4;
    public static final int PARCERIAS_CHAVE = 5;
    public static final int CANAIS = 6;
    public static final int RECURSOS_PRINCIPAIS = 7;
    public static final int CONCORRENTES = 8;
    public static final int ESTAGIO_EVOLUCAO = 9;
    public static final int TECNOLOGIA_PROCESSOS = 10;
    public static final int POTENCIAL_INOVACAO_TECNOLOGICA = 11;
    public static final int APLICACOES = 12;
    public static final int DIFICULDADES_ESPERADAS = 13;
    public static final int INTERACAO_EMPRESA_UNIVERSIDADE = 14;
    public static final int INTERACAO_EMPRESA_COMUNIDADE_GOVERNO = 15;
    public static final int INFRAESTRUTURA = 16;
    public static final int PARTICIPACAO_ACIONARIA = 17;
    public static final int POTENCIAL_EMPREGO = 18;
    public static final int FONTES_RECEITA = 19;
    public static final int ESTRUTURA_CUSTO = 20;
    public static final int INVESTIMENTO_INICIAL = 21;
    public static final int CUSTOS_FIXOS = 22;
    public static final int CUSTOS_VARIAVEIS = 23;

    public Textocomentario() {
        this.texto = "";
    }

    public Textocomentario(int idtextocomentario, GerenteRelacionamento gerenteRelacionamento) {
        this.texto = "";
        this.idtextocomentario = idtextocomentario;
        this.gerenteRelacionamento = gerenteRelacionamento;
    }

    public Textocomentario(int idtextocomentario, GerenteRelacionamento gerenteRelacionamento, String texto, Date dataAlteracao, Date dataSubmissao, Integer tipo, Set comentarioprojetos) {
        this.idtextocomentario = idtextocomentario;
        this.gerenteRelacionamento = gerenteRelacionamento;
        this.texto = texto;
        this.dataAlteracao = dataAlteracao;
        this.dataSubmissao = dataSubmissao;
        this.tipo = tipo;
        this.comentarioprojetos = comentarioprojetos;
    }
    
    /**
     * <p>
     * Retorna a data de alteração no formato dd/MM/yyy às HH:mm:ss
     * </p>
     * @return stringDataAlteracao
     */
    public String getDataAlteracaoFormatada(){
        String stringDataAlteracao, Data, Hora;
        Date dataDiaMesAno, dataHoraMinSeg;
        
        SimpleDateFormat diaMesAno = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat horaMinSeg = new SimpleDateFormat("HH:mm:ss");
        
        
        if(this.getDataAlteracao() != null){
       
            dataHoraMinSeg = this.getDataAlteracao();
            dataDiaMesAno = this.getDataAlteracao();

            Hora = horaMinSeg.format(dataHoraMinSeg);
            Data = diaMesAno.format(dataDiaMesAno);

            stringDataAlteracao = (Hora + " em " + Data);

            return stringDataAlteracao;
        }
        else{
            return "";
        }
    }

    public Integer getIdtextocomentario() {
        return this.idtextocomentario;
    }

    public void setIdtextocomentario(Integer idtextocomentario) {
        this.idtextocomentario = idtextocomentario;
    }

    public GerenteRelacionamento getGerenteRelacionamento() {
        return this.gerenteRelacionamento;
    }

    public void setGerenteRelacionamento(GerenteRelacionamento gerenteRelacionamento) {
        this.gerenteRelacionamento = gerenteRelacionamento;
    }

    public String getTexto() {
        return this.texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getDataAlteracao() {
        return this.dataAlteracao;
    }

    public void setDataAlteracao(Date dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public Date getDataSubmissao() {
        return this.dataSubmissao;
    }

    public void setDataSubmissao(Date dataSubmissao) {
        this.dataSubmissao = dataSubmissao;
    }

    public Integer getTipo() {
        return this.tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public Set getComentarioprojetos() {
        return this.comentarioprojetos;
    }

    public void setComentarioprojetos(Set comentarioprojetos) {
        this.comentarioprojetos = comentarioprojetos;
    }
}
