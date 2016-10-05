/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author GUTO
 */
@ManagedBean(name = "ajudaview")
public class AjudaView {

    /**
     * @since 22/09/2015
     * @param referencia metodo que recebe a referencia do botão de ajuda
     * clicado na parte de enviar projeto e exibe o componente de ajuda
     */
    public void showMessage(String referencia) {
        FacesMessage message = null;
        switch (referencia) {
            case "nome":

                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Campo Nome", "Esse é o nome da empresa, seja criativo, pois<br/>"
                        + "um nome de empresa coerente é essencial para<br/>"
                        + "um plano de negócio de sucesso.");
                break;

            case "email":
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Campo Email", "Adicione empreendedores sócios para visualizarem<br/> "
                        + "o plano de negócio junto com você. Insira<br/>"
                        + "seus emails para os incluir nesse plano de negócio. <br/>"
                        + "Caso eles não possuam cadastro no sistema, eles se-<br/>"
                        + "rão direcionados ao cadastro de usuário.");
                break;

            case "segmentoDeClientes":
                message = new FacesMessage("Ajuda com preenchimento de Segmento de Cliente", "Exemplos:<br/>-Pessoas que não tempo para ir ao supermercado;<br/>"
                        + "-Usuários que precisam localizar empresas na região;<br/>"
                        + "-Usuários que procuram diversão online.");
//                ctx.addMessage(null, message);
                break;

            case "propostaDeValor":
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ajuda  com preenchimento de Proposta de Valor", "Exemplos:<br/> -Aplicativo onde Cliente Z solicita e compra produto X;<br>"
                        + "-Ferramenta para facilitar a vida do Cliente Y que necessita realizar a atividade W;<br/>"
                        + "-Proporciona maior ( Agilidade, Praticidade, Novidade, Desempenho, Customização, ... ) para o Usuário Z;<br/>"
                        + "-Oferece ( menor preço, redução de custos, redução de riscos, ...) ao Cliente Y;<br/>"
                        + "-Muito mais (Acessibilidade, Conveniência...) do que os concorrentes;");
                break;

            case "atividadesChave":
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ajuda com preenchimento de Atividades Chave", "Exemplos(utilize verbos no infinitivo):<br/> -Manter Plataformas on-line;<br/>"
                        + "-Fabricar o produto X;<br/>"
                        + "-Desenvolver o software Y; <br/>"
                        + "-Pesquisar e Desenvolver novos Produtos; <br/>"
                        + "-Firmar e manter parcerias para operar o Sistema de Entrega do Produto.<br/>"
                        + "-Treinar constantemente a equipe de instaladores do sistema;");
                break;

            case "relacoComClientes":
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ajuda com preenchimento de Relação com cliente", "Exemplo:<br/>-Programa de pontos para clientes que mais compraram;<br/>"
                        + "-Sistema de Avaliação pelos Segmentos de Clientes;<br/>"
                        + "-Plataforma On-line para consulta de Saldos, Compras anteriores, Andamento dos Pedidos,...;");
                break;

            case "parceriasChaves":
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ajuda com preenchimento de Parcerias Chave", "Dica: <br/>Quais as motivações para manter cada parceria: Otimização e economia, Redução de risco e incerteza; <br/>Aquisição de recursos e atividades particulares; Desenvolvimento de um novo produto ou serviço");
                break;

            case "canais":
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ajuda com preenchimento de Canais", "Exemplo:<br/> - Site; Telemarketing; Consultor presencial;<br/> Correios; Transportadora");
                break;

            case "recursosPrincipais":
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ajuda com preenchimento de Recursos Principais", "Exemplo:<br/> -Intelectuais (patentes de marcas, direitos autorais, dados); <br/>"
                        + "-Humanos (quantidade, formação e perfil dos trabalhadores); <br/>"
                        + "-Logísticos (prédios, veículos, equipamentos, ...); <br/>"
                        + "-Tecnológicos (servidores, computadores, softwares, conexão, rede ...)");
                break;

            case "concorrentes":
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Campo Concorrentes", "Descrição");
                break;

            case "estagioDeEvolucao":
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Campo Estagio De Evolucao", "Descrição");
                break;

            case "tecnologiaProcessos":
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ajuda com preenchimento de Tecnologia e Processos", "Dica:<br/> -Conjunto de ações que uma empresa executa, visando o respeito ao meio ambiente e o desenvolvimento sustentável da sociedade.");
                break;

            case "potencialInovacaoTecnologica":
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Campo Potencial de Inovacao e Tecnologica", "Descrição");
                break;

            case "aplicacoes":
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Campo Potencial de Aplicacoes", "Descrição");
                break;

            case "dificuldadesEsperadas":
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Campo Dificuldades Esperadas", "Descrição");
                break;

            case "interacaoEmpresaUniversidade":
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Campo Interacao entre empresa e universidade", "Descrição");
                break;

            case "interacaoEmpresaComunidadeGoverno":
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Campo Interacao entre empresa, comunidade e governo", "Descrição");
                break;

            case "infraestrutura":
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Campo Infraestrutura", "Descrição");
                break;

            case "participacaoAcionaria":
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Campo Participacao Acionaria", "Descrição");
                break;

            case "potencialEmprego":
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Campo Potencial de Emprego", "Descrição");
                break;

            case "fontesDeReceita":
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ajuda  com preenchimento de Fontes de Receitas", "Dica:<br/> -Por qual preço estão dispostos a pagar nossos clientes? <br/>"
                        + "-Quanto pagam atualmente? "
                        + "Como pagam atualmente?"
                        + "Como eles gostariam de pagar?<br/>"
                        + "Exemplos:<br/> "
                        + "-Venda de ativos; "
                        + "Taxas de uso; "
                        + "Taxas de assinatura;<br/>"
                        + "-Licenciamento; "
                        + "Anuncio ;<br/>"
                        + "-Preços por lista (Dependente de características do produto ou do segmento de cliente);");
                break;

            case "estruturaCustos":
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Campo Estrutura de Custos", "Descrição");
                break;

            case "investimentoInicial":
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Campo Investimento Inicial", "Descrição");
                break;

            case "custosfixos":
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Campo Custos Fixos", "Descrição");
                break;

            case "custosvariaveis":
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Campo Custos Variaveis", "Descrição");
                break;

            case "campoObservacoes":
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Atribuir Status de Avaliação", "Descricao");
                break;

            case "statusAvaliacao":
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Atribuir Status de Avaliação", "O status de avaliação indica a situação do <br/>"
                        + "plano de negócio, escolha uma das opções disponívels.");
                break;
                
            case "observacoesPreDefinidas":
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Campo Mensagem Pré Definida", "Este campo não pode ser alterado, ele trará uma <br/>"
                        + "mensagem padrão conforme a opção selecionada em avaliação.");
                break;
        }

        RequestContext.getCurrentInstance().showMessageInDialog(message);
    }

}
