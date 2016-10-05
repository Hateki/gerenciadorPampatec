/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideiah.sisponto02.validacoes;

import ideiah.sisponto02.dao.PersistenciaFuncionario;
import ideiah.sisponto02.modelo.Endereco;
import ideiah.sisponto02.modelo.Funcionario;
import java.util.List;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;

/**
 *
 * @author Pedro
 */
@Ignore
public class ValidacaoFuncionarioTest {

    Funcionario funcionario;
    Endereco endereco;
    PersistenciaFuncionario persistefuncionario;

    @Before
    public void setUp() {
        persistefuncionario = new PersistenciaFuncionario();
        funcionario = new Funcionario();
        endereco = new Endereco();

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

        persistefuncionario.salvar(funcionario);
    }

    @After
    public void tearDown() {
        persistefuncionario.excluir(funcionario);
        funcionario = null;
        endereco = null;
        persistefuncionario = null;

    }

    /**
     * Testa se o método verifica se o código de acesso tem menos de 15 letras
     */
    @Test
    public void testValidaCodigoAcessoMenos() {
        System.out.println("Código com menos de 15 letras");
        ValidacaoFuncionario instance = new ValidacaoFuncionario(funcionario);
        assertFalse("Código com menos de 15 letras", instance.isCodigoAcessoErrado());
    }

    /**
     * Testa se o método verifica se o código de acesso tem mais de 15 letras
     */
    @Test
    public void testValidaCodigoAcessoMais() {
        System.out.println("Código com mais de 15 letras");
        String codigoAcessoAnterior = funcionario.getCodigoAcesso();
        funcionario.setCodigoAcesso("123456789101112131415");
        ValidacaoFuncionario instance = new ValidacaoFuncionario(funcionario);
        assertTrue("Código com mais de 15 letras", instance.isCodigoAcessoErrado());
        funcionario.setCodigoAcesso(codigoAcessoAnterior);
    }

    /**
     * Testa se o método verifica se o código de acesso existe
     */
    @Test
    public void testValidaCodigoAcessoExiste() {
        System.out.println("Código já existe");
        ValidacaoFuncionario instance = new ValidacaoFuncionario(funcionario);
        assertTrue("Código já existe", instance.isCodigoAcessoExiste());
    }

    /**
     * Testa se o método verifica se o código de acesso existe
     */
    @Test
    public void testValidaCodigoAcessoNaoExiste() {
        System.out.println("Código não existe");
        funcionario.setCodigoAcesso("123456789101112131415jkhjyjghtdthgdfdtrdgdgpoiiy");
        ValidacaoFuncionario instance = new ValidacaoFuncionario(funcionario);
        assertFalse("Código não existe", instance.isCodigoAcessoExiste());
    }

    /**
     * Testa se o método verifica a existência de um cpf.
     */
    @Test
    public void testValidarCpfExiste() {
        System.out.println("CPF Existe");
        ValidacaoFuncionario instance = new ValidacaoFuncionario(funcionario);
        assertTrue("CPF Existe", instance.isCpfExiste());
    }

    /**
     * Testa se o método verifica a inexistência de um cpf.
     */
    @Test
    public void testValidarCpfNaoExiste() {
        System.out.println("CPF não existe");
        String cpfAnterior = funcionario.getCpf();
        funcionario.setCpf("9999999999999999");
        ValidacaoFuncionario instance = new ValidacaoFuncionario(funcionario);
        assertFalse("CPF não existe", instance.isCpfExiste());
        funcionario.setCpf(cpfAnterior);
    }

    /**
     * Testa se o método verifica CPF formato inválido.
     */
    @Test
    public void testValidarCpfInvalido() {
        System.out.println("CPF formato invalido");
        funcionario.setCpf("99999999999");
        ValidacaoFuncionario instance = new ValidacaoFuncionario(funcionario);
        assertTrue("CPF invalido", instance.isCpfInvalido());

    }

    /**
     * Testa se o método verifica a existência de um RG.
     */
    @Test
    public void testValidarRgExiste() {
        System.out.println("RG Existe");
        ValidacaoFuncionario instance = new ValidacaoFuncionario(funcionario);
        assertTrue("RG Existe", instance.isRgExiste());
    }

    /**
     * Testa se o método verifica a inexistência de um RG.
     */
    @Test
    public void testValidarRGNaoExiste() {
        System.out.println("RG não existe");
        String rgAnterior = funcionario.getRg();
        funcionario.setRg("9999999999999999");
        ValidacaoFuncionario instance = new ValidacaoFuncionario(funcionario);
        assertFalse("RG não existe", instance.isRgExiste());
        funcionario.setRg(rgAnterior);
    }

    /**
     * Testa se o método verifica a existência de uma matrícula.
     */
    @Test
    public void testValidarMatriculaExiste() {
        System.out.println("Matrícula Existe");
        ValidacaoFuncionario instance = new ValidacaoFuncionario(funcionario);
        assertTrue("Matrícula Existe", instance.isMatriculaExiste());
    }

    /**
     * Testa se o método verifica a inexistência de uma matrícula.
     */
    @Test
    public void testValidarMatriculaNaoExiste() {
        System.out.println("Matrícula não Existe");
        String matriculaAnterior = funcionario.getMatricula();
        funcionario.setMatricula("9999999999999999");
        ValidacaoFuncionario instance = new ValidacaoFuncionario(funcionario);
        assertFalse("Matrícula não Existe", instance.isMatriculaExiste());
        funcionario.setMatricula(matriculaAnterior);
    }

}
