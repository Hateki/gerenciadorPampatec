/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideiah.sisponto02.validacoes;

import ideiah.sisponto02.bean.FuncionarioBean;
import ideiah.sisponto02.dao.PersistenciaDiretor;
import ideiah.sisponto02.dao.PersistenciaFuncionario;
import ideiah.sisponto02.modelo.Diretor;
import ideiah.sisponto02.modelo.Endereco;
import ideiah.sisponto02.modelo.Funcionario;
import java.util.Date;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Peterson
 */
@Ignore
public class ValidacaoDiretorTest {

    ValidacaoDiretor instance;

    public ValidacaoDiretorTest() {
    }

    @Before
    public void setUp() {
        instance = new ValidacaoDiretor();
    }

    @After
    public void tearDown() {
        instance = null;
    }

    /**
     * Test of validarData method, of class ValidacaoDiretor.
     */
    @Test
    public void testValidarDataNegativo() {
        System.out.println("Data não pode ser posterior a atual");
        Date dataAmanha = new Date();
        dataAmanha.setDate(dataAmanha.getDate() + 1);
        instance.setDataPosse(dataAmanha);
        instance.validarData();
        assertTrue(instance.isDataPosteriorAAtual());
    }

    /**
     * Test of validarData method, of class ValidacaoDiretor.
     */
    @Test
    public void testValidarDataPositivo() {
        System.out.println("Data não pode ser posterior a atual");
        Date dataOntem = new Date();
        dataOntem.setDate(dataOntem.getDate() - 4);
        instance.setDataPosse(dataOntem);
        instance.validarData();
        assertFalse(instance.isDataPosteriorAAtual());
    }

    /**
     * Test of validarData method, of class ValidacaoDiretor.
     */
    @Test
    public void testValidarDataPositivo2() {
        System.out.println("Data não pode ser posterior a atual");
        Date data = new Date();
        instance.setDataPosse(data);
        instance.validarData();
        assertFalse(instance.isDataPosteriorAAtual());
    }

    /**
     * Test of validarData method, of class ValidacaoDiretor.
     */
    @Test
    public void testValidarDataNegativo2() {
        System.out.println("Data não pode ser vazia");
        Date data = null;
        instance.setDataPosse(data);
        instance.validarData();
        assertTrue(instance.isDataPosseVazia());
    }

    /**
     * Test of validarSenha method, of class ValidacaoDiretor.
     */
    @Test
    public void testValidarSenha1Positivo() {
        System.out.println("Senha1 não pode ser vazia");
        String senha1 = "123umdoistres";
        instance.setSenhaDiretor(senha1);
        instance.validarSenha();

        assertFalse(instance.isSenhaDiretorVazia());
    }

    /**
     * Test of validarSenha method, of class ValidacaoDiretor.
     */
    @Test
    public void testValidarSenha1Negativo() {
        System.out.println("Senha1 não pode ser vazia");
        String senha1 = "";
        instance.setSenhaDiretor(senha1);
        instance.validarSenha();

        assertTrue(instance.isSenhaDiretorVazia());
    }

    /**
     * Test of validarSenha method, of class ValidacaoDiretor.
     */
    @Test
    public void testValidarSenha1Negativo2() {
        System.out.println("Senha1 não pode ser vazia");
        String senha1 = null;
        instance.setSenhaDiretor(senha1);
        instance.validarSenha();

        assertTrue(instance.isSenhaDiretorVazia());
    }

    /**
     * Test of validarSenha method, of class ValidacaoDiretor.
     */
    @Test
    public void testValidarSenha1Negativo3() {
        System.out.println("Senha1 não pode ser vazia");
        String senha1 = " ";
        instance.setSenhaDiretor(senha1);
        instance.validarSenha();

        assertTrue(instance.isSenhaDiretorVazia());
    }

    /**
     * Test of validarSenha method, of class ValidacaoDiretor.
     */
    @Test
    public void testValidarSenha2Positivo() {
        System.out.println("Senha2 não pode ser vazia");
        //String senha1 = "123123F";
        String senha2 = "123123F";

        instance.setSenhaConfirmacao(senha2);
        instance.validarSenha();

        assertFalse(instance.isConfirmacaoSenhaDiretorVazia());
    }

    /**
     * Test of validarSenha method, of class ValidacaoDiretor.
     */
    @Test
    public void testValidarSenha2Negativo() {
        System.out.println("Senha2 não pode ser vazia");
        String senha2 = "";
        instance.setSenhaConfirmacao(senha2);
        instance.validarSenha();

        assertTrue(instance.isConfirmacaoSenhaDiretorVazia());
    }

    /**
     * Test of validarSenha method, of class ValidacaoDiretor.
     */
    @Test
    public void testValidarSenha2Negativo2() {
        System.out.println("Senha2 não pode ser vazia");
        String senha2 = null;
        instance.setSenhaConfirmacao(senha2);
        instance.validarSenha();

        assertTrue(instance.isConfirmacaoSenhaDiretorVazia());
    }

    /**
     * Test of validarSenha method, of class ValidacaoDiretor.
     */
    @Test
    public void testValidarSenha2Negativo3() {
        System.out.println("Senha2 não pode ser vazia");
        String senha1 = " ";
        instance.setSenhaConfirmacao(senha1);
        instance.validarSenha();

        assertTrue(instance.isConfirmacaoSenhaDiretorVazia());
    }

    /**
     * Test of validarSenha method, of class ValidacaoDiretor.
     */
    @Test
    public void testValidarSenhaConferemPositivo() {
        System.out.println("Senha 1 e Senha 2 devem ser iguais");
        String senha1 = "123umdoistres";
        String senha2 = "123umdoistres";

        instance.setSenhaDiretor(senha1);
        instance.setSenhaConfirmacao(senha2);
        instance.validarSenha();

        assertFalse(instance.isSenhasNaoConferem());
    }

    /**
     * Test of validarSenha method, of class ValidacaoDiretor.
     */
    @Test
    public void testValidarSenhaConferemNegativo() {
        System.out.println("Senha 1 e Senha 2 devem ser iguais");
        String senha1 = "23umdoisres";
        String senha2 = "123umdoistres";

        instance.setSenhaDiretor(senha1);
        instance.setSenhaConfirmacao(senha2);
        instance.validarSenha();

        assertTrue(instance.isSenhasNaoConferem());
    }

    /**
     * Test of validarSenha method, of class ValidacaoDiretor.
     */
    @Test
    public void testValidarSenhaConferemNegativo2() {
        System.out.println("Senha 1 e Senha 2 devem ser iguais");
        String senha1 = "12Tres";
        String senha2 = "12tres";

        instance.setSenhaDiretor(senha1);
        instance.setSenhaConfirmacao(senha2);
        instance.validarSenha();

        assertTrue(instance.isSenhasNaoConferem());
    }

    /**
     * Test of validarSenha method, of class ValidacaoDiretor.
     */
    @Test
    public void testValidarSenhaConferemNegativo3() {
        System.out.println("Senha 1 e Senha 2 devem ser iguais");
        String senha1 = " 12Tres";
        String senha2 = "12tres";

        instance.setSenhaDiretor(senha1);
        instance.setSenhaConfirmacao(senha2);
        instance.validarSenha();

        assertTrue(instance.isSenhasNaoConferem());
    }

    /**
     * Test of validarSenha method, of class ValidacaoDiretor.
     */
    @Test
    public void testValidarSenhaConferemPositivo2() {
        System.out.println("Senha 1 e Senha 2 devem ser iguais");
        String senha1 = " 12Tres";
        String senha2 = " 12Tres";

        instance.setSenhaDiretor(senha1);
        instance.setSenhaConfirmacao(senha2);
        instance.validarSenha();

        assertFalse(instance.isSenhasNaoConferem());
    }

    /**
     * Test of validarSenha method, of class ValidacaoDiretor.
     */
    @Test
    public void testVerificaDiretorPositivo() {
        System.out.println("Todos dados validos");

        instance.setSenhaDiretor("senha");
        instance.setSenhaConfirmacao("senha");
        instance.setDataPosse(new Date());
        instance.validarDiretor();

        assertTrue(instance.verificaDiretor());
    }

    /**
     * Test of validarSenha method, of class ValidacaoDiretor.
     */
    @Test
    public void testVerificaDiretorNegativo() {
        System.out.println("Senha1 invalida");

        instance.setSenhaDiretor(" ");
        instance.setSenhaConfirmacao("senha");
        instance.setDataPosse(new Date());
        instance.validarDiretor();

        assertFalse(instance.verificaDiretor());
    }

    /**
     * Test of validarSenha method, of class ValidacaoDiretor.
     */
    @Test
    public void testVerificaDiretorNegativo2() {
        System.out.println("Senha2 invalida");

        instance.setSenhaDiretor("senha");
        instance.setSenhaConfirmacao(" ");
        instance.setDataPosse(new Date());
        instance.validarDiretor();

        assertFalse(instance.verificaDiretor());
    }

    /**
     * Test of validarSenha method, of class ValidacaoDiretor.
     */
    @Test
    public void testVerificaDiretorNegativo3() {
        System.out.println("Senhas não conferem");

        instance.setSenhaDiretor("senha");
        instance.setSenhaConfirmacao("senhasadas");
        instance.setDataPosse(new Date());
        instance.validarDiretor();

        assertFalse(instance.verificaDiretor());
    }

    /**
     * Test of validarSenha method, of class ValidacaoDiretor.
     */
    @Test
    public void testVerificaDiretorNegativo4() {
        System.out.println("data invalida");

        instance.setSenhaDiretor("senha");
        instance.setSenhaConfirmacao("senha");
        instance.setDataPosse(null);
        instance.validarDiretor();

        assertFalse(instance.verificaDiretor());
    }

    /**
     * Test of validarSenha method, of class ValidacaoDiretor.
     */
    @Test
    public void testVerificaDiretorNegativo5() {
        System.out.println("data de amanha");

        instance.setSenhaDiretor("senha");
        instance.setSenhaConfirmacao("senha");
        Date dataAmanha = new Date();
        dataAmanha.setDate(dataAmanha.getDate() + 1);

        instance.setDataPosse(dataAmanha);
        instance.validarDiretor();

        assertFalse(instance.verificaDiretor());
    }

    /**
     * Test of validarSenha method, of class ValidacaoDiretor.
     */
    @Test
    public void testVerificaDiretorNegativo6() {
        System.out.println("tudo inválido");

        instance.setSenhaDiretor(" ");
        instance.setSenhaConfirmacao(null);
        instance.setDataPosse(null);
        instance.validarDiretor();

        assertFalse(instance.verificaDiretor());
    }
}
