package com.ideiah.gerenciadorpampatec.util;

/**
 * <p>Classe responsável por validar números de telefone.</p>
 * 
 * @author unipampa
 */
public class TelefoneUtil {

    public TelefoneUtil() {
    }

    /**
     * <p>
     * Método para remover os parênteses da <code>String</code> telefone.</p>
     *
     * @param telefone
     * @return
     */
    public static String removeParentesesTelefone(String telefone) {
        String numero = "";
        if (telefone != null) {
            for (int i = 0; i < telefone.length(); i++) {
                if (Character.isDigit(telefone.charAt(i))) {
                    numero = numero.concat(String.valueOf(telefone.charAt(i)));
                }
            }
        }
        return numero;
    }
}
