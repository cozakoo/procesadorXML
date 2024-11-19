/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.util.List;

/**
 *
 * @author dgc06
 */
public class DetalleNota {
   private String nombreArchivo;
   private String descripcion;
    
    
   public DetalleNota(String nombre, String detalle){
       nombreArchivo = nombre;
       descripcion = detalle;
   }
   public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return  nombreArchivo + "\n" + descripcion ;
    }
  
   
}
