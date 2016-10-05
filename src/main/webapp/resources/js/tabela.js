/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var botaoPadrao;

/**
 * Função que muda a classe do botão quando ele foi clicado pelo usuário, 
 * mas antes disso armazena o valor padrão do mesmo.
 * Ao inciiar a pagina, o todos ja vem clicado 
 * entao foi adicionado um if para verificar se o mesmo foi clicado denovo
 *´para nao mudar a classe para filtro
 * @param {type} botaoClicado
 * @returns {undefined}
 */
function filtroTabela(botaoClicado) {

    var botaoTodos = document.getElementById("locovelho:tabelaProjetoGerente:todos");

    if (botaoPadrao !== undefined) {
        botaoPadrao.setAttribute("class", "filtro");
    }

    botaoClicado.setAttribute("class", "filtro filtroClicado");
    botaoPadrao =botaoClicado;
    if (botaoClicado !== botaoTodos) {
        botaoTodos.setAttribute("class", "filtro");
    }
}