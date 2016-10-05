package com.ideiah.gerenciadorpampatec.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Pedro
 */
public class FacesUtil {

    public FacesUtil() {
    }

    /**
     * Mensagem de socesso no salvamento.
     *
     * @param idComponente
     */
    public static void addFeedbackSaveSuccess(String idComponente) {
        FacesContext.getCurrentInstance().addMessage(idComponente,
                new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "Salvo", "Sua alteração foi salva com sucesso."));

    }

    /**
     * Mensagem de sucesso.
     *
     * @param message
     */
    public static void addSuccessMessage(String message) {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO,
                        message, message));
    }

    /**
     * Adiciona uma mensagem de informação a um componente específico.
     *
     * @param message
     * @param idComponente
     */
    public static void addSuccessMessage(String message, String idComponente) {
        FacesContext.getCurrentInstance().addMessage(idComponente,
                new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "Operação realizada com sucesso!", message));
    }

    /**
     * Mensagem de erro.
     *
     * @param message
     */
    public static void addErrorMessage(String message) {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        message, message));
    }

    /**
     * Adiciona uma mensagem de erro a um componente específico.
     *
     * @param message
     * @param idComponente
     */
    public static void addErrorMessage(String message, String idComponente) {
        FacesContext.getCurrentInstance().addMessage(idComponente,
                new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "Erro!", message));
    }

    /**
     * Converte uma string em int, extraindo os números que existe nela. Por
     * Exemplo: uma string 555-555 é convertida na int 555555.
     *
     * @param valor
     * @return valor convertido
     */
    public static int transformaInt(String valor) {
        if (valor == null || valor.equals("")) {
            return 0;
        } else {
            return Integer.parseInt(valor.replaceAll("\\D", ""));
        }
    }

    /**
     *
     * Converte uma string em long, extraindo os números que existe nela. Por
     * Exemplo: uma string 555-555 é convertida na long 555555.
     *
     * @param valor
     * @return valor convertido
     */
    public static long transformaLong(String valor) {
        if (valor == null || valor.equals("")) {
            return 0;
        } else {
            return Long.parseLong(valor.replaceAll("\\D", ""));
        }

    }

    /**
     *
     * Retira caracteres especiais
     *
     * @param valor
     * @return valor convertido
     */
    public static String removeCaracteres(String valor) {
        if (valor == null) {
            return "";
        } else {
            return valor.replaceAll("\\D", "");
        }
    }

}
