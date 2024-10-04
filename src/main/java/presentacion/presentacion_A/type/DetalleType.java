package presentacion.presentacion_A.type;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class DetalleType {
    @XmlAttribute(name = "nombre")
    private String nombre;

    @XmlAttribute(name = "valor")
    private String valor;

    public String getNombre() {
        return nombre;
    }

    public String getValor() {
        return valor;
    }
    
    
    
}
