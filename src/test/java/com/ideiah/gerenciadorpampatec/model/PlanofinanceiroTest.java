/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlanofinanceiroTest {
    
    int id = 1;
    String estruturaCusto = "estrutura";
    String fonteReceita = "fonte";
    String investimento = "investimento";
    
    
    public PlanofinanceiroTest() {
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
     * Test of Constructor
     */
    @Test
    public void testPlanoFinanceiro(){
        Planofinanceiro pf = new Planofinanceiro(id, fonteReceita, estruturaCusto);
        
        assertEquals(id, pf.getIdPlanoFinanceiro());
        assertEquals(fonteReceita, pf.getFontesReceita());
        assertEquals(estruturaCusto, pf.getEstruturaCusto());
    }
    
    /**
     * Test of Constructor
     */
    @Test
    public void testPlanoFinanceiro2(){
        Planofinanceiro pf = new Planofinanceiro(id, fonteReceita, estruturaCusto, investimento);
        
        assertEquals(id, pf.getIdPlanoFinanceiro());
        assertEquals(fonteReceita, pf.getFontesReceita());
        assertEquals(estruturaCusto, pf.getEstruturaCusto());
        assertEquals(investimento, pf.getInvestimentoInicial());
    }
    
    /**
     * Test of retornaListaCustosFixos method, of class Planofinanceiro.
     */
    @Test
    public void testRetornaListaCustosFixos() {
        Planofinanceiro instance = new Planofinanceiro();
        ArrayList lista = new ArrayList();
        ArrayList result = instance.retornaListaCustosFixos();
        assertEquals(lista, result);
    }
    
    /**
     * Test of retornaListaCustosFixos method, of class Planofinanceiro.
     * tente se o custo é fixo, se é adiciona na lista do metodo
     * A lista do teste contem ambos, ou seja o resultado nao pode ser igual a lista do metodo
     */
    @Test
    public void testRetornaListaCustosFixos2() {
        Planofinanceiro instance = new Planofinanceiro();
        
        Custo custo = new Custo();
        custo.setTipo(Custo.CUSTO_FIXO);
        
        Custo custo2 = new Custo();
        custo2.setTipo(Custo.CUSTO_VARIAVEL);
        
        Set<Custo> custos = new HashSet<>();
        
        custos.add(custo);
        custos.add(custo2);
        
        ArrayList lista = new ArrayList();
        for (Custo ObjCusto : custos) {
            if (ObjCusto.getTipo() == Custo.CUSTO_FIXO) {
                lista.add(ObjCusto);
            }
        }
        
        instance.setCusto(custos);
        
        ArrayList result = instance.retornaListaCustosFixos();
        assertEquals(lista, result);
    }
    /**
     * Test of retornaListaCustosVariaveis method, of class Planofinanceiro.
     */
    @Test
    public void testRetornaListaCustosVariaveis() {
        Planofinanceiro instance = new Planofinanceiro();
        ArrayList lista = new ArrayList();
        ArrayList result = instance.retornaListaCustosVariaveis();
        assertEquals(lista, result);
    }
       /**
     * Test of retornaListaCustosVariaveis method, of class Planofinanceiro.
     * teste se é custo variavel, se for adiciona na lista do metodo.
     * A lista do teste contem ambos, ou seja o resultado nao pode ser igual a lista do metodo
     */
    @Test
    public void testRetornaListaCustosVariaveis2() {
        Planofinanceiro instance = new Planofinanceiro();
        
        Custo custo = new Custo();
        custo.setTipo(Custo.CUSTO_FIXO);
        
        Custo custo2 = new Custo();
        custo2.setTipo(Custo.CUSTO_VARIAVEL);
        
        Set<Custo> custos = new HashSet<>();
        
        custos.add(custo);
        custos.add(custo2);
        
        ArrayList lista = new ArrayList();
        for (Custo ObjCusto : custos) {
            if (ObjCusto.getTipo() == Custo.CUSTO_VARIAVEL) {
                lista.add(ObjCusto);
            }
        }
        
        instance.setCusto(custos);
        
        ArrayList result = instance.retornaListaCustosVariaveis();
        assertEquals(lista, result);
    }

    /**
     * Test of getIdPlanoFinanceiro method, of class Planofinanceiro.
     */
    @Test
    public void testGetIdPlanoFinanceiro() {
        Planofinanceiro instance = new Planofinanceiro();
        int expResult = 1;
        instance.setIdPlanoFinanceiro(expResult);
        int result = instance.getIdPlanoFinanceiro();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIdPlanoFinanceiro method, of class Planofinanceiro.
     */
    @Test
    public void testSetIdPlanoFinanceiro() {
        Planofinanceiro instance = new Planofinanceiro();
        int expResult = 1;
        instance.setIdPlanoFinanceiro(expResult);
        int result = instance.getIdPlanoFinanceiro();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFontesReceita method, of class Planofinanceiro.
     */
    @Test
    public void testGetFontesReceita() {
        Planofinanceiro instance = new Planofinanceiro();
        String expResult = "Fontes";
        instance.setFontesReceita(expResult);
        String result = instance.getFontesReceita();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFontesReceita method, of class Planofinanceiro.
     */
    @Test
    public void testSetFontesReceita() {
        Planofinanceiro instance = new Planofinanceiro();
        String expResult = "Fontes";
        instance.setFontesReceita(expResult);
        String result = instance.getFontesReceita();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEstruturaCusto method, of class Planofinanceiro.
     */
    @Test
    public void testGetEstruturaCusto() {
        Planofinanceiro instance = new Planofinanceiro();
        String expResult = "Estrutura";
        instance.setEstruturaCusto(expResult);
        String result = instance.getEstruturaCusto();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEstruturaCusto method, of class Planofinanceiro.
     */
    @Test
    public void testSetEstruturaCusto() {
        Planofinanceiro instance = new Planofinanceiro();
        String expResult = "Estrutura";
        instance.setEstruturaCusto(expResult);
        String result = instance.getEstruturaCusto();
        assertEquals(expResult, result);
    }

    /**
     * Test of getInvestimentoInicial method, of class Planofinanceiro.
     */
    @Test
    public void testGetInvestimentoInicial() {
        Planofinanceiro instance = new Planofinanceiro();
        String expResult = "Investimento";
        instance.setInvestimentoInicial(expResult);
        String result = instance.getInvestimentoInicial();
        assertEquals(expResult, result);
    }

    /**
     * Test of setInvestimentoInicial method, of class Planofinanceiro.
     */
    @Test
    public void testSetInvestimentoInicial() {
        Planofinanceiro instance = new Planofinanceiro();
        String expResult = "Investimento";
        instance.setInvestimentoInicial(expResult);
        String result = instance.getInvestimentoInicial();
        assertEquals(expResult, result);
    }

    /**
     * Test of getProjetos method, of class Planofinanceiro.
     */
    @Test
    public void testGetProjetos() {
        Planofinanceiro instance = new Planofinanceiro();
        Set expResult = null;
        instance.setProjetos(expResult);
        Set result = instance.getProjetos();
        assertEquals(expResult, result);
    }

    /**
     * Test of setProjetos method, of class Planofinanceiro.
     */
    @Test
    public void testSetProjetos() {
        Planofinanceiro instance = new Planofinanceiro();
        Set expResult = null;
        instance.setProjetos(expResult);
        Set result = instance.getProjetos();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCusto method, of class Planofinanceiro.
     */
    @Test
    public void testGetCusto() {
        
        Planofinanceiro instance = new Planofinanceiro();
        Set<Custo> expResult = null;
        instance.setCusto(expResult);
        Set<Custo> result = instance.getCusto();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCusto method, of class Planofinanceiro.
     */
    @Test
    public void testSetCusto() {
        
        Planofinanceiro instance = new Planofinanceiro();
        Set<Custo> expResult = null;
        instance.setCusto(expResult);
        Set<Custo> result = instance.getCusto();
        assertEquals(expResult, result);
    }

    /**
     * Test of getValorTotalFixo method, of class Planofinanceiro.
     */
    @Test
    public void testGetValorTotalFixo() {
        Planofinanceiro instance = new Planofinanceiro();
        Integer expResult = 100;
        instance.setValorTotalFixo(expResult);
        Integer result = instance.getValorTotalFixo();
        assertEquals(expResult, result);
    }

    /**
     * Test of setValorTotalFixo method, of class Planofinanceiro.
     */
    @Test
    public void testSetValorTotalFixo() {
        Planofinanceiro instance = new Planofinanceiro();
        Integer expResult = 100;
        instance.setValorTotalFixo(expResult);
        Integer result = instance.getValorTotalFixo();
        assertEquals(expResult, result);
    }

    /**
     * Test of getValorTotalVariavel method, of class Planofinanceiro.
     */
    @Test
    public void testGetValorTotalVariavel() {
        Planofinanceiro instance = new Planofinanceiro();
        Integer expResult = 100;
        instance.setValorTotalVariavel(expResult);
        Integer result = instance.getValorTotalVariavel();
        assertEquals(expResult, result);
    }

    /**
     * Test of setValorTotalVariavel method, of class Planofinanceiro.
     */
    @Test
    public void testSetValorTotalVariavel() {
        Planofinanceiro instance = new Planofinanceiro();
        Integer expResult = 100;
        instance.setValorTotalVariavel(expResult);
        Integer result = instance.getValorTotalVariavel();
        assertEquals(expResult, result);
    }
    
}
