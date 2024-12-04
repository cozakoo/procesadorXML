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
public class KimpGan extends Tabla {

    private final DataBase db;

    public KimpGan(DataBase db) {
        this.db = db;
    }

    @Override
    public void generar() {
        try {
            aplicarCondCasoA();
            aplicarCondCasoB();

            // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        } catch (SQLException ex) {
            Logger.getLogger(KimpGan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean isGenerable() {
        return true;
    }

    private void aplicarCondCasoA() throws SQLException {
        String query = "insert into kimpgan (SELECT "
                + "K.codemp, "
                + "K.seg, "
                + "K.documento, "
                + "MAX(K.nombre) AS nombre, "
                + "K.tliq, "
                + "K.tipoigg,"
                + "SUM(K.monto) AS total_monto,"
                + "K.mes_sue , K.mes_dev,"
                + "K.mes,"
                + "CASE "
                + "WHEN mes_dev = '' then cast(mes_sue as numeric)-1 "
                + "ELSE cast(mes_dev as numeric) "
                + "END AS nmesdev "
                + "FROM "
                + "kimpagrup K "
                + "where (cast(mes_sue as numeric) % 100) > 1 "
                + "GROUP BY "
                + "K.codemp, "
                + "K.seg, "
                + "K.documento,"
                + "K.tliq, "
                + "K.tipoigg, "
                + "K.mes_sue, "
                + "K.mes_dev, "
                + "K.mes)";

        int executeUpdate = db.getPreparedStatement(query).executeUpdate();

    }

    private void aplicarCondCasoB() throws SQLException {
        String query = "INSERT INTO kimpgan (SELECT "
                + "    K.codemp, "
                + "    K.seg, "
                + "    K.documento, "
                + "    MAX(K.nombre) AS nombre, "
                + "    K.tliq, "
                + "    K.tipoigg,"
                + "    SUM(K.monto) AS total_monto, "
                + "    K.mes_sue,"
                + "    K.mes_dev, "
                + "    K.mes,"
                + "    CASE "
                + "        WHEN mes_dev = '' then ((cast(mes_sue as numeric)/100)-1)*100+11"
                + "        ELSE cast (mes_dev as integer) "
                + "    END AS nmesdev "
                + "FROM "
                + "    kimpagrup K "
                + "where (cast(mes_sue as numeric) % 100) = 1 "
                + "GROUP BY "
                + "    K.codemp, "
                + "    K.seg, "
                + "    K.documento,"
                + "    K.tliq, "
                + "    K.tipoigg, "
                + "    K.mes_sue, "
                + "    K.mes_dev, "
                + "    K.mes )";
        int executeUpdate = db.getPreparedStatement(query).executeUpdate();
    }

    @Override
    public void clean() {
        String query = "select * from kimpgrup";
        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
