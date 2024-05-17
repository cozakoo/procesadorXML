/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.SeccionA;

import java.util.List;
import javax.xml.bind.annotation.*;
/**
 *
 * @author dgc06
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class CargasFamilia {
      @XmlElement(name = "cargaFamilia")
      private List<CargaFamilia> cargasFamilia;

    public List<CargaFamilia> getCargasFamilia() {
        return cargasFamilia;
    }

    public void setCargasFamilia(List<CargaFamilia> cargasFamilia) {
        this.cargasFamilia = cargasFamilia;
    }
}
