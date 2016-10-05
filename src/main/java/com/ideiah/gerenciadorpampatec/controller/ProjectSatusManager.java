/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.controller;

import com.ideiah.gerenciadorpampatec.dao.ProjetoDao;
import com.ideiah.gerenciadorpampatec.model.GerenteRelacionamento;
import com.ideiah.gerenciadorpampatec.model.Projeto;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <p>
 * Classe para gerenciar o status do projeto em todo o sistema. Migrar para essa
 * classe os tratamentos de status do projeto.</p>
 *
 * @author unipampa
 * @since 07-06-2016
 */
public abstract class ProjectSatusManager {

    /**
     * <p>
     * Muda o status do projeto para em pré-avaliação antes da sessão do gerente
     * ser finalizada. Caso o usuário logado seja um Empreendedor, a sessão é
     * encerrada sem alterar os dados dos projetos.
     * </p>
     */
    public static synchronized void tratamentoStatusSendoAvaliado() {
        try {
            GerenteRelacionamento gerente = (GerenteRelacionamento) SessionManager.getAttribute("gerente");
            Projeto projeto = (Projeto) SessionManager.getAttribute("projetoSelecionado");

            if (gerente != null && projeto != null
                    && projeto.getStatus() == Projeto.SENDO_AVALIADO) {

                projeto.setStatus(Projeto.EM_PRE_AVALIACAO);
                /**
                 * Atualizando o objeto do projeto no banco de dados.
                 */
                ProjetoDao projetoDao = new ProjetoDao();
                projetoDao.update(projeto);
                SessionManager.removeAttribute("projetoSelecionado");
            }

        } catch (Exception e) {
            Logger.getLogger(ProjectSatusManager.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
