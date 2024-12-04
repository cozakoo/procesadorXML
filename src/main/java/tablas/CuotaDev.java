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
public class CuotaDev extends Tabla {

    DataBase db;

    public CuotaDev(DataBase db) {
        this.db = db;
    }

    @Override
    public boolean isGenerable() {
        return true; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void insertCuotasConceptosPorrateables(int mesp) throws SQLException {
        String query = "INSERT INTO cuotadev ( SELECT  R.CODEMP,R.SEG, R.DOCUMENTO, TLIQ, CODLIQ, PRO, trim(codliq)||'-NETO',sum(monto) /(13-mesd) ,NRO MESP,"
                + "NRO MESD, 0 NMESDEV, MESD AS MESORIGEN "
                + "FROM REMUNERA R , MESES  M "
                + "WHERE   TLIQ IN (SELECT CODLIQ FROM TIPOLIQ WHERE PRORRATEA = 1 ) AND NRO>=MESD"
                + "AND   R.MESP = "+mesp+" "
                + "GROUP BY R.CODEMP, R.SEG, R.DOCUMENTO, TLIQ, CODLIQ, PRO , NRO , MESD )";

        int Update = db.Update(query);
        
    }

    @Override
    public void generar() {
        try {
            int mesp = 10;
            insertCuotasConceptosPorrateables(mesp);
            insertConcpPorrateAleNoExistInTipoLIQ(mesp);
            
        } catch (SQLException ex) {
            Logger.getLogger(CuotaDev.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void clean() {
        try {
            String query = "delete from cuotadev";
            
            db.Update(query);
            //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        } catch (SQLException ex) {
            Logger.getLogger(CuotaDev.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void insertConcpPorrateAleNoExistInTipoLIQ(int mesp) throws SQLException {
        String query = "INSERT INTO cuotadev (SELECT  CODEMP, SEG, DOCUMENTO, TLIQ, codLIQ, PRO , CONCEPTO,  MONTO /(13-MESD ) monto ,"
                + "MESP, NRO mesd , NMESDEV, MESP mesorigen "
                + "FROM remunera R , meses M "
                + "WHERE  PRO = 1 "
                + "AND NRO>=MESD  and mesd > 0 "
                + "AND TLIQ  NOT IN (SELECT CODLIQ FROM TIPOLIQ WHERE PRORRATEA =1 ) "
                + "AND R.MESP = " + mesp;
        
        db.Update(query);
    }

}
