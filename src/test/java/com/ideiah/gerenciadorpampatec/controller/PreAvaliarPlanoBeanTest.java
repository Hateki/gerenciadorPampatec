/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.controller;

import com.ideiah.gerenciadorpampatec.dao.ComentarioDao;
import com.ideiah.gerenciadorpampatec.dao.ProjetoDao;
import com.ideiah.gerenciadorpampatec.model.ComentarioProjeto;
import com.ideiah.gerenciadorpampatec.model.Projeto;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Claudio
 */
@Ignore
public class PreAvaliarPlanoBeanTest {

    PreAvaliarPlanoBean instance;
    Projeto projeto;
    ComentarioDao comentDao;
    ComentarioProjeto comentarioProjeto;
    ProjetoDao projDao;

    public PreAvaliarPlanoBeanTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        projeto = new Projeto();
        projDao = new ProjetoDao();
        comentDao = new ComentarioDao();
        projeto = projDao.buscar(1);
        comentarioProjeto = comentDao.buscar(1);
        instance = new PreAvaliarPlanoBean(projeto);
    }

    @After
    public void tearDown() {
        projeto = null;
        projDao = null;
        comentDao = null;
        projeto = null;
        comentarioProjeto = null;
        instance = null;
    }

    /**
     * Test of buscarComentarioProjeto method, of class PreAvaliarPlanoBean.
     */
    @Test
    public void testBuscarComentarioProjeto() {
        instance.buscarComentarioProjeto(projeto);
        assertEquals(comentarioProjeto.getIdcomentario(), instance.getComentarioProjeto().getIdcomentario());
    }

    /**
     * Test of verificaEstagioEvolucao method, of class PreAvaliarPlanoBean.
     */
    @Test
    public void testVerificaEstagioEvolucao() {
        String esperado = "Projeto Básico";
        assertEquals(esperado, projeto.getProdutoouservico().getEstagioEvolucao());
    }

    @Test
    public void testVerificaEstagioFalso() {
        String esperado = "Idéia Básica";
        assertNotSame(esperado, projeto.getProdutoouservico().getEstagioEvolucao());
    }

    /**
     * Test of mudaStatusProjetoParaSendoAvaliado method, of class
     * PreAvaliarPlanoBean.
     */
    @Test
    public void testMudaStatusProjetoParaSendoAvaliadoFalse() {
        //int statusProjeto = Projeto.SUBMETIDO;
        instance.mudaStatusProjetoParaSendoAvaliado(projeto);

        //assertFalse("Verifica se o status do projeto é mudado de Pré Avaliacao para Sendo avaliado deve ser False", statusProjeto == instance.getProjeto().getStatus());
        instance.mudaStatusProjetoParaEmPreAvaliacao(projeto);
    }

    @Test
    public void testMudaStatusProjetoParaSendoAvaliadoTrue() {
        instance.mudaStatusProjetoParaSendoAvaliado(projeto);
        assertTrue("Verifica se o status do projeto é: Sendo Avaliado deve ser True", Projeto.SENDO_AVALIADO == instance.getProjeto().getStatus());
        instance.mudaStatusProjetoParaEmPreAvaliacao(projeto);
    }

    /**
     * Test of mudaStatusProjetoParaEmPreAvaliacao method, of class
     * PreAvaliarPlanoBean.
     */
    @Test
    public void testMudaStatusProjetoParaEmPreAvaliacaoTrue() {
        instance.mudaStatusProjetoParaSendoAvaliado(projeto);
        projeto.getStatusString(projeto.getStatus());
        instance.mudaStatusProjetoParaEmPreAvaliacao(projeto);

        //assertTrue("Verifica se o status do projeto é: Em Pre Avaliação Deve ser True", Projeto.SUBMETIDO == projeto.getStatus());
    }

    @Test
    public void testMudaStatusProjetoParaEmPreAvaliacaoFalse() {
        instance.mudaStatusProjetoParaSendoAvaliado(projeto);
        projeto.getStatusString(projeto.getStatus());
        instance.mudaStatusProjetoParaEmPreAvaliacao(projeto);

        assertFalse("Verifica se o status do projeto é: Em Pre Avaliação, Deve ser falso", Projeto.SENDO_AVALIADO == projeto.getStatus());
    }
}
