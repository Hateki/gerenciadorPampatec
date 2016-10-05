package ideiah.sisponto02.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * Classe responsável por iniciar uma nova conexão com o banco.
 *
 * @author Jonas Chagas, Eduardo Amaral
 */
public class ConexaoHibernate {
    
    private static final SessionFactory sessionFactory;
    private static final ThreadLocal<Session> threaLocal = new ThreadLocal<Session>();

    static {
        try {
            sessionFactory = new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable e) {
            System.err.println("\n\n\n --------Erro na fábrica de sessões do hibernate-------- \n\n\n");
            e.printStackTrace();
            System.err.println("\n\n\n --------Fim do erro na fábrica de sessões do hibernate-------- \n\n\n");

            throw new ExceptionInInitializerError(e);
        }

    }
    
    /**
     * Método que abre uma sessão junto ao banco de dados
     * @return Um objeto do tipo Session que contém a sessão aberta do banco.
     */
    public static Session getInstance(){
        Session session = (Session) threaLocal.get();
        session = sessionFactory.openSession();
        threaLocal.set(session);
        return session;
    }
    
}
