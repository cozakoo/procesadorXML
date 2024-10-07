package main;

import io.github.cdimascio.dotenv.Dotenv;
import static io.github.cdimascio.dotenv.DslKt.dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {

    private static DataBase instance;
    private static Connection conection = null;
    private static Statement stmt = null;
    private PreparedStatement pstmt = null;
    private Dotenv dotenv;
    private String sql;

    public static DataBase getInstance(boolean isClient) {
        if (instance == null) {
            instance = new DataBase();
        }
        return instance;
    }

    public void inicializar(String modo) throws SQLException, Exception {
        dotenv = Dotenv.load();
        if ("server".equals(modo)) {
            conection = DriverManager.getConnection(dotenv.get("DB_URL"), dotenv.get("DB_USER"), dotenv.get("DB_PASS"));
            stmt = conection.createStatement();
        } else {

            conection = DriverManager.getConnection(dotenv.get("DB_URL"), dotenv.get("DB_USER"), dotenv.get("DB_PASS"));
            stmt = conection.createStatement();

        }
    }
    
      public ResultSet consulta(String query) {
        try {
            this.sql = query;
            return stmt.executeQuery(query);
        } catch (SQLException ex) {
            System.out.println("Consulta vacía");
        }
        return null;
    }
      
    public PreparedStatement getPreparedStatement(String sql) throws SQLException {
        return conection.prepareStatement(sql);
    }
    
    

}
