package presentacion.presentacion_A;

import presentacion_A.arrayType.ArrayRetPerPagosType;
import presentacion_A.arrayType.ArrayOtrosEmpEntType;
import presentacion_A.arrayType.ArrayDatosAdicionalesType;
import presentacion_A.arrayType.ArrayCargasFamiliaType;
import presentacion_A.arrayType.ArrayAjustesType;
import presentacion_A.arrayType.ArrayDeduccionesType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import presentacion.PresentacionType;

@XmlRootElement(name = "presentacion")
@XmlAccessorType(XmlAccessType.FIELD)
public class presentacionTypeSeccionA extends PresentacionType {

    @XmlElement(name = "cargasFamilia")
    private ArrayCargasFamiliaType cargasFamilia;

    @XmlElement(name = "ganLiqOtrosEmpEnt")
    private ArrayOtrosEmpEntType ganLiqOtrosEmpEnt;

    @XmlElement(name = "deducciones")
    private ArrayDeduccionesType deducciones;

    @XmlElement(name = "retPerPagos")
    private ArrayRetPerPagosType retPerPagos;

    @XmlElement(name = "ajustes")
    private ArrayAjustesType ajustes;

    @XmlElement(name = "datosAdicionales")
    private ArrayDatosAdicionalesType datosAdicionales;

    @Override
    public String toString() {
        super.imprimirCabecera();
        
        System.out.println("");
        System.out.println("-------- CARGAS FAMILIA  ---------------");
        this.cargasFamilia.toString();
        
        System.out.println("");
        System.out.println("---------- OTROS EMPLEADORES ----------");
        this.ganLiqOtrosEmpEnt.toString();
        
        System.out.println("");
        System.out.println("---------- DEDUCCIONES ----------");
        this.deducciones.toString();
        
        System.out.println("---------- DATOS ADICIONALES ----------");
        this.datosAdicionales.toString();

        return super.toString();
    }

}
