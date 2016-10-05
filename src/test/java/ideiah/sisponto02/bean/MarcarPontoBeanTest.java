/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideiah.sisponto02.bean;

import ideiah.sisponto02.dao.PersistenciaFuncionario;
import ideiah.sisponto02.dao.PersistenciaPonto;
import ideiah.sisponto02.modelo.Endereco;
import ideiah.sisponto02.modelo.Funcionario;
import ideiah.sisponto02.modelo.Ponto;

import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.runners.MethodSorters;

/**
 *
 * Os testes estão todos considerando o cascade do Funcionario com Ponto sem ser
 * "ALL". Neste momento está "ALL", pois ainda será feito a migração de dados do
 * banco velho para o novo. Após isso, deve ser tirado do cascade all para
 * normal.
 *
 * @author Jonas Chagas
 */
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Ignore
public class MarcarPontoBeanTest {

    Funcionario funcionario;
    Ponto ponto;
    Endereco endereco;
    MarcarPontoBean marcarBean;
    PersistenciaPonto persisteponto;
    PersistenciaFuncionario persistefuncionario;
    Date data;

    public MarcarPontoBeanTest() {
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
     * teste marcar entrada do ponto positivo
     */
    @Test
    public void testMarcarPontoEntradaPositivo() {

        data = new Date();
        persisteponto = new PersistenciaPonto();
        persistefuncionario = new PersistenciaFuncionario();
        marcarBean = new MarcarPontoBean();
        funcionario = new Funcionario();
        endereco = new Endereco();
        marcarBean.init();
        endereco.setBairro("Centro");
        endereco.setCidade("Alegrete");
        endereco.setComplemento("Casa");
        endereco.setEstado("RS");
        endereco.setLogradouro("Rua");
        endereco.setRua("Gaspar");
        endereco.setNumero(15);

        funcionario.setAtivo(true);
        funcionario.setCodigoAcesso("acesso1");
        funcionario.setCpf("01846652033");
        funcionario.setCurso("Engenharia");
        funcionario.setEmail("email@email.com");
        funcionario.setEndereco(endereco);
        funcionario.setEstagioObrigatorio(true);
        funcionario.setInstituicao("Unipampa");
        funcionario.setMatricula("5000255");
        funcionario.setNome("TEste 1");
        funcionario.setRg("100002202");
        funcionario.setTelefone("342226616");

        persistefuncionario.cadastrarFuncionario(funcionario);

        marcarBean.setCodigo_acesso(funcionario.getCodigoAcesso());
        marcarBean.marcarPonto();

        ponto = PersistenciaFuncionario.consultarPontoAberto(funcionario.getCodigoAcesso()).getPontos().iterator().next();
        assertEquals(true, ponto.isStatus());
        persisteponto.excluirPonto(ponto);
        persistefuncionario.excluir(funcionario);
    }

    /**
     * teste marcar saída do ponto positivo de sucesso
     */
    @Test
    public void testMarcarPontoSaidaPositivo() {
        data = new Date();
        persisteponto = new PersistenciaPonto();
        persistefuncionario = new PersistenciaFuncionario();
        Funcionario funcionario2;
        marcarBean = new MarcarPontoBean();
        funcionario = new Funcionario();
        endereco = new Endereco();
        marcarBean.init();
        endereco.setBairro("Centro");
        endereco.setCidade("Alegrete");
        endereco.setComplemento("Casa");
        endereco.setEstado("RS");
        endereco.setLogradouro("Rua");
        endereco.setRua("Gaspar");
        endereco.setNumero(15);

        funcionario.setAtivo(true);
        funcionario.setCodigoAcesso("acesso1");
        funcionario.setCpf("01846652033");
        funcionario.setCurso("Engenharia");
        funcionario.setEmail("email@email.com");
        funcionario.setEndereco(endereco);
        funcionario.setEstagioObrigatorio(true);
        funcionario.setInstituicao("Unipampa");
        funcionario.setMatricula("5000255");
        funcionario.setNome("TEste 2");
        funcionario.setRg("100002202");
        funcionario.setTelefone("342226616");

        persistefuncionario.cadastrarFuncionario(funcionario);

        Ponto ponto2 = new Ponto();
        ponto2.setData(data);
        ponto2.setEntrada(data);

        ponto2.setFuncionario(funcionario);
        ponto2.setStatus(true);
        persisteponto.salvarPonto(ponto2);

        marcarBean.setCodigo_acesso(funcionario.getCodigoAcesso());
        marcarBean.setAtividadeRealizada("aaaaaaaaaaaaaaaa");
        funcionario2 = PersistenciaFuncionario.consultarPontoAberto("acesso1");
        marcarBean.setFuncionario(funcionario2);
        marcarBean.saidaPonto();

        ponto2 = persisteponto.consultarPontoPorId(ponto2.getIdponto());

        assertEquals(false, ponto2.isStatus());

        persisteponto.excluirPonto(ponto2);
        persistefuncionario.excluir(funcionario);
    }

    /**
     * teste marcar saída do ponto negativo. Processo: registrar um ponto em um
     * dia anterior ao atual. Exemplo: abrir ponto no dia (20) e tentar marcar
     * ponto no dia (21). O sistema deve manter o do dia 20 aberto e abrir um
     * novo para o dia 21.
     */
    @Test
    public void testMarcarPontoSaidaNegativo() {
        /**
         * Configuração do ambiente para teste.
         */
        Date dataOntem = new Date();
        Date dataHoje = new Date();

        persisteponto = new PersistenciaPonto();
        persistefuncionario = new PersistenciaFuncionario();
        marcarBean = new MarcarPontoBean();
        funcionario = new Funcionario();
        endereco = new Endereco();
        marcarBean.init();
        endereco.setBairro("Centro");
        endereco.setCidade("Alegrete");
        endereco.setComplemento("Casa");
        endereco.setEstado("RS");
        endereco.setLogradouro("Rua");
        endereco.setRua("Gaspar");
        endereco.setNumero(15);

        funcionario.setAtivo(true);
        funcionario.setCodigoAcesso("acesso1");
        funcionario.setCpf("01846652033");
        funcionario.setCurso("Engenharia");
        funcionario.setEmail("email@email.com");
        funcionario.setEndereco(endereco);
        funcionario.setEstagioObrigatorio(true);
        funcionario.setInstituicao("Unipampa");
        funcionario.setMatricula("5000255");
        funcionario.setNome("TEste 3");
        funcionario.setRg("100002202");
        funcionario.setTelefone("342226616");

        persistefuncionario.cadastrarFuncionario(funcionario);

        Ponto ponto2 = new Ponto();
        dataOntem.setDate(dataOntem.getDate() - 1);// fazendo com que o dia seja o de ontem.
        ponto2.setData(dataOntem);
        ponto2.setEntrada(dataOntem);

        ponto2.setFuncionario(funcionario);
        ponto2.setStatus(true);
        persisteponto.salvarPonto(ponto2);

        marcarBean.setCodigo_acesso(funcionario.getCodigoAcesso());
        marcarBean.marcarPonto();

        /**
         * Conteúdo do teste.
         */
        Ponto pontoNovo = marcarBean.getPonto();
        ponto2 = persisteponto.consultarPontoPorId(ponto2.getIdponto());

        assertEquals(true, ponto2.isStatus()); // esse registro, marcado como sendo ontem, deve estar aberto 
        assertEquals(true, pontoNovo.isStatus()); // um novo registro deve ter sido aberto para hoje.

        persisteponto.excluirPonto(ponto2);

        persisteponto.excluirPonto(pontoNovo);
        persistefuncionario.excluir(funcionario);
    }

    /**
     *
     */
    @Test
    public void testConsultaFuncionario() {
        /**
         * Preparação do ambiente para teste
         */
        Date dataOntem = new Date();
        Date dataHoje = new Date();

        persisteponto = new PersistenciaPonto();
        persistefuncionario = new PersistenciaFuncionario();
        marcarBean = new MarcarPontoBean();
        funcionario = new Funcionario();
        endereco = new Endereco();
        marcarBean.init();
        endereco.setBairro("Centro");
        endereco.setCidade("Alegrete");
        endereco.setComplemento("Casa");
        endereco.setEstado("RS");
        endereco.setLogradouro("Rua");
        endereco.setRua("Gaspar");
        endereco.setNumero(15);

        funcionario.setAtivo(true);
        funcionario.setCodigoAcesso("acesso2");
        funcionario.setCpf("01846652033");
        funcionario.setCurso("Engenharia");
        funcionario.setEmail("email@email.com");
        funcionario.setEndereco(endereco);
        funcionario.setEstagioObrigatorio(true);
        funcionario.setInstituicao("Unipampa");
        funcionario.setMatricula("5000255");
        funcionario.setNome("TEste 4");
        funcionario.setRg("100002202");
        funcionario.setTelefone("342226616");

        persistefuncionario.cadastrarFuncionario(funcionario);

        Ponto ponto2 = new Ponto();
        dataOntem.setDate(dataOntem.getDate() - 1);// fazendo com que o dia seja o de ontem.
        ponto2.setData(dataOntem);
        ponto2.setEntrada(dataOntem);

        ponto2.setFuncionario(funcionario);
        ponto2.setStatus(true);
        persisteponto.salvarPonto(ponto2);

        marcarBean.setCodigo_acesso(funcionario.getCodigoAcesso());
        /**
         * O teste é o método marcarBean.consultaFuncionario().getNome(), que
         * deve retornar nullo, pq não há registro ponto no dia de hoje, e sim
         * no de ontem.
         */
        assertNull(marcarBean.consultaFuncionario());

        persisteponto.excluirPonto(ponto2);
        persistefuncionario.excluir(funcionario);
    }

    /**
     * Método que testa marcar ponto para um funcionário com status inativo.
     */
    @Test
    public void testMarcarPontoSaidaNegativo2() {
        data = new Date();
        persisteponto = new PersistenciaPonto();
        persistefuncionario = new PersistenciaFuncionario();
        marcarBean = new MarcarPontoBean();
        funcionario = new Funcionario();
        endereco = new Endereco();
        marcarBean.init();
        endereco.setBairro("Centro");
        endereco.setCidade("Alegrete");
        endereco.setComplemento("Casa");
        endereco.setEstado("RS");
        endereco.setLogradouro("Rua");
        endereco.setRua("Gaspar");
        endereco.setNumero(15);

        funcionario.setAtivo(false); // desativando funcinario
        funcionario.setCodigoAcesso("acesso1");
        funcionario.setCpf("01846652033");
        funcionario.setCurso("Engenharia");
        funcionario.setEmail("email@email.com");
        funcionario.setEndereco(endereco);
        funcionario.setEstagioObrigatorio(true);
        funcionario.setInstituicao("Unipampa");
        funcionario.setMatricula("5000255");
        funcionario.setNome("TEste 1");
        funcionario.setRg("100002202");
        funcionario.setTelefone("342226616");

        persistefuncionario.cadastrarFuncionario(funcionario);

        marcarBean.setCodigo_acesso(funcionario.getCodigoAcesso());
        marcarBean.marcarPonto();

        funcionario = PersistenciaFuncionario.consultarFuncionarioPorCodigodeAcesso(funcionario.getCodigoAcesso());
        assertNull(PersistenciaFuncionario.consultarPontoAberto(funcionario.getCodigoAcesso()));

        persistefuncionario.excluir(funcionario);

    }
}
