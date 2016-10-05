/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.model;

import com.ideiah.gerenciadorpampatec.dao.ProjetoDao;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 * 
 * @author unipampa
 */
public class ProjetoTest {

    public ProjetoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * teste executa o método de salvar um projeto já existente primeiro é
     * criado um projeto e depois editado
     */
    @Ignore
    public void testSalvarProjetoExistente() {

        Projeto instance = new Projeto();
        Projeto projeto = new Projeto();
        ProjetoDao dao = new ProjetoDao();

        projeto = (Projeto) dao.salvar(projeto);
        projeto.setEdital("Edital 123");
        instance.SalvarProjetoExistente(projeto);
        String edital = projeto.getEdital();

        Projeto projeto2 = (Projeto) dao.buscarObjetoCriteria("edital", edital, Projeto.class);

        assertEquals(projeto, projeto2);

        dao.excluir(projeto.getIdProjeto(), Projeto.class);
    }
    
    /**
     * Test Constructor
     */
    @Test
    public void testProjeto() {
        Integer idProjeto = 1;
        Analiseemprego analiseemprego = new Analiseemprego();
        Negocio negocio = new Negocio();
        Planofinanceiro planofinanceiro = new Planofinanceiro();
        Produtoouservico produtoouservico = new Produtoouservico();
        String participacaoacionaria = "part";

        Projeto instance = new Projeto(idProjeto, analiseemprego, 
                negocio, planofinanceiro, produtoouservico, 
                participacaoacionaria);
        assertNotNull(instance);
    }
    /**
     * Test Constructor
     */
    @Test
    public void testProjeto2() {

        Integer idProjeto = 1;
        Analiseemprego analiseemprego = new Analiseemprego();
        Negocio negocio = new Negocio();
        Planofinanceiro planofinanceiro = new Planofinanceiro();
        Produtoouservico produtoouservico = new Produtoouservico();
        String participacaoacionaria = "part";
        Date dataEnvio = new Date();
        Integer status = 1;
        Set empreendedores = new HashSet(0);
        empreendedores.add(new Empreendedor());
        Date dataCriacao = new Date();
        GerenteRelacionamento gerenteRelacionamento = new GerenteRelacionamento();        
        
        Projeto instance = new Projeto(idProjeto, analiseemprego, 
                negocio, planofinanceiro, produtoouservico, 
                participacaoacionaria, dataEnvio, status, participacaoacionaria, 
                empreendedores, participacaoacionaria, participacaoacionaria,
                dataCriacao, gerenteRelacionamento);

        assertNotNull(instance);
    }
    
    /**
     * Test of formatarDataEnvio method, of class Projeto.
     */
    @Test
    public void testFormatarDataEnvio() {
        
        Projeto instance = new Projeto();
        Date expResult = new Date();
        instance.setDataEnvio(new Date());
        String result = instance.formatarDataEnvio();
        assertNotSame(expResult, result);
    }

    /**
     * Test of formatarDataEnvio method, of class Projeto.
     */
    @Test
    public void testFormatarDataEnvio2() {
        
        Projeto instance = new Projeto();
        String expResult = "Plano não enviado.";
        instance.setDataEnvio(null);
        String result = instance.formatarDataEnvio();
        assertEquals(expResult, result);
    }

    /**
     * Test of formatarDataAvaliacao method, of class Projeto.
     */
    @Test
    public void testFormatarDataAvaliacao() {
        Projeto instance = new Projeto();
        Date expResult = new Date();
        instance.setDataAvaliacao(new Date());
        String result = instance.formatarDataAvaliacao();
        assertNotSame(expResult, result);
    }

    /**
     * Test of formatarDataAvaliacao method, of class Projeto.
     */
    @Test
    public void testFormatarDataAvaliacao2() {
        Projeto instance = new Projeto();
        String expResult = "Plano não avaliado";
        instance.setDataAvaliacao(null);
        String result = instance.formatarDataAvaliacao();
        assertEquals(expResult, result);
    }

    /**
     * Test of mudarStatus method, of class Projeto.
     */
    @Test
    public void testMudarStatus() {
        
        Integer status = null;
        Projeto instance = new Projeto();
        instance.mudarStatus(status);
    }

    /**
     * Test of buscarProjetoPorStatus method, of class Projeto.
     */
    @Ignore
    public void testBuscarProjetoPorStatus() {
        
        int status = 0;
        ArrayList<Projeto> expResult = null;
        ArrayList<Projeto> result = Projeto.buscarProjetoPorStatus(status);
        assertEquals(expResult, result);
    }

    /**
     * Test of retornaListaEmpreendedores method, of class Projeto.
     */
    @Test
    public void testRetornaListaEmpreendedores() {
        
        Projeto instance = new Projeto();
        Set empreendedors = new HashSet(0);
        Empreendedor e = new Empreendedor();
        Empreendedor e2 = new Empreendedor();
        Empreendedor e3 = new Empreendedor();
        Empreendedor e4 = new Empreendedor();
        empreendedors.add(e);
        empreendedors.add(e2);
        empreendedors.add(e3);
        empreendedors.add(e4);
        instance.setEmpreendedores(empreendedors);

        ArrayList<Empreendedor> expResult = new ArrayList<>();
        expResult.add(e);
        expResult.add(e2);
        expResult.add(e3);
        expResult.add(e4);

        ArrayList<Empreendedor> result = instance.retornaListaEmpreendedores();
        assertNotSame(expResult, result);
    }

    /**
     * Test of verificaSubmetido method, of class Projeto.
     */
    @Test
    public void testVerificaSubmetido() {
        Projeto instance = new Projeto();
        instance.setStatus(Projeto.SUBMETIDO);
        boolean expResult = false;
        boolean result = instance.verificaSubmetido();
        assertEquals(expResult, result);
    }

    /**
     * Test of verificaReSubmetido method, of class Projeto.
     */
    @Test
    public void testVerificaReSubmetido() {
        Projeto instance = new Projeto();
        instance.setStatus(Projeto.RESUBMETIDO);
        boolean expResult = false;
        boolean result = instance.verificaReSubmetido();
        assertEquals(expResult, result);
    }

    /**
     * Test of verificaEmPreAvaliacao method, of class Projeto.
     */
    @Test
    public void testVerificaEmPreAvaliacao() {
        Projeto instance = new Projeto();
        instance.setStatus(Projeto.EM_PRE_AVALIACAO);
        boolean expResult = false;
        boolean result = instance.verificaEmPreAvaliacao();
        assertEquals(expResult, result);
    }

    /**
     * Test of verificarSendoAvaliado method, of class Projeto.
     */
    @Test
    public void testVerificarSendoAvaliado() {
        Projeto instance = new Projeto();
        instance.setStatus(Projeto.SENDO_AVALIADO);
        boolean expResult = false;
        boolean result = instance.verificarSendoAvaliado();
        assertEquals(expResult, result);
    }

    /**
     * Test of verificarNecessitaAvaliacao method, of class Projeto.
     */
    @Test
    public void testVerificarNecessitaAvaliacao() {
        Projeto instance = new Projeto();
        instance.setStatus(Projeto.NECESSITA_MELHORIA);
        boolean expResult = false;
        boolean result = instance.verificarNecessitaAvaliacao();
        assertEquals(expResult, result);
    }

    /**
     * Test of verificarRevisando method, of class Projeto.
     */
    @Test
    public void testVerificarRevisando() {
        Projeto instance = new Projeto();
        instance.setStatus(Projeto.REVISANDO);
        boolean expResult = false;
        boolean result = instance.verificarRevisando();
        assertEquals(expResult, result);
    }

    /**
     * Test of verificarAceitoParaAvaliacao method, of class Projeto.
     */
    @Test
    public void testVerificarAceitoParaAvaliacao() {
        Projeto instance = new Projeto();
        instance.setStatus(Projeto.ACEITO_PARA_AVALIACAO);
        boolean expResult = false;
        boolean result = instance.verificarAceitoParaAvaliacao();
        assertEquals(expResult, result);
    }

    /**
     * Test of verificarReprovado method, of class Projeto.
     */
    @Test
    public void testVerificarReprovado() {
        Projeto instance = new Projeto();
        instance.setStatus(Projeto.REPROVADO);
        boolean expResult = false;
        boolean result = instance.verificarReprovado();
        assertEquals(expResult, result);
    }

    /**
     * Test of getIdProjeto method, of class Projeto.
     */
    @Test
    public void testGetIdProjeto() {
        Integer idProjeto = 1;
        Projeto instance = new Projeto();
        instance.setIdProjeto(idProjeto);
        assertEquals(idProjeto, instance.getIdProjeto());
    }

    /**
     * Test of setIdProjeto method, of class Projeto.
     */
    @Test
    public void testSetIdProjeto() {
        Integer idProjeto = 1;
        Projeto instance = new Projeto();
        instance.setIdProjeto(idProjeto);
        assertEquals(idProjeto, instance.getIdProjeto());

    }

    /**
     * Test of getAnaliseemprego method, of class Projeto.
     */
    @Test
    public void testGetAnaliseemprego() {
        Analiseemprego analiseemprego = new Analiseemprego();
        Projeto instance = new Projeto();
        instance.setAnaliseemprego(analiseemprego);
        assertEquals(analiseemprego, instance.getAnaliseemprego());
    }

    /**
     * Test of setAnaliseemprego method, of class Projeto.
     */
    @Test
    public void testSetAnaliseemprego() {
        Analiseemprego analiseemprego = new Analiseemprego();
        Projeto instance = new Projeto();
        instance.setAnaliseemprego(analiseemprego);
        assertEquals(analiseemprego, instance.getAnaliseemprego());
    }

    /**
     * Test of getNegocio method, of class Projeto.
     */
    @Test
    public void testGetNegocio() {
        Negocio negocio = new Negocio();
        Projeto instance = new Projeto();
        instance.setNegocio(negocio);
        assertEquals(negocio, instance.getNegocio());
    }

    /**
     * Test of setNegocio method, of class Projeto.
     */
    @Test
    public void testSetNegocio() {
        Negocio negocio = new Negocio();
        Projeto instance = new Projeto();
        instance.setNegocio(negocio);
        assertEquals(negocio, instance.getNegocio());
    }

    /**
     * Test of getPlanofinanceiro method, of class Projeto.
     */
    @Test
    public void testGetPlanofinanceiro() {
        Planofinanceiro planofinanceiro = new Planofinanceiro();
        Projeto instance = new Projeto();
        instance.setPlanofinanceiro(planofinanceiro);
        assertEquals(planofinanceiro, instance.getPlanofinanceiro());
    }

    /**
     * Test of setPlanofinanceiro method, of class Projeto.
     */
    @Test
    public void testSetPlanofinanceiro() {
        Planofinanceiro planofinanceiro = new Planofinanceiro();
        Projeto instance = new Projeto();
        instance.setPlanofinanceiro(planofinanceiro);
        assertEquals(planofinanceiro, instance.getPlanofinanceiro());
    }

    /**
     * Test of getProdutoouservico method, of class Projeto.
     */
    @Test
    public void testGetProdutoouservico() {
        Produtoouservico produtoouservico = new Produtoouservico();
        Projeto instance = new Projeto();
        instance.setProdutoouservico(produtoouservico);
        assertEquals(produtoouservico, instance.getProdutoouservico());
    }

    /**
     * Test of setProdutoouservico method, of class Projeto.
     */
    @Test
    public void testSetProdutoouservico() {
        Produtoouservico produtoouservico = new Produtoouservico();
        Projeto instance = new Projeto();
        instance.setProdutoouservico(produtoouservico);
        assertEquals(produtoouservico, instance.getProdutoouservico());
    }

    /**
     * Test of getNome method, of class Projeto.
     */
    @Test
    public void testGetNome() {
        String nome = "nome";
        Projeto instance = new Projeto();
        instance.setNome(nome);
        assertEquals(nome, instance.getNome());
    }

    /**
     * Test of setNome method, of class Projeto.
     */
    @Test
    public void testSetNome() {
        String nome = "nome";
        Projeto instance = new Projeto();
        instance.setNome(nome);
        assertEquals(nome, instance.getNome());
    }

    /**
     * Test of getDataEnvio method, of class Projeto.
     */
    @Test
    public void testGetDataEnvio() {
        Date dataEnvio = null;
        Projeto instance = new Projeto();
        instance.setDataEnvio(dataEnvio);
        assertEquals(dataEnvio, instance.getDataEnvio());
    }

    /**
     * Test of setDataEnvio method, of class Projeto.
     */
    @Test
    public void testSetDataEnvio() {
        Date dataEnvio = null;
        Projeto instance = new Projeto();
        instance.setDataEnvio(dataEnvio);
        assertEquals(dataEnvio, instance.getDataEnvio());
    }

    /**
     * Test of getDataAvaliacao method, of class Projeto.
     */
    @Test
    public void testGetDataAvaliacao() {
        Date dataAvaliacao = new Date();
        Projeto instance = new Projeto();
        instance.setDataAvaliacao(dataAvaliacao);
        assertEquals(dataAvaliacao, instance.getDataAvaliacao());
    }

    /**
     * Test of setDataAvaliacao method, of class Projeto.
     */
    @Test
    public void testSetDataAvaliacao() {
        Date dataAvaliacao = new Date();
        Projeto instance = new Projeto();
        instance.setDataAvaliacao(dataAvaliacao);
        assertEquals(dataAvaliacao, instance.getDataAvaliacao());
    }

    /**
     * Test of getStatusString method, of class Projeto. case Elaboração
     */
    @Test
    public void testGetStatusString() {
        int status = Projeto.ELABORACAO;
        Projeto instance = new Projeto();
        instance.setStatus(status);
        String expResult = "Em elaboração";
        String result = instance.getStatusString(status);
        assertEquals(expResult, result);
    }

    /**
     * Test of getStatusString method, of class Projeto. case Sendo Avaliado
     */
    @Test
    public void testGetStatusString2() {
        int status = Projeto.SENDO_AVALIADO;
        Projeto instance = new Projeto();
        instance.setStatus(status);
        String expResult = "Sendo Avaliado";
        String result = instance.getStatusString(status);
        assertEquals(expResult, result);
    }

    /**
     * Test of getStatusString method, of class Projeto. case Submetido
     */
    @Test
    public void testGetStatusString3() {
        int status = Projeto.SUBMETIDO;
        Projeto instance = new Projeto();
        instance.setStatus(status);
        String expResult = "Submetido";
        String result = instance.getStatusString(status);
        assertEquals(expResult, result);
    }

    /**
     * Test of getStatusString method, of class Projeto. case Aceito para
     * Avaliação
     */
    @Test
    public void testGetStatusString4() {
        int status = Projeto.ACEITO_PARA_AVALIACAO;
        Projeto instance = new Projeto();
        instance.setStatus(status);
        String expResult = "Aceito para Avaliação";
        String result = instance.getStatusString(status);
        assertEquals(expResult, result);
    }

    /**
     * Test of getStatusString method, of class Projeto. case Necessita Melhoria
     */
    @Test
    public void testGetStatusString5() {
        int status = Projeto.NECESSITA_MELHORIA;
        Projeto instance = new Projeto();
        instance.setStatus(status);
        String expResult = "Necessita Melhoria";
        String result = instance.getStatusString(status);
        assertEquals(expResult, result);
    }

    /**
     * Test of getStatusString method, of class Projeto. case Em Formalização
     */
    @Test
    public void testGetStatusString6() {
        int status = Projeto.FORMALIZACAO;
        Projeto instance = new Projeto();
        instance.setStatus(status);
        String expResult = "Em Formalização";
        String result = instance.getStatusString(status);
        assertEquals(expResult, result);
    }

    /**
     * Test of getStatusString method, of class Projeto. case Incubação
     */
    @Test
    public void testGetStatusString7() {
        int status = Projeto.INCUBACAO;
        Projeto instance = new Projeto();
        instance.setStatus(status);
        String expResult = "Incubação";
        String result = instance.getStatusString(status);
        assertEquals(expResult, result);
    }

    /**
     * Test of getStatusString method, of class Projeto. case Reprovado
     */
    @Test
    public void testGetStatusString8() {
        int status = Projeto.REPROVADO;
        Projeto instance = new Projeto();
        instance.setStatus(status);
        String expResult = "Reprovado";
        String result = instance.getStatusString(status);
        assertEquals(expResult, result);
    }

    /**
     * Test of getStatusString method, of class Projeto. case Em Pré-Avaliação
     */
    @Test
    public void testGetStatusString9() {
        int status = Projeto.EM_PRE_AVALIACAO;
        Projeto instance = new Projeto();
        instance.setStatus(status);
        String expResult = "Em Pré-Avaliação";
        String result = instance.getStatusString(status);
        assertEquals(expResult, result);
    }

    /**
     * Test of getStatusString method, of class Projeto. case Ressubmetido
     */
    @Test
    public void testGetStatusString10() {
        int status = Projeto.RESUBMETIDO;
        Projeto instance = new Projeto();
        instance.setStatus(status);
        String expResult = "Ressubmetido";
        String result = instance.getStatusString(status);
        assertEquals(expResult, result);
    }

    /**
     * Test of getStatusString method, of class Projeto. case Necessita Melhoria
     */
    @Test
    public void testGetStatusString11() {
        int status = Projeto.REVISANDO;
        Projeto instance = new Projeto();
        instance.setStatus(status);
        String expResult = "Necessita Melhoria";
        String result = instance.getStatusString(status);
        assertEquals(expResult, result);
    }

    /**
     * Test of getStatusString method, of class Projeto. Status nao presente
     */
    @Test
    public void testGetStatusString12() {
        int status = 1000;
        Projeto instance = new Projeto();
        instance.setStatus(status);
        String expResult = "Status Inexistente! [Projeto.java]";
        String result = instance.getStatusString(status);
        assertEquals(expResult, result);
    }

    /**
     * Test of getStatus method, of class Projeto.
     */
    @Test
    public void testGetStatus() {
        Integer status = 1;
        Projeto instance = new Projeto();
        instance.setStatus(status);
        assertEquals(status, instance.getStatus());
    }

    /**
     * Test of setStatus method, of class Projeto.
     */
    @Test
    public void testSetStatus() {
        Integer status = 1;
        Projeto instance = new Projeto();
        instance.setStatus(status);
        assertEquals(status, instance.getStatus());
    }

    /**
     * Test of getPotencialEmprego method, of class Projeto.
     */
    @Test
    public void testGetPotencialEmprego() {
        String potencialEmprego = "potencial";
        Projeto instance = new Projeto();
        instance.setPotencialEmprego(potencialEmprego);
        assertEquals(potencialEmprego, instance.getPotencialEmprego());
    }

    /**
     * Test of setPotencialEmprego method, of class Projeto.
     */
    @Test
    public void testSetPotencialEmprego() {
        String potencialEmprego = "potencial";
        Projeto instance = new Projeto();
        instance.setPotencialEmprego(potencialEmprego);
        assertEquals(potencialEmprego, instance.getPotencialEmprego());
    }

    /**
     * Test of getEmpreendedores method, of class Projeto.
     */
    @Test
    public void testGetEmpreendedores() {
        
        Set<Empreendedor> empreendedores = new HashSet();
        Empreendedor empreendedor = new Empreendedor();
        empreendedores.add(empreendedor);
        Projeto instance = new Projeto();
        instance.setEmpreendedores(empreendedores);
        assertEquals(empreendedores, instance.getEmpreendedores());
    }

    /**
     * Test of setEmpreendedores method, of class Projeto.
     */
    @Test
    public void testSetEmpreendedores() {
        
        Set<Empreendedor> empreendedores = new HashSet();
        Empreendedor empreendedor = new Empreendedor();
        empreendedores.add(empreendedor);
        Projeto instance = new Projeto();
        instance.setEmpreendedores(empreendedores);
        assertEquals(empreendedores, instance.getEmpreendedores());
    }

    /**
     * Test of getParticipacaoacionaria method, of class Projeto.
     */
    @Test
    public void testGetParticipacaoacionaria() {
        String participacaoacionaria = "participaçao";
        Projeto instance = new Projeto();
        instance.setParticipacaoacionaria(participacaoacionaria);
        assertEquals(participacaoacionaria, instance.getParticipacaoacionaria());
    }

    /**
     * Test of setParticipacaoacionaria method, of class Projeto.
     */
    @Test
    public void testSetParticipacaoacionaria() {
        String participacaoacionaria = "participaçao";
        Projeto instance = new Projeto();
        instance.setParticipacaoacionaria(participacaoacionaria);
        assertEquals(participacaoacionaria, instance.getParticipacaoacionaria());
    }

    /**
     * Test of getEdital method, of class Projeto.
     */
    @Test
    public void testGetEdital() {
        String edital = "edital";
        Projeto instance = new Projeto();
        instance.setEdital(edital);
        assertEquals(edital, instance.getEdital());
    }

    /**
     * Test of setEdital method, of class Projeto.
     */
    @Test
    public void testSetEdital() {
        String edital = "edital";
        Projeto instance = new Projeto();
        instance.setEdital(edital);
        assertEquals(edital, instance.getEdital());

    }

    /**
     * Test of getDataCriacao method, of class Projeto.
     */
    @Test
    public void testGetDataCriacao() {
        Date dataCriacao = new Date();
        Projeto instance = new Projeto();
        instance.setDataCriacao(dataCriacao);
        assertEquals(dataCriacao, instance.getDataCriacao());
    }

    /**
     * Test of setDataCriacao method, of class Projeto.
     */
    @Test
    public void testSetDataCriacao() {
        Date dataCriacao = new Date();
        Projeto instance = new Projeto();
        instance.setDataCriacao(dataCriacao);
        assertEquals(dataCriacao, instance.getDataCriacao());
    }

    /**
     * Test of getGerenteRelacionamento method, of class Projeto.
     */
    @Test
    public void testGetGerenteRelacionamento() {
        GerenteRelacionamento gerenteRelacionamento = new GerenteRelacionamento();
        Projeto instance = new Projeto();
        instance.setGerenteRelacionamento(gerenteRelacionamento);
        assertEquals(gerenteRelacionamento, instance.getGerenteRelacionamento());
    }

    /**
     * Test of setGerenteRelacionamento method, of class Projeto.
     */
    @Test
    public void testSetGerenteRelacionamento() {
        GerenteRelacionamento gerenteRelacionamento = new GerenteRelacionamento();
        Projeto instance = new Projeto();
        instance.setGerenteRelacionamento(gerenteRelacionamento);
        assertEquals(gerenteRelacionamento, instance.getGerenteRelacionamento());
    }

    /**
     * Test of getEmpreendedorCorrespondente method, of class Projeto.
     */
    @Test
    public void testGetEmpreendedorCorrespondente() {
        Empreendedor empreendedor = new Empreendedor();
        Projeto instance = new Projeto();
        instance.setEmpreendedorCorrespondente(empreendedor);
        assertEquals(empreendedor, instance.getEmpreendedorCorrespondente());
    }

    /**
     * Test of setEmpreendedorCorrespondente method, of class Projeto.
     */
    @Test
    public void testSetEmpreendedorCorrespondente() {
        Empreendedor empreendedor = new Empreendedor();
        Projeto instance = new Projeto();
        instance.setEmpreendedorCorrespondente(empreendedor);
        assertEquals(empreendedor, instance.getEmpreendedorCorrespondente());
    }

    /**
     * Test of getComentarioProjeto method, of class Projeto.
     */
    @Test
    public void testGetComentarioProjeto() {
        Set<ComentarioProjeto> comentariosProjeto = new HashSet<>();
        ComentarioProjeto comentarioProjeto = new ComentarioProjeto();
        comentariosProjeto.add(comentarioProjeto);
        Projeto instance = new Projeto();
        instance.setComentarioProjeto(comentariosProjeto);
        assertEquals(comentariosProjeto, instance.getComentarioProjeto());
    }

    /**
     * Test of setComentarioProjeto method, of class Projeto.
     */
    @Test
    public void testSetComentarioProjeto() {
        Set<ComentarioProjeto> comentariosProjeto = new HashSet<>();
        ComentarioProjeto comentarioProjeto = new ComentarioProjeto();
        comentariosProjeto.add(comentarioProjeto);
        Projeto instance = new Projeto();
        instance.setComentarioProjeto(comentariosProjeto);
        assertEquals(comentariosProjeto, instance.getComentarioProjeto());
    }

    /**
     * Test of getContAcesso method, of class Projeto.
     */
    @Test
    public void testGetContAcesso() {
        int contAcesso = 0;
        Projeto instance = new Projeto();
        instance.setContAcesso(contAcesso);
        assertEquals(contAcesso, instance.getContAcesso());
    }

    /**
     * Test of setContAcesso method, of class Projeto.
     */
    @Test
    public void testSetContAcesso() {
        int contAcesso = 0;
        Projeto instance = new Projeto();
        instance.setContAcesso(contAcesso);
        assertEquals(contAcesso, instance.getContAcesso());
    }

    /**
     * Test of getStatusTemp method, of class Projeto.
     */
    @Test
    public void testGetStatusTemp() {
        Integer statusTemp = 1;
        Projeto instance = new Projeto();
        instance.setStatusTemp(statusTemp);
        assertEquals(statusTemp, instance.getStatusTemp());
    }

    /**
     * Test of setStatusTemp method, of class Projeto.
     */
    @Test
    public void testSetStatusTemp() {
        Integer statusTemp = 1;
        Projeto instance = new Projeto();
        instance.setStatusTemp(statusTemp);
        assertEquals(statusTemp, instance.getStatusTemp());
    }
}
