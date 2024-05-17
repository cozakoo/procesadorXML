/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.SeccionA;

/**
 *
 * @author dgc06
 */
import java.util.List;
import javax.xml.bind.annotation.*;


@XmlRootElement(name = "presentacion")
@XmlAccessorType(XmlAccessType.FIELD)
public class Presentacion {
    private int periodo;
    @XmlElement(name = "nroPresentacion")
    private int numeroPresentacion;
    @XmlElement(name = "fechaPresentacion")
    private String fechaPresentacion;
    private Empleado empleado;
    private CargasFamilia cargasFamilia;

    public CargasFamilia getCargasFamilia() {
        return cargasFamilia;
    }

    public void setCargasFamilia(CargasFamilia cargasFamilia) {
        this.cargasFamilia = cargasFamilia;
    }


    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public int getNumeroPresentacion() {
        return numeroPresentacion;
    }

    public void setNumeroPresentacion(int numeroPresentacion) {
        this.numeroPresentacion = numeroPresentacion;
    }

    public String getFechaPresentacion() {
        return fechaPresentacion;
    }

    public void setFechaPresentacion(String fechaPresentacion) {
        this.fechaPresentacion = fechaPresentacion;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    
}
