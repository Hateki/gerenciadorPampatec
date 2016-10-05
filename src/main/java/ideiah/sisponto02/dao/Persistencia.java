/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideiah.sisponto02.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Jonas Chagas
 */
public abstract class Persistencia {

    /**
     * método que salva um objeto no banco de dados
     *
     * @param obj
     * @return
     */
    public boolean salvar(Object obj) {

        Session session = ConexaoHibernate.getInstance();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(obj);
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    /**
     * Método que consulta um objeto
     * @param coluna
     * @param valor
     * @param classe
     * @return 
     */
    public Object consultar(String coluna, String valor, Class classe) {

        Session session = ConexaoHibernate.getInstance();
        Transaction tx = null;
        try {
            if (classe != null) {
                Object objeto = session.createCriteria(classe).add(Restrictions.eq(coluna, valor)).uniqueResult();
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
     * Método que altera de um objeto
     *
     * @param obj
     * @return
     */
    public boolean alterar(Object obj) {

        Session session = ConexaoHibernate.getInstance();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(obj);
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }
    
     /**
     * Método que realiza a exclusão de um objeto
     *
     * @param obj
     * @return
     */
    public boolean excluir(Object obj) {

        Session session = ConexaoHibernate.getInstance();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.delete(obj);
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }
    
    /**
     * método que busca uma lista de objetos conforme a classe que é passada.
     * @param classe
     * @return 
     */
     public List<?> buscaLista(Class<?> classe) {

        Session session = ConexaoHibernate.getInstance();
        Transaction tx = null;
        try{
        tx = session.beginTransaction();
        Criteria crit = session.createCriteria(classe);
        crit.setFirstResult(0);
        List list = crit.list();
        List<?> lista = (List<?>) list;
        return lista;
        }catch(Exception e){
          e.printStackTrace();
        }finally{
            session.close();
        }
        return null;
    }
}
