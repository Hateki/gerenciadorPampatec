/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.controller;

import com.ideiah.gerenciadorpampatec.dao.GerenteDao;
import com.ideiah.gerenciadorpampatec.model.GerenteRelacionamento;
import com.ideiah.gerenciadorpampatec.model.Projeto;
import com.ideiah.gerenciadorpampatec.util.EmailUtil;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <p>
 * Classe destinada a manipular as informações necessárias quando o sistema
 * precisar envia emails.
 * </p>
 *
 * @author unipampa
 * @since 05/07/2016
 */
public abstract class EmailManager {

    /**
     * <p>
     * Método que recupera todos os gerentes cadastrados no banco, insere em uma
     * lista e chama o método que enviará os emails.
     * </p>
     *
     * @param projeto O projeto cujo status foi modificado.
     */
    public static void enviaEmailParaGerentes(Projeto projeto) {
        try {
            String nomeProjeto = projeto.getNome();
            String statusProjeto = projeto.getStatusString(projeto.getStatus());
            String nomeEmpreendedor = projeto.getEmpreendedorCorrespondente().getNome();
            
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat formatohora = new SimpleDateFormat("HH:mm:ss");
            String dataSubmissao = formato.format(projeto.getDataEnvio());
            String horaSubmissao = formatohora.format(projeto.getDataEnvio());

            ArrayList<GerenteRelacionamento> listaDeGerentes;
            GerenteDao gerenteDAO = new GerenteDao();
            listaDeGerentes = (ArrayList<GerenteRelacionamento>) gerenteDAO.buscarTodosGerente();

            EmailUtil.enviaEmailParaGerentes(nomeProjeto, nomeEmpreendedor, dataSubmissao, horaSubmissao, statusProjeto, listaDeGerentes);

        } catch (Exception e) {
            Logger.getLogger(EmailManager.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
