
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tablas;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.DataBase;

/**
 *
 * @author dgc06
 */
public class Remunera extends Tabla {

    private final DataBase db;

    public Remunera(DataBase db) {
        this.db = db;
    }

    @Override
    public boolean isGenerable() {
        return true;
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void insertRemuera(int mes, int periodo) throws SQLException {

        String query = "insert into remunera (SELECT CODEMP,SEG, DOCUMENTO , TLIQ, TIPOLIQ CODLIQ,"
                + "CASE WHEN C.PRORRATEA = 1 OR T.PRORRATEA=1 THEN 1 ELSE 0 END  AS PRO ,"
                + "TIPOIGG CONCEPTO, MONTO , MESP,"
                + "CASE WHEN nmesdev < " + periodo + " then 0 else"
                + "CASE WHEN NMESDEV = " + periodo + " THEN 1   ELSE  cast(substring(cast(NMESDEV as text ),5,6)as numeric)"
                + "+1 END"
                + "END MESD , NMESDEV"
                + "FROM KIMPGAN K LEFT JOIN TIPOLIQ T  ON K.TLIQ=T.CODLIQ"
                + "LEFT JOIN CONCEPTOS C ON TIPOIGG= CONCEPTO"
                + "Where TLIQ<> 90  AND K.MESP = " + mes
                + " ORDER BY MESD)";

        db.Update(query);

    }

    private void actualizarLiquidacionProrrateada(int mes) throws SQLException {
        //:PARA LIQUIDACIONES QUE PRORRATEA IGUALO MESDEVENGADO A MES PAGADDO
        String query = "Update REMUNERA "
                + "Set MESD = MESP "
                + "WHERE  TLIQ IN (SELECT CODLIQ FROM TIPOLIQ Where PRORRATEA = 1 ) AND MESP = " + mes;
        int Update = db.Update(query);

    }

    private void generarRemunera() {
        try {
            int mes = 10;
            int periodo = 202410;
            insertRemuera(mes, periodo);
            actualizarLiquidacionProrrateada(mes);
            insertSac1AsignarMesDevengadoJunio(mes, periodo);

        } catch (SQLException ex) {
            Logger.getLogger(Remunera.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void generar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void clean() {
        String query = "delete from remunera";
        try {
            db.getPreparedStatement(query).executeUpdate();

            //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        } catch (SQLException ex) {
            Logger.getLogger(Remunera.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void insertSac1AsignarMesDevengadoJunio(int mes, int periodo) throws SQLException {
        String query = "INSERT INTO kimpgan (SELECT CODEMP,SEG, DOCUMENTO, TLIQ, TIPOLIQ CODLIQ,"
                + "CASE WHEN C.PRORRATEA = 1 OR T.PRORRATEA=1 THEN 1 ELSE 0 END  AS PRO ,"
                + "TIPOIGG CONCEPTO, MONTO , MESP,"
                + "CASE WHEN nmesdev < " + periodo + " then 0 else "
                + "CASE WHEN NMESDEV = " + periodo + "  THEN 1 ELSE cast(substring(cast(NMESDEV as text ),5,6)as numeric)  END "
                + "END MESD , NMESDEV "
                + "FROM KIMPGAN K LEFT JOIN TIPOLIQ T  ON K.TLIQ=T.CODLIQ "
                + "LEFT JOIN CONCEPTOS C ON TIPOIGG= CONCEPTO "
                + "Where TLIQ=90  AND K.MESP = " + mes
                + " ORDER BY MESD )";

        db.Update(query);
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }



}
