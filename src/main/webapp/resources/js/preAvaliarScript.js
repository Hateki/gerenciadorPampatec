/* 
 * JavaScript para a página PréAvaliarPlanoNegocio
 */

var POSICAO_REALIZAR_MELHORIA = 1;//Posição em que a opção de realizar ajustes está localizada.

/**
 * Método que mostra e esconde o aviso de que o usuário precisa preencher pelo
 * menos um campo ao enviar para realizar ajuste.
 * @returns {undefined}
 */
function mostrarMensagemCampoObrigatorio() {
    var mensagemRealizarAjustes = document.getElementById("formulario_comentarpreavalizar:mensagemStatusAvaliacao");
    var listacampos = document.getElementsByClassName("campoFeedBack");
    var listaCamposAbertos = document.getElementsByClassName("campoFeedBackOn");
    var cont = 0;

    juntarListas(listacampos, listaCamposAbertos);

    for (var i = 0; i < listacampos.tamanho; i++) {
        var campo = listacampos[i];
        if (campo != null && campo.value != "" &&
                campo.id != "formulario_comentarpreavalizar:campoObservacoes" &&
                campo.id != "formulario_comentarpreavalizar:observacoesPreDefinidas") {
            cont++;
            break;
        }
    }
    if (mensagemRealizarAjustes != null) {
        if (verificaPreechimentoRadioButton()) {
            if (cont == 0) {
                mensagemRealizarAjustes.style.display = "block";
            } else {
                mensagemRealizarAjustes.style.display = "none";
            }
        } else {
            mensagemRealizarAjustes.style.display = "none";
        }
    }
}

/**
 * método usado para juntar 2 listas
 *  disponibilizadas pelo método mostrarMensagemCampoObrigatorio.
 * @param {Array} array1
 * @param {Array} array2
 * @returns {undefined}
 */
function juntarListas(array1, array2) {
    var cont = 0;
    var posicao;
    for (var i = 0; i < array2.length; i++) {
        posicao = array1.length + i;
        array1[posicao] = array2[i];
        cont++;
    }

    array1.tamanho = array1.length + cont;
}
;

/**
 * Verifica se o radio button está com a opção de realizar ajustes selecionada.
 * @returns {Boolean}
 */
function verificaPreechimentoRadioButton() {

    if (document.forms['formulario_comentarpreavalizar']['formulario_comentarpreavalizar:avaliacao'][POSICAO_REALIZAR_MELHORIA].checked) {
        return true;
    }
    return false;
}





