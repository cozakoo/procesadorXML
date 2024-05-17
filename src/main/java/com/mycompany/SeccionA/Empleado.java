/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.SeccionA;

import com.mycompany.SimpleType.CuitSimpleType;
import javax.xml.bind.annotation.*;
/**
 *
 * @author dgc06
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Empleado {
    private long cuit;
    private String tipoDoc;
    private String apellido;
    private String nombre;
    private Direccion direccion;
        
    public long getCuit() {
        
        return cuit;
    }

    public void setCuit(long cuit) {
        this.cuit = cuit;
    }

   
 

    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
}
