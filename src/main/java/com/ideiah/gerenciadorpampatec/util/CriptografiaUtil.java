/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <p>
 * Classe responsável por aplicar uma função Hash Criptográfica aos dados
 * sensíveis do usuário como modo de segurança dos mesmos. </p>
 *
 * @author AugustoCesar
 */
public final class CriptografiaUtil {

    public CriptografiaUtil() {
    }

    /**
     * <p>
     * Método responsável por transformar a senha recebida por parâmetro em uma
     * hash criptográfica do tipo MD5.</p>
     *
     * @param senha
     * @return A Hash Criptográfica da senha. Tipo <code>String</code>.
     */
    @Deprecated
    public static String md5(String senha) {
        MessageDigest m;
        try {
            m = MessageDigest.getInstance("MD5");
            m.update(senha.getBytes(), 0, senha.length());
            BigInteger i = new BigInteger(1, m.digest());

//Formatando o resuldado em uma cadeia de 32 caracteres, completando com 0 caso falte 
            senha = String.format("%1$032X", i);

        } catch (Exception ex) {
            Logger.getLogger(CriptografiaUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return senha;
    }
}
