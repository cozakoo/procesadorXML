package presentacion_A;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
class ArrayIngresosAporteType {
    
    @XmlElement(name = "mes")
    private int mes;
    
    @XmlElement(name = "regimen")
    private String regimen;

    @XmlElement(name = "ingAp")
    private List<ingresoAporteType> ingAp = new ArrayList<>();

    
}
