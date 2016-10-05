/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideiah.sisponto02.validacoes;

import ideiah.sisponto02.modelo.Diretor;
import java.util.Date;

/**
 *
 * @author Stephanie
 */
public class ValidacaoDiretor {

    private boolean senhasNaoConferem, dataPosteriorAAtual, dataPosseVazia, confirmacaoSenhaDiretorVazia, senhaDiretorVazia;
    private Date dataPosse;
    private String senhaDiretor;
    private String cargoDiretor;
    private String senhaConfirmacao;

    public ValidacaoDiretor() {

    }
    
    public ValidacaoDiretor(Diretor diretor,String senhaConfirmacao) {
        this.dataPosse = diretor.getDataPosse();
        this.senhaDiretor = diretor.getSenha();
        this.cargoDiretor = diretor.getCargo();
        this.senhaConfirmacao = senhaConfirmacao;
        this.confirmacaoSenhaDiretorVazia = false;
        this.senhaDiretorVazia = false;
        this.dataPosseVazia = false;
        this.senhasNaoConferem = false;
        this.dataPosteriorAAtual = false;

        validarDiretor();
    }

    public ValidacaoDiretor(Date dataPosse, String senhaDiretor, String senhaConfirmacao, String cargoDiretor) {

        this.dataPosse = dataPosse;
        this.senhaDiretor = senhaDiretor;
        this.cargoDiretor = cargoDiretor;
        this.senhaConfirmacao = senhaConfirmacao;
        this.confirmacaoSenhaDiretorVazia = false;
        this.senhaDiretorVazia = false;
        this.dataPosseVazia = false;
        this.senhasNaoConferem = false;
        this.dataPosteriorAAtual = false;

        validarDiretor();
    }

    /**
     * método que chama todos outros métodos para realizarem a validação dos
     * atributos.
     */
    public void validarDiretor() {
        this.validarData();
        this.validarSenha();
    }

    public boolean verificaDiretor() {
        return !(senhaDiretorVazia || dataPosseVazia || senhasNaoConferem || dataPosteriorAAtual || confirmacaoSenhaDiretorVazia);
    }

    /**
     * método que valida data de posse diretor não pode ser data posteior ao
     * registro e se não esta nulla.
     *
     */
    public void validarData() {
        Date dataatual = new Date();
        if (dataPosse == null) {
            this.dataPosseVazia = true;
        } else {
            this.dataPosteriorAAtual = dataPosse.after(dataatual);
        }

    }

    /**
     * Método que verifica a consistencia da senha, tanto senhaDiretor quanto a
     * senha de confirmação.
     *
     */
    public void validarSenha() {
        this.senhaDiretorVazia = senhaDiretor == null;
        if (!senhaDiretorVazia) {
            if (senhaDiretor.trim().isEmpty()) {
                senhaDiretorVazia = true;
            }
        }

        this.confirmacaoSenhaDiretorVazia = senhaConfirmacao == null;
        if (!confirmacaoSenhaDiretorVazia) {
            if (senhaConfirmacao.trim().isEmpty()) {
                confirmacaoSenhaDiretorVazia = true;
            }
        }
        if (!senhaDiretorVazia && !confirmacaoSenhaDiretorVazia) {
            this.senhasNaoConferem = !senhaDiretor.equals(senhaConfirmacao);
        }
    }

    public boolean isSenhasNaoConferem() {
        return senhasNaoConferem;
    }

    public void setSenhasNaoConferem(boolean senhasNaoConferem) {
        this.senhasNaoConferem = senhasNaoConferem;
    }

    public Date getDataPosse() {
        return dataPosse;
    }

    public void setDataPosse(Date dataPosse) {
        this.dataPosse = dataPosse;
    }

    public String getSenhaDiretor() {
        return senhaDiretor;
    }

    public void setSenhaDiretor(String senhaDiretor) {
        this.senhaDiretor = senhaDiretor;
    }

    public String getCargoDiretor() {
        return cargoDiretor;
    }

    public void setCargoDiretor(String cargoDiretor) {
        this.cargoDiretor = cargoDiretor;
    }

    public boolean isDataPosteriorAAtual() {
        return dataPosteriorAAtual;
    }

    public void setDataPosteriorAAtual(boolean dataPosteriorAAtual) {
        this.dataPosteriorAAtual = dataPosteriorAAtual;
    }

    public boolean isConfirmacaoSenhaDiretorVazia() {
        return confirmacaoSenhaDiretorVazia;
    }

    public void setConfirmacaoSenhaDiretorVazia(boolean confirmacaoSenhaDiretorVazia) {
        this.confirmacaoSenhaDiretorVazia = confirmacaoSenhaDiretorVazia;
    }

    public boolean isSenhaDiretorVazia() {
        return senhaDiretorVazia;
    }

    public void setSenhaDiretorVazia(boolean senhaDiretorVazia) {
        this.senhaDiretorVazia = senhaDiretorVazia;
    }

    public String getSenhaConfirmacao() {
        return senhaConfirmacao;
    }

    public void setSenhaConfirmacao(String senhaConfirmacao) {
        this.senhaConfirmacao = senhaConfirmacao;
    }

    public boolean isDataPosseVazia() {
        return dataPosseVazia;
    }

    public void setDataPosseVazia(boolean dataPosseVazia) {
        this.dataPosseVazia = dataPosseVazia;
    }

}
