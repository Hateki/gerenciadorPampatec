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
 *
 * @author Maicon Alves
 */
public class CpfUtilTest {
    
    public CpfUtilTest() {
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
     * Test of isValidCPF method, of class CpfUtil.
     */
    @Test
    public void testIsValidCPF() {
        
        String cpf = "";
        boolean expResult = false;
        boolean result = CpfUtil.isValidCPF(cpf);
        assertEquals(expResult, result); 
    }
    
    
    @Test
    public void testIsValidCPF2() {
        
        String cpf = "97198244505";
        boolean expResult = true;
        boolean result = CpfUtil.isValidCPF(cpf);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testIsValidCPF3() {
        
        String cpf = "97192244505";
        boolean expResult = false;
        boolean result = CpfUtil.isValidCPF(cpf);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testIsValidCPF4() {
        
        String cpf = null;
        boolean expResult = false;
        boolean result = CpfUtil.isValidCPF(cpf);
        assertEquals(expResult, result);
    }
    
     @Test
    public void testIsValidCPF5() {
        
        String cpf = "41238192389383283233";
        boolean expResult = false;
        boolean result = CpfUtil.isValidCPF(cpf);
        assertEquals(expResult, result);
    }
    
     @Test
    public void testIsValidCPF6() {
        
        
        CpfUtil cpf2 = new CpfUtil();
        
        
        String cpf = "11111111111";
        boolean expResult = false;
        boolean result = CpfUtil.isValidCPF(cpf);
        assertEquals(expResult, result);
    }
    
    
    
}
