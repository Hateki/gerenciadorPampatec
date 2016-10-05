/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideiah.sisponto02.bean;

import ideiah.sisponto02.dao.PersistenciaDiretor;
import ideiah.sisponto02.dao.PersistenciaFuncionario;
import ideiah.sisponto02.dao.PersistenciaPonto;
import ideiah.sisponto02.modelo.Diretor;
import ideiah.sisponto02.modelo.Endereco;
import ideiah.sisponto02.modelo.Funcionario;
import ideiah.sisponto02.modelo.Ponto;
import ideiah.sisponto02.validacoes.ExcecoesValidacao;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 * Os testes estão todos considerando o cascade do Funcionario com Ponto sem ser
 * "ALL". Neste momento está "ALL", pois ainda será feito a migração de dados do
 * banco velho para o novo. Após isso, deve ser tirado do cascade all para
 * normal.
 *
 * @author Peterson
 */
@Ignore
public class FuncionarioBeanTest {

    Funcionario funcionario;
    Endereco endereco;
    Diretor diretor;
    FuncionarioBean funcionariobean;
    PersistenciaFuncionario persistefuncionario;
    PersistenciaDiretor persistediretor;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        endereco = new Endereco();
        funcionario = new Funcionario();
        funcionariobean = new FuncionarioBean();
        persistefuncionario = new PersistenciaFuncionario();
        persistediretor = new PersistenciaDiretor();
        diretor = new Diretor();
        funcionariobean.init();

        endereco.setBairro("Centro");
        endereco.setCidade("Alegrete");
        endereco.setComplemento("101");
        endereco.setEstado("RS");
        endereco.setLogradouro("rua");
        endereco.setNumero(459);
        endereco.setRua("Barão do Cerro Largo3");

        funcionario.setAtivo(true);
        funcionario.setCodigoAcesso("testa12");
        funcionario.setCpf("96746412113");
        funcionario.setCurso("ES");
        funcionario.setEmail("testeemail@gmail.com");
        funcionario.setEndereco(endereco);
        funcionario.setEstagioObrigatorio(true);
        funcionario.setInstituicao("UNIPAMPA");
        funcionario.setMatricula("9999999999");
        funcionario.setNome("Teste Nome TesteSobrenome");
        funcionario.setRg("999999999999999");
        funcionario.setTelefone("96372999");

        diretor.setCargo("Direto Administrativo");
        diretor.setDataPosse(new Date());
        diretor.setSenha("1234dddddd");
    }

    @After
    public void tearDown() {
        funcionariobean = null;
        persistefuncionario = null;
        funcionario = null;
    }

    @Test
    public void testSalvarFuncionario() throws ExcecoesValidacao {
        funcionariobean.setFuncionario(funcionario);
        funcionariobean.setCargoFuncionario("Desenvolvedor");

        funcionariobean.salvarFuncionario();

        Funcionario result1 = PersistenciaFuncionario.consultarFuncionarioPorCodigodeAcesso("testa12");
        String result = result1.getCodigoAcesso();
        String expResult = funcionario.getCodigoAcesso();
        assertEquals(result, expResult);
        persistefuncionario.excluir(funcionario);
        //persistefuncionario.excluir(endereco); //quando excluir funcionario já exclui endereço.
    }

    @Test
    public void testSalvarFuncionario2() throws ExcecoesValidacao {
        funcionario.setCodigoAcesso("aaaaaa21a");
        funcionariobean.setCargoFuncionario("Desenvolvedor");
        funcionariobean.setFuncionario(funcionario);
        funcionariobean.salvarFuncionario();

        assertEquals(PersistenciaFuncionario.consultarFuncionarioPorCodigodeAcesso("aaaaaa21a").getCodigoAcesso(), funcionario.getCodigoAcesso());

        persistefuncionario.excluir(funcionario);
        //persistefuncionario.excluir(endereco); //quando excluir funcionario já exclui endereço.
    }

    /**
     * Testando o salvamento de um funcionário desenvolvedor, dessa forma, não
     * pode ser um objeto Diretor atrelado a ele.
     *
     * @throws ExcecoesValidacao
     */
    @Test
    public void testSalvarFuncionario3() throws ExcecoesValidacao {
        funcionario.setCodigoAcesso("acessoB2");
        funcionariobean.setFuncionario(funcionario);
        funcionariobean.setCargoFuncionario("Desenvolvedor");
        funcionariobean.salvarFuncionario();
        Funcionario funcionarioBanco = PersistenciaFuncionario.consultarFuncionarioPorCodigodeAcesso("acessoB2");

        assertNull(funcionarioBanco.getDiretor());

        persistefuncionario.excluir(funcionario);
        //persistefuncionario.excluir(endereco); //quando excluir funcionario já exclui endereço.
    }

    @Test
    public void testSalvarFuncionarioPositivo() throws ExcecoesValidacao {

        funcionario.setCodigoAcesso("aaaaaa21a");
        funcionariobean.setCargoFuncionario("Desenvolvedor");
        funcionariobean.setFuncionario(funcionario);
        funcionariobean.salvarFuncionario();
        assertEquals(PersistenciaFuncionario.consultarFuncionarioPorCodigodeAcesso("aaaaaa21a").getCodigoAcesso(), funcionario.getCodigoAcesso());

        persistefuncionario.excluir(funcionario);
//persistefuncionario.excluir(endereco); //quando excluir funcionario já exclui endereço.    
    }

    //Devido ao teste feito na classe de validação não é necessário testar esse método agora.
//    @Test(expected = ExcecoesValidacao.class)
//    public void testSalvarFuncionarioNegativo() throws ExcecoesValidacao {
//
//        funcionario.setCodigoAcesso("aaaaaaaaaaaaaaa1");
//        funcionariobean.setFuncionario(funcionario);
//        funcionariobean.salvarFuncionario();
//    }
//    //@Test(expected = ExcecoesValidacao.class)
//    public void testSalvarFuncionarioNegativo2() throws ExcecoesValidacao {
//
//        funcionario.setCodigoAcesso("aaaaaaaaaaaaaaa");
//        funcionariobean.setFuncionario(funcionario);
//        funcionariobean.salvarFuncionario();
//    }
//    @Test
//    public void testAlterarFuncionario() {
//        funcionario.setCodigoAcesso("testaAltera");
//        persistefuncionario.alterarFuncionario(funcionario);
//
//        funcionariobean.setFuncionario(funcionario);
//        funcionario.setCodigoAcesso("testaAltera");
//        funcionariobean.alterarFuncionario();
//
//        assertEquals(PersistenciaFuncionario.consultarFuncionarioPorCodigodeAcesso("testaAltera").getCodigoAcesso(), funcionario.getCodigoAcesso());
//
//
//        persistefuncionario.excluir(funcionario);
//        persistefuncionario.excluir(endereco);
//
//    }
    /**
     * teste que exclui um funcionario.
     *
     * @throws ExcecoesValidacao
     */
    @Test
    public void testExcluirFuncionario() throws ExcecoesValidacao {

        funcionario.setCodigoAcesso("12sdsfsds");
        funcionariobean.setCargoFuncionario("Desenvolvedor");
        persistefuncionario.salvar(this.funcionario);
        funcionario = PersistenciaFuncionario.consultarFuncionarioPorCodigodeAcesso(funcionario.getCodigoAcesso());
        String id = String.valueOf(funcionario.getIdfuncionario());
        funcionariobean.setFuncionario(funcionario);
        funcionariobean.excluirFuncionario(funcionario);

        assertNull(persistefuncionario.consultarFuncionario("idfuncionario", id, Funcionario.class));
    }

    /**
     * teste que consulta uma lista de funcionarios.
     */
    @Test
    public void testConsultarFuncionarios() {

        List list;
        list = funcionariobean.consultarFuncionarios();
        assertNotNull(list);
    }

    /**
     *
     */
    @Test
    public void testEditarPositivo() {
        System.out.println("Testando método positivo para editar funcionario.");

        /**
         * configura a senha de acesso do funcionário
         */
        funcionario.setCodigoAcesso("aa21a");
        funcionariobean.setFuncionario(funcionario);
        /**
         * Configura os dados do diretor na Bean;
         */
        funcionariobean.setCargoFuncionario(diretor.getCargo());
        funcionariobean.setSenhaDiretor(diretor.getSenha());
        funcionariobean.setConfirmarSenhaDiretor(diretor.getSenha());
        funcionariobean.setDataPosseString("2016-04-12");
        /**
         * Valar funcionario diretor;
         */
        funcionariobean.salvarFuncionario();

        /**
         * Busca funcionario diretor
         */
        funcionario = PersistenciaFuncionario.consultarFuncionarioPorCodigodeAcesso("aa21a");
        funcionario.getEndereco().setRua("Cabral");
        funcionariobean.setFuncionario(funcionario);
        funcionariobean.setCargoFuncionario(funcionario.getDiretor().getCargo());
        funcionariobean.setDataPosseString("2016-04-12");
        funcionariobean.setSenhaDiretor(funcionario.getDiretor().getSenha());
        funcionariobean.setConfirmarSenhaDiretor(funcionario.getDiretor().getSenha());
        /**
         * Edita funcionario diretor;
         */
        funcionariobean.editarFuncionario();

        assertEquals(PersistenciaFuncionario.consultarFuncionarioPorCodigodeAcesso("aa21a").getEndereco().getRua(), "Cabral");
        persistefuncionario.excluir(funcionario);
    }

    //------------------------------Testes de Diretor na Bean---------------------------------------
    @Test
    public void testSalvarFuncionarioDiretorPositivo() {

        /**
         * configura a senha de acesso do funcionário
         */
        funcionario.setCodigoAcesso("aa21a");
        funcionariobean.setFuncionario(funcionario);
        /**
         * Configura os dados do diretor na Bean;
         */
        funcionariobean.setCargoFuncionario(diretor.getCargo());
        funcionariobean.setSenhaDiretor(diretor.getSenha());
        funcionariobean.setConfirmarSenhaDiretor(diretor.getSenha());
        funcionariobean.setDataPosseString("2016-04-12");

        funcionariobean.salvarFuncionario();
        assertEquals(PersistenciaFuncionario.consultarFuncionarioPorCodigodeAcesso("aa21a").getDiretor().getSenha(), diretor.getSenha());

        System.out.println("excluindo diretor.");

        persistefuncionario.excluir(funcionario);
        //  persistediretor.excluirDiretor(funcionario.getDiretor());
    }

    /**
     *
     */
    @Test
    public void testSalvarFuncionarioDiretorNegativo() {
        System.out.println("Testando método negativo de salvar funcionario, com data inválida.");
        /**
         * configura a senha de acesso do funcionário
         */
        funcionario.setCodigoAcesso("aa21a");
        funcionariobean.setFuncionario(funcionario);
        /**
         * Configura os dados do diretor na Bean;
         */
        funcionariobean.setCargoFuncionario(diretor.getCargo());
        funcionariobean.setSenhaDiretor(diretor.getSenha());
        funcionariobean.setConfirmarSenhaDiretor(diretor.getSenha());
        funcionariobean.setDataPosseString("201644-04-12");

        funcionariobean.salvarFuncionario();
        assertNull(PersistenciaFuncionario.consultarFuncionarioPorCodigodeAcesso("aa21a"));
    }

    /**
     *
     */
    @Test
    public void testSalvarAtualizarFuncionarioDiretorNegativo2() {
        System.out.println("Testando método negativo de salvar funcionario, com senha1 inválida.");

        /**
         * configura a senha de acesso do funcionário
         */
        funcionario.setCodigoAcesso("aa21a");
        funcionariobean.setFuncionario(funcionario);
        /**
         * Configura os dados do diretor na Bean;
         */
        funcionariobean.setCargoFuncionario(diretor.getCargo());
        funcionariobean.setSenhaDiretor(" ");
        funcionariobean.setConfirmarSenhaDiretor(diretor.getSenha());
        funcionariobean.setDataPosseString("2016-04-12");

        funcionariobean.salvarFuncionario();
        assertNull(PersistenciaFuncionario.consultarFuncionarioPorCodigodeAcesso("aa21a"));
    }

    /**
     *
     */
    @Test
    public void testSalvarAtualizarFuncionarioDiretorNegativo3() {
        System.out.println("Testando método negativo de salvar funcionario, com senha2 inválida.");

        /**
         * configura a senha de acesso do funcionário
         */
        funcionario.setCodigoAcesso("aa21a");
        funcionariobean.setFuncionario(funcionario);
        /**
         * Configura os dados do diretor na Bean;
         */
        funcionariobean.setCargoFuncionario(diretor.getCargo());
        funcionariobean.setSenhaDiretor(diretor.getSenha());
        funcionariobean.setConfirmarSenhaDiretor(null);
        funcionariobean.setDataPosseString("2016-04-12");

        funcionariobean.salvarFuncionario();
        assertNull(PersistenciaFuncionario.consultarFuncionarioPorCodigodeAcesso("aa21a"));
    }

    /**
     *
     */
    @Test
    public void testSalvarAtualizarFuncionarioDiretorNegativo4() {
        System.out.println("Testando método negativo de salvar funcionario, com senhas não conferem.");

        /**
         * configura a senha de acesso do funcionário
         */
        funcionario.setCodigoAcesso("aa21a");
        funcionariobean.setFuncionario(funcionario);
        /**
         * Configura os dados do diretor na Bean;
         */
        funcionariobean.setCargoFuncionario(diretor.getCargo());
        funcionariobean.setSenhaDiretor(diretor.getSenha());
        funcionariobean.setConfirmarSenhaDiretor("naoconfere");
        funcionariobean.setDataPosseString("2016-04-12");

        funcionariobean.salvarFuncionario();
        assertNull(PersistenciaFuncionario.consultarFuncionarioPorCodigodeAcesso("aa21a"));
    }

}
