package util;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Persona {
    
    @XmlElement(name = "apellido")
    private String apellido;

    @XmlElement(name = "nombre")
    private String nombre;
    
    @XmlElement(name = "tipoDoc")
    private short tipoDoc;

    public String getApellido() {
        return apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public short getTipoDoc() {
        return tipoDoc;
    }
    
}
