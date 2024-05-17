/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.SeccionA;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author dgc06
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class EmpleadoEntidad {
    private long cuit;
    private String denominacion;
    private String ingresosAportes;
    private String convenioColectivo;
    private String TransporteLargaDist;
    private String TransporteTerrLargaDist;

    public String getConvenioColectivo() {
        return convenioColectivo;
    }

    public void setConvenioColectivo(String convenioColectivo) {
        this.convenioColectivo = convenioColectivo;
    }

    public String getTransporteLargaDist() {
        return TransporteLargaDist;
    }

    public void setTransporteLargaDist(String TransporteLargaDist) {
        this.TransporteLargaDist = TransporteLargaDist;
    }

    public String getTransporteTerrLargaDist() {
        return TransporteTerrLargaDist;
    }

    public void setTransporteTerrLargaDist(String TransporteTerrLargaDist) {
        this.TransporteTerrLargaDist = TransporteTerrLargaDist;
    }
    
    
    
    
    public long getCuit() {
        return cuit;
    }

    public void setCuit(long cuit) {
        this.cuit = cuit;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public String getIngresosAportes() {
        return ingresosAportes;
    }

    public void setIngresosAportes(String ingresosAportes) {
        this.ingresosAportes = ingresosAportes;
    }
           
    
}
