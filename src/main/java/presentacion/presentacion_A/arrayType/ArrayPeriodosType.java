package presentacion_A.arrayType;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import presentacion_A.type.PeriodoType;

@XmlAccessorType(XmlAccessType.FIELD)
public class ArrayPeriodosType {
    
    @XmlElement(name = "periodo")
    private List<PeriodoType> periodo = new ArrayList<>();

    @Override
    public String toString() {
         for (PeriodoType periodo : periodo) {
            System.out.print("-- PERIODO: ");
            System.out.print("mesDesde: " + periodo.getMesDesde());
            System.out.print(" mesHasta: " + periodo.getMesHasta());
            System.out.println(" montoMensual: " + periodo.getMontoMensual());
         }
        System.out.println("");
        return null;
    }

}
