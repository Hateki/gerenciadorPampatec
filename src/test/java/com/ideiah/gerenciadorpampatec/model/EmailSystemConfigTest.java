/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.model;

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
public class EmailSystemConfigTest {
    
    public EmailSystemConfigTest() {
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
     * Test of getEmail method, of class EmailSystemConfig.
     */
    @Test
    public void testConstrturEmailSystemConfig() {
        
        String authEmail = "";
        String authPassphrase = "";
        EmailSystemConfig instance = new EmailSystemConfig(authEmail, authPassphrase);
        assertNotNull(instance);
    }

    /**
     * Test of getEmail method, of class EmailSystemConfig.
     */
    @Test
    public void testGetEmail() {
        
        EmailSystemConfig instance = new EmailSystemConfig();
        String expResult = "";
        instance.setEmail(expResult);
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEmail method, of class EmailSystemConfig.
     */
    @Test
    public void testSetEmail() {
        
        String aAuthEmail = "";
        EmailSystemConfig instance = new EmailSystemConfig();
        instance.setEmail(aAuthEmail);
    }

    /**
     * Test of getPassphrase method, of class EmailSystemConfig.
     */
    @Test
    public void testGetPassphrase() {
        
        EmailSystemConfig instance = new EmailSystemConfig();
        String expResult = "";
        instance.setPassphrase(expResult);
        String result = instance.getPassphrase();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPassphrase method, of class EmailSystemConfig.
     */
    @Test
    public void testSetPassphrase() {
        
        String aAuthPassphrase = "";
        EmailSystemConfig instance = new EmailSystemConfig();
        instance.setPassphrase(aAuthPassphrase);
    }

    /**
     * Test of getId_systememail method, of class EmailSystemConfig.
     */
    @Test
    public void testGetId_systememail() {
        
        EmailSystemConfig instance = new EmailSystemConfig();
        Integer expResult = null;
        instance.setId_systememail(expResult);
        Integer result = instance.getId_systememail();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId_systememail method, of class EmailSystemConfig.
     */
    @Test
    public void testSetId_systememail() {
        
        Integer id_systememail = null;
        EmailSystemConfig instance = new EmailSystemConfig();
        instance.setId_systememail(id_systememail);
    }
    
}
