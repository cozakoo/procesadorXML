package main;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.DriverManager;

import java.sql.SQLException;


public class DataBasePostGre extends DataBase{

     private static DataBasePostGre instance = null;

    public static DataBasePostGre getInstance(boolean isClient) {
        if (instance == null) {
            instance = new DataBasePostGre();
        }
        return instance;
    }

     @Override
    public void inicializar(String modo) throws SQLException, Exception {
        dotenv = Dotenv.load();
        if ("server".equals(modo)) {
            connection = DriverManager.getConnection(dotenv.get("DB_URL"), dotenv.get("DB_USER"), dotenv.get("DB_PASS"));
            stmt = connection.createStatement();
        } else {

            connection = DriverManager.getConnection(dotenv.get("DB_URL"), dotenv.get("DB_USER"), dotenv.get("DB_PASS"));
            stmt = connection.createStatement();

        }
    }
    
    
    

}
