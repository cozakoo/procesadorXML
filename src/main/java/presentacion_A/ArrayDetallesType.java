package presentacion_A;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
class ArrayDetallesType {
    
    @XmlElement(name = "detalle")
    private List<DetalleType> detalle = new ArrayList<>();

}
