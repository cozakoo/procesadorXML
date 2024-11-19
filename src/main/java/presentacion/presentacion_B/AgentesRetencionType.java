package presentacion.presentacion_B;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class AgentesRetencionType {

    @XmlElement(name = "cuit")
    private String cuit;

    @XmlElement(name = "denominacion")
    private String denominacion;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("--------AGENTE DE RETENCION--------").append("\n");
        sb.append("cuit: ").append(this.cuit).append("\n");
        sb.append("denominacion: ").append(this.denominacion);
        return sb.toString();

    }

    public String getCuit() {
        return cuit;
    }

    public String getDenominacion() {
        return denominacion;
    }
     
  
}
