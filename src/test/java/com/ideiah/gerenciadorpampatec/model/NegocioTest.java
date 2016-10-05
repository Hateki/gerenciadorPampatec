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
public class NegocioTest {

    public NegocioTest() {
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
     * Test of getIdNegocio method, of class Negocio.
     */
    @Test
    public void testGetIdNegocio() {
        
        Negocio instance = new Negocio();
        int expResult = 0;
        int result = instance.getIdNegocio();
        assertEquals(expResult, result);
    }

    /**
     * Test of getIdNegocio method, of class Negocio.
     */
    @Test
    public void testConstrutorNegocio() {
        
        int idNegocio = 0;
        String segmentoClientes = "";
        String propostaValor = "";
        String atividadesChaves = "";
        Negocio instance = new Negocio(idNegocio,
                segmentoClientes, propostaValor, atividadesChaves);

        assertNotNull(instance);
    }

    /**
     * Test of getIdNegocio method, of class Negocio.
     */
    @Test
    public void testConstrutorNegocio2() {
        
        String segmentoClientes = "";
        String propostaValor = "";
        String atividadesChaves = "";
        Set projetos = new HashSet(0);
        Negocio instance = new Negocio(0, segmentoClientes, propostaValor, atividadesChaves, projetos);
        assertNotNull(instance);
    }

    /**
     *
     * Test of setIdNegocio method, of class Negocio.
     */
    @Test
    public void testSetIdNegocio() {
        
        int idNegocio = 0;
        Negocio instance = new Negocio();
        instance.setIdNegocio(idNegocio);
    }

    /**
     * Test of getSegmentoClientes method, of class Negocio.
     */
    @Test
    public void testGetSegmentoClientes() {
        
        Negocio instance = new Negocio();
        String expResult = "";
        instance.setSegmentoClientes(expResult);
        String result = instance.getSegmentoClientes();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSegmentoClientes method, of class Negocio.
     */
    @Test
    public void testSetSegmentoClientes() {
        
        Negocio instance = new Negocio();
        String segmentoClientes = "";
        instance.setSegmentoClientes(segmentoClientes);
    }

    /**
     * Test of getPropostaValor method, of class Negocio.
     */
    @Test
    public void testGetPropostaValor() {
        
        Negocio instance = new Negocio();
        String expResult = "";
        instance.setPropostaValor(expResult);
        String result = instance.getPropostaValor();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPropostaValor method, of class Negocio.
     */
    @Test
    public void testSetPropostaValor() {
        
        String propostaValor = "";
        Negocio instance = new Negocio();
        instance.setPropostaValor(propostaValor);
    }

    /**
     * Test of getAtividadesChaves method, of class Negocio.
     */
    @Test
    public void testGetAtividadesChaves() {
        
        Negocio instance = new Negocio();
        String expResult = "";
        instance.setAtividadesChaves(expResult);
        String result = instance.getAtividadesChaves();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAtividadesChaves method, of class Negocio.
     */
    @Test
    public void testSetAtividadesChaves() {
        
        String atividadesChaves = "";
        Negocio instance = new Negocio();
        instance.setAtividadesChaves(atividadesChaves);
    }

    /**
     * Test of getProjetos method, of class Negocio.
     */
    @Test
    public void testGetProjetos() {
        
        Negocio instance = new Negocio();
        Set expResult = null;
        instance.setProjetos(expResult);
        Set result = instance.getProjetos();
        assertEquals(expResult, result);
    }

    /**
     * Test of setProjetos method, of class Negocio.
     */
    @Test
    public void testSetProjetos() {
        
        Set projetos = null;
        Negocio instance = new Negocio();
        instance.setProjetos(projetos);
    }

}
