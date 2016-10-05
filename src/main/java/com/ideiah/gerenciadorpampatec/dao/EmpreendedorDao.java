/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.dao;

import com.ideiah.gerenciadorpampatec.model.Empreendedor;
import com.ideiah.gerenciadorpampatec.model.Notificacao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pedro
 */
public class EmpreendedorDao extends Dao {

//<editor-fold defaultstate="collapsed" desc="Salvar">
    public Empreendedor salvar(Empreendedor empreendedor) {
        return (Empreendedor) super.salvar(empreendedor);
    }
    
    public Notificacao salvarNotificacao(Notificacao notificacao) {
        return (Notificacao) super.salvar(notificacao);
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Buscar">
    public ArrayList<Empreendedor> buscar() {
        return (ArrayList<Empreendedor>) buscarObjetos(Empreendedor.class);
    }

    public Empreendedor buscar(int codigo) {
        return (Empreendedor) buscarObjeto(codigo, Empreendedor.class);
    }

    public Empreendedor buscarPorIdUnico(String idUnico) {
        return (Empreendedor) buscarObjetoCriteria("idUnico", idUnico, Empreendedor.class);

    }

    public Empreendedor buscaPorEmail(String email) {
        return (Empreendedor) buscarObjetoCriteria("email", email, Empreendedor.class);
    }
    
    
    public Notificacao buscarNotificacao(int codigo) {
        return (Notificacao) buscarObjeto(codigo, Empreendedor.class);
    }

    /*
     * Verificação se o email e o nome já estão 
     * cadastrados no sistema.
     */
//    public boolean buscarDados(String email, String nome) {
//        boolean resultado = true;
//        //TRUE -> Não está cadastrado
//        //FALSE -> Está cadastrado
//
//        for (int i = 0; i < this.buscar().size(); i++) {
//            if (this.buscar().get(i).getEmail() == email || this.buscar().get(i).getNome() == nome) {
//                resultado = false;
//            } else {
//                resultado = true;
//            }
//            return resultado;
//        }
//        return resultado;
//    }
    public Empreendedor buscarPorCpf(String cpf) {
        return (Empreendedor) buscarObjetoCriteria("cpf", cpf, Empreendedor.class);

    }
//    public boolean verificarEmail(String email){
//        if((Empreendedor) buscarObjetoCriteria("email", email, Empreendedor.class)!=null){
//            return true;
//        }
//        else
//            return false;
//    }

    public Empreendedor buscarPorEmail(String email) {
        return (Empreendedor) buscarObjetoCriteria("email", email, Empreendedor.class);
    }

    public static boolean soContemNumeros(String texto) {
//        return texto.matches("[0-9]");
        if (texto == null) {
            return false;
        }
        for (char letra : texto.toCharArray()) {
            if (letra < '0' || letra > '9') {
                return false;
            }
        }
        return true;
    }

//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="Deletar">
    public boolean deletar(int codigo) {
        return excluir(codigo, Empreendedor.class
        );
    }

    public boolean deletarPorEmail(String email) {
        Empreendedor empreendedorEmail = (Empreendedor) buscarObjetoCriteria("email", email, Empreendedor.class);
        return deletar(empreendedorEmail.getIdUsuario());
    }
    
    public boolean deletarNotificacao(int codigo) {
        return excluir(codigo, Notificacao.class);
    }
//</editor-fold>

}
