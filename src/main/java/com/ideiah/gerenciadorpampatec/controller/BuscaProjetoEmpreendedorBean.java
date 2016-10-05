package com.ideiah.gerenciadorpampatec.controller;

import com.ideiah.gerenciadorpampatec.dao.ProjetoDao;
import com.ideiah.gerenciadorpampatec.model.Empreendedor;
import com.ideiah.gerenciadorpampatec.model.Projeto;
import com.ideiah.gerenciadorpampatec.util.ComparadorCriacaoUtil;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean(name = "buscaProjetoEmpreendedorBean")
@ViewScoped
public class BuscaProjetoEmpreendedorBean implements Serializable {

    private ArrayList<Projeto> listaProjetos;//Lista de projetos exibidos
    private ArrayList<String> listaStatusProjeto; //Lista de Status de projetos exibidos
    private ProjetoDao projetoDao;//Dao para acessar o banco de dados
    private Projeto projetoSelecionado;//Projeto que foi selecionado quando um usuário escolhe algum item da lista.

    public BuscaProjetoEmpreendedorBean() {
        projetoDao = new ProjetoDao();
        listaProjetos = buscaProjetoPorEmpreendedor();
        listaStatusProjeto = new ArrayList<>();
    
        //Adicionando os Status para o Filtro na tabela
        listaStatusProjeto.add("Em elaboração");
        listaStatusProjeto.add("Em pré-avaliação");
        listaStatusProjeto.add("Necessita melhoria");
        listaStatusProjeto.add("Aceito para avaliação");
        listaStatusProjeto.add("Em formalização");
        listaStatusProjeto.add("Incubação");
        listaStatusProjeto.add("Reprovado");

        sortByDateCriacao(listaProjetos);
    }
    
    public void setListaProjetos(ArrayList<Projeto> listaProjetos) {

        this.listaProjetos = sortByDateCriacao(listaProjetos);
    }

    public ArrayList<Projeto> getListaProjetos() {
        return listaProjetos;
    }

    public Projeto getProjetoSelecionado() {
        return projetoSelecionado;
    }

    public List<Projeto> buscarProjetos() {
        return projetoDao.buscar();
    }

    public ProjetoDao getProjeto() {
        return projetoDao;
    }

    /**
     * Remove o empreendedor do projeto selecionado
     */
    public void sairDoProjeto() {
        HttpSession sessao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        Empreendedor empreendedor = (Empreendedor) sessao.getAttribute("empreendedor");
        for (Object object : projetoSelecionado.getEmpreendedores()) {
            Empreendedor emmpreendedorLaco = (Empreendedor) object;
            if (Objects.equals(empreendedor.getIdUsuario(), emmpreendedorLaco.getIdUsuario())) {
                projetoSelecionado.getEmpreendedores().remove(emmpreendedorLaco);
                break;
            }
        }

        listaProjetos.remove(projetoSelecionado);

        if (projetoSelecionado.getEmpreendedores().isEmpty()) {
            projetoDao.deletar(projetoSelecionado.getIdProjeto());
        } else {
            projetoDao.update(projetoSelecionado);
        }

    }

    /**
     * Busca os projetos que um empreendedor tem.
     *
     * @return Lista de projetos encontrada.
     */
    public ArrayList<Projeto> buscaProjetoPorEmpreendedor() {
        HttpSession sessao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        Empreendedor empreendedor = (Empreendedor) sessao.getAttribute("empreendedor");
        empreendedor = Empreendedor.buscaPorEmail(empreendedor.getEmail());

        ArrayList<Projeto> projetosEmpreendedor = new ArrayList();
        for (Object projeto : empreendedor.getProjetos()) {
            projetosEmpreendedor.add((Projeto) projeto);
        }
        return projetosEmpreendedor;
    }

    public void setProjetoSelecionado(Projeto projetoSelecionado) {
        this.projetoSelecionado = projetoSelecionado;
    }
    /**
     * <p>
     * Retorna o status do projeto de acordo com as necessidades do empreendedor,
     * Empreendedor não sabe quando o projeto está sendo avaliado, quando está em
     * avaliação, em submetido ou ressubmetido. Apenas  resultados de avaliação.</p>
     * 
     * @param proj O objeto do projeto.
     * @return O status do projeto.
     */
    public String retornaProjetoStatus(Projeto proj){
        if (proj.getStatus() == Projeto.SENDO_AVALIADO || 
            proj.getStatus() == Projeto.SUBMETIDO ||
            proj.getStatus() == Projeto.RESUBMETIDO) {
            return "Em Pré-Avaliação";
        }else if(proj.getStatus() == Projeto.REVISANDO) {
            return "Necessita Melhoria";   
        }
        return proj.getStatusString(proj.getStatus());
    }

    /**
     * Envia o usuário para a página de enviar projeto, de acordo com o projeto
     * que ele selecionou.
     */
    public void enviaProjetoEditar() {
        HttpSession secao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        secao.setAttribute("projetoSelecionado", projetoSelecionado);
        try {

            if (projetoSelecionado.getStatus() == Projeto.NECESSITA_MELHORIA
                    || projetoSelecionado.getStatus() == Projeto.SUBMETIDO
                    || projetoSelecionado.getStatus() == Projeto.RESUBMETIDO
                    || projetoSelecionado.getStatus() == Projeto.REPROVADO
                    || projetoSelecionado.getStatus() == Projeto.ACEITO_PARA_AVALIACAO
                    || projetoSelecionado.getStatus() == Projeto.EM_PRE_AVALIACAO
                    || projetoSelecionado.getStatus() == Projeto.SENDO_AVALIADO
                    || projetoSelecionado.getStatus() == Projeto.REVISANDO) {

                FacesContext.getCurrentInstance().getExternalContext().redirect("planoDeNegocio/revisarPlanoDeNegocio.jsf");
            
            }else{
                
                FacesContext.getCurrentInstance().getExternalContext().redirect("enviarProjeto.jsf");
            }
        } catch (IOException ex) {
            Logger.getLogger(BuscaProjetoEmpreendedorBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Deleta o projeto que o usuário selecionou.
     * @param projeto
     */
    public void deletarProjeto(Projeto projeto) {
        HttpSession secao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        secao.setAttribute("projetoSelecionado", null);
        Empreendedor empreendedor = (Empreendedor) secao.getAttribute("empreendedor");
        this.projetoDao.deletar(projetoSelecionado.getIdProjeto());
        listaProjetos.remove(projetoSelecionado);
        secao.setAttribute("empreendedor", Empreendedor.buscaPorEmail(empreendedor.getEmail()));
        
    }

    /**
     * Verifica se o empreendedor da seção é o empreendedor correspondente do
     * objeto especificado.
     *
     * @param projeto Projeto para se verificar se o empreendedor é
     * correspondente
     * @return true se o empreendedor é correspondente
     */
    public boolean verificarEmpreendedor(Projeto projeto) {
        HttpSession secao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        Empreendedor empreendedor = (Empreendedor) secao.getAttribute("empreendedor");
        return empreendedor.verificaTipoEmpreendedor(projeto.getEmpreendedorCorrespondente());
    }

    /**
     * Verifica se o botão excluir pode ser ativado olhando o tipo de
     * empreendedor e se o projeto está em pre-avaliação.
     *
     * @param projeto Projeto para se verificar.
     * @return true se o botão pode ser ativado.
     */
    public boolean verificaExcluir(Projeto projeto) {
        return verificarEmpreendedor(projeto)
                && projeto.verificaSubmetido()
                && projeto.verificarSendoAvaliado()
                && projeto.verificarAceitoParaAvaliacao()
                && projeto.verificarReprovado()
                && projeto.verificarNecessitaAvaliacao()
                && projeto.verificaReSubmetido()
                && projeto.verificaEmPreAvaliacao()
                && projeto.verificarRevisando();
                
    }

    public String formatarDataCriacao(Projeto projeto) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        if (projeto.getDataCriacao() != null) {
            return formato.format(projeto.getDataCriacao());
        } else {
            return "Plano não criado.";
        }
    }

    public String formatarDataEnvio(Projeto projeto) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        if (projeto.getDataEnvio() != null) {
            return formato.format(projeto.getDataEnvio());
        } else {
            return "Plano não enviado.";
        }
    }
    /**
     * Usa a classe Collection pra arrumar a lista por ordem de criação, com o mais velho primeiro
     * depois reverte essa lista pra mostrar o ultimo criado.
     * @param lista
     *  Não retorna lista, ele ordena dentro dela mesma.
     */
    private ArrayList<Projeto> sortByDateCriacao(ArrayList<Projeto> lista) {
        Collections.sort(lista, new ComparadorCriacaoUtil());
        Collections.reverse(lista);
        return lista;
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
