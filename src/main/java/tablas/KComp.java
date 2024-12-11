/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tablas;

import main.DataBase;

/**
 *
 * @author dgc06
 */
public class KComp extends Tabla{

    private DataBase db;
    public KComp(DataBase db) {
        this.db = db;
    }

    
    
    @Override
    public boolean isGenerable() {
        String query = "select * from kimpgancom";
        return !util.SqlUtils.isConsultaVacia(query, db);
        
         
         
       // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void generar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void clean() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
