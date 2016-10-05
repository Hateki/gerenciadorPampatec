/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author Ideiah
 * @since 10/11/15
 */
public class ComentarioProjeto implements java.io.Serializable {

    public static final int EM_ANDAMENTO = 1;
    public static final int FINALIZADO = 2;
    public static final int HISTORICO = 3;

    private Integer idcomentario;
    private String nome;
    private String participacaoacionaria;
    private String potencialemprego;
    private String consideracoes;
    private Projeto projeto;
    private Integer status;
    private String consideracoesPersonalizadas;
    private Set<Textocomentario> textocomentarios = new HashSet();
    private Textocomentario segmentosClientes;
    private Textocomentario propostaValor;
    private Textocomentario atividadeChave;
    private Textocomentario relacionamentoCliente;
    private Textocomentario parceriasChave;
    private Textocomentario canais;
    private Textocomentario recursosPrincipais;
    private Textocomentario concorrentes;
    private Textocomentario estagioEvolucao;
    private Textocomentario tecnologiaProcessos;
    private Textocomentario potencialInovacaoTecnologica;
    private Textocomentario aplicacoes;
    private Textocomentario dificuldadesEsperadas;
    private Textocomentario interacaoEmpresaUniversidade;
    private Textocomentario interacaoEmpresaComunidadeGoverno;
    private Textocomentario infraestrutura;
    private Textocomentario participacaoAcionaria;
    private Textocomentario potencialEmprego;
    private Textocomentario fontesReceita;
    private Textocomentario estruturaCusto;
    private Textocomentario investimentoInicial;
    private Textocomentario custoFixo;
    private Textocomentario custoVariavel;

    private Set<AlteracaoCampos> alteracaocampos = new HashSet();
    private AlteracaoCampos segmentosClientes_alteracao;
    private AlteracaoCampos propostaValor_alteracao;
    private AlteracaoCampos atividadeChave_alteracao;
    private AlteracaoCampos relacionamentoCliente_alteracao;
    private AlteracaoCampos parceriasChave_alteracao;
    private AlteracaoCampos canais_alteracao;
    private AlteracaoCampos recursosPrincipais_alteracao;
    private AlteracaoCampos concorrentes_alteracao;
    private AlteracaoCampos estagioEvolucao_alteracao;
    private AlteracaoCampos tecnologiaProcessos_alteracao;
    private AlteracaoCampos potencialInovacaoTecnologica_alteracao;
    private AlteracaoCampos aplicacoes_alteracao;
    private AlteracaoCampos dificuldadesEsperadas_alteracao;
    private AlteracaoCampos interacaoEmpresaUniversidade_alteracao;
    private AlteracaoCampos interacaoEmpresaComunidadeGoverno_alteracao;
    private AlteracaoCampos infraestrutura_alteracao;
    private AlteracaoCampos participacaoAcionaria_alteracao;
    private AlteracaoCampos potencialEmprego_alteracao;
    private AlteracaoCampos fontesReceita_alteracao;
    private AlteracaoCampos estruturaCusto_alteracao;
    private AlteracaoCampos investimentoInicial_alteracao;
    private AlteracaoCampos custoFixo_alteracao;
    private AlteracaoCampos custoVariavel_alteracao;

    public ComentarioProjeto() {
        nome = "";
        participacaoacionaria = "";
        potencialemprego = "";
        consideracoes = "";
        consideracoesPersonalizadas = "";
        status = EM_ANDAMENTO;
        adicionaListaComentario();
        adicionaListaAlteracaoCampos();
    }

    public ComentarioProjeto(int idcomentario) {
        this.idcomentario = idcomentario;
        textocomentarios = new HashSet();
        alteracaocampos = new HashSet();
    }

    public ComentarioProjeto(int idcomentario, String nome, String participacaoacionaria, String potencialemprego, String consideracoes) {
        this.idcomentario = idcomentario;
        this.nome = nome;
        this.participacaoacionaria = participacaoacionaria;
        this.potencialemprego = potencialemprego;
        this.consideracoes = consideracoes;
        textocomentarios = new HashSet();
        alteracaocampos = new HashSet();
    }

    /**
     * <p>
     * Método que popula as variáveis dos comentários, que que essas possam ser
     * utilizadas na interface da aplicação. </p>
     */
    public void populandoVariaveisAlteracoesCampos() {

        segmentosClientes_alteracao = retornarAlteracaoCampos(AlteracaoCampos.SEGMENTO_CLIENTE);
        propostaValor_alteracao = retornarAlteracaoCampos(AlteracaoCampos.PROPOSTA_VALOR);
        atividadeChave_alteracao = retornarAlteracaoCampos(AlteracaoCampos.ATIVIDADES_CHAVE);
        relacionamentoCliente_alteracao = retornarAlteracaoCampos(AlteracaoCampos.RELACOES_CLIENTE);
        parceriasChave_alteracao = retornarAlteracaoCampos(AlteracaoCampos.PARCERIAS_CHAVE);
        canais_alteracao = retornarAlteracaoCampos(AlteracaoCampos.CANAIS);
        recursosPrincipais_alteracao = retornarAlteracaoCampos(AlteracaoCampos.RECURSOS_PRINCIPAIS);
        concorrentes_alteracao = retornarAlteracaoCampos(AlteracaoCampos.CONCORRENTES);
        estagioEvolucao_alteracao = retornarAlteracaoCampos(AlteracaoCampos.ESTAGIO_EVOLUCAO);
        tecnologiaProcessos_alteracao = retornarAlteracaoCampos(AlteracaoCampos.TECNOLOGIA_PROCESSOS);
        potencialInovacaoTecnologica_alteracao = retornarAlteracaoCampos(AlteracaoCampos.POTENCIAL_INOVACAO_TECNOLOGICA);
        aplicacoes_alteracao = retornarAlteracaoCampos(AlteracaoCampos.APLICACOES);
        dificuldadesEsperadas_alteracao = retornarAlteracaoCampos(AlteracaoCampos.DIFICULDADES_ESPERADAS);
        interacaoEmpresaUniversidade_alteracao = retornarAlteracaoCampos(AlteracaoCampos.INTERACAO_EMPRESA_UNIVERSIDADE);
        interacaoEmpresaComunidadeGoverno_alteracao = retornarAlteracaoCampos(AlteracaoCampos.INTERACAO_EMPRESA_COMUNIDADE_GOVERNO);
        infraestrutura_alteracao = retornarAlteracaoCampos(AlteracaoCampos.INFRAESTRUTURA);
        participacaoAcionaria_alteracao = retornarAlteracaoCampos(AlteracaoCampos.PARTICIPACAO_ACIONARIA);
        potencialEmprego_alteracao = retornarAlteracaoCampos(AlteracaoCampos.POTENCIAL_EMPREGO);
        fontesReceita_alteracao = retornarAlteracaoCampos(AlteracaoCampos.FONTES_RECEITA);
        estruturaCusto_alteracao = retornarAlteracaoCampos(AlteracaoCampos.ESTRUTURA_CUSTO);
        investimentoInicial_alteracao = retornarAlteracaoCampos(AlteracaoCampos.INVESTIMENTO_INICIAL);
        custoFixo_alteracao = retornarAlteracaoCampos(AlteracaoCampos.CUSTOS_FIXOS);
        custoVariavel_alteracao = retornarAlteracaoCampos(AlteracaoCampos.CUSTOS_VARIAVEIS);
    }

    /**
     * <p>
     * Método que popula as variáveis das alterações, que que essas possam ser
     * utilizadas na interface da aplicação. </p>
     */
    public void populandoVariaveisComentario() {
        
        segmentosClientes = retornarTextoComentario(Textocomentario.SEGMENTO_CLIENTE);
        propostaValor = retornarTextoComentario(Textocomentario.PROPOSTA_VALOR);
        atividadeChave = retornarTextoComentario(Textocomentario.ATIVIDADES_CHAVE);
        relacionamentoCliente = retornarTextoComentario(Textocomentario.RELACOES_CLIENTE);
        parceriasChave = retornarTextoComentario(Textocomentario.PARCERIAS_CHAVE);
        canais = retornarTextoComentario(Textocomentario.CANAIS);
        recursosPrincipais = retornarTextoComentario(Textocomentario.RECURSOS_PRINCIPAIS);
        concorrentes = retornarTextoComentario(Textocomentario.CONCORRENTES);
        estagioEvolucao = retornarTextoComentario(Textocomentario.ESTAGIO_EVOLUCAO);
        tecnologiaProcessos = retornarTextoComentario(Textocomentario.TECNOLOGIA_PROCESSOS);
        potencialInovacaoTecnologica = retornarTextoComentario(Textocomentario.POTENCIAL_INOVACAO_TECNOLOGICA);
        aplicacoes = retornarTextoComentario(Textocomentario.APLICACOES);
        dificuldadesEsperadas = retornarTextoComentario(Textocomentario.DIFICULDADES_ESPERADAS);
        interacaoEmpresaUniversidade = retornarTextoComentario(Textocomentario.INTERACAO_EMPRESA_UNIVERSIDADE);
        interacaoEmpresaComunidadeGoverno = retornarTextoComentario(Textocomentario.INTERACAO_EMPRESA_COMUNIDADE_GOVERNO);
        infraestrutura = retornarTextoComentario(Textocomentario.INFRAESTRUTURA);
        participacaoAcionaria = retornarTextoComentario(Textocomentario.PARTICIPACAO_ACIONARIA);
        potencialEmprego = retornarTextoComentario(Textocomentario.POTENCIAL_EMPREGO);
        fontesReceita = retornarTextoComentario(Textocomentario.FONTES_RECEITA);
        estruturaCusto = retornarTextoComentario(Textocomentario.ESTRUTURA_CUSTO);
        investimentoInicial = retornarTextoComentario(Textocomentario.INVESTIMENTO_INICIAL);
        custoFixo = retornarTextoComentario(Textocomentario.CUSTOS_FIXOS);
        custoVariavel = retornarTextoComentario(Textocomentario.CUSTOS_VARIAVEIS);
    }

    public String todasConsideracoes() {
        return consideracoes + "\n" + consideracoesPersonalizadas;
    }

    /**
     * <p>
     * Retorna a quantidade de campos comentário vazios
     * </p>
     *
     * @return
     */
    public int verificaCampos() {
        int FLAG = 0;

        //NEGOCIO
        if (!retornaTextoComentario(Textocomentario.SEGMENTO_CLIENTE).equals("")) {
            FLAG++;
        }

        if (!retornaTextoComentario(Textocomentario.PROPOSTA_VALOR).equals("")) {
            FLAG++;
        }

        if (!retornaTextoComentario(Textocomentario.ATIVIDADES_CHAVE).equals("")) {
            FLAG++;
        }
        //ANALISE DE MERCADO
        if (!retornaTextoComentario(Textocomentario.RELACOES_CLIENTE).equals("")) {
            FLAG++;
        }

        if (!retornaTextoComentario(Textocomentario.PARCERIAS_CHAVE).equals("")) {
            FLAG++;
        }

        if (!retornaTextoComentario(Textocomentario.CANAIS).equals("")) {
            FLAG++;
        }

        if (!retornaTextoComentario(Textocomentario.RECURSOS_PRINCIPAIS).equals("")) {
            FLAG++;
        }

        if (!retornaTextoComentario(Textocomentario.CONCORRENTES).equals("")) {
            FLAG++;
        }
        //PRODUTO OU SERVIÇO
        if (!retornaTextoComentario(Textocomentario.ESTAGIO_EVOLUCAO).equals("")) {
            FLAG++;
        }

        if (!retornaTextoComentario(Textocomentario.TECNOLOGIA_PROCESSOS).equals("")) {
            FLAG++;
        }

        if (!retornaTextoComentario(Textocomentario.POTENCIAL_INOVACAO_TECNOLOGICA).equals("")) {
            FLAG++;
        }

        if (!retornaTextoComentario(Textocomentario.APLICACOES).equals("")) {
            FLAG++;
        }

        if (!retornaTextoComentario(Textocomentario.DIFICULDADES_ESPERADAS).equals("")) {
            FLAG++;
        }

        if (!retornaTextoComentario(Textocomentario.INTERACAO_EMPRESA_UNIVERSIDADE).equals("")) {
            FLAG++;
        }

        if (!retornaTextoComentario(Textocomentario.INTERACAO_EMPRESA_COMUNIDADE_GOVERNO).equals("")) {
            FLAG++;
        }

        if (!retornaTextoComentario(Textocomentario.INFRAESTRUTURA).equals("")) {
            FLAG++;
        }
        //GESTAO DE PESSOAS
        if (!retornaTextoComentario(Textocomentario.PARTICIPACAO_ACIONARIA).equals("")) {
            FLAG++;
        }

        if (!retornaTextoComentario(Textocomentario.POTENCIAL_EMPREGO).equals("")) {
            FLAG++;
        }
        //PLANO FINANCEIRO
        if (!retornaTextoComentario(Textocomentario.FONTES_RECEITA).equals("")) {
            FLAG++;
        }

        if (!retornaTextoComentario(Textocomentario.ESTRUTURA_CUSTO).equals("")) {
            FLAG++;
        }

        if (!retornaTextoComentario(Textocomentario.INVESTIMENTO_INICIAL).equals("")) {
            FLAG++;
        }

        if (!retornaTextoComentario(Textocomentario.CUSTOS_FIXOS).equals("")) {
            FLAG++;
        }

        if (!retornaTextoComentario(Textocomentario.CUSTOS_VARIAVEIS).equals("")) {
            FLAG++;
        }
        return FLAG;
    }

    /**
     * Retorna o texto do comentário segundo seu tipo (segmento de cliente,
     * proposta de valor, etc..)
     *
     * @param tipo
     * @return textoCoentario
     */
    public String retornaTextoComentario(int tipo) {

        String textoComentario = null;

        for (Textocomentario objetoTextoComentario : textocomentarios) {
            if (objetoTextoComentario.getTipo() == tipo) {
                textoComentario = objetoTextoComentario.getTexto();
            }
        }
        return textoComentario;
    }

    /**
     * Retorna o objeto texto comentário
     *
     * @param tipo tipo para se retornar
     * @return objeto encontrado
     */
    public Textocomentario retornarTextoComentario(int tipo) {
        for (Textocomentario objetoTextoComentario : textocomentarios) {
            if (objetoTextoComentario.getTipo() == tipo) {
                return objetoTextoComentario;
            }
        }
        return null;
    }

    /**
     * Retorna o objeto alteracao campos
     *
     * @param tipo tipo para se retornar
     * @return objeto encontrado
     */
    public AlteracaoCampos retornarAlteracaoCampos(int tipo) {
        for (AlteracaoCampos objetoAlteracaoCampos : alteracaocampos) {
            if (objetoAlteracaoCampos.getTipo() == tipo) {
                return objetoAlteracaoCampos;
            }
        }
        return null;
    }

    /**
     * Cria um texto de comentário.
     *
     * @param tipo tipo do comentário a ser criado
     * @return comentário criado
     */
    private Textocomentario criaTextoComentario(int tipo) {

        Textocomentario textoComentario = new Textocomentario();
        textoComentario.setTipo(tipo);
        textoComentario.setTexto("");

        return textoComentario;
    }

    /**
     * Cria uma alteração de campos do empreendedor
     *
     * @param tipo tipo do comentário a ser criado
     * @return comentário criado
     */
    private AlteracaoCampos criaAlteracaoCampos(int tipo) {

        AlteracaoCampos alteracao = new AlteracaoCampos();
        alteracao.setTipo(tipo);
        alteracao.setTexto("");
        return alteracao;
    }
    
    /**
     * Faz a inicialização dos campos de comentários.
     */
    private void adicionaListaComentario() {
        
        textocomentarios.add(criaTextoComentario(Textocomentario.SEGMENTO_CLIENTE));
        textocomentarios.add(criaTextoComentario(Textocomentario.PROPOSTA_VALOR));
        textocomentarios.add(criaTextoComentario(Textocomentario.ATIVIDADES_CHAVE));
        textocomentarios.add(criaTextoComentario(Textocomentario.RELACOES_CLIENTE));
        textocomentarios.add(criaTextoComentario(Textocomentario.PARCERIAS_CHAVE));
        textocomentarios.add(criaTextoComentario(Textocomentario.CANAIS));
        textocomentarios.add(criaTextoComentario(Textocomentario.RECURSOS_PRINCIPAIS));
        textocomentarios.add(criaTextoComentario(Textocomentario.CONCORRENTES));
        textocomentarios.add(criaTextoComentario(Textocomentario.ESTAGIO_EVOLUCAO));
        textocomentarios.add(criaTextoComentario(Textocomentario.TECNOLOGIA_PROCESSOS));
        textocomentarios.add(criaTextoComentario(Textocomentario.POTENCIAL_INOVACAO_TECNOLOGICA));
        textocomentarios.add(criaTextoComentario(Textocomentario.APLICACOES));
        textocomentarios.add(criaTextoComentario(Textocomentario.DIFICULDADES_ESPERADAS));
        textocomentarios.add(criaTextoComentario(Textocomentario.INTERACAO_EMPRESA_UNIVERSIDADE));
        textocomentarios.add(criaTextoComentario(Textocomentario.INTERACAO_EMPRESA_COMUNIDADE_GOVERNO));
        textocomentarios.add(criaTextoComentario(Textocomentario.INFRAESTRUTURA));
        textocomentarios.add(criaTextoComentario(Textocomentario.PARTICIPACAO_ACIONARIA));
        textocomentarios.add(criaTextoComentario(Textocomentario.POTENCIAL_EMPREGO));
        textocomentarios.add(criaTextoComentario(Textocomentario.FONTES_RECEITA));
        textocomentarios.add(criaTextoComentario(Textocomentario.ESTRUTURA_CUSTO));
        textocomentarios.add(criaTextoComentario(Textocomentario.INVESTIMENTO_INICIAL));
        textocomentarios.add(criaTextoComentario(Textocomentario.CUSTOS_FIXOS));
        textocomentarios.add(criaTextoComentario(Textocomentario.CUSTOS_VARIAVEIS));

    }
    
     /**
     * Faz a inicialização dos campos de comentários.
     */
    private void adicionaListaAlteracaoCampos() {
        
        alteracaocampos.add(criaAlteracaoCampos(AlteracaoCampos.SEGMENTO_CLIENTE));
        alteracaocampos.add(criaAlteracaoCampos(AlteracaoCampos.PROPOSTA_VALOR));
        alteracaocampos.add(criaAlteracaoCampos(AlteracaoCampos.ATIVIDADES_CHAVE));
        alteracaocampos.add(criaAlteracaoCampos(AlteracaoCampos.RELACOES_CLIENTE));
        alteracaocampos.add(criaAlteracaoCampos(AlteracaoCampos.PARCERIAS_CHAVE));
        alteracaocampos.add(criaAlteracaoCampos(AlteracaoCampos.CANAIS));
        alteracaocampos.add(criaAlteracaoCampos(AlteracaoCampos.RECURSOS_PRINCIPAIS));
        alteracaocampos.add(criaAlteracaoCampos(AlteracaoCampos.CONCORRENTES));
        alteracaocampos.add(criaAlteracaoCampos(AlteracaoCampos.ESTAGIO_EVOLUCAO));
        alteracaocampos.add(criaAlteracaoCampos(AlteracaoCampos.TECNOLOGIA_PROCESSOS));
        alteracaocampos.add(criaAlteracaoCampos(AlteracaoCampos.POTENCIAL_INOVACAO_TECNOLOGICA));
        alteracaocampos.add(criaAlteracaoCampos(AlteracaoCampos.APLICACOES));
        alteracaocampos.add(criaAlteracaoCampos(AlteracaoCampos.DIFICULDADES_ESPERADAS));
        alteracaocampos.add(criaAlteracaoCampos(AlteracaoCampos.INTERACAO_EMPRESA_UNIVERSIDADE));
        alteracaocampos.add(criaAlteracaoCampos(AlteracaoCampos.INTERACAO_EMPRESA_COMUNIDADE_GOVERNO));
        alteracaocampos.add(criaAlteracaoCampos(AlteracaoCampos.INFRAESTRUTURA));
        alteracaocampos.add(criaAlteracaoCampos(AlteracaoCampos.PARTICIPACAO_ACIONARIA));
        alteracaocampos.add(criaAlteracaoCampos(AlteracaoCampos.POTENCIAL_EMPREGO));
        alteracaocampos.add(criaAlteracaoCampos(AlteracaoCampos.FONTES_RECEITA));
        alteracaocampos.add(criaAlteracaoCampos(AlteracaoCampos.ESTRUTURA_CUSTO));
        alteracaocampos.add(criaAlteracaoCampos(AlteracaoCampos.INVESTIMENTO_INICIAL));
        alteracaocampos.add(criaAlteracaoCampos(AlteracaoCampos.CUSTOS_FIXOS));
        alteracaocampos.add(criaAlteracaoCampos(AlteracaoCampos.CUSTOS_VARIAVEIS));

    }

    /**
     * Atualiza todos os campos da lista de textoComentários com o valor de seus
     * campos de texto comentário.
     *
     * @param gerente
     */
    public void atualizaTodosOsTextoComentario(GerenteRelacionamento gerente) {
        atualizarTextoComentario(gerente, segmentosClientes);
        atualizarTextoComentario(gerente, propostaValor);
        atualizarTextoComentario(gerente, atividadeChave);
        atualizarTextoComentario(gerente, relacionamentoCliente);
        atualizarTextoComentario(gerente, parceriasChave);
        atualizarTextoComentario(gerente, canais);
        atualizarTextoComentario(gerente, recursosPrincipais);
        atualizarTextoComentario(gerente, concorrentes);
        atualizarTextoComentario(gerente, estagioEvolucao);
        atualizarTextoComentario(gerente, tecnologiaProcessos);
        atualizarTextoComentario(gerente, potencialInovacaoTecnologica);
        atualizarTextoComentario(gerente, aplicacoes);
        atualizarTextoComentario(gerente, dificuldadesEsperadas);
        atualizarTextoComentario(gerente, interacaoEmpresaUniversidade);
        atualizarTextoComentario(gerente, interacaoEmpresaComunidadeGoverno);
        atualizarTextoComentario(gerente, infraestrutura);
        atualizarTextoComentario(gerente, participacaoAcionaria);
        atualizarTextoComentario(gerente, potencialEmprego);
        atualizarTextoComentario(gerente, fontesReceita);
        atualizarTextoComentario(gerente, estruturaCusto);
        atualizarTextoComentario(gerente, investimentoInicial);
        atualizarTextoComentario(gerente, custoFixo);
        atualizarTextoComentario(gerente, custoVariavel);
    }

    /**
     * Procura um texto comentário em uma lista e atualiza ele com o texto
     * comentário fornecido.
     *
     * @param gerente
     * @param textocomentario
     */
    public void atualizarTextoComentario(GerenteRelacionamento gerente, Textocomentario textocomentario) {
        
        for (Textocomentario textocomentarioLaco : textocomentarios) {
            if (Objects.equals(textocomentario.getTipo(), textocomentarioLaco.getTipo())) {
                Date data = new Date(System.currentTimeMillis());

                textocomentarioLaco.setTexto(textocomentario.getTexto());
                textocomentarioLaco.setDataSubmissao(textocomentario.getDataSubmissao());
                textocomentarioLaco.setDataAlteracao(data);
                textocomentarioLaco.setGerenteRelacionamento(gerente);
                break;
            }
        }
    }
    
    
    /**
     * Procura um texto comentário em uma lista e atualiza ele com o texto
     * comentário fornecido.
     *
     * @param alteracao
     * @param texto
     * @param empreendedor
     */
    public void atualizarTextoAlteracao(AlteracaoCampos alteracao, String texto, Empreendedor empreendedor) {
        
        if (alteracao != null) {
            
            for (AlteracaoCampos alteracaoLaco : alteracaocampos) {
                if (Objects.equals(alteracao.getTipo(), alteracaoLaco.getTipo())) {
                    
                    Date data = new Date(System.currentTimeMillis());

                    alteracaoLaco.setTexto(texto);
                    alteracaoLaco.setData_alteracao(data);
                    alteracaoLaco.setEmpreendedor(empreendedor);

                    break;
                }
            }
        }
    }
    
    /**
     * Muda o texto de uma alteracaoCampo dependendo do tipo.
     *
     
     * @param texto texto para se colocar.
     */
    public void setTextoComentario(int tipo, String texto) {
        for (Textocomentario textocomentario : textocomentarios) {
            if (textocomentario.getTipo() == tipo) {
                textocomentario.setTexto(texto);
            }
        }
    }

    /**
     * Muda o gerente de um TextoComentário dependendo do tipo.
     *
     * @param tipo tipo do comentário
     * @param gerenteRelacionamento gerente para se adicionar
     */
    public void setTextoComentario(int tipo, GerenteRelacionamento gerenteRelacionamento) {
        for (Textocomentario textocomentario : textocomentarios) {
            if (textocomentario.getTipo() == tipo) {
                textocomentario.setGerenteRelacionamento(gerenteRelacionamento);
            }
        }
    }

    /**
     * Muda a data de alteração de um TextoComentário dependendo do tipo.
     *
     * @param tipo tipo do comentário
     * @param dataAlteracao
     */
    public void setTextoComentarioDataAlteracao(int tipo, Date dataAlteracao) {
        for (Textocomentario textocomentario : textocomentarios) {
            if (textocomentario.getTipo() == tipo) {
                textocomentario.setDataAlteracao(dataAlteracao);
            }
        }
    }

    /**
     * Muda a data de alteração de um TextoComentário dependendo do tipo.
     *
     * @param tipo tipo do comentário
     * @param dataSubmissao
     */
    public void setTextoComentarioDataSubmissao(int tipo, Date dataSubmissao) {
        for (Textocomentario textocomentario : textocomentarios) {
            if (textocomentario.getTipo() == tipo) {
                textocomentario.setDataSubmissao(dataSubmissao);
            }
        }
    }

    public Integer getIdcomentario() {
        return this.idcomentario;
    }

    public void setIdcomentario(Integer idcomentario) {
        this.idcomentario = idcomentario;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getParticipacaoacionaria() {
        return this.participacaoacionaria;
    }

    public void setParticipacaoacionaria(String participacaoacionaria) {
        this.participacaoacionaria = participacaoacionaria;
    }

    public String getPotencialemprego() {
        return this.potencialemprego;
    }

    public void setPotencialemprego(String potencialemprego) {
        this.potencialemprego = potencialemprego;
    }

    public String getConsideracoes() {
        return this.consideracoes;
    }

    public void setConsideracoes(String consideracoes) {
        this.consideracoes = consideracoes;
    }

    /**
     * @return the projeto
     */
    public Projeto getProjeto() {
        return projeto;
    }

    /**
     * @param projeto the projeto to set
     */
    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusString(int status) {
        String statusDescricao = "";
        switch (status) {
            case EM_ANDAMENTO:
                statusDescricao = "Em andamento";
                break;
            case FINALIZADO:
                statusDescricao = "Finalizado";
                break;
        }
        return statusDescricao;
    }

    /**
     * @return the consideracoesPersonalizadas
     */
    public String getConsideracoesPersonalizadas() {
        return consideracoesPersonalizadas;
    }

    /**
     * @param consideracoesPersonalizadas the consideracoesPersonalizadas to set
     */
    public void setConsideracoesPersonalizadas(String consideracoesPersonalizadas) {
        this.consideracoesPersonalizadas = consideracoesPersonalizadas;
    }

    /**
     * @return the segmentosClientes
     */
    public Textocomentario getSegmentosClientes() {
        return segmentosClientes;
    }

    /**
     * @param segmentosClientes the segmentosClientes to set
     */
    public void setSegmentosClientes(Textocomentario segmentosClientes) {
        Textocomentario textoLista = retornarTextoComentario(Textocomentario.SEGMENTO_CLIENTE);
        textoLista.setTexto(segmentosClientes.getTexto());
        this.segmentosClientes = segmentosClientes;
    }

    /**
     * @return the propostaValor
     */
    public Textocomentario getPropostaValor() {
        return propostaValor;
    }

    /**
     * @param propostaValor the propostaValor to set
     */
    public void setPropostaValor(Textocomentario propostaValor) {
        this.propostaValor = propostaValor;
    }

    /**
     * @return the atividadeChave
     */
    public Textocomentario getAtividadeChave() {
        return atividadeChave;
    }

    /**
     * @param atividadeChave the atividadeChave to set
     */
    public void setAtividadeChave(Textocomentario atividadeChave) {
        this.atividadeChave = atividadeChave;
    }

    /**
     * @return the relacionamentoCliente
     */
    public Textocomentario getRelacionamentoCliente() {
        return relacionamentoCliente;
    }

    /**
     * @param relacionamentoCliente the relacionamentoCliente to set
     */
    public void setRelacionamentoCliente(Textocomentario relacionamentoCliente) {
        this.relacionamentoCliente = relacionamentoCliente;
    }

    /**
     * @return the parceriasChave
     */
    public Textocomentario getParceriasChave() {
        return parceriasChave;
    }

    /**
     * @param parceriasChave the parceriasChave to set
     */
    public void setParceriasChave(Textocomentario parceriasChave) {
        this.parceriasChave = parceriasChave;
    }

    /**
     * @return the canais
     */
    public Textocomentario getCanais() {
        return canais;
    }

    /**
     * @param canais the canais to set
     */
    public void setCanais(Textocomentario canais) {
        this.canais = canais;
    }

    /**
     * @return the recursosPrincipais
     */
    public Textocomentario getRecursosPrincipais() {
        return recursosPrincipais;
    }

    /**
     * @param recursosPrincipais the recursosPrincipais to set
     */
    public void setRecursosPrincipais(Textocomentario recursosPrincipais) {
        this.recursosPrincipais = recursosPrincipais;
    }

    /**
     * @return the concorrentes
     */
    public Textocomentario getConcorrentes() {
        return concorrentes;
    }

    /**
     * @param concorrentes the concorrentes to set
     */
    public void setConcorrentes(Textocomentario concorrentes) {
        this.concorrentes = concorrentes;
    }

    /**
     * @return the estagioEvolucao
     */
    public Textocomentario getEstagioEvolucao() {
        return estagioEvolucao;
    }

    /**
     * @param estagioEvolucao the estagioEvolucao to set
     */
    public void setEstagioEvolucao(Textocomentario estagioEvolucao) {
        this.estagioEvolucao = estagioEvolucao;
    }

    /**
     * @return the tecnologiaProcessos
     */
    public Textocomentario getTecnologiaProcessos() {
        return tecnologiaProcessos;
    }

    /**
     * @param tecnologiaProcessos the tecnologiaProcessos to set
     */
    public void setTecnologiaProcessos(Textocomentario tecnologiaProcessos) {
        this.tecnologiaProcessos = tecnologiaProcessos;
    }

    /**
     * @return the potencialInovacaoTecnologica
     */
    public Textocomentario getPotencialInovacaoTecnologica() {
        return potencialInovacaoTecnologica;
    }

    /**
     * @param potencialInovacaoTecnologica the potencialInovacaoTecnologica to
     * set
     */
    public void setPotencialInovacaoTecnologica(Textocomentario potencialInovacaoTecnologica) {
        this.potencialInovacaoTecnologica = potencialInovacaoTecnologica;
    }

    /**
     * @return the aplicacoes
     */
    public Textocomentario getAplicacoes() {
        return aplicacoes;
    }

    /**
     * @param aplicacoes the aplicacoes to set
     */
    public void setAplicacoes(Textocomentario aplicacoes) {
        this.aplicacoes = aplicacoes;
    }

    /**
     * @return the dificuldadesEsperadas
     */
    public Textocomentario getDificuldadesEsperadas() {
        return dificuldadesEsperadas;
    }

    /**
     * @param dificuldadesEsperadas the dificuldadesEsperadas to set
     */
    public void setDificuldadesEsperadas(Textocomentario dificuldadesEsperadas) {
        this.dificuldadesEsperadas = dificuldadesEsperadas;
    }

    /**
     * @return the interacaoEmpresaUniversidade
     */
    public Textocomentario getInteracaoEmpresaUniversidade() {
        return interacaoEmpresaUniversidade;
    }

    /**
     * @param interacaoEmpresaUniversidade the interacaoEmpresaUniversidade to
     * set
     */
    public void setInteracaoEmpresaUniversidade(Textocomentario interacaoEmpresaUniversidade) {
        this.interacaoEmpresaUniversidade = interacaoEmpresaUniversidade;
    }

    /**
     * @return the interacaoEmpresaComunidadeGoverno
     */
    public Textocomentario getInteracaoEmpresaComunidadeGoverno() {
        return interacaoEmpresaComunidadeGoverno;
    }

    /**
     * @param interacaoEmpresaComunidadeGoverno the
     * interacaoEmpresaComunidadeGoverno to set
     */
    public void setInteracaoEmpresaComunidadeGoverno(Textocomentario interacaoEmpresaComunidadeGoverno) {
        this.interacaoEmpresaComunidadeGoverno = interacaoEmpresaComunidadeGoverno;
    }

    /**
     * @return the infraestrutura
     */
    public Textocomentario getInfraestrutura() {
        return infraestrutura;
    }

    /**
     * @param infraestrutura the infraestrutura to set
     */
    public void setInfraestrutura(Textocomentario infraestrutura) {
        this.infraestrutura = infraestrutura;
    }

    /**
     * @return the participacaoAcionaria
     */
    public Textocomentario getParticipacaoAcionaria() {
        return participacaoAcionaria;
    }

    /**
     * @param participacaoAcionaria the participacaoAcionaria to set
     */
    public void setParticipacaoAcionaria(Textocomentario participacaoAcionaria) {
        this.participacaoAcionaria = participacaoAcionaria;
    }

    /**
     * @return the potencialEmprego
     */
    public Textocomentario getPotencialEmprego() {
        return potencialEmprego;
    }

    /**
     * @param potencialEmprego the potencialEmprego to set
     */
    public void setPotencialEmprego(Textocomentario potencialEmprego) {
        this.potencialEmprego = potencialEmprego;
    }

    /**
     * @return the fontesReceita
     */
    public Textocomentario getFontesReceita() {
        return fontesReceita;
    }

    /**
     * @param fontesReceita the fontesReceita to set
     */
    public void setFontesReceita(Textocomentario fontesReceita) {
        this.fontesReceita = fontesReceita;
    }

    /**
     * @return the estruturaCusto
     */
    public Textocomentario getEstruturaCusto() {
        return estruturaCusto;
    }

    /**
     * @param estruturaCusto the estruturaCusto to set
     */
    public void setEstruturaCusto(Textocomentario estruturaCusto) {
        this.estruturaCusto = estruturaCusto;
    }

    /**
     * @return the investimentoInicial
     */
    public Textocomentario getInvestimentoInicial() {
        return investimentoInicial;
    }

    /**
     * @param investimentoInicial the investimentoInicial to set
     */
    public void setInvestimentoInicial(Textocomentario investimentoInicial) {
        this.investimentoInicial = investimentoInicial;
    }

    /**
     * @return the custoFixo
     */
    public Textocomentario getCustoFixo() {
        return custoFixo;
    }

    /**
     * @param custoFixo the custoFixo to set
     */
    public void setCustoFixo(Textocomentario custoFixo) {
        this.custoFixo = custoFixo;
    }

    /**
     * @return the custoVariavel
     */
    public Textocomentario getCustoVariavel() {
        return custoVariavel;
    }

    /**
     * @param custoVariavel the custoVariavel to set
     */
    public void setCustoVariavel(Textocomentario custoVariavel) {
        this.custoVariavel = custoVariavel;
    }

    public Set<AlteracaoCampos> getAlteracaocampos() {
        return alteracaocampos;
    }

    public void setAlteracaocampos(Set<AlteracaoCampos> alteracaocampos) {
        this.alteracaocampos = alteracaocampos;
    }

    public AlteracaoCampos getSegmentosClientes_alteracao() {
        return segmentosClientes_alteracao;
    }

    public void setSegmentosClientes_alteracao(AlteracaoCampos segmentosClientes_alteracao) {
        this.segmentosClientes_alteracao = segmentosClientes_alteracao;
    }

    public AlteracaoCampos getPropostaValor_alteracao() {
        return propostaValor_alteracao;
    }

    public void setPropostaValor_alteracao(AlteracaoCampos propostaValor_alteracao) {
        this.propostaValor_alteracao = propostaValor_alteracao;
    }

    public AlteracaoCampos getAtividadeChave_alteracao() {
        return atividadeChave_alteracao;
    }

    public void setAtividadeChave_alteracao(AlteracaoCampos atividadeChave_alteracao) {
        this.atividadeChave_alteracao = atividadeChave_alteracao;
    }

    public AlteracaoCampos getRelacionamentoCliente_alteracao() {
        return relacionamentoCliente_alteracao;
    }

    public void setRelacionamentoCliente_alteracao(AlteracaoCampos relacionamentoCliente_alteracao) {
        this.relacionamentoCliente_alteracao = relacionamentoCliente_alteracao;
    }

    public AlteracaoCampos getParceriasChave_alteracao() {
        return parceriasChave_alteracao;
    }

    public void setParceriasChave_alteracao(AlteracaoCampos parceriasChave_alteracao) {
        this.parceriasChave_alteracao = parceriasChave_alteracao;
    }

    public AlteracaoCampos getCanais_alteracao() {
        return canais_alteracao;
    }

    public void setCanais_alteracao(AlteracaoCampos canais_alteracao) {
        this.canais_alteracao = canais_alteracao;
    }

    public AlteracaoCampos getRecursosPrincipais_alteracao() {
        return recursosPrincipais_alteracao;
    }

    public void setRecursosPrincipais_alteracao(AlteracaoCampos recursosPrincipais_alteracao) {
        this.recursosPrincipais_alteracao = recursosPrincipais_alteracao;
    }

    public AlteracaoCampos getConcorrentes_alteracao() {
        return concorrentes_alteracao;
    }

    public void setConcorrentes_alteracao(AlteracaoCampos concorrentes_alteracao) {
        this.concorrentes_alteracao = concorrentes_alteracao;
    }

    public AlteracaoCampos getEstagioEvolucao_alteracao() {
        return estagioEvolucao_alteracao;
    }

    public void setEstagioEvolucao_alteracao(AlteracaoCampos estagioEvolucao_alteracao) {
        this.estagioEvolucao_alteracao = estagioEvolucao_alteracao;
    }

    public AlteracaoCampos getTecnologiaProcessos_alteracao() {
        return tecnologiaProcessos_alteracao;
    }

    public void setTecnologiaProcessos_alteracao(AlteracaoCampos tecnologiaProcessos_alteracao) {
        this.tecnologiaProcessos_alteracao = tecnologiaProcessos_alteracao;
    }

    public AlteracaoCampos getPotencialInovacaoTecnologica_alteracao() {
        return potencialInovacaoTecnologica_alteracao;
    }

    public void setPotencialInovacaoTecnologica_alteracao(AlteracaoCampos potencialInovacaoTecnologica_alteracao) {
        this.potencialInovacaoTecnologica_alteracao = potencialInovacaoTecnologica_alteracao;
    }

    public AlteracaoCampos getAplicacoes_alteracao() {
        return aplicacoes_alteracao;
    }

    public void setAplicacoes_alteracao(AlteracaoCampos aplicacoes_alteracao) {
        this.aplicacoes_alteracao = aplicacoes_alteracao;
    }

    public AlteracaoCampos getDificuldadesEsperadas_alteracao() {
        return dificuldadesEsperadas_alteracao;
    }

    public void setDificuldadesEsperadas_alteracao(AlteracaoCampos dificuldadesEsperadas_alteracao) {
        this.dificuldadesEsperadas_alteracao = dificuldadesEsperadas_alteracao;
    }

    public AlteracaoCampos getInteracaoEmpresaUniversidade_alteracao() {
        return interacaoEmpresaUniversidade_alteracao;
    }

    public void setInteracaoEmpresaUniversidade_alteracao(AlteracaoCampos interacaoEmpresaUniversidade_alteracao) {
        this.interacaoEmpresaUniversidade_alteracao = interacaoEmpresaUniversidade_alteracao;
    }

    public AlteracaoCampos getInteracaoEmpresaComunidadeGoverno_alteracao() {
        return interacaoEmpresaComunidadeGoverno_alteracao;
    }

    public void setInteracaoEmpresaComunidadeGoverno_alteracao(AlteracaoCampos interacaoEmpresaComunidadeGoverno_alteracao) {
        this.interacaoEmpresaComunidadeGoverno_alteracao = interacaoEmpresaComunidadeGoverno_alteracao;
    }

    public AlteracaoCampos getInfraestrutura_alteracao() {
        return infraestrutura_alteracao;
    }

    public void setInfraestrutura_alteracao(AlteracaoCampos infraestrutura_alteracao) {
        this.infraestrutura_alteracao = infraestrutura_alteracao;
    }

    public AlteracaoCampos getParticipacaoAcionaria_alteracao() {
        return participacaoAcionaria_alteracao;
    }

    public void setParticipacaoAcionaria_alteracao(AlteracaoCampos participacaoAcionaria_alteracao) {
        this.participacaoAcionaria_alteracao = participacaoAcionaria_alteracao;
    }

    public AlteracaoCampos getPotencialEmprego_alteracao() {
        return potencialEmprego_alteracao;
    }

    public void setPotencialEmprego_alteracao(AlteracaoCampos potencialEmprego_alteracao) {
        this.potencialEmprego_alteracao = potencialEmprego_alteracao;
    }

    public AlteracaoCampos getFontesReceita_alteracao() {
        return fontesReceita_alteracao;
    }

    public void setFontesReceita_alteracao(AlteracaoCampos fontesReceita_alteracao) {
        this.fontesReceita_alteracao = fontesReceita_alteracao;
    }

    public AlteracaoCampos getEstruturaCusto_alteracao() {
        return estruturaCusto_alteracao;
    }

    public void setEstruturaCusto_alteracao(AlteracaoCampos estruturaCusto_alteracao) {
        this.estruturaCusto_alteracao = estruturaCusto_alteracao;
    }

    public AlteracaoCampos getInvestimentoInicial_alteracao() {
        return investimentoInicial_alteracao;
    }

    public void setInvestimentoInicial_alteracao(AlteracaoCampos investimentoInicial_alteracao) {
        this.investimentoInicial_alteracao = investimentoInicial_alteracao;
    }

    public AlteracaoCampos getCustoFixo_alteracao() {
        return custoFixo_alteracao;
    }

    public void setCustoFixo_alteracao(AlteracaoCampos custoFixo_alteracao) {
        this.custoFixo_alteracao = custoFixo_alteracao;
    }

    public AlteracaoCampos getCustoVariavel_alteracao() {
        return custoVariavel_alteracao;
    }

    public void setCustoVariavel_alteracao(AlteracaoCampos custoVariavel_alteracao) {
        this.custoVariavel_alteracao = custoVariavel_alteracao;
    }

    /**
     * @return Retorna o valor do comentário relacionado ao segmento de
     * clientes.
     */
    public String retornarSegmentosClientes() {
        return retornaTextoComentario(Textocomentario.SEGMENTO_CLIENTE);
    }

    /**
     * @return Retorna o valor do comentário relacionado ao proposta de valor.
     */
    public String retornarPropostaValor() {
        return retornaTextoComentario(Textocomentario.PROPOSTA_VALOR);
    }

    /**
     * @return Retorna o valor do comentário relacionado ao atividades chaves.
     */
    public String retornarAtividadesChave() {
        return retornaTextoComentario(Textocomentario.ATIVIDADES_CHAVE);
    }

    /**
     * @return Retorna o valor do comentário relacionado ao relações de
     * clientes.
     */
    public String retornarRelacoesClientes() {
        return retornaTextoComentario(Textocomentario.RELACOES_CLIENTE);
    }

    /**
     * @return Retorna o valor do comentário relacionado ao parcerias chaves.
     */
    public String retornarParceriasChave() {
        return retornaTextoComentario(Textocomentario.PARCERIAS_CHAVE);
    }

    /**
     * @return Retorna o valor do comentário relacionado ao canais.
     */
    public String retornarCanais() {
        return retornaTextoComentario(Textocomentario.CANAIS);
    }

    /**
     * @return Retorna o valor do comentário relacionado a recursos principais.
     */
    public String retornarRecursosPrincipais() {
        return retornaTextoComentario(Textocomentario.RECURSOS_PRINCIPAIS);
    }

    /**
     * @return Retorna o valor do comentário relacionado a concorrentes.
     */
    public String retornarConcorrentes() {
        return retornaTextoComentario(Textocomentario.CONCORRENTES);
    }

    /**
     * @return Retorna o valor do comentário relacionado a estagio de evolução.
     */
    public String retornarEstagioEvolucao() {
        return retornaTextoComentario(Textocomentario.ESTAGIO_EVOLUCAO);
    }

    /**
     * @return Retorna o valor do comentário relacionado a tecnologia e
     * processos.
     */
    public String retornarTecnologiaProcesso() {
        return retornaTextoComentario(Textocomentario.TECNOLOGIA_PROCESSOS);
    }

    /**
     * @return Retorna o valor do comentário relacionado ao potencial em
     * inovação e tecnologia..
     */
    public String retornarPotencialInovacaoTecnologia() {
        return retornaTextoComentario(Textocomentario.POTENCIAL_INOVACAO_TECNOLOGICA);
    }

    /**
     * @return Retorna o valor do comentário relacionado a aplicações.
     */
    public String retornarAplicacoes() {
        return retornaTextoComentario(Textocomentario.APLICACOES);
    }

    /**
     * @return Retorna o valor do comentário relacionado a difilcudades
     * esperadas.
     */
    public String retornarDifilcudadesEsperadas() {
        return retornaTextoComentario(Textocomentario.DIFICULDADES_ESPERADAS);
    }

    /**
     * @return Retorna o valor do comentário relacionado a interacao entre a
     * empresa e universidade.
     */
    public String retornarInteracaoEmpresaUniversidade() {
        return retornaTextoComentario(Textocomentario.INTERACAO_EMPRESA_UNIVERSIDADE);
    }

    /**
     * @return Retorna o valor do comentário relacionado a interacao entre a
     * empresa, a comunidade e o governo.
     */
    public String retornarInteracaoEmpresaComunidadeGoverno() {
        return retornaTextoComentario(Textocomentario.INTERACAO_EMPRESA_COMUNIDADE_GOVERNO);
    }

    /**
     * @return Retorna o valor do comentário relacionado a infraestrutura.
     */
    public String retornarInfraEstrutura() {
        return retornaTextoComentario(Textocomentario.INFRAESTRUTURA);
    }

    /**
     * @return Retorna o valor do comentário relacionado a participacao
     * acionário.
     */
    public String retornarParticipacaoAcionaria() {
        return retornaTextoComentario(Textocomentario.PARTICIPACAO_ACIONARIA);
    }

    /**
     * @return Retorna o valor do comentário relacionado o potencial de emprego.
     */
    public String retornarPotencialEmprego() {
        return retornaTextoComentario(Textocomentario.POTENCIAL_EMPREGO);
    }

    /**
     * @return Retorna o valor do comentário relacionado a fontes de receitas.
     */
    public String retornarFontesReceitas() {
        return retornaTextoComentario(Textocomentario.FONTES_RECEITA);
    }

    /**
     * @return Retorna o valor do comentário relacionado a estrutura de custos..
     */
    public String retornarEstruturaCustos() {
        return retornaTextoComentario(Textocomentario.ESTRUTURA_CUSTO);
    }

    /**
     * @return Retorna o valor do comentário relacionado ao investimento
     * inicial.
     */
    public String retornarInvestimentoInicial() {
        return retornaTextoComentario(Textocomentario.INVESTIMENTO_INICIAL);
    }

    /**
     * @return Retorna o valor do comentário relacionado ao custos fixos.
     */
    public String retornarCustosFixos() {
        return retornaTextoComentario(Textocomentario.CUSTOS_FIXOS);
    }

    /**
     * @return Retorna o valor do comentário relacionado ao custos variáveis.
     */
    public String retornarCustosVariaveis() {
        return retornaTextoComentario(Textocomentario.CUSTOS_VARIAVEIS);
    }

    /**
     * @return the textocomentarios
     */
    public Set<Textocomentario> getTextocomentarios() {
        return textocomentarios;
    }

    /**
     * @param textocomentarios the textocomentarios to set
     */
    public void setTextocomentarios(Set<Textocomentario> textocomentarios) {
        this.textocomentarios = textocomentarios;
    }
}
