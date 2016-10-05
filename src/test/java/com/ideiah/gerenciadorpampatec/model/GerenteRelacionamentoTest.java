/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.model;

import com.ideiah.gerenciadorpampatec.dao.GerenteDao;
import java.util.Set;
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
public class GerenteRelacionamentoTest {

    public GerenteRelacionamentoTest() {
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
     * Test of getIdgerente_relacionamento method, of class
     * GerenteRelacionamento.
     */
    @Test
    public void testConstrutorGerenteRelacionamento() {
        
        int idgerente_relacionamento = 0;
        String senha = "";
        String nome = "";
        String email = "";
        String cpf = "";
        GerenteRelacionamento instance = new GerenteRelacionamento(idgerente_relacionamento,
                senha, nome, email, cpf);
        assertNotNull(instance);
    }

    /**
     * Test of getGerenteDao method, of class GerenteRelacionamento.
     */
    @Ignore
    public void testGetGerenteDao() {
        
        GerenteDao expResult = null;
        GerenteDao result = GerenteRelacionamento.getGerenteDao();
        assertEquals(expResult, result);
    }

    /**
     * Test of getIdgerente_relacionamento method, of class
     * GerenteRelacionamento.
     */
    @Test
    public void testGetIdgerente_relacionamento() {
        
        GerenteRelacionamento instance = new GerenteRelacionamento();
        int expResult = 0;
        instance.setIdgerente_relacionamento(expResult);
        int result = instance.getIdgerente_relacionamento();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIdgerente_relacionamento method, of class
     * GerenteRelacionamento.
     */
    @Test
    public void testSetIdgerente_relacionamento() {
        
        int idgerente_relacionamento = 0;
        GerenteRelacionamento instance = new GerenteRelacionamento();
        instance.setIdgerente_relacionamento(idgerente_relacionamento);
    }

    /**
     * Test of getSenha method, of class GerenteRelacionamento.
     */
    @Test
    public void testGetSenha() {
        
        GerenteRelacionamento instance = new GerenteRelacionamento();
        String expResult = "";
        instance.setSenha(expResult);
        String result = instance.getSenha();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSenha method, of class GerenteRelacionamento.
     */
    @Test
    public void testSetSenha() {
        
        String senha = "";
        GerenteRelacionamento instance = new GerenteRelacionamento();
        instance.setSenha(senha);
    }

    /**
     * Test of getNome method, of class GerenteRelacionamento.
     */
    @Test
    public void testGetNome() {
        
        GerenteRelacionamento instance = new GerenteRelacionamento();
        String expResult = "";
        instance.setNome(expResult);
        String result = instance.getNome();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNome method, of class GerenteRelacionamento.
     */
    @Test
    public void testSetNome() {
        
        String nome = "";
        GerenteRelacionamento instance = new GerenteRelacionamento();
        instance.setNome(nome);
    }

    /**
     * Test of getEmail method, of class GerenteRelacionamento.
     */
    @Test
    public void testGetEmail() {
        
        GerenteRelacionamento instance = new GerenteRelacionamento();
        String expResult = "";
        instance.setEmail(expResult);
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEmail method, of class GerenteRelacionamento.
     */
    @Test
    public void testSetEmail() {
        
        String email = "";
        GerenteRelacionamento instance = new GerenteRelacionamento();
        instance.setEmail(email);
    }

    /**
     * Test of getCpf method, of class GerenteRelacionamento.
     */
    @Test
    public void testGetCpf() {
        
        GerenteRelacionamento instance = new GerenteRelacionamento();
        String expResult = "";
        instance.setCpf(expResult);
        String result = instance.getCpf();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCpf method, of class GerenteRelacionamento.
     */
    @Test
    public void testSetCpf() {
        
        String cpf = "";
        GerenteRelacionamento instance = new GerenteRelacionamento();
        instance.setCpf(cpf);
    }

    /**
     * Test of getProjetos method, of class GerenteRelacionamento.
     */
    @Test
    public void testGetProjetos() {
        
        GerenteRelacionamento instance = new GerenteRelacionamento();
        Set<Notificacao> expResult = null;
        instance.setProjetos(expResult);
        Set<Notificacao> result = instance.getProjetos();
        assertEquals(expResult, result);
    }

    /**
     * Test of setProjetos method, of class GerenteRelacionamento.
     */
    @Test
    public void testSetProjetos() {
        
        Set<Notificacao> projetos = null;
        GerenteRelacionamento instance = new GerenteRelacionamento();
        instance.setProjetos(projetos);
    }

    /**
     * Test of buscarPorEmail method, of class GerenteRelacionamento.
     */
    @Ignore
    public void testBuscarPorEmail() {
        
        String user = "";
        GerenteRelacionamento instance = new GerenteRelacionamento();
        GerenteRelacionamento expResult = null;
        GerenteRelacionamento result = instance.buscarPorEmail(user);
        assertEquals(expResult, result);
    }

    /**
     * Test of buscarPorCpf method, of class GerenteRelacionamento.
     */
    @Ignore
    public void testBuscarPorCpf() {
        
        String user = "";
        GerenteRelacionamento instance = new GerenteRelacionamento();
        GerenteRelacionamento expResult = null;
        GerenteRelacionamento result = instance.buscarPorCpf(user);
        assertEquals(expResult, result);
    }

}
