/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var clock;

/**
 * <p>Função ainda em implementaçao, não utilizar!</p>
 * Irá chamar um relógio no canto da página para iniciar uma contágem regressiva.
 * Ao chegar a "0" era finalizar a sessão.
 * @returns {undefined}
 */
function sessionCountdown() {
    var countup;
    clock = $('.your-clock').FlipClock(60, {
        countdown: true,
        clockFace: 'MinuteCounter',
        language: 'pt-br'
    });

    countup = setInterval(function () {
        console.log(clock.getTime().time);
        if (clock.getTime().time <= 0) {
            console.log("No if: "+clock.getTime().time);
            showSweetAlert();
            clearInterval(countup);
        }
    }, 800);
}

/**
 * <p>Método que implementa o alerta da API SweetAlert, 
 * para notificar o usuário que a sessão acabou. </p>
 * 
 * @returns {undefined}
 */
function showSweetAlert() {
//    setTimeout(function () {
        triggerParaInvalidarSessao();
        // sweetAlert: http://t4t5.github.io/sweetalert/
        sweetAlert({
            title: "Bah!",
            text: "Sua sessão expirou!",
            type: "error",
            confirmButtonColor: '#00A859'
        }, function () {
            // Redireciona o usuário para a página de login.
            window.location.href = "/GerenciadorPampatec/loginEmpreendedor.jsf";
        });
//    }, (tempoMaxSessao - 1) * 1000);
}