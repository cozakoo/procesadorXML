/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author dgc06
 */
public abstract class DataBase {

    protected Connection connection;
    protected Statement stmt = null;
    protected PreparedStatement pstmt = null;
    protected Dotenv dotenv;
    protected String sql;

    public abstract void inicializar(String modo) throws SQLException, Exception;

    public ResultSet consulta(String query) {
        try {
            this.sql = query;
            return stmt.executeQuery(query);
        } catch (SQLException ex) {
            System.out.println("Consulta vacía");
        }
        return null;
    }
   
    
    public Connection getConection() {
        return connection;

    }

    public PreparedStatement getPreparedStatement(String sql) throws SQLException {
        return connection.prepareStatement(sql);
    }
     
    public Statement creatStatement() throws SQLException{
        return connection.createStatement();
    }
    
    public int Update(String query) throws SQLException{
        PreparedStatement ps = connection.prepareStatement(query);
        return ps.executeUpdate();
    }
    
}
