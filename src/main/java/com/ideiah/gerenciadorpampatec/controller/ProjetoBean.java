/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.controller;

import com.ideiah.gerenciadorpampatec.dao.EmpreendedorDao;
import com.ideiah.gerenciadorpampatec.dao.ProjetoDao;
import com.ideiah.gerenciadorpampatec.model.Analiseemprego;
import com.ideiah.gerenciadorpampatec.model.Custo;
import com.ideiah.gerenciadorpampatec.model.Empreendedor;
import com.ideiah.gerenciadorpampatec.model.GerenteRelacionamento;
import com.ideiah.gerenciadorpampatec.model.Negocio;
import com.ideiah.gerenciadorpampatec.model.Planofinanceiro;
import com.ideiah.gerenciadorpampatec.model.Produtoouservico;
import com.ideiah.gerenciadorpampatec.model.Projeto;
import com.ideiah.gerenciadorpampatec.util.EmailUtil;
import com.ideiah.gerenciadorpampatec.util.FacesUtil;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Pedro
 */
@ManagedBean(name = "projetoBean")
@ViewScoped
public class ProjetoBean implements Serializable {

    private Empreendedor empreendedorSelected;
    private Projeto projeto;
    private Analiseemprego analiseEmprego;
    private Negocio negocio;
    private Produtoouservico produtoOuSevico;
    private Planofinanceiro planoFinanceiro;
    private String emailEmpreendedor;
    private List<Empreendedor> listaEmpreendedor;
    private List<Empreendedor> empreedendoresAdicionados;
    private String selectedButton;
    private String descricaoButtonOutro;
    private Empreendedor empreendedorSession;
    private boolean salvou;
    private String nomeCustoFixo;
    private float valorCustoFixo;
    private String nomeCustoVariavel;
    private float valorCustoVariavel;
    private List<Custo> listaCustoFixo;
    private List<Custo> listaCustoVariavel;
    private Custo custoFixoSelecionado;
    private Custo custoVariavelSelecionado;
    private int somatorioVariavel;

    private int somatorioFixo;
    private List<Projeto> listaProjetoFiltradaPorBase;

    public ProjetoBean() {
        salvou = false;
        listaEmpreendedor = Empreendedor.retornarEmpreendedores();
        empreedendoresAdicionados = new ArrayList<>();
        projeto = (Projeto) SessionManager.getAttribute("projetoSelecionado");
        empreendedorSession = (Empreendedor) SessionManager.getAttribute("empreendedor");
        preencheDropDown();
        listaCustoFixo = new ArrayList<>();
        listaCustoVariavel = new ArrayList<>();
        preencheListaCusto();
        //INICIANDO VARIÁVEIS DE APOIO PARA DELETAR CUSTOS DA TABELA;
        custoFixoSelecionado = new Custo();
        custoVariavelSelecionado = new Custo();

    }

    /**
     * Preenche a lista de custo com os custos do projeto.
     */
    public void preencheListaCusto() {
        if (projeto != null) {
            //lista de custos fixos recebe a lista de custos filtrada por atributo tipo = fixo
            listaCustoFixo = filtraCustoPorTipo(converteSetParaArrayListdeCusto(projeto.getPlanofinanceiro().getCusto()), Custo.CUSTO_FIXO);
            //lista de custos variaveis recebe a lista de custos filtrada por atributo tipo = variavel
            listaCustoVariavel = filtraCustoPorTipo(converteSetParaArrayListdeCusto(projeto.getPlanofinanceiro().getCusto()), Custo.CUSTO_VARIAVEL);
        }
    }

    /**
     * Atualiza o projeto que está na sessão.
     */
    public void atualizarProjetoSessao() {
        HttpSession secao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        secao.setAttribute("projetoSelecionado", projeto);
    }

    /**
     * Preenche o radio button se o projeto já estiver com ele preenchido
     */
    public void preencheDropDown() {
        if (projeto != null && projeto.getProdutoouservico() != null && projeto.getProdutoouservico().getEstagioEvolucao() != null) {
            if (projeto.getProdutoouservico().verificaStatusProjeto(projeto.getProdutoouservico().getEstagioEvolucao()).equals("Outro:")) {
                selectedButton = "Outro";
                descricaoButtonOutro = projeto.getProdutoouservico().getEstagioEvolucao();
            } else {
                selectedButton = projeto.getProdutoouservico().getEstagioEvolucao();
            }
        }
    }

    /**
     * METODO VERIFICA QUAL O BOTÃO FOI SELECIONADO NO RADIO BUTTON DE ESTAGIO
     * DE EVOLUÇÃO APÓS VERIFICAR QUAL BOTÃO, SETA NO ESTAGIO DE VOLUÇÃO O VALOR
     * CORRESPONDENTE CASO FOI SELECIONADO O BOTÃO (OUTRO) ENTÃO É SALVO O VALOR
     * DO CAMPO (descricaoButtonOutro)
     */
    public void pegaValorDropDown() {
        switch (selectedButton) {
            case "Ideia Básica":
                projeto.getProdutoouservico().setEstagioEvolucao("Ideia Básica");
                descricaoButtonOutro = null;
                break;
            case "Projeto Básico":
                projeto.getProdutoouservico().setEstagioEvolucao("Projeto Básico");
                descricaoButtonOutro = null;
                break;
            case "Projeto Detalhado":
                projeto.getProdutoouservico().setEstagioEvolucao("Projeto Detalhado");
                descricaoButtonOutro = null;
                break;
            case "Protótipo Desenvolvido":
                projeto.getProdutoouservico().setEstagioEvolucao("Protótipo Desenvolvido");
                descricaoButtonOutro = null;
                break;
            case "Em teste no mercado":
                projeto.getProdutoouservico().setEstagioEvolucao("Em teste no mercado");
                descricaoButtonOutro = null;
                break;
            case "Clientes Pagando":
                projeto.getProdutoouservico().setEstagioEvolucao("Clientes Pagando");
                descricaoButtonOutro = null;
                break;
            default:
                projeto.getProdutoouservico().setEstagioEvolucao(descricaoButtonOutro);
                descricaoButtonOutro = getDescricaoButtonOutro();
                break;

        }
    }

    /**
     * Salva o projeto atual no banco de dados e na sessão.
     */
    public void salvarProjeto() {
        if (projeto.getNome() == null || projeto.getNome().equals("")) {
            projeto.setNome("Novo plano de negócio sem nome");
        }
        pegaValorDropDown();

        EnviaEmails(projeto);

        ProjetoDao daoProj = new ProjetoDao();
        projeto = daoProj.salvarRetornandoProjeto(projeto);
        atualizarProjetoSessao();
        salvou = true;
    }

    /**
     * Envia emails de termino de cadastro para os empreendedores necessários
     * dentro do projeto e atualiza os empreendedores.
     *
     * @param projeto Projeto que contém os empreendedores para se enviar os
     * emails
     */
    public void EnviaEmails(Projeto projeto) {
        Empreendedor empreendedor, empreendedorCadastrado;

        for (Object object : projeto.getEmpreendedores()) {
            empreendedor = (Empreendedor) object;
            empreendedorCadastrado = Empreendedor.buscaEmpreendedorID(empreendedor.getIdUnico());
            enviarEmailCadastro(empreendedor, projeto);
        }
    }

    /**
     * Envia um email para que o empreendedor possa terminar o seu cadastro.
     *
     * @param empreendedor Empreendedor para se colocar o IDUnico e enviar o
     * email.
     * @param projeto Projeto para se adicionar o empreendedor atualizado.
     */
    public void enviarEmailCadastro(Empreendedor empreendedor, Projeto projeto) {
        String idUnico;
        if (!Empreendedor.verificaDadosEmpreendedor(empreendedor)) {
            if (empreendedor.getIdUnico() == null) {
                idUnico = UUID.randomUUID().toString();
                EmailUtil.mandarEmailConcluirCadastro(empreendedorSession.getNome(), projeto.getNome(), empreendedor.getEmail(), idUnico);
                empreendedor.setIdUnico(idUnico);
                empreendedor.atualizarEmpreendedor(empreendedor);
            }
        }
    }

    /**
     * Retorna lista de emails de empreendedores cadastrados que começam com a
     * string passada.
     *
     * @param busca = string inicial a ser buscada
     * @return lista de emails que começam com a string busca
     */
    public List<String> sugerirEmpreendedorCadastrado(String busca) {
        List<String> listaFiltrada = new ArrayList<>();

        for (Empreendedor empreendedor : getListaEmpreendedor()) {
            if (empreendedor.getEmail().toLowerCase().startsWith(busca)) {
                listaFiltrada.add(empreendedor.getEmail());
            }
        }

        return listaFiltrada;
    }

    /**
     * Deletar empreendedor de um projeto desde que ele não seja o dono do mesmo
     *
     * @param empreendedorSelected
     */
    public void deletarEmpreendedor(Empreendedor empreendedorSelected) {

        HttpSession sessao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        Empreendedor empreendedor = (Empreendedor) sessao.getAttribute("empreendedor");
        if (!empreendedor.getEmail().equals(empreendedorSelected.getEmail())) {
            projeto.getEmpreendedores().remove(empreendedorSelected);
            //Percorre a lista achar o empreendedor selecionado e remove ele da lista de adicionados.
            for (int i = 0; i < empreedendoresAdicionados.size(); i++) {
                if (empreedendoresAdicionados.get(i).getEmail().equals(empreendedorSelected.getEmail())) {
                    empreedendoresAdicionados.remove(i);
                    break;
                }
            }
        }
    }

    /**
     * Adiciona o Empreendedor ao projeto.
     */
    public void adicionarEmpreendedor() {
        GerenteRelacionamento gerente = new GerenteRelacionamento();
        if (emailEmpreendedor.equals("")) {
            FacesUtil.addErrorMessage("Adicione um email válido para cadastrar um novo empreendedor", "formEquipe:autocomplete");
        } else if (gerente.buscarPorEmail(emailEmpreendedor) != null) {
            FacesUtil.addErrorMessage("Este usuário não está disponível para ser adicionado à sua equipe", "formEquipe:autocomplete");
        } else {

            boolean existe = false;
            Empreendedor empreendedorAchado = null;
            for (Empreendedor empreendedor : listaEmpreendedor) {
                if (empreendedor.getEmail().equals(emailEmpreendedor)) {
                    existe = true;
                    empreendedorAchado = empreendedor;
                    break;
                }
            }

            if (existe == false) {
                Empreendedor empreendedor = new Empreendedor();
                empreendedor.setEmail(emailEmpreendedor);
                empreendedorAchado = empreendedor;
            }
            if (!verificarLista(empreedendoresAdicionados, empreendedorAchado)) {
                if (!existe) {
                    empreendedorAchado.cadastrarEmpreendedor(empreendedorAchado);
                    empreendedorAchado = Empreendedor.buscaPorEmail(emailEmpreendedor);
                }
                empreedendoresAdicionados.add(empreendedorAchado);
                projeto.getEmpreendedores().add(empreendedorAchado);
            } else {
                FacesUtil.addErrorMessage("Empreendedor já adicionado", "formEquipe:autocomplete");
            }
        }
        //limpa o campo depois de dar refresh na página.        
        emailEmpreendedor = null;
    }

    /**
     * Verifica se o empreendedor disponibilizado está na lista.
     *
     * @param empreendedores
     * @param empreendedorAchado
     * @return True se ele está presente na lista. ou se já esta no projeto!
     */
    public boolean verificarLista(List<Empreendedor> empreendedores, Empreendedor empreendedorAchado) {
        for (Object emp : projeto.getEmpreendedores()) {
            Empreendedor empree = (Empreendedor) emp;
            if (empree.getEmail().equals(empreendedorAchado.getEmail())) {
                return true;
            }
        }
        for (Empreendedor empreendedore : empreendedores) {
            if (empreendedore.getEmail().equals(empreendedorAchado.getEmail())) {
                return true;
            }
        }
        return false;
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

    /**
     * @return the analiseEmprego
     */
    public Analiseemprego getAnaliseEmprego() {
        return analiseEmprego;
    }

    /**
     * @param analiseEmprego the analiseEmprego to set
     */
    public void setAnaliseEmprego(Analiseemprego analiseEmprego) {
        this.analiseEmprego = analiseEmprego;
    }

    /**
     * @return the negocio
     */
    public Negocio getNegocio() {
        return negocio;
    }

    /**
     * @param negocio the negocio to set
     */
    public void setNegocio(Negocio negocio) {
        this.negocio = negocio;
    }

    /**
     * @return the produtoOuSevico
     */
    public Produtoouservico getProdutoOuSevico() {
        return produtoOuSevico;
    }

    /**
     * @param produtoOuSevico the produtoOuSevico to set
     */
    public void setProdutoOuSevico(Produtoouservico produtoOuSevico) {
        this.produtoOuSevico = produtoOuSevico;
    }

    /**
     * @return the planoFinanceiro
     */
    public Planofinanceiro getPlanoFinanceiro() {
        return planoFinanceiro;
    }

    /**
     * @param planoFinanceiro the planoFinanceiro to set
     */
    public void setPlanoFinanceiro(Planofinanceiro planoFinanceiro) {
        this.planoFinanceiro = planoFinanceiro;
    }

    /**
     * @return the emailEmpreendedor
     */
    public String getEmailEmpreendedor() {
        return emailEmpreendedor;
    }

    /**
     * @param emailEmpreendedor the emailEmpreendedor to set
     */
    public void setEmailEmpreendedor(String emailEmpreendedor) {
        this.emailEmpreendedor = emailEmpreendedor;
    }

    /**
     * @return the listaEmpreendedor
     */
    public List<Empreendedor> getListaEmpreendedor() {
        return listaEmpreendedor;
    }

    /**
     * @param listaEmpreendedor the listaEmpreendedor to set
     */
    public void setListaEmpreendedor(List<Empreendedor> listaEmpreendedor) {
        this.listaEmpreendedor = listaEmpreendedor;
    }

    /**
     * @return the empreedendoresAdicionados
     */
    public List<Empreendedor> getEmpreedendoresAdicionados() {
        return empreedendoresAdicionados;
    }

    /**
     * @param empreedendoresAdicionados the empreedendoresAdicionados to set
     */
    public void setEmpreedendoresAdicionados(List<Empreendedor> empreedendoresAdicionados) {
        this.empreedendoresAdicionados = empreedendoresAdicionados;
    }

    /**
     * @return the empreendedorSelected
     */
    public Empreendedor getEmpreendedorSelected() {
        return empreendedorSelected;
    }

    /**
     * @param empreendedorSelected the empreendedorSelected to set
     */
    public void setEmpreendedorSelected(Empreendedor empreendedorSelected) {
        this.empreendedorSelected = empreendedorSelected;
    }

    /**
     * Cria um novo plano de negócio vazio e atribui à sessão.
     */
    public void criarObjetoPlano() {
        Projeto pjto = new Projeto();
        Analiseemprego analiseemprego = new Analiseemprego();
        Produtoouservico produtoouservico = new Produtoouservico();
        Negocio negocio = new Negocio();
        Planofinanceiro planofinanceiro = new Planofinanceiro();
        ProjetoDao daoP = new ProjetoDao();

        alocaCustosIniciais(planofinanceiro);

        pjto.setAnaliseemprego(analiseemprego);
        pjto.setNegocio(negocio);
        pjto.setPlanofinanceiro(planofinanceiro);
        pjto.setProdutoouservico(produtoouservico);
        pjto.getEmpreendedores().add(empreendedorSession);
        pjto.setEmpreendedorCorrespondente(empreendedorSession);
        pjto.setStatus(Projeto.DEFININDO_EQUIPE);

        /**
         * O EDITAL ESTA SENDO SETADO DIRETAMENTE EM LINHA DE CÓDIGO, POIS MUITO
         * RARAMENTE VAI SER ALTERADO
         */
        pjto.setEdital("2015abc123");
        Date data = new Date(System.currentTimeMillis());
        pjto.setDataCriacao(data);

        HttpSession secao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        empreendedorSession = Empreendedor.buscaPorEmail(empreendedorSession.getEmail());
        secao.setAttribute("empreendedor", empreendedorSession);
        secao.setAttribute("projetoSelecionado", pjto);
    }

    public void criarNovoPlano() {
        criarObjetoPlano();
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("enviarProjeto.jsf");
        } catch (IOException ex) {
            Logger.getLogger(ProjetoBean.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }

    }

    /**
     * <p>
     * Cria o objeto plano de negocio e redireciona para a pagina EnviarProjeto,
     * voltando uma pasta no projeto.</p>
     */
    public void criarNovoPlanoRevisar() {
        criarObjetoPlano();
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("../enviarProjeto.jsf");
        } catch (IOException ex) {
            Logger.getLogger(ProjetoBean.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }

    }

    /**
     * Cria os custos obrigatórios do empreendedor
     *
     * @param planofinanceiro
     */
    public void alocaCustosIniciais(Planofinanceiro planofinanceiro) {
        Custo prolabore = new Custo(planofinanceiro);
        Custo aluguel = new Custo(planofinanceiro);

        prolabore.setDescricao("Prolabore");
        prolabore.setPodeExcluir(false);
        prolabore.setProjecao(0);
        prolabore.setTipo(Custo.CUSTO_FIXO);
        prolabore.setTotal(0);
        planofinanceiro.getCusto().add(prolabore);

        aluguel.setDescricao("Aluguel com o Pampatec");
        aluguel.setPodeExcluir(false);
        aluguel.setProjecao(270);
        aluguel.setTipo(Custo.CUSTO_FIXO);
        aluguel.setTotal(45);
        planofinanceiro.getCusto().add(aluguel);

    }

    /**
     * Verifica se o empreendedor tem projetos cadastrados.
     *
     * @return true se o empreendedor não tem projetos cadastrados.
     */
    public boolean verificaCadastroProjeto() {
        Empreendedor emp;
        emp = (Empreendedor) SessionManager.getAttribute("empreendedor");

        EmpreendedorDao empreendedorDao = new EmpreendedorDao();
        emp = empreendedorDao.buscar(emp.getIdUsuario());

        return emp.getProjetos().isEmpty();
    }

    /**
     * Método verifica se todos os campos do formulario de cadastro de projeto
     * estão preenchidos.
     *
     * @return true se todos os campos do formulario estao preenchidos.
     * @since 21/09/2015
     */
    public int verificarCampos() {
        int FLAG = 0;
        if (projeto.getNome().trim().isEmpty()) {
            FacesUtil.addErrorMessage("Campo não pode estar vazio", "formulario_cadastro_projeto:empresaProjeto");
            FLAG = FLAG + 1;
        }
        if (projeto.getNegocio().getSegmentoClientes().trim().isEmpty()) {
            FacesUtil.addErrorMessage("Campo não pode estar vazio", "formulario_cadastro_projeto:segmentoDeClientes");
            FLAG = FLAG + 1;
        }
        if (projeto.getNegocio().getPropostaValor().trim().isEmpty()) {
            FacesUtil.addErrorMessage("Campo não pode estar vazio", "formulario_cadastro_projeto:propostaDeValor");
            FLAG = FLAG + 1;
        }
        if (projeto.getNegocio().getAtividadesChaves().trim().isEmpty()) {
            FacesUtil.addErrorMessage("Campo não pode estar vazio", "formulario_cadastro_projeto:atividadesChave");
            FLAG = FLAG + 1;
        }
        if (projeto.getAnaliseemprego().getRelacoesClientes().trim().isEmpty()) {
            FacesUtil.addErrorMessage("Campo não pode estar vazio", "formulario_cadastro_projeto:relacoComClientes");
            FLAG = FLAG + 1;
        }
        if (projeto.getAnaliseemprego().getParceriasChaves().trim().isEmpty()) {
            FacesUtil.addErrorMessage("Campo não pode estar vazio", "formulario_cadastro_projeto:parceriasChaves");
            FLAG = FLAG + 1;
        }
        if (projeto.getAnaliseemprego().getCanais().trim().isEmpty()) {
            FacesUtil.addErrorMessage("Campo não pode estar vazio", "formulario_cadastro_projeto:canais");
            FLAG = FLAG + 1;
        }
        if (projeto.getAnaliseemprego().getRecursosPrincipais().trim().isEmpty()) {
            FacesUtil.addErrorMessage("Campo não pode estar vazio", "formulario_cadastro_projeto:recursosPrincipais");
            FLAG = FLAG + 1;
        }
        if (projeto.getAnaliseemprego().getConcorrentes().trim().isEmpty()) {
            FacesUtil.addErrorMessage("Campo não pode estar vazio", "formulario_cadastro_projeto:concorrentes");
            FLAG = FLAG + 1;
        }
        /*
         if (selectedButton.equals("Outro:") && descricaoButtonOutro.trim().isEmpty()) {
         FacesUtil.addErrorMessage("Se a opção selecionada for (Outro) então o campo acima não pode estar vazio", "formulario_cadastro_projeto:descricaoOutroEstagio");
         FLAG = FLAG + 1;
         }*/
        if (projeto.getProdutoouservico().getTecnologiaProcessos().trim().isEmpty()) {
            FacesUtil.addErrorMessage("Campo não pode estar vazio", "formulario_cadastro_projeto:tecnologiaProcessos");
            FLAG = FLAG + 1;
        }
        if (projeto.getProdutoouservico().getPotencialInovacaoTecnologica().trim().isEmpty()) {
            FacesUtil.addErrorMessage("Campo não pode estar vazio", "formulario_cadastro_projeto:potencialInovacaoTecnologica");
            FLAG = FLAG + 1;
        }
        if (projeto.getProdutoouservico().getAplicacoes().trim().isEmpty()) {
            FacesUtil.addErrorMessage("Campo não pode estar vazio", "formulario_cadastro_projeto:aplicacoes");
            FLAG = FLAG + 1;
        }
        if (projeto.getProdutoouservico().getDificuldadesEsperadas().trim().isEmpty()) {
            FacesUtil.addErrorMessage("Campo não pode estar vazio", "formulario_cadastro_projeto:dificuldadesEsperadas");
            FLAG = FLAG + 1;
        }
        if (projeto.getProdutoouservico().getInteracaoEmpresaUniversidade().trim().isEmpty()) {
            FacesUtil.addErrorMessage("Campo não pode estar vazio", "formulario_cadastro_projeto:interacaoEmpresaUniversidade");
            FLAG = FLAG + 1;
        }
        if (projeto.getProdutoouservico().getInteracaoEmpresaComunidadeGoverno().trim().isEmpty()) {
            FacesUtil.addErrorMessage("Campo não pode estar vazio", "formulario_cadastro_projeto:interacaoEmpresaComunidadeGoverno");
            FLAG = FLAG + 1;
        }
        if (projeto.getProdutoouservico().getInfraestrutura().trim().isEmpty()) {
            FacesUtil.addErrorMessage("Campo não pode estar vazio", "formulario_cadastro_projeto:infraestrutura");
            FLAG = FLAG + 1;
        }
        if (projeto.getParticipacaoacionaria().trim().isEmpty()) {
            FacesUtil.addErrorMessage("Campo não pode estar vazio", "formulario_cadastro_projeto:participacaoAcionaria");
            FLAG = FLAG + 1;
        }
        if (projeto.getPotencialEmprego().trim().isEmpty()) {
            FacesUtil.addErrorMessage("Campo não pode estar vazio", "formulario_cadastro_projeto:potencialEmprego");
            FLAG = FLAG + 1;
        }
        if (projeto.getPlanofinanceiro().getFontesReceita().trim().isEmpty()) {
            FacesUtil.addErrorMessage("Campo não pode estar vazio", "formulario_cadastro_projeto:fontesDeReceita");
            FLAG = FLAG + 1;
        }
        if (projeto.getPlanofinanceiro().getEstruturaCusto().trim().isEmpty()) {
            FacesUtil.addErrorMessage("Campo não pode estar vazio", "formulario_cadastro_projeto:estruturaCustos");
            FLAG = FLAG + 1;
        }
        if (projeto.getPlanofinanceiro().getInvestimentoInicial().trim().isEmpty()) {
            FacesUtil.addErrorMessage("Campo não pode estar vazio", "formulario_cadastro_projeto:investimentoInicial");
            FLAG = FLAG + 1;
        }
//        if (listaCustoFixo.isEmpty()) {
//            FacesUtil.addErrorMessage("A lista de custos fixos não pode estar vazia", "formulario_cadastro_projeto:nomeCustoFixo");
//            FLAG = FLAG + 1;
//        }
//        if (listaCustoVariavel.isEmpty()) {
//            FacesUtil.addErrorMessage("A lista de custos variáveis não pode estar vazia", "formulario_cadastro_projeto:nomeCustoVariavel");
//            FLAG = FLAG + 1;
//        }

        return FLAG;
    }

    /**
     * Envia o projeto para a pré-avaliação. Atualiza status, salva projeto
     * base.
     */
    public void enviarProjeto() {
        int FLAG = verificarCampos();
        int FLAG_STATUS = 0;

        if (FLAG > 0) {
            FacesUtil.addErrorMessage("  O Sistema encontrou " + FLAG + " campos não preenchidos.",
                    "formulario_cadastro_projeto:tituloMensagem");
        } else {
            try {

                HttpSession secao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
                Empreendedor emp = (Empreendedor) secao.getAttribute("empreendedor");

                if (projeto.getStatus() == Empreendedor.ENVIADO) {
                    FacesContext.getCurrentInstance().getExternalContext().redirect("paginaBuscaProjeto.jsf");
                } else {
                    salvarProjeto();
                    if (emp.enviarProjeto(projeto) == Empreendedor.ENVIADO) {
                        atualizarProjetoSessao();
                        // ENVIA EMAIL PARA GERENTES APÓS SUBMETER O PLANO
                        EmailManager.enviaEmailParaGerentes(projeto);
//                        TRECHO PARA EXIBIR A MENSAGEM DE CONFIRMAÇÃO À SUBMISSÃO DO PROJETO.                        
                        FacesMessage msg;
                        msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Plano de Negócio enviado!", "Seu plano de negócio foi enviado com sucesso. Aguarde o resultado!");
                        FacesContext.getCurrentInstance().addMessage("formulario_cadastro_projeto:mensagensFeed", msg);

                    } else {

                        FacesUtil.addErrorMessage("Ainda há Empreendedores que precisam terminar o cadastro no sistema.",
                                "formulario_cadastro_projeto:tituloMensagem");
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Origem: " + this.getClass().getName() + ":: \t Erro: " + e);
            }
        }
    }

    /**
     * @return the selectedButton
     */
    public String getSelectedButton() {
        return selectedButton;
    }

    /**
     * @param selectedButton the selectedButton to set
     */
    public void setSelectedButton(String selectedButton) {
        this.selectedButton = selectedButton;
    }

    /**
     * @return the descricaoButtonOutro
     */
    public String getDescricaoButtonOutro() {
        return descricaoButtonOutro;
    }

    /**
     * @param descricaoButtonOutro the descricaoButtonOutro to set
     */
    public void setDescricaoButtonOutro(String descricaoButtonOutro) {
        this.descricaoButtonOutro = descricaoButtonOutro;
        this.selectedButton = descricaoButtonOutro;
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

    /**
     * Método para adicionar custo fixo ao projeto e à tabela.
     */
    public void adicionarLinhaFixo() {
        Custo custo = new Custo();
        int zero = 0;
        custo.setDescricao("Novo Custo");
        custo.setTipo(Custo.CUSTO_FIXO);
        custo.setTotal(zero);
        custo.setProjecao(zero);
        custo.setPodeExcluir(true);
        projeto.getPlanofinanceiro().getCusto().add(custo);
        custo.setPlanofinanceiro(projeto.getPlanofinanceiro());
        salvarProjeto();
        preencheListaCusto();
    }

    public String getNomeCustoFixo() {
        return nomeCustoFixo;
    }

    public void setNomeCustoFixo(String nomeCustoFixo) {
        this.nomeCustoFixo = nomeCustoFixo;
    }

    public float getValorCustoFixo() {
        return valorCustoFixo;
    }

    public void setValorCustoFixo(float valorCustoFixo) {
        this.valorCustoFixo = valorCustoFixo;
    }

    public String getNomeCustoVariavel() {
        return nomeCustoVariavel;
    }

    public void setNomeCustoVariavel(String nomeCustoVariavel) {
        this.nomeCustoVariavel = nomeCustoVariavel;
    }

    public float getValorCustoVariavel() {
        return valorCustoVariavel;
    }

    public void setValorCustoVariavel(float valorCustoVariavel) {
        this.valorCustoVariavel = valorCustoVariavel;
    }

    /**
     * filtra lista de custos por tipo, seguindo constantes definidas na classe
     * Custo: FIXO ou VARIAVEL
     *
     * @param listaCompleta
     * @param tipo
     * @return novaLista
     */
    public ArrayList<Custo> filtraCustoPorTipo(ArrayList<Custo> listaCompleta, int tipo) {
        ArrayList<Custo> novaLista = new ArrayList<>();
        for (Custo custoSelecionado : listaCompleta) {
            if (custoSelecionado.getTipo() == tipo) {
                novaLista.add(custoSelecionado);
            }
        }
        return novaLista;
    }

    /**
     * Converte os registros do setCusto em um arraylist
     *
     * @param setCusto
     * @return arrayCusto
     */
    public ArrayList<Custo> converteSetParaArrayListdeCusto(Set<Custo> setCusto) {
        ArrayList<Custo> arrayCusto = new ArrayList<>();
        for (Custo custoSet : setCusto) {
            arrayCusto.add(custoSet);
        }
        return arrayCusto;
    }

    /**
     * Verifica se o empreendedor logado é o empreendedor correspondente desse
     * projeto.
     *
     * @return true se ele é correspondente.
     */
    public boolean verificarEmpreendedor() {
        HttpSession secao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        Empreendedor empreendedor = (Empreendedor) secao.getAttribute("empreendedor");
        projeto = (Projeto) secao.getAttribute("projetoSelecionado");
        return empreendedor.verificaTipoEmpreendedor(projeto.getEmpreendedorCorrespondente());
    }

    /**
     * Verifica se o empreendedor disponibilizado é o empreendedor
     * correspondente desse projeto.
     *
     * @param empreendedor empreendedor para se verificar.
     * @return true se ele é correspondente.
     */
    public boolean verificarEmpreendedor(Empreendedor empreendedor) {
        return empreendedor.verificaTipoEmpreendedor(projeto.getEmpreendedorCorrespondente());
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

    /**
     * Remove custo fixo da tabela e do projeto
     *
     * @param custoFixo
     */
    public void deletarCustoFixo(Custo custoFixo) {
        ProjetoDao daoProj = new ProjetoDao();
        listaCustoFixo.remove(custoFixo);
        empreendedorSession.removeCustoProjeto(custoFixo);
        projeto = daoProj.buscar(projeto.getIdProjeto());
        atualizarProjetoSessao();
        preencheListaCusto();
    }

    /**
     * Remove custo variavel da tabela e do projeto
     *
     * @param custoVariavel
     */
    public void deletarCustoVariavel(Custo custoVariavel) {
        ProjetoDao daoProj = new ProjetoDao();
        listaCustoVariavel.remove(custoVariavel);
        empreendedorSession.removeCustoProjeto(custoVariavel);
        projeto = daoProj.buscar(projeto.getIdProjeto());
        atualizarProjetoSessao();
        preencheListaCusto();
    }

    public Custo getcustoFixoSelecionado() {
        return custoFixoSelecionado;
    }

    public void setCustoFixoSelecionado(Custo custoFixoSelecionado) {
        this.custoFixoSelecionado = custoFixoSelecionado;
    }

    public Custo getCustoVariavelSelecionado() {
        return custoVariavelSelecionado;
    }

    public void setCustoVariavelSelecionado(Custo custoVariavelSelecionado) {
        this.custoVariavelSelecionado = custoVariavelSelecionado;
    }

    /**
     * Verifica se o status do projeto não é DEFININDO_EQUIPE ou ELABORACAO
     *
     * @return true se for outro status
     */
    public boolean verificaElaboracao() {
        if (projeto.getStatus() == Projeto.DEFININDO_EQUIPE) {
            return false;
        } else if (projeto.getStatus() == Projeto.ELABORACAO) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Atualiza o status do projeto para "EM ELABORAÇÃO" e salva o projeto.
     */
    public void atualizaStatus() {
        projeto.setStatus(Projeto.ELABORACAO);
        salvarProjeto();

    }

    /**
     * Exibe o campo de texto para inserir conteúdo referente a opção OUTRO no
     * estado do negócio
     *
     * @return true se o usuário clicar no checkbox "Outro"
     */
    public boolean exibeCampo() {
        return selectedButton != null && selectedButton.equals("Outro");
    }

    /**
     * Deleta registro na tabela.
     *
     * @param custo
     */
    public void deletarLinha(Custo custo) {
        FacesMessage msg;
        if (custo.getTipo() == Custo.CUSTO_FIXO) {
            deletarCustoFixo(custo);
            calcularValorColunaCustoFixo();
            msg = new FacesMessage("Custo fixo DELETADO");
            FacesContext.getCurrentInstance().addMessage("formulario_cadastro_projeto:mensagensFeed", msg);
        }
        if (custo.getTipo() == Custo.CUSTO_VARIAVEL) {
            deletarCustoVariavel(custo);
            calcularValorColunaCustoVariavel();
            msg = new FacesMessage("Custo variavel DELETADO");
            FacesContext.getCurrentInstance().addMessage("formulario_cadastro_projeto:mensagensFeed", msg);
        }
        projeto.SalvarProjetoExistente(projeto);

    }

    /**
     * *
     * Método para ação após linha ser editada, atualizando valores na tabela.
     *
     * @param event
     */
    public void onRowEdit(RowEditEvent event) {
        FacesMessage msg;
        Custo custo = (Custo) event.getObject();

        msg = new FacesMessage("Custo Editado", custo.getDescricao());
        FacesContext.getCurrentInstance().addMessage("formulario_cadastro_projeto:mensagensFeed", msg);

        calcularValorColunaCustoVariavel();
        calcularValorColunaCustoFixo();

        ProjetoDao projetoDao = new ProjetoDao();
        projetoDao.salvar(custo);

    }

    /**
     * Método que cancela edição da linha na tabela.
     *
     * @param event
     */
    public void onRowCancel(RowEditEvent event) {

        FacesMessage msg = new FacesMessage("Edição Cancelada", ((Custo) event.getObject()).getDescricao());
        FacesContext.getCurrentInstance().addMessage(null, msg);

    }

    public void onCellEdit(CellEditEvent event) {

    }

    /**
     * metodo que faz o calculo da projecao de cada custo variavel para seis
     * meses
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

    /**
     * metodo que faz o calculo da projecao de cada custo fixo para seis meses
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
     * Metodo que soma os valores de cada custo variavel adicionados na tabela e
     * faz a projeção para seis meses.
     *
     * @return
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
     * Metodo que soma os valores de cada custo fixo adicionados na tabela e faz
     * a projeção para seis meses.
     *
     * @return somatorioFixo
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
     * Método para adicionar custo variável a tabela.
     */
    public void adicionarLinhaVariavel() {
        Custo custo = new Custo();
        int zero = 0;
        custo.setDescricao("Novo Custo");
        custo.setTipo(Custo.CUSTO_VARIAVEL);
        custo.setTotal(zero);
        custo.setProjecao(zero);
        custo.setPodeExcluir(true);
        projeto.getPlanofinanceiro().getCusto().add(custo);
        custo.setPlanofinanceiro(projeto.getPlanofinanceiro());
        salvarProjeto();
        preencheListaCusto();
    }

    /**
     * @return the somatorioVariavel
     */
    public float getSomatorioVariavel() {
        return somatorioVariavel;
    }

    /**
     * @param somatorioVariavel the somatorioVariavel to set
     */
    public void setSomatorioVariavel(int somatorioVariavel) {
        this.somatorioVariavel = somatorioVariavel;
    }

    public List<Projeto> getListaProjetoFiltradaPorBase() {
        return listaProjetoFiltradaPorBase;
    }

    public void setListaProjetoFiltradaPorBase(List<Projeto> listaProjetoFiltradaPorBase) {
        this.listaProjetoFiltradaPorBase = listaProjetoFiltradaPorBase;
    }

    /**
     * Retorna o projeto da sessão, garantindo que ele está atualizado com o
     * servidor.
     *
     * @return projeto da sessão
     */
    public int retornaStatusProjeto() {
        HttpSession secao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        projeto = (Projeto) secao.getAttribute("projetoSelecionado");
        return projeto.getStatus();
    }

    public List<Custo> retornaListaCustoFixo() {
        preencheListaCusto();
        return listaCustoFixo;
    }

    public List<Custo> retornaListaCustoVariavel() {
        preencheListaCusto();
        return listaCustoVariavel;
    }

    public String retornaSelectedButton() {
        if (projeto.getProdutoouservico().verificaStatusProjeto(projeto.getProdutoouservico().getEstagioEvolucao()).equals("Outro:")) {
            selectedButton = projeto.getProdutoouservico().verificaStatusProjeto(projeto.getProdutoouservico().getEstagioEvolucao());
            descricaoButtonOutro = projeto.getProdutoouservico().getEstagioEvolucao();
        } else {
            selectedButton = projeto.getProdutoouservico().verificaStatusProjeto(projeto.getProdutoouservico().getEstagioEvolucao());
        }
        return selectedButton;
    }

    /**
     * Verifica se o empreendedor detalhou seu cadastro, com formação e
     * antecedentes, se não tiver escrito nada ele retorna campo nao
     * expecificado
     *
     * @param detalhe
     * @return
     */
    public String verificaTextoDetalhesEmpreendedor(String detalhe) {

        if (detalhe == null) {
            return "Campo não expecificado";
        } else if (detalhe.trim().isEmpty()) {
            return "Campo não expecificado";
        } else {
            return detalhe;
        }
    }
}
