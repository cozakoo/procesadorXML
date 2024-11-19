package presentacion.presentacion_B;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import presentacion.PresentacionType;

@XmlRootElement(name = "presentacion")
@XmlAccessorType(XmlAccessType.FIELD)
public class presentacionTypeSeccionB extends PresentacionType {

    @XmlElement(name = "agenteRetencion")
    private AgentesRetencionType agenteRetencion;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PRESENTACION TIPO B").append("\n")
                .append(super.toString())
                .append(this.agenteRetencion.toString()).append("\n");

        return sb.toString();
    }

    public AgentesRetencionType getAgenteRetencion() {
        return agenteRetencion;
    }
    
}
