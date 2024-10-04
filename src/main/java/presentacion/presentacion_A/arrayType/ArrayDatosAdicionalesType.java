package presentacion.presentacion_A.arrayType;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import presentacion.presentacion_A.type.DatoAdicionalType;

@XmlAccessorType(XmlAccessType.FIELD)
public class ArrayDatosAdicionalesType {

    @XmlElement(name = "datoAdicional")
    private List<DatoAdicionalType> datoAdicional = new ArrayList<>();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (DatoAdicionalType adicional : datoAdicional) {
            sb.append("-------- ADICIONAL ---- \n");
            sb.append("nombre: ").append(adicional.getNombre()).append("\n");
            sb.append("mesDesde: ").append(adicional.getMesDesde()).append("\n");
            sb.append("mesHasta: ").append(adicional.getMesHasta()).append("\n");
            sb.append("valor: ").append(adicional.getValor()).append("\n");
        }

        return sb.toString();
    }
}
