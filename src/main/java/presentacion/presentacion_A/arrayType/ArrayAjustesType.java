package presentacion_A.arrayType;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import presentacion.presentacion_A.type.AjusteType;


@XmlAccessorType(XmlAccessType.FIELD)
public class ArrayAjustesType {

    @XmlElement(name = "ajuste")
    private List<AjusteType> ajuste  = new ArrayList<>();

    public List<AjusteType> getAjuste() {
        return ajuste;
    }

    @Override
    public String toString() {
         StringBuilder  sb = new StringBuilder();
         for (AjusteType ajusteDetalle : ajuste) {
            sb.append(ajusteDetalle.toString());
        }
         return sb.toString();
    }
    
    
    
}
