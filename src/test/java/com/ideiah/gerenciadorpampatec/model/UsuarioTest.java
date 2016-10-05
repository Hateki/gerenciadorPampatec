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

public class UsuarioTest {
    
    public UsuarioTest() {
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
     * Test of getIdUsuario method, of class Usuario.
     */
    @Test
    public void testGetIdUsuario() {
        int expResult = 1;
        Usuario instance = new UsuarioImpl();
        instance.setIdUsuario(expResult);
        int result = instance.getIdUsuario();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIdUsuario method, of class Usuario.
     */
    @Test
    public void testSetIdUsuario() {
        int idUsuario = 1;
        Usuario instance = new UsuarioImpl();
        instance.setIdUsuario(idUsuario);
        int result = instance.getIdUsuario();
        assertEquals(idUsuario, result);
    }

    /**
     * Test of getEmail method, of class Usuario.
     */
    @Test
    public void testGetEmail() {
        String expResult = "joao@email.com";
        Usuario instance = new UsuarioImpl();
        instance.setEmail(expResult);
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEmail method, of class Usuario.
     */
    @Test
    public void testSetEmail() {
        String expResult = "joao@email.com";
        Usuario instance = new UsuarioImpl();
        instance.setEmail(expResult);
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCpf method, of class Usuario.
     */
    @Test
    public void testGetCpf() {
        String expResult = "00334570012";
        Usuario instance = new UsuarioImpl();
        instance.setCpf(expResult);
        String result = instance.getCpf();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCpf method, of class Usuario.
     */
    @Test
    public void testSetCpf() {
        String expResult = "00334570012";
        Usuario instance = new UsuarioImpl();
        instance.setCpf(expResult);
        String result = instance.getCpf();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNome method, of class Usuario.
     */
    @Test
    public void testGetNome() {
        String expResult = "Joao";
        Usuario instance = new UsuarioImpl();
        instance.setNome(expResult);
        String result = instance.getNome();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNome method, of class Usuario.
     */
    @Test
    public void testSetNome() {
        String expResult = "Joao";
        Usuario instance = new UsuarioImpl();
        instance.setNome(expResult);
        String result = instance.getNome();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTelefone method, of class Usuario.
     */
    @Test
    public void testGetTelefone() {
        String expResult = "34222222";
        Usuario instance = new UsuarioImpl();
        instance.setTelefone(expResult);
        String result = instance.getTelefone();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTelefone method, of class Usuario.
     */
    @Test
    public void testSetTelefone() {
        String expResult = "34222222";
        Usuario instance = new UsuarioImpl();
        instance.setTelefone(expResult);
        String result = instance.getTelefone();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSenha method, of class Usuario.
     */
    @Test
    public void testGetSenha() {
        String expResult = "34222222";
        Usuario instance = new UsuarioImpl();
        instance.setSenha(expResult);
        String result = instance.getSenha();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSenha method, of class Usuario.
     */
    @Test
    public void testSetSenha() {
        String expResult = "34222222";
        Usuario instance = new UsuarioImpl();
        instance.setSenha(expResult);
        String result = instance.getSenha();
        assertEquals(expResult, result);
    }

    public class UsuarioImpl extends Usuario {
    }
    
}
