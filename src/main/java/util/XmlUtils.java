/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import Interfaz.IConsultaSql;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.DataBase;
import main.DataBasePostGre;

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

    public static ResultSet obtenerUltimaPresentacionVigente(BigDecimal nroDocumento) {
        String query = IConsultaSql.consulta_utlima_preentacion + nroDocumento;
        return DataBasePostGre.getInstance(true).consulta(query);

    }

    public static String obtenerConceptoDeduccAdmitida(int code, DataBase db) {
        String sql = IConsultaSql.consulta_recuperacion_concepto_deuccion + code;
        ResultSet rs = db.consulta(sql);
        try {
            if (rs.next()) {
                String concepto = rs.getString("concepto");
                System.out.println("concepto es: " + concepto);
                return concepto;
            } else {
                System.out.println("No se encontró ningún cliente con el DNI proporcionado.");
            }
        } catch (SQLException ex) {
            System.out.println("no pude recuperar cod consulta");
            //Logger.getLogger(XmlUtils.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "vacio";
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

    public static int obtenerCodParentesto(int cod) {
        String contarRegistrosSQL = "SELECT codfam FROM \"TablasDelSistema\".parentesco WHERE codigo = " + cod;
        ResultSet rs = DataBasePostGre.getInstance(true).consulta(contarRegistrosSQL);
        try {
            if (rs.next()) {
                int codfam = rs.getInt("codfam");
                System.out.println("codParentesto es: " + codfam);
                return codfam;
            } else {
                System.out.println("No se encontró ningún cliente con el DNI proporcionado.");
            }
        } catch (SQLException ex) {
            System.out.println("no pude recuperar cod consulta");
            //Logger.getLogger(XmlUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public static int obtenerMesActual() {
        return LocalDate.now().getMonthValue();
    }
}
