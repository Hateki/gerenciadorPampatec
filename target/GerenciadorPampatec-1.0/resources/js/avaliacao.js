/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




/**
 * @description 
 * Ao entrar em uma pagina na aba AVALIAÇÃO contendo o workflow 
 * o metodo é chamado na declaração do body, passando o status do projeto
 * então ele usa o método MostraDiv 
 * para apresenta ou esconde componentes da tela conforme esse status 
 * a variavel andamentoProjeto = status do projeto
 * 
 * cada caso seria a apresentação das divs para aquele status usando o metodo MostraDiv
 * ja tranformando o workflow  clicavel ou nao dependendo do status
 * 
 * @returns {undefined}
 */
function carregaPagina() {

    var etapa1 = document.getElementById("etapa1");
    var etapa2 = document.getElementById("etapa2");
    var etapa3 = document.getElementById("etapa3");
    var etapa4 = document.getElementById("etapa4");
    var etapa5 = document.getElementById("etapa5");

    switch (andamentoProjeto) {

//      AVALIACAO = 2;    
        case 2:
            
            etapa4.innerHTML = "<b>Formalização</b>";
            etapa5.innerHTML = "<b>Incubação</b>";

            etapaAtualDoWorkflow = "etapa3";

            etapa1.setAttribute("class", "active");
            etapa2.setAttribute("class", "active");
            etapa3.setAttribute("class", "active, etapaAtual");
            
            mostra_avaliacao();
            
            var etapa = document.getElementById("etapa4");
            etapa.setAttribute("style", "cursor: default;");
            var etapa = document.getElementById("etapa5");
            etapa.setAttribute("style", "cursor: default;");

            break;

//      FORMALIZACAO = 3;
        case 3:
            etapa5.innerHTML = "<b>Incubação</b>";

            etapaAtualDoWorkflow = "etapa4";

            etapa1.setAttribute("class", "active");
            etapa2.setAttribute("class", "active");
            etapa3.setAttribute("class", "active");
            etapa4.setAttribute("class", "active, etapaAtual");

            var etapa = document.getElementById("etapa5");
            etapa.setAttribute("style", "cursor: default;");

            break;

//      INCUBACAO = 4;
        case 4:

            etapa1.setAttribute("class", "active");
            etapa2.setAttribute("class", "active");
            etapa3.setAttribute("class", "active");
            etapa4.setAttribute("class", "active");
            etapa5.setAttribute("class", "active, etapaAtual");
            etapaAtualDoWorkflow = "etapa5";

            break;
            
        default :
            break;
    }
   
}

/**
 * @description Função que exibe o menu vertical referente a etapa de Avaliação
 * @returns {undefined}
 */
function mostra_avaliacao() {

    var divElaboracao = document.getElementById("vertical_etapa_elaboracao");
    divElaboracao.setAttribute("class", "esconder-div");
    var divPreAvaliacao = document.getElementById("vertical_etapa_pre_avaliacao");
    divPreAvaliacao.setAttribute("class", "esconder-div");
    var divAvaliacao = document.getElementById("vertical_etapa_avaliacao");
    divAvaliacao.setAttribute("class", "col-md-2 text-center bounceInLeft animated estiloDivVertical noprint");
    var divFormalizacao = document.getElementById("vertical_etapa_formalizacao");
    divFormalizacao.setAttribute("class", "esconder-div");
    var divIncubacao = document.getElementById("vertical_etapa_incubacao");
    divIncubacao.setAttribute("class", "esconder-div");

}

/**
 * @description Função para alternar entre as DIVs da pagina 
 * é utilizado no metodo carregaPagina
 * @param {type} referencia
 * @returns {undefined}
 */
function mostraDIV(referencia) {
    div1 = document.getElementsByClassName("classeConteudo");
    for (var i = 0; i < div1.length; i++) {

        if (div1[i].getAttribute("id") === referencia) {
            div1[i].setAttribute("class", "classeConteudo col-md-10");
        } else {
            div1[i].setAttribute("class", "classeConteudo esconder-div");
        }
    }
}