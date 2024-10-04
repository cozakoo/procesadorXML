package presentacion.presentacion_A.arrayType;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import presentacion.presentacion_A.type.IngresoAporteDetalleType;

public class ArrayIngresoAporteDetalleType {
    @XmlElement(name = "concepto")
    private List<IngresoAporteDetalleType> concepto = new ArrayList<>();

    public List<IngresoAporteDetalleType> getConcepto() {
        return concepto;
    }
    
   
   
}
