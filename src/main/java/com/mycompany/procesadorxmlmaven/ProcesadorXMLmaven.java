/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.procesadorxmlmaven;

import com.mycompany.SeccionA.CargaFamilia;
import com.mycompany.SeccionA.Direccion;
import com.mycompany.SeccionA.Empleado;
import com.mycompany.SeccionA.EmpleadoEntidad;
import com.mycompany.SeccionA.Presentacion;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;


/**
 *
 * @author dgc06
 */
public class ProcesadorXMLmaven {

    public static void main(String[] args) {
       System.out.println("main vacio");
         try {
            // Crear un contexto JAXB
            JAXBContext jaxbContext = JAXBContext.newInstance(Presentacion.class);

            // Crear un unmarshaller
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            // Leer el archivo XML y convertirlo a objeto Java
            Presentacion presentacion = (Presentacion) unmarshaller.unmarshal(new File("prueba_a.xml"));

            // Mostrar los datos
            System.out.println("Periodo: " + presentacion.getPeriodo());
            System.out.println("Nro de presentación: " + presentacion.getNumeroPresentacion());
            System.out.println("Fecha de presentación: " + presentacion.getFechaPresentacion());
            System.out.println("Empleado:");
            Empleado empleado = presentacion.getEmpleado();
            System.out.println("  CUIT: " + empleado.getCuit());
            System.out.println("  Tipo de documento: " + empleado.getTipoDoc());
            System.out.println("  Apellido: " + empleado.getApellido());
            System.out.println("  Nombre: " + empleado.getNombre());
            System.out.println("  Direccion:");
            Direccion direccion = empleado.getDireccion();
            System.out.println("    Provincia: " + direccion.getProvincia());
            System.out.println("    CP: " + direccion.getCp());
            System.out.println("    Localidad: " + direccion.getLocalidad());
            System.out.println("    Calle: " + direccion.getCalle());
            System.out.println("    Nro: " + direccion.getNro());
            System.out.println("cargasFamilia: ");
             for (CargaFamilia item: presentacion.getCargasFamilia().getCargasFamilia()) {
                 System.out.println("   ------------------ ");
                 System.out.println("    Tipo doc : " + item.getTipoDoc());
                 System.out.println("    Nro documento familia : " + item.getNroDoc());
                 System.out.println("    Apellido: " + item.getApellido());
                 System.out.println("    Nombre : " + item.getNombre());
                 System.out.println("    fechaNac: " + item.getFechaNac());
                 System.out.println("    mesdeDesde : " + item.getMesDesde());
                 System.out.println("    mesHasta : " + item.getMesHasta());
                 System.out.println("   ------------------ ");
                 //generar tabla
             }
              System.out.println("ganLiqOTrosEmpl: ");
             for (EmpleadoEntidad item: presentacion.getGanLiqOtrosEmpEnt().getEmpleadosEntidadType()) {
                 System.out.println("   ------------------ ");
                 System.out.println("    cuit : " + item.getCuit());
                 System.out.println("    denominacc : " + item.getDenominacion());
                  System.out.println("   ingresosAportes : " + item.getIngresosAportes());
                 System.out.println("    transporteLargaDist : " + item.getTransporteLargaDist());
                 System.out.println("    transporteTerrLargaDist : " + item.getTransporteTerrLargaDist());
                 System.out.println("    transporteLargaDist : " + item.getTransporteLargaDist());
                 
             }

        } catch (JAXBException e) {
            
            e.printStackTrace();
            
        }
    }
}
