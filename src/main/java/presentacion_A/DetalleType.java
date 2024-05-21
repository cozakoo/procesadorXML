package presentacion_A;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
class DetalleType {
    @XmlElement(name = "nombre")
    private String nombre;

    @XmlElement(name = "valor")
    private String valor;
    
}
