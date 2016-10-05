/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideiah.sisponto02.validacoes;

import ideiah.sisponto02.dao.PersistenciaFuncionario;
import ideiah.sisponto02.modelo.Funcionario;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Pedro
 */
@Ignore
public class ValidacaoExclusaoFuncionarioTest {

    public ValidacaoExclusaoFuncionarioTest() {
    }

    /**
     * Testa se o método de validar aceita um funcionário qualquer para ser
     * excluido.
     *
     * @throws Exception
     */
    @Test
    public void testValidarExclusaoPositivo() throws Exception {
        System.out.println("Validando a exclusão de um funcionário qualquer. "
                + "Espero que me deixe excluir");
        Funcionario funcionario = new Funcionario();
        ValidacaoExclusaoFuncionario validacao = new ValidacaoExclusaoFuncionario();
        validacao.validarExclusao(funcionario);
    }

    /**
     * Testa se o método de validar aceita excluir um funcionário que têm pontos
     * mmarcados.
     *
     * @throws Exception
     */
    //@Test(expected = ExcecoesValidacao.class)
    @Ignore
    public void testValidarExclusaoNegativo() throws Exception {
        System.out.println("Validando a exclusão de um funcionário com pontos marcados. "
                + "Espero que não me deixe excluir");
        PersistenciaFuncionario db = new PersistenciaFuncionario();
        Funcionario funcionario = null;

        //Procura no banco um funcionário que tenha pontos marcados
        for (Object object : db.consultarListaFuncionario()) {
            Funcionario funcionarioBanco = (Funcionario) object;
            if (!funcionarioBanco.getPontos().isEmpty()) {
                funcionario = funcionarioBanco;
                break;
            }
        }

        ValidacaoExclusaoFuncionario validacao = new ValidacaoExclusaoFuncionario();
        validacao.validarExclusao(funcionario);
    }

}
