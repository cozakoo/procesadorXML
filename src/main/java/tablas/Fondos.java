/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tablas;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.DataBase;
import util.Mensaje;

/**
 *
 * @author dgc06
 */
public class Fondos extends Tabla {

    private File file;
    private String concepto;
    private int saf;
    private BigDecimal montoClas = new BigDecimal(0);
    private DataBase db;

    public Fondos(File file, String concepto, int saf, DataBase db) {
        this.file = file;
        this.concepto = concepto;
        this.saf = saf;
        this.db = db;
    }

    @Override
    public boolean isGenerable() {
        return true;
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void addtransaccion() {

    }

    private void addTrancFondo(String concepto, int saf, int mes, int mes_sue, String linea, PreparedStatement pstmt) throws SQLException {
        String dni = obtenerDni(linea);
        String monto = obtenerMonto(linea);
        int i = 0;
        int rango = 0;
        int tipoSue = 0;
        System.out.println("dni: " + dni);
        System.out.println("monto: " + monto);

        montoClas = new BigDecimal(monto).add(montoClas);
        //tener
        double mont = Double.parseDouble(monto);

        pstmt.setInt(++i, Integer.parseInt(dni));
        pstmt.setInt(++i,saf );
        pstmt.setInt(++i, mes);
        pstmt.setString(++i, concepto);
        pstmt.setDouble(++i, mont);
        pstmt.setInt(++i,tipoSue );
        pstmt.setString(++i, "");
       
        pstmt.setInt(++i, rango);
        pstmt.setInt(++i,mes_sue);
        pstmt.setInt(++i,mes_sue);
        pstmt.setInt(++i,mes_sue);
        pstmt.setString(++i, "");
        
        pstmt.addBatch();
    }

    @Override
    public void generar() {

        int mes = 10;
        int mes_sue = 202410;
        if (file.exists()) {

            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
               String linea;
               Connection conexion = db.getConection();
                try {
                    // Leer el archivo línea por línea hasta llegar al final
                    
                    conexion.setAutoCommit(false);
                    PreparedStatement pstmt = prepararTranscacion();
                    while ((linea = br.readLine()) != null) {

                        addTrancFondo(concepto, saf, mes, mes_sue, linea, pstmt);
              
                    }
                    
                    pstmt.executeBatch();
                    registrarImportacion();
                    Mensaje.exito("fondos importados con exito");
                    
                } catch (SQLException ex) {
                    try {
                        //co
                        
                        conexion.rollback();
                        Logger.getLogger(Fondos.class.getName()).log(Level.SEVERE, null, ex);
                        conexion.setAutoCommit(true);
                    } catch (SQLException ex1) {
                        Logger.getLogger(Fondos.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                  
                }
                try {
                    conexion.setAutoCommit(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Fondos.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("total; " + montoClas);

            } catch (IOException e) {
                e.printStackTrace();  // Manejo de excepciones
            }
        }
        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void clean() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private String obtenerDni(String linea) {
        return linea.substring(2, 2 + 8);
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private String obtenerMonto(String linea) {
        return linea.substring(41, 41 + 12);
        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private PreparedStatement prepararTranscacion() throws SQLException {
        String query = "INSERT INTO fondossaf (documento, codemp, mes, concepto, monto, tiposue, mesc, rango, mes_sis, mes_sue, mes_perc, blanco) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt = db.getPreparedStatement(query);
        return pstmt;
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void registrarImportacion() throws SQLException {
        Date fecha = util.XmlUtils.obtenerFechaActual();
        
        String query = "INSERT INTO historial_carga_fondos (nombre_archivo, fecha_carga) VALUES (?,?)";
        
        PreparedStatement pstmt = db.getPreparedStatement(query);
        
        pstmt.setString(1,file.getName() );
        pstmt.setDate(2,fecha );
        pstmt.executeUpdate();
        
       //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
