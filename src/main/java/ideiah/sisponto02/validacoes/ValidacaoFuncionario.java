/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideiah.sisponto02.validacoes;

import ideiah.sisponto02.dao.PersistenciaFuncionario;
import ideiah.sisponto02.modelo.Funcionario;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Valida as informações de um funcionário e preenche as variáveis para que se
 * possa saber o que deu errado.
 *
 * @author Jonas Chagas
 */
public class ValidacaoFuncionario {

    public static final boolean FUNCIONARIO_EXISTE = true;
    public static final boolean FUNCIONARIO_NAO_EXISTE = false;
    public static final boolean VALIDACAO_EDITAR = true;
    public static final boolean VALIDACAO_CRIAR = false;

    private Funcionario funcionario;
    private PersistenciaFuncionario bd;
    private boolean cpfExiste;
    private boolean cpfInvalido;
    private boolean rgExiste;
    private boolean codigoAcessoExiste;
    private boolean matriculaExiste;
    private boolean codigoAcessoErrado;
    private boolean codigoAcessoNaoTemNumero;

    /**
     * Cria um objeto ValidacaoFuncionario, validando se o usuáiro pode ser criado
     * @param funcionario funcionário para se validar
     */
    public ValidacaoFuncionario(Funcionario funcionario) {
        bd = new PersistenciaFuncionario();
        cpfExiste = false;
        rgExiste = false;
        codigoAcessoExiste = false;
        matriculaExiste = false;
        codigoAcessoErrado = false;
        cpfInvalido = false;
        codigoAcessoNaoTemNumero =false;
        this.funcionario = funcionario;
        validar(VALIDACAO_CRIAR);
    }

    /**
     * Cria um objeto ValidacaoFuncionario, validando se o usuáiro pode
     * ser criado ou editado. Isso irá depender do tipo de validação selecionada.
     * Dessa forma a validação será focada na edição(true) ou na criação(false).
     * @param funcionario funcionário para se validar
     * @param tipoValidacao tipo de validação a ser feita(Para facilitar,
     * utilizar constantes VALIDACAO_EDITAR e VALIDACAO_CRIAR).
     */
    public ValidacaoFuncionario(Funcionario funcionario, boolean tipoValidacao) {
        bd = new PersistenciaFuncionario();
        cpfExiste = false;
        rgExiste = false;
        codigoAcessoExiste = false;
        matriculaExiste = false;
        codigoAcessoErrado = false;
        cpfInvalido = false;
        codigoAcessoNaoTemNumero =false;
        this.funcionario = funcionario;
        validar(tipoValidacao);
    }

    /**
     * método que valida os campos de um funcionário
     *
     * @param tipoValidacao tipo de valdidação a ser realizada
     */
    public void validar(boolean tipoValidacao) {
        validaCodigoAcesso(tipoValidacao);
        validarCpf(tipoValidacao);
        validarRg(tipoValidacao);
        validarMatricula(tipoValidacao);
    }

    /**
     * Valida se o código de acesso existe e se ele é válido
     */
    private void validaCodigoAcesso(boolean tipoValidacao) {
        ValidacaoCodigoDeAcesso validacodigo = new ValidacaoCodigoDeAcesso();
        Funcionario encontrado = bd.consultarFuncionario("codigoAcesso", funcionario.getCodigoAcesso(), Funcionario.class);

        try {
            validacodigo.validate(funcionario.getCodigoAcesso());
        } catch (ExcecoesValidacao ex) {
            if(ex.getMessage().equals("O campo deve conter pelo menos um número")){
                codigoAcessoNaoTemNumero = true;
            }else{
                codigoAcessoErrado = true;
            }
        }

        if (encontrado != null && tipoValidacao == VALIDACAO_EDITAR) {
            codigoAcessoExiste = funcionario.getIdfuncionario() != encontrado.getIdfuncionario();
        }else if(encontrado != null){
            codigoAcessoExiste = true;
        }
    }

    /**
     * Valida se o cpf existe e se ele é válido.
     */
    private void validarCpf(boolean tipoValidacao) {
        String cpf;
        Funcionario encontrado = bd.consultarFuncionario("cpf", funcionario.getCpf(), Funcionario.class);
        cpf = funcionario.getCpf();

        if (encontrado != null && tipoValidacao == VALIDACAO_EDITAR) {
            cpfExiste = funcionario.getIdfuncionario() != encontrado.getIdfuncionario();
        }else if(encontrado != null){
            cpfExiste = true;
        }

        if (!CpfUtil.isValidCPF(cpf)) {
            cpfInvalido = true;
        }
    }

    /**
     * Valida se o rg existe
     */
    private void validarRg(boolean tipoValidacao) {
        Funcionario encontrado = bd.consultarFuncionario("rg", funcionario.getRg(), Funcionario.class);
        if (encontrado != null && tipoValidacao == VALIDACAO_EDITAR) {
            rgExiste = funcionario.getIdfuncionario() != encontrado.getIdfuncionario();
        }else if(encontrado != null){
            rgExiste = true;
        }
    }

    /**
     * Valida se a matrícula existe
     */
    private void validarMatricula(boolean tipoValidacao) {
        Funcionario encontrado = bd.consultarFuncionario("matricula", funcionario.getMatricula(), Funcionario.class);
        if (encontrado != null && tipoValidacao == VALIDACAO_EDITAR) {
            matriculaExiste = funcionario.getIdfuncionario() != encontrado.getIdfuncionario();
        }else if(encontrado != null){
            matriculaExiste = true;
        }
    }

    /**
     * Verifica se o funcionário passa pela validação
     *
     * @return true se o funcionário passou por todas as validações
     */
    public boolean verificaFuncionario() {
        return !(cpfExiste || cpfInvalido || rgExiste || codigoAcessoErrado
                || codigoAcessoExiste || matriculaExiste  || codigoAcessoNaoTemNumero);
    }

    /**
     * @return the cpfExiste
     */
    public boolean isCpfExiste() {
        return cpfExiste;
    }

    /**
     * @return the rgExiste
     */
    public boolean isRgExiste() {
        return rgExiste;
    }

    /**
     * @return the codigoAcessoExiste
     */
    public boolean isCodigoAcessoExiste() {
        return codigoAcessoExiste;
    }

    /**
     * @return the matriculaExiste
     */
    public boolean isMatriculaExiste() {
        return matriculaExiste;
    }

    /**
     * @return the codigoAcessoErrado
     */
    public boolean isCodigoAcessoErrado() {
        return codigoAcessoErrado;
    }

    /**
     * @return the cpfInvalido
     */
    public boolean isCpfInvalido() {
        return cpfInvalido;
    }

    /**
     * @return the codigoAcessoNaoTemNumero
     */
    public boolean isCodigoAcessoNaoTemNumero() {
        return codigoAcessoNaoTemNumero;
    }

    /**
     * @param codigoAcessoNaoTemNumero the codigoAcessoNaoTemNumero to set
     */
    public void setCodigoAcessoNaoTemNumero(boolean codigoAcessoNaoTemNumero) {
        this.codigoAcessoNaoTemNumero = codigoAcessoNaoTemNumero;
    }

}
