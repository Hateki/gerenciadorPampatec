/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.controller;

import com.ideiah.gerenciadorpampatec.model.GerenteRelacionamento;
import javax.servlet.http.HttpSession;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.mockito.Mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author unipampa
 */
public class SystemAccessBeanTest {

    @Mock
    private HttpSession mockedSession;
    
    public SystemAccessBeanTest() {
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
     * Test of submit method, of class SystemAccessBean.
     */
    @Ignore
    public void testSubmit() {
        
        SystemAccessBean instance = new SystemAccessBean();
        instance.submit();
    }

    /**
     * <p>Teste para verificar se texto inserido contem apenas números.</p>
     */
    @Test
    public void testSoContemNumeros() {
        
        String texto = "1234567890";
        boolean expResult = false;
        boolean result = SystemAccessBean.soContemNumeros(texto);
        assertNotSame(expResult, result);
    }

    /**
     * <p>Teste para verificar se o texto inserido contém letras.</p>
     */
    @Test
    public void testSoContemNumeros2() {
        
        String texto = "Teste com Letras";
        boolean expResult = false;
        boolean result = SystemAccessBean.soContemNumeros(texto);
        assertEquals(expResult, result);
    }    
    
    /**
     * <p>Teste para verificar se o método identifica e trata corretamente um texto nulo.</p>
     */
    @Test
    public void testSoContemNumeros3() {
        
        String texto = null;
        boolean expResult = false;
        boolean result = SystemAccessBean.soContemNumeros(texto);
        assertEquals(expResult, result);
    }      
    
    /**
     * Test of fazLogout method, of class SystemAccessBean.
     */
    @Ignore
    public void testFazLogout() {
        
        when(SessionManager.getCreateSession()).thenReturn(mockedSession);
        GerenteRelacionamento gerente = new GerenteRelacionamento();
        mockedSession.setAttribute("gerente", gerente);
        SystemAccessBean.fazLogout();
    }

    /**
     * Test of recuperarSenha method, of class SystemAccessBean.
     */
    @Ignore
    public void testRecuperarSenha() {
        
        SystemAccessBean instance = new SystemAccessBean();
        instance.setEmailRecuperarSenha("vitor@gerente.com");
        instance.recuperarSenha();
    }

    /**
     * <p>Teste para verificar user vazio.</p>
     */
    @Test
    public void testGetUser() {
        
        SystemAccessBean instance = new SystemAccessBean();
        String expResult = "";
        instance.setUser(expResult);
        String result = instance.getUser();
        assertEquals(expResult, result);
    }
    
    /**
     * <p>Teste para user nulo</p>
     */
    @Test
    public void testGetUser2() {
        
        SystemAccessBean instance = new SystemAccessBean();
        String expResult = null;
        String result;
        result = instance.getUser();
        assertEquals(expResult, result);
    }
    

    /**
     * Test of setUser method, of class SystemAccessBean.
     */
    @Test
    public void testSetUser() {
        
        String aUser = "";
        SystemAccessBean instance = new SystemAccessBean();
        instance.setUser(aUser);
    }

    /**
     * Test of getPassphrase method, of class SystemAccessBean.
     */
    @Test
    public void testGetPassphrase() {
        
        SystemAccessBean instance = new SystemAccessBean();
        String expResult = "";
        instance.setPassphrase(expResult);        
        String result = instance.getPassphrase();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getPassphrase method, of class SystemAccessBean.
     */
    @Test
    public void testGetPassphrase2() {
        
        SystemAccessBean instance = new SystemAccessBean();
        String expResult = null;
        String result = instance.getPassphrase();
        assertEquals(expResult, result);
    }
    

    /**
     * Test of setPassphrase method, of class SystemAccessBean.
     */
    @Test
    public void testSetPassphrase() {
        
        String aSenha = "";
        SystemAccessBean instance = new SystemAccessBean();
        instance.setPassphrase(aSenha);
    }

    /**
     * Test of getNome method, of class SystemAccessBean.
     */
    @Test
    public void testGetNome() {
        
        SystemAccessBean instance = new SystemAccessBean();
        String expResult = null;
        String result = instance.getNome();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNome method, of class SystemAccessBean.
     */
    @Test
    public void testGetNome2() {
        
        SystemAccessBean instance = new SystemAccessBean();
        String expResult = "";
        instance.setNome(expResult);
        String result = instance.getNome();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of setNome method, of class SystemAccessBean.
     */
    @Test
    public void testSetNome() {
        
        String nome = "";
        SystemAccessBean instance = new SystemAccessBean();
        instance.setNome(nome);
    }

    /**
     * Test of getEmailRecuperarSenha method, of class SystemAccessBean.
     */
    @Test
    public void testGetEmailRecuperarSenha() {
        
        SystemAccessBean instance = new SystemAccessBean();
        String expResult = "";
        String result = instance.getEmailRecuperarSenha();
        assertNotSame(expResult, result);
    }

    /**
     * Test of setEmailRecuperarSenha method, of class SystemAccessBean.
     */
    @Test
    public void testSetEmailRecuperarSenha() {
        
        String emailRecuperarSenha = "";
        SystemAccessBean instance = new SystemAccessBean();
        instance.setEmailRecuperarSenha(emailRecuperarSenha);
    }

    /**
     * Test of verificaCadastroIncompleto method, of class SystemAccessBean.
     */
    @Test
    public void testVerificaCadastroIncompleto() {
        
        SystemAccessBean instance = new SystemAccessBean();
        boolean expResult = false;
        boolean result = instance.verificaCadastroIncompleto();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of verificaCadastroIncompleto method, of class SystemAccessBean.
     */
    @Test
    public void testVerificaCadastroIncompleto2() {
        
        SystemAccessBean instance = new SystemAccessBean();
        boolean expResult = true;
        instance.setCadastroIncompleto(true);
        boolean result;
        result = instance.verificaCadastroIncompleto();
        assertEquals(expResult, result);
    }    

    /**
     * Test of isCadastroIncompleto method, of class SystemAccessBean.
     */
    @Test
    public void testIsCadastroIncompleto() {
        
        SystemAccessBean instance = new SystemAccessBean();
        boolean expResult = false;
        boolean result = instance.isCadastroIncompleto();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCadastroIncompleto method, of class SystemAccessBean.
     */
    @Test
    public void testSetCadastroIncompleto() {
        
        boolean cadastroIncompleto = false;
        SystemAccessBean instance = new SystemAccessBean();
        instance.setCadastroIncompleto(cadastroIncompleto);
    }
}
