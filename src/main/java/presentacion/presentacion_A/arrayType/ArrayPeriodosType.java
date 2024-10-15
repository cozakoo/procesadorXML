package presentacion_A.arrayType;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import presentacion.presentacion_A.type.PeriodoType;

@XmlAccessorType(XmlAccessType.FIELD)
public class ArrayPeriodosType {

    @XmlElement(name = "periodo")
    private List<PeriodoType> periodo = new ArrayList<>();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (PeriodoType periodo : periodo) {
            sb.append("-- PERIODO: ");
            sb.append("mesDesde: ").append(periodo.getMesDesde());
            sb.append(" mesHasta: ").append(periodo.getMesHasta());
            sb.append(" montoMensual: ").append(periodo.getMontoMensual()).append("\n");
        }

        sb.append("\n"); // Añadir una línea en blanco como en el código original
        return sb.toString();
    }

    public List<PeriodoType> getPeriodo() {
        return periodo;
    }
    
}
