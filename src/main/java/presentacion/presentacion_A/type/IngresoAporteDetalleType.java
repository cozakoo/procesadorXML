package presentacion.presentacion_A.type;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class IngresoAporteDetalleType {
    
    @XmlElement(name = "descripcion")
    private String descripcion;
    @XmlElement(name = "monto")
    private String monto;

    public String getDescripcion() {
        return descripcion;
    }

    public String getMonto() {
        return monto;
    }
    
    
}
