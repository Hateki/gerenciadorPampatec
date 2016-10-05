/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* variavel para armazenar o objeto do botao anterior */
/* global andamentoProjeto */

var objetoBotaoAnterior = null;

/* campo para armazenar a classe dO botao que o usuario esta visualizando antes de ir para outro */
var classeBotaoAnterior = null;

/* armazena o temporizador da sessão para mostrar a mensagem*/
var timeOutSessao = null;

var time = 1800;


/**
 * @description 
 * Ao entrar em uma pagina na aba PRE AVALIAÇÃO contendo o workflow 
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

//      SUBMETIDO = 1;
        case 1:
            etapa3.innerHTML = "<b>Avaliação</b>";
            etapa4.innerHTML = "<b>Formalização</b>";
            etapa5.innerHTML = "<b>Incubação</b>";
            etapa1.setAttribute("class", "active");
            etapa2.setAttribute("class", "active, etapaAtual etapaSelecionada");
            etapaAtualDoWorkflow = "etapa2";

            mostraDIV('sessao_plano_nao_avaliado');

            var etapa = document.getElementById("etapa3");
            etapa.setAttribute("style", "cursor: default;");
            var etapa = document.getElementById("etapa4");
            etapa.setAttribute("style", "cursor: default;");
            var etapa = document.getElementById("etapa5");
            etapa.setAttribute("style", "cursor: default;");

            break;

//      RESUBMETIDO = 11;
        case 11:
            etapa3.innerHTML = "<b>Avaliação</b>";
            etapa4.innerHTML = "<b>Formalização</b>";
            etapa5.innerHTML = "<b>Incubação</b>";
            etapa1.setAttribute("class", "active");
            etapa2.setAttribute("class", "active, etapaAtual etapaSelecionada");
            etapaAtualDoWorkflow = "etapa2";

            mostraDIV('sessao_plano_nao_avaliado');

            var etapa = document.getElementById("etapa3");
            etapa.setAttribute("style", "cursor: default;");
            var etapa = document.getElementById("etapa4");
            etapa.setAttribute("style", "cursor: default;");
            var etapa = document.getElementById("etapa5");
            etapa.setAttribute("style", "cursor: default;");

            break;

//      EM PRE AVALIAÇÃO = 12;
        case 12:
            etapa3.innerHTML = "<b>Avaliação</b>";
            etapa4.innerHTML = "<b>Formalização</b>";
            etapa5.innerHTML = "<b>Incubação</b>";
            etapa1.setAttribute("class", "active");
            etapa2.setAttribute("class", "active, etapaAtual etapaSelecionada");
            etapaAtualDoWorkflow = "etapa2";

            mostraDIV('sessao_plano_nao_avaliado');

            var etapa = document.getElementById("etapa3");
            etapa.setAttribute("style", "cursor: default;");
            var etapa = document.getElementById("etapa4");
            etapa.setAttribute("style", "cursor: default;");
            var etapa = document.getElementById("etapa5");
            etapa.setAttribute("style", "cursor: default;");

            break;

//      SENDO AVALIADO = 10;
        case 10:
            etapa3.innerHTML = "<b>Avaliação</b>";
            etapa4.innerHTML = "<b>Formalização</b>";
            etapa5.innerHTML = "<b>Incubação</b>";
            etapa1.setAttribute("class", "active");
            etapa2.setAttribute("class", "active, etapaAtual etapaSelecionada");
            etapaAtualDoWorkflow = "etapa2";

            mostraDIV('sessao_plano_nao_avaliado');

            var etapa = document.getElementById("etapa3");
            etapa.setAttribute("style", "cursor: default;");
            var etapa = document.getElementById("etapa4");
            etapa.setAttribute("style", "cursor: default;");
            var etapa = document.getElementById("etapa5");
            etapa.setAttribute("style", "cursor: default;");

            break;

//      ACEITO PARA AVALIAÇÃO = 2;    
        case 2:
            etapa4.innerHTML = "<b>Formalização</b>";
            etapa5.innerHTML = "<b>Incubação</b>";
            etapa1.setAttribute("class", "active");
            etapa2.setAttribute("class", "active etapaSelecionada");
            etapa3.setAttribute("class", "active etapaAtual");

            etapaAtualDoWorkflow = "etapa3";

            mostraDIV('sessao_resultado_avaliador');

            addFocoBotao("menuSuperior:botao_resultado_preavaliacao");

            var etapa = document.getElementById("etapa4");
            etapa.setAttribute("style", "cursor: default;");
            var etapa = document.getElementById("etapa5");
            etapa.setAttribute("style", "cursor: default;");

            break;

//      REPROVADO = 6;
        case 6:
            etapa3.innerHTML = "<b>Avaliação</b>";
            etapa4.innerHTML = "<b>Formalização</b>";
            etapa5.innerHTML = "<b>Incubação</b>";
            etapa1.setAttribute("class", "active");
            etapa2.setAttribute("class", "active, etapaAtual etapaSelecionada");

            var botaoResultadoPreAvaliacao = document.getElementById("menuSuperior:botao_resultado_preavaliacao");
            botaoResultadoPreAvaliacao.setAttribute("class", "btn btn-danger btnEstadoAtual");

            mostraDIV('sessao_resultado_avaliador');
            addFocoBotao("menuSuperior:botao_resultado_preavaliacao");

            var etapa = document.getElementById("etapa3");
            etapa.setAttribute("style", "cursor: default;");
            var etapa = document.getElementById("etapa4");
            etapa.setAttribute("style", "cursor: default;");
            var etapa = document.getElementById("etapa5");
            etapa.setAttribute("style", "cursor: default;");
            break;

//     NECESSITA_MELHORIA = 7
        case 7:
            etapa3.innerHTML = "<b>Avaliação</b>";
            etapa4.innerHTML = "<b>Formalização</b>";
            etapa5.innerHTML = "<b>Incubação</b>";
            etapa1.setAttribute("class", "active");
            etapa2.setAttribute("class", "active, etapaAtual etapaSelecionada");

            var botaoResultadoPreAvaliacao = document.getElementById("menuSuperior:botao_resultado_preavaliacao");
            botaoResultadoPreAvaliacao.setAttribute("class", "btn btn-danger btnEstadoAtual");

            mostraDIV('sessao_resultado_avaliador');
            addFocoBotao("menuSuperior:botao_resultado_preavaliacao");

            var etapa = document.getElementById("etapa3");
            etapa.setAttribute("style", "cursor: default;");
            var etapa = document.getElementById("etapa4");
            etapa.setAttribute("style", "cursor: default;");
            var etapa = document.getElementById("etapa5");
            etapa.setAttribute("style", "cursor: default;");
            break;

            //     REVISANDO = 13
        case 13:
            etapa3.innerHTML = "<b>Avaliação</b>";
            etapa4.innerHTML = "<b>Formalização</b>";
            etapa5.innerHTML = "<b>Incubação</b>";
            etapa1.setAttribute("class", "active");
            etapa2.setAttribute("class", "active, etapaAtual etapaSelecionada");

            var botaoResultadoPreAvaliacao = document.getElementById("menuSuperior:botao_resultado_preavaliacao");
            botaoResultadoPreAvaliacao.setAttribute("class", "btn btn-danger btnEstadoAtual");

            mostraDIV2('sessao_revisar_plano_pre_melhoria');

            var etapa = document.getElementById("etapa3");
            etapa.setAttribute("style", "cursor: default;");
            var etapa = document.getElementById("etapa4");
            etapa.setAttribute("style", "cursor: default;");
            var etapa = document.getElementById("etapa5");
            etapa.setAttribute("style", "cursor: default;");
            break;

        default :
            break;
    }
}

/**
 * @description Função que exibe o menu vertical referente a etapa de pré avaliação
 * @returns {undefined}
 */
function mostra_vertical_pre_avaliacao() {


    var divElaboracao = document.getElementById("vertical_etapa_elaboracao");
    divElaboracao.setAttribute("class", "esconder-div");
    var divPreAvaliacao = document.getElementById("vertical_etapa_pre_avaliacao");
    divPreAvaliacao.setAttribute("class", "col-md-2 text-center bounceInLeft animated estiloDivVertical noprint");
    var divAvaliacao = document.getElementById("vertical_etapa_avaliacao");
    divAvaliacao.setAttribute("class", "esconder-div");
    var divFormalizacao = document.getElementById("vertical_etapa_formalizacao");
    divFormalizacao.setAttribute("class", "esconder-div");
    var divIncubacao = document.getElementById("vertical_etapa_incubacao");
    divIncubacao.setAttribute("class", "esconder-div");
}

/**
 * @description Função para alternar entre as DIVs
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
/**
 * @description Esta função é chamada para validar que quando o plano está em melhoria 
 * e os empreendedores observadores tentarem acessar o plano.
 * @param {type} referencia
 */
function mostraDIV2(referencia) {
    // se andamento está em elaboração
    if (andamentoProjeto === 13) {
        // se o empreendedor é correspondente
        if (tipoEmpreededor) {
            mostraDIV(referencia);
            addFocoBotao("menuSuperior:botao_revisar");
        } else {
            // se empreendedor não é correspondente, apenas mostra plano para revisar
            mostraDIV('sessao_resultado_avaliador');
            addFocoBotao("menuSuperior:botao_resultado_preavaliacao");
        }
    }
}


/**
 * @description Coloca foco no botao em que o usuário está visualizando no workflow vertical
 * @param {type} idDoItem
 * @returns {undefined}
 */
function addFocoBotao(idDoItem) {
    var etapaBotao = document.getElementById(idDoItem);
    if (objetoBotaoAnterior !== null) {
        retornarCorOriginalBotao();
    }
    classeBotaoAnterior = etapaBotao.getAttribute('class');
    etapaBotao.setAttribute("class", classeBotaoAnterior + " pulse animated bordaEstadoVisualizado");
    objetoBotaoAnterior = etapaBotao;

}


/**
 * @description Retorna a classe original do botao que o usuário deixou de visualizar
 * @returns {undefined}
 */
function retornarCorOriginalBotao() {
    objetoBotaoAnterior.setAttribute("class", classeBotaoAnterior);
}

/**
 * Como Empreendedor
 * É chamado no body da página (ao caregar a página)
 * verifica a existencia de comentários em todos os campos dentro das abas
 * Se houver, os metodos das Abas mudam a cor das Abas.
 */
function verificaComentariosRevisar() {

    verificaComentarioNegocioRevisar();
    verificaComentarioAnaliseMercadoRevisar();
    verificaComentarioProdutoServicoRevisar();
    verificaComentarioGestaoPessoasRevisar();
    verificaComentarioPlanoFinanceiroRevisar();

}

/**
 * Como Gerente
 * É chamado no body da página (ao caregar a página)
 * verifica a existencia de comentários em todos os campos dentro das abas
 * Se houver, os metodos das Abas mudam a cor das Abas.
 */
function verificaComentariosPreAvaliar() {

    verificaComentarioNegocioPreAvaliar();
    verificaComentarioAnaliseMercadoPreAvaliar();
    verificaComentarioProdutoServicoPreAvaliar();
    verificaComentarioGestaoPessoasPreAvaliar();
    verificaComentarioPlanoFinanceiroPreAvaliar();

}

/**
 * Como Empreendedor
 * Preenche uma lista contendo os elementos dos comentarios dos campos
 * verifica a existencia de comentários em  campos dentro da aba Negocio
 * Se houver, o metodo mudarCorLista muda a cor da Aba.
 */
function verificaComentarioNegocioRevisar() {

    var comentarioSegmentoDeClientes = document.getElementById("formulario_resubmeterplano:segmentoDeClientes3");
    var comentarioPropostaDeValor = document.getElementById("formulario_resubmeterplano:propostaDeValor3");
    var comentarioAtividadesChave = document.getElementById("formulario_resubmeterplano:atividadesChaves3");
    var tabNegocio = document.getElementById("tabNegocio");
    var listaCampos = new Array();

    listaCampos[0] = comentarioSegmentoDeClientes;
    listaCampos[1] = comentarioPropostaDeValor;
    listaCampos[2] = comentarioAtividadesChave;

    mudarCorLista(listaCampos, tabNegocio, "Negócio");
}

/**
 * Como Gerente
 * Preenche uma lista contendo os elementos dos comentarios dos campos
 * verifica a existencia de comentários em  campos dentro da aba Negocio
 * Se houver, o metodo mudarCorLista muda a cor da Aba.
 */
function verificaComentarioNegocioPreAvaliar() {

    var comentarioSegmentoDeClientes = document.getElementById("formulario_comentarpreavalizar:segmentoDeCliente2");
    var comentarioPropostaDeValor = document.getElementById("formulario_comentarpreavalizar:propostaDeValor2");
    var comentarioAtividadesChave = document.getElementById("formulario_comentarpreavalizar:atividadesChave2");
    var tabNegocio = document.getElementById("tabNegocio");
    var listaCampos = new Array();

    listaCampos[0] = comentarioSegmentoDeClientes;
    listaCampos[1] = comentarioPropostaDeValor;
    listaCampos[2] = comentarioAtividadesChave;

    mudarCorListaPreAvaliar(listaCampos, tabNegocio, "Negócio");
}

/**
 * Como Empreendedor
 * Preenche uma lista contendo os elementos dos comentarios dos campos
 * verifica a existencia de comentários em  campos dentro da aba Analise de Mercado
 * Se houver, o metodo mudarCorLista muda a cor da Aba.
 */
function verificaComentarioAnaliseMercadoRevisar() {

    var comentarioRelacoComClientes = document.getElementById("formulario_resubmeterplano:relacaoClientes3");
    var comentarioParceriasChaves = document.getElementById("formulario_resubmeterplano:parceriasChaves3");
    var comentarioCanais = document.getElementById("formulario_resubmeterplano:canais3");
    var comentarioRecursosPrincipais = document.getElementById("formulario_resubmeterplano:recursosPrincipais3");
    var comentarioConcorrentes = document.getElementById("formulario_resubmeterplano:concorrentes3");
    var tabAnaliseMercado = document.getElementById("tabAnaliseMercado");
    var listaCampos = new Array();

    listaCampos[0] = comentarioRelacoComClientes;
    listaCampos[1] = comentarioParceriasChaves;
    listaCampos[2] = comentarioCanais;
    listaCampos[3] = comentarioRecursosPrincipais;
    listaCampos[4] = comentarioConcorrentes;

    mudarCorLista(listaCampos, tabAnaliseMercado, "Análise de Mercado");
}

/**
 * Como Gerente
 * Preenche uma lista contendo os elementos dos comentarios dos campos
 * verifica a existencia de comentários em  campos dentro da aba Analise de Mercado
 * Se houver, o metodo mudarCorLista muda a cor da Aba.
 */
function verificaComentarioAnaliseMercadoPreAvaliar() {

    var comentarioRelacaoComClientes = document.getElementById("formulario_comentarpreavalizar:relacaoClientes2");
    var comentarioParceriasChave = document.getElementById("formulario_comentarpreavalizar:parceriasChave2");
    var comentarioCanais = document.getElementById("formulario_comentarpreavalizar:canais2");
    var comentarioRecursosPrincipais = document.getElementById("formulario_comentarpreavalizar:recursosPrincipais2");
    var comentarioConcorrentes = document.getElementById("formulario_comentarpreavalizar:concorrentes2");
    var tabAnaliseMercado = document.getElementById("tabAnaliseMercado");
    var listaCampos = new Array();

    listaCampos[0] = comentarioRelacaoComClientes;
    listaCampos[1] = comentarioParceriasChave;
    listaCampos[2] = comentarioCanais;
    listaCampos[3] = comentarioRecursosPrincipais;
    listaCampos[4] = comentarioConcorrentes;

    mudarCorListaPreAvaliar(listaCampos, tabAnaliseMercado, "Análise de Mercado");
}

/**
 * Como Empreendedor
 * Preenche uma lista contendo os elementos dos comentarios dos campos
 * verifica a existencia de comentários em  campos dentro da aba Protudo e Serviço
 * Se houver, o metodo mudarCorLista muda a cor da Aba.
 */
function verificaComentarioProdutoServicoRevisar() {

    var comentarioEstagioEvolucao = document.getElementById("formulario_resubmeterplano:estagioEvolucao3");
    var comentarioTecnologiaProcessos = document.getElementById("formulario_resubmeterplano:tecnologiaProcessos3");
    var comentarioPotencialInovacaoTecnologica = document.getElementById("formulario_resubmeterplano:potencialInovacaoTecnologica3");
    var comentarioAplicacoes = document.getElementById("formulario_resubmeterplano:aplicacoes3");
    var comentarioDificuldadesEsperadas = document.getElementById("formulario_resubmeterplano:dificuldadesEsperadas3");
    var comentarioInteracaoEmpresaUniversidade = document.getElementById("formulario_resubmeterplano:interacaoEmpresaUniversidade3");
    var comentarioInteracaoEmpresaComunidadeGoverno = document.getElementById("formulario_resubmeterplano:interacaoEmpresaComunidadeGoverno3");
    var comentarioInfraestrutura = document.getElementById("formulario_resubmeterplano:infraestrutura3");
    var tabProdutoServico = document.getElementById("tabProdutoServico");
    var listaCampos = new Array();
    listaCampos[0] = comentarioEstagioEvolucao;
    listaCampos[1] = comentarioTecnologiaProcessos;
    listaCampos[2] = comentarioPotencialInovacaoTecnologica;
    listaCampos[3] = comentarioAplicacoes;
    listaCampos[4] = comentarioDificuldadesEsperadas;
    listaCampos[5] = comentarioInteracaoEmpresaUniversidade;
    listaCampos[6] = comentarioInteracaoEmpresaComunidadeGoverno;
    listaCampos[7] = comentarioInfraestrutura;

    mudarCorLista(listaCampos, tabProdutoServico, "Produto ou Serviço");
}

/**
 * Como Gerente
 * Preenche uma lista contendo os elementos dos comentarios dos campos
 * verifica a existencia de comentários em  campos dentro da aba Protudo e Serviço
 * Se houver, o metodo mudarCorLista muda a cor da Aba.
 */
function verificaComentarioProdutoServicoPreAvaliar() {

    var comentarioEstagioEvolucao = document.getElementById("formulario_comentarpreavalizar:estagioEvolucao2");
    var comentarioTecnologiaProcessos = document.getElementById("formulario_comentarpreavalizar:tecnologiaProcessos2");
    var comentarioPotencialInovacaoTecnologica = document.getElementById("formulario_comentarpreavalizar:potencialInovacaoTecnologica2");
    var comentarioAplicacoes = document.getElementById("formulario_comentarpreavalizar:aplicacoes2");
    var comentarioDificuldadesEsperadas = document.getElementById("formulario_comentarpreavalizar:dificuldadesEsperadas2");
    var comentarioInteracaoEmpresaUniversidade = document.getElementById("formulario_comentarpreavalizar:interacaoEmpresaUniversidade2");
    var comentarioInteracaoEmpresaComunidadeGoverno = document.getElementById("formulario_comentarpreavalizar:interacaoEmpresaComunidadeGoverno2");
    var comentarioInfraestrutura = document.getElementById("formulario_comentarpreavalizar:infraestrutura2");
    var tabProdutoServico = document.getElementById("tabProdutoServico");
    var listaCampos = new Array();

    listaCampos[0] = comentarioEstagioEvolucao;
    listaCampos[1] = comentarioTecnologiaProcessos;
    listaCampos[2] = comentarioPotencialInovacaoTecnologica;
    listaCampos[3] = comentarioAplicacoes;
    listaCampos[4] = comentarioDificuldadesEsperadas;
    listaCampos[5] = comentarioInteracaoEmpresaUniversidade;
    listaCampos[6] = comentarioInteracaoEmpresaComunidadeGoverno;
    listaCampos[7] = comentarioInfraestrutura;

    mudarCorListaPreAvaliar(listaCampos, tabProdutoServico, "Produto ou Serviço");
}

/**
 * Como Empreendedor
 * Preenche uma lista contendo os elementos dos comentarios dos campos
 * verifica a existencia de comentários em  campos dentro da aba Gestão de Pessoas
 * Se houver, o metodo mudarCorLista muda a cor da Aba.
 */
function verificaComentarioGestaoPessoasRevisar() {

    var comentarioParticipacaoAcionaria = document.getElementById("formulario_resubmeterplano:participacaoAcionaria3");
    var comentarioPotencialEmprego = document.getElementById("formulario_resubmeterplano:potencialEmprego3");
    var tabGestaoPessoas = document.getElementById("tabGestaoPessoas");
    var listaCampos = new Array();

    listaCampos[0] = comentarioParticipacaoAcionaria;
    listaCampos[1] = comentarioPotencialEmprego;

    mudarCorLista(listaCampos, tabGestaoPessoas, "Gestão de Pessoas");
}

/**
 * Como gerente
 * Preenche uma lista contendo os elementos dos comentarios dos campos
 * verifica a existencia de comentários em  campos dentro da aba Gestão de Pessoas
 * Se houver, o metodo mudarCorLista muda a cor da Aba.
 */
function verificaComentarioGestaoPessoasPreAvaliar() {

    var comentarioParticipacaoAcionaria = document.getElementById("formulario_comentarpreavalizar:participacaoAcionaria2");
    var comentarioPotencialEmprego = document.getElementById("formulario_comentarpreavalizar:potencialEmprego2");
    var tabGestaoPessoas = document.getElementById("tabGestaoPessoas");
    var listaCampos = new Array();

    listaCampos[0] = comentarioParticipacaoAcionaria;
    listaCampos[1] = comentarioPotencialEmprego;

    mudarCorListaPreAvaliar(listaCampos, tabGestaoPessoas, "Gestão de Pessoas");
}

/**
 * Como Empreendedor
 * Preenche uma lista contendo os elementos dos comentarios dos campos
 * verifica a existencia de comentários em  campos dentro da aba Plano Financeiro
 * Se houver, o metodo mudarCorLista muda a cor da Aba.
 */
function verificaComentarioPlanoFinanceiroRevisar() {

    var comentarioFontesDeReceita = document.getElementById("formulario_resubmeterplano:fontesDeReceita3");
    var comentarioEstruturaCustos = document.getElementById("formulario_resubmeterplano:estruturaCustos3");
    var comentarioInvestimentoInicial = document.getElementById("formulario_resubmeterplano:investimentoInicial3");
    var comentarioTabelaCustoFixo = document.getElementById("formulario_resubmeterplano:comentarioCustoFixo2");
    var comentarioTabelaCustoVariavel = document.getElementById("formulario_resubmeterplano:comentarioCustoVariavel2");
    var tabPlanoFinanceiro = document.getElementById("tabPlanoFinanceiro");
    var listaCampos = new Array();

    listaCampos[0] = comentarioFontesDeReceita;
    listaCampos[1] = comentarioEstruturaCustos;
    listaCampos[2] = comentarioInvestimentoInicial;
    listaCampos[3] = comentarioTabelaCustoFixo;
    listaCampos[4] = comentarioTabelaCustoVariavel;

    mudarCorLista(listaCampos, tabPlanoFinanceiro, "Plano Financeiro");
}

/**
 * Como Gerente
 * Preenche uma lista contendo os elementos dos comentarios dos campos
 * verifica a existencia de comentários em  campos dentro da aba Plano Financeiro
 * Se houver, o metodo mudarCorLista muda a cor da Aba.
 */
function verificaComentarioPlanoFinanceiroPreAvaliar() {

    var comentarioFontesDeReceita = document.getElementById("formulario_comentarpreavalizar:fontesDeReceita2");
    var comentarioEstruturaCustos = document.getElementById("formulario_comentarpreavalizar:estruturaCustos2");
    var comentarioInvestimentoInicial = document.getElementById("formulario_comentarpreavalizar:investimentoInicial2");
    var comentarioTabelaCustoFixo = document.getElementById("formulario_comentarpreavalizar:comentarioCustoFixo2");
    var comentarioTabelaCustoVariavel = document.getElementById("formulario_comentarpreavalizar:comentarioCustoVariavel2");
    var tabPlanoFinanceiro = document.getElementById("tabPlanoFinanceiro");
    var listaCampos = new Array();

    listaCampos[0] = comentarioFontesDeReceita;
    listaCampos[1] = comentarioEstruturaCustos;
    listaCampos[2] = comentarioInvestimentoInicial;
    listaCampos[3] = comentarioTabelaCustoFixo;
    listaCampos[4] = comentarioTabelaCustoVariavel;

    mudarCorListaPreAvaliar(listaCampos, tabPlanoFinanceiro, "Plano Financeiro");
}

/**
 * Método Usado pelos métodos de Aba (Ex: verificaNegocio)
 * para mudar a cor e o icone das Abas
 * @param {type} listaCampos
 * @param {type} tab
 * @param {type} nomeCampo
 * @returns {undefined}
 */
function mudarCorLista(listaCampos, tab, nomeCampo) {
    var flagCompleto = false;
    for (var i = 0; i < listaCampos.length; i++) {
        if (verificaPreenchimentoComentario(listaCampos[i])) {
            flagCompleto = false;
            break;
        } else {
            flagCompleto = true;
        }
    }

    if (flagCompleto) {
        tab.innerHTML = nomeCampo + " <i id='idIconContato' class='fa fa-check-square'></i>";
        tab.style.color = "green";
    } else {
        tab.innerHTML = nomeCampo + " <i id='idIconContato' class='fa fa-comment-o'></i>";
        tab.style.color = "red";
    }
}

function mudarCorListaPreAvaliar(listaCampos, tab, nomeCampo) {
    var flagCompleto = false;
    for (var i = 0; i < listaCampos.length; i++) {
        if (verificaPreenchimentoComentario(listaCampos[i])) {
            flagCompleto = false;
            break;
        } else {
            flagCompleto = true;
        }
    }

    if (flagCompleto) {
        tab.innerHTML = nomeCampo;
        tab.style.color = "#2780e3";
    } else {
        tab.innerHTML = nomeCampo + " <i id='idIconContato' class='fa fa-comment-o'></i>";
        tab.style.color = "orange";
    }
}

/**
 * @description Verifica o preenchimento do campo de formulário desejado
 * @param {type} campo
 * @returns {Boolean}
 */
function verificaPreenchimentoComentario(campo) {
    if (campo.value === "") {
        return false;
    } else {
        return true;
    }
}

/**
 * @description Ao salvar via ajax atualiza a aba para amarela e adiciona o icone de comentario
 * @param {type} data
 * @returns {undefined}
 */
function funcaoAjaxSalvoAtualizandoAbas(data) {
    if (data.status === "success") {
        verificaComentariosPreAvaliar();
        funcaoAjaxSalvo(data);
    }
}

/**
 * @description Metodo que exibe ou esconde os campos de mostrar comentarios do historico na realizar pré-avaliação
 * @param {type} idCampo
 * @param {type} idDiv
 * @returns {undefined}
 */
function mostrarFeedBackHistorico(idCampo, idDiv) {
    var campo = document.getElementById(idCampo);
    var div = document.getElementById(idDiv);
    if ($(campo).hasClass("campoFeedBackOn historicoComentario")) {
        $(campo).fadeOut(900);
        $(div).fadeOut(900);
        campo.setAttribute("class", "campoFeedBack historicoComentario");
        div.setAttribute("class", "campoFeedBack col-md-12 div-separacao");
    } else {
        $(campo).fadeIn(900);
        $(div).fadeIn(900);
        campo.setAttribute("class", "campoFeedBackOn historicoComentario");
        div.setAttribute("class", "campoFeedBackOn col-md-12 div-separacao");
    }
}

/**
 * @description Metodo que exibe ou esconde os campos de adicionar comentarios na realizar pré-avaliação
 * @param {type} id
 * @param {type} idBotao
 * @returns {undefined}
 */

function mostrarFeedBack(idCampo,idBotao, idAlteracao) {
    var campo = document.getElementById(idCampo);
    var botao = document.getElementById(idBotao);
    var alteracao = document.getElementById(idAlteracao);
    if ($(campo).hasClass("form-control campoFeedBackOn")) {
        $(campo).fadeOut(900);
        campo.setAttribute("class", "form-control campoFeedBack");
        //botao.setAttribute("class", "botaoBaseComentario botaoVerde");
		//    botao.setAttribute("value", "Fechar Comentário");
		//    botao.setAttribute("icon", "fa fa-minus");
        alteracao.setAttribute("class","campoFeedBack");
    } else {
        $(campo).fadeIn(900);
        campo.setAttribute("class", "form-control campoFeedBackOn");
        //botao.setAttribute("class", "botaoBaseComentario botaoVerdeMarcado");
        alteracao.setAttribute("class","campoFeedBackOn");
        //   botao.setAttribute("value", "Adicionar Comentário");
		//   botao.setAttribute("icon", "fa fa-plus");
    }
}

/**
 * Seta um tempo para exibir a mensagem de término da sessão.
 * @returns {undefined}
 */
function temporizadorSessao(){
    clearTimeout(timeOutSessao);
    setTimeout(function (){
        mostraMensagemFimSessao();
    },60000);
}

/**
 * Mostra a mensagem de termino da sessão.
 * @returns {undefined}
 */
function mostraMensagemFimSessao() {
    sweetAlert({
        title: "Bah!",
        text: "Sua sessão expirou!",
        type: "error",
        confirmButtonColor: '#00A859'
    }, function () {
        // Redireciona o usuário para a página de login.
        window.location.href = "/GerenciadorPampatec/loginEmpreendedor.jsf";
    });

}