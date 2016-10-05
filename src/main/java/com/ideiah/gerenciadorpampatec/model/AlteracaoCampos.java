/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author unipampa
 */
public class AlteracaoCampos implements Serializable{
    
    private Integer idalteracao_dos_campos;
    private Empreendedor empreendedor;
    private String texto;
    private Date data_alteracao;
    private Integer tipo;
    
   
    
    
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

    public AlteracaoCampos() {
        Date data = new Date(System.currentTimeMillis());
        this.texto = "";
        this.setData_alteracao(data);
    }
    
    
    /**
     * <p>
     * Retorna a data de alteração no formato "HH:mm:ss em dd/MM/yyy" 
     * </p>
     * @return stringDataAlteracao
     */
    public String getDataAlteracaoFormatada(){
        String stringDataAlteracao, Data, Hora;
        Date dataDiaMesAno, dataHoraMinSeg;
        
        SimpleDateFormat diaMesAno = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat horaMinSeg = new SimpleDateFormat("HH:mm:ss");
        
        
        if(this.getData_alteracao() != null){
       
            dataHoraMinSeg = this.getData_alteracao();
            dataDiaMesAno = this.getData_alteracao();

            Hora = horaMinSeg.format(dataHoraMinSeg);
            Data = diaMesAno.format(dataDiaMesAno);

            stringDataAlteracao = (Hora + " em " + Data);

            return stringDataAlteracao;
        }
        else{
            return "";
        }
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getData_alteracao() {
        return data_alteracao;
    }

    public void setData_alteracao(Date data_alteracao) {
        this.data_alteracao = data_alteracao;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public Integer getIdalteracao_dos_campos() {
        return idalteracao_dos_campos;
    }

    public void setIdalteracao_dos_campos(Integer idalteracao_dos_campos) {
        this.idalteracao_dos_campos = idalteracao_dos_campos;
    }

    public Empreendedor getEmpreendedor() {
        return empreendedor;
    }

    public void setEmpreendedor(Empreendedor empreendedor) {
        this.empreendedor = empreendedor;
    }
    
    
    
    
    
    
}

