package presentacion.presentacion_A.arrayType;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import presentacion.presentacion_A.type.DetalleType;

@XmlAccessorType(XmlAccessType.FIELD)
public class ArrayDetallesType {

    @XmlElement(name = "detalle")
    private List<DetalleType> detalle = new ArrayList<>();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (DetalleType detalleType : detalle) {
            sb.append("---- DETALLE ----\n") // Separador para cada detalle
                    .append("Nombre: ").append(detalleType.getNombre()).append("\n") // Nombre del detalle
                    .append("Valor: ").append(detalleType.getValor()).append("\n");  // Valor del detalle
        }
        return sb.toString();
    }

}
