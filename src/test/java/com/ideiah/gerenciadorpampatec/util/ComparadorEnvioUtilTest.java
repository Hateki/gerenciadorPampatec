/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.util;

import com.ideiah.gerenciadorpampatec.model.Projeto;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * <p>
 * Classe para realizar testes unitários na classe
 * <code>ComparadorEnvioUtil</code>.</p>
 *
 * @author unipampa
 */
public class ComparadorEnvioUtilTest {

    public ComparadorEnvioUtilTest() {
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
     * Test of compare method, of class ComparadorEnvioUtil.
     * <p>
     * Teste para validar datas iguais.</p>
     */
    @Test
    public void testCompare() {
        

        Projeto o1 = new Projeto();
        Projeto o2 = new Projeto();

        Date date = new Date();
        o1.setDataEnvio(date);
        o2.setDataEnvio(date);

        ComparadorEnvioUtil instance = new ComparadorEnvioUtil();
        int expResult = 0;
        int result = instance.compare(o1, o2);
        assertEquals(expResult, result);
    }

    /**
     * Test of compare method, of class ComparadorEnvioUtil.
     * <p>
     * Teste para validar data diferentes.</p>
     */
    @Test
    public void testCompare2() {
        

        Projeto o1 = new Projeto();
        Projeto o2 = new Projeto();

        Date date = new Date();
        GregorianCalendar date2 = new GregorianCalendar(
                1500, Calendar.FEBRUARY, 12);
        o1.setDataEnvio(date);
        o2.setDataEnvio(date2.getGregorianChange());

        ComparadorEnvioUtil instance = new ComparadorEnvioUtil();
        int expResult = 0;
        int result = instance.compare(o1, o2);
        assertNotSame(expResult, result);
    }
}
