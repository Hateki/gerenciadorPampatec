/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.util;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

public class FacesUtilTest {
    
    String idComponente = "idComponenteInterface";
    
    public FacesUtilTest() {
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
     * Test of addFeedbackSaveSuccess method, of class FacesUtil.
     */
    @Test
    public void testConstrutorFacesUtil() {
        FacesUtil fu = new FacesUtil();
        assertNotNull(fu);
    }    
    
    /**
     * Test of addFeedbackSaveSuccess method, of class FacesUtil.
     */
    @Ignore
    public void testAddFeedbackSaveSuccess() {
        String idComponente = "";
        FacesUtil.addFeedbackSaveSuccess(idComponente);
    }

    /**
     * Test of addSuccessMessage method, of class FacesUtil.
     */
    @Ignore
    public void testAddSuccessMessage_String() {
        String message = "";
        FacesUtil.addSuccessMessage(message);
    }

    /**
     * Test of addSuccessMessage method, of class FacesUtil.
     */
    @Ignore
    public void testAddSuccessMessage_String_String() {
        String message = "";
        String idComponente = "";
        FacesUtil.addSuccessMessage(message, idComponente);
    }

    /**
     * Test of addErrorMessage method, of class FacesUtil.
     */
    @Ignore
    public void testAddErrorMessage_String() {
        String message = "";
        FacesUtil.addErrorMessage(message);
    }

    /**
     * Test of addErrorMessage method, of class FacesUtil.
     */
    @Ignore
    public void testAddErrorMessage_String_String() {
        
        String message = "";
        String idComponente = "";
        FacesUtil.addErrorMessage(message, idComponente);
    }

    /**
     * Test of transformaInt method, of class FacesUtil.
     * Recebendo String vazia ("")
     */
    @Test
    public void testTransformaInt() {
        String valor = "";
        int expResult = 0;
        int result = FacesUtil.transformaInt(valor);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of transformaInt method, of class FacesUtil.
     * Recebendo NULL
     */
    @Test
    public void testTransformaInt2() {
        String valor = null;
        int expResult = 0;
        int result = FacesUtil.transformaInt(valor);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of transformaInt method, of class FacesUtil.
     * Recebendo numeros
     */
    @Test
    public void testTransformaInt3() {
        String valor = "123";
        int expResult = 123;
        int result = FacesUtil.transformaInt(valor);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of transformaInt method, of class FacesUtil.
     * Recebendo numeros e letras
     */
    @Test
    public void testTransformaInt4() {
        String valor = "123abc";
        int expResult = 123;
        int result = FacesUtil.transformaInt(valor);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of transformaLong method, of class FacesUtil.
     * recebendo String Vazia ("")
     */
    @Test
    public void testTransformaLong() {
        String valor = "";
        long expResult = 0;
        long result = FacesUtil.transformaLong(valor);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of transformaLong method, of class FacesUtil.
     * recebendo NULL
     */
    @Test
    public void testTransformaLong2() {
        String valor = null;
        long expResult = 0;
        long result = FacesUtil.transformaLong(valor);
        assertEquals(expResult, result);
    }
        
    /**
     * Test of transformaLong method, of class FacesUtil.
     * Recebendo numeros
     */
    @Test
    public void testTransformaLong3() {
        String valor = "123";
        long expResult = 123;
        long result = FacesUtil.transformaLong(valor);
        assertEquals(expResult, result);
    }
        
    /**
     * Test of transformaLong method, of class FacesUtil.
     * Recebendo numeros e letras
     */
    @Test
    public void testTransformaLong4() {
        String valor = "123abc";
        long expResult = 123;
        long result = FacesUtil.transformaLong(valor);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of removeCaracteres method, of class FacesUtil.
     * Recebendo String vazia
     */
    @Test
    public void testRemoveCaracteres() {
        String valor = "";
        String expResult = "";
        String result = FacesUtil.removeCaracteres(valor);
        assertEquals(expResult, result);
    }
        
    /**
     * Test of removeCaracteres method, of class FacesUtil.
     * Recebendo null
     */
    @Test
    public void testRemoveCaracteres2() {
        String valor = null;
        String expResult = "";
        String result = FacesUtil.removeCaracteres(valor);
        assertEquals(expResult, result);
    }
        
    /**
     * Test of removeCaracteres method, of class FacesUtil.
     * Recebendo String sem caracteres especiais
     */
    @Test
    public void testRemoveCaracteres3() {
        String valor = "abcabc123";
        String expResult = "123";
        String result = FacesUtil.removeCaracteres(valor);
        assertEquals(expResult, result);
    }
        
    /**
     * Test of removeCaracteres method, of class FacesUtil.
     * Recebendo String com caracteres especiais
     */
    @Test
    public void testRemoveCaracteres4() {
        String valor = "abcâãç°123";
        String expResult = "123";
        String result = FacesUtil.removeCaracteres(valor);
        assertEquals(expResult, result);
    }
}
