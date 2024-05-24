package presentacion_A.arrayType;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import presentacion_A.type.DetalleType;

@XmlAccessorType(XmlAccessType.FIELD)
public class ArrayDetallesType {
    
    @XmlElement(name = "detalle")
    private List<DetalleType> detalle = new ArrayList<>();

}
