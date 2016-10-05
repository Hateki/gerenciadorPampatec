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
import org.junit.Ignore;


public class CustoTest {
    
        Planofinanceiro planofinanceiro = new Planofinanceiro();
        String descricao = "Novo Custo";
        Integer total = 10;
        Integer tipo = 1;
        
    
    public CustoTest() {
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
     * Test of Custo method, of class Custo.
     */
    @Test
    public void testCusto(){

        Custo valor = new Custo(planofinanceiro, descricao, total, tipo);
        
        valor.setPlanofinanceiro(planofinanceiro);
        valor.setTotal(total);
        valor.setDescricao(descricao);
        valor.setIdCusto(1);
        valor.setTipo(tipo);
        valor.setPodeExcluir(true);
        
        assertEquals(descricao, valor.getDescricao());
        assertEquals(planofinanceiro, valor.getPlanofinanceiro());
        assertEquals(total, valor.getTotal());
        assertEquals(tipo, valor.getTipo());  
    }
    
        @Test
    public void testCusto2(){
        Custo valor = new Custo(planofinanceiro);
        
        valor.setPlanofinanceiro(planofinanceiro);
        valor.setTotal(total);
        valor.setDescricao(descricao);
        valor.setIdCusto(1);
        valor.setTipo(tipo);
        valor.setPodeExcluir(true);
        
        assertEquals(descricao, valor.getDescricao());
        assertEquals(planofinanceiro, valor.getPlanofinanceiro());
        assertEquals(total, valor.getTotal());
        assertEquals(tipo, valor.getTipo());  
    }

    /**
     * Test of getIdCusto method, of class Custo.
     */
    @Test
    public void testGetIdCusto() {
        Custo instance = new Custo();
        int expResult = 1;
        instance.setIdCusto(1);
        int result = instance.getIdCusto();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIdCusto method, of class Custo.
     */
    @Test
    public void testSetIdCusto() {
        Custo instance = new Custo();
        int expResult = 1;
        instance.setIdCusto(1);
        int result = instance.getIdCusto();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPlanofinanceiro method, of class Custo.
     */
    @Test
    public void testGetPlanofinanceiro() {
        Custo instance = new Custo();
        Planofinanceiro expResult = new Planofinanceiro();
        instance.setPlanofinanceiro(expResult);
        Planofinanceiro result = instance.getPlanofinanceiro();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPlanofinanceiro method, of class Custo.
     */
    @Test
    public void testSetPlanofinanceiro() {
        Custo instance = new Custo();
        Planofinanceiro expResult = new Planofinanceiro();
        instance.setPlanofinanceiro(expResult);
        Planofinanceiro result = instance.getPlanofinanceiro();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDescricao method, of class Custo.
     */
    @Test
    public void testGetDescricao() {
        Custo instance = new Custo();
        String expResult = "novo Custo";
        instance.setDescricao(expResult);
        String result = instance.getDescricao();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDescricao method, of class Custo.
     */
    @Test
    public void testSetDescricao() {
        Custo instance = new Custo();
        String expResult = "novo Custo";
        instance.setDescricao(expResult);
        String result = instance.getDescricao();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTotal method, of class Custo.
     */
    @Test
    public void testGetTotal() {
        Custo instance = new Custo();
        int expResult = 10;
        instance.setTotal(expResult);
        int result = instance.getTotal();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTotal method, of class Custo.
     */
    @Test
    public void testSetTotal() {
        Custo instance = new Custo();
        int expResult = 10;
        instance.setTotal(expResult);
        int result = instance.getTotal();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTipo method, of class Custo.
     */
    @Test
    public void testGetTipo() {
        Custo instance = new Custo();
        int expResult = 1;
        instance.setTipo(expResult);
        int result = instance.getTipo();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTipo method, of class Custo.
     */
    @Test
    public void testSetTipo() {
        Custo instance = new Custo();
        int expResult = 1;
        instance.setTipo(expResult);
        int result = instance.getTipo();
        assertEquals(expResult, result);
    }

    /**
     * Test of getProjecao method, of class Custo.
     */
    @Test
    public void testGetProjecao() {
        Custo instance = new Custo();
        int expResult = 1;
        instance.setProjecao(1);
        int result = instance.getProjecao();
        assertEquals(expResult, result);
    }

    /**
     * Test of setProjecao method, of class Custo.
     */
    @Test
    public void testSetProjecao() {
        Custo instance = new Custo();
        int expResult = 1;
        instance.setProjecao(1);
        int result = instance.getProjecao();
        assertEquals(expResult, result);
    }

    /**
     * Test of isPodeExcluir method, of class Custo.
     */
    @Test
    public void testIsPodeExcluir() {
        Custo instance = new Custo();
        boolean expResult = false;
        instance.setPodeExcluir(expResult);
        boolean result = instance.isPodeExcluir();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPodeExcluir method, of class Custo.
     */
    @Test
    public void testSetPodeExcluir() {
        Custo instance = new Custo();
        boolean expResult = false;
        instance.setPodeExcluir(expResult);
        boolean result = instance.isPodeExcluir();
        assertEquals(expResult, result);
    }
    
}
