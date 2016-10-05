///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package SeleniumTests;
//
//import com.thoughtworks.selenium.SeleneseTestCase;
//import com.thoughtworks.selenium.Selenium;
//import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;
//import ideiah.sisponto02.bean.MarcarPontoBean;
//import ideiah.sisponto02.dao.PersistenciaFuncionario;
//import ideiah.sisponto02.dao.PersistenciaPonto;
//import ideiah.sisponto02.modelo.Endereco;
//import ideiah.sisponto02.modelo.Funcionario;
//import ideiah.sisponto02.modelo.Ponto;
//import java.util.Date;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
///**
// *
// * @author kaiocosta
// */
//public class MarcarPontoTest extends SeleneseTestCase {
//
//    private Selenium selenium;
//    Funcionario funcionario;
//    Ponto ponto;
//    Endereco endereco;
//    MarcarPontoBean marcarBean;
//    PersistenciaPonto persisteponto;
//    PersistenciaFuncionario persistefuncionario;
//    Date data;
//
//    @Before
//    public void setUp() throws Exception {
//        /**
//         * Configuração do drive do selenium
//         */
//        //Descomentar abaixo para executar no Mac  - Kaio   
//        //System.setProperty("webdriver.chrome.driver", "/Users/kaiocosta/downloads/chromedriver");
//
//        //Descomentar abaixo para executar no Windows
//        System.setProperty("webdriver.chrome.driver", "src\\test\\chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//        String baseUrl = "http://localhost:8080/";
//        selenium = new WebDriverBackedSelenium(driver, baseUrl);
//
//    }
//
//    @After
//    public void tearDown() throws Exception {
//        selenium.stop();
//    }
//
//    /**
//     * Teste para abertura de ponto
//     *
//     */
//    public void testAbrirPonto() throws Exception {
//
//        /**
//         * Criando funcionário
//         */
//        data = new Date();
//        persisteponto = new PersistenciaPonto();
//        persistefuncionario = new PersistenciaFuncionario();
//        marcarBean = new MarcarPontoBean();
//        funcionario = new Funcionario();
//        endereco = new Endereco();
//        marcarBean.init();
//        endereco.setBairro("Centro");
//        endereco.setCidade("Alegrete");
//        endereco.setComplemento("Casa");
//        endereco.setEstado("RS");
//        endereco.setLogradouro("Rua");
//        endereco.setRua("Gaspar");
//        endereco.setNumero(15);
//
//        funcionario.setAtivo(true);
//        funcionario.setCodigoAcesso("testador1");
//        funcionario.setCpf("01846652033");
//        funcionario.setCurso("Engenharia");
//        funcionario.setEmail("email@email.com");
//        funcionario.setEndereco(endereco);
//        funcionario.setEstagioObrigatorio(true);
//        funcionario.setInstituicao("Unipampa");
//        funcionario.setMatricula("5000255");
//        funcionario.setNome("Testador");
//        funcionario.setRg("100002202");
//        funcionario.setTelefone("342226616");
//
//        persistefuncionario.cadastrarFuncionario(funcionario);
//
//        selenium.open("/Sisponto02/faces/index.xhtml");
//        selenium.type("id=marcaPonto:iCodigo", "testador1");
//        selenium.click("id=marcaPonto:j_idt7");
//        selenium.waitForPageToLoad("30000");
//    }
//
//    /**
//     * Teste para fechamento de ponto
//     *
//     * @throws java.lang.Exception
//     */
//    public void testFecharPonto() throws Exception {
//        selenium.open("/Sisponto02/faces/index.xhtml;jsessionid=84fe26352740cba2be3dc411fb91");
//        selenium.type("id=marcaPonto:iCodigo", "testador1");
//        selenium.waitForPageToLoad("30000");
//        selenium.click("id=marcaPonto:j_idt7");
//        selenium.waitForPageToLoad("30000");
//        selenium.type("name=marcaPonto:j_idt18", "testes");
//        selenium.waitForPageToLoad("30000");
//        selenium.click("name=marcaPonto:j_idt20");
//        selenium.waitForPageToLoad("30000");
//        
//        funcionario = PersistenciaFuncionario.consultarPontoFechado("testador1");
//        ponto = funcionario.getPontos().iterator().next();
//        
//        persistefuncionario = new PersistenciaFuncionario();
//        persisteponto = new PersistenciaPonto();
//        persisteponto.excluirPonto(ponto);
//        persistefuncionario.excluir(funcionario);
//       
//    }
//}
