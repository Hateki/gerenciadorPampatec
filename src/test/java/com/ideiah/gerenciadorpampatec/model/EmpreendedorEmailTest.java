/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.model;

import com.ideiah.gerenciadorpampatec.dao.EmpreendedorEmailDao;
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
public class EmpreendedorEmailTest {

    public EmpreendedorEmailTest() {
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
     * Test of getEmpreededorEmailDao method, of class EmpreendedorEmail.
     */
    @Test
    public void testConstrutorEmpreededorEmail() {
        
        String idEmpreendedorEmail = "";
        String tipo = "";
        Empreendedor empreendedor = new Empreendedor();
        EmpreendedorEmail result = new EmpreendedorEmail(idEmpreendedorEmail, tipo, empreendedor);
        assertNotNull(result);

    }

    /**
     * Test of getEmpreededorEmailDao method, of class EmpreendedorEmail.
     */
    @Ignore
    public void testGetEmpreededorEmailDao() {
        
        EmpreendedorEmailDao expResult = null;
        EmpreendedorEmailDao result = EmpreendedorEmail.getEmpreededorEmailDao();
        assertEquals(expResult, result);
    }

    /**
     * Test of salvarEmpreendedorEmail method, of class EmpreendedorEmail.
     */
    @Ignore
    public void testSalvarEmpreendedorEmail() {
        
        EmpreendedorEmail empreendedorEmail = null;
        EmpreendedorEmail instance = new EmpreendedorEmail();
        EmpreendedorEmail expResult = null;
        EmpreendedorEmail result = instance.salvarEmpreendedorEmail(empreendedorEmail);
        assertEquals(expResult, result);
    }

    /**
     * Test of getIdEmpreendedorEmail method, of class EmpreendedorEmail.
     */
    @Test
    public void testGetIdEmpreendedorEmail() {
        
        EmpreendedorEmail instance = new EmpreendedorEmail();
        String expResult = "1";
        instance.setIdEmpreendedorEmail(expResult);
        String result = instance.getIdEmpreendedorEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIdEmpreendedorEmail method, of class EmpreendedorEmail.
     */
    @Test
    public void testSetIdEmpreendedorEmail() {
        
        String idEmpreendedorEmail = "";
        EmpreendedorEmail instance = new EmpreendedorEmail();
        instance.setIdEmpreendedorEmail(idEmpreendedorEmail);
    }

    /**
     * Test of getTipo method, of class EmpreendedorEmail.
     */
    @Test
    public void testGetTipo() {
        
        EmpreendedorEmail instance = new EmpreendedorEmail();
        String expResult = "";
        instance.setTipo(expResult);
        String result = instance.getTipo();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTipo method, of class EmpreendedorEmail.
     */
    @Test
    public void testSetTipo() {
        
        String tipo = "";
        EmpreendedorEmail instance = new EmpreendedorEmail();
        instance.setTipo(tipo);
    }

    /**
     * Test of buscaEmpreendedorMailID method, of class EmpreendedorEmail.
     */
    @Ignore
    public void testBuscaEmpreendedorMailID() {
        
        String id = "";
        EmpreendedorEmail expResult = null;
        EmpreendedorEmail result = EmpreendedorEmail.buscaEmpreendedorMailID(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of getEmpreendedor method, of class EmpreendedorEmail.
     */
    @Test
    public void testGetEmpreendedor() {
        
        EmpreendedorEmail instance = new EmpreendedorEmail();
        Empreendedor expResult = new Empreendedor();
        instance.setEmpreendedor(expResult);
        Empreendedor result = instance.getEmpreendedor();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEmpreendedor method, of class EmpreendedorEmail.
     */
    @Test
    public void testSetEmpreendedor() {
        
        Empreendedor empreendedor = null;
        EmpreendedorEmail instance = new EmpreendedorEmail();
        instance.setEmpreendedor(empreendedor);
    }

    /**
     * Test of apagarDoBanco method, of class EmpreendedorEmail.
     */
    @Ignore
    public void testApagarDoBanco() {
        
        EmpreendedorEmail empreendedorEmail = null;
        EmpreendedorEmail instance = new EmpreendedorEmail();
        instance.apagarDoBanco(empreendedorEmail);
    }

}
