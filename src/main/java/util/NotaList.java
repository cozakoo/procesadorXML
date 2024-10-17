/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dgc06
 */
//describe el estado o resultado de los archivos pasados
public class NotaList {
    private static NotaList instance = null;
    private final List<DetalleNota> actualizados ;
    private final List<DetalleNota> NoActulizados;
    private final List<DetalleNota> ConErrores;    

   private NotaList() {
        actualizados = new ArrayList<>();
        NoActulizados = new ArrayList<>();
        ConErrores = new ArrayList<>();
   } 
    
    public static NotaList getIntance(){
       if(instance == null ){
           instance = new NotaList();
       }
       return instance;
    }
    public  List<DetalleNota> getActualizados() {
        return actualizados;
    }

    public void addNotaActualizados(String nombre, String descripcion) {
        this.actualizados.add(
         new DetalleNota(nombre, descripcion)
        );
                
    }

    public List<DetalleNota> getNoActulizados() {
        return NoActulizados;
    }

    public void addNotaNoActualizados(String nombre, String descripcion) {
        this.NoActulizados.add(
         new DetalleNota(nombre, descripcion)
        );
    }

    public List<DetalleNota> getConErrores() {
        return ConErrores;
    }

    public void addNotaConErrores(String nombre,String descripcion) {
        this.ConErrores.add(
         new DetalleNota(nombre, descripcion)
        );
    }
    
    
    
}
