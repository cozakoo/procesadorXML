/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tablas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.DataBase;
import util.SqlUtils;

/**
 *
 * @author dgc06
 */
public class KimpaGrup extends Tabla {

    private DataBase db;

    public KimpaGrup(DataBase db) {

        this.db = db;
    }

    @Override
    public boolean isGenerable() {
        //consulta verifica si conceptos no existe
        String query = "select DISTINCT e.l_dley, e.l_dconc from ene24 as e "
                + "left join concparam as c "
                + "on e.l_dley = c.ley and e.l_dconc = c.conc "
                + "WHERE (c.ley IS NULL OR c.conc is NULL) AND e.l_dconc < 2700 ";

        return SqlUtils.isConsultaVacia(query, db);

    }

    public void generarKimpG(String mesSue, String mes_dev, String mes, String workingTable) {
        try {
            String query = "insert into kimpagrup select codemp "
                    + ", l_seg, CAST( SUBSTRING(CAST( l_mlega AS TEXT) FROM 4 FOR 8) as numeric) "
                    + "documento,l_mayn nombre, l_tliq, tipoigg, sum(l_dimp)," + mesSue + " mes_sue, "
                    + "RIGHT(p.l_ddesc,6)mes_dev," + mes + " mes "
                    + "from (select * from " + workingTable + " as e left join concparam as c "
                    + "on e.l_dley = c.ley and e.l_dconc = c.conc "
                    + "left join empresas as m "
                    + "on m.claveseg = e.l_seg) as p "
                    + "where l_dconc < 2700 AND l_seg not in ('NVG', 'NPG' ) AND IIGG = 1 "
                    + "GROUP BY codemp ,l_seg, SUBSTRING(CAST( l_mlega AS TEXT)FROM 4 FOR 8), "
                    + "l_mayn , l_tliq , tipoigg, RIGHT(p.l_ddesc,6) "
                    + "order by 1,2 ";

            PreparedStatement pstmt = db.getPreparedStatement(query);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(KimpaGrup.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void clean() {
        try {
            String query = "delete from kimpagrup";
            PreparedStatement stmt = db.getPreparedStatement(query);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(KimpaGrup.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void generar() {
        generarKimpG("202401", "202401", "10", "ENE24");; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
