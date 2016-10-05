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
@Ignore
public class PersistenciaPontoTest {

    private PersistenciaPonto persisteponto;
    private PersistenciaFuncionario persistefuncionario;
    private Funcionario funcionario;
    private Endereco endereco;
    private Date data;
    private Ponto ponto;
    
    public PersistenciaPontoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        this.persisteponto = new PersistenciaPonto();
        this.persistefuncionario = new PersistenciaFuncionario();
        this.endereco = new Endereco();
        this.funcionario = new Funcionario();
        this.data = new Date();

       
    }

    @After
    public void tearDown() {
        persisteponto.excluirPonto(ponto);
        persistefuncionario.excluir(funcionario);
    }

    /**
     * teste de salvar um Ponto;
     */
    @Test
    public void testSalvarPonto() {

        endereco.setBairro("Centro");
        endereco.setCidade("Alegrete");
        endereco.setComplemento("101");
        endereco.setEstado("RS");
        endereco.setLogradouro("rua");
        endereco.setNumero(459);
        endereco.setRua("Barão do Cerro Largo1");

        funcionario.setAtivo(true);
        funcionario.setCodigoAcesso("eduardo2202");
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
        funcionario.setEndereco(endereco);
        persistefuncionario.cadastrarFuncionario(funcionario);

        ponto = new Ponto();

        ponto.setData(data);
        ponto.setEntrada(data);
        ponto.setFuncionario(funcionario);
        ponto.setStatus(true);
        persisteponto.salvarPonto(ponto);

        Ponto ponto2 = (Ponto) persisteponto.consultarPontoPorId(ponto.getIdponto());

        assertEquals(ponto2.getIdponto(), ponto.getIdponto());

        persisteponto.excluirPonto(ponto);
        persistefuncionario.excluir(funcionario);
    }

    /**
     * teste negativo de salvar um Ponto;
     */
    @Test
    public void testSalvarPontoNegativo() {
        endereco.setBairro("Centro");
        endereco.setCidade("Alegrete");
        endereco.setComplemento("101");
        endereco.setEstado("RS");
        endereco.setLogradouro("rua");
        endereco.setNumero(459);
        endereco.setRua("Barão do Cerro Largo1");

        funcionario.setAtivo(true);
        funcionario.setCodigoAcesso("eduardo2203");
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
        funcionario.setEndereco(endereco);
        persistefuncionario.cadastrarFuncionario(funcionario);

        ponto = new Ponto();

        ponto.setEntrada(data);
        ponto.setFuncionario(funcionario);
        ponto.setStatus(true);
        persisteponto.salvarPonto(ponto);
        String id = String.valueOf(ponto.getIdponto());

        Ponto ponto2 = (Ponto) persisteponto.consultar("idponto", id, Ponto.class);

        assertNull(ponto2);

        persistefuncionario.excluir(funcionario);
    }

    /**
     * Teste alterar ponto.
     */
    @Test
    public void testAlterarPonto() {

        endereco.setBairro("Centro");
        endereco.setCidade("Alegrete");
        endereco.setComplemento("101");
        endereco.setEstado("RS");
        endereco.setLogradouro("rua");
        endereco.setNumero(459);
        endereco.setRua("Barão do Cerro Largo1");

        funcionario.setAtivo(true);
        funcionario.setCodigoAcesso("eduardo2204");
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
        funcionario.setEndereco(endereco);
        persistefuncionario.cadastrarFuncionario(funcionario);

        ponto = new Ponto();

        ponto.setData(data);
        ponto.setEntrada(data);
        ponto.setFuncionario(funcionario);
        ponto.setStatus(true);
        persisteponto.salvarPonto(ponto);

        ponto.setAtividadeRealizada("Atividade Alterada");
        persisteponto.alterarPonto(ponto);

        Ponto ponto2 = (Ponto) persisteponto.consultarPontoPorId(ponto.getIdponto());

        assertEquals("Atividade Alterada", ponto2.getAtividadeRealizada());

        persisteponto.excluirPonto(ponto);
        persistefuncionario.excluir(funcionario);

    }

    /**
     * Teste excluir ponto.
     */
    @Test
    public void testExcluirPonto() {

        endereco.setBairro("Centro");
        endereco.setCidade("Alegrete");
        endereco.setComplemento("101");
        endereco.setEstado("RS");
        endereco.setLogradouro("rua");
        endereco.setNumero(459);
        endereco.setRua("Barão do Cerro Largo1");

        funcionario.setAtivo(true);
        funcionario.setCodigoAcesso("eduardo2205");
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
        funcionario.setEndereco(endereco);
        persistefuncionario.cadastrarFuncionario(funcionario);

        ponto = new Ponto();
        ponto.setData(data);
        ponto.setEntrada(data);
        ponto.setFuncionario(funcionario);
        ponto.setStatus(true);
        persisteponto.salvarPonto(ponto);

        String id = String.valueOf(ponto.getIdponto());
        persisteponto.excluirPonto(ponto);

        assertEquals(null, persisteponto.consultar("idponto", id, Ponto.class));

        persisteponto.excluirPonto(ponto);
        persistefuncionario.excluir(funcionario);
    }

    /**
     * Teste consultar lista de pontos
     */
    @Test
    public void testConsultarListaPonto() {

        endereco.setBairro("Centro");
        endereco.setCidade("Alegrete");
        endereco.setComplemento("101");
        endereco.setEstado("RS");
        endereco.setLogradouro("rua");
        endereco.setNumero(459);
        endereco.setRua("Barão do Cerro Largo1");

        funcionario.setAtivo(true);
        funcionario.setCodigoAcesso("eduardo2206");
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
        funcionario.setEndereco(endereco);
        persistefuncionario.cadastrarFuncionario(funcionario);

        ponto = new Ponto();
        ponto.setData(data);
        ponto.setEntrada(data);
        ponto.setFuncionario(funcionario);
        ponto.setStatus(true);
        persisteponto.salvarPonto(ponto);

        Ponto ponto2 = new Ponto();
        ponto2.setData(data);
        ponto2.setEntrada(data);
        ponto2.setFuncionario(funcionario);
        ponto2.setStatus(true);
        persisteponto.salvarPonto(ponto2);

        List list = persisteponto.consultarListaPonto();

        assertNotNull(list);

        persisteponto.excluirPonto(ponto);
        persisteponto.excluirPonto(ponto2);
        persistefuncionario.excluir(funcionario);

    }

}
