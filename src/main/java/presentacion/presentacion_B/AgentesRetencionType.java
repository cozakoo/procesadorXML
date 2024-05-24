package presentacion.presentacion_B;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
class AgentesRetencionType {

    @XmlElement(name = "cuit")
    private String cuit;

    @XmlElement(name = "denominacion")
    private String denominacion;

    @Override
    public String toString() {
        System.out.println("cuit: " + this.cuit);
        System.out.println("denominacion: " + this.denominacion);
        return null;
    }
    
}
