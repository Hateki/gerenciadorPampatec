/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.dao;

import com.ideiah.gerenciadorpampatec.model.Empreendedor;
import com.ideiah.gerenciadorpampatec.model.Projeto;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * Classe testada localmente, todos testes passam
 */
@Ignore
public class ProjetoDaoTest {

    Projeto projeto;
    ProjetoDao instance;

    public ProjetoDaoTest() {
    }

    @Before
    public void setUp() {
        this.projeto = new Projeto();
        this.instance = new ProjetoDao();
    }

    /**
     * Teste que salva um projeto e verifica se o mesmo foi salvo corretamente
     * no banco Após é excluído o projeto do banco de dados.
     */
    @Test
    public void testSalvarProjetoDAO() {

        projeto.setNome("Projeto123");
        projeto.setContAcesso(123);
        projeto.setDataAvaliacao(new Date());
        projeto.setDataEnvio(new Date());
        projeto.setEdital("Edital 456");
        projeto.setPotencialEmprego("Emprego789");
        projeto.setStatus(1);

        Projeto result = new Projeto();

        result = instance.salvar(projeto);
        int codigo = result.getIdProjeto();

        assertEquals(result, instance.buscar(codigo));

        instance.excluir(result.getIdProjeto(), Projeto.class);

    }

    /**
     * Teste que salva um projeto e verifica se o mesmo foi salvo corretamente
     * no banco Após é excluído o projeto do banco de dados.
     */
    @Test
    public void testSalvarRetornandoProjeto() {

        projeto.setNome("Projeto123");
        projeto.setContAcesso(123);
        projeto.setDataAvaliacao(new Date());
        projeto.setDataEnvio(new Date());
        projeto.setEdital("Edital 456");
        projeto.setPotencialEmprego("Emprego789");
        projeto.setStatus(1);

        Projeto result = new Projeto();

        result = instance.salvarRetornandoProjeto(projeto);
        int codigo = result.getIdProjeto();

        assertEquals(result, instance.buscar(codigo));

        instance.excluir(result.getIdProjeto(), Projeto.class);

    }

    /**
     * Teste que salva um projeto e depois altera o seu nome para alteração no
     * banco de dados, confere se o nome foi alterado de fato. Após é excluído o
     * projeto do banco de dados.
     */
    @Test
    public void testUpdate() {

        projeto.setNome("Nome antes");
        projeto.setContAcesso(123);
        projeto.setDataAvaliacao(new Date());
        projeto.setDataEnvio(new Date());
        projeto.setEdital("Edital 456");
        projeto.setPotencialEmprego("Emprego789");
        projeto.setStatus(1);

        Projeto result = instance.salvarRetornandoProjeto(projeto);
        result.setNome("Nome Depois");
        instance.update(result);
        Projeto expected = (Projeto) instance.buscarObjetoCriteria("nome", "Nome Depois", Projeto.class);
        assertEquals(expected.getNome(), result.getNome());

        instance.excluir(result.getIdProjeto(), Projeto.class);
    }

    /**
     * Teste que busca uma lista de projetos de um status.
     * Após são excluídos os objetos do projeto.
     */
    @Test
    public void testBuscarListaProjetoPorStatus() {

        projeto.setNome("Nome antes");
        projeto.setContAcesso(123);
        projeto.setDataAvaliacao(new Date());
        projeto.setDataEnvio(new Date());
        projeto.setEdital("Edital 456");
        projeto.setPotencialEmprego("Emprego789");
        projeto.setStatus(1);
        Projeto result = new Projeto();
        result = instance.salvar(projeto);

        projeto.setNome("Projeto 123");
        projeto.setContAcesso(123456);
        projeto.setDataAvaliacao(new Date());
        projeto.setDataEnvio(new Date());
        projeto.setEdital("Edital 12334");
        projeto.setPotencialEmprego("Emprego789");
        projeto.setStatus(1);
        Projeto result2 = new Projeto();
        result2 = instance.salvar(projeto);

        List list = instance.buscarListaProjetoPorStatus(1);
        assertTrue(list.contains(result) && list.contains(result2));

        instance.excluir(result.getIdProjeto(), Projeto.class);
        instance.excluir(result2.getIdProjeto(), Projeto.class);
    }
}
