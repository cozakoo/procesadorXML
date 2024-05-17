package com.mycompany.SeccionA;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author dgc06
 */
import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class CargaFamilia {
     @XmlElement(name = "tipoDoc")
    private String tipoDoc;
    @XmlElement(name = "nroDoc")
    private String nroDoc;
    private String apellido;
    private String nombre;
    @XmlElement(name = "fechaNac")
    private String fechaNac;
    @XmlElement(name = "mesDesde")
    private int mesDesde;

    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public String getNroDoc() {
        return nroDoc;
    }

    public void setNroDoc(String nroDoc) {
        this.nroDoc = nroDoc;
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

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public int getMesDesde() {
        return mesDesde;
    }

    public void setMesDesde(int mesDesde) {
        this.mesDesde = mesDesde;
    }

    public int getMesHasta() {
        return mesHasta;
    }

    public void setMesHasta(int mesHasta) {
        this.mesHasta = mesHasta;
    }

    public int getParentesco() {
        return parentesco;
    }

    public void setParentesco(int parentesco) {
        this.parentesco = parentesco;
    }

    public String getVigenteProximosPeriodos() {
        return vigenteProximosPeriodos;
    }

    public void setVigenteProximosPeriodos(String vigenteProximosPeriodos) {
        this.vigenteProximosPeriodos = vigenteProximosPeriodos;
    }

    public int getPorcentajeDeduccion() {
        return porcentajeDeduccion;
    }

    public void setPorcentajeDeduccion(int porcentajeDeduccion) {
        this.porcentajeDeduccion = porcentajeDeduccion;
    }
    @XmlElement(name = "mesHasta")
    private int mesHasta;
    private int parentesco;
    @XmlElement(name = "vigenteProximosPeriodos")
    private String vigenteProximosPeriodos;
    @XmlElement(name = "porcentajeDeduccion")
    private int porcentajeDeduccion;
    
}
