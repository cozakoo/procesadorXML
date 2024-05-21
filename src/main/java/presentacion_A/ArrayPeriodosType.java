package presentacion_A;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
class ArrayPeriodosType {
    
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
