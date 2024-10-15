package presentacion_A.arrayType;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import presentacion.presentacion_A.type.ConceptoType;

@XmlAccessorType(XmlAccessType.FIELD)
public class ArrayRetPerPagosType {

    @XmlElement(name = "retPerPago")
    private List<ConceptoType> retenciones = new ArrayList<>();

    public List<ConceptoType> getRetenciones() {
        return retenciones;
    }


    
    
    @Override
    public String toString() {
        StringBuilder sb =  new StringBuilder();
        for (ConceptoType detalle : retenciones) {
            sb.append(detalle.toString());
        }
        return sb.toString();
    }
    
    
    
}
