package presentacion_A.type;

import presentacion_A.arrayType.ArrayDetallesType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class AjusteType {
    
    @XmlAttribute(name = "tipo")
    private String tipo;
    
    @XmlElement(name = "cuit")
    private String cuit;
    
    @XmlElement(name = "denominacion")
    private String denominacion;
    
    @XmlElement(name = "descBasica")
    private String descBasica;
        
    @XmlElement(name = "descAdicional")
    private String descAdicional;
    
    @XmlElement(name = "montoTotal")
    private String montoTotal;
 
    @XmlElement(name = "detalles")
    private ArrayDetallesType detalles;

}
