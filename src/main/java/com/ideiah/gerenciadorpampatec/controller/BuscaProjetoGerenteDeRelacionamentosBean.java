/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.controller;

import com.ideiah.gerenciadorpampatec.dao.ProjetoDao;
import com.ideiah.gerenciadorpampatec.model.Projeto;
import com.ideiah.gerenciadorpampatec.util.ComparadorAvaliacaoUtil;
import com.ideiah.gerenciadorpampatec.util.ComparadorEnvioUtil;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.Application;
import javax.faces.application.ViewHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Edison Moura
 */
@ManagedBean(name = "buscaProjetoGerenteDeRelacionamentosBean")
@ViewScoped
public class BuscaProjetoGerenteDeRelacionamentosBean implements Serializable {

    private ArrayList<Projeto> listaProjetos;
    private ArrayList<String> listaStatusProjeto;
    private Projeto projetoSelecionado;
    private ProjetoDao projetoDao;
    private ProjetoBean projetoBean;
    private boolean testeBoolean = false;
    private int filtrarPor;
    private final int TODOS = 1;
    private final int PRE_AVALIACAO = 2;
    private final int MELHORIA = 3;
    private final int APROVADOS = 4;
    private final int REPROVADOS = 5;
    private String campoProcurar;

    public BuscaProjetoGerenteDeRelacionamentosBean() {
        projetoDao = new ProjetoDao();
        this.atualizaListaProjetosTodos();
        listaStatusProjeto = new ArrayList<>();

        //Adicionando os Status para o Filtro na tabela
        listaStatusProjeto.add("Sendo Avaliado");
        listaStatusProjeto.add("Submetido");
        listaStatusProjeto.add("Ressubmetido");
        listaStatusProjeto.add("Em Pré-Avaliação");
        listaStatusProjeto.add("Necessita Melhoria");
        listaStatusProjeto.add("Aceito para Avaliação");
        listaStatusProjeto.add("Em Formalização");
        listaStatusProjeto.add("Incubação");
        listaStatusProjeto.add("Reprovado");
    }

    public void setListaProjetos(ArrayList<Projeto> listaProjetos) {
        sortByDate(listaProjetos);
        this.listaProjetos = listaProjetos;
    }

    public ArrayList<Projeto> getListaProjetos() {
        return listaProjetos;
    }

    public Projeto getProjetoSelecionado() {
        return projetoSelecionado;
    }

    /**
     * Atualiza lista de projeto para projetos que podem ou estão sendo
     * avaliados.
     */
    public void atualizaListaProjetosPreAvaliacao() {
        filtrarPor = PRE_AVALIACAO;
        campoProcurar = "";
        this.setListaProjetos(buscaProjetoPorStatusPreAvaliacao());

    }

    /**
     * Método utilizado para verificar quais os tipos de projeto devem ser
     * retornados para lista.
     */
    public void atualizaListaProjetosPreAvaliacaoFLAG() {

        switch (filtrarPor) {
            case TODOS:
                this.setListaProjetos(buscaProjetoPorStatusTodos());
                break;
            case PRE_AVALIACAO:
                this.setListaProjetos(buscaProjetoPorStatusPreAvaliacao());
                break;
            case MELHORIA:
                this.setListaProjetos(buscaProjetoPorStatusMelhoria());
                break;
            case REPROVADOS:
                this.setListaProjetos(buscaProjetoPorStatusReprovado());
                break;
            case APROVADOS:
                this.setListaProjetos(buscaProjetoPorStatusAprovado());
                break;
        }
    }

    /**
     * Atualiza lista de projeto para projetos que não estão em elaboração
     */
    public void atualizaListaProjetosTodos() {
        filtrarPor = TODOS;
        campoProcurar = "";
        this.setListaProjetos(buscaProjetoPorStatusTodos());
    }

    /**
     * Atualiza lista de projeto para projetos aprovados.
     */
    public void atualizaListaProjetosAprovados() {
        filtrarPor = APROVADOS;
        campoProcurar = "";
        this.setListaProjetos(buscaProjetoPorStatusAprovado());
    }

    /**
     * Atualiza lista de projeto para projetos Reprovados
     */
    public void atualizaListaProjetosReprovados() {
        filtrarPor = REPROVADOS;
        campoProcurar = "";
        this.setListaProjetos(buscaProjetoPorStatusReprovado());
    }

    /**
     * Atualiza lista de projeto para projetos em melhoria
     */
    public void atualizaListaProjetosnelhoria() {
        filtrarPor = MELHORIA;
        campoProcurar = "";
        this.setListaProjetos(buscaProjetoPorStatusMelhoria());
    }

    /**
     *
     * @return Lista de projetos com o status igual à 1 (EM_PRE_AVALIAÇÃO) e 10
     * (SENDO AVALIADO)
     */
    public ArrayList<Projeto> buscaProjetoPorStatusPreAvaliacao() {
        projetoDao = new ProjetoDao();
        ArrayList<Projeto> listaProjetosPorStatus = projetoDao.buscarListaProjetoPorStatus(Projeto.SUBMETIDO);
        ArrayList<Projeto> listaProjetosResubmetidos = projetoDao.buscarListaProjetoPorStatus(Projeto.RESUBMETIDO);
        ArrayList<Projeto> listaProjetosEmPreAvaliacao = projetoDao.buscarListaProjetoPorStatus(Projeto.EM_PRE_AVALIACAO);
        ArrayList<Projeto> listaProjetosSendoAvaliado = projetoDao.buscarListaProjetoPorStatus(Projeto.SENDO_AVALIADO);

        for (Projeto projeto : listaProjetosSendoAvaliado) {
            listaProjetosPorStatus.add(projeto);
        }
        for (Projeto projeto : listaProjetosResubmetidos) {
            listaProjetosPorStatus.add(projeto);
        }
        for (Projeto projeto : listaProjetosEmPreAvaliacao) {
            listaProjetosPorStatus.add(projeto);
        }
        return listaProjetosPorStatus;
    }

    /**
     *
     * @return Lista de todos projetos Aprovados
     */
    public ArrayList<Projeto> buscaProjetoPorStatusAprovado() {
        return projetoDao.buscarListaProjetoPorStatus(Projeto.ACEITO_PARA_AVALIACAO);
    }

    /**
     *
     * @return Lista de todos projetos Reprovados
     */
    public ArrayList<Projeto> buscaProjetoPorStatusReprovado() {
        return projetoDao.buscarListaProjetoPorStatus(Projeto.REPROVADO);
    }

    /**
     *
     * @return Lista de todos projetos em Melhoria
     */
    public ArrayList<Projeto> buscaProjetoPorStatusMelhoria() {
        return projetoDao.buscarListaProjetoPorStatus(Projeto.NECESSITA_MELHORIA);
    }

    private ArrayList<Projeto> buscaTodosProjetos() {
        projetoDao = new ProjetoDao();
        return projetoDao.buscar();
    }

    /**
     *
     * @return Lista de todos projetos menos os que estão em elaboração
     */
    public ArrayList<Projeto> buscaProjetoPorStatusTodos() {

        ArrayList<Projeto> listaProjetosMenosElaboracao = new ArrayList<>();
        for (Projeto projeto : this.buscaTodosProjetos()) {
            if (projeto.getStatus() != 0) {
                listaProjetosMenosElaboracao.add(projeto);
            }
        }

        return listaProjetosMenosElaboracao;
    }

    /**
     * Atualiza o status do projeto base para SENDO_AVALIADO caso esteja sendo
     * avaliado ou SUBMETIDO caso a avaliação seja interrompida
     *
     * @param projeto
     */
    public void atualizaStatusProjeto(Projeto projeto) {
        if (projeto.getStatus() == Projeto.SUBMETIDO) {
            projeto.setStatus(Projeto.SENDO_AVALIADO);
        }

        projetoDao.salvar(projeto);

        atualizarProjetoSessao();
        listaProjetos = buscaProjetoPorStatusPreAvaliacao();
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("buscarPlanoDeNegocio.jsf");
        } catch (IOException ex) {
            Logger.getLogger(ProjetoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Atualiza o projeto que está na sessão.
     */
    public void atualizarProjetoSessao() {
        HttpSession secao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        secao.setAttribute("projetoSelecionado", projetoSelecionado);
    }

    /**
     * Atualiza a página que chamar esse método. Para que o método seja chamado
     * repetidas vezes, quando uma atualização da página de forma periódica for
     * necessária, basta chama-lo no listener de um componente p:poll. Fica a
     * sugestão.
     */
    public void refresh() {
        FacesContext context = FacesContext.getCurrentInstance();
        Application application = context.getApplication();
        ViewHandler viewHandler = application.getViewHandler();
        UIViewRoot viewRoot = viewHandler.createView(context, context.getViewRoot().getViewId());
        context.setViewRoot(viewRoot);
        context.renderResponse();
    }

    /**
     * @return the testeBoolean
     */
    public boolean isTesteBoolean() {
        return testeBoolean;
    }

    /**
     * @param testeBoolean the testeBoolean to set
     */
    public void setTesteBoolean(boolean testeBoolean) {
        this.testeBoolean = testeBoolean;
    }

    /**
     * Verifica se o projeto está em pré avaliação e retorna true se sim.
     *
     * @param projeto
     * @return
     */
    public boolean verificaStatusProjeto(Projeto projeto) {
        return (projeto.getStatus() == Projeto.SUBMETIDO)
                || (projeto.getStatus() == Projeto.RESUBMETIDO)
                || (projeto.getStatus() == Projeto.EM_PRE_AVALIACAO);
    }

    /**
     * Verifica se o projeto está sendo avaliado e retorna true se sim.
     *
     * @param projeto
     * @return
     */
    public boolean verificaStatusProjetoSendoAvaliado(Projeto projeto) {
        return projeto.getStatus() == Projeto.SENDO_AVALIADO;
    }

    /**
     * Verifica se o projeto não esta sendo avaliado nem em pré-avaliação e
     * retorna true se sim.
     *
     * @param projeto
     * @return
     */
    public boolean verificaStatusProjetoRestantes(Projeto projeto) {
        return projeto.getStatus() != Projeto.SENDO_AVALIADO
                && projeto.getStatus() != Projeto.SUBMETIDO
                && projeto.getStatus() != Projeto.RESUBMETIDO
                && projeto.getStatus() != Projeto.EM_PRE_AVALIACAO;
    }

    public void atualizaListaDeProjetos() {
        listaProjetos = buscaProjetoPorStatusPreAvaliacao();
    }

    /**
     * <p>
     * Método que muda o status do projeto, atualizar essa informação no banco e
     * chama o método para redirecionar para a página de pré-avaliação do
     * pré-projeto selecionado.</p>
     *
     * @param projSelec
     */
    public void enviarPreAvaliacaoPreProjeto(Projeto projSelec) {
        /**
         * Gambiarra para resolver o problema do Ajax+Filtro.
         */
        if (projSelec != null) {
            ProjetoDao dao = new ProjetoDao();
            /**
             * Nesse if de baixo ele garante que 2 gerentes não poderão avaliar
             * o mesmo plano ao mesmo tempo.PS: Somente se eles clicarem para
             * avaliar no mesmo tempo, bem no mesmo tempo, tipo juntos, se tiver
             * diferença de meio segundo já não cai no if de baixo.
             *
             */
            if (dao.buscar(projSelec.getIdProjeto()).getStatus() != Projeto.SENDO_AVALIADO) {
                projSelec.setStatus(Projeto.SENDO_AVALIADO);
                dao.update(projSelec);
                HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
                session.setAttribute("projetoSelecionado", projSelec);
                getPreAvaliarProjeto();
            } else {
                try {
                    FacesContext.getCurrentInstance().getExternalContext().redirect("buscarPlanoDeNegocio.jsf");
                } catch (Exception e) {
                    Logger.getLogger(PreAvaliarPlanoBean.class.getName()).log(Level.SEVERE, null, e);
                }
            }

        }
    }

    /**
     * Redireciona para a página de Pre-Avaliação do Pré-Projeto.
     */
    private void getPreAvaliarProjeto() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("preAvaliarPlanoDeNegocio.jsf");
        } catch (Exception e) {
            Logger.getLogger(PreAvaliarPlanoBean.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * <p>
     * Usa a classe Collection pra arrumar a lista por ordem de alteração e
     * envio, com o mais novo alterado em cima, seguido dos mais novos enviados.
     * A lista é reordenada separadamente e reordenada
     *
     * @param lista Não retorna lista, ele ordena dentro dela mesma.
     * </p>
     */
    public void sortByDate(ArrayList<Projeto> lista) {

        ArrayList<Projeto> avaliados = new ArrayList();
        ArrayList<Projeto> naoavaliados = new ArrayList();

        for (Projeto plano : lista) {
            if (plano.getDataAvaliacao() == null) {
                naoavaliados.add(plano);
            } else {
                avaliados.add(plano);
            }
        }

        Collections.sort(naoavaliados, new ComparadorEnvioUtil());
        Collections.reverse(naoavaliados);

        Collections.sort(avaliados, new ComparadorAvaliacaoUtil());
        Collections.reverse(avaliados);

        lista.clear();

        lista.addAll(avaliados);
        lista.addAll(naoavaliados);

    }

    /**
     * @return the campoProcurar
     */
    public String getCampoProcurar() {
        return campoProcurar;
    }

    /**
     * @param campoProcurar the campoProcurar to set
     */
    public void setCampoProcurar(String campoProcurar) {
        this.campoProcurar = campoProcurar;
    }

    /**
     * @return the listaStatusProjeto
     */
    public ArrayList<String> getListaStatusProjeto() {
        return listaStatusProjeto;
    }

    /**
     * @param listaStatusProjeto the listaStatusProjeto to set
     */
    public void setListaStatusProjeto(ArrayList<String> listaStatusProjeto) {
        this.listaStatusProjeto = listaStatusProjeto;
    }
}
