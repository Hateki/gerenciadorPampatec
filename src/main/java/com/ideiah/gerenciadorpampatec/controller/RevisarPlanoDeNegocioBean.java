/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.controller;

import com.ideiah.gerenciadorpampatec.dao.ComentarioDao;
import com.ideiah.gerenciadorpampatec.dao.ProjetoDao;
import com.ideiah.gerenciadorpampatec.model.AlteracaoCampos;
import com.ideiah.gerenciadorpampatec.model.ComentarioProjeto;
import com.ideiah.gerenciadorpampatec.model.Custo;
import com.ideiah.gerenciadorpampatec.model.Empreendedor;
import com.ideiah.gerenciadorpampatec.model.Projeto;
import com.ideiah.gerenciadorpampatec.model.Textocomentario;
import com.ideiah.gerenciadorpampatec.util.FacesUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Ideiah Computer
 */
@ManagedBean
@ViewScoped
public class RevisarPlanoDeNegocioBean implements Serializable {

    private Projeto projeto;
    private ComentarioProjeto comentarioProjeto;
    private Textocomentario textocomentario;
    private String estagioEvolucao;
    private String estagioEvolucaoOutro;
    private Empreendedor empreendedorSession;
    private List<Custo> listaCustoFixo;
    private List<Custo> listaCustoVariavel;
    private ArrayList<Custo> custos;
    private ArrayList<Custo> custosVariaveis;
    private int somatorioFixo;
    private int somatorioVariavel;
    private boolean salvou;

    public RevisarPlanoDeNegocioBean() {
    }

    @PostConstruct
    private void init() {
        ProjetoDao projetoDao = new ProjetoDao();
        custos = new ArrayList<>();
        custosVariaveis = new ArrayList<>();
        projeto = (Projeto) SessionManager.getAttribute("projetoSelecionado");
        projeto = projetoDao.buscar(projeto.getIdProjeto());
        copiaCustosFixos();
        copiaCustosVariaveis();
        empreendedorSession = (Empreendedor) SessionManager.getAttribute("empreendedor");
        recuperaComentarioProjeto();
        setEstagioEvolucao(verificaEstagioEvolucao());
        listaCustoFixo = new ArrayList<>();
        listaCustoVariavel = new ArrayList<>();
        preencheListaCusto();
        salvou = false;
    }

    /**
     * <p>
     * Método para retornar os comentários do projeto selecionado que estão com
     * o status finalizado.
     * </p>
     */
    private void recuperaComentarioProjeto() {

        for (ComentarioProjeto objetoComentarioprojeto : projeto.getComentarioProjeto()) {
            if (objetoComentarioprojeto.getStatus() == ComentarioProjeto.FINALIZADO) {
                comentarioProjeto = objetoComentarioprojeto;
                break;
            }
        }
        if (comentarioProjeto != null) {
            comentarioProjeto.populandoVariaveisComentario();
            comentarioProjeto.populandoVariaveisAlteracoesCampos();
        }
    }

    /**
     * método que copia os custos fixos no inicio do objeto;
     */
    public void copiaCustosFixos() {

        for (Custo custo : projeto.getPlanofinanceiro().retornaListaCustosFixos()) {
            custos.add(custo);
        }
    }

    /**
     * método que copia os custos variaveis no inicio do objeto;
     */
    public void copiaCustosVariaveis() {

        for (Custo custo : projeto.getPlanofinanceiro().retornaListaCustosVariaveis()) {
            custosVariaveis.add(custo);
        }
    }

    /**
     * Método que Ordena a Lista ja preenchida de comentarios por data para
     * retornar o comentario certo a caixa de texto
     */
//    public void OrdenaListaComentariosProData(){
//
//        
//        for (Textocomentario listaTextoComentario : comentarioProjeto.getTextocomentarios()) {
//            if (comentarioProjeto.getStatus() == ComentarioProjeto.FINALIZADO) {
//                listaTextoComentario.
//            }
//            
//        }
//        
//        
//        projeto.getComentarioProjeto().
//        comentarioProjeto.getStatus().
//        listaDeComentarios.getTipo()
//    }
    /**
     * <p>
     * Preenche a lista de custo com os custos do projeto.</p>
     */
    private void preencheListaCusto() {
        if (projeto != null) {
            /**
             * lista de custos fixos recebe a lista de custos filtrada por
             * atributo tipo = fixo
             */
            listaCustoFixo = filtraCustoPorTipo(converteSetParaArrayListdeCusto(projeto.getPlanofinanceiro().getCusto()), Custo.CUSTO_FIXO);
            /**
             * lista de custos variáveis recebe a lista de custos filtrada por
             * atributo tipo = variável
             */
            listaCustoVariavel = filtraCustoPorTipo(converteSetParaArrayListdeCusto(projeto.getPlanofinanceiro().getCusto()), Custo.CUSTO_VARIAVEL);
        }
    }

    /**
     * <p>
     * Converte os registros do setCusto em um <code>ArrayList</code>.
     * </p>
     *
     * @param setCusto
     * @return arrayCusto
     */
    private ArrayList<Custo> converteSetParaArrayListdeCusto(Set<Custo> setCusto) {
        ArrayList<Custo> arrayCusto = new ArrayList<>();

        for (Custo custoSet : setCusto) {
            arrayCusto.add(custoSet);
        }
        return arrayCusto;
    }

    /**
     * <p>
     * Filtra lista de custos por tipo, seguindo constantes definidas na classe
     * Custo: FIXO ou VARIAVEL </p>
     *
     * @param listaCompleta
     * @param tipo
     * @return novaLista
     */
    private ArrayList<Custo> filtraCustoPorTipo(ArrayList<Custo> listaCompleta, int tipo) {
        ArrayList<Custo> novaLista = new ArrayList<>();
        for (Custo custoSelecionado : listaCompleta) {
            if (custoSelecionado.getTipo() == tipo) {
                novaLista.add(custoSelecionado);
            }
        }
        return novaLista;
    }

    /**
     * <p>
     * Atualiza o projeto que está na sessão.</p>
     */
    public void atualizarProjetoSessao() {
        HttpSession secao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        secao.setAttribute("projetoSelecionado", projeto);
    }

    /**
     *
     * @param projetoSelecionado
     * @return
     */
    public boolean verificaExistenciaComentarioProjeto(Projeto projetoSelecionado) {
        if (projetoSelecionado.getStatus() == Projeto.ACEITO_PARA_AVALIACAO) {

            if (comentarioProjeto != null && comentarioProjeto.verificaCampos() != 0) {
                return true;
            }

        }
        return false;
    }

    /**
     *
     * @param projetoSelecionado
     * @return
     */
    public boolean verificaStatusSendoAvaliado(Projeto projetoSelecionado) {

        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        projetoSelecionado = (Projeto) session.getAttribute("projetoSelecionado");
        return projetoSelecionado.getStatus() == Projeto.SENDO_AVALIADO;
    }

    /**
     *
     * @param projetoSelecionado
     * @return
     */
    public boolean verificaStatusAceitoAvaliacao(Projeto projetoSelecionado) {

        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        projetoSelecionado = (Projeto) session.getAttribute("projetoSelecionado");
        return projetoSelecionado.getStatus() == Projeto.ACEITO_PARA_AVALIACAO;
    }

    public boolean verificaStatusRevisando(Projeto projetoSelecionado) {

        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        projetoSelecionado = (Projeto) session.getAttribute("projetoSelecionado");
        return projetoSelecionado.getStatus() == Projeto.REVISANDO;
    }

    /**
     *
     * @param projetoSelecionado
     * @return
     */
    public boolean verificaStatusSubmetido(Projeto projetoSelecionado) {

        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        projetoSelecionado = (Projeto) session.getAttribute("projetoSelecionado");
        return projetoSelecionado.getStatus() == Projeto.SUBMETIDO;
    }

    /**
     *
     * @param projetoSelecionado
     * @return
     */
    public boolean verificaStatusReSubmetido(Projeto projetoSelecionado) {

        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        projetoSelecionado = (Projeto) session.getAttribute("projetoSelecionado");
        return projetoSelecionado.getStatus() == Projeto.RESUBMETIDO;
    }

    /**
     *
     * @param projetoSelecionado
     * @return
     */
    public boolean verificaStatusEmPreAvaliacao(Projeto projetoSelecionado) {

        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        projetoSelecionado = (Projeto) session.getAttribute("projetoSelecionado");
        return projetoSelecionado.getStatus() == Projeto.EM_PRE_AVALIACAO;
    }

    /**
     *
     * @param projetoSelecionado
     * @return
     */
    public boolean verificaStatusNecessitaMelhoria(Projeto projetoSelecionado) {

        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        projetoSelecionado = (Projeto) session.getAttribute("projetoSelecionado");

        return (projetoSelecionado.getStatus() == Projeto.NECESSITA_MELHORIA)
                || (projetoSelecionado.getStatus() == Projeto.REVISANDO);
    }

    /**
     * <p>
     * Retorna o projeto da sessão, garantindo que ele está atualizado com o
     * servidor.</p>
     *
     * @return projeto da sessão
     */
    public int retornaStatusProjeto() {
        HttpSession sessao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        projeto = (Projeto) sessao.getAttribute("projetoSelecionado");
        return projeto.getStatus();
    }

    /**
     * <p>
     * Método para retornar o resultado da Avaliação em <code>String</code> para
     * a área de Avaliação.
     * </p>
     *
     * @return o resultado da avaliação pelo gerente.
     *
     */
    public String retornaResultadoAvaliacao() {
        String resultadoAvaliacao = "";

        switch (projeto.getStatus()) {
            case Projeto.NECESSITA_MELHORIA:
                resultadoAvaliacao = " Projeto Necessita Realizar Ajustes";
                break;
            case Projeto.REPROVADO:
                resultadoAvaliacao = " Projeto Reprovado";
                break;
            case Projeto.ACEITO_PARA_AVALIACAO:
                resultadoAvaliacao = " Projeto Aceito para Avaliação";
                break;
            default:
                break;
        }
        return resultadoAvaliacao;
    }

    /**
     * <p>
     * Método para verificar qual o tipo de estágio a empresa se encontra.
     * </p>
     *
     * @return o estágio em que a empresa está.
     */
    private String verificaEstagioEvolucao() {
        if (projeto.getProdutoouservico().getEstagioEvolucao() == null) {
            return "Ideia Básica";
        }
        String status = projeto.getProdutoouservico().verificaStatusProjeto(projeto.getProdutoouservico().getEstagioEvolucao());
        if (status.equals("Outro:")) {
            estagioEvolucaoOutro = projeto.getProdutoouservico().getEstagioEvolucao();
            return "Outro";
        } else {
            return status;
        }
    }

    /**
     * <p>
     * Muda o status do projeto em pré avaliação e redireciona para o início.
     * </p>
     */
    public void mudaStatusRedirecionaInicio() {
        RedirectManager.getInicio();
    }

    /**
     * <p>
     * Método para salvar as edições feitas no objeto do projeto.
     * </p>
     */
    public void salvarRevisaoProjeto() {
        ProjetoDao projetoDao = new ProjetoDao();
        projeto.getProdutoouservico().setEstagioEvolucao(pegaValorDropDown());
        projeto.setStatus(Projeto.REVISANDO);
        projetoDao.salvar(projeto);
        salvou = true;

        /**
         * Para exibir a mensagem de salvo com sucesso.
         */
        FacesMessage msg;
        msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Salvo", "Sua alteração foi salva com sucesso.");
        FacesContext.getCurrentInstance().addMessage("formulario_resubmeterplano:tituloMensagem", msg);
    }

    /**
     * <p>
     * Método para salvar o projeto e as alterações dos campos do plano no
     * histórico de comentários. Em cada alteração de campo efetuada, essa
     * alteração é salva e o plano também. É tóis!
     * </p>
     *
     * @param alteracao
     * @param texto
     */
    public void salvarAlteracaoCampo(AlteracaoCampos alteracao, String texto) {
        ProjetoDao projetoDao = new ProjetoDao();
        projeto.getProdutoouservico().setEstagioEvolucao(pegaValorDropDown());
        projeto.setStatus(Projeto.REVISANDO);
        projetoDao.salvar(projeto);
        salvou = true;

        ComentarioDao comentDao = new ComentarioDao();
        comentarioProjeto.atualizarTextoAlteracao(alteracao, texto, empreendedorSession);
        comentDao.salvar(comentarioProjeto);

        /**
         * Para exibir a mensagem de salvo com sucesso.
         */
        FacesMessage msg;
        msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Salvo", "Sua alteração foi salva com sucesso.");
        FacesContext.getCurrentInstance().addMessage("formulario_resubmeterplano:tituloMensagem", msg);

    }

    /**
     * METODO VERIFICA QUAL O BOTÃO FOI SELECIONADO NO RADIO BUTTON DE ESTAGIO
     * DE EVOLUÇÃO APÓS VERIFICAR QUAL BOTÃO, SETA NO ESTAGIO DE VOLUÇÃO O VALOR
     * CORRESPONDENTE CASO FOI SELECIONADO O BOTÃO (OUTRO) ENTÃO É SALVO O VALOR
     * DO CAMPO (descricaoButtonOutro)
     *
     * @return
     */
    public String pegaValorDropDown() {
        String valorEstagioEvolucao = null;
        switch (estagioEvolucao) {
            case "Ideia Básica":
                valorEstagioEvolucao = "Ideia Básica";
                estagioEvolucaoOutro = null;
                break;
            case "Projeto Básico":
                valorEstagioEvolucao = "Projeto Básico";
                estagioEvolucaoOutro = null;
                break;
            case "Projeto Detalhado":
                valorEstagioEvolucao = "Projeto Detalhado";
                estagioEvolucaoOutro = null;
                break;
            case "Protótipo Desenvolvido":
                valorEstagioEvolucao = "Protótipo Desenvolvido";
                estagioEvolucaoOutro = null;
                break;
            case "Em teste no mercado":
                valorEstagioEvolucao = "Em teste no mercado";
                estagioEvolucaoOutro = null;
                break;
            case "Clientes Pagando":
                valorEstagioEvolucao = "Clientes Pagando";
                estagioEvolucaoOutro = null;
                break;
            default:
                valorEstagioEvolucao = estagioEvolucaoOutro;
                break;
        }
        return valorEstagioEvolucao;
    }

    /**
     * método que salva as aterações realizadas na tabela e custos fixos
     *
     * @param alteracao
     * @param custo
     */
    public void salvarAlteracaoCampoTabelaCustosFixos(AlteracaoCampos alteracao, Custo custo) {

        salvou = true;
        String texto = "";

        if (custos.size() != projeto.getPlanofinanceiro().retornaListaCustosFixos().size()) {
            texto = "Foi adicionada ou excluída uma linha da tabela";
        } else {
            for (int i = 0; i < custos.size(); i++) {

                if (Objects.equals(custos.get(i).getIdCusto(), custo.getIdCusto())) {

                    if (!custos.get(i).getDescricao().equalsIgnoreCase(custo.getDescricao())) {
                        texto += "Foi alterado a descricao da linha" + (i + 1) + "\n";
                    }
                    if (!Objects.equals(custos.get(i).getTotal(), custo.getTotal())) {
                        texto += "Foi alterado o custo da linha" + (i + 1);
                    }
                }
            }
        }
        ComentarioDao comentDao = new ComentarioDao();
        ProjetoDao projetoDao = new ProjetoDao();
        projeto.getProdutoouservico().setEstagioEvolucao(pegaValorDropDown());
        projeto.setStatus(Projeto.REVISANDO);
        projetoDao.salvar(projeto);
        comentarioProjeto.atualizarTextoAlteracao(alteracao, texto, empreendedorSession);
        comentDao.salvar(comentarioProjeto);

        /**
         * Para exibir a mensagem de salvo com sucesso.
         */
        FacesMessage msg;
        msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Salvo", "Sua alteraÃ§Ã£o foi salva com sucesso.");

        FacesContext.getCurrentInstance()
                .addMessage("formulario_resubmeterplano:tituloMensagem", msg);

    }

    /**
     * método que salva as aterações realizadas na tabela e custos variáveis
     *
     * @param alteracao
     * @param custo
     */
    public void salvarAlteracaoCampoTabelaCustosVariaveis(AlteracaoCampos alteracao, Custo custo) {

        salvou = true;
        String texto = "";

        if (custosVariaveis.size() != projeto.getPlanofinanceiro().retornaListaCustosVariaveis().size()) {
            texto = "Foi adicionada ou excluída uma linha da tabela";

        } else {

            for (int i = 0; i < custosVariaveis.size(); i++) {

                if (Objects.equals(custosVariaveis.get(i).getIdCusto(), custo.getIdCusto())) {

                    if (!custosVariaveis.get(i).getDescricao().equalsIgnoreCase(custo.getDescricao())) {

                        texto += "Foi alterado a descricao da linha" + (i + 1) + "\n";

                    }
                    if (!Objects.equals(custosVariaveis.get(i).getTotal(), custo.getTotal())) {

                        texto += "Foi alterado o custo da linha" + (i + 1);
                    }
                }
            }
        }
        ComentarioDao comentDao = new ComentarioDao();
        ProjetoDao projetoDao = new ProjetoDao();
        projeto.getProdutoouservico().setEstagioEvolucao(pegaValorDropDown());
        projeto.setStatus(Projeto.REVISANDO);
        projetoDao.salvar(projeto);
        comentarioProjeto.atualizarTextoAlteracao(alteracao, texto, empreendedorSession);
        comentDao.salvar(comentarioProjeto);

        /**
         * Para exibir a mensagem de salvo com sucesso.
         */
        FacesMessage msg;
        msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Salvo", "Sua alteraÃ§Ã£o foi salva com sucesso.");

        FacesContext.getCurrentInstance()
                .addMessage("formulario_resubmeterplano:tituloMensagem", msg);

    }

    /**
     * <p>
     * Método para verificar se todos os campos do plano de negócio estão
     * preenchidos.</p>
     *
     * @return FLAG
     */
    public int verificarCampos() {
        int FLAG = 0;
        if (projeto.getNome().trim().isEmpty()) {
            FacesUtil.addErrorMessage("Campo não pode estar vazio", "formulario_resubmeterplano:empresaProjeto1");
            FLAG = FLAG + 1;
        }
        if (projeto.getNegocio().getSegmentoClientes().trim().isEmpty()) {
            FacesUtil.addErrorMessage("Campo não pode estar vazio", "formulario_resubmeterplano:segmentoDeClientes1");
            FLAG = FLAG + 1;
        }
        if (projeto.getNegocio().getPropostaValor().trim().isEmpty()) {
            FacesUtil.addErrorMessage("Campo não pode estar vazio", "formulario_resubmeterplano:propostaDeValor1");
            FLAG = FLAG + 1;
        }
        if (projeto.getNegocio().getAtividadesChaves().trim().isEmpty()) {
            FacesUtil.addErrorMessage("Campo não pode estar vazio", "formulario_resubmeterplano:atividadesChave1");
            FLAG = FLAG + 1;
        }
        if (projeto.getAnaliseemprego().getRelacoesClientes().trim().isEmpty()) {
            FacesUtil.addErrorMessage("Campo não pode estar vazio", "formulario_resubmeterplano:relacoComClientes1");
            FLAG = FLAG + 1;
        }
        if (projeto.getAnaliseemprego().getParceriasChaves().trim().isEmpty()) {
            FacesUtil.addErrorMessage("Campo não pode estar vazio", "formulario_resubmeterplano:parceriasChaves1");
            FLAG = FLAG + 1;
        }
        if (projeto.getAnaliseemprego().getCanais().trim().isEmpty()) {
            FacesUtil.addErrorMessage("Campo não pode estar vazio", "formulario_resubmeterplano:canais1");
            FLAG = FLAG + 1;
        }
        if (projeto.getAnaliseemprego().getRecursosPrincipais().trim().isEmpty()) {
            FacesUtil.addErrorMessage("Campo não pode estar vazio", "formulario_resubmeterplano:recursosPrincipais1");
            FLAG = FLAG + 1;
        }
        if (projeto.getAnaliseemprego().getConcorrentes().trim().isEmpty()) {
            FacesUtil.addErrorMessage("Campo não pode estar vazio", "formulario_resubmeterplano:concorrentes1");
            FLAG = FLAG + 1;
        }

        if (projeto.getProdutoouservico().getTecnologiaProcessos().trim().isEmpty()) {
            FacesUtil.addErrorMessage("Campo não pode estar vazio", "formulario_resubmeterplano:tecnologiaProcessos1");
            FLAG = FLAG + 1;
        }
        if (projeto.getProdutoouservico().getPotencialInovacaoTecnologica().trim().isEmpty()) {
            FacesUtil.addErrorMessage("Campo não pode estar vazio", "formulario_resubmeterplano:potencialInovacaoTecnologica1");
            FLAG = FLAG + 1;
        }
        if (projeto.getProdutoouservico().getAplicacoes().trim().isEmpty()) {
            FacesUtil.addErrorMessage("Campo não pode estar vazio", "formulario_resubmeterplano:aplicacoes1");
            FLAG = FLAG + 1;
        }
        if (projeto.getProdutoouservico().getDificuldadesEsperadas().trim().isEmpty()) {
            FacesUtil.addErrorMessage("Campo não pode estar vazio", "formulario_resubmeterplano:dificuldadesEsperadas1");
            FLAG = FLAG + 1;
        }
        if (projeto.getProdutoouservico().getInteracaoEmpresaUniversidade().trim().isEmpty()) {
            FacesUtil.addErrorMessage("Campo não pode estar vazio", "formulario_resubmeterplano:interacaoEmpresaUniversidade1");
            FLAG = FLAG + 1;
        }
        if (projeto.getProdutoouservico().getInteracaoEmpresaComunidadeGoverno().trim().isEmpty()) {
            FacesUtil.addErrorMessage("Campo não pode estar vazio", "formulario_resubmeterplano:interacaoEmpresaComunidadeGoverno1");
            FLAG = FLAG + 1;
        }
        if (projeto.getProdutoouservico().getInfraestrutura().trim().isEmpty()) {
            FacesUtil.addErrorMessage("Campo não pode estar vazio", "formulario_resubmeterplano:infraestrutura1");
            FLAG = FLAG + 1;
        }
        if (projeto.getParticipacaoacionaria().trim().isEmpty()) {
            FacesUtil.addErrorMessage("Campo não pode estar vazio", "formulario_resubmeterplano:participacaoAcionaria1");
            FLAG = FLAG + 1;
        }
        if (projeto.getPotencialEmprego().trim().isEmpty()) {
            FacesUtil.addErrorMessage("Campo não pode estar vazio", "formulario_resubmeterplano:potencialEmprego1");
            FLAG = FLAG + 1;
        }
        if (projeto.getPlanofinanceiro().getFontesReceita().trim().isEmpty()) {
            FacesUtil.addErrorMessage("Campo não pode estar vazio", "formulario_resubmeterplano:fontesDeReceita1");
            FLAG = FLAG + 1;
        }
        if (projeto.getPlanofinanceiro().getEstruturaCusto().trim().isEmpty()) {
            FacesUtil.addErrorMessage("Campo não pode estar vazio", "formulario_resubmeterplano:estruturaCustos1");
            FLAG = FLAG + 1;
        }
        if (projeto.getPlanofinanceiro().getInvestimentoInicial().trim().isEmpty()) {
            FacesUtil.addErrorMessage("Campo não pode estar vazio", "formulario_resubmeterplano:investimentoInicial1");
            FLAG = FLAG + 1;
        }

        return FLAG;
    }

    /**
     * <p>
     * Método para salvar e terminar a revisão do projeto.
     * </p>
     */
    public void terminarRevisaoProjeto() {
        int FLAG = verificarCampos();
        int FLAG_STATUS = 0;

        if (FLAG > 0) {
            FacesUtil.addErrorMessage(" O Sistema encontrou " + FLAG + " campos não preenchidos",
                    "formulario_resubmeterplano:tituloMensagem");

        } else {
            ProjetoDao projetoDao = new ProjetoDao();
            projeto.setStatus(Projeto.RESUBMETIDO);
            Date dataEnvio = new Date(System.currentTimeMillis());
            /**
             * Altera a data de envio, setando a nova para a data atual da
             * ressubmissão.
             */
            projeto.setDataEnvio(dataEnvio);
            /**
             * A data de avaliação e alterada para null pois o projeto será
             * ressubmetido.
             */
            projeto.setDataAvaliacao(null);
            comentarioProjeto.setStatus(ComentarioProjeto.HISTORICO);

            projetoDao.salvar(comentarioProjeto);
            projetoDao.salvar(projeto);

            EmailManager.enviaEmailParaGerentes(projeto);

            getBuscarPlanoDeNegocio();
        }
    }

    /**
     * <p>
     * Redireciona para a página de lista de Planos de Negócio.
     * </p>
     */
    private void getBuscarPlanoDeNegocio() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("../paginaBuscaPlanoDeNegocio.jsf");
        } catch (Exception e) {
            Logger.getLogger(PreAvaliarPlanoBean.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * <p>
     * Redireciona para a página da fase de Avaliação.</p>
     */
    public void redirecionaPaginaAvaliacao() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("avaliacaoPlanoDeNegocio.jsf");
        } catch (Exception e) {
            Logger.getLogger(PreAvaliarPlanoBean.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * <p>
     * Exibe o campo de texto para inserir conteúdo referente a opção OUTRO no
     * estado do negócio.</p>
     *
     * @return <code>true</code> se o usuário clicar no <i>checkbox</i> "Outro".
     */
    public boolean exibeCampoOutro() {
        return estagioEvolucao != null && estagioEvolucao.equals("Outro");
    }

    /**
     * <p>
     * Método que faz o calculo da projeção de cada custo fixo para seis
     * meses.</p>
     *
     * @param custo
     */
    public void caucularProjecaoCustoFixo(Custo custo) {
        if (custo != null) {
            int valor = custo.getTotal() * 6;
            custo.setProjecao(valor);

//            salvarProjeto();
            ProjetoDao dao = new ProjetoDao();
            dao.update(custo);
        }
    }

    /**
     * <p>
     * Método que faz o calculo da projeção de cada custo variável para seis
     * meses.</p>
     *
     * @param custo
     */
    public void caucularProjecaoCustoVariavel(Custo custo) {
        if (custo != null) {
            int valor = custo.getTotal() * 6;
            custo.setProjecao(valor);

//            salvarProjeto();
            ProjetoDao dao = new ProjetoDao();
            dao.update(custo);
        }

    }

//==============================================================================
    /**
     * <p>
     * Método para ação após linha ser editada, atualizando valores na
     * tabela.</p>
     *
     * @param event
     * @param alteracao
     */
    public void onRowEdit(RowEditEvent event) {
        FacesMessage msg;
        Custo custo = (Custo) event.getObject();

        msg = new FacesMessage("Custo Editado", custo.getDescricao());
        FacesContext.getCurrentInstance().addMessage("formulario_resubmeterplano:mensagensFeed", msg);
        salvou = true;

        if (custo.getTipo() == 0) {
            AlteracaoCampos alteracao = comentarioProjeto.getCustoFixo_alteracao();
            salvarAlteracaoCampoTabelaCustosFixos(alteracao, custo);

        } else {
            AlteracaoCampos alteracao = comentarioProjeto.getCustoVariavel_alteracao();
            salvarAlteracaoCampoTabelaCustosVariaveis(alteracao, custo);
        }

        calcularValorColunaCustoVariavel();
        calcularValorColunaCustoFixo();

        ProjetoDao projetoDao = new ProjetoDao();
        projetoDao.salvar(custo);

    }

    /**
     * <p>
     * Método que cancela edição da linha na tabela.</p>
     *
     * @param event
     */
    public void onRowCancel(RowEditEvent event) {

        FacesMessage msg = new FacesMessage("Edição Cancelada", ((Custo) event.getObject()).getDescricao());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    /**
     * <p>
     * Deleta registro na tabela.</p>
     *
     * @param custo
     */
    public void deletarLinha(Custo custo) {
        FacesMessage msg;
        if (custo.getTipo() == Custo.CUSTO_FIXO) {
            deletarCustoFixo(custo);
            calcularValorColunaCustoFixo();
            msg = new FacesMessage("Custo fixo DELETADO");
            FacesContext.getCurrentInstance().addMessage("formulario_resubmeterplano:mensagensFeed", msg);
        }
        if (custo.getTipo() == Custo.CUSTO_VARIAVEL) {
            deletarCustoVariavel(custo);
            calcularValorColunaCustoVariavel();
            msg = new FacesMessage("Custo variavel DELETADO");
            FacesContext.getCurrentInstance().addMessage("formulario_resubmeterplano:mensagensFeed", msg);
        }
        salvou = true;
        projeto.SalvarProjetoExistente(projeto);
    }

    /**
     * <p>
     * Método para adicionar custo fixo ao projeto e à tabela.</p>
     */
    public void adicionarLinhaFixo() {
        Custo custo = new Custo();
        custo.setDescricao("Novo Custo");
        custo.setTipo(Custo.CUSTO_FIXO);
        custo.setTotal(0);
        custo.setProjecao(0);
        custo.setPodeExcluir(true);
        projeto.getPlanofinanceiro().getCusto().add(custo);
        custo.setPlanofinanceiro(projeto.getPlanofinanceiro());
        salvou = true;
        salvarProjeto();
        preencheListaCusto();
    }

    /**
     * <p>
     * Método para adicionar custo variável a tabela.</p>
     */
    public void adicionarLinhaVariavel() {
        Custo custo = new Custo();
        custo.setDescricao("Novo Custo");
        custo.setTipo(Custo.CUSTO_VARIAVEL);
        custo.setTotal(0);
        custo.setProjecao(0);
        custo.setPodeExcluir(true);
        projeto.getPlanofinanceiro().getCusto().add(custo);
        custo.setPlanofinanceiro(projeto.getPlanofinanceiro());
        salvou = true;
        salvarProjeto();
        preencheListaCusto();
    }

    /**
     * <p>
     * Salva o projeto atual no banco de dados e na sessão.</p>
     */
    private void salvarProjeto() {
        if (projeto.getNome() == null || projeto.getNome().equals("")) {
            projeto.setNome("Novo plano de negócio sem nome");
        }

        FacesUtil.addFeedbackSaveSuccess("formulario_resubmeterplano:tituloMensagem");

//        pegaValorDropDown();
//        EnviaEmails(projeto);
        ProjetoDao daoProj = new ProjetoDao();
        projeto = daoProj.salvarRetornandoProjeto(projeto);
        atualizarProjetoSessao();
    }

    /**
     * <p>
     * Método que soma os valores de cada custo fixo adicionados na tabela e faz
     * a projeção para seis meses.</p>
     *
     * @return O somatório do custo fixo.
     */
    public int calcularValorColunaCustoFixo() {
        somatorioFixo = 0;
        for (int i = 0; i < listaCustoFixo.size(); i++) {
            somatorioFixo = somatorioFixo + listaCustoFixo.get(i).getTotal();
        }
        somatorioFixo = somatorioFixo * 6;
        projeto.getPlanofinanceiro().setValorTotalFixo(somatorioFixo);
        setSomatorioVariavel(somatorioFixo);
        return somatorioFixo;
    }

    /**
     * <p>
     * Método que soma os valores de cada custo variável adicionados na tabela e
     * faz a projeção para seis meses.</p>
     *
     * @return O somatório do custo variável.
     */
    public int calcularValorColunaCustoVariavel() {
        somatorioVariavel = 0;
        for (int i = 0; i < listaCustoVariavel.size(); i++) {
            somatorioVariavel = somatorioVariavel + listaCustoVariavel.get(i).getTotal();
        }
        somatorioVariavel = somatorioVariavel * 6;
        projeto.getPlanofinanceiro().setValorTotalVariavel(somatorioVariavel);
        setSomatorioVariavel(somatorioVariavel);
        return somatorioVariavel;
    }

    /**
     * <p>
     * Remove custo fixo da tabela e do projeto.</p>
     *
     * @param custoFixo
     */
    private void deletarCustoFixo(Custo custoFixo) {
        ProjetoDao daoProj = new ProjetoDao();
        listaCustoFixo.remove(custoFixo);
        empreendedorSession.removeCustoProjeto(custoFixo);
        projeto = daoProj.buscar(projeto.getIdProjeto());
        atualizarProjetoSessao();

        preencheListaCusto();
    }

    /**
     * <p>
     * Remove custo variável da tabela e do projeto.</p>
     *
     * @param custoVariavel
     */
    private void deletarCustoVariavel(Custo custoVariavel) {
        ProjetoDao daoProj = new ProjetoDao();
        listaCustoVariavel.remove(custoVariavel);
        empreendedorSession.removeCustoProjeto(custoVariavel);
        projeto = daoProj.buscar(projeto.getIdProjeto());
        atualizarProjetoSessao();
        preencheListaCusto();
    }

//==============================================================================    
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

    /**
     * @return the comentarioProjeto
     */
    public ComentarioProjeto getComentarioProjeto() {
        return comentarioProjeto;
    }

    /**
     * @param comentarioProjeto the comentarioProjeto to set
     */
    public void setComentarioProjeto(ComentarioProjeto comentarioProjeto) {
        this.comentarioProjeto = comentarioProjeto;
    }

//    /**
//     * @return the loginBean
//     */
//    public RedirectManager getLoginBean() {
//        return loginBean;
//    }
//
//    /**
//     * @param loginBean the loginBean to set
//     */
//    public void setLoginBean(RedirectManager loginBean) {
//        this.loginBean = loginBean;
//    }
    public String getEstagioEvolucao() {
        return estagioEvolucao;
    }

    public void setEstagioEvolucao(String estagioEvolucao) {
        this.estagioEvolucao = estagioEvolucao;
    }

    public String getEstagioEvolucaoOutro() {
        return estagioEvolucaoOutro;
    }

    public void setEstagioEvolucaoOutro(String estagioEvolucaoOutro) {
        this.estagioEvolucaoOutro = estagioEvolucaoOutro;
    }

    public List<Custo> getListaCustoFixo() {
        return listaCustoFixo;
    }

    public void setListaCustoFixo(List<Custo> listaCustoFixo) {
        this.listaCustoFixo = listaCustoFixo;
    }

    public List<Custo> getListaCustoVariavel() {
        return listaCustoVariavel;
    }

    public void setListaCustoVariavel(List<Custo> listaCustoVariavel) {
        this.listaCustoVariavel = listaCustoVariavel;
    }

    public int getSomatorioFixo() {
        return somatorioFixo;
    }

    public void setSomatorioFixo(int somatorioFixo) {
        this.somatorioFixo = somatorioFixo;
    }

    public int getSomatorioVariavel() {
        return somatorioVariavel;
    }

    public void setSomatorioVariavel(int somatorioVariavel) {
        this.somatorioVariavel = somatorioVariavel;
    }

    /**
     * @return the salvou
     */
    public boolean isSalvou() {
        return salvou;
    }

    /**
     * @param salvou the salvou to set
     */
    public void setSalvou(boolean salvou) {
        this.salvou = salvou;
    }
}
