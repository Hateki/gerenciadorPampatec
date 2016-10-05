/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideiah.sisponto02.validacoes;

/**
 *
 * @author Jonas Chagas
 */
public class ValidacaoCodigoDeAcesso {

    /**
     * mÃ©todo que valida o código de acesso
     *
     * @param o
     * @throws ExcecoesValidacao
     */
    public void validate(Object o) throws ExcecoesValidacao {

        boolean numero = true;
        if (o.toString().length() > 15) {
            throw new ExcecoesValidacao("O campo não pode conter mais de 15 caracteres");
        }

        for (int i = 0; i < o.toString().length(); i++) {
            Character caractere = o.toString().charAt(i);
            if (Character.isDigit(caractere)) {
                numero = false;
                break;
            }
        }
        if (numero) {
            throw new ExcecoesValidacao("O campo deve conter pelo menos um número");
        }
    }
}