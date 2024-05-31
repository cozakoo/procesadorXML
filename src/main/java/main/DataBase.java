package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {

    private static DataBase instance;
    private static Connection conection = null;
    private static Statement stmt = null;
    private PreparedStatement pstmt = null;
    private String 
            sql,
            jdbcUrl = "jdbc:postgresql://192.168.10.76:5432/AlmacenXML",
            usuario = "postgres",
            contrasena = "admin";
    
    
    public static DataBase getInstance(boolean isClient) {
        if (instance == null) {
            instance = new DataBase();
        }
        return instance;
    }

    public void inicializar(String modo) throws SQLException, Exception {
        if ("server".equals(modo)) {
            conection = DriverManager.getConnection(jdbcUrl, usuario, contrasena);
            stmt = conection.createStatement();
        } else {
            jdbcUrl = "jdbc:postgresql://192.168.10.76:5432/AlmacenXML";
            conection = DriverManager.getConnection(jdbcUrl, usuario, contrasena);
            stmt = conection.createStatement();

        }
    }
    
}
