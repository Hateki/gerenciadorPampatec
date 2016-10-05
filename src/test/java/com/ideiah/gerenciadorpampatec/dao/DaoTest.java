/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.dao;

import com.ideiah.gerenciadorpampatec.model.Empreendedor;
import com.ideiah.gerenciadorpampatec.model.Projeto;
import com.ideiah.gerenciadorpampatec.model.Usuario;
import java.util.ArrayList;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Peterson
 */
//@Ignore
//public class DaoTest {
//
//    private static final int CODIGO_EMPREENDEDOR = 99999999;
//
//    Dao instance;
//
//    public DaoTest() {
//    }
//
//    @Before
//    public void setUp() {
//        instance = new DaoImpl();
//
//    }
//
//    @After
//    public void tearDown() {
//        instance = null;
//    }
//
//    public class DaoImpl extends Dao {
//    }
//
//    /**
//     * Salvar um Empreendedor;
//     */
//    @Test
//    public void testSalvar1() {
//        Usuario empreendedor = new Empreendedor();
//        empreendedor.setCpf("71957794240");
//        Usuario result = (Usuario) instance.salvar(empreendedor);
//        Usuario expected = (Usuario) instance.buscarObjetoCriteria("cpf", "71957794240", Empreendedor.class);
//        assertEquals(expected, result);
//        instance.excluir(result.getIdUsuario(), Usuario.class);
//    }
//
//    /**
//     * Salvar um Empreendedor nulo;
//     */
//    @Test
//    public void testSalvar2() {
//        Empreendedor empreendedor = null;
//        Usuario result = (Usuario) instance.salvar(empreendedor);
//        assertNull(result);
//        if (result != null) {
//            instance.excluir(result.getIdUsuario(), Usuario.class);
//        }
//    }
//
//    /**
//     * Teste de alterar um objeto; Primeiro é salvo um objeto no banco e depois
//     * alterado o seu nome. Buscamos o objeto pelo nome alterado e esperamos que
//     * a consulta venha com o objeto.
//     */
//    @Test
//    public void testUpdatePositivo() {
//        Usuario empreendedor = new Empreendedor();
//        empreendedor.setNome("Nome Antes");
//        Usuario result = (Usuario) instance.salvar(empreendedor);
//        result.setNome("Nome Depois");
//        instance.update(result);
//        Usuario expected = (Usuario) instance.buscarObjetoCriteria("nome", "Nome Depois", Empreendedor.class);
//        assertEquals(expected.getNome(), result.getNome());
//        instance.excluir(result.getIdUsuario(), Usuario.class);
//    }
//
//    /**
//     * Teste de excluir um objeto da dao que passa um int e a classe como
//     * parametros. é criado um objeto empreendedor e salvo no banco de dados
//     * depois é excluído esse mesmo objeto. Consultamos pelo o id que era do
//     * objeto e esperamos que a consulta venha nula pois o objeto não existe
//     * mais no banco
//     */
//    @Test
//    public void testExcluirPositivo() {
//        Usuario usuario = new Empreendedor();
//        usuario = (Usuario) instance.salvar(usuario);
//        int id = usuario.getIdUsuario();
//        instance.excluir(usuario.getIdUsuario(), Usuario.class);
//        Usuario result = (Usuario) instance.buscarObjeto(id, Empreendedor.class);
//        assertNull(result);
//    }
//
//    /**
//     * Teste de excluir um objeto da dao que não existe passa um int e a classe
//     * como parâmetros. é setado uma id que não existe e chama o excluir por
//     * aquele id o método retorna falso pois não existe o objeto
//     */
//    @Test
//    public void testExcluirNegativo() {
//        Usuario usuario = new Empreendedor();
//        usuario.setIdUsuario(10000000);
//        boolean result = instance.excluir(usuario.getIdUsuario(), Empreendedor.class);
//        assertFalse(result);
//    }
//
//    /**
//     * Teste de excluir um objeto da dao que passa uma String e a classe como
//     * parametros. é criado um objeto empreendedor e salvo no banco de dados
//     * depois é excluído esse mesmo objeto. Consultamos pelo o id que era do
//     * objeto e esperamos que a consulta venha nula pois o objeto não existe
//     * mais no banco
//     */
//    @Test
//    public void testExcluir2Positivo() {
//        Usuario usuario = new Empreendedor();
//        usuario = (Usuario) instance.salvar(usuario);
//        String id = String.valueOf(usuario.getIdUsuario());
//        instance.excluir(id, Usuario.class);
//        Usuario result = (Usuario) instance.buscarObjeto(usuario.getIdUsuario(), Empreendedor.class);
//        assertNull(result);
//    }
//
//    /**
//     * Teste de excluir um objeto da dao que não existe, passa uma String e a
//     * classe como parâmetros. é setado uma id que não existe e chama o excluir
//     * por aquele id o método retorna falso pois não existe o objeto
//     */
//    @Test
//    public void testExcluir2Negativo() {
//        Usuario usuario = new Empreendedor();
//        usuario.setIdUsuario(10000000);
//        String id = String.valueOf(usuario.getIdUsuario());
//        boolean result = instance.excluir(id, Empreendedor.class);
//        assertFalse(result);
//    }
//
//    /**
//     * Testa busca Objetos no banco de dados. Criam-se dois objetos de
//     * empreendedor e após são salvos no banco de dados chama-se o método de
//     * buscar e verifica-se se a lista contém os dois objetos salvos
//     * anteriormente
//     */
//    @Test
//    public void testBuscarObjetos() {
//        Usuario usuario1 = new Empreendedor();
//        usuario1 = (Usuario) instance.salvar(usuario1);
//        Usuario usuario2 = new Empreendedor();
//        usuario2 = (Usuario) instance.salvar(usuario2);
//
//        ArrayList list = instance.buscarObjetos(Empreendedor.class);
//
//        boolean result = list.contains(usuario1) && list.contains(usuario2);
//
//        assertTrue(result);
//
//        instance.excluir(usuario1.getIdUsuario(), Empreendedor.class);
//        instance.excluir(usuario2.getIdUsuario(), Empreendedor.class);
//
//    }
//
//    /**
//     * Testa o método de buscar objetos com critérios. Primeiro cria objetos no
//     * banco com status diferentes para garantir que o banco esteja preenchido.
//     * Depois busca os objetos com um critério definido. Depois se os objetos
//     * retornados respeitam os critérios estabelecidos. Depois apaga os
//     * registros criados.
//     */
//    @Test
//    public void testBuscarObjetosCriteria() {
//        boolean flag = false;
//        Projeto projeto = new Projeto();
//        Projeto projetoStatus2 = new Projeto();
//        projeto.setStatus(1);
//        projetoStatus2.setStatus(2);
//        projeto = (Projeto) instance.salvar(projeto);
//        projetoStatus2 = (Projeto) instance.salvar(projetoStatus2);
//
//        ArrayList<Projeto> result = (ArrayList<Projeto>) instance.buscarObjetosCritera("status",
//                1, Projeto.class);
//        for (Projeto projetoLaco : result) {
//            if (projetoLaco.getStatus() != 1) {
//                flag = true;
//                break;
//            }
//        }
//        assertFalse(flag);
//        instance.excluir(projeto.getIdProjeto(), Projeto.class);
//        instance.excluir(projetoStatus2.getIdProjeto(), Projeto.class);
//    }
//
//    /**
//     * teste que executa o método "buscarObjetoCriteriaINT". É salvo um objeto e
//     * buscado pelo campo de id no banco. Deposi são comparados os objetos.
//     */
//    @Test
//    public void testeBuscarObjetoCriteriaINT() {
//        Projeto projeto = new Projeto();
//        projeto.setStatus(1);
//        projeto = (Projeto) instance.salvar(projeto);
//
//        int id = projeto.getIdProjeto();
//        Projeto result = (Projeto) instance.buscarObjetoCriteriaINT("idProjeto", id, Projeto.class);
//        assertEquals(result, projeto);
//
//        instance.excluir(projeto.getIdProjeto(), Projeto.class);
//    }
//
//    /**
//     * teste que executa o método modificador da sessão. *
//     */
//    @Test
//    public void testSetSession() {
//        Session session;
//        session = HibernateUtil.getSessionFactory().openSession();
//        instance.setSession(session);
//
//        Session session2 = instance.getSession();
//        assertEquals(session2, session);
//    }
//}
