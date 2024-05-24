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
        super.imprimirCabecera();
        System.out.println("");
        System.out.println("-------- AgentesRetencion ---------------");
        this.agenteRetencion.toString();
        return super.toString();
    }
}
