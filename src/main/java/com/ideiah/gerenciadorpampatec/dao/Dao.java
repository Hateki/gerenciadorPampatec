package com.ideiah.gerenciadorpampatec.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Pedro
 */
public abstract class Dao {

    public static final int SALVOU = 0;
    public static final int ERRO_SALVAR = 1;
    public static final int ARQUIVO_GRANDE = 2;

    private Transaction tx = null;
    private Session session = null;

    public Dao() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    // <editor-fold defaultstate="collapsed" desc="INSERT and UPDATE"> 
    /**
     * Salva um objeto mapeado no banco de dados
     *
     * @param obj
     * @return boolean se salvou ou não
     */
    public Object salvar(Object obj) {
        Object salvo = null;
        try {
            setTx(getSession().getTransaction());
            getTx().begin();
            salvo = getSession().merge(obj);
            getTx().commit();
        } catch (Exception e) {
            e.printStackTrace();
            getSession().getTransaction().rollback();
            return null;
        }
        return salvo;
    }

    // <editor-fold defaultstate="collapsed" desc="INSERT and UPDATE"> 
    public Object update(Object obj) {

        try {
            setTx(getSession().getTransaction());
            getTx().begin();
            getSession().merge(obj);
            getTx().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            getSession().getTransaction().rollback();
            return null;
        }
        return obj;
    }
        // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="DELETE"> 
    public boolean excluir(int codigo, Class type) {
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        Transaction tx = null;
        try {
            setTx(getSession().getTransaction());
            getTx().begin();
            Object object = getSession().get(type, codigo);
            getSession().delete(object);
            getTx().commit();

        } catch (Exception e) {
            e.printStackTrace();
            getSession().getTransaction().rollback();
            return false;
        }
        return true;
    }

    public boolean excluir(String codigo, Class type) {
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        Transaction tx = null;
        try {
            setTx(getSession().getTransaction());
            getTx().begin();
            Object object = getSession().get(type, Integer.parseInt(codigo));
            getSession().delete(object);
            getTx().commit();

        } catch (Exception e) {
            e.printStackTrace();
            getSession().getTransaction().rollback();
            return false;
        }
        return true;
    }

    // <editor-fold defaultstate="collapsed" desc="SEARCH OBJECT"> 
    public Object buscarObjeto(int codigo, Class<?> classe) {
        Object objeto = null;
        Criteria criteria = getCriteria(classe);
        criteria.add(Restrictions.idEq(codigo));
        return getObject(criteria);
    }
//    METODO PARA BUSCAR QUALQUER OBJETO UNICO EM QUALQUER CLASSE, (PROPRIEDADE CHAVE, VALOR A SER COMPARADO, TABELA)

    public Object buscarObjetoCriteria(String propriedade, String valor, Class<?> classe) {
        Object objeto = null;
        Criteria criteria = getCriteria(classe);
        criteria.add(Restrictions.eq(propriedade, valor));
        return getObject(criteria);
    }

    public Object buscarObjetoCriteriaINT(String propriedade, int valor, Class<?> classe) {
        Object objeto = null;
        Criteria criteria = getCriteria(classe);
        criteria.add(Restrictions.eq(propriedade, valor));
        return getObject(criteria);
    }

    public ArrayList<?> buscarObjetosCritera(String propriedade, int valor, Class<?> classe) {
        Criteria criteria = getCriteria(classe);
        criteria.add(Restrictions.eq(propriedade, valor));
        return getObjects(criteria);
    }


    // <editor-fold defaultstate="collapsed" desc="SEARCH OBJECTS"> 
    public ArrayList<?> buscarObjetos(Class<?> classe) {
        Criteria criteria = getCriteria(classe);
        return getObjects(criteria);
    }
    // </editor-fold>

    private Object getObject(Criteria criteria) {
        Object object = criteria.uniqueResult();
//        tx.commit();
        return object;
    }

    private ArrayList<?> getObjects(Criteria criteria) {
        List list = criteria.list();
        ArrayList<?> lista = (ArrayList<?>) list;
        return lista;
    }

    private Criteria getCriteria(Class<?> classe) {
        Criteria criteria = null;
        try {
//            tx = session.beginTransaction();//cria uma transação para o hibernate conectar no banco
            criteria = getSession().createCriteria(classe);
//            tx.commit();
        } catch (Exception e) {
            if (getTx() != null) {
                getTx().rollback();
            }
            e.printStackTrace();
        }
        return criteria;
    }

    /**
     * @return the tx
     */
    public Transaction getTx() {
        return tx;
    }

    /**
     * @param tx the tx to set
     */
    public void setTx(Transaction tx) {
        this.tx = tx;
    }

    /**
     * @return the session
     */
    public Session getSession() {
        return session;
    }

    /**
     * @param session the session to set
     */
    public void setSession(Session session) {
        this.session = session;
    }
}
