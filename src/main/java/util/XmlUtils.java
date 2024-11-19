/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import Interfaz.IConsultaSql;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.DataBase;
import main.DataBasePostGre;
import org.postgresql.translation.messages_bg;

/**
 *
 * @author dgc06
 */
public class XmlUtils {

    public static boolean ExisteEtiqueta(Object obj) {
        // Lógica para determinar si es Sección B
        return obj != null;
    }

    public static boolean isMesInicioEqualSMesFIN(int mesInicio, int mesFin) {
        return mesInicio == mesFin;
    }

    public static Date StringADate(String fecha) {
        LocalDate localDate = LocalDate.parse(fecha);
        return Date.valueOf(localDate);
    }

    public static String obtenerCuitConGuion(String cuit) {
        if (cuit.length() != 11) {
            throw new IllegalArgumentException("El CUIT debe tener 11 dígitos.");
        }

        // Formatear el CUIT agregando los guiones
        return cuit.substring(0, 2) + "-"
                + cuit.substring(2, 10) + "-"
                + cuit.substring(10, 11);

    }

    public static int obtenerCodEmpresa(String cuit, DataBase db) throws SQLException {

        String sql = IConsultaSql.consulta_cod_empresa + "'" + obtenerCuitConGuion(cuit) + "'";
        ResultSet rs = db.consulta(sql);
       
            if (rs.next()) {
                int codEmp = rs.getInt("codemp");
                System.out.println("codEmp es: " + codEmp);
                return codEmp;
            } else {
                System.out.println("No se encontró codEmp con el cuil: " + cuit);
            }
        

        return 1;
    }
    public static boolean esPresentCargadaPosteriorPresentVigente(int periodoPresentVigente , int nroPresVigente, int periodoPresentCargada,int nroPresCargada ){
        return (periodoPresentCargada == periodoPresentVigente && nroPresCargada >= nroPresVigente);
    }
    
    public static ResultSet obtenerUltimaPresentacionVigente(BigDecimal nroDocumento) {
        String query = IConsultaSql.consulta_utlima_preentacion + nroDocumento;
        return DataBasePostGre.getInstance(true).consulta(query);

    }

    public static String obtenerConceptoDeduccAdmitida(int code, DataBase db) throws SQLException, Exception {
        String sql = IConsultaSql.consulta_recuperacion_concepto_deuccion + code;
        ResultSet rs = db.consulta(sql);
    
            if (rs.next()) {
                String concepto = rs.getString("concepto");
                System.out.println("concepto es: " + concepto);
                return concepto;
            } else {
                System.out.println("No se encontró ningún cliente con el DNI proporcionado.");
                throw new Exception("No se pudo obtner concepto de la deducion con el codigo: ."+code);
            }
      
    }

    public static Date obtenerFechaActual() {
        Date sqlDate = Date.valueOf(LocalDate.now());
        return sqlDate;
    }

    public static String obtenerNombreYApellido(String nombre, String apellido) {
        if (nombre != "") {
            return apellido + " " + nombre;
        }
        return apellido;
    }

    public static String obtenerDni(String cuit) {
        return cuit.substring(2, 10);
    }

    public static int obtenerCodParentesto(int cod) throws SQLException, Exception {
        String contarRegistrosSQL = "SELECT codfam FROM \"TablasDelSistema\".parentesco WHERE codigo = " + cod;
        ResultSet rs = DataBasePostGre.getInstance(true).consulta(contarRegistrosSQL);
     
            if (rs.next()) {
                int codfam = rs.getInt("codfam");
                System.out.println("codParentesto es: " + codfam);
                return codfam;
            } else {
                System.out.println("No se encontró ningún cliente con el DNI proporcionado.");
                throw new Exception("No se pudo obtener el Codigo de parententesco");
            }
      
  
    }

    public static int obtenerMesActual() {
        return LocalDate.now().getMonthValue();
    }

    public static  java.sql.Date convertirAStringToFecha(String fecha) throws ParseException {

        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date fechaUtil = formato.parse(fecha);
        java.sql.Date fechaSQL = new java.sql.Date(fechaUtil.getTime());
        // Convertir String a Date
        return fechaSQL;

    }
}
