/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideiah.sisponto02.bean;

import ideiah.sisponto02.dao.Persistencia;
import ideiah.sisponto02.dao.PersistenciaDiretor;
import ideiah.sisponto02.dao.PersistenciaFuncionario;
import ideiah.sisponto02.modelo.Endereco;
import ideiah.sisponto02.modelo.Diretor;
import ideiah.sisponto02.modelo.Funcionario;
import ideiah.sisponto02.validacoes.ExcecoesValidacao;
import ideiah.sisponto02.validacoes.FacesUtil;
import ideiah.sisponto02.validacoes.ValidacaoCodigoDeAcesso;
import ideiah.sisponto02.validacoes.ValidacaoDiretor;
import ideiah.sisponto02.validacoes.ValidacaoExclusaoFuncionario;
import ideiah.sisponto02.validacoes.ValidacaoFuncionario;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Jonas Chagas
 */
@SessionScoped
@ManagedBean(name = "beanFuncionario")
public class FuncionarioBean {

    public static final int EH_DIRETOR = 0;
    public static final int DIRETOR_DADOS_INVALIDOS = 1;
    public static final int NAO_EH_DIRETOR = 2;

    private Funcionario funcionario;
    private PersistenciaFuncionario persistefuncionario;
    private PersistenciaDiretor persistediretor;
    private Persistencia persiste;
    private String cargoFuncionario;
    private List<Funcionario> funcionarios;
    private Diretor diretor;
    private String senhaDiretor;
    private String confirmarSenhaDiretor;
    private Date dataPosse;
    private String dataPosseString;
    private DateFormat dateFormat;
    private ValidacaoDiretor validadiretor;

    @PostConstruct
    public void init() {
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.funcionario = new Funcionario();
        this.funcionario.setEndereco(new Endereco());
        this.persistefuncionario = new PersistenciaFuncionario();
        this.persistediretor = new PersistenciaDiretor();
        this.funcionarios = new ArrayList<>();
        this.funcionarios = consultarFuncionarios();
        this.diretor = new Diretor();
        this.senhaDiretor = "";
        this.confirmarSenhaDiretor = "";
        this.dataPosseString = "";
        this.dataPosse = null;
        validadiretor = null;
        cargoFuncionario = "Desenvolvedor";
        this.funcionario.setAtivo(true);
    }

    /**
     * método que salva um funcionário tanto Diretor como Desenvolvedor.
     *
     */
    public void salvarFuncionario() {
        int resultVerificacao;

        resultVerificacao = verificaSeEhDiretor();

        if (resultVerificacao == EH_DIRETOR) { // se for diretor, faz isso.
            if (salvarAtualizarFuncionario(ValidacaoFuncionario.VALIDACAO_CRIAR)) {
                init();
            }
        } else if (resultVerificacao == NAO_EH_DIRETOR) { // se for desenvolvedor
            if (lidaDiretor(ValidacaoFuncionario.VALIDACAO_CRIAR)) {
                init();
            }
        }
    }

    /**
     * método que edita um funcionário
     *
     */
    public void editarFuncionario() {
        int resultVerificacao;

        resultVerificacao = verificaSeEhDiretor();

        if (resultVerificacao == EH_DIRETOR) { // se for diretor, faz isso.
            salvarAtualizarFuncionario(ValidacaoFuncionario.VALIDACAO_EDITAR);
        } else if (resultVerificacao == NAO_EH_DIRETOR) { // se for desenvolvedor
            if (lidaDiretor(ValidacaoFuncionario.VALIDACAO_EDITAR)) {
                dataPosseString = null;
            }
        }
    }

    private boolean lidaDiretor(boolean tipoTrasacao) {
        Diretor diretor;
        boolean resultado;

        diretor = funcionario.getDiretor();
        funcionario.setDiretor(null);
        resultado = salvarAtualizarFuncionario(tipoTrasacao);
        deletarDiretor(diretor);
        return resultado;
    }

    /**
     * Exclui um diretor de um funcionário do banco de dados.
     */
    private void deletarDiretor(Diretor diretor) {
        if (diretor != null) {
            persistediretor.excluirDiretor(diretor);
        }
    }

    /**
     * Método que verifica se o funcionário é diretor
     *
     * @return true se for, false se não.
     */
    private int verificaSeEhDiretor() {
        boolean resultadoConfigura = false;
        boolean cargoIgualDesenvolvedor = this.cargoFuncionario.equalsIgnoreCase("Desenvolvedor");

        if (cargoIgualDesenvolvedor) {//Se selecionou a opção de ser um desenvolvedor
            return NAO_EH_DIRETOR;
        } else {
            resultadoConfigura = inicializaValidacaoDiretor();
            if (!resultadoConfigura) { // Se o usuário não preencheu a data
                FacesUtil.addErrorMessage("Preencha com uma data válida", "formCadastro:datepicker");
                return DIRETOR_DADOS_INVALIDOS;
            } else if (validadiretor != null && !validadiretor.verificaDiretor()) {//Se houve algum erro na validação
                enviaFeedBackDiretor(validadiretor);
                return DIRETOR_DADOS_INVALIDOS;
            }
            return EH_DIRETOR;
        }
    }

    /**
     * Faz a inicialização do diretor e da sua validação.
     *
     * @param cargoIgualDesenvolvedor usada para saber qual o cargo escolhido
     * pelo usuário
     * @return true se a inicialização foi bem sucedida.
     */
    private boolean inicializaValidacaoDiretor() {
        if (!verificaSeFuncionarioTemDiretor()) {
            return configurarDiretor();
        } else {
            try {
                dataPosse = dateFormat.parse(dataPosseString);
                funcionario.getDiretor().setDataPosse(dataPosse);
                funcionario.getDiretor().setCargo(cargoFuncionario);
                funcionario.getDiretor().setSenha(senhaDiretor);
                validadiretor = new ValidacaoDiretor(funcionario.getDiretor(), confirmarSenhaDiretor);
            } catch (ParseException ex) {
                return false;
            }
        }
        return true;
    }

    /**
     * Verifica se um funcionário é um diretor
     *
     * @return true se ele é um diretor.
     */
    private boolean verificaSeFuncionarioTemDiretor() {
        return funcionario.getDiretor() != null;
    }

    /**
     * método que configura um diretor para um funcionário;
     *
     * @return false se ouve uma exeção de parsing de data
     */
    public boolean configurarDiretor() {

        diretor = new Diretor();

        try {
            dataPosse = dateFormat.parse(dataPosseString);

            validadiretor = new ValidacaoDiretor(dataPosse, senhaDiretor, confirmarSenhaDiretor, cargoFuncionario);

            diretor.setSenha(senhaDiretor);
            diretor.setDataPosse(dataPosse);
            diretor.setCargo(cargoFuncionario);

            funcionario.setDiretor(diretor);

        } catch (ParseException ex) {
            // erro de formato da data.
            Logger.getLogger(FuncionarioBean.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        return true;
    }

    /**
     * Método responsável de fazer solicitação para DB realizar a exclusão de um
     * Funcionário.
     *
     * @param funcionario funcionario a executar.
     * @throws ideiah.sisponto02.validacoes.ExcecoesValidacao Exceções de
     * tamanho de valor ou personalizadas
     */
    public void excluirFuncionario(Funcionario funcionario) throws ExcecoesValidacao {
        ValidacaoExclusaoFuncionario validacao = new ValidacaoExclusaoFuncionario();

        try {
            validacao.validarExclusao(funcionario);

            if (persistefuncionario.excluirFuncionario(funcionario)) {
                FacesUtil.addSuccessMessage("Sucesso",
                        "formListaFuncionarios:excluirFuncionario");
                init();
            } else {
            }

        } catch (ExcecoesValidacao e) {
            FacesUtil.addErrorMessage("Erro",
                    "formListaFuncionarios:excluirFuncionario");
        } catch (Exception e) {
            FacesUtil.addErrorMessage("ErroInesperado",
                    "formListaFuncionarios:excluirFuncionario");
        }
    }

    /**
     * Salva ou atualiza o funcionário (dependendo se ele existe ou não no
     * banco) e envia os feedbacks de acordo com os resultados.
     */
    private boolean salvarAtualizarFuncionario(boolean tipoValidacao) {
        ValidacaoFuncionario validafuncionario = new ValidacaoFuncionario(funcionario, tipoValidacao);
        boolean diretoValido = true;
        if (diretoValido && validafuncionario.verificaFuncionario()
                && criarAtualizarFuncionarioBanco(tipoValidacao)) {
            FacesUtil.addSuccessMessage("Cadastro realizado com sucesso", "formCadastro:salvarFuncionario");
            return true;
        } else {
            enviaFeedBacks(validafuncionario);
        }
        return false;
    }

    /**
     * Cria ou atualiza um funcionário no banco dependendo do tipo de transação
     * a ser feita
     *
     * @param tipoTransacao tipo de trasação a ser feita. Sendo que editar é
     * true e criar é false.
     * @return true se a trasação ocorreu com sucesso.
     */
    private boolean criarAtualizarFuncionarioBanco(boolean tipoTransacao) {
        if (tipoTransacao == ValidacaoFuncionario.VALIDACAO_CRIAR) {
            return persistefuncionario.cadastrarFuncionario(this.funcionario);
        } else {
            persistefuncionario.alterarFuncionario(funcionario);
            return true;
        }
    }

    /**
     * Preenche as mensagens para serem exibidas de acordo com a validação
     * fornecida.
     *
     * @param validacaoFuncionario validação do funcionário para se basear.
     */
    private void enviaFeedBacks(ValidacaoFuncionario validacaoFuncionario) {

        if (validacaoFuncionario.isCodigoAcessoErrado()) {
            FacesUtil.addErrorMessage("O código de acesso deve ter no máximo 15 caracteres", "formCadastro:codigoAcesso");
        } else if (validacaoFuncionario.isCodigoAcessoNaoTemNumero()) {
            FacesUtil.addErrorMessage("O código de acesso precisa ter pelo menos um número.", "formCadastro:codigoAcesso");
        } else if (validacaoFuncionario.isCodigoAcessoExiste()) {
            FacesUtil.addErrorMessage("O código de acesso já existe", "formCadastro:codigoAcesso");
        }

        if (validacaoFuncionario.isCpfInvalido()) {
            FacesUtil.addErrorMessage("O cpf é inválido", "formCadastro:cpf");
        } else if (validacaoFuncionario.isCpfExiste()) {
            FacesUtil.addErrorMessage("O cpf já existe", "formCadastro:cpf");
        }

        if (validacaoFuncionario.isRgExiste()) {
            FacesUtil.addErrorMessage("O rg já existe", "formCadastro:rg");
        }

        if (validacaoFuncionario.isMatriculaExiste()) {
            FacesUtil.addErrorMessage("A matrícula já existe", "formCadastro:matricula");
        }

    }

    /**
     *
     * @param validacaoDiretor
     */
    public void enviaFeedBackDiretor(ValidacaoDiretor validacaoDiretor) {
        boolean validaSenhasConferem = true;
        if (validacaoDiretor.isSenhaDiretorVazia()) {
            validaSenhasConferem = false;
            FacesUtil.addErrorMessage("A senha não pode estar vazia", "formCadastro:senhaDiretor1");
        }
        if (validacaoDiretor.isConfirmacaoSenhaDiretorVazia()) {
            validaSenhasConferem = false;
            FacesUtil.addErrorMessage("A senha não pode estar vazia", "formCadastro:senhaDiretor2");
        }
        if (validaSenhasConferem) {
            if (validacaoDiretor.isSenhasNaoConferem()) {
                FacesUtil.addErrorMessage("Senhas não conferem", "formCadastro:senhaDiretor1");
                FacesUtil.addErrorMessage("Senhas não conferem", "formCadastro:senhaDiretor2");
            }
        }
        if (validacaoDiretor.isDataPosteriorAAtual()) {
            FacesUtil.addErrorMessage("Data não pode ser posterior ao dia de hoje.", "formCadastro:datepicker");
        }
    }

    /**
     * método que busca uma lista de funcionários
     *
     * @return
     */
    public List consultarFuncionarios() {
        funcionarios = persistefuncionario.consultarListaFuncionario();

        return funcionarios;
    }

    public String dirCadastrar() {
        init();
        funcionario.setAtivo(true);
        return "cadastrar";
    }

    public String dirEditar(Funcionario funcionario) {
        this.funcionario = persistefuncionario.consultarFuncionarioPorId(funcionario.getIdfuncionario());
        if (funcionario.getDiretor() != null) {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            dataPosseString = df.format(funcionario.getDiretor().getDataPosse());
            cargoFuncionario = funcionario.getDiretor().getCargo();
            senhaDiretor = funcionario.getDiretor().getSenha();
            confirmarSenhaDiretor = funcionario.getDiretor().getSenha();
        } else {
            dataPosseString = null;
            cargoFuncionario = "Desenvolvedor";
        }
        return "editar";
    }

    public String dirConsultar(Funcionario funcionario) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        this.funcionario = persistefuncionario.consultarFuncionarioEndereco(funcionario.getCodigoAcesso());
        if (funcionario.getDiretor() == null) {
            cargoFuncionario = "Desenvolvedor";
            dataPosseString = null;
        } else {
            cargoFuncionario = funcionario.getDiretor().getCargo();
            dataPosseString = df.format(funcionario.getDiretor().getDataPosse());
        }
        return "consultar";
    }

    // <editor-fold defaultstate="collapsed" desc="Get's e Set's">
    public Funcionario getFuncionario() {
        return funcionario;
    }

    public String getSenhaDiretor() {
        return senhaDiretor;
    }

    public void setSenhaDiretor(String senhaDiretor) {
        this.senhaDiretor = senhaDiretor;
    }

    public String getConfirmarSenhaDiretor() {
        return confirmarSenhaDiretor;
    }

    public void setConfirmarSenhaDiretor(String confirmarSenhaDiretor) {
        this.confirmarSenhaDiretor = confirmarSenhaDiretor;
    }

    public String getCargoFuncionario() {
        return cargoFuncionario;
    }

    public void setCargoFuncionario(String cargoFuncionario) {
        this.cargoFuncionario = cargoFuncionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public List<Funcionario> getFuncionarios() {
        consultarFuncionarios();
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public Diretor getDiretor() {
        return diretor;
    }

    public void setDiretor(Diretor diretor) {
        this.diretor = diretor;
    }

    public String getDataPosseString() {
        return dataPosseString;
    }

    public void setDataPosseString(String dataPosseString) {
        this.dataPosseString = dataPosseString;
    }

    public Date getDataPosse() {
        return dataPosse;
    }

    public DateFormat getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    public ValidacaoDiretor getValidadiretor() {
        return validadiretor;
    }

    public void setValidadiretor(ValidacaoDiretor validadiretor) {
        this.validadiretor = validadiretor;
    }

    public void setDataPosse(Date dataPosse) {
        this.dataPosse = dataPosse;
    }

    // </editor-fold>
    // </editor-fold>
}
