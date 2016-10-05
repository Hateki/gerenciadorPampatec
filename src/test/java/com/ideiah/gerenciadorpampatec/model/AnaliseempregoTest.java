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

/**
 *
 * @author unipampa
 */
public class AnaliseempregoTest {

    int id = 1;
    String relacoesClientes = "Relacoes";
    String parceriasChaves = "Parcerias";
    String canais = "Canais";
    String recursosPrincipais = "Recursos";
    String concorrentes = "Concorrentes";
    Set<Projeto> projetos = new HashSet<>();
    Projeto projeto = new Projeto();

    public AnaliseempregoTest() {
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
     * test do construtor
     */
    @Test
    public void testAnaliseEmprego() {
        Analiseemprego analise = new Analiseemprego(id);

        assertEquals(id, analise.getIdAnaliseEmprego());
    }

    /**
     * test do construtor
     */
    @Test
    public void testAnaliseEmprego2() {
        Analiseemprego analise = new Analiseemprego(id, relacoesClientes, parceriasChaves, canais, recursosPrincipais, concorrentes, projetos);

        assertEquals(id, analise.getIdAnaliseEmprego());
        assertEquals(relacoesClientes, analise.getRelacoesClientes());
        assertEquals(parceriasChaves, analise.getParceriasChaves());
        assertEquals(canais, analise.getCanais());
        assertEquals(recursosPrincipais, analise.getRecursosPrincipais());
        assertEquals(concorrentes, analise.getConcorrentes());
        assertEquals(projetos, analise.getProjetos());
    }

    /**
     * Test of getIdAnaliseEmprego method, of class Analiseemprego.
     */
    @Test
    public void testGetIdAnaliseEmprego() {
        Analiseemprego instance = new Analiseemprego();
        int expResult = 0;
        int result = instance.getIdAnaliseEmprego();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIdAnaliseEmprego method, of class Analiseemprego.
     */
    @Test
    public void testSetIdAnaliseEmprego() {
        int idAnaliseEmprego = 0;
        Analiseemprego instance = new Analiseemprego();
        instance.setIdAnaliseEmprego(idAnaliseEmprego);
    }

    /**
     * Test of getRelacoesClientes method, of class Analiseemprego.
     */
    @Test
    public void testGetRelacoesClientes() {
        Analiseemprego instance = new Analiseemprego();
        String expResult = "";
        instance.setRelacoesClientes(expResult);
        String result = instance.getRelacoesClientes();
        assertEquals(expResult, result);
    }

    /**
     * Test of setRelacoesClientes method, of class Analiseemprego.
     */
    @Test
    public void testSetRelacoesClientes() {
        String relacoesClientes = "";
        Analiseemprego instance = new Analiseemprego();
        instance.setRelacoesClientes(relacoesClientes);
    }

    /**
     * Test of getParceriasChaves method, of class Analiseemprego.
     */
    @Test
    public void testGetParceriasChaves() {
        Analiseemprego instance = new Analiseemprego();
        String expResult = "";
        instance.setParceriasChaves(expResult);
        String result = instance.getParceriasChaves();
        assertEquals(expResult, result);
    }

    /**
     * Test of setParceriasChaves method, of class Analiseemprego.
     */
    @Test
    public void testSetParceriasChaves() {
        String parceriasChaves = "";
        Analiseemprego instance = new Analiseemprego();
        instance.setParceriasChaves(parceriasChaves);
    }

    /**
     * Test of getCanais method, of class Analiseemprego.
     */
    @Test
    public void testGetCanais() {
        Analiseemprego instance = new Analiseemprego();
        String expResult = "";
        instance.setCanais(expResult);
        String result = instance.getCanais();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCanais method, of class Analiseemprego.
     */
    @Test
    public void testSetCanais() {
        String expResult = "";
        Analiseemprego instance = new Analiseemprego();
        instance.setCanais(expResult);
    }

    /**
     * Test of getRecursosPrincipais method, of class Analiseemprego.
     */
    @Test
    public void testGetRecursosPrincipais() {
        Analiseemprego instance = new Analiseemprego();
        String expResult = "";
        instance.setRecursosPrincipais(expResult);
        String result = instance.getRecursosPrincipais();
        assertEquals(expResult, result);
    }

    /**
     * Test of setRecursosPrincipais method, of class Analiseemprego.
     */
    @Test
    public void testSetRecursosPrincipais() {
        String expResult = "";
        Analiseemprego instance = new Analiseemprego();
        instance.setRecursosPrincipais(expResult);
    }

    /**
     * Test of getConcorrentes method, of class Analiseemprego.
     */
    @Test
    public void testGetConcorrentes() {
        Analiseemprego instance = new Analiseemprego();
        String expResult = "";
        instance.setConcorrentes(expResult);
        String result = instance.getConcorrentes();
        assertEquals(expResult, result);
    }

    /**
     * Test of setConcorrentes method, of class Analiseemprego.
     */
    @Test
    public void testSetConcorrentes() {
        String expResult = "";
        Analiseemprego instance = new Analiseemprego();
        instance.setConcorrentes(expResult);
    }

    /**
     * Test of getProjetos method, of class Analiseemprego.
     */
    @Test
    public void testGetProjetos() {
        Analiseemprego instance = new Analiseemprego();
        Set expResult = null;
        instance.setProjetos(expResult);
        Set result = instance.getProjetos();
        assertEquals(expResult, result);
    }

    /**
     * Test of setProjetos method, of class Analiseemprego.
     */
    @Test
    public void testSetProjetos() {
        Set expResult = null;
        Analiseemprego instance = new Analiseemprego();
        instance.setProjetos(expResult);
    }
}
