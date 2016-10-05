package ideiah.sisponto02.dao;

import ideiah.sisponto02.modelo.Funcionario;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 * Classe responsável por realizar a persistência da classe Funcionario.
 *
 * @author Jonas Chagas, Eduardo Amaral
 */
public class PersistenciaFuncionario extends Persistencia {

    private Funcionario funcionario;
    private List list;

    public PersistenciaFuncionario() {
    }

    /**
     * Método que busca uma lista de funcionários
     *
     * @return Uma lista da classe List contendo todos os funcionários
     * cadastrados.
     */
    public List consultarListaFuncionario() {

        list = this.buscaLista(Funcionario.class);
        return list;
    }

    /**
     * Método que altera um funcionário.
     *
     * @param funcionario - O funcionário a ser alterado.
     */
    public void alterarFuncionario(Funcionario funcionario) {

        this.alterar(funcionario);

    }

    /**
     * Método que exclui um funcionário.
     *
     * @param funcionario
     * @return
     */
    public boolean excluirFuncionario(Funcionario funcionario) {

        boolean result = this.excluir(funcionario);

        return result;
    }

    /**
     * Método que altera um funcionário.
     *
     * @return boolean
     * @param funcionario - O funcionário a ser alterado.
     */
    public boolean cadastrarFuncionario(Funcionario funcionario) {

        //consultarFuncionarioPorCodigodeAcesso(funcionario.getCodigoAcesso());
        boolean result = salvar(funcionario);

        return result;

    }

    /**
     * Método que consulta um objeto Funcionário à partir da escolha da coluna e
     * do valor escolhido.
     *
     * @param coluna - Coluna que será analisada para ver se encontra o valor
     * desejado.
     * @param valor - Valor desejado que seja encontrado na coluna.
     * @param classe - A classe da tabela em que será buscada.
     * @return Um objeto do tipo funcionário.
     */
    public Funcionario consultarFuncionario(String coluna, String valor, Class classe) {

        Session session = ConexaoHibernate.getInstance();
        Transaction tx = null;
        try {
            if (classe != null) {
                Funcionario objeto = (Funcionario) session.createCriteria(classe).add(Restrictions.eq(coluna, valor)).uniqueResult();
                if (objeto == null) {
                    return null;
                } else {
                    return objeto;
                }
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    /**
     * Método que consulta um objeto Funcionário à partir da escolha de um id.
     *
     * @param valor - Valor desejado que seja encontrado na coluna.
     * @return Um objeto do tipo funcionário.
     */
    public Funcionario consultarFuncionarioPorId(int valor) {

        Session session = ConexaoHibernate.getInstance();
        Transaction tx = null;
        try {
            Funcionario objeto = (Funcionario) session.createCriteria(Funcionario.class).add(Restrictions.eq("idfuncionario", valor)).uniqueResult();
            if (objeto == null) {
                return null;
            } else {
                return objeto;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    /**
     * Método que busca um Funcionário através do seu código de acesso.
     *
     * @param codigoAcesso - O código de acesso que representa o funcionário.
     * @return - Um objeto da classe Funcionario que contenha o codigo de acesso
     * especificado.
     */
    public static Funcionario consultarFuncionarioPorCodigodeAcesso(String codigoAcesso) {
        Session session;
        session = ConexaoHibernate.getInstance();
        Transaction tx = null;

        Funcionario func = null;

        try {

            Query q;

            tx = session.beginTransaction();

            q = session.createQuery("FROM Funcionario as f where f.codigoAcesso=:codigoAcesso");

            q.setParameter("codigoAcesso", codigoAcesso);

            List resultados = q.list();

            if (resultados.size() > 0) {
                func = (Funcionario) resultados.get(0);
            }

            return func;

        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
            return func;

        } finally {
            session.close();
        }
    }

    /**
     * Método que busca um Funcionario específico e seu ponto aberto de todos os
     * registros pelo seu codigo de acesso
     *
     * @param codigoAcesso - O código de acesso que representa o funcionário.
     * @return - Um objeto da classe Funcionario que contenha o codigo de acesso
     * especificado e um ponto aberto.
     */
    public static Funcionario consultarPontoAberto(String codigoAcesso) {
        Session session;
        session = ConexaoHibernate.getInstance();
        Transaction tx = null;

        Funcionario func = null;

        try {

            Query q;

            tx = session.beginTransaction();

            q = session.createQuery("FROM Funcionario as f RIGHT JOIN fetch f.pontos as p where f.codigoAcesso=:codigoAcesso AND p.status=true");

            q.setParameter("codigoAcesso", codigoAcesso);

            List resultados = q.list();

            if (resultados.size() > 0) {
                func = (Funcionario) resultados.get(0);
            }

            return func;

        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
            return func;

        } finally {
            session.close();
        }
    }

    /**
     * Método que busca um Funcionario específico e seu ponto aberto pelo seu
     * codigo de acesso do dia atual.
     *
     * @param codigoAcesso - O código de acesso que representa o funcionário.
     * @return - Um objeto da classe Funcionario que contenha o codigo de acesso
     * especificado e um ponto aberto do dia.
     */
    public static Funcionario consultarPontoAbertoDia(String codigoAcesso, Date data) {
        Session session;
        session = ConexaoHibernate.getInstance();
        Transaction tx = null;

        Funcionario func = null;

        try {

            Query q;

            tx = session.beginTransaction();

            q = session.createQuery("FROM Funcionario as f RIGHT JOIN fetch f.pontos as p where f.codigoAcesso=:codigoAcesso AND p.status=true AND p.data=:data");

            q.setParameter("codigoAcesso", codigoAcesso);
            q.setParameter("data", data);

            List resultados = q.list();

            if (resultados.size() > 0) {
                func = (Funcionario) resultados.get(0);
            }

            return func;

        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
            return func;

        } finally {
            session.close();
        }
    }

    /**
     * Método que busca um Funcionario específico e seu ponto fechado pelo seu
     * codigo de acesso
     *
     * @param codigoAcesso - O código de acesso que representa o funcionário.
     * @return - Um objeto da classe Funcionario que contenha o codigo de acesso
     * especificado e um ponto aberto.
     */
    public static Funcionario consultarPontoFechado(String codigoAcesso) {

        Session session;
        session = ConexaoHibernate.getInstance();
        Transaction tx = null;

        Funcionario func = null;

        try {

            Query q;

            tx = session.beginTransaction();

            q = session.createQuery("FROM Funcionario as f RIGHT JOIN fetch f.pontos as p where f.codigoAcesso=:codigoAcesso AND p.status=false");

            q.setParameter("codigoAcesso", codigoAcesso);

            List resultados = q.list();

            if (resultados.size() > 0) {
                func = (Funcionario) resultados.get(0);
            }

            return func;

        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
            return func;

        } finally {
            session.close();
        }
    }

    /**
     * Método que busca um Funcionario específico e seu ponto fechado pelo seu
     * codigo de acesso
     *
     * @param codigoAcesso - O código de acesso que representa o funcionário.
     * @return - Um objeto da classe Funcionario que contenha o codigo de acesso
     * especificado e um ponto aberto.
     */
    public Funcionario consultarFuncionarioEndereco(String codigoAcesso) {

        Session session;
        session = ConexaoHibernate.getInstance();
        Transaction tx = null;

        Funcionario func = null;

        try {

            Query q;

            tx = session.beginTransaction();

            q = session.createQuery("FROM Funcionario as f RIGHT JOIN fetch f.endereco as e where f.codigoAcesso=:codigoAcesso");

            q.setParameter("codigoAcesso", codigoAcesso);

            List resultados = q.list();

            if (resultados.size() > 0) {
                func = (Funcionario) resultados.get(0);
            }

            return func;

        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
            return func;

        } finally {
            session.close();
        }
    }

    /**
     * MÃ©todo que busca um Funcionario especÃ­fico e seu ponto fechado pelo seu
     * codigo de acesso
     *
     * @param codigoAcesso - O cÃ³digo de acesso que representa o funcionÃ¡rio.
     * @return - Um objeto da classe Funcionario que contenha o codigo de acesso
     * especificado e um ponto aberto.
     */
    public static Funcionario consultarFuncionarioPonto(String codigoAcesso) {

        Session session;
        session = ConexaoHibernate.getInstance();
        Transaction tx = null;

        Funcionario func = null;

        try {

            Query q;

            tx = session.beginTransaction();

            q = session.createQuery("FROM Funcionario as f RIGHT JOIN fetch f.pontos as p where f.codigoAcesso=:codigoAcesso");

            q.setParameter("codigoAcesso", codigoAcesso);

            List resultados = q.list();

            if (resultados.size() > 0) {
                func = (Funcionario) resultados.get(0);
            }

            return func;

        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
            return func;

        } finally {
            session.close();
        }
    }
}
