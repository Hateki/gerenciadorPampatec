package ideiah.sisponto02.dao;

import ideiah.sisponto02.modelo.Funcionario;
import ideiah.sisponto02.modelo.Ponto;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Classe responsável por realizar a persistência da classe Funcionario.
 *
 * @author Jonas Chagas
 */
public class PersistenciaPonto extends Persistencia {

    
    List list;
    
    /**
     * Método que salva um objeto da classe Ponto no banco de dados.
     *
     * @param ponto - O objeto ponto a ser salvo.
     */
    public void salvarPonto(Ponto ponto) {

        this.salvar(ponto);

    }

    /**
     * Método que altera um objeto da classe Ponto no banco de dados.
     *
     * @param ponto - O objeto ponto a ser alterado.
     */
    public void alterarPonto(Ponto ponto) {
        
        this.alterar(ponto);
    }

    /**
     * Método que exclui um objeto da classe Ponto no banco de dados.
     *
     * @param ponto - O objeto ponto a ser excluido.
     */
    public void excluirPonto(Ponto ponto){
        
        this.excluir(ponto);
    }
    
     /**
     * Método que busca uma lista de objetos da classe Ponto no banco de dados.
     * 
     * @return Uma lista com todos os objetos da classe Ponto salvos no banco.
     */
    public List consultarListaPonto(){
        
        list =  this.buscaLista(Ponto.class);
        return list;
    }
    
    /**
     * Método que busca um Funcionário através do seu código de acesso.
     *
     * @param codigoAcesso - O código de acesso que representa o funcionário.
     * @return - Um objeto da classe Funcionario que contenha o codigo de acesso especificado.
     */
    public Ponto consultarPontoPorId(int id) {
        Session session;
        session = ConexaoHibernate.getInstance();
        Transaction tx = null;

        Ponto ponto = null;

        try {

            Query q;

            tx = session.beginTransaction();

            q = session.createQuery("FROM Ponto as p where p.idponto=:id");

            q.setParameter("id", id);

            List resultados = q.list();

            if (resultados.size() > 0) {
                ponto = (Ponto) resultados.get(0);
            }

            return ponto;

        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
            return ponto;

        } finally {
            session.close();
        }
    }
}
