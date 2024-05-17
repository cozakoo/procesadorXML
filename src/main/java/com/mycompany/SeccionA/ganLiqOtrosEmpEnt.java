/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.SeccionA;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author dgc06
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ganLiqOtrosEmpEnt {
      @XmlElement(name = "empEnt")
      private List<EmpleadoEntidad> empleadosEntidadType;

        public List<EmpleadoEntidad> getEmpleadosEntidadType() {
            return empleadosEntidadType;
        }

        public void setEmpleadosEntidadType(List<EmpleadoEntidad> empleadosEntidadType) {
            this.empleadosEntidadType = empleadosEntidadType;
        }

}
