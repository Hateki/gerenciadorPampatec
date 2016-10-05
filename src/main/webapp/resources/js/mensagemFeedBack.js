
var ERRO = 0;//Representa o tipo de mensagem erro.
var SALVO = 1;//Representa o tipo de mensagem de salvar
var timeOutMensagem;

/**
 * Recebe o resultado da requisição ajax. Se ela for positiva, começa um
 * temporizador para fechar a mensagem de salvamento.
 * @param {type} data
 * @returns {undefined}
 */
function funcaoAjaxSalvo(data) {
    clearTimeout(timeOutMensagem);
    if (data.status === 'success') {
        timeOutMensagem = timeoutMensagemFeedBack(SALVO);
    }
}

/**
 * Começa um temporizador que irá fechar a mensagem de salvamento. OBS: Esse
 * método é para ser utilizado nos resultados do 
 * p:ajax(tags:"onsuccess","oncomplete").
 * @returns {undefined}
 */
function funcaoAjaxSalvoPrimeFaces() {
    clearTimeout(timeOutMensagem);
    timeOutMensagem = timeoutMensagemFeedBack(SALVO);
}

/**
 * Recebe o resultado da requisição ajax. Se ela for positiva, começa um
 * temporizador para fechar a mensagem de erro.
 * @param {type} data
 * @returns {undefined}
 */
function funcaoAjaxErro(data) {
    clearTimeout(timeOutMensagem);
    if (data.status === 'success') {
        timeOutMensagem = timeoutMensagemFeedBack(ERRO);
    }
}

/**
 * Determina um tempo para que a mensagem de notificação desapareça da tela.
 * @param {int} tipoNot tipo da notificação que vai desaparecer.
 * @returns {undefined}
 */
function timeoutMensagemFeedBack(tipoNot) {
    return setTimeout(function () {
        if (tipoNot == ERRO) {
            fecharMensagemFeedBackErro();
        } else if (tipoNot == SALVO) {
            fecharMensagemFeedBackSalvo();
        }
    }, 4500);
}

/**
 * Fecha a mensagem de feedBack de salvar
 * @returns {undefined}
 */
function fecharMensagemFeedBackSalvo() {
    var listaNotificacaoSalvo = document.getElementsByClassName("notSalvo");
    for (var i = 0; i < listaNotificacaoSalvo.length; i++) {
        var notificacaoSalvo = listaNotificacaoSalvo[i];
        notificacaoSalvo.setAttribute("class", "ns-box ns-growl notSalvo zoomOut animated");
    }
}

/**
 * Fecha a mensagem de feedBack de erro
 * @returns {undefined}
 */
function fecharMensagemFeedBackErro() {
    var listaNotificacaoSalvo = document.getElementsByClassName("notErro");
    for (var i = 0; i < listaNotificacaoSalvo.length; i++) {
        var notificacaoSalvo = listaNotificacaoSalvo[i];
        notificacaoSalvo.setAttribute("class", "ns-box ns-growl notErro zoomOut animated");
    }
}


