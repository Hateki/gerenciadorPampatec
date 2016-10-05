/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.util;

import com.ideiah.gerenciadorpampatec.model.Projeto;
import java.util.Comparator;

/**
 *
 * @author Claudio
 */
public class ComparadorEnvioUtil implements Comparator<Projeto> {

    public ComparadorEnvioUtil() {
    }

    /**
     * @param Projeto o1 para ser comparado
     * @param Projeto o2 para ser comparado COmpara pela data utilizando uma
     * classe abstrata. Como o Data é comparavel O java já implementa o
     * compareTo(). Quando esse método for chamado na bean ele vai comparar o
     * projeto 1 com o projeto 2 e ordenar a lista usando collection.
     * @return
     */
    @Override
    public int compare(Projeto o1, Projeto o2) {
        return o1.getDataEnvio().compareTo(o2.getDataEnvio());
    }

}
