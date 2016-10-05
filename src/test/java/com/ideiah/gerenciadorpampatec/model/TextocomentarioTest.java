/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.model;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TextocomentarioTest {
    
    Integer id = 1;
    GerenteRelacionamento gerente = new GerenteRelacionamento();
    String textoComentario = "comentario";
    Date dataAlteracao = new Date();
    Date dataSubmissao = new Date();
    Integer tipo = 1;
    Set<ComentarioProjeto> comentarioProjeto = new Set<ComentarioProjeto>() {
        @Override
        public int size() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public boolean isEmpty() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public boolean contains(Object o) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Iterator<ComentarioProjeto> iterator() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Object[] toArray() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public <T> T[] toArray(T[] a) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public boolean add(ComentarioProjeto e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public boolean remove(Object o) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public boolean addAll(Collection<? extends ComentarioProjeto> c) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void clear() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    };
    
    
    public TextocomentarioTest() {
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
     * test of Constructor TextoComentario
     */
    @Test
    public void textTextoComentario(){
        
        Textocomentario texto = new Textocomentario(id, gerente);
        
        texto.setGerenteRelacionamento(gerente);
        texto.setIdtextocomentario(id);
        
        assertEquals(gerente, texto.getGerenteRelacionamento());
        assertEquals(id, texto.getIdtextocomentario());
    }
        /**
     * test of Constructor TextoComentario
     */
    @Test
    public void textTextoComentario2(){
        
        Textocomentario texto = new Textocomentario(id, gerente, textoComentario, dataAlteracao, dataSubmissao, tipo, comentarioProjeto);
        
        texto.setGerenteRelacionamento(gerente);
        texto.setIdtextocomentario(id);
        
        assertEquals(gerente, texto.getGerenteRelacionamento());
        assertEquals(id, texto.getIdtextocomentario());
        assertEquals(textoComentario, texto.getTexto());
        assertEquals(dataAlteracao, texto.getDataAlteracao());
        assertEquals(dataSubmissao, texto.getDataSubmissao());
        assertEquals(tipo, texto.getTipo());
        assertEquals(comentarioProjeto, texto.getComentarioprojetos());
    }
    
    /**
     * Test of getDataAlteracaoFormatada method, of class Textocomentario.
     */
    @Test
    public void testGetDataAlteracaoFormatada() {
        Textocomentario instance = new Textocomentario();
        instance.setDataAlteracao(new Date());
        
        String stringDataAlteracao, Data, Hora;
        Date dataDiaMesAno, dataHoraMinSeg;
        
        SimpleDateFormat diaMesAno = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat horaMinSeg = new SimpleDateFormat("HH:mm:ss");
       
            dataHoraMinSeg = instance.getDataAlteracao();
            dataDiaMesAno = instance.getDataAlteracao();

            Hora = horaMinSeg.format(dataHoraMinSeg);
            Data = diaMesAno.format(dataDiaMesAno);

            stringDataAlteracao = (Hora + " em " + Data);

        String result = instance.getDataAlteracaoFormatada();
        
        assertEquals(stringDataAlteracao, result);
    }
    /**
     * Test of getDataAlteracaoFormatada method, of class Textocomentario.
     */
    @Test
    public void testGetDataAlteracaoFormatada2() {
        Textocomentario instance = new Textocomentario();
        instance.setDataAlteracao(null);

        
        assertEquals(instance.getDataAlteracaoFormatada(), "");
    }
    
    /**
     * Test of getIdtextocomentario method, of class Textocomentario.
     */
    @Test
    public void testGetIdtextocomentario() {
        Textocomentario instance = new Textocomentario();
        Integer expResult = 1;
        instance.setIdtextocomentario(expResult);
        Integer result = instance.getIdtextocomentario();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIdtextocomentario method, of class Textocomentario.
     */
    @Test
    public void testSetIdtextocomentario() {
        Textocomentario instance = new Textocomentario();
        Integer expResult = 1;
        instance.setIdtextocomentario(expResult);
        Integer result = instance.getIdtextocomentario();
        assertEquals(expResult, result);
    }

    
    /**
     * Test of getComentarioprojetos method, of class Textocomentario.
     */
    @Test
    public void testGetComentarioprojetos() {
        Textocomentario instance = new Textocomentario();
        Set expResult = null;
        instance.setComentarioprojetos(expResult);
        Set result = instance.getComentarioprojetos();
        assertEquals(expResult, result);
    }

    /**
     * Test of setComentarioprojetos method, of class Textocomentario.
     */
    @Test
    public void testSetComentarioprojetos() {
        Textocomentario instance = new Textocomentario();
        Set expResult = null;
        instance.setComentarioprojetos(expResult);
        Set result = instance.getComentarioprojetos();
        assertEquals(expResult, result);
    }
    
}
