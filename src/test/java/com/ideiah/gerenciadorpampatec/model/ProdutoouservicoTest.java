/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.model;

import java.util.HashSet;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ProdutoouservicoTest {

    int id = 1;
    String estagioEvolucao = "Outro:";
    String tecnologiaProcessos = "tecnologia";
    String potencialInovacaoTecnologica = "potencial";
    String aplicacoes = "aplicacoes";
    String dificuldadesEsperadas = "dificuldades";
    String interacaoEmpresaUniversidade = "interacaoEU";
    String interacaoEmpresaComunidadeGoverno = "interacaoECG";
    String infraestrutura = "infra";
    Set<Projeto> projetos = new HashSet<>();
    Projeto projeto = new Projeto();

    public ProdutoouservicoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        projetos.add(projeto);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of verificaStatusProjeto method, of class Produtoouservico. case
     * Ideiah Basica
     */
    @Test
    public void testVerificaStatusProjeto() {
        String status = "Ideia Básica";
        Produtoouservico instance = new Produtoouservico();
        String expResult = Produtoouservico.IDEIA_BASICA;
        String result = instance.verificaStatusProjeto(status);
        assertEquals(expResult, result);
    }

    /**
     * Test of verificaStatusProjeto method, of class Produtoouservico. case
     * Cliente Pagando
     */
    @Test
    public void testVerificaStatusProjeto2() {
        String status = "Clientes Pagando";
        Produtoouservico instance = new Produtoouservico();
        String expResult = Produtoouservico.CLIENTES_PAGANDO;
        String result = instance.verificaStatusProjeto(status);
        assertEquals(expResult, result);
    }

    /**
     * Test of verificaStatusProjeto method, of class Produtoouservico. case
     * Projeto Básico
     */
    @Test
    public void testVerificaStatusProjeto3() {
        String status = "Projeto Básico";
        Produtoouservico instance = new Produtoouservico();
        String expResult = Produtoouservico.PROJETO_BASICO;
        String result = instance.verificaStatusProjeto(status);
        assertEquals(expResult, result);
    }

    /**
     * Test of verificaStatusProjeto method, of class Produtoouservico. case Em
     * teste no mercado
     */
    @Test
    public void testVerificaStatusProjeto4() {
        String status = "Em teste no mercado";
        Produtoouservico instance = new Produtoouservico();
        String expResult = Produtoouservico.EM_TESTE_NO_MERCADO;
        String result = instance.verificaStatusProjeto(status);
        assertEquals(expResult, result);
    }

    /**
     * Test of verificaStatusProjeto method, of class Produtoouservico. case
     * Projeto Detalhado
     */
    @Test
    public void testVerificaStatusProjeto5() {
        String status = "Projeto Detalhado";
        Produtoouservico instance = new Produtoouservico();
        String expResult = Produtoouservico.PROJETO_DETALHADO;
        String result = instance.verificaStatusProjeto(status);
        assertEquals(expResult, result);
    }

    /**
     * Test of verificaStatusProjeto method, of class Produtoouservico. case
     * Protótipo Desenvolvido
     */
    @Test
    public void testVerificaStatusProjeto6() {
        String status = "Protótipo Desenvolvido";
        Produtoouservico instance = new Produtoouservico();
        String expResult = Produtoouservico.PROTOTIPO_DESENVOLVIDO;
        String result = instance.verificaStatusProjeto(status);
        assertEquals(expResult, result);
    }

    /**
     * Test of verificaStatusProjeto method, of class Produtoouservico. case
     * Protótipo Desenvolvido
     */
    @Test
    public void testVerificaStatusProjeto7() {
        String status = "AEHOOOO";
        Produtoouservico instance = new Produtoouservico();
        String expResult = "Outro:";
        String result = instance.verificaStatusProjeto(status);
        assertEquals(expResult, result);
    }

    /**
     * Test of verificaStatusProjeto method, of class Produtoouservico. com
     * status null
     */
    @Test
    public void testVerificaStatusProjeto8() {
        String status = null;
        Produtoouservico instance = new Produtoouservico();
        String expResult = "Status Indefinido";
        String result = instance.verificaStatusProjeto(status);
        assertEquals(expResult, result);
    }

    /**
     * Test do Construtor
     */
    @Test
    public void testProdutoServico1() {
        Produtoouservico produtoouservico = new Produtoouservico(id, estagioEvolucao);

        assertEquals(id, produtoouservico.getIdProdutoOuServico());
        assertEquals(estagioEvolucao, produtoouservico.getEstagioEvolucao());
    }

    /**
     * Test de Contrutor
     */
    @Test
    public void testProdutoServico2() {
        Produtoouservico produtoouservico = new Produtoouservico(id, estagioEvolucao, tecnologiaProcessos, potencialInovacaoTecnologica, aplicacoes, dificuldadesEsperadas, interacaoEmpresaUniversidade, interacaoEmpresaComunidadeGoverno, infraestrutura, projetos);

        assertEquals(id, produtoouservico.getIdProdutoOuServico());
        assertEquals(estagioEvolucao, produtoouservico.getEstagioEvolucao());
        assertEquals(tecnologiaProcessos, produtoouservico.getTecnologiaProcessos());
        assertEquals(potencialInovacaoTecnologica, produtoouservico.getPotencialInovacaoTecnologica());
        assertEquals(aplicacoes, produtoouservico.getAplicacoes());
        assertEquals(dificuldadesEsperadas, produtoouservico.getDificuldadesEsperadas());
        assertEquals(interacaoEmpresaUniversidade, produtoouservico.getInteracaoEmpresaUniversidade());
        assertEquals(interacaoEmpresaComunidadeGoverno, produtoouservico.getInteracaoEmpresaComunidadeGoverno());
        assertEquals(infraestrutura, produtoouservico.getInfraestrutura());
        assertEquals(projetos, produtoouservico.getProjetos());
    }

    /**
     * Test of getIdProdutoOuServico method, of class Produtoouservico.
     */
    @Test
    public void testGetIdProdutoOuServico() {
        
        Produtoouservico instance = new Produtoouservico();
        int expResult = 0;
        instance.setIdProdutoOuServico(expResult);
        int result = instance.getIdProdutoOuServico();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIdProdutoOuServico method, of class Produtoouservico.
     */
    @Test
    public void testSetIdProdutoOuServico() {
        
        int idProdutoOuServico = 0;
        Produtoouservico instance = new Produtoouservico();
        instance.setIdProdutoOuServico(idProdutoOuServico);
    }

    /**
     * Test of getEstagioEvolucao method, of class Produtoouservico.
     */
    @Test
    public void testGetEstagioEvolucao() {
        
        Produtoouservico instance = new Produtoouservico();
        String expResult = "";
        instance.setEstagioEvolucao(expResult);
        String result = instance.getEstagioEvolucao();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEstagioEvolucao method, of class Produtoouservico.
     */
    @Test
    public void testSetEstagioEvolucao() {
        
        String estagioEvolucao = "";
        Produtoouservico instance = new Produtoouservico();
        instance.setEstagioEvolucao(estagioEvolucao);
    }

    /**
     * Test of getTecnologiaProcessos method, of class Produtoouservico.
     */
    @Test
    public void testGetTecnologiaProcessos() {
        
        Produtoouservico instance = new Produtoouservico();
        String expResult = "";
        instance.setTecnologiaProcessos(expResult);
        String result = instance.getTecnologiaProcessos();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTecnologiaProcessos method, of class Produtoouservico.
     */
    @Test
    public void testSetTecnologiaProcessos() {
        
        String tecnologiaProcessos = "";
        Produtoouservico instance = new Produtoouservico();
        instance.setTecnologiaProcessos(tecnologiaProcessos);
    }

    /**
     * Test of getPotencialInovacaoTecnologica method, of class
     * Produtoouservico.
     */
    @Test
    public void testGetPotencialInovacaoTecnologica() {
        
        Produtoouservico instance = new Produtoouservico();
        String expResult = "";
        instance.setPotencialInovacaoTecnologica(expResult);
        String result = instance.getPotencialInovacaoTecnologica();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPotencialInovacaoTecnologica method, of class
     * Produtoouservico.
     */
    @Test
    public void testSetPotencialInovacaoTecnologica() {
        
        String potencialInovacaoTecnologica = "";
        Produtoouservico instance = new Produtoouservico();
        instance.setPotencialInovacaoTecnologica(potencialInovacaoTecnologica);
    }

    /**
     * Test of getAplicacoes method, of class Produtoouservico.
     */
    @Test
    public void testGetAplicacoes() {
        
        Produtoouservico instance = new Produtoouservico();
        String expResult = "";
        instance.setAplicacoes(expResult);
        String result = instance.getAplicacoes();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAplicacoes method, of class Produtoouservico.
     */
    @Test
    public void testSetAplicacoes() {
        
        String aplicacoes = "";
        Produtoouservico instance = new Produtoouservico();
        instance.setAplicacoes(aplicacoes);
    }

    /**
     * Test of getDificuldadesEsperadas method, of class Produtoouservico.
     */
    @Test
    public void testGetDificuldadesEsperadas() {
        
        Produtoouservico instance = new Produtoouservico();
        String expResult = "";
        instance.setDificuldadesEsperadas(expResult);
        String result = instance.getDificuldadesEsperadas();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDificuldadesEsperadas method, of class Produtoouservico.
     */
    @Test
    public void testSetDificuldadesEsperadas() {
        
        String dificuldadesEsperadas = "";
        Produtoouservico instance = new Produtoouservico();
        instance.setDificuldadesEsperadas(dificuldadesEsperadas);
    }

    /**
     * Test of getInteracaoEmpresaUniversidade method, of class
     * Produtoouservico.
     */
    @Test
    public void testGetInteracaoEmpresaUniversidade() {
        
        Produtoouservico instance = new Produtoouservico();
        String expResult = "";
        instance.setInteracaoEmpresaUniversidade(expResult);
        String result = instance.getInteracaoEmpresaUniversidade();
        assertEquals(expResult, result);
    }

    /**
     * Test of setInteracaoEmpresaUniversidade method, of class
     * Produtoouservico.
     */
    @Test
    public void testSetInteracaoEmpresaUniversidade() {
        
        String interacaoEmpresaUniversidade = "";
        Produtoouservico instance = new Produtoouservico();
        instance.setInteracaoEmpresaUniversidade(interacaoEmpresaUniversidade);
    }

    /**
     * Test of getInteracaoEmpresaComunidadeGoverno method, of class
     * Produtoouservico.
     */
    @Test
    public void testGetInteracaoEmpresaComunidadeGoverno() {
        
        Produtoouservico instance = new Produtoouservico();
        String expResult = "";
        instance.setInteracaoEmpresaComunidadeGoverno(expResult);
        String result = instance.getInteracaoEmpresaComunidadeGoverno();
        assertEquals(expResult, result);
    }

    /**
     * Test of setInteracaoEmpresaComunidadeGoverno method, of class
     * Produtoouservico.
     */
    @Test
    public void testSetInteracaoEmpresaComunidadeGoverno() {
        
        String interacaoEmpresaComunidadeGoverno = "";
        Produtoouservico instance = new Produtoouservico();
        instance.setInteracaoEmpresaComunidadeGoverno(interacaoEmpresaComunidadeGoverno);
    }

    /**
     * Test of getInfraestrutura method, of class Produtoouservico.
     */
    @Test
    public void testGetInfraestrutura() {
        
        Produtoouservico instance = new Produtoouservico();
        String expResult = "";
        instance.setInfraestrutura(expResult);
        String result = instance.getInfraestrutura();
        assertEquals(expResult, result);
    }

    /**
     * Test of setInfraestrutura method, of class Produtoouservico.
     */
    @Test
    public void testSetInfraestrutura() {
        
        String infraestrutura = "";
        Produtoouservico instance = new Produtoouservico();
        instance.setInfraestrutura(infraestrutura);
    }

    /**
     * Test of getProjetos method, of class Produtoouservico.
     */
    @Test
    public void testGetProjetos() {
        
        Produtoouservico instance = new Produtoouservico();
        Set expResult = null;
        instance.setProjetos(expResult);
        Set result = instance.getProjetos();
        assertEquals(expResult, result);
    }

    /**
     * Test of setProjetos method, of class Produtoouservico.
     */
    @Test
    public void testSetProjetos() {
        
        Set projetos = null;
        Produtoouservico instance = new Produtoouservico();
        instance.setProjetos(projetos);
    }

}
