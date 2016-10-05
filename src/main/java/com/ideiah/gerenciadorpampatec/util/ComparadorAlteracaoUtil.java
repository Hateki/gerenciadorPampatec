/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.util;

import com.ideiah.gerenciadorpampatec.model.AlteracaoCampos;
import java.util.Comparator;

/**
 *
 * @author unipampa
 */
public class ComparadorAlteracaoUtil implements Comparator<AlteracaoCampos>{

    @Override
    public int compare(AlteracaoCampos o1, AlteracaoCampos o2) {
        if(o1 == null || o2 == null){
            return 0;
        }
        
        //se os dois objetos contém data, é retornado como maior o que tem data mais recente
        return o1.getData_alteracao().compareTo(o2.getData_alteracao());
    }
    
}
