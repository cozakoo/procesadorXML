/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author dgc06
 */
public class DataBaseAS400 extends DataBase{
    private static DataBaseAS400 instance = null;
    @Override
    public void inicializar(String modo) throws SQLException, Exception {
       dotenv = Dotenv.load();
       Class.forName("com.ibm.as400.access.AS400JDBCDriver");
        if ("server".equals(modo)) {
            connection = DriverManager.getConnection(dotenv.get("DB_URL"), dotenv.get("DB_USER"), dotenv.get("DB_PASS"));
            stmt = connection.createStatement();
        } else {

            connection = DriverManager.getConnection(dotenv.get("DB_URL"), dotenv.get("DB_USER"), dotenv.get("DB_PASS"));
            stmt = connection.createStatement();

        }
    }

    public static DataBase getInstance(boolean isClient) {
      if (instance == null) {
            instance = new DataBaseAS400();
        }
        return instance;
    }
    
}
