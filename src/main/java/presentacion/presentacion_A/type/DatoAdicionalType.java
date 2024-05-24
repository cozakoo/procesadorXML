package presentacion_A.type;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class DatoAdicionalType {

    @XmlAttribute(name = "nombre")
    private String nombre;

    @XmlAttribute(name = "mesDesde")
    private int mesDesde;

    @XmlAttribute(name = "mesHasta")
    private int mesHasta;

    @XmlAttribute(name = "valor")
    private String valor;

    public String getNombre() {
        return nombre;
    }

    public int getMesDesde() {
        return mesDesde;
    }

    public int getMesHasta() {
        return mesHasta;
    }

    public String getValor() {
        return valor;
    }

    
}
