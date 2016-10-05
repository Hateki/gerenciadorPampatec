package migracaoDados;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class ConectaDB {

    private static ConectaDB myInstance;
    private static final String URL_DATABASE = "jdbc:mysql://localhost:3306/sisponto";
    private static final String USER_BANCO = "root";
    private static final String PASS_BANCO = "";
    private Connection con;

    private ConectaDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.con = (Connection) DriverManager.getConnection(URL_DATABASE, USER_BANCO, PASS_BANCO);
        } catch (SQLException sql) {
            sql.printStackTrace();
        } catch (ClassNotFoundException classNotException) {
            classNotException.printStackTrace();
        }
    }

    public static ConectaDB getInstance() {
        if (myInstance == null) {
            myInstance = new ConectaDB();
        }
        return myInstance;
    }

    public void encerrarConexao() {
        try {
            if (this.con != null) {
                this.con.close();
                myInstance = null;
            }
        } catch (SQLException sql) {
            sql.printStackTrace();
        }
    }

    /**
     *
     * @return Connection
     */
    public Connection getConnection() {
        return this.con;
    }
}
