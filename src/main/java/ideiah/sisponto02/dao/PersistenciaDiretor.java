/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideiah.sisponto02.dao;

import ideiah.sisponto02.modelo.Diretor;

/**
 *
 * @author Jonas Chagas
 */
public class PersistenciaDiretor extends Persistencia {

    public boolean salvarDiretor(Diretor diretor) {
        boolean result = this.salvar(diretor);
        return result;
    }

    public boolean excluirDiretor(Diretor diretor) {
        boolean result = this.excluir(diretor);
        return result;
    }

}
