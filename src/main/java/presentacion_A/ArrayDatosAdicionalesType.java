package presentacion_A;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
class ArrayDatosAdicionalesType {

    @XmlElement(name = "datoAdicional")
    private List<DatoAdicionalType> datoAdicional = new ArrayList<>();

    @Override
    public String toString() {
        for (DatoAdicionalType adicional : datoAdicional) {
            System.out.print("-- ADICIONAL ");
            System.out.print("nombre: " + adicional.getNombre());
            System.out.print("mesDesde: " + adicional.getMesDesde());
            System.out.print("mesHasta: " + adicional.getMesHasta());
            System.out.print("valor: " + adicional.getValor());

        }
        return null;
    }
}
