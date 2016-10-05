function confirmaExclusao() {
    if (confirm('Deseja realmente excluir?')) {
        return true;
    } else {
        return false;
    }
}

function ativaCancelar() {
    var button = document.getElementById("closeModal");
    button.click();
}

/**
 * Método que faz com que o usuário possa digitar somente número.
 * @returns {Boolean} true se pode escrever
 */
function SomenteNumero(e) {
    var tecla = (window.event) ? event.keyCode : e.which;
    if ((tecla > 47 && tecla < 58))
        return true;
    else {
        if (tecla == 8 || tecla == 0)
            return true;
        else
            return false;
    }
}

/**
 * Abri a modal de mensagem de sucesso.
 * @returns {undefined}
 */
function abriModalMensagemSucesso() {
    $('#myModal').modal('toggle');
    $('#myModal').on('shown.bs.modal', function () {
        $('#closeModal').focus();
    });
}

/**
 * Método que faz as divs para 
 * @param {type} campoCarto
 */
 function escondeDivDiretor (idCampo) {
     var data = document.getElementById("formCadastro:datepicker");
     data.setAttribute("type","date");
     
     var campoCargo = document.getElementById(idCampo);
     if(campoCargo.value == "Desenvolvedor"){
         if(!$('#divDadosDiretor').hasClass("divDinamicaNone")){
             $('#divDadosDiretor').addClass("divDinamicaNone");
             $('#divDadosDiretor').removeClass("divDinamica");
         }
     }else{
         if(!$('#divDadosDiretor').hasClass("divDinamica")){
             $('#divDadosDiretor').removeClass("divDinamicaNone");
             $('#divDadosDiretor').addClass("divDinamica");
         }
     }
}