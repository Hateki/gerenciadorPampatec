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
 * Classe para implementação dos testes unitários da classe
 * <code>TelefoneUtil</code>.</p>
 *
 * @author unipampa
 */
public class TelefoneUtilTest {

    public TelefoneUtilTest() {
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
     * Test of removeParentesesTelefone method, of class TelefoneUtil.
     * <p>
     * Teste para validar se o objeto da classe é gerado corretamente.</p>
     */
    @Test
    public void testConstrutorTelefoneUtil() {
        
        TelefoneUtil result = new TelefoneUtil();
        assertNotNull(result);
    }

    /**
     * Test of removeParentesesTelefone method, of class TelefoneUtil.
     * <p>
     * Teste para validar se o método evita o lançamento de
     * <code>nullPointerException</code>.</p>
     */
    @Test
    public void testRemoveParentesesTelefone() {
        
        String telefone = null;
        String expResult = "";
        String result = TelefoneUtil.removeParentesesTelefone(telefone);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeParentesesTelefone method, of class TelefoneUtil.
     * <p>
     * Teste para validar se o método reconhece <code>Strings</code> vazias.
     * </p>
     */
    @Test
    public void testRemoveParentesesTelefone2() {
        
        String telefone = "";
        String expResult = "";
        String result = TelefoneUtil.removeParentesesTelefone(telefone);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeParentesesTelefone method, of class TelefoneUtil.
     * <p>
     * Teste para validar se o método realmente remove espaços, parênteses e
     * traços do número de telefone recebido.
     * </p>
     */
    @Test
    public void testRemoveParentesesTelefone3() {
        
        String telefone = "(55) 5555-5555";
        String expResult = "5555555555";
        String result = TelefoneUtil.removeParentesesTelefone(telefone);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeParentesesTelefone method, of class TelefoneUtil.
     * <p>
     * Teste para validar se o método consegue remover espaços e parênteses do
     * número de telefone recebido.
     * </p>
     */
    @Test
    public void testRemoveParentesesTelefone4() {
        
        String telefone = "(55) 55555555";
        String expResult = "5555555555";
        String result = TelefoneUtil.removeParentesesTelefone(telefone);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeParentesesTelefone method, of class TelefoneUtil.
     * <p>
     * Teste para validar se o método reconhece e remove letras e caracteres
     * especiais do número de telefone recebido.
     * </p>
     */
    @Test
    public void testRemoveParentesesTelefone5() {
        
        String telefone = "(ABC) ABCD-EFGH";
        String expResult = "";
        String result = TelefoneUtil.removeParentesesTelefone(telefone);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeParentesesTelefone method, of class TelefoneUtil.
     * <p>
     * Teste para validar se o método reconhece e remove caracteres especiais do
     * número de telefone recebido.
     * </p>
     */
    @Test
    public void testRemoveParentesesTelefone6() {
        
        String telefone = "(:<<) }+_%-'!@#";
        String expResult = "";
        String result = TelefoneUtil.removeParentesesTelefone(telefone);
        assertEquals(expResult, result);
    }
}
