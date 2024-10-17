package presentacion.presentacion_A.type;

import presentacion_A.arrayType.ArrayRetPerPagosType;
import presentacion.presentacion_A.arrayType.ArrayOtrosEmpEntType;
import presentacion.presentacion_A.arrayType.ArrayDatosAdicionalesType;
import presentacion.presentacion_A.arrayType.ArrayCargasFamiliaType;
import presentacion_A.arrayType.ArrayAjustesType;
import presentacion_A.arrayType.ArrayDeduccionesType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import presentacion.PresentacionType;

import static util.XmlUtils.ExisteEtiqueta;

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
        StringBuilder sb = new StringBuilder();

        sb.append("PRESENTACION TIPO - A\n");
        sb.append(super.toString()).append("\n"); // Suponiendo que `imprimirCabecera` retorna un string o lo modifiques para que lo haga.

        sb.append("\n");
        sb.append("-------- CARGAS FAMILIA --------------- \n");
        if (ExisteEtiqueta(this.cargasFamilia)) {
            sb.append(this.cargasFamilia.toString()).append("\n");
        }
        
        sb.append("\n");
        sb.append("-------- GAN.LIQ OTROS EMPLEADORES ---------------\n");
        if (ExisteEtiqueta(this.ganLiqOtrosEmpEnt)) {
            sb.append(this.ganLiqOtrosEmpEnt.toString()).append("\n");
        }
        sb.append("\n");
        sb.append("-------- DEDUCCIONES ---------------\n");
        if (ExisteEtiqueta(this.deducciones)) {
            sb.append(this.deducciones.toString()).append("\n");
//            for ( object :this.deducciones.gr ) {
//                
//            }
        }
       
        sb.append("-------- RETENCION PAGOS ----------\n");
        if (ExisteEtiqueta(this.retPerPagos)) {
            sb.append(this.retPerPagos.toString()).append("\n");
        }
        
        sb.append("-------- AJUSTES ----------\n");
        if (ExisteEtiqueta(this.ajustes)) {
            sb.append(this.ajustes.toString()).append("\n");
        }
        sb.append("\n");

        sb.append("-------- DATOS ADICIONALES ----------\n");
        if (ExisteEtiqueta(this.datosAdicionales)) {
            sb.append(this.datosAdicionales.toString()).append("\n");
        }
        sb.append("---------------------------------------------------------------------------\n");
        sb.append("\n");

        // Agregar el contenido del `super.toString()`
        return sb.toString();
    }

    @Override
    public void validar(String periodo) {

        super.validar(periodo);

    }

    public ArrayCargasFamiliaType getCargasFamilia() {
        return cargasFamilia;
    }

    public ArrayOtrosEmpEntType getGanLiqOtrosEmpEnt() {
        return ganLiqOtrosEmpEnt;
    }

    public ArrayDeduccionesType getDeducciones() {
        return deducciones;
    }

    public ArrayRetPerPagosType getRetPerPagos() {
        return retPerPagos;
    }

    public ArrayAjustesType getAjustes() {
        return ajustes;
    }

    public ArrayDatosAdicionalesType getDatosAdicionales() {
        return datosAdicionales;
    }
    

}
