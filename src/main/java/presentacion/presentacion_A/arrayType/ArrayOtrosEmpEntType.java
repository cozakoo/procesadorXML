package presentacion_A.arrayType;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import presentacion_A.type.EmpleadorEntidadType;

@XmlAccessorType(XmlAccessType.FIELD)
public class ArrayOtrosEmpEntType {

    @XmlElement(name = "empEnt")
    private List<EmpleadorEntidadType> empEnt = new ArrayList<>();

    @Override
    public String toString() {
        for (EmpleadorEntidadType emp : empEnt) {
            System.out.println("----------- EMPLEADOR ENTIDAD ----------- ");
            System.out.println("cuit: " + emp.getCuit());
            System.out.println("denominacion: " + emp.getDenominacion());
        }
        return null;
    }

}