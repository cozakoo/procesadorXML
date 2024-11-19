/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dgc06
 */
public class IuUtils {
    public static DefaultTableModel crearModel(ResultSet rs) throws SQLException {
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        boolean columnasNoCargadas = true;
        int indexFila;
        String resultadoSQL = "";
        int numColumnas = 0;

        try {
            numColumnas = rs.getMetaData().getColumnCount();

            while (rs.next()) {
                if (columnasNoCargadas) {
                    for (int i = 1; i <= numColumnas; i++) {
                        if (!"".equals(resultadoSQL)) {
                            if (i < numColumnas) {
                                resultadoSQL = rs.getMetaData().getColumnName(i);
                            } else {
                                resultadoSQL = rs.getMetaData().getColumnName(i) + resultadoSQL;
                            }
                        } else if (i < numColumnas) {
                            resultadoSQL = rs.getMetaData().getColumnName(i);
                        } else {
                            resultadoSQL = rs.getMetaData().getColumnName(i);
                        }

                        model.addColumn(resultadoSQL);
                        resultadoSQL = "";
                        columnasNoCargadas = false;
                    }
                }
                Object[] row = new Object[numColumnas];
                indexFila = 0;
                Object obj;
                resultadoSQL = " ";

                for (int i = 1; i <= numColumnas; i++) {
                    obj = rs.getObject(i);
                    if (obj != null) {
                        if (obj instanceof Double) {
                            DecimalFormat formatea = new DecimalFormat("###,##0.00");
                            row[indexFila] = formatea.format(obj);
                        } else {
                            row[indexFila] = obj;
                        }
                        

                        resultadoSQL = "";
                    }else{
                        row[indexFila] = " ";
                    }
                    indexFila++;
                }
                model.addRow(row);

                resultadoSQL = "";

            }
        } catch (SQLException e) {
        }
        return model;
    }
    
}
