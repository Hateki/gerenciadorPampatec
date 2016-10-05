/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideiah.sisponto02.validacoes;

import ideiah.sisponto02.dao.PersistenciaFuncionario;
import ideiah.sisponto02.modelo.Funcionario;

/**
 *
 * @author Jonas Chagas
 */
public class ValidacaoExclusaoFuncionario {

    /**
     * método que valida a exclusão de um funcionário.
     *
     * @param funcionario
     * @throws ExcecoesValidacao
     */
    public void validarExclusao(Funcionario funcionario) throws ExcecoesValidacao {

               
        if (PersistenciaFuncionario.consultarFuncionarioPonto(funcionario.getCodigoAcesso()) != null) {
            throw new ExcecoesValidacao("O funcionário não pode ser excluído, pois possui registro de Ponto");
        }
    }
}
