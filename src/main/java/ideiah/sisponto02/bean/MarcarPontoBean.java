package ideiah.sisponto02.bean;

import ideiah.sisponto02.dao.PersistenciaFuncionario;
import ideiah.sisponto02.dao.PersistenciaPonto;
import ideiah.sisponto02.modelo.Funcionario;
import ideiah.sisponto02.modelo.Ponto;
import java.util.Date;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 * Classe responsável por realizar o controle da funcionalidade marcarPonto.
 *
 * @author Jonas Chagas, Eduardo Amaral
 */
@ManagedBean(name = "beanMarcarPonto")
@ApplicationScoped
public class MarcarPontoBean {

    private Funcionario funcionario;
    private String codigo_acesso;
    private String atividadeRealizada;
    private Date horaEntrada;
    private Date horaSaida;
    private PersistenciaFuncionario persisteFuncionario;
    private PersistenciaPonto persistePonto;
    private Ponto ponto;

    /**
     * Método responsável por realizar as atividades necessárias para iniciar a
     * funcionalidade.
     */
    public void init() {
        funcionario = new Funcionario();
        horaEntrada = new Date();
        horaSaida = new Date();
        persisteFuncionario = new PersistenciaFuncionario();
        persistePonto = new PersistenciaPonto();
        atividadeRealizada = "";

    }

    /**
     * Método que realiza a abertura ou encerramento do ponto.
     */
    public void marcarPonto() {
        init();
        
        funcionario = this.consultaFuncionario(); // retorna algo se tiver ponto aberto
        this.ponto = new Ponto();

        if (funcionario == null) { // é pq não tem ponto aberto
            funcionario = PersistenciaFuncionario.consultarFuncionarioPorCodigodeAcesso(codigo_acesso);//busca funcionario pelo código.

            if (funcionario != null && funcionario.isAtivo()) {
                setPonto(new Ponto());
                this.entradaPonto(getPonto(), funcionario);
            }
        }
    }

    /**
     * Método executado quando o usuário não possui nenhum ponto aberto salvo no
     * sistema.
     *
     * @param ponto - Um objeto do tipo Ponto.
     * @param funcionario - O Funcionário que está realizando a abertura do
     * ponto.
     */
    public void entradaPonto(Ponto ponto, Funcionario funcionario) {

        horaEntrada = new Date();
        ponto.setEntrada(horaEntrada);
        ponto.setData(horaEntrada);
        ponto.setStatus(true);
        ponto.setFuncionario(funcionario);
        persistePonto.salvar(ponto);
        setCodigo_acesso("");
    }

    /**
     * método que marca a saída do ponto de um funcionário;
     */
    public void saidaPonto() {

        if (!"".equals(atividadeRealizada.trim())) {

            ponto = funcionario.getPontos().iterator().next();
            getPonto().setSaida(horaSaida);
            getPonto().setAtividadeRealizada(atividadeRealizada);
            getPonto().setStatus(false);
            persistePonto.alterar(getPonto());
            persisteFuncionario.alterar(funcionario);
            atividadeRealizada = "";

        }
    }

    /**
     *
     * Método responsável por buscar um funcionário com ponto aberto no sistema,
     * caso ele não possua nenhum ponto aberto é retornado um objeto NULL.
     *
     * @return Um objeto do tipo funcionário que possua um ponto aberto salvo no
     * sistema.
     */
    public Funcionario consultaFuncionario() {

        Funcionario func;
        func = PersistenciaFuncionario.consultarPontoAbertoDia(codigo_acesso, new Date());

        return func;
    }
//    public Funcionario consultaFuncionarioAtivo(){
//        
//    }

    // <editor-fold defaultstate="collapsed" desc="Get's e Set's">
    /**
     *
     * @return
     */
    public Funcionario getFuncionario() {
        return funcionario;
    }

    /**
     *
     * @param funcionario
     */
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    /**
     *
     * @return
     */
    public String getCodigo_acesso() {
        return codigo_acesso;
    }

    /**
     *
     * @param codigo_acesso
     */
    public void setCodigo_acesso(String codigo_acesso) {
        this.codigo_acesso = codigo_acesso;
    }

    /**
     *
     * @return
     */
    public String getAtividadeRealizada() {
        return atividadeRealizada;
    }

    /**
     *
     * @param atividadeRealizada
     */
    public void setAtividadeRealizada(String atividadeRealizada) {
        this.atividadeRealizada = atividadeRealizada;
    }

    /**
     *
     * @return
     */
    public Date getHoraEntrada() {
        return horaEntrada;
    }

    /**
     *
     * @param dataEntrada
     */
    public void setHoraEntrada(Date dataEntrada) {
        this.horaEntrada = dataEntrada;
    }

    /**
     *
     * @return
     */
    public Date getHoraSaida() {
        return horaSaida;
    }

    /**
     *
     * @param dataSaida
     */
    public void setHoraSaida(Date dataSaida) {
        this.horaSaida = dataSaida;
    }

    /**
     *
     * @return
     */
    public PersistenciaFuncionario getPersisteFuncionario() {
        return persisteFuncionario;
    }

    /**
     *
     * @param persisteFuncionario
     */
    public void setPersisteFuncionario(PersistenciaFuncionario persisteFuncionario) {
        this.persisteFuncionario = persisteFuncionario;
    }

    /**
     * @return the ponto
     */
    public Ponto getPonto() {
        return ponto;
    }

    /**
     * @param ponto the ponto to set
     */
    public void setPonto(Ponto ponto) {
        this.ponto = ponto;
    }

    // </editor-fold>
}
