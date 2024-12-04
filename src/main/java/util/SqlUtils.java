/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import main.DataBase;

/**
 *
 * @author dgc06
 */
public class SqlUtils {
    public static boolean isConsultaVacia(String query, DataBase db) {
        try {
            // Lógica para determinar si es Sección B
            return (db.consulta(query).next()) ? false : true;
        } catch (SQLException ex) {
            Logger.getLogger(SqlUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
     
    }
    
    public static ResultSet SelectTableSql(String tableName, String condicion, DataBase db){
        String query = "select * from " + tableName;
        query = !condicion.isEmpty() ?  query + " " + condicion :  query; 

        return db.consulta(query);
    }
   
  
    
    public static DefaultTableModel crearModel(ResultSet rs) throws SQLException {
        DefaultTableModel model = new DefaultTableModel() {

          

        };
        boolean columnasNoCargadas = true;
        int indexFila;
        String resultadoSQL = "";
        int numColumnas = 0;

        try {
            int cantBotonsEdit = 2;
            int totalColumnas = rs.getMetaData().getColumnCount() + cantBotonsEdit;
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
//                    model.addColumn("");
//                    model.addColumn("");

                }

                Object[] row = new Object[totalColumnas];
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
                    } else {
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
    
    
    
    
    
   public static DefaultTableModel crearModelEditable(ResultSet rs) throws SQLException {
        DefaultTableModel model = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 13 || column == 14; // Solo la columna "Acción" es editable
            }

        };
        boolean columnasNoCargadas = true;
        int indexFila;
        String resultadoSQL = "";
        int numColumnas = 0;

        try {
            int cantBotonsEdit = 2;
            int totalColumnas = rs.getMetaData().getColumnCount() + cantBotonsEdit;
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
                    model.addColumn("");
                    model.addColumn("");

                }

                Object[] row = new Object[totalColumnas];
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
                    } else {
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
