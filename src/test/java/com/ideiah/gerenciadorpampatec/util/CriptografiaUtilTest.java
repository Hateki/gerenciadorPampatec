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

/**
 * <p>
 * Classe para testar a criptografia utilizada no sistema.</p>
 *
 * @author unipampa
 */
public class CriptografiaUtilTest {

    public CriptografiaUtilTest() {
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
     * Test of md5 method, of class CriptografiaUtil.
     * <p>
     * Teste para verificar se construtor da classe é gerador corretamente.</p>
     */
    @Test
    public void testConstrutorCriptografiaUtil() {
        
        CriptografiaUtil expResult = new CriptografiaUtil();
        assertNotNull(expResult);

    }

    /**
     * Test of md5 method, of class CriptografiaUtil.
     * <p>
     * Teste para verificar a geração da hash criptográfica.</p>
     */
    @Test
    public void testMd52() {
        
        String senha = "";
        String expResult = "";
        String result = CriptografiaUtil.md5(senha);
        assertNotSame(expResult, result);
    }

    /**
     * Test of md5 method, of class CriptografiaUtil.
     * <p>
     * Teste para verificar se a hash criptográfica gerada está correta.</p>
     */
    @Test
    public void testMd53() {
        
        String senha = "123456";
        String expResult = "e10adc3949ba59abbe56e057f20f883e".toUpperCase();
        String result = CriptografiaUtil.md5(senha);
        assertEquals(expResult, result);
    }

    /**
     * Test of md5 method, of class CriptografiaUtil.
     * <p>
     * Teste para verificar se o método realmente está gerando uma hash
     * criptográfica.</p>
     */
    @Test
    public void testMd54() {
        
        String senha = "123456";
        String expResult = "";
        String result = CriptografiaUtil.md5(senha);
        assertNotSame(expResult, result);
    }
}
