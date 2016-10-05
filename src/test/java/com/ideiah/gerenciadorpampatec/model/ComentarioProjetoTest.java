/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.model;

import java.util.Date;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pedro
 */
public class ComentarioProjetoTest {

    // <editor-fold defaultstate="collapsed" desc="Variáveis para os testes.">
    private final String testeTextoGigante;
    String textoSegmentoCliente = "Teste do histórico de comentário Segmento de Cliente.";
    String textoPropostaValor = "Teste do histórico de comentário Proposta Valor.";
    String textoAtividadesChave = "Teste do histórico de comentário Atividades Chave.";
    String textoRelacoesCliente = "Teste do histórico de comentário Relações com Cliente.";
    String textoParceriasChave = "Teste do histórico de comentário Parcerias Chave.";
    String textoCanais = "Teste do histórico de comentário Canais.";
    String textoRecursosPrincipais = "Teste do histórico de comentário Recursos Principais.";
    String textoConcorrentes = "Teste do histórico de comentário Concorrencias.";
    String textoEstagioEvolucao = "Teste do histórico de comentário Estagio de Evolução.";
    String textoTecnologiaProcessos = "Teste do histórico de comentário Tecnologia de Processos.";
    String textoPotencialInovacaoTecnologica = "Teste do histórico de comentário Potencial de Inovação Tecnologica.";
    String textoAplicacoes = "Teste do histórico de comentário Aplicações.";
    String textoDificuldadesEsperadas = "Teste do histórico de comentário Dificuldades Esperadas.";
    String textoInteracaoEmpresaUniversidade = "Teste do histórico de comentário Interação entre Empresa e Universidade.";
    String textoInteracaoEmpresaComunidadeGoverno = "Teste do histórico de comentário Interação entreEmpresa, Comunidade e Governo.";
    String textoInfraestrutura = "Teste do histórico de comentário Infraestrutura.";
    String textoParticipacaoAcionaria = "Teste do histórico de comentátio Participação Acionaria.";
    String textoPotencialEmprego = "Teste do histórico de comentátio Potencial de Emprego.";
    String textoFonteReceita = "Teste do histórico de comentátio Fontes de Receita.";
    String textoEstruturaCusto = "Teste do histórico de comentátio Estrutura de Cutos.";
    String textoInvestimentoInicial = "Teste do histórico de comentátio Investimento Inicial.";
    String textoCustoFixo = "Teste do histórico de comentátio Custos Fixos.";
    String textoCustovariavel = "Teste do histórico de comentátio Custos variáveis.";
    // </editor-fold>

    public ComentarioProjetoTest() {
        // <editor-fold defaultstate="collapsed" desc="Texto Gigante para os testes!">
        testeTextoGigante = "https://pt.wikipedia.org/wiki/Teste_de_software Teste de software\n"
                + "Origem: Wikipédia, a enciclopédia livre.\n"
                + "O teste do software é a investigação do software a fim de fornecer informações sobre sua qualidade em relação ao contexto em que ele deve operar. Isso inclui o processo de utilizar o produto para encontrar seus defeitos.\n"
                + "O teste é um processo realizado pelo testador de software, que permeia outros processos da engenharia de software, e que envolve ações que vão do levantamento de requisitos até a execução do teste propriamente dito."
                + "De forma geral, mensurar o bom funcionamento de um software envolve compará-lo com elementos como especificações, outros softwares da mesma linha, versões anteriores do mesmo produto, inferências pessoais, expectativas do cliente, "
                + "normas relevantes, leis aplicáveis, entre outros. Enquanto a especificação do software diz respeito ao processo de verificação do software, a expectativa do cliente diz respeito ao processo de validação do software. "
                + "Por meio da verificação será analisado se o produto foi feito corretamente, se ele está de acordo com os requisitos especificados. Por meio da "
                + "validação será analisado se foi feito o produto correto, se ele está de acordo com as necessidades e expectativas do cliente.\n\n"
                + "Um desenvolvimento de software organizado tem como premissa uma metodologia de trabalho. Esta deve ter como base conceitos que visem a construção de um produto de software de forma eficaz. Dentro desta metodologia estão "
                + "definidos os passos necessários para chegar ao produto final esperado.\n"
                + "Assim, quando se segue uma metodologia para o desenvolvimento de um produto de software, espera-se um produto final que melhor agrade tanto aos clientes quanto ao próprio fornecedor, ou seja, a empresa de desenvolvimento. "
                + "Observando este aspecto, não faz sentido iniciar a construção de um produto de software sem ter uma metodologia de trabalho bem solidificada e que seja do conhecimento de todos os envolvidos no processo. Porém, além de uma "
                + "crescente demanda por softwares de qualidade, as empresas de desenvolvimento de software sofrem cada vez mais pressão por parte dos clientes para que o produto seja entregue num curto período de tempo. Este fato pode fazer com "
                + "que uma sólida metodologia de trabalho acabe por se desequilibrar.\n"
                + "Independentemente da metodologia de trabalho empregada no desenvolvimento de um software, para que se obtenha um produto final com um certo nível de qualidade é imprescindível a melhoria dos processos de engenharia de software.\n"
                + "Uma maneira viável para se assegurar a melhoria de tais processos seria tomar como base modelos sugeridos por entidades internacionais respeitadas no assunto. Dentro de uma gama de modelos, sejam eles para situações e ambientes "
                + "específicos ou para soluções genéricas, existem alguns que são mais utilizados e tidos como eficientes, como por exemplo os SW-CMM, SE-CMM, ISO/IEC 15504 e o mais conhecido CMMI.\n"
                + "Outro fator com grande influência sobre a qualidade do software a ser produzido é o que diz respeito aos testes que serão executados sobre tal produto. Todas as metodologias de desenvolvimento de software têm uma disciplina dedicada "
                + "aos testes. Atualmente esta é uma tarefa indispensável, porém muitas vezes efetuada de maneira ineficiente, seja pelo subestimar dos que desenvolvem, pela falta de tempo ou mesmo pela falta de recursos humanos e financeiros.\n"
                + "De acordo com um estudo conduzido pelo NIST em 2002, os defeitos resultam num custo anual de 59,5 bilhões de dólares à economia dos Estados Unidos. Mais de um terço do custo poderia ser evitado com melhorias na infraestrutura do teste de software.[3]\n"
                + "Princípios\n"
                + "Para Myers (2004), há princípios vitais para o teste de software. O caso de teste deve definir a saída esperada, de forma a reduzir a interpretação do critério de sucesso. A saída da execução do teste deve ser exaustivamente analisada. "
                + "Os casos de teste devem verificar não somente as condições inválidas de execução, como também as condições válidas. Outro conceito apresentado é utilizar pessoas e organizações diferentes para a implementação e para a verificação. "
                + "A entidade de teste possui uma visão destrutiva do sistema, em busca de erros, enquanto a entidade de programação possui uma visão construtiva, em busca da implementação de uma especificação.\n"
                + "Myers também aborda o esforço para se construir casos de teste. Deve-se evitar testes descartáveis, pois a qualidade do teste piora gradualmente com as iterações de desenvolvimento. Em contrapartida, "
                + "há o teste de regressão, que permite quantificar a evolução da qualidade de software, mantendo e executando novamente testes realizados anteriormente.\n"
                + "O mesmo autor afirma que, diferente do que se poderia considerar senso comum, a probabilidade de existência de erros num certo trecho de código é proporcional à "
                + "quantidade de erros já encontrada anteriormente. Basicamente, erros aparecem em grupos. Trechos específicos de código de um software qualquer estão mais propensos a ter erros que outros.\n"
                + "Técnicas\n"
                + "Existem muitas maneiras de se testar um software. Mesmo assim, existem as técnicas que sempre foram muito utilizadas em sistemas desenvolvidos sobre linguagens estruturadas que ainda hoje têm grande valia para os sistemas orientados a objeto. "
                + "Apesar de os paradigmas de desenvolvimento serem completamente diferentes, o objetivo principal destas técnicas continua a ser o mesmo, encontrar falhas no software. Abaixo estão descritas algumas das técnicas mais conhecidas.\n"
                + "Caixa-branca\n"
                + "Ver artigo principal: teste de caixa-branca\n"
                + "Também chamada de teste estrutural ou orientado à lógica, a técnica de caixa-branca avalia o comportamento interno do componente de software. Essa técnica trabalha diretamente sobre o código fonte do componente de software para "
                + "avaliar aspectos tais como: teste de condição, teste de fluxo de dados, teste de ciclos, teste de caminhos lógicos, códigos nunca executados.\n"
                + "Os aspectos avaliados nesta técnica de teste dependerão da complexidade e da tecnologia que determinarem a construção do componente de software, cabendo portanto avaliação de mais aspectos que os citados anteriormente. O testador tem acesso ao "
                + "código fonte da aplicação e pode construir códigos para efetuar a ligação de bibliotecas e componentes. Este tipo de teste é desenvolvido analisando o código fonte e elaborando casos de teste que cubram todas as possibilidades do componente de software. "
                + "Dessa maneira, todas as variações relevantes originadas por estruturas de condições são testadas.\n"
                + "Um exemplo bem prático desta técnica de teste é o uso da ferramenta livre JUnit para desenvolvimento de classes de teste para testar classes ou métodos desenvolvidos em Java. Também se enquadram nessa técnica testes manuais ou testes efetuados com apoio de "
                + "ferramentas para verificação de aderência a boas práticas de codificação reconhecidas pelo mercado de software. A aderência a padrões e boas práticas visa principalmente a diminuição da possibilidade de erros de codificação e a busca de utilização de comandos "
                + "que gerem o melhor desempenho de execução possível. Apesar de muitos desenvolvedores alegarem que não há ganhos perceptíveis com essa técnica de teste aplicada sobre unidades de software, devemos lembrar que, no ambiente produtivo, cada programa pode vir a ser "
                + "executado milhares ou milhões de vezes em intervalos de tempo pequenos. É na realidade de produção que a soma dos aparentes pequenos tempos de execução e consumo de memória de cada programa poderá levar o software a deixar de atender aos objetivos esperados. "
                + "A técnica de teste de caixa-branca é recomendada para as fases de teste de unidade e teste de integração, cuja responsabilidade principal fica a cargo dos desenvolvedores do software, que por sua vez conhecem bem o código fonte produzido.\n"
                + "Caixa-preta\n"
                + "Ver artigo principal: Teste de caixa-preta\n"
                + "Também chamada de teste funcional, teste comportamental, orientado a dado ou orientado a entrada e saída, a técnica de caixa-preta avalia o comportamento externo do componente de software, sem se considerar o comportamento interno do mesmo.[4] "
                + "Dados de entrada são fornecidos, o teste é executado e o resultado obtido é comparado a um resultado esperado previamente conhecido. Como detalhes de implementação não são considerados, os casos de teste são todos derivados da especificação.\n"
                + "Quanto mais entradas são fornecidas, mais rico será o teste. Numa situação ideal todas as entradas possíveis seriam testadas, mas na ampla maioria dos casos isso é impossível.[5] Outro problema é que a especificação pode estar ambígua em relação "
                + "ao sistema produzido, e como resultado as entradas especificadas podem não ser as mesmas aceitas para o teste.[6] Uma abordagem mais realista para o teste de caixa-preta é escolher um subconjunto de entradas que maximize a riqueza do teste. Pode-se "
                + "agrupar subconjuntos de entradas possíveis que são processadas similarmente, de forma que testar somente um elemento desse subconjunto serve para averiguar a qualidade de todo o subconjunto. Por exemplo, em um sistema que aceita um inteiro como entrada, "
                + "testar todos os casos possíveis pode gerar pelo menos dezenas de milhares de casos de testes distintos. Entretanto, a partir da especificação do sistema, pode-se encontrar um subconjunto de inteiros que maximizem a qualidade do teste. Depende do propósito do "
                + "sistema, mas casos possíveis incluem inteiros pares, inteiros ímpares, zero, inteiros positivos, inteiros negativos, o maior inteiro, o menor inteiro.\n"
                + "Essa técnica é aplicável a todas as fases de teste – teste unitário, teste de integração, teste de sistema e teste de aceitação. A aplicação de critérios de teste leva o testador a produzir um conjunto de casos de teste (ou situações de teste). "
                + "A aplicação do critério de Particionamento de Equivalência (ou uso de classes de equivalência) permite avaliar se a quantidade de casos de teste produzida é coerente. O Particionamento de Equivalência se baseia em testar subconjuntos dos dados e não todos "
                + "os dados possíveis - o que seria exaustivo e às vezes impossível -, pode-se assumir que as classes de equivalência serão tratadas da mesma maneira, pois um único elemento da classe se comporta como um representante dessa classe. A partir das classes de "
                + "equivalência identificadas pode-se usar a Análise de Valor Limite, o testador construirá casos de teste que atuem nos limites superiores e inferiores destas classes, de forma que um número mínimo de casos de teste permita a maior cobertura de teste possível. "
                + "Outro critério é o Grafo Causa-Efeito, que consiste em utilizar a ideia de grafos para transformar entradas de dados em causas e saídas de dados em efeitos. Esse grafo é posteriormente convertido para tabela de decisão e este para casos de teste. Por fim, "
                + "tem-se o critério de Error-Guessing, que é uma técnica em que os analistas de teste, por meio da experiência e intuição, supõem tipos prováveis de erro.\n"
                + "Uma abordagem no desenvolvimento do teste de caixa-preta é o teste baseado na especificação, de forma que as funcionalidades são testadas de acordo com os requisitos. Apesar de necessário, esse tipo de teste é insuficiente para identificar certos riscos num projeto de software.[7]\n"
                + "Caixa-cinza\n"
                + "A técnica de teste de caixa-cinza é uma mescla do uso das técnicas de caixa-preta e de caixa-branca. Isso envolve ter acesso a estruturas de dados e algoritmos do componente a fim de desenvolver os casos de teste, que são executados como na técnica da caixa-preta. "
                + "Manipular entradas de dados e formatar a saída não é considerado caixa-cinza pois a entrada e a saída estão claramente fora da caixa-preta. A caixa-cinza pode incluir também o uso de engenharia reversa para determinar por exemplo os limites superiores e inferiores das classes, além de mensagens de erro.\n"
                + "Regressão\n"
                + "Ver artigo principal: teste de regressão\n"
                + "Essa é uma técnica de teste aplicável a uma nova versão de software ou à necessidade de se executar um novo ciclo de teste durante o processo de desenvolvimento. Consiste em se aplicar, a cada nova versão do software ou a cada ciclo, todos os testes que já foram "
                + "aplicados nas versões ou ciclos de teste anteriores do sistema. Inclui-se nesse contexto a observação de fases e técnicas de teste de acordo com o impacto de alterações provocado pela nova versão ou ciclo de teste. Para efeito de aumento de produtividade e de "
                + "viabilidade dos testes, é recomendada a utilização de ferramentas de automação de teste, de forma que, sobre a nova versão ou ciclo de teste, todos os testes anteriores possam ser executados novamente com maior agilidade.\n"
                + "Técnicas não funcionais\n"
                + "São técnicas utilizadas para verificar a operação correta do sistema em relação a casos inválidos ou inesperados de entrada. Outras técnicas de teste existem para testar aspectos não-funcionais do software, como por exemplo, a adequação a restrições de negócio, "
                + "adequação a normas, ou restrições tecnológicas. Em contraste às técnicas funcionais mencionadas acima, que verificam a produção pelo sistema de respostas adequadas de suas operações, de acordo com uma especificação, as técnicas não funcionais verificam atributos "
                + "de um componente ou sistema que não se relacionam com a funcionalidade (por exemplo, confiabilidade, eficiência, usabilidade, manutenibilidade e portabilidade)[8] .\n"
                + "Uma delas é o uso conjunto de teste de desempenho e teste de carga, que verifica se o software consegue processar grandes quantidades de dados, e nas especificações de tempo de processamento exigidas, o que determina a escalabilidade do software. O teste de usabilidade "
                + "é necessário para verificar se a interface de usuário é fácil de se aprender e utilizar. Entre verificações cabíveis estão a relação da interface com conhecimento do usuário, a compreensibilidade das mensagens de erro e a integridade visual entre diferentes componentes.[9] "
                + "Já o teste de confiabilidade é usado para verificar se o software é seguro em assegurar o sigilo dos dados armazenados e processados. O teste de recuperação é usado para verificar a robustez do software em retornar a um estado estável de execução após estar em um estado de falha.\n"
                + "Fases ou Níveis\n"
                + "Abstração do teste Descendente\n"
                + "Crystal Clear action 1downarrow.png 	Sistema 	Crystal Clear action 1uparrow.png\n"
                + "Ascendente\n"
                + "Integração\n"
                + "Unidade\n"
                + "Uma prática comum é testar o software após uma funcionalidade ser desenvolvida, e antes dela ser implantada no cliente, por um grupo de profissionais diferente da implementação. Essa prática pode resultar na fase de teste ser usada para compensar atrasos do projeto, comprometendo o "
                + "tempo devotado ao teste. Outra prática é começar o teste no mesmo momento que o projeto, num processo contínuo até o fim do projeto.\n"
                + "Em contrapartida, algumas práticas emergentes como a programação extrema e o desenvolvimento ágil focam o modelo de desenvolvimento orientado ao teste. Nesse processo, os testes de unidade são escritos primeiro (TDD), por engenheiros de software. Antes da implementação da unidade em "
                + "questão, o teste falha. Então o código é escrito, passando incrementalmente em porções maiores dos casos de teste. Os testes são mantidos junto com o resto do código fonte do software, e geralmente também integra o processo de construção do software.\n"
                + "Teste de unidade\n"
                + "Ver artigo principal: teste de unidade\n"
                + "Também conhecida como teste unitário ou teste de módulo, é a fase em que se testam as menores unidades de software desenvolvidas (pequenas partes ou unidades do sistema).[10] O universo alvo desse tipo de teste são as subrotinas, métodos, classes ou mesmo pequenos trechos de código. "
                + "Assim, o objetivo é o de encontrar falhas de funcionamento dentro de uma pequena parte do sistema funcionando independentemente do todo.\n"
                + "Teste de integração\n"
                + "Ver artigo principal: teste de integração\n"
                + "Na fase de teste de integração, o objetivo é encontrar falhas provenientes da integração interna dos componentes de um sistema. Geralmente os tipos de falhas encontradas são de transmissão de dados. Por exemplo, um componente A pode estar aguardando o retorno de um valor X ao executar "
                + "um método do componente B; porém, B pode retornar um valor Y, gerando uma falha. O teste de integração conduz ao descobrimento de possíveis falhas associadas à interface do sistema.Não faz parte do escopo dessa fase de teste o tratamento de interfaces com outros sistemas (integração entre sistemas). "
                + "Essas interfaces são testadas na fase de teste de sistema, apesar de, a critério do gerente de projeto, estas interfaces podem ser testadas mesmo antes de o sistema estar plenamente construído.\n"
                + "Teste de sistema\n"
                + "Ver artigo principal: teste de sistema\n"
                + "Na fase de teste de sistema, o objetivo é executar o sistema sob ponto de vista de seu usuário final, varrendo as funcionalidades em busca de falhas em relação aos objetivos originais. Os testes são executados em condições similares – de ambiente, interfaces sistêmicas e massas de dados – "
                + "àquelas que um usuário utilizará no seu dia-a-dia de manipulação do sistema. De acordo com a política de uma organização, podem ser utilizadas condições reais de ambiente, interfaces sistêmicas e massas de dados.\n"
                + "Teste de aceitação\n"
                + "Ver artigo principal: teste de aceitação\n"
                + "Geralmente, os testes de aceitação são realizados por um grupo restrito de usuários finais do sistema, que simulam operações de rotina do sistema de modo a verificar se seu comportamento está de acordo com o solicitado. Teste formal conduzido para determinar se um sistema satisfaz ou não "
                + "seus critérios de aceitação e para permitir ao cliente determinar se aceita ou não o sistema. Validação de um software pelo comprador, pelo usuário ou por terceira parte, com o uso de dados ou cenários especificados ou reais. Pode incluir testes funcionais, de configuração, de recuperação de falhas, de segurança e de desempenho.\n"
                + "Teste de operação\n"
                + "Ver artigo principal: teste de operação\n"
                + "Nessa fase o teste é conduzido pelos administradores do ambiente final em que o sistema ou software entrará em ambiente produtivo. Vale ressaltar que essa fase é aplicável somente a sistemas de informação próprios de uma organização, cujo acesso pode ser feito interna ou externamente a essa organização. "
                + "Nessa fase de teste devem ser feitas simulações para garantir que a entrada em produção do sistema será bem sucedida. Envolve testes de instalação, simulações com cópia de segurança dos bancos de dados, etc.. Em alguns casos um sistema entrará em produção para substituir outro e é necessário garantir que"
                + " o novo sistema continuará garantindo o suporte ao negócio.\n"
                + "Testes alfa e beta\n"
                + "Ver artigo principal: versão alfa\n"
                + "Ver artigo principal: versão beta\n"
                + "Em casos especiais de processos de desenvolvimento de software – sistemas operacionais, sistemas gerenciadores de bancos de dados e outros softwares distribuídos em escala nacional e internacional – os testes requerem fases também especiais antes do produto ser disponibilizado a todos os usuários.\n"
                + "O período entre o término do desenvolvimento e a entrega é conhecido como fase alfa e os testes executados nesse período, como testes alfa. PRESSMAN[11] afirma que o teste alfa é conduzido pelo cliente no ambiente do desenvolvedor, com este \"olhando sobre o ombro\" do usuário e registrando erros e problemas de uso.\n"
                + "Completada a fase alfa de testes, são lançadas a grupos restritos de usuários, versões de teste do sistema denominadas versões beta. Ele também é um teste de aceitação voltado para softwares cuja distribuição atingirá grande número de usuários de uma ou várias empresas compradoras. PRESSMAN afirma que o teste beta é "
                + "conduzido em uma ou mais instalações do cliente, pelo usuário final do software. Diferente do teste alfa, o desenvolvedor geralmente não está presente. Consequentemente, o teste beta é uma aplicação do software num ambiente que não pode ser controlado pelo desenvolvedor. O cliente registra todos os problemas (reais ou imaginários)"
                + " que são encontrados durante o teste beta e os relata ao desenvolvedor em intervalos regulares. Com o resultado dos problemas relatados durante os testes beta, os engenheiros de software fazem modificações e depois se preparam para liberar o produto de software para toda a base de clientes.\n"
                + "A comunidade do teste de software usa o termo teste gama de forma sarcástica referindo-se aos produtos que são mal testados e são entregues aos usuários finais para que estes encontrem os defeitos já em fase de produção.\n"
                + "Candidato a lançamento\n"
                + "Ultimamente, e principalmente na comunidade de software livre, é comum utilizar o termo candidato a lançamento (release candidate) para indicar uma versão que é candidata a ser a versão final, em função da quantidade de erros encontrados. Tais versões são um passo além do teste beta, sendo divulgadas para toda a comunidade.";
        // </editor-fold>
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     */
    @Test
    public void testConstrutorComentarioProjeto() {
        Integer idcomentario = Integer.MIN_VALUE;
        ComentarioProjeto instance = new ComentarioProjeto(idcomentario);
        assertNotNull(instance);
    }

    /**
     */
    @Test
    public void testConstrutorComentarioProjeto2() {
        Integer idcomentario = Integer.MIN_VALUE;
        ComentarioProjeto instance = new ComentarioProjeto(idcomentario,
                textoCanais, textoParticipacaoAcionaria, textoPotencialEmprego,
                textoAplicacoes);
        assertNotNull(instance);
    }

    /**
     * Teste se o texto do comentário é encontrado.
     */
    @Test
    public void testRetornarTextoComentario1() {
        ComentarioProjeto instance = new ComentarioProjeto();
        String expResult = "";
        String result = instance.retornaTextoComentario(Textocomentario.SEGMENTO_CLIENTE);
        assertEquals(expResult, result);
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com o texto
     * preenchido.
     */
    @Test
    public void testRetornarTextoComentario2() {
        ComentarioProjeto instance = new ComentarioProjeto();
        instance.setTextoComentario(Textocomentario.SEGMENTO_CLIENTE, "Texto");
        String expResult = "Texto";
        String result = instance.retornaTextoComentario(Textocomentario.SEGMENTO_CLIENTE);
        assertEquals(expResult, result);
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com a data de
     * alteração preenchida.
     */
    @Test
    public void testRetornarTextoComentario3() {
        ComentarioProjeto instance = new ComentarioProjeto();
        Date date = new Date();
        instance.setTextoComentarioDataAlteracao(Textocomentario.SEGMENTO_CLIENTE, date);
        Date expResult = date;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.SEGMENTO_CLIENTE);
        assertEquals(expResult, result.getDataAlteracao());
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com a data de
     * submissão preenchida.
     */
    @Test
    public void testRetornarTextoComentario4() {
        ComentarioProjeto instance = new ComentarioProjeto();
        Date date = new Date();
        instance.setTextoComentarioDataSubmissao(Textocomentario.SEGMENTO_CLIENTE, date);
        Date expResult = date;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.SEGMENTO_CLIENTE);
        assertEquals(expResult, result.getDataSubmissao());
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com a o gerente
     * preenchido
     */
    @Test
    public void testRetornarTextoComentario5() {
        ComentarioProjeto instance = new ComentarioProjeto();
        GerenteRelacionamento gerente = new GerenteRelacionamento();
        gerente.setIdgerente_relacionamento(2);
        instance.setTextoComentario(Textocomentario.SEGMENTO_CLIENTE, gerente);
        GerenteRelacionamento expResult = gerente;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.SEGMENTO_CLIENTE);
        assertEquals(expResult, result.getGerenteRelacionamento());
    }

    /**
     * Teste se o texto do comentário é encontrado.
     */
    @Test
    public void testRetornarTextoComentario6() {
        ComentarioProjeto instance = new ComentarioProjeto();
        Textocomentario textocomentario = instance.retornarTextoComentario(Textocomentario.SEGMENTO_CLIENTE);
        textocomentario.setTexto(null);
        String expResult = null;
        String result = instance.retornaTextoComentario(Textocomentario.SEGMENTO_CLIENTE);
        assertEquals(expResult, result);
    }

    /**
     * <p>
     * Teste para o texto extenso
     * </p>
     */
    public void testRetornarTextoComentario7() {
        ComentarioProjeto instance = new ComentarioProjeto();
        Textocomentario textocomentario = instance.retornarTextoComentario(Textocomentario.SEGMENTO_CLIENTE);
        textocomentario.setTexto(testeTextoGigante);
        String expResult = testeTextoGigante;
        String result = instance.retornaTextoComentario(Textocomentario.SEGMENTO_CLIENTE);
        assertEquals(expResult, result);
    }

    /**
     * teste se o texto do comentario Proposta valor é encontrado.
     */
    public void testRetornarTextoComentarioPropostaValor() {
        ComentarioProjeto instance = new ComentarioProjeto();
        String expResult = "";
        String result = instance.retornaTextoComentario(Textocomentario.PROPOSTA_VALOR);
        assertEquals(expResult, result);
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com o texto
     * preechido.
     */
    @Test
    public void testRetornarTextoComentarioPropostaValor2() {
        ComentarioProjeto instance = new ComentarioProjeto();
        instance.setTextoComentario(Textocomentario.PROPOSTA_VALOR, "Texto");
        String expResult = "Texto";
        String result = instance.retornaTextoComentario(Textocomentario.PROPOSTA_VALOR);
        assertEquals(expResult, result);
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com a data de
     * alteração preenchida.
     */
    @Test
    public void testRetornarTextoComentarioPropostavalor3() {
        ComentarioProjeto instance = new ComentarioProjeto();
        Date date = new Date();
        instance.setTextoComentarioDataAlteracao(Textocomentario.PROPOSTA_VALOR, date);
        Date expResult = date;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.PROPOSTA_VALOR);
        assertEquals(expResult, result.getDataAlteracao());
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com a data de
     * submissão preenchida.
     */
    @Test
    public void testRetornarTextoComentarioPropostaValor4() {
        ComentarioProjeto instance = new ComentarioProjeto();
        Date date = new Date();
        instance.setTextoComentarioDataSubmissao(Textocomentario.PROPOSTA_VALOR, date);
        Date expResult = date;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.PROPOSTA_VALOR);
        assertEquals(expResult, result.getDataSubmissao());
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com a o gerente
     * preenchido
     */
    @Test
    public void testRetornarTextoComentarioPropostavalor5() {
        ComentarioProjeto instance = new ComentarioProjeto();
        GerenteRelacionamento gerente = new GerenteRelacionamento();
        gerente.setIdgerente_relacionamento(2);
        instance.setTextoComentario(Textocomentario.PROPOSTA_VALOR, gerente);
        GerenteRelacionamento expResult = gerente;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.PROPOSTA_VALOR);
        assertEquals(expResult, result.getGerenteRelacionamento());
    }

    /**
     * Teste se o texto do comentário é encontrado.
     */
    @Test
    public void testRetornarTextoComentarioPropostavalor6() {
        ComentarioProjeto instance = new ComentarioProjeto();
        Textocomentario textocomentario = instance.retornarTextoComentario(Textocomentario.PROPOSTA_VALOR);
        textocomentario.setTexto(null);
        String expResult = null;
        String result = instance.retornaTextoComentario(Textocomentario.PROPOSTA_VALOR);
        assertEquals(expResult, result);
    }

    /**
     * <p>
     * Teste para o texto extenso
     * </p>
     */
    public void testRetornarTextoComentarioPropostavalor7() {
        ComentarioProjeto instance = new ComentarioProjeto();
        Textocomentario textocomentario = instance.retornarTextoComentario(Textocomentario.PROPOSTA_VALOR);
        textocomentario.setTexto(testeTextoGigante);
        String expResult = testeTextoGigante;
        String result = instance.retornaTextoComentario(Textocomentario.PROPOSTA_VALOR);
        assertEquals(expResult, result);
    }

    public void testRetornarTextoComentarioAtividadesChave1() {
        ComentarioProjeto instance = new ComentarioProjeto();
        String expResult = "";
        String result = instance.retornaTextoComentario(Textocomentario.ATIVIDADES_CHAVE);
        assertEquals(expResult, result);
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com o texto
     * preechido.
     */
    @Test
    public void testRetornarTextoComentarioAtividadesChave2() {
        ComentarioProjeto instance = new ComentarioProjeto();
        instance.setTextoComentario(Textocomentario.ATIVIDADES_CHAVE, "Texto");
        String expResult = "Texto";
        String result = instance.retornaTextoComentario(Textocomentario.ATIVIDADES_CHAVE);
        assertEquals(expResult, result);
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com a data de
     * alteração preenchida.
     */
    @Test
    public void testRetornarTextoComentarioAtividadesChave3() {
        ComentarioProjeto instance = new ComentarioProjeto();
        Date date = new Date();
        instance.setTextoComentarioDataAlteracao(Textocomentario.ATIVIDADES_CHAVE, date);
        Date expResult = date;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.ATIVIDADES_CHAVE);
        assertEquals(expResult, result.getDataAlteracao());
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com a data de
     * submissão preenchida.
     */
    @Test
    public void testRetornarTextoComentarioAtividadesChave4() {
        ComentarioProjeto instance = new ComentarioProjeto();
        Date date = new Date();
        instance.setTextoComentarioDataSubmissao(Textocomentario.ATIVIDADES_CHAVE, date);
        Date expResult = date;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.ATIVIDADES_CHAVE);
        assertEquals(expResult, result.getDataSubmissao());
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com a o gerente
     * preenchido
     */
    @Test
    public void testRetornarTextoComentarioAtividadesChave5() {
        ComentarioProjeto instance = new ComentarioProjeto();
        GerenteRelacionamento gerente = new GerenteRelacionamento();
        gerente.setIdgerente_relacionamento(2);
        instance.setTextoComentario(Textocomentario.ATIVIDADES_CHAVE, gerente);
        GerenteRelacionamento expResult = gerente;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.ATIVIDADES_CHAVE);
        assertEquals(expResult, result.getGerenteRelacionamento());
    }

    /**
     * Teste se o texto do comentário é encontrado.
     */
    @Test
    public void testRetornarTextoComentarioAtividadesChave6() {
        ComentarioProjeto instance = new ComentarioProjeto();
        Textocomentario textocomentario = instance.retornarTextoComentario(Textocomentario.ATIVIDADES_CHAVE);
        textocomentario.setTexto(null);
        String expResult = null;
        String result = instance.retornaTextoComentario(Textocomentario.ATIVIDADES_CHAVE);
        assertEquals(expResult, result);
    }

    /**
     * <p>
     * Teste para o texto extenso
     * </p>
     */
    public void testRetornarTextoAtividadesChave7() {
        ComentarioProjeto instance = new ComentarioProjeto();
        Textocomentario textocomentario = instance.retornarTextoComentario(Textocomentario.ATIVIDADES_CHAVE);
        textocomentario.setTexto(testeTextoGigante);
        String expResult = testeTextoGigante;
        String result = instance.retornaTextoComentario(Textocomentario.ATIVIDADES_CHAVE);
        assertEquals(expResult, result);
    }

    public void testRetornarTextoComentarioRelacaoCliente1() {
        ComentarioProjeto instance = new ComentarioProjeto();
        String expResult = "";
        String result = instance.retornaTextoComentario(Textocomentario.RELACOES_CLIENTE);
        assertEquals(expResult, result);
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com o texto
     * preechido.
     */
    @Test
    public void testRetornarTextoComentarioRelacaoCliente2() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        instance.setTextoComentario(Textocomentario.RELACOES_CLIENTE, "Texto");
        String expResult = "Texto";
        String result = instance.retornaTextoComentario(Textocomentario.RELACOES_CLIENTE);
        assertEquals(expResult, result);
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com a data de
     * alteração preenchida.
     */
    @Test
    public void testRetornarTextoComentarioRelacaoCliente3() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Date date = new Date();
        instance.setTextoComentarioDataAlteracao(Textocomentario.RELACOES_CLIENTE, date);
        Date expResult = date;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.RELACOES_CLIENTE);
        assertEquals(expResult, result.getDataAlteracao());
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com a data de
     * submissão preenchida.
     */
    @Test
    public void testRetornarTextoComentarioRelacaoCliente4() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Date date = new Date();
        instance.setTextoComentarioDataSubmissao(Textocomentario.RELACOES_CLIENTE, date);
        Date expResult = date;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.RELACOES_CLIENTE);
        assertEquals(expResult, result.getDataSubmissao());
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com a o gerente
     * preenchido
     */
    @Test
    public void testRetornarTextoComentarioRelacaoCliente5() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        GerenteRelacionamento gerente = new GerenteRelacionamento();
        gerente.setIdgerente_relacionamento(2);
        instance.setTextoComentario(Textocomentario.RELACOES_CLIENTE, gerente);
        GerenteRelacionamento expResult = gerente;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.RELACOES_CLIENTE);
        assertEquals(expResult, result.getGerenteRelacionamento());
    }

    /**
     * Teste se o texto do comentário é encontrado.
     */
    @Test
    public void testRetornarTextoComentarioRelacaoCliente6() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Textocomentario textocomentario = instance.retornarTextoComentario(Textocomentario.RELACOES_CLIENTE);
        textocomentario.setTexto(null);
        String expResult = null;
        String result = instance.retornaTextoComentario(Textocomentario.RELACOES_CLIENTE);
        assertEquals(expResult, result);
    }

    /**
     * <p>
     * Teste para o texto extenso
     * </p>
     */
    public void testRetornarTextoRelacaoCliente7() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Textocomentario textocomentario = instance.retornarTextoComentario(Textocomentario.RELACOES_CLIENTE);
        textocomentario.setTexto(testeTextoGigante);
        String expResult = testeTextoGigante;
        String result = instance.retornaTextoComentario(Textocomentario.RELACOES_CLIENTE);
        assertEquals(expResult, result);
    }

    public void testRetornarTextoComentarioParceriasChave1() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        String expResult = "";
        String result = instance.retornaTextoComentario(Textocomentario.PARCERIAS_CHAVE);
        assertEquals(expResult, result);
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com o texto
     * preechido.
     */
    @Test
    public void testRetornarTextoComentarioParceriasChave2() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        instance.setTextoComentario(Textocomentario.PARCERIAS_CHAVE, "Texto");
        String expResult = "Texto";
        String result = instance.retornaTextoComentario(Textocomentario.PARCERIAS_CHAVE);
        assertEquals(expResult, result);
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com a data de
     * alteração preenchida.
     */
    @Test
    public void testRetornarTextoComentarioParceriasChave3() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Date date = new Date();
        instance.setTextoComentarioDataAlteracao(Textocomentario.PARCERIAS_CHAVE, date);
        Date expResult = date;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.PARCERIAS_CHAVE);
        assertEquals(expResult, result.getDataAlteracao());
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com a data de
     * submissão preenchida.
     */
    @Test
    public void testRetornarTextoComentarioParceriasChave4() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Date date = new Date();
        instance.setTextoComentarioDataSubmissao(Textocomentario.PARCERIAS_CHAVE, date);
        Date expResult = date;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.PARCERIAS_CHAVE);
        assertEquals(expResult, result.getDataSubmissao());
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com a o gerente
     * preenchido
     */
    @Test
    public void testRetornarTextoComentarioParceiasChave5() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        GerenteRelacionamento gerente = new GerenteRelacionamento();
        gerente.setIdgerente_relacionamento(2);
        instance.setTextoComentario(Textocomentario.PARCERIAS_CHAVE, gerente);
        GerenteRelacionamento expResult = gerente;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.PARCERIAS_CHAVE);
        assertEquals(expResult, result.getGerenteRelacionamento());
    }

    /**
     * Teste se o texto do comentário é encontrado.
     */
    @Test
    public void testRetornarTextoComentarioParceriasChave6() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Textocomentario textocomentario = instance.retornarTextoComentario(Textocomentario.PARCERIAS_CHAVE);
        textocomentario.setTexto(null);
        String expResult = null;
        String result = instance.retornaTextoComentario(Textocomentario.PARCERIAS_CHAVE);
        assertEquals(expResult, result);
    }

    /**
     * <p>
     * Teste para o texto extenso
     * </p>
     */
    public void testRetornarTextoComentarioParceriasChave7() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Textocomentario textocomentario = instance.retornarTextoComentario(Textocomentario.PARCERIAS_CHAVE);
        textocomentario.setTexto(testeTextoGigante);
        String expResult = testeTextoGigante;
        String result = instance.retornaTextoComentario(Textocomentario.PARCERIAS_CHAVE);
        assertEquals(expResult, result);
    }

    /**
     * <p>
     * teste que verifica um campo vazio
     * </p>
     */
    public void testRetornarTextoComentarioCanais1() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        String expResult = "";
        String result = instance.retornaTextoComentario(Textocomentario.CANAIS);
        assertEquals(expResult, result);
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com o texto
     * preechido.
     */
    @Test
    public void testRetornarTextoComentarioCanais2() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        instance.setTextoComentario(Textocomentario.CANAIS, "Texto");
        String expResult = "Texto";
        String result = instance.retornaTextoComentario(Textocomentario.CANAIS);
        assertEquals(expResult, result);
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com a data de
     * alteração preenchida.
     */
    @Test
    public void testRetornarTextoComentarioCanais3() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Date date = new Date();
        instance.setTextoComentarioDataAlteracao(Textocomentario.CANAIS, date);
        Date expResult = date;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.CANAIS);
        assertEquals(expResult, result.getDataAlteracao());
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com a data de
     * submissão preenchida.
     */
    @Test
    public void testRetornarTextoComentarioCanais4() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Date date = new Date();
        instance.setTextoComentarioDataSubmissao(Textocomentario.CANAIS, date);
        Date expResult = date;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.CANAIS);
        assertEquals(expResult, result.getDataSubmissao());
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com a o gerente
     * preenchido
     */
    @Test
    public void testRetornarTextoComentarioCanais5() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        GerenteRelacionamento gerente = new GerenteRelacionamento();
        gerente.setIdgerente_relacionamento(2);
        instance.setTextoComentario(Textocomentario.CANAIS, gerente);
        GerenteRelacionamento expResult = gerente;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.CANAIS);
        assertEquals(expResult, result.getGerenteRelacionamento());
    }

    /**
     * Teste se o texto do comentário é encontrado.
     */
    @Test
    public void testRetornarTextoComentarioCanais6() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Textocomentario textocomentario = instance.retornarTextoComentario(Textocomentario.CANAIS);
        textocomentario.setTexto(null);
        String expResult = null;
        String result = instance.retornaTextoComentario(Textocomentario.CANAIS);
        assertEquals(expResult, result);
    }

    /**
     * <p>
     * Teste para o texto extenso
     * </p>
     */
    public void testRetornarTextoComentarioCanais7() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Textocomentario textocomentario = instance.retornarTextoComentario(Textocomentario.SEGMENTO_CLIENTE);
        textocomentario.setTexto(testeTextoGigante);
        String expResult = testeTextoGigante;
        String result = instance.retornaTextoComentario(Textocomentario.SEGMENTO_CLIENTE);
        assertEquals(expResult, result);
    }

    /**
     * <p>
     * teste que verifica um campo vazio
     * </p>
     */
    public void testRetornarTextoComentarioRecursosPrincipais1() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        String expResult = "";
        String result = instance.retornaTextoComentario(Textocomentario.RECURSOS_PRINCIPAIS);
        assertEquals(expResult, result);
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com o texto
     * preechido.
     */
    @Test
    public void testRetornarTextoComentarioRecursosPrincipais2() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        instance.setTextoComentario(Textocomentario.RECURSOS_PRINCIPAIS, "Texto");
        String expResult = "Texto";
        String result = instance.retornaTextoComentario(Textocomentario.RECURSOS_PRINCIPAIS);
        assertEquals(expResult, result);
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com a data de
     * alteração preenchida.
     */
    @Test
    public void testRetornarTextoComentarioRecursosPrincipais3() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Date date = new Date();
        instance.setTextoComentarioDataAlteracao(Textocomentario.RECURSOS_PRINCIPAIS, date);
        Date expResult = date;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.RECURSOS_PRINCIPAIS);
        assertEquals(expResult, result.getDataAlteracao());
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com a data de
     * submissão preenchida.
     */
    @Test
    public void testRetornarTextoComentarioRecursosPrincipais4() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Date date = new Date();
        instance.setTextoComentarioDataSubmissao(Textocomentario.RECURSOS_PRINCIPAIS, date);
        Date expResult = date;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.RECURSOS_PRINCIPAIS);
        assertEquals(expResult, result.getDataSubmissao());
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com a o gerente
     * preenchido
     */
    @Test
    public void testRetornarTextoComentarioRecursosPrincipais5() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        GerenteRelacionamento gerente = new GerenteRelacionamento();
        gerente.setIdgerente_relacionamento(2);
        instance.setTextoComentario(Textocomentario.RECURSOS_PRINCIPAIS, gerente);
        GerenteRelacionamento expResult = gerente;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.RECURSOS_PRINCIPAIS);
        assertEquals(expResult, result.getGerenteRelacionamento());
    }

    /**
     * Teste se o texto do comentário é encontrado.
     */
    @Test
    public void testRetornarTextoComentarioRecursosPrincipais6() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Textocomentario textocomentario = instance.retornarTextoComentario(Textocomentario.RECURSOS_PRINCIPAIS);
        textocomentario.setTexto(null);
        String expResult = null;
        String result = instance.retornaTextoComentario(Textocomentario.RECURSOS_PRINCIPAIS);
        assertEquals(expResult, result);
    }

    /**
     * <p>
     * Teste para o texto extenso
     * </p>
     */
    public void testRetornarTextoComentarioRecusosPrincipais7() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Textocomentario textocomentario = instance.retornarTextoComentario(Textocomentario.RECURSOS_PRINCIPAIS);
        textocomentario.setTexto(testeTextoGigante);
        String expResult = testeTextoGigante;
        String result = instance.retornaTextoComentario(Textocomentario.RECURSOS_PRINCIPAIS);
        assertEquals(expResult, result);
    }

    /**
     * <p>
     * teste que verifica um campo vazio
     * </p>
     */
    public void testRetornarTextoComentarioConcorrentes1() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        String expResult = "";
        String result = instance.retornaTextoComentario(Textocomentario.CONCORRENTES);
        assertEquals(expResult, result);
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com o texto
     * preechido.
     */
    @Test
    public void testRetornarTextoComentarioConcorrentes2() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        instance.setTextoComentario(Textocomentario.CONCORRENTES, "Texto");
        String expResult = "Texto";
        String result = instance.retornaTextoComentario(Textocomentario.CONCORRENTES);
        assertEquals(expResult, result);
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com a data de
     * alteração preenchida.
     */
    @Test
    public void testRetornarTextoComentarioConcorrentes3() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Date date = new Date();
        instance.setTextoComentarioDataAlteracao(Textocomentario.CONCORRENTES, date);
        Date expResult = date;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.CONCORRENTES);
        assertEquals(expResult, result.getDataAlteracao());
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com a data de
     * submissão preenchida.
     */
    @Test
    public void testRetornarTextoComentarioConcorrentes4() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Date date = new Date();
        instance.setTextoComentarioDataSubmissao(Textocomentario.CONCORRENTES, date);
        Date expResult = date;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.CONCORRENTES);
        assertEquals(expResult, result.getDataSubmissao());
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com a o gerente
     * preenchido
     */
    @Test
    public void testRetornarTextoComentarioConcorrentes5() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        GerenteRelacionamento gerente = new GerenteRelacionamento();
        gerente.setIdgerente_relacionamento(2);
        instance.setTextoComentario(Textocomentario.CONCORRENTES, gerente);
        GerenteRelacionamento expResult = gerente;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.CONCORRENTES);
        assertEquals(expResult, result.getGerenteRelacionamento());
    }

    /**
     * Teste se o texto do comentário é encontrado.
     */
    @Test
    public void testRetornarTextoComentarioConcorrentes6() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Textocomentario textocomentario = instance.retornarTextoComentario(Textocomentario.CONCORRENTES);
        textocomentario.setTexto(null);
        String expResult = null;
        String result = instance.retornaTextoComentario(Textocomentario.CONCORRENTES);
        assertEquals(expResult, result);
    }

    /**
     * <p>
     * Teste para o texto extenso
     * </p>
     */
    public void testRetornarTextoComentarioConcorrentes7() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Textocomentario textocomentario = instance.retornarTextoComentario(Textocomentario.CONCORRENTES);
        textocomentario.setTexto(testeTextoGigante);
        String expResult = testeTextoGigante;
        String result = instance.retornaTextoComentario(Textocomentario.CONCORRENTES);
        assertEquals(expResult, result);
    }

    /**
     * <p>
     * teste que verifica um campo vazio
     * </p>
     */
    public void testRetornarTextoComentarioEstagioEvolucao1() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        String expResult = "";
        String result = instance.retornaTextoComentario(Textocomentario.ESTAGIO_EVOLUCAO);
        assertEquals(expResult, result);
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com o texto
     * preechido.
     */
    @Test
    public void testRetornarTextoComentarioEstagioEvolucao2() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        instance.setTextoComentario(Textocomentario.ESTAGIO_EVOLUCAO, "Texto");
        String expResult = "Texto";
        String result = instance.retornaTextoComentario(Textocomentario.ESTAGIO_EVOLUCAO);
        assertEquals(expResult, result);
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com a data de
     * alteração preenchida.
     */
    @Test
    public void testRetornarTextoComentarioEstagioEvolucao3() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Date date = new Date();
        instance.setTextoComentarioDataAlteracao(Textocomentario.ESTAGIO_EVOLUCAO, date);
        Date expResult = date;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.ESTAGIO_EVOLUCAO);
        assertEquals(expResult, result.getDataAlteracao());
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com a data de
     * submissão preenchida.
     */
    @Test
    public void testRetornarTextoComentarioEstagioEvolucao4() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Date date = new Date();
        instance.setTextoComentarioDataSubmissao(Textocomentario.ESTAGIO_EVOLUCAO, date);
        Date expResult = date;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.ESTAGIO_EVOLUCAO);
        assertEquals(expResult, result.getDataSubmissao());
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com a o gerente
     * preenchido
     */
    @Test
    public void testRetornarTextoComentarioEstagioEvolucao5() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        GerenteRelacionamento gerente = new GerenteRelacionamento();
        gerente.setIdgerente_relacionamento(2);
        instance.setTextoComentario(Textocomentario.ESTAGIO_EVOLUCAO, gerente);
        GerenteRelacionamento expResult = gerente;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.ESTAGIO_EVOLUCAO);
        assertEquals(expResult, result.getGerenteRelacionamento());
    }

    /**
     * Teste se o texto do comentário é encontrado.
     */
    @Test
    public void testRetornarTextoComentarioEstagioEvolucao6() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Textocomentario textocomentario = instance.retornarTextoComentario(Textocomentario.ESTAGIO_EVOLUCAO);
        textocomentario.setTexto(null);
        String expResult = null;
        String result = instance.retornaTextoComentario(Textocomentario.ESTAGIO_EVOLUCAO);
        assertEquals(expResult, result);
    }

    /**
     * <p>
     * Teste para o texto extenso
     * </p>
     */
    public void testRetornarTextoComentarioEstagioEvolucao7() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Textocomentario textocomentario = instance.retornarTextoComentario(Textocomentario.ESTAGIO_EVOLUCAO);
        textocomentario.setTexto(testeTextoGigante);
        String expResult = testeTextoGigante;
        String result = instance.retornaTextoComentario(Textocomentario.ESTAGIO_EVOLUCAO);
        assertEquals(expResult, result);
    }

    /**
     * <p>
     * teste que verifica um campo vazio
     * </p>
     */
    public void testRetornarTextoComentarioTecnologiaProcessos1() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        String expResult = "";
        String result = instance.retornaTextoComentario(Textocomentario.TECNOLOGIA_PROCESSOS);
        assertEquals(expResult, result);
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com o texto
     * preechido.
     */
    @Test
    public void testRetornarTextoComentarioTecnologiaProcessos2() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        instance.setTextoComentario(Textocomentario.TECNOLOGIA_PROCESSOS, "Texto");
        String expResult = "Texto";
        String result = instance.retornaTextoComentario(Textocomentario.TECNOLOGIA_PROCESSOS);
        assertEquals(expResult, result);
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com a data de
     * alteração preenchida.
     */
    @Test
    public void testRetornarTextoComentarioTecnologiaProcessos3() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Date date = new Date();
        instance.setTextoComentarioDataAlteracao(Textocomentario.TECNOLOGIA_PROCESSOS, date);
        Date expResult = date;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.TECNOLOGIA_PROCESSOS);
        assertEquals(expResult, result.getDataAlteracao());
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com a data de
     * submissão preenchida.
     */
    @Test
    public void testRetornarTextoComentarioTecnologiaProcessos4() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Date date = new Date();
        instance.setTextoComentarioDataSubmissao(Textocomentario.TECNOLOGIA_PROCESSOS, date);
        Date expResult = date;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.TECNOLOGIA_PROCESSOS);
        assertEquals(expResult, result.getDataSubmissao());
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com a o gerente
     * preenchido
     */
    @Test
    public void testRetornarTextoComentarioTecnologiaProcessos5() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        GerenteRelacionamento gerente = new GerenteRelacionamento();
        gerente.setIdgerente_relacionamento(2);
        instance.setTextoComentario(Textocomentario.TECNOLOGIA_PROCESSOS, gerente);
        GerenteRelacionamento expResult = gerente;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.TECNOLOGIA_PROCESSOS);
        assertEquals(expResult, result.getGerenteRelacionamento());
    }

    /**
     * Teste se o texto do comentário é encontrado.
     */
    @Test
    public void testRetornarTextoComentarioTecnologiaProcessos6() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Textocomentario textocomentario = instance.retornarTextoComentario(Textocomentario.TECNOLOGIA_PROCESSOS);
        textocomentario.setTexto(null);
        String expResult = null;
        String result = instance.retornaTextoComentario(Textocomentario.TECNOLOGIA_PROCESSOS);
        assertEquals(expResult, result);
    }

    /**
     * <p>
     * Teste para o texto extenso
     * </p>
     */
    public void testRetornarTextoComentarioTecnologiaProcessos7() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Textocomentario textocomentario = instance.retornarTextoComentario(Textocomentario.TECNOLOGIA_PROCESSOS);
        textocomentario.setTexto(testeTextoGigante);
        String expResult = testeTextoGigante;
        String result = instance.retornaTextoComentario(Textocomentario.TECNOLOGIA_PROCESSOS);
        assertEquals(expResult, result);
    }

    /**
     * <p>
     * teste que verifica um campo vazio
     * </p>
     */
    public void testRetornarTextoComentarioPotencialInovacao1() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        String expResult = "";
        String result = instance.retornaTextoComentario(Textocomentario.POTENCIAL_INOVACAO_TECNOLOGICA);
        assertEquals(expResult, result);
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com o texto
     * preechido.
     */
    @Test
    public void testRetornarTextoComentarioPotencialInovacao2() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        instance.setTextoComentario(Textocomentario.POTENCIAL_INOVACAO_TECNOLOGICA, "Texto");
        String expResult = "Texto";
        String result = instance.retornaTextoComentario(Textocomentario.POTENCIAL_INOVACAO_TECNOLOGICA);
        assertEquals(expResult, result);
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com a data de
     * alteração preenchida.
     */
    @Test
    public void testRetornarTextoComentarioPotencialInovacao3() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Date date = new Date();
        instance.setTextoComentarioDataAlteracao(Textocomentario.POTENCIAL_INOVACAO_TECNOLOGICA, date);
        Date expResult = date;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.POTENCIAL_INOVACAO_TECNOLOGICA);
        assertEquals(expResult, result.getDataAlteracao());
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com a data de
     * submissão preenchida.
     */
    @Test
    public void testRetornarTextoComentarioPotencialInovacao4() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Date date = new Date();
        instance.setTextoComentarioDataSubmissao(Textocomentario.POTENCIAL_INOVACAO_TECNOLOGICA, date);
        Date expResult = date;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.POTENCIAL_INOVACAO_TECNOLOGICA);
        assertEquals(expResult, result.getDataSubmissao());
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com a o gerente
     * preenchido
     */
    @Test
    public void testRetornarTextoComentarioPotencialInovacao5() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        GerenteRelacionamento gerente = new GerenteRelacionamento();
        gerente.setIdgerente_relacionamento(2);
        instance.setTextoComentario(Textocomentario.POTENCIAL_INOVACAO_TECNOLOGICA, gerente);
        GerenteRelacionamento expResult = gerente;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.POTENCIAL_INOVACAO_TECNOLOGICA);
        assertEquals(expResult, result.getGerenteRelacionamento());
    }

    /**
     * Teste se o texto do comentário é encontrado.
     */
    @Test
    public void testRetornarTextoComentarioPotencialInovacao6() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Textocomentario textocomentario = instance.retornarTextoComentario(Textocomentario.POTENCIAL_INOVACAO_TECNOLOGICA);
        textocomentario.setTexto(null);
        String expResult = null;
        String result = instance.retornaTextoComentario(Textocomentario.POTENCIAL_INOVACAO_TECNOLOGICA);
        assertEquals(expResult, result);
    }

    /**
     * <p>
     * Teste para o texto extenso
     * </p>
     */
    public void testRetornarTextoComentarioPotencialInovacao7() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Textocomentario textocomentario = instance.retornarTextoComentario(Textocomentario.POTENCIAL_INOVACAO_TECNOLOGICA);
        textocomentario.setTexto(testeTextoGigante);
        String expResult = testeTextoGigante;
        String result = instance.retornaTextoComentario(Textocomentario.POTENCIAL_INOVACAO_TECNOLOGICA);
        assertEquals(expResult, result);
    }

    /**
     * <p>
     * teste que verifica um campo vazio
     * </p>
     */
    public void testRetornarTextoComentarioAplicacoes1() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        String expResult = "";
        String result = instance.retornaTextoComentario(Textocomentario.APLICACOES);
        assertEquals(expResult, result);
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com o texto
     * preechido.
     */
    @Test
    public void testRetornarTextoComentarioAplicacoes2() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        instance.setTextoComentario(Textocomentario.APLICACOES, "Texto");
        String expResult = "Texto";
        String result = instance.retornaTextoComentario(Textocomentario.APLICACOES);
        assertEquals(expResult, result);
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com a data de
     * alteração preenchida.
     */
    @Test
    public void testRetornarTextoComentarioAplicacoes3() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Date date = new Date();
        instance.setTextoComentarioDataAlteracao(Textocomentario.APLICACOES, date);
        Date expResult = date;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.APLICACOES);
        assertEquals(expResult, result.getDataAlteracao());
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com a data de
     * submissão preenchida.
     */
    @Test
    public void testRetornarTextoComentarioAplicacoes4() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Date date = new Date();
        instance.setTextoComentarioDataSubmissao(Textocomentario.APLICACOES, date);
        Date expResult = date;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.APLICACOES);
        assertEquals(expResult, result.getDataSubmissao());
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com a o gerente
     * preenchido
     */
    @Test
    public void testRetornarTextoComentarioAplicacoes5() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        GerenteRelacionamento gerente = new GerenteRelacionamento();
        gerente.setIdgerente_relacionamento(2);
        instance.setTextoComentario(Textocomentario.APLICACOES, gerente);
        GerenteRelacionamento expResult = gerente;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.APLICACOES);
        assertEquals(expResult, result.getGerenteRelacionamento());
    }

    /**
     * Teste se o texto do comentário é encontrado.
     */
    @Test
    public void testRetornarTextoComentarioAplicacoes6() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Textocomentario textocomentario = instance.retornarTextoComentario(Textocomentario.APLICACOES);
        textocomentario.setTexto(null);
        String expResult = null;
        String result = instance.retornaTextoComentario(Textocomentario.APLICACOES);
        assertEquals(expResult, result);
    }

    /**
     * <p>
     * Teste para o texto extenso
     * </p>
     */
    public void testRetornarTextoComentarioAplicacoes7() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Textocomentario textocomentario = instance.retornarTextoComentario(Textocomentario.APLICACOES);
        textocomentario.setTexto(testeTextoGigante);
        String expResult = testeTextoGigante;
        String result = instance.retornaTextoComentario(Textocomentario.APLICACOES);
        assertEquals(expResult, result);
    }

    /**
     * <p>
     * teste que verifica um campo vazio
     * </p>
     */
    public void testRetornarTextoComentarioDificuldades1() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        String expResult = "";
        String result = instance.retornaTextoComentario(Textocomentario.DIFICULDADES_ESPERADAS);
        assertEquals(expResult, result);
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com o texto
     * preechido.
     */
    @Test
    public void testRetornarTextoComentarioDificuldades2() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        instance.setTextoComentario(Textocomentario.DIFICULDADES_ESPERADAS, "Texto");
        String expResult = "Texto";
        String result = instance.retornaTextoComentario(Textocomentario.DIFICULDADES_ESPERADAS);
        assertEquals(expResult, result);
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com a data de
     * alteração preenchida.
     */
    @Test
    public void testRetornarTextoComentarioDificuldades3() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Date date = new Date();
        instance.setTextoComentarioDataAlteracao(Textocomentario.DIFICULDADES_ESPERADAS, date);
        Date expResult = date;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.DIFICULDADES_ESPERADAS);
        assertEquals(expResult, result.getDataAlteracao());
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com a data de
     * submissão preenchida.
     */
    @Test
    public void testRetornarTextoComentarioDificuldades4() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Date date = new Date();
        instance.setTextoComentarioDataSubmissao(Textocomentario.DIFICULDADES_ESPERADAS, date);
        Date expResult = date;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.DIFICULDADES_ESPERADAS);
        assertEquals(expResult, result.getDataSubmissao());
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com a o gerente
     * preenchido
     */
    @Test
    public void testRetornarTextoComentarioDificuldades5() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        GerenteRelacionamento gerente = new GerenteRelacionamento();
        gerente.setIdgerente_relacionamento(2);
        instance.setTextoComentario(Textocomentario.DIFICULDADES_ESPERADAS, gerente);
        GerenteRelacionamento expResult = gerente;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.DIFICULDADES_ESPERADAS);
        assertEquals(expResult, result.getGerenteRelacionamento());
    }

    /**
     * Teste se o texto do comentário é encontrado.
     */
    @Test
    public void testRetornarTextoComentarioDificuldades6() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Textocomentario textocomentario = instance.retornarTextoComentario(Textocomentario.DIFICULDADES_ESPERADAS);
        textocomentario.setTexto(null);
        String expResult = null;
        String result = instance.retornaTextoComentario(Textocomentario.DIFICULDADES_ESPERADAS);
        assertEquals(expResult, result);
    }

    /**
     * <p>
     * Teste para o texto extenso
     * </p>
     */
    public void testRetornarTextoComentarioDificuldades7() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Textocomentario textocomentario = instance.retornarTextoComentario(Textocomentario.DIFICULDADES_ESPERADAS);
        textocomentario.setTexto(testeTextoGigante);
        String expResult = testeTextoGigante;
        String result = instance.retornaTextoComentario(Textocomentario.DIFICULDADES_ESPERADAS);
        assertEquals(expResult, result);
    }

    /**
     * <p>
     * teste que verifica um campo vazio
     * </p>
     */
    public void testRetornarTextoComentarioInteracaoEmpresaUniversidade1() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        String expResult = "";
        String result = instance.retornaTextoComentario(Textocomentario.INTERACAO_EMPRESA_UNIVERSIDADE);
        assertEquals(expResult, result);
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com o texto
     * preechido.
     */
    @Test
    public void testRetornarTextoComentarioInteracaoEmpresaUniversidade2() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        instance.setTextoComentario(Textocomentario.INTERACAO_EMPRESA_UNIVERSIDADE, "Texto");
        String expResult = "Texto";
        String result = instance.retornaTextoComentario(Textocomentario.INTERACAO_EMPRESA_UNIVERSIDADE);
        assertEquals(expResult, result);
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com a data de
     * alteração preenchida.
     */
    @Test
    public void testRetornarTextoComentarioInteracaoEmpresaUniversidade3() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Date date = new Date();
        instance.setTextoComentarioDataAlteracao(Textocomentario.INTERACAO_EMPRESA_UNIVERSIDADE, date);
        Date expResult = date;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.INTERACAO_EMPRESA_UNIVERSIDADE);
        assertEquals(expResult, result.getDataAlteracao());
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com a data de
     * submissão preenchida.
     */
    @Test
    public void testRetornarTextoComentarioInteracaoEmpresaUniversidade4() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Date date = new Date();
        instance.setTextoComentarioDataSubmissao(Textocomentario.INTERACAO_EMPRESA_UNIVERSIDADE, date);
        Date expResult = date;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.INTERACAO_EMPRESA_UNIVERSIDADE);
        assertEquals(expResult, result.getDataSubmissao());
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com a o gerente
     * preenchido
     */
    @Test
    public void testRetornarTextoComentarioInteracaoEmpresaUniversidade5() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        GerenteRelacionamento gerente = new GerenteRelacionamento();
        gerente.setIdgerente_relacionamento(2);
        instance.setTextoComentario(Textocomentario.INTERACAO_EMPRESA_UNIVERSIDADE, gerente);
        GerenteRelacionamento expResult = gerente;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.INTERACAO_EMPRESA_UNIVERSIDADE);
        assertEquals(expResult, result.getGerenteRelacionamento());
    }

    /**
     * Teste se o texto do comentário é encontrado.
     */
    @Test
    public void testRetornarTextoComentarioInteracaoEmpresaUniversidade6() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Textocomentario textocomentario = instance.retornarTextoComentario(Textocomentario.INTERACAO_EMPRESA_UNIVERSIDADE);
        textocomentario.setTexto(null);
        String expResult = null;
        String result = instance.retornaTextoComentario(Textocomentario.INTERACAO_EMPRESA_UNIVERSIDADE);
        assertEquals(expResult, result);
    }

    /**
     * <p>
     * Teste para o texto extenso
     * </p>
     */
    public void testRetornarTextoComentarioInteracaoEmpresaUniversidade7() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Textocomentario textocomentario = instance.retornarTextoComentario(Textocomentario.INTERACAO_EMPRESA_UNIVERSIDADE);
        textocomentario.setTexto(testeTextoGigante);
        String expResult = testeTextoGigante;
        String result = instance.retornaTextoComentario(Textocomentario.INTERACAO_EMPRESA_UNIVERSIDADE);
        assertEquals(expResult, result);
    }

    /**
     * <p>
     * teste que verifica um campo vazio
     * </p>
     */
    public void testRetornarTextoComentarioInteracaoEmpresa1() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        String expResult = "";
        String result = instance.retornaTextoComentario(Textocomentario.INTERACAO_EMPRESA_COMUNIDADE_GOVERNO);
        assertEquals(expResult, result);
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com o texto
     * preechido.
     */
    @Test
    public void testRetornarTextoComentarioInteracaoEmpresa2() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        instance.setTextoComentario(Textocomentario.INTERACAO_EMPRESA_COMUNIDADE_GOVERNO, "Texto");
        String expResult = "Texto";
        String result = instance.retornaTextoComentario(Textocomentario.INTERACAO_EMPRESA_COMUNIDADE_GOVERNO);
        assertEquals(expResult, result);
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com a data de
     * alteração preenchida.
     */
    @Test
    public void testRetornarTextoComentarioInteracaoEmpresa3() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Date date = new Date();
        instance.setTextoComentarioDataAlteracao(Textocomentario.INTERACAO_EMPRESA_COMUNIDADE_GOVERNO, date);
        Date expResult = date;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.INTERACAO_EMPRESA_COMUNIDADE_GOVERNO);
        assertEquals(expResult, result.getDataAlteracao());
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com a data de
     * submissão preenchida.
     */
    @Test
    public void testRetornarTextoComentarioInteracaoEmpresa4() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Date date = new Date();
        instance.setTextoComentarioDataSubmissao(Textocomentario.INTERACAO_EMPRESA_COMUNIDADE_GOVERNO, date);
        Date expResult = date;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.INTERACAO_EMPRESA_COMUNIDADE_GOVERNO);
        assertEquals(expResult, result.getDataSubmissao());
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com a o gerente
     * preenchido
     */
    @Test
    public void testRetornarTextoComentarioInteracaoEmpresa5() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        GerenteRelacionamento gerente = new GerenteRelacionamento();
        gerente.setIdgerente_relacionamento(2);
        instance.setTextoComentario(Textocomentario.INTERACAO_EMPRESA_COMUNIDADE_GOVERNO, gerente);
        GerenteRelacionamento expResult = gerente;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.INTERACAO_EMPRESA_COMUNIDADE_GOVERNO);
        assertEquals(expResult, result.getGerenteRelacionamento());
    }

    /**
     * Teste se o texto do comentário é encontrado.
     */
    @Test
    public void testRetornarTextoComentarioInteracaoEmpresa6() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Textocomentario textocomentario = instance.retornarTextoComentario(Textocomentario.INTERACAO_EMPRESA_COMUNIDADE_GOVERNO);
        textocomentario.setTexto(null);
        String expResult = null;
        String result = instance.retornaTextoComentario(Textocomentario.INTERACAO_EMPRESA_COMUNIDADE_GOVERNO);
        assertEquals(expResult, result);
    }

    /**
     * <p>
     * Teste para o texto extenso
     * </p>
     */
    public void testRetornarTextoComentarioInteracaoEmpresa7() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Textocomentario textocomentario = instance.retornarTextoComentario(Textocomentario.INTERACAO_EMPRESA_COMUNIDADE_GOVERNO);
        textocomentario.setTexto(testeTextoGigante);
        String expResult = testeTextoGigante;
        String result = instance.retornaTextoComentario(Textocomentario.INTERACAO_EMPRESA_COMUNIDADE_GOVERNO);
        assertEquals(expResult, result);

    }

    /**
     * <p>
     * teste que verifica um campo vazio
     * </p>
     */
    public void testRetornarTextoComentarioInfraEstrutura1() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        String expResult = "";
        String result = instance.retornaTextoComentario(Textocomentario.INFRAESTRUTURA);
        assertEquals(expResult, result);
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com o texto
     * preechido.
     */
    @Test
    public void testRetornarTextoComentarioInfraEstrutura2() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        instance.setTextoComentario(Textocomentario.INFRAESTRUTURA, "Texto");
        String expResult = "Texto";
        String result = instance.retornaTextoComentario(Textocomentario.INFRAESTRUTURA);
        assertEquals(expResult, result);
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com a data de
     * alteração preenchida.
     */
    @Test
    public void testRetornarTextoComentarioInfraEstrutura3() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Date date = new Date();
        instance.setTextoComentarioDataAlteracao(Textocomentario.INFRAESTRUTURA, date);
        Date expResult = date;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.INFRAESTRUTURA);
        assertEquals(expResult, result.getDataAlteracao());
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com a data de
     * submissão preenchida.
     */
    @Test
    public void testRetornarTextoComentarioInfraEstrutura4() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Date date = new Date();
        instance.setTextoComentarioDataSubmissao(Textocomentario.INFRAESTRUTURA, date);
        Date expResult = date;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.INFRAESTRUTURA);
        assertEquals(expResult, result.getDataSubmissao());
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com a o gerente
     * preenchido
     */
    @Test
    public void testRetornarTextoComentarioInfraEstrutura5() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        GerenteRelacionamento gerente = new GerenteRelacionamento();
        gerente.setIdgerente_relacionamento(2);
        instance.setTextoComentario(Textocomentario.INFRAESTRUTURA, gerente);
        GerenteRelacionamento expResult = gerente;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.INFRAESTRUTURA);
        assertEquals(expResult, result.getGerenteRelacionamento());
    }

    /**
     * Teste se o texto do comentário é encontrado.
     */
    @Test
    public void testRetornarTextoComentarioInfraEstrutura6() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Textocomentario textocomentario = instance.retornarTextoComentario(Textocomentario.INFRAESTRUTURA);
        textocomentario.setTexto(null);
        String expResult = null;
        String result = instance.retornaTextoComentario(Textocomentario.INFRAESTRUTURA);
        assertEquals(expResult, result);
    }

    /**
     * <p>
     * Teste para o texto extenso
     * </p>
     */
    public void testRetornarTextoComentarioInfraEstrutura7() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Textocomentario textocomentario = instance.retornarTextoComentario(Textocomentario.INFRAESTRUTURA);
        textocomentario.setTexto(testeTextoGigante);
        String expResult = testeTextoGigante;
        String result = instance.retornaTextoComentario(Textocomentario.INFRAESTRUTURA);
        assertEquals(expResult, result);
    }

    /**
     * <p>
     * teste que verifica um campo vazio
     * </p>
     */
    public void testRetornarTextoComentarioParticipacaoAcionaria1() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        String expResult = "";
        String result = instance.retornaTextoComentario(Textocomentario.PARTICIPACAO_ACIONARIA);
        assertEquals(expResult, result);
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com o texto
     * preechido.
     */
    @Test
    public void testRetornarTextoComentarioParticipacaoAcionaria2() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        instance.setTextoComentario(Textocomentario.PARTICIPACAO_ACIONARIA, "Texto");
        String expResult = "Texto";
        String result = instance.retornaTextoComentario(Textocomentario.PARTICIPACAO_ACIONARIA);
        assertEquals(expResult, result);
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com a data de
     * alteração preenchida.
     */
    @Test
    public void testRetornarTextoComentarioParticipacaoAcionaria3() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Date date = new Date();
        instance.setTextoComentarioDataAlteracao(Textocomentario.PARTICIPACAO_ACIONARIA, date);
        Date expResult = date;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.PARTICIPACAO_ACIONARIA);
        assertEquals(expResult, result.getDataAlteracao());
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com a data de
     * submissão preenchida.
     */
    @Test
    public void testRetornarTextoComentarioParticipacaoAcionaria4() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Date date = new Date();
        instance.setTextoComentarioDataSubmissao(Textocomentario.PARTICIPACAO_ACIONARIA, date);
        Date expResult = date;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.PARTICIPACAO_ACIONARIA);
        assertEquals(expResult, result.getDataSubmissao());
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com a o gerente
     * preenchido
     */
    @Test
    public void testRetornarTextoComentarioParticipacaoAcionaria5() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        GerenteRelacionamento gerente = new GerenteRelacionamento();
        gerente.setIdgerente_relacionamento(2);
        instance.setTextoComentario(Textocomentario.PARTICIPACAO_ACIONARIA, gerente);
        GerenteRelacionamento expResult = gerente;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.PARTICIPACAO_ACIONARIA);
        assertEquals(expResult, result.getGerenteRelacionamento());
    }

    /**
     * Teste se o texto do comentário é encontrado.
     */
    @Test
    public void testRetornarTextoComentarioParticipacaoAcionaria6() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Textocomentario textocomentario = instance.retornarTextoComentario(Textocomentario.PARTICIPACAO_ACIONARIA);
        textocomentario.setTexto(null);
        String expResult = null;
        String result = instance.retornaTextoComentario(Textocomentario.PARTICIPACAO_ACIONARIA);
        assertEquals(expResult, result);
    }

    /**
     * <p>
     * Teste para o texto extenso
     * </p>
     */
    public void testRetornarTextoComentarioParticipacaoAcionaria7() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Textocomentario textocomentario = instance.retornarTextoComentario(Textocomentario.PARTICIPACAO_ACIONARIA);
        textocomentario.setTexto(testeTextoGigante);
        String expResult = testeTextoGigante;
        String result = instance.retornaTextoComentario(Textocomentario.PARTICIPACAO_ACIONARIA);
        assertEquals(expResult, result);
    }

    /**
     * <p>
     * teste que verifica um campo vazio
     * </p>
     */
    public void testRetornarTextoComentarioPotencialEmprego1() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        String expResult = "";
        String result = instance.retornaTextoComentario(Textocomentario.POTENCIAL_EMPREGO);
        assertEquals(expResult, result);
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com o texto
     * preechido.
     */
    @Test
    public void testRetornarTextoComentarioPotencialEmprego2() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        instance.setTextoComentario(Textocomentario.POTENCIAL_EMPREGO, "Texto");
        String expResult = "Texto";
        String result = instance.retornaTextoComentario(Textocomentario.POTENCIAL_EMPREGO);
        assertEquals(expResult, result);
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com a data de
     * alteração preenchida.
     */
    @Test
    public void testRetornarTextoComentarioPotencialEmprego3() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Date date = new Date();
        instance.setTextoComentarioDataAlteracao(Textocomentario.POTENCIAL_EMPREGO, date);
        Date expResult = date;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.POTENCIAL_EMPREGO);
        assertEquals(expResult, result.getDataAlteracao());
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com a data de
     * submissão preenchida.
     */
    @Test
    public void testRetornarTextoComentarioPotencialEmprego4() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Date date = new Date();
        instance.setTextoComentarioDataSubmissao(Textocomentario.POTENCIAL_EMPREGO, date);
        Date expResult = date;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.POTENCIAL_EMPREGO);
        assertEquals(expResult, result.getDataSubmissao());
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com a o gerente
     * preenchido
     */
    @Test
    public void testRetornarTextoComentarioPotencialEmprego5() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        GerenteRelacionamento gerente = new GerenteRelacionamento();
        gerente.setIdgerente_relacionamento(2);
        instance.setTextoComentario(Textocomentario.POTENCIAL_EMPREGO, gerente);
        GerenteRelacionamento expResult = gerente;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.POTENCIAL_EMPREGO);
        assertEquals(expResult, result.getGerenteRelacionamento());
    }

    /**
     * Teste se o texto do comentário é encontrado.
     */
    @Test
    public void testRetornarTextoComentarioPotencialEmprego6() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Textocomentario textocomentario = instance.retornarTextoComentario(Textocomentario.POTENCIAL_EMPREGO);
        textocomentario.setTexto(null);
        String expResult = null;
        String result = instance.retornaTextoComentario(Textocomentario.POTENCIAL_EMPREGO);
        assertEquals(expResult, result);
    }

    /**
     * <p>
     * Teste para o texto extenso
     * </p>
     */
    public void testRetornarTextoComentarioPotencialEmprego7() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Textocomentario textocomentario = instance.retornarTextoComentario(Textocomentario.POTENCIAL_EMPREGO);
        textocomentario.setTexto(testeTextoGigante);
        String expResult = testeTextoGigante;
        String result = instance.retornaTextoComentario(Textocomentario.POTENCIAL_EMPREGO);
        assertEquals(expResult, result);
    }

    /**
     * <p>
     * teste que verifica um campo vazio
     * </p>
     */
    public void testRetornarTextoComentarioFontesReceita1() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        String expResult = "";
        String result = instance.retornaTextoComentario(Textocomentario.FONTES_RECEITA);
        assertEquals(expResult, result);
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com o texto
     * preechido.
     */
    @Test
    public void testRetornarTextoComentarioFontesReceita2() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        instance.setTextoComentario(Textocomentario.FONTES_RECEITA, "Texto");
        String expResult = "Texto";
        String result = instance.retornaTextoComentario(Textocomentario.FONTES_RECEITA);
        assertEquals(expResult, result);
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com a data de
     * alteração preenchida.
     */
    @Test
    public void testRetornarTextoComentarioFontesReceita3() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Date date = new Date();
        instance.setTextoComentarioDataAlteracao(Textocomentario.FONTES_RECEITA, date);
        Date expResult = date;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.FONTES_RECEITA);
        assertEquals(expResult, result.getDataAlteracao());
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com a data de
     * submissão preenchida.
     */
    @Test
    public void testRetornarTextoComentarioFontesReceita4() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Date date = new Date();
        instance.setTextoComentarioDataSubmissao(Textocomentario.FONTES_RECEITA, date);
        Date expResult = date;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.FONTES_RECEITA);
        assertEquals(expResult, result.getDataSubmissao());
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com a o gerente
     * preenchido
     */
    @Test
    public void testRetornarTextoComentarioFontesReceita5() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        GerenteRelacionamento gerente = new GerenteRelacionamento();
        gerente.setIdgerente_relacionamento(2);
        instance.setTextoComentario(Textocomentario.FONTES_RECEITA, gerente);
        GerenteRelacionamento expResult = gerente;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.FONTES_RECEITA);
        assertEquals(expResult, result.getGerenteRelacionamento());
    }

    /**
     * Teste se o texto do comentário é encontrado.
     */
    @Test
    public void testRetornarTextoComentarioFontesReceita6() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Textocomentario textocomentario = instance.retornarTextoComentario(Textocomentario.FONTES_RECEITA);
        textocomentario.setTexto(null);
        String expResult = null;
        String result = instance.retornaTextoComentario(Textocomentario.FONTES_RECEITA);
        assertEquals(expResult, result);
    }

    /**
     * <p>
     * Teste para o texto extenso
     * </p>
     */
    public void testRetornarTextoComentarioFontesReceita7() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Textocomentario textocomentario = instance.retornarTextoComentario(Textocomentario.FONTES_RECEITA);
        textocomentario.setTexto(testeTextoGigante);
        String expResult = testeTextoGigante;
        String result = instance.retornaTextoComentario(Textocomentario.FONTES_RECEITA);
        assertEquals(expResult, result);
    }

    /**
     * <p>
     * teste que verifica um campo vazio
     * </p>
     */
    public void testRetornarTextoComentarioEstruturaCustos1() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        String expResult = "";
        String result = instance.retornaTextoComentario(Textocomentario.ESTRUTURA_CUSTO);
        assertEquals(expResult, result);
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com o texto
     * preechido.
     */
    @Test
    public void testRetornarTextoComentarioEstruturaCustos2() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        instance.setTextoComentario(Textocomentario.ESTRUTURA_CUSTO, "Texto");
        String expResult = "Texto";
        String result = instance.retornaTextoComentario(Textocomentario.ESTRUTURA_CUSTO);
        assertEquals(expResult, result);
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com a data de
     * alteração preenchida.
     */
    @Test
    public void testRetornarTextoComentarioEstruturaCustos3() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Date date = new Date();
        instance.setTextoComentarioDataAlteracao(Textocomentario.ESTRUTURA_CUSTO, date);
        Date expResult = date;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.ESTRUTURA_CUSTO);
        assertEquals(expResult, result.getDataAlteracao());
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com a data de
     * submissão preenchida.
     */
    @Test
    public void testRetornarTextoComentarioEstruturaCustos4() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Date date = new Date();
        instance.setTextoComentarioDataSubmissao(Textocomentario.ESTRUTURA_CUSTO, date);
        Date expResult = date;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.ESTRUTURA_CUSTO);
        assertEquals(expResult, result.getDataSubmissao());
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com a o gerente
     * preenchido
     */
    @Test
    public void testRetornarTextoComentarioEstruturaCustos5() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        GerenteRelacionamento gerente = new GerenteRelacionamento();
        gerente.setIdgerente_relacionamento(2);
        instance.setTextoComentario(Textocomentario.ESTRUTURA_CUSTO, gerente);
        GerenteRelacionamento expResult = gerente;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.ESTRUTURA_CUSTO);
        assertEquals(expResult, result.getGerenteRelacionamento());
    }

    /**
     * Teste se o texto do comentário é encontrado.
     */
    @Test
    public void testRetornarTextoComentarioEstruturaCustos6() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Textocomentario textocomentario = instance.retornarTextoComentario(Textocomentario.ESTRUTURA_CUSTO);
        textocomentario.setTexto(null);
        String expResult = null;
        String result = instance.retornaTextoComentario(Textocomentario.ESTRUTURA_CUSTO);
        assertEquals(expResult, result);
    }

    /**
     * <p>
     * Teste para o texto extenso
     * </p>
     */
    public void testRetornarTextoComentarioEstruturaCustos7() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Textocomentario textocomentario = instance.retornarTextoComentario(Textocomentario.ESTRUTURA_CUSTO);
        textocomentario.setTexto(testeTextoGigante);
        String expResult = testeTextoGigante;
        String result = instance.retornaTextoComentario(Textocomentario.ESTRUTURA_CUSTO);
        assertEquals(expResult, result);
    }

    /**
     * <p>
     * teste que verifica um campo vazio
     * </p>
     */
    public void testRetornarTextoComentarioInvestimentoInicial1() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        String expResult = "";
        String result = instance.retornaTextoComentario(Textocomentario.INVESTIMENTO_INICIAL);
        assertEquals(expResult, result);
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com o texto
     * preechido.
     */
    @Test
    public void testRetornarTextoComentarioInvestimentoInicial2() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        instance.setTextoComentario(Textocomentario.INVESTIMENTO_INICIAL, "Texto");
        String expResult = "Texto";
        String result = instance.retornaTextoComentario(Textocomentario.INVESTIMENTO_INICIAL);
        assertEquals(expResult, result);
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com a data de
     * alteração preenchida.
     */
    @Test
    public void testRetornarTextoComentarioInvestimentoInicial3() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Date date = new Date();
        instance.setTextoComentarioDataAlteracao(Textocomentario.INVESTIMENTO_INICIAL, date);
        Date expResult = date;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.INVESTIMENTO_INICIAL);
        assertEquals(expResult, result.getDataAlteracao());
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com a data de
     * submissão preenchida.
     */
    @Test
    public void testRetornarTextoComentarioInvestimentoInicial4() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Date date = new Date();
        instance.setTextoComentarioDataSubmissao(Textocomentario.INVESTIMENTO_INICIAL, date);
        Date expResult = date;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.INVESTIMENTO_INICIAL);
        assertEquals(expResult, result.getDataSubmissao());
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com a o gerente
     * preenchido
     */
    @Test
    public void testRetornarTextoComentarioInvestimentoInicial5() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        GerenteRelacionamento gerente = new GerenteRelacionamento();
        gerente.setIdgerente_relacionamento(2);
        instance.setTextoComentario(Textocomentario.INVESTIMENTO_INICIAL, gerente);
        GerenteRelacionamento expResult = gerente;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.INVESTIMENTO_INICIAL);
        assertEquals(expResult, result.getGerenteRelacionamento());
    }

    /**
     * Teste se o texto do comentário é encontrado.
     */
    @Test
    public void testRetornarTextoComentarioInvestimentoInicial6() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Textocomentario textocomentario = instance.retornarTextoComentario(Textocomentario.INVESTIMENTO_INICIAL);
        textocomentario.setTexto(null);
        String expResult = null;
        String result = instance.retornaTextoComentario(Textocomentario.INVESTIMENTO_INICIAL);
        assertEquals(expResult, result);
    }

    /**
     * <p>
     * Teste para o texto extenso
     * </p>
     */
    public void testRetornarTextoComentarioInvestimentoInicial7() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Textocomentario textocomentario = instance.retornarTextoComentario(Textocomentario.INVESTIMENTO_INICIAL);
        textocomentario.setTexto(testeTextoGigante);
        String expResult = testeTextoGigante;
        String result = instance.retornaTextoComentario(Textocomentario.INVESTIMENTO_INICIAL);
        assertEquals(expResult, result);
    }

    /**
     * <p>
     * teste que verifica um campo vazio
     * </p>
     */
    public void testRetornarTextoComentarioCustoFixo1() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        String expResult = "";
        String result = instance.retornaTextoComentario(Textocomentario.CUSTOS_FIXOS);
        assertEquals(expResult, result);
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com o texto
     * preechido.
     */
    @Test
    public void testRetornarTextoComentarioCustoFixo2() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        instance.setTextoComentario(Textocomentario.CUSTOS_FIXOS, "Texto");
        String expResult = "Texto";
        String result = instance.retornaTextoComentario(Textocomentario.CUSTOS_FIXOS);
        assertEquals(expResult, result);
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com a data de
     * alteração preenchida.
     */
    @Test
    public void testRetornarTextoComentarioCustoFixo3() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Date date = new Date();
        instance.setTextoComentarioDataAlteracao(Textocomentario.CUSTOS_FIXOS, date);
        Date expResult = date;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.CUSTOS_FIXOS);
        assertEquals(expResult, result.getDataAlteracao());
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com a data de
     * submissão preenchida.
     */
    @Test
    public void testRetornarTextoComentarioCustoFixo4() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Date date = new Date();
        instance.setTextoComentarioDataSubmissao(Textocomentario.CUSTOS_FIXOS, date);
        Date expResult = date;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.CUSTOS_FIXOS);
        assertEquals(expResult, result.getDataSubmissao());
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com a o gerente
     * preenchido
     */
    @Test
    public void testRetornarTextoComentarioCustoFixo5() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        GerenteRelacionamento gerente = new GerenteRelacionamento();
        gerente.setIdgerente_relacionamento(2);
        instance.setTextoComentario(Textocomentario.CUSTOS_FIXOS, gerente);
        GerenteRelacionamento expResult = gerente;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.CUSTOS_FIXOS);
        assertEquals(expResult, result.getGerenteRelacionamento());
    }

    /**
     * Teste se o texto do comentário é encontrado.
     */
    @Test
    public void testRetornarTextoComentarioCustoFixo6() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Textocomentario textocomentario = instance.retornarTextoComentario(Textocomentario.CUSTOS_FIXOS);
        textocomentario.setTexto(null);
        String expResult = null;
        String result = instance.retornaTextoComentario(Textocomentario.CUSTOS_FIXOS);
        assertEquals(expResult, result);
    }

    /**
     * <p>
     * Teste para o texto extenso
     * </p>
     */
    public void testRetornarTextoComentarioCustoFixo7() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Textocomentario textocomentario = instance.retornarTextoComentario(Textocomentario.CUSTOS_FIXOS);
        textocomentario.setTexto(testeTextoGigante);
        String expResult = testeTextoGigante;
        String result = instance.retornaTextoComentario(Textocomentario.CUSTOS_FIXOS);
        assertEquals(expResult, result);
    }

    /**
     * <p>
     * teste que verifica um campo vazio
     * </p>
     */
    public void testRetornarTextoComentarioCustoVariavel1() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        String expResult = "";
        String result = instance.retornaTextoComentario(Textocomentario.CUSTOS_VARIAVEIS);
        assertEquals(expResult, result);
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com o texto
     * preechido.
     */
    @Test
    public void testRetornarTextoComentarioCustoVariavel2() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        instance.setTextoComentario(Textocomentario.CUSTOS_VARIAVEIS, "Texto");
        String expResult = "Texto";
        String result = instance.retornaTextoComentario(Textocomentario.CUSTOS_VARIAVEIS);
        assertEquals(expResult, result);
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com a data de
     * alteração preenchida.
     */
    @Test
    public void testRetornarTextoComentarioCustoVariavel3() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Date date = new Date();
        instance.setTextoComentarioDataAlteracao(Textocomentario.CUSTOS_VARIAVEIS, date);
        Date expResult = date;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.CUSTOS_VARIAVEIS);
        assertEquals(expResult, result.getDataAlteracao());
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com a data de
     * submissão preenchida.
     */
    @Test
    public void testRetornarTextoComentarioCustoVariavel4() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Date date = new Date();
        instance.setTextoComentarioDataSubmissao(Textocomentario.CUSTOS_VARIAVEIS, date);
        Date expResult = date;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.CUSTOS_VARIAVEIS);
        assertEquals(expResult, result.getDataSubmissao());
    }

    /**
     * Teste se o texto do comentário é encontrado quando está com a o gerente
     * preenchido
     */
    @Test
    public void testRetornarTextoComentarioCustoVariavel5() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        GerenteRelacionamento gerente = new GerenteRelacionamento();
        gerente.setIdgerente_relacionamento(2);
        instance.setTextoComentario(Textocomentario.CUSTOS_VARIAVEIS, gerente);
        GerenteRelacionamento expResult = gerente;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.CUSTOS_VARIAVEIS);
        assertEquals(expResult, result.getGerenteRelacionamento());
    }

    /**
     * Teste se o texto do comentário é encontrado.
     */
    @Test
    public void testRetornarTextoComentarioCustoVariavel6() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Textocomentario textocomentario = instance.retornarTextoComentario(Textocomentario.CUSTOS_VARIAVEIS);
        textocomentario.setTexto(null);
        String expResult = null;
        String result = instance.retornaTextoComentario(Textocomentario.CUSTOS_VARIAVEIS);
        assertEquals(expResult, result);
    }

    /**
     * <p>
     * Teste para o texto extenso
     * </p>
     */
    public void testRetornarTextoComentarioCustoVariavel7() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Textocomentario textocomentario = instance.retornarTextoComentario(Textocomentario.CUSTOS_VARIAVEIS);
        textocomentario.setTexto(testeTextoGigante);
        String expResult = testeTextoGigante;
        String result = instance.retornaTextoComentario(Textocomentario.CUSTOS_VARIAVEIS);
        assertEquals(expResult, result);
    }

    /**
     * Test of populandoVariaveisComentario method, of class ComentarioProjeto.
     */
    @Test
    public void testPopulandoVariaveisComentario() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        instance.populandoVariaveisComentario();
    }

    /**
     * Test of todasConsideracoes method, of class ComentarioProjeto.
     */
    @Test
    public void testTodasConsideracoes() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        instance.setConsideracoes("");
        instance.setConsideracoesPersonalizadas("");
        String expResult = instance.getConsideracoes() + "\n" + instance.getConsideracoesPersonalizadas();
        String result = instance.todasConsideracoes();
        assertEquals(expResult, result);
    }

    /**
     * Test of verificaCampos method, of class ComentarioProjeto.
     */
    @Test
    public void testVerificaCampos() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        int expResult = 0;
        int result = instance.verificaCampos();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTextocomentarios method, of class ComentarioProjeto.
     */
    @Test
    public void testGetTextocomentarios() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Set<Textocomentario> expResult = null;
        instance.setTextocomentarios(expResult);
        Set<Textocomentario> result = instance.getTextocomentarios();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTextocomentarios method, of class ComentarioProjeto.
     */
    @Test
    public void testSetTextocomentarios() {
        
        Set<Textocomentario> textocomentarios = null;
        ComentarioProjeto instance = new ComentarioProjeto();
        instance.setTextocomentarios(textocomentarios);
    }

    /**
     * Test of retornaTextoComentario method, of class ComentarioProjeto.
     */
    @Test
    public void testRetornaTextoComentario() {
        
        int tipo = 0;
        ComentarioProjeto instance = new ComentarioProjeto();
        String expResult = null;
        String result = instance.retornaTextoComentario(tipo);
        assertEquals(expResult, result);
    }

    /**
     * Test of retornarTextoComentario method, of class ComentarioProjeto.
     */
    @Test
    public void testRetornarTextoComentario() {
        
        int tipo = 0;
        ComentarioProjeto instance = new ComentarioProjeto();
        Textocomentario expResult = null;
        Textocomentario result = instance.retornarTextoComentario(tipo);
        assertEquals(expResult, result);
    }

    /**
     * Test of retornarSegmentosClientes method, of class ComentarioProjeto.
     */
    @Test
    public void testRetornarSegmentosClientes() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        String expResult = "";
        String result = instance.retornarSegmentosClientes();
        assertEquals(expResult, result);
    }

    /**
     * Test of retornarPropostaValor method, of class ComentarioProjeto.
     */
    @Test
    public void testRetornarPropostaValor() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        String expResult = "";
        String result = instance.retornarPropostaValor();
        assertEquals(expResult, result);
    }

    /**
     * Test of retornarAtividadesChave method, of class ComentarioProjeto.
     */
    @Test
    public void testRetornarAtividadesChave() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        String expResult = "";
        String result = instance.retornarAtividadesChave();
        assertEquals(expResult, result);
    }

    /**
     * Test of retornarRelacoesClientes method, of class ComentarioProjeto.
     */
    @Test
    public void testRetornarRelacoesClientes() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        String expResult = "";
        String result = instance.retornarRelacoesClientes();
        assertEquals(expResult, result);
    }

    /**
     * Test of retornarParceriasChave method, of class ComentarioProjeto.
     */
    @Test
    public void testRetornarParceriasChave() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        String expResult = "";
        String result = instance.retornarParceriasChave();
        assertEquals(expResult, result);
    }

    /**
     * Test of retornarCanais method, of class ComentarioProjeto.
     */
    @Test
    public void testRetornarCanais() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        String expResult = "";
        String result = instance.retornarCanais();
        assertEquals(expResult, result);
    }

    /**
     * Test of retornarRecursosPrincipais method, of class ComentarioProjeto.
     */
    @Test
    public void testRetornarRecursosPrincipais() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        String expResult = "";
        String result = instance.retornarRecursosPrincipais();
        assertEquals(expResult, result);
    }

    /**
     * Test of retornarConcorrentes method, of class ComentarioProjeto.
     */
    @Test
    public void testRetornarConcorrentes() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        String expResult = "";
        String result = instance.retornarConcorrentes();
        assertEquals(expResult, result);
    }

    /**
     * Test of retornarEstagioEvolucao method, of class ComentarioProjeto.
     */
    @Test
    public void testRetornarEstagioEvolucao() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        String expResult = "";
        String result = instance.retornarEstagioEvolucao();
        assertEquals(expResult, result);
    }

    /**
     * Test of retornarTecnologiaProcesso method, of class ComentarioProjeto.
     */
    @Test
    public void testRetornarTecnologiaProcesso() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        String expResult = "";
        String result = instance.retornarTecnologiaProcesso();
        assertEquals(expResult, result);
    }

    /**
     * Test of retornarPotencialInovacaoTecnologia method, of class
     * ComentarioProjeto.
     */
    @Test
    public void testRetornarPotencialInovacaoTecnologia() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        String expResult = "";
        String result = instance.retornarPotencialInovacaoTecnologia();
        assertEquals(expResult, result);
    }

    /**
     * Test of retornarAplicacoes method, of class ComentarioProjeto.
     */
    @Test
    public void testRetornarAplicacoes() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        String expResult = "";
        String result = instance.retornarAplicacoes();
        assertEquals(expResult, result);
    }

    /**
     * Test of retornarDifilcudadesEsperadas method, of class ComentarioProjeto.
     */
    @Test
    public void testRetornarDifilcudadesEsperadas() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        String expResult = "";
        String result = instance.retornarDifilcudadesEsperadas();
        assertEquals(expResult, result);
    }

    /**
     * Test of retornarInteracaoEmpresaUniversidade method, of class
     * ComentarioProjeto.
     */
    @Test
    public void testRetornarInteracaoEmpresaUniversidade() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        String expResult = "";
        String result = instance.retornarInteracaoEmpresaUniversidade();
        assertEquals(expResult, result);
    }

    /**
     * Test of retornarInteracaoEmpresaComunidadeGoverno method, of class
     * ComentarioProjeto.
     */
    @Test
    public void testRetornarInteracaoEmpresaComunidadeGoverno() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        String expResult = "";
        String result = instance.retornarInteracaoEmpresaComunidadeGoverno();
        assertEquals(expResult, result);
    }

    /**
     * Test of retornarInfraEstrutura method, of class ComentarioProjeto.
     */
    @Test
    public void testRetornarInfraEstrutura() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        String expResult = "";
        String result = instance.retornarInfraEstrutura();
        assertEquals(expResult, result);
    }

    /**
     * Test of retornarParticipacaoAcionaria method, of class ComentarioProjeto.
     */
    @Test
    public void testRetornarParticipacaoAcionaria() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        String expResult = "";
        String result = instance.retornarParticipacaoAcionaria();
        assertEquals(expResult, result);
    }

    /**
     * Test of retornarPotencialEmprego method, of class ComentarioProjeto.
     */
    @Test
    public void testRetornarPotencialEmprego() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        String expResult = "";
        String result = instance.retornarPotencialEmprego();
        assertEquals(expResult, result);
    }

    /**
     * Test of retornarFontesReceitas method, of class ComentarioProjeto.
     */
    @Test
    public void testRetornarFontesReceitas() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        String expResult = "";
        String result = instance.retornarFontesReceitas();
        assertEquals(expResult, result);
    }

    /**
     * Test of retornarEstruturaCustos method, of class ComentarioProjeto.
     */
    @Test
    public void testRetornarEstruturaCustos() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        String expResult = "";
        String result = instance.retornarEstruturaCustos();
        assertEquals(expResult, result);
    }

    /**
     * Test of retornarInvestimentoInicial method, of class ComentarioProjeto.
     */
    @Test
    public void testRetornarInvestimentoInicial() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        String expResult = "";
        String result = instance.retornarInvestimentoInicial();
        assertEquals(expResult, result);
    }

    /**
     * Test of retornarCustosFixos method, of class ComentarioProjeto.
     */
    @Test
    public void testRetornarCustosFixos() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        String expResult = "";
        String result = instance.retornarCustosFixos();
        assertEquals(expResult, result);
    }

    /**
     * Test of retornarCustosVariaveis method, of class ComentarioProjeto.
     */
    @Test
    public void testRetornarCustosVariaveis() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        String expResult = "";
        String result = instance.retornarCustosVariaveis();
        assertEquals(expResult, result);
    }

    /**
     * Test of atualizaTodosOsTextoComentario method, of class
     * ComentarioProjeto.
     */
    @Test
    public void testAtualizaTodosOsTextoComentario() {
        
        GerenteRelacionamento gerente = new GerenteRelacionamento();
        ComentarioProjeto instance = new ComentarioProjeto();
        Textocomentario textoComent = new Textocomentario();

        instance.setAplicacoes(textoComent);
        instance.setAtividadeChave(textoComent);
        instance.setCanais(textoComent);
        instance.setConcorrentes(textoComent);
        instance.setCustoFixo(textoComent);
        instance.setCustoVariavel(textoComent);
        instance.setDificuldadesEsperadas(textoComent);
        instance.setEstagioEvolucao(textoComent);
        instance.setEstruturaCusto(textoComent);
        instance.setFontesReceita(textoComent);
        instance.setInfraestrutura(textoComent);
        instance.setInteracaoEmpresaComunidadeGoverno(textoComent);
        instance.setInteracaoEmpresaUniversidade(textoComent);
        instance.setInvestimentoInicial(textoComent);
        instance.setParceriasChave(textoComent);
        instance.setParticipacaoAcionaria(textoComent);
        instance.setPotencialEmprego(textoComent);
        instance.setPotencialInovacaoTecnologica(textoComent);
        instance.setPropostaValor(textoComent);
        instance.setRecursosPrincipais(textoComent);
        instance.setRelacionamentoCliente(textoComent);
        instance.setSegmentosClientes(textoComent);
        instance.setTecnologiaProcessos(textoComent);

        instance.atualizaTodosOsTextoComentario(gerente);
    }

    /**
     * Test of atualizarTextoComentario method, of class ComentarioProjeto.
     */
    @Test
    public void testAtualizarTextoComentario() {
        
        GerenteRelacionamento gerente = new GerenteRelacionamento();
        ComentarioProjeto instance = new ComentarioProjeto();
        Textocomentario textoComent = new Textocomentario();

        instance.setAplicacoes(textoComent);
        instance.setAtividadeChave(textoComent);
        instance.setCanais(textoComent);
        instance.setConcorrentes(textoComent);
        instance.setCustoFixo(textoComent);
        instance.setCustoVariavel(textoComent);
        instance.setDificuldadesEsperadas(textoComent);
        instance.setEstagioEvolucao(textoComent);
        instance.setEstruturaCusto(textoComent);
        instance.setFontesReceita(textoComent);
        instance.setInfraestrutura(textoComent);
        instance.setInteracaoEmpresaComunidadeGoverno(textoComent);
        instance.setInteracaoEmpresaUniversidade(textoComent);
        instance.setInvestimentoInicial(textoComent);
        instance.setParceriasChave(textoComent);
        instance.setParticipacaoAcionaria(textoComent);
        instance.setPotencialEmprego(textoComent);
        instance.setPotencialInovacaoTecnologica(textoComent);
        instance.setPropostaValor(textoComent);
        instance.setRecursosPrincipais(textoComent);
        instance.setRelacionamentoCliente(textoComent);
        instance.setSegmentosClientes(textoComent);
        instance.setTecnologiaProcessos(textoComent);

        instance.atualizarTextoComentario(gerente, textoComent);
    }

    /**
     * Test of setTextoComentario method, of class ComentarioProjeto.
     */
    @Test
    public void testSetTextoComentario_int_String() {
        
        int tipo = 0;
        String texto = "";
        ComentarioProjeto instance = new ComentarioProjeto();
        instance.setTextoComentario(tipo, texto);
    }

    /**
     * Test of setTextoComentario method, of class ComentarioProjeto.
     */
    @Test
    public void testSetTextoComentario_int_GerenteRelacionamento() {
        
        int tipo = 0;
        GerenteRelacionamento gerenteRelacionamento = null;
        ComentarioProjeto instance = new ComentarioProjeto();
        instance.setTextoComentario(tipo, gerenteRelacionamento);
    }

    /**
     * Test of setTextoComentarioDataAlteracao method, of class
     * ComentarioProjeto.
     */
    @Test
    public void testSetTextoComentarioDataAlteracao() {
        
        int tipo = 0;
        Date dataAlteracao = null;
        ComentarioProjeto instance = new ComentarioProjeto();
        instance.setTextoComentarioDataAlteracao(tipo, dataAlteracao);
    }

    /**
     * Test of setTextoComentarioDataSubmissao method, of class
     * ComentarioProjeto.
     */
    @Test
    public void testSetTextoComentarioDataSubmissao() {
        
        int tipo = 0;
        Date dataSubmissao = null;
        ComentarioProjeto instance = new ComentarioProjeto();
        instance.setTextoComentarioDataSubmissao(tipo, dataSubmissao);
    }

    /**
     * Test of getIdcomentario method, of class ComentarioProjeto.
     */
    @Test
    public void testGetIdcomentario() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Integer expResult = null;
        instance.setIdcomentario(expResult);
        Integer result = instance.getIdcomentario();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIdcomentario method, of class ComentarioProjeto.
     */
    @Test
    public void testSetIdcomentario() {
        
        Integer idcomentario = null;
        ComentarioProjeto instance = new ComentarioProjeto();
        instance.setIdcomentario(idcomentario);
    }

    /**
     * Test of getNome method, of class ComentarioProjeto.
     */
    @Test
    public void testGetNome() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        String expResult = "";
        instance.setNome(expResult);
        String result = instance.getNome();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNome method, of class ComentarioProjeto.
     */
    @Test
    public void testSetNome() {
        
        String nome = "";
        ComentarioProjeto instance = new ComentarioProjeto();
        instance.setNome(nome);
    }

    /**
     * Test of getParticipacaoacionaria method, of class ComentarioProjeto.
     */
    @Test
    public void testGetParticipacaoacionaria() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        String expResult = "";
        instance.setParticipacaoacionaria(expResult);
        String result = instance.getParticipacaoacionaria();
        assertEquals(expResult, result);
    }

    /**
     * Test of setParticipacaoacionaria method, of class ComentarioProjeto.
     */
    @Test
    public void testSetParticipacaoacionaria() {
        
        String participacaoacionaria = "";
        ComentarioProjeto instance = new ComentarioProjeto();
        instance.setParticipacaoacionaria(participacaoacionaria);
    }

    /**
     * Test of getPotencialemprego method, of class ComentarioProjeto.
     */
    @Test
    public void testGetPotencialemprego() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        String expResult = "";
        instance.setPotencialemprego(expResult);
        String result = instance.getPotencialemprego();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPotencialemprego method, of class ComentarioProjeto.
     */
    @Test
    public void testSetPotencialemprego() {
        
        String potencialemprego = "";
        ComentarioProjeto instance = new ComentarioProjeto();
        instance.setPotencialemprego(potencialemprego);
    }

    /**
     * Test of getConsideracoes method, of class ComentarioProjeto.
     */
    @Test
    public void testGetConsideracoes() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        String expResult = "";
        instance.setConsideracoes(expResult);
        String result = instance.getConsideracoes();
        assertEquals(expResult, result);
    }

    /**
     * Test of setConsideracoes method, of class ComentarioProjeto.
     */
    @Test
    public void testSetConsideracoes() {
        
        String consideracoes = "";
        ComentarioProjeto instance = new ComentarioProjeto();
        instance.setConsideracoes(consideracoes);
    }

    /**
     * Test of getProjeto method, of class ComentarioProjeto.
     */
    @Test
    public void testGetProjeto() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Projeto expResult = null;
        instance.setProjeto(expResult);
        Projeto result = instance.getProjeto();
        assertEquals(expResult, result);
    }

    /**
     * Test of setProjeto method, of class ComentarioProjeto.
     */
    @Test
    public void testSetProjeto() {
        
        Projeto projeto = null;
        ComentarioProjeto instance = new ComentarioProjeto();
        instance.setProjeto(projeto);
    }

    /**
     * Test of getStatus method, of class ComentarioProjeto.
     */
    @Test
    public void testGetStatus() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Integer expResult = null;
        instance.setStatus(expResult);
        Integer result = instance.getStatus();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStatus method, of class ComentarioProjeto.
     */
    @Test
    public void testGetStatus2() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Integer expResult = 1; // Em andamento
        instance.setStatus(expResult);
        Integer result = instance.getStatus();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStatus method, of class ComentarioProjeto.
     */
    @Test
    public void testGetStatus3() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Integer expResult = 2; // Finalizado
        instance.setStatus(expResult);
        Integer result = instance.getStatus();
        assertEquals(expResult, result);
    }

    /**
     * Test of setStatus method, of class ComentarioProjeto.
     */
    @Test
    public void testSetStatus() {
        
        Integer status = null;
        ComentarioProjeto instance = new ComentarioProjeto();
        instance.setStatus(status);
    }

    /**
     * Test of getStatusString method, of class ComentarioProjeto.
     */
    @Test
    public void testGetStatusString() {
        
        int status = 0;
        ComentarioProjeto instance = new ComentarioProjeto();
        String expResult = "";
        instance.setStatus(status);
        String result = instance.getStatusString(status);
        assertEquals(expResult, result);
    }

    /**
     * Test of getConsideracoesPersonalizadas method, of class
     * ComentarioProjeto.
     */
    @Test
    public void testGetConsideracoesPersonalizadas() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        String expResult = "";
        instance.setConsideracoesPersonalizadas(expResult);
        String result = instance.getConsideracoesPersonalizadas();
        assertEquals(expResult, result);
    }

    /**
     * Test of setConsideracoesPersonalizadas method, of class
     * ComentarioProjeto.
     */
    @Test
    public void testSetConsideracoesPersonalizadas() {
        
        String consideracoesPersonalizadas = "";
        ComentarioProjeto instance = new ComentarioProjeto();
        instance.setConsideracoesPersonalizadas(consideracoesPersonalizadas);
    }

    /**
     * Test of getSegmentosClientes method, of class ComentarioProjeto.
     */
    @Test
    public void testGetSegmentosClientes() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Textocomentario expResult = new Textocomentario();
        instance.setSegmentosClientes(expResult);
        Textocomentario result = instance.getSegmentosClientes();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSegmentosClientes method, of class ComentarioProjeto.
     */
    @Test
    public void testSetSegmentosClientes() {
        
        Textocomentario segmentosClientes = new Textocomentario();
        ComentarioProjeto instance = new ComentarioProjeto();
        instance.setSegmentosClientes(segmentosClientes);
    }

    /**
     * Test of getPropostaValor method, of class ComentarioProjeto.
     */
    @Test
    public void testGetPropostaValor() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Textocomentario expResult = null;
        instance.setPropostaValor(expResult);
        Textocomentario result = instance.getPropostaValor();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPropostaValor method, of class ComentarioProjeto.
     */
    @Test
    public void testSetPropostaValor() {
        
        Textocomentario propostaValor = null;
        ComentarioProjeto instance = new ComentarioProjeto();
        instance.setPropostaValor(propostaValor);
    }

    /**
     * Test of getAtividadeChave method, of class ComentarioProjeto.
     */
    @Test
    public void testGetAtividadeChave() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Textocomentario expResult = null;
        instance.setAtividadeChave(expResult);
        Textocomentario result = instance.getAtividadeChave();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAtividadeChave method, of class ComentarioProjeto.
     */
    @Test
    public void testSetAtividadeChave() {
        
        Textocomentario atividadeChave = null;
        ComentarioProjeto instance = new ComentarioProjeto();
        instance.setAtividadeChave(atividadeChave);
    }

    /**
     * Test of getRelacionamentoCliente method, of class ComentarioProjeto.
     */
    @Test
    public void testGetRelacionamentoCliente() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Textocomentario expResult = null;
        instance.setRelacionamentoCliente(expResult);
        Textocomentario result = instance.getRelacionamentoCliente();
        assertEquals(expResult, result);
    }

    /**
     * Test of setRelacionamentoCliente method, of class ComentarioProjeto.
     */
    @Test
    public void testSetRelacionamentoCliente() {
        
        Textocomentario relacionamentoCliente = null;
        ComentarioProjeto instance = new ComentarioProjeto();
        instance.setRelacionamentoCliente(relacionamentoCliente);
    }

    /**
     * Test of getParceriasChave method, of class ComentarioProjeto.
     */
    @Test
    public void testGetParceriasChave() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Textocomentario expResult = null;
        instance.setParceriasChave(expResult);
        Textocomentario result = instance.getParceriasChave();
        assertEquals(expResult, result);
    }

    /**
     * Test of setParceriasChave method, of class ComentarioProjeto.
     */
    @Test
    public void testSetParceriasChave() {
        
        Textocomentario parceriasChave = null;
        ComentarioProjeto instance = new ComentarioProjeto();
        instance.setParceriasChave(parceriasChave);
    }

    /**
     * Test of getCanais method, of class ComentarioProjeto.
     */
    @Test
    public void testGetCanais() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Textocomentario expResult = null;
        instance.setCanais(expResult);
        Textocomentario result = instance.getCanais();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCanais method, of class ComentarioProjeto.
     */
    @Test
    public void testSetCanais() {
        
        Textocomentario canais = null;
        ComentarioProjeto instance = new ComentarioProjeto();
        instance.setCanais(canais);
    }

    /**
     * Test of getRecursosPrincipais method, of class ComentarioProjeto.
     */
    @Test
    public void testGetRecursosPrincipais() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Textocomentario expResult = null;
        instance.setRecursosPrincipais(expResult);
        Textocomentario result = instance.getRecursosPrincipais();
        assertEquals(expResult, result);
    }

    /**
     * Test of setRecursosPrincipais method, of class ComentarioProjeto.
     */
    @Test
    public void testSetRecursosPrincipais() {
        
        Textocomentario recursosPrincipais = null;
        ComentarioProjeto instance = new ComentarioProjeto();
        instance.setRecursosPrincipais(recursosPrincipais);
    }

    /**
     * Test of getConcorrentes method, of class ComentarioProjeto.
     */
    @Test
    public void testGetConcorrentes() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Textocomentario expResult = null;
        Textocomentario result = instance.getConcorrentes();
        assertEquals(expResult, result);
    }

    /**
     * Test of setConcorrentes method, of class ComentarioProjeto.
     */
    @Test
    public void testSetConcorrentes() {
        
        Textocomentario concorrentes = null;
        ComentarioProjeto instance = new ComentarioProjeto();
        instance.setConcorrentes(concorrentes);
    }

    /**
     * Test of getEstagioEvolucao method, of class ComentarioProjeto.
     */
    @Test
    public void testGetEstagioEvolucao() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Textocomentario expResult = null;
        instance.setEstagioEvolucao(expResult);
        Textocomentario result = instance.getEstagioEvolucao();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEstagioEvolucao method, of class ComentarioProjeto.
     */
    @Test
    public void testSetEstagioEvolucao() {
        
        Textocomentario estagioEvolucao = null;
        ComentarioProjeto instance = new ComentarioProjeto();
        instance.setEstagioEvolucao(estagioEvolucao);
    }

    /**
     * Test of getTecnologiaProcessos method, of class ComentarioProjeto.
     */
    @Test
    public void testGetTecnologiaProcessos() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Textocomentario expResult = null;
        instance.setTecnologiaProcessos(expResult);
        Textocomentario result = instance.getTecnologiaProcessos();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTecnologiaProcessos method, of class ComentarioProjeto.
     */
    @Test
    public void testSetTecnologiaProcessos() {
        
        Textocomentario tecnologiaProcessos = null;
        ComentarioProjeto instance = new ComentarioProjeto();
        instance.setTecnologiaProcessos(tecnologiaProcessos);
    }

    /**
     * Test of getPotencialInovacaoTecnologica method, of class
     * ComentarioProjeto.
     */
    @Test
    public void testGetPotencialInovacaoTecnologica() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Textocomentario expResult = null;
        instance.setPotencialInovacaoTecnologica(expResult);
        Textocomentario result = instance.getPotencialInovacaoTecnologica();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPotencialInovacaoTecnologica method, of class
     * ComentarioProjeto.
     */
    @Test
    public void testSetPotencialInovacaoTecnologica() {
        
        Textocomentario potencialInovacaoTecnologica = null;
        ComentarioProjeto instance = new ComentarioProjeto();
        instance.setPotencialInovacaoTecnologica(potencialInovacaoTecnologica);
    }

    /**
     * Test of getAplicacoes method, of class ComentarioProjeto.
     */
    @Test
    public void testGetAplicacoes() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Textocomentario expResult = null;
        instance.setAplicacoes(expResult);
        Textocomentario result = instance.getAplicacoes();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAplicacoes method, of class ComentarioProjeto.
     */
    @Test
    public void testSetAplicacoes() {
        
        Textocomentario aplicacoes = null;
        ComentarioProjeto instance = new ComentarioProjeto();
        instance.setAplicacoes(aplicacoes);
    }

    /**
     * Test of getDificuldadesEsperadas method, of class ComentarioProjeto.
     */
    @Test
    public void testGetDificuldadesEsperadas() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Textocomentario expResult = null;
        instance.setDificuldadesEsperadas(expResult);
        Textocomentario result = instance.getDificuldadesEsperadas();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDificuldadesEsperadas method, of class ComentarioProjeto.
     */
    @Test
    public void testSetDificuldadesEsperadas() {
        
        Textocomentario dificuldadesEsperadas = null;
        ComentarioProjeto instance = new ComentarioProjeto();
        instance.setDificuldadesEsperadas(dificuldadesEsperadas);
    }

    /**
     * Test of getInteracaoEmpresaUniversidade method, of class
     * ComentarioProjeto.
     */
    @Test
    public void testGetInteracaoEmpresaUniversidade() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Textocomentario expResult = null;
        instance.setInteracaoEmpresaUniversidade(expResult);
        Textocomentario result = instance.getInteracaoEmpresaUniversidade();
        assertEquals(expResult, result);
    }

    /**
     * Test of setInteracaoEmpresaUniversidade method, of class
     * ComentarioProjeto.
     */
    @Test
    public void testSetInteracaoEmpresaUniversidade() {
        
        Textocomentario interacaoEmpresaUniversidade = null;
        ComentarioProjeto instance = new ComentarioProjeto();
        instance.setInteracaoEmpresaUniversidade(interacaoEmpresaUniversidade);
    }

    /**
     * Test of getInteracaoEmpresaComunidadeGoverno method, of class
     * ComentarioProjeto.
     */
    @Test
    public void testGetInteracaoEmpresaComunidadeGoverno() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Textocomentario expResult = null;
        instance.setInteracaoEmpresaComunidadeGoverno(expResult);
        Textocomentario result = instance.getInteracaoEmpresaComunidadeGoverno();
        assertEquals(expResult, result);
    }

    /**
     * Test of setInteracaoEmpresaComunidadeGoverno method, of class
     * ComentarioProjeto.
     */
    @Test
    public void testSetInteracaoEmpresaComunidadeGoverno() {
        
        Textocomentario interacaoEmpresaComunidadeGoverno = null;
        ComentarioProjeto instance = new ComentarioProjeto();
        instance.setInteracaoEmpresaComunidadeGoverno(interacaoEmpresaComunidadeGoverno);
    }

    /**
     * Test of getInfraestrutura method, of class ComentarioProjeto.
     */
    @Test
    public void testGetInfraestrutura() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Textocomentario expResult = null;
        instance.setInfraestrutura(expResult);
        Textocomentario result = instance.getInfraestrutura();
        assertEquals(expResult, result);
    }

    /**
     * Test of setInfraestrutura method, of class ComentarioProjeto.
     */
    @Test
    public void testSetInfraestrutura() {
        
        Textocomentario infraestrutura = null;
        ComentarioProjeto instance = new ComentarioProjeto();
        instance.setInfraestrutura(infraestrutura);
    }

    /**
     * Test of getParticipacaoAcionaria method, of class ComentarioProjeto.
     */
    @Test
    public void testGetParticipacaoAcionaria() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Textocomentario expResult = null;
        instance.setParticipacaoAcionaria(expResult);
        Textocomentario result = instance.getParticipacaoAcionaria();
        assertEquals(expResult, result);
    }

    /**
     * Test of setParticipacaoAcionaria method, of class ComentarioProjeto.
     */
    @Test
    public void testSetParticipacaoAcionaria() {
        
        Textocomentario participacaoAcionaria = null;
        ComentarioProjeto instance = new ComentarioProjeto();
        instance.setParticipacaoAcionaria(participacaoAcionaria);
    }

    /**
     * Test of getPotencialEmprego method, of class ComentarioProjeto.
     */
    @Test
    public void testGetPotencialEmprego() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Textocomentario expResult = null;
        instance.setPotencialEmprego(expResult);
        Textocomentario result = instance.getPotencialEmprego();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPotencialEmprego method, of class ComentarioProjeto.
     */
    @Test
    public void testSetPotencialEmprego() {
        
        Textocomentario potencialEmprego = null;
        ComentarioProjeto instance = new ComentarioProjeto();
        instance.setPotencialEmprego(potencialEmprego);
    }

    /**
     * Test of getFontesReceita method, of class ComentarioProjeto.
     */
    @Test
    public void testGetFontesReceita() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Textocomentario expResult = null;
        instance.setFontesReceita(expResult);
        Textocomentario result = instance.getFontesReceita();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFontesReceita method, of class ComentarioProjeto.
     */
    @Test
    public void testSetFontesReceita() {
        
        Textocomentario fontesReceita = null;
        ComentarioProjeto instance = new ComentarioProjeto();
        instance.setFontesReceita(fontesReceita);
    }

    /**
     * Test of getEstruturaCusto method, of class ComentarioProjeto.
     */
    @Test
    public void testGetEstruturaCusto() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Textocomentario expResult = null;
        instance.setEstruturaCusto(expResult);
        Textocomentario result = instance.getEstruturaCusto();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEstruturaCusto method, of class ComentarioProjeto.
     */
    @Test
    public void testSetEstruturaCusto() {
        
        Textocomentario estruturaCusto = null;
        ComentarioProjeto instance = new ComentarioProjeto();
        instance.setEstruturaCusto(estruturaCusto);
    }

    /**
     * Test of getInvestimentoInicial method, of class ComentarioProjeto.
     */
    @Test
    public void testGetInvestimentoInicial() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Textocomentario expResult = null;
        instance.setInvestimentoInicial(expResult);
        Textocomentario result = instance.getInvestimentoInicial();
        assertEquals(expResult, result);
    }

    /**
     * Test of setInvestimentoInicial method, of class ComentarioProjeto.
     */
    @Test
    public void testSetInvestimentoInicial() {
        
        Textocomentario investimentoInicial = null;
        ComentarioProjeto instance = new ComentarioProjeto();
        instance.setInvestimentoInicial(investimentoInicial);
    }

    /**
     * Test of getCustoFixo method, of class ComentarioProjeto.
     */
    @Test
    public void testGetCustoFixo() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Textocomentario expResult = null;
        instance.setCustoFixo(expResult);
        Textocomentario result = instance.getCustoFixo();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCustoFixo method, of class ComentarioProjeto.
     */
    @Test
    public void testSetCustoFixo() {
        
        Textocomentario custoFixo = null;
        ComentarioProjeto instance = new ComentarioProjeto();
        instance.setCustoFixo(custoFixo);
    }

    /**
     * Test of getCustoVariavel method, of class ComentarioProjeto.
     */
    @Test
    public void testGetCustoVariavel() {
        
        ComentarioProjeto instance = new ComentarioProjeto();
        Textocomentario expResult = null;
        instance.setCustoVariavel(expResult);
        Textocomentario result = instance.getCustoVariavel();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCustoVariavel method, of class ComentarioProjeto.
     */
    @Test
    public void testSetCustoVariavel() {
        
        Textocomentario custoVariavel = null;
        ComentarioProjeto instance = new ComentarioProjeto();
        instance.setCustoVariavel(custoVariavel);
    }
}
