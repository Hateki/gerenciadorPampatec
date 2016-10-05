/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideiah.sisponto02.dao;

import ideiah.sisponto02.modelo.Endereco;
import ideiah.sisponto02.modelo.Funcionario;
import ideiah.sisponto02.modelo.Ponto;
import java.util.Date;
import java.util.List;
import org.hibernate.PropertyValueException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Jonas Chagas
 */

public class PersistenciaFuncionarioTest {

    PersistenciaFuncionario persistefuncionario;
    Funcionario funcionario;
    Ponto ponto;

    public PersistenciaFuncionarioTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        persistefuncionario = new PersistenciaFuncionario();
        //funcionario = new Funcionario();
    }

    @After
    public void tearDown() {
        PersistenciaPonto persPonto = new PersistenciaPonto();
        persPonto.excluirPonto(ponto);
        persistefuncionario.excluir(funcionario);
    }

    /**
     * Test of consultarListaFuncionario method, of class
     * PersistenciaFuncionario.
     */
    @Test
    public void testConsultarListaFuncionario() {
        System.out.println("Testando método consultarListaFuncionario");

        Endereco endereco = new Endereco();
        endereco.setBairro("Centro");
        endereco.setCidade("Alegrete");
        endereco.setComplemento("101");
        endereco.setEstado("RS");
        endereco.setLogradouro("rua");
        endereco.setNumero(459);
        endereco.setRua("Barão do Cerro Largo1");

        funcionario = new Funcionario();
        funcionario.setAtivo(true);
        funcionario.setCodigoAcesso("eduardo2201");
        funcionario.setCpf("11111111111");
        funcionario.setCurso("ES");
        funcionario.setEmail("eduardoamaral@gmail.com");
        funcionario.setEndereco(endereco);
        funcionario.setEstagioObrigatorio(true);
        funcionario.setInstituicao("UNIPAMPA");
        funcionario.setMatricula("131150105");
        funcionario.setNome("Eduardo Amaral1");
        funcionario.setRg("12312312312");
        funcionario.setTelefone("96372999");

        persistefuncionario.salvar(funcionario);

        Endereco endereco2 = new Endereco();
        endereco2.setBairro("Centro");
        endereco2.setCidade("Alegrete");
        endereco2.setComplemento("101");
        endereco2.setEstado("RS");
        endereco2.setLogradouro("rua");
        endereco2.setNumero(459);
        endereco2.setRua("Barão do Cerro Largo2");

        Funcionario funcionario2;
        funcionario2 = new Funcionario();
        funcionario2.setAtivo(true);
        funcionario2.setCodigoAcesso("jonas2201");
        funcionario2.setCpf("03599999999");
        funcionario2.setCurso("ES");
        funcionario2.setEmail("eduardoamaral@gmail.com");
        funcionario2.setEndereco(endereco2);
        funcionario2.setEstagioObrigatorio(true);
        funcionario2.setInstituicao("UNIPAMPA");
        funcionario2.setMatricula("131150105");
        funcionario2.setNome("Jonas Chagas2");
        funcionario2.setRg("12312312312");
        funcionario2.setTelefone("96372999");

        persistefuncionario.salvar(funcionario2);
        List list = persistefuncionario.consultarListaFuncionario();

        boolean funcionarioResult = list.contains(funcionario) && list.contains(funcionario2);

        assertEquals(true, funcionarioResult);
    }

    /**
     * Test of alterarFuncionario method, of class PersistenciaFuncionario.
     */
    @Test
    public void testAlterarFuncionario() {
        System.out.println("Testando método alterarFuncionario");

        Endereco endereco = new Endereco();
        endereco.setBairro("Centro");
        endereco.setCidade("Alegrete");
        endereco.setComplemento("101");
        endereco.setEstado("RS");
        endereco.setLogradouro("rua");
        endereco.setNumero(459);
        endereco.setRua("Barão do Cerro Largo3");

        funcionario = new Funcionario();
        funcionario.setAtivo(true);
        funcionario.setCodigoAcesso("eduardo2202");
        funcionario.setCpf("11111111111");
        funcionario.setCurso("ES");
        funcionario.setEmail("eduardoamaral@gmail.com");
        funcionario.setEndereco(endereco);
        funcionario.setEstagioObrigatorio(true);
        funcionario.setInstituicao("UNIPAMPA");
        funcionario.setMatricula("131150105");
        funcionario.setNome("Eduardo Amaral3");
        funcionario.setRg("12312312312");
        funcionario.setTelefone("96372999");

        persistefuncionario.salvar(funcionario);

        funcionario.setNome("EduardoAlterado");

        PersistenciaFuncionario instance = new PersistenciaFuncionario();
        instance.alterarFuncionario(funcionario);
        Funcionario funcionarioResult = PersistenciaFuncionario.consultarFuncionarioPorCodigodeAcesso("eduardo2202");
        assertEquals(funcionario, funcionarioResult);
    }

    /**
     * Test of consultarFuncionario method, of class PersistenciaFuncionario.
     */
    @Test
    public void testConsultarFuncionario() {
        System.out.println("Testando método consultarFuncionario");

        Endereco endereco = new Endereco();
        endereco.setBairro("Centro");
        endereco.setCidade("Alegrete");
        endereco.setComplemento("101");
        endereco.setEstado("RS");
        endereco.setLogradouro("rua");
        endereco.setNumero(459);
        endereco.setRua("Barão do Cerro Largo4");

        funcionario = new Funcionario();
        funcionario.setAtivo(true);
        funcionario.setCodigoAcesso("eduardo2203");
        funcionario.setCpf("11111111111");
        funcionario.setCurso("ES");
        funcionario.setEmail("eduardoamaral@gmail.com");
        funcionario.setEndereco(endereco);
        funcionario.setEstagioObrigatorio(true);
        funcionario.setInstituicao("UNIPAMPA");
        funcionario.setMatricula("131150105");
        funcionario.setNome("Eduardo Amaral4");
        funcionario.setRg("12312312312");
        funcionario.setTelefone("96372999");

        persistefuncionario.salvar(funcionario);

        String coluna = "codigoAcesso";
        String valor = "eduardo2203";
        Class classe = Funcionario.class;

        Funcionario result = persistefuncionario.consultarFuncionario(coluna, valor, classe);
        assertEquals(funcionario, result);
    }

    /**
     * Teste que realiza a consulta de um funcionário através do código de
     * acesso. PersistenciaFuncionario.
     */
    @Test
    public void testConsultarFuncionarioPorCodigodeAcesso() {
        System.out.println("Testando método consultarFuncionarioPorCodigodeAcesso");

        Endereco endereco = new Endereco();
        endereco.setBairro("Centro");
        endereco.setCidade("Alegrete");
        endereco.setComplemento("101");
        endereco.setEstado("RS");
        endereco.setLogradouro("rua");
        endereco.setNumero(459);
        endereco.setRua("Barão do Cerro Largo5");

        funcionario = new Funcionario();
        funcionario.setAtivo(true);
        funcionario.setCodigoAcesso("eduardo2260");
        funcionario.setCpf("11111111111");
        funcionario.setCurso("ES");
        funcionario.setEmail("eduardoamaral@gmail.com");
        funcionario.setEndereco(endereco);
        funcionario.setEstagioObrigatorio(true);
        funcionario.setInstituicao("UNIPAMPA");
        funcionario.setMatricula("131150105");
        funcionario.setNome("Eduardo Amaral5");
        funcionario.setRg("12312312312");
        funcionario.setTelefone("96372999");

        persistefuncionario.salvar(funcionario);

        String codigoAcesso = funcionario.getCodigoAcesso();
        Funcionario expResult = funcionario;
        Funcionario result = PersistenciaFuncionario.consultarFuncionarioPorCodigodeAcesso(codigoAcesso);
        assertEquals(expResult, result);
    }

    /**
     * Teste que realiza a consulta de um funcionário através do código de
     * acesso. PersistenciaFuncionario.
     */
    @Test
    public void testConsultarNegativoFuncionarioPorCodigodeAcesso() {
        System.out.println("Testando método consultarNegativoFuncionarioPorCodigodeAcesso");

        Endereco endereco = new Endereco();
        endereco.setBairro("Centro");
        endereco.setCidade("Alegrete");
        endereco.setComplemento("101");
        endereco.setEstado("RS");
        endereco.setLogradouro("rua");
        endereco.setNumero(459);
        endereco.setRua("Barão do Cerro Largo5");

        funcionario = new Funcionario();
        funcionario.setAtivo(true);
        funcionario.setCodigoAcesso("eduardo2260");
        funcionario.setCpf("11111111111");
        funcionario.setCurso("ES");
        funcionario.setEmail("eduardoamaral@gmail.com");
        funcionario.setEndereco(endereco);
        funcionario.setEstagioObrigatorio(true);
        funcionario.setInstituicao("UNIPAMPA");
        funcionario.setMatricula("131150105");
        funcionario.setNome("Eduardo Amaral5");
        funcionario.setRg("12312312312");
        funcionario.setTelefone("96372999");

        persistefuncionario.salvar(funcionario);

        String codigoAcesso = "eduardo226"; //é passado o código errado
        Funcionario result = PersistenciaFuncionario.consultarFuncionarioPorCodigodeAcesso(codigoAcesso);
        assertNull(result);
    }

    /**
     * Test of consultarPontoAberto method, of class PersistenciaFuncionario.
     */
    @Test
    public void testConsultarPontoAberto() {
        System.out.println("Testando método consultarPontoAberto");

        Endereco endereco = new Endereco();
        endereco.setBairro("Centro");
        endereco.setCidade("Alegrete");
        endereco.setComplemento("101");
        endereco.setEstado("RS");
        endereco.setLogradouro("rua");
        endereco.setNumero(459);
        endereco.setRua("Barão do Cerro Largo6");

        funcionario = new Funcionario();
        funcionario.setAtivo(true);
        funcionario.setCodigoAcesso("eduardo20");
        funcionario.setCpf("11111111111");
        funcionario.setCurso("ES");
        funcionario.setEmail("eduardoamaral@gmail.com");
        funcionario.setEndereco(endereco);
        funcionario.setEstagioObrigatorio(true);
        funcionario.setInstituicao("UNIPAMPA");
        funcionario.setMatricula("131150105");
        funcionario.setNome("Eduardo Amaral6");
        funcionario.setRg("12312312312");
        funcionario.setTelefone("96372999");

        persistefuncionario.salvar(funcionario);

        PersistenciaPonto persPonto = new PersistenciaPonto();

        ponto = new Ponto();
        ponto.setData(new Date());
        ponto.setEntrada(new Date());
        ponto.setStatus(true);
        ponto.setFuncionario(funcionario);
        persPonto.salvarPonto(ponto);

        String codigoAcesso = funcionario.getCodigoAcesso();
        Funcionario expResult = funcionario;
        Funcionario result = PersistenciaFuncionario.consultarPontoAberto(codigoAcesso);
        assertEquals(expResult, result);
    }

    /**
     * Test of consultarPontoAberto method, of class PersistenciaFuncionario.
     */
    @Test
    public void testConsultarNegativoPontoAberto() {
        System.out.println("Testando método consultarPontoAberto");

        Endereco endereco = new Endereco();
        endereco.setBairro("Centro");
        endereco.setCidade("Alegrete");
        endereco.setComplemento("101");
        endereco.setEstado("RS");
        endereco.setLogradouro("rua");
        endereco.setNumero(459);
        endereco.setRua("Barão do Cerro Largo6");

        funcionario = new Funcionario();
        funcionario.setAtivo(true);
        funcionario.setCodigoAcesso("eduardo20");
        funcionario.setCpf("11111111111");
        funcionario.setCurso("ES");
        funcionario.setEmail("eduardoamaral@gmail.com");
        funcionario.setEndereco(endereco);
        funcionario.setEstagioObrigatorio(true);
        funcionario.setInstituicao("UNIPAMPA");
        funcionario.setMatricula("131150105");
        funcionario.setNome("Eduardo Amaral6");
        funcionario.setRg("12312312312");
        funcionario.setTelefone("96372999");

        persistefuncionario.salvar(funcionario);

        PersistenciaPonto persPonto = new PersistenciaPonto();

        ponto = new Ponto();
        ponto.setData(new Date());
        ponto.setEntrada(new Date());
        ponto.setSaida(new Date());
        ponto.setStatus(false);
        ponto.setFuncionario(funcionario);
        persPonto.salvarPonto(ponto);

        String codigoAcesso = funcionario.getCodigoAcesso();
        Funcionario result = PersistenciaFuncionario.consultarPontoAberto(codigoAcesso);
        assertNull(result);
    }

    /**
     * Teste que cadastra um funcionario
     */
    @Test
    public void testCadastrarFuncionario() {
        System.out.println("Testando método consultarFuncionario");

        Endereco endereco = new Endereco();
        endereco.setBairro("Centro");
        endereco.setCidade("Alegrete");
        endereco.setComplemento("101");
        endereco.setEstado("RS");
        endereco.setLogradouro("rua");
        endereco.setNumero(459);
        endereco.setRua("Barão do Cerro Largo7");

        funcionario = new Funcionario();
        funcionario.setAtivo(true);
        funcionario.setCodigoAcesso("eduardo220");
        funcionario.setCpf("11111111111");
        funcionario.setCurso("ES");
        funcionario.setEmail("eduardoamaral@gmail.com");
        funcionario.setEndereco(endereco);
        funcionario.setEstagioObrigatorio(true);
        funcionario.setInstituicao("UNIPAMPA");
        funcionario.setMatricula("131150105");
        funcionario.setNome("Eduardo Amaral7");
        funcionario.setRg("12312312312");
        funcionario.setTelefone("96372999");

        persistefuncionario.salvar(funcionario);

        List list = persistefuncionario.consultarListaFuncionario();
        boolean result = list.contains(funcionario);

        assertTrue(result);
    }

    /**
     * Teste que passa o campo vazio no nome e espera que não seja salvo o
     * registro de funcionario sem o nome.
     */
    @Test
    public void testCadastrarNegativoFuncionario() {
        System.out.println("Testando método cadastrarNegativoFuncionario");

        Endereco endereco = new Endereco();
        endereco.setBairro("Centro");
        endereco.setCidade("Alegrete");
        endereco.setComplemento("101");
        endereco.setEstado("RS");
        endereco.setLogradouro("rua");
        endereco.setNumero(459);
        endereco.setRua("Barão do Cerro Largo7");

        funcionario = new Funcionario();
        funcionario.setAtivo(true);
        funcionario.setCodigoAcesso("eduardo220");
        funcionario.setCpf("11111111111");
        funcionario.setCurso("ES");
        funcionario.setEmail("eduardoamaral@gmail.com");
        funcionario.setEndereco(endereco);
        funcionario.setEstagioObrigatorio(true);
        funcionario.setInstituicao("UNIPAMPA");
        funcionario.setMatricula("131150105");
        //funcionario.setNome("Eduardo Amaral7"); não pode ser salvo sem o nome
        funcionario.setRg("12312312312");
        funcionario.setTelefone("96372999");

        PersistenciaFuncionario instance = new PersistenciaFuncionario();
        instance.cadastrarFuncionario(funcionario);

        List list = persistefuncionario.consultarListaFuncionario();
        boolean result = list.contains(funcionario);

        assertFalse(result);
    }

    /**
     * teste que exclui um funcionário.
     */
    @Test
    public void testExcluirFuncionario() {

        Endereco endereco = new Endereco();
        endereco.setBairro("Centro");
        endereco.setCidade("Alegrete");
        endereco.setComplemento("101");
        endereco.setEstado("RS");
        endereco.setLogradouro("rua");
        endereco.setNumero(459);
        endereco.setRua("Barão do Cerro Largo7");

        funcionario = new Funcionario();
        funcionario.setAtivo(true);
        funcionario.setCodigoAcesso("eduardo220");
        funcionario.setCpf("11111111111");
        funcionario.setCurso("ES");
        funcionario.setEmail("eduardoamaral@gmail.com");
        funcionario.setEndereco(endereco);
        funcionario.setEstagioObrigatorio(true);
        funcionario.setInstituicao("UNIPAMPA");
        funcionario.setMatricula("131150105");
        funcionario.setNome("Eduardo Amaral7");
        funcionario.setRg("12312312312");
        funcionario.setTelefone("96372999");

        persistefuncionario.salvar(this.funcionario);
        funcionario = PersistenciaFuncionario.consultarFuncionarioPorCodigodeAcesso(funcionario.getCodigoAcesso());
        String id = String.valueOf(funcionario.getIdfuncionario());

        persistefuncionario.excluirFuncionario(funcionario);

        assertNull(persistefuncionario.consultar("idfuncionario", id, Funcionario.class));
    }

    /**
     * teste do método que busca um funcionário que possua algum ponto
     * cadastrado
     */
    @Test
    public void testConsultarFuncionarioPonto() {

        Endereco endereco = new Endereco();
        endereco.setBairro("Centro");
        endereco.setCidade("Alegrete");
        endereco.setComplemento("101");
        endereco.setEstado("RS");
        endereco.setLogradouro("rua");
        endereco.setNumero(459);
        endereco.setRua("Barão do Cerro Largo6");

        funcionario = new Funcionario();
        funcionario.setAtivo(true);
        funcionario.setCodigoAcesso("eduardo20");
        funcionario.setCpf("11111111111");
        funcionario.setCurso("ES");
        funcionario.setEmail("eduardoamaral@gmail.com");
        funcionario.setEndereco(endereco);
        funcionario.setEstagioObrigatorio(true);
        funcionario.setInstituicao("UNIPAMPA");
        funcionario.setMatricula("131150105");
        funcionario.setNome("Eduardo Amaral6");
        funcionario.setRg("12312312312");
        funcionario.setTelefone("96372999");

        persistefuncionario.salvar(funcionario);

        funcionario = PersistenciaFuncionario.consultarFuncionarioPorCodigodeAcesso(funcionario.getCodigoAcesso());

        PersistenciaPonto persPonto = new PersistenciaPonto();

        ponto = new Ponto();
        ponto.setData(new Date());
        ponto.setEntrada(new Date());
        ponto.setStatus(true);
        ponto.setFuncionario(funcionario);
        persPonto.salvarPonto(ponto);

        Ponto ponto2 = new Ponto();
        ponto2.setData(new Date());
        ponto2.setEntrada(new Date());
        ponto2.setSaida(new Date());
        ponto2.setStatus(false);
        ponto2.setFuncionario(funcionario);
        persPonto.salvarPonto(ponto2);

        String codigoAcesso = funcionario.getCodigoAcesso();
        Funcionario expResult = funcionario;
        Funcionario result = PersistenciaFuncionario.consultarFuncionarioPonto(codigoAcesso);
        assertEquals(expResult, result);
    }

    /**
     * teste do método que busca um funcionário que possua um ponto fechado
     * cadastrado
     */
    @Test
    public void testConsultarFuncionarioPontoFechado() {

        Endereco endereco = new Endereco();
        endereco.setBairro("Centro");
        endereco.setCidade("Alegrete");
        endereco.setComplemento("101");
        endereco.setEstado("RS");
        endereco.setLogradouro("rua");
        endereco.setNumero(459);
        endereco.setRua("Barão do Cerro Largo6");

        funcionario = new Funcionario();
        funcionario.setAtivo(true);
        funcionario.setCodigoAcesso("eduardo20");
        funcionario.setCpf("11111111111");
        funcionario.setCurso("ES");
        funcionario.setEmail("eduardoamaral@gmail.com");
        funcionario.setEndereco(endereco);
        funcionario.setEstagioObrigatorio(true);
        funcionario.setInstituicao("UNIPAMPA");
        funcionario.setMatricula("131150105");
        funcionario.setNome("Eduardo Amaral6");
        funcionario.setRg("12312312312");
        funcionario.setTelefone("96372999");

        persistefuncionario.salvar(funcionario);

        funcionario = PersistenciaFuncionario.consultarFuncionarioPorCodigodeAcesso(funcionario.getCodigoAcesso());

        PersistenciaPonto persPonto = new PersistenciaPonto();

        ponto = new Ponto();
        ponto.setData(new Date());
        ponto.setEntrada(new Date());
        ponto.setSaida(new Date());
        ponto.setStatus(false);
        ponto.setFuncionario(funcionario);
        persPonto.salvarPonto(ponto);

        String codigoAcesso = funcionario.getCodigoAcesso();
        Funcionario expResult = funcionario;
        Funcionario result = PersistenciaFuncionario.consultarPontoFechado(codigoAcesso);
        assertEquals(expResult, result);
    }
    
    @Test
    public void teste(){
        Endereco enderenco = new Endereco();
        enderenco.setBairro("");
        enderenco.setCidade("dsd");
        enderenco.setComplemento("dsas");
        enderenco.setEstado("dsa");
        enderenco.setLogradouro("dsada");
        enderenco.setNumero(123);
        enderenco.setRua("dsa");
        Persistencia pe = new Persistencia() {
            
};
        
        pe.salvar(enderenco);
        
    }
}
