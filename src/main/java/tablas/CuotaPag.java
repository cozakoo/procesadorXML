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
public class CuotaPag extends Tabla {

    private DataBase db;
    public CuotaPag(DataBase db) {
        this.db = db;
    }
    
    
    
    
    
    @Override
    public boolean isGenerable() {
        return true;
    }

    public void insertCuotaPag(int mesP) throws SQLException {
    String query = "INSERT INTO cuotapag ( SELECT  R.CODEMP,R.SEG, R.DOCUMENTO, TLIQ, CODLIQ, PRO, trim(codliq)||'-NETO',sum(monto) /(13-mesd) ,NRO MESP,\"\n"
                + "NRO MESD, 0 NMESDEV, MESD AS MESORIGEN "
                + "FROM REMUNERA R , MESES  M "
                + "WHERE   TLIQ IN (SELECT CODLIQ FROM TIPOLIQ WHERE PRORRATEA = 1 ) AND NRO>=MESD"
                + "AND   R.MESP =" + mesP + " "
                + "GROUP BY R.CODEMP, R.SEG, R.DOCUMENTO, TLIQ, CODLIQ, PRO , NRO , MESD )";
                
    int Update = db.Update(query);
    }

    @Override
    public void generar() {
        try {
            insertCuotaPag(10);
        } catch (SQLException ex) {
            Logger.getLogger(CuotaPag.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void clean() {
        try {
            String query = "delete from cuotapag";
            db.Update(query);
            //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        } catch (SQLException ex) {
            Logger.getLogger(CuotaPag.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
