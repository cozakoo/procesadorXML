package presentacion_A;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
class PeriodoType {

    @XmlAttribute(name = "mesDesde")
    private int mesDesde;
    
    @XmlAttribute(name = "mesHasta")
    private int mesHasta;


    @XmlAttribute(name = "montoMensual")
    private String montoMensual;

    public int getMesDesde() {
        return mesDesde;
    }

    public int getMesHasta() {
        return mesHasta;
    }

    public String getMontoMensual() {
        return montoMensual;
    }
    
    
}
