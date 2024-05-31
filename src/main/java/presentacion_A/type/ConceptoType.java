package presentacion_A.type;

import presentacion_A.arrayType.ArrayPeriodosType;
import presentacion_A.arrayType.ArrayDetallesType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class ConceptoType {
    
    @XmlAttribute(name = "tipo")
    private String tipo;
        
    @XmlElement(name = "tipoDoc")
    private String tipoDoc;
    
    @XmlElement(name = "nroDoc")
    private String nroDoc;
    
    @XmlElement(name = "denominacion")
    private String denominacion;
    
    @XmlElement(name = "descBasica")
    private String descBasica;
    
    @XmlElement(name = "descAdicional")
    private String descAdicional;
    
    @XmlElement(name = "montoTotal")
    private String montoTotal;
    
    @XmlElement(name = "periodos")
    private ArrayPeriodosType periodos;
    
    @XmlElement(name = "detalles")
    private ArrayDetallesType detalles;

    public String getTipoDoc() {
        return tipoDoc;
    }

    public String getNroDoc() {
        return nroDoc;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public String getDescBasica() {
        return descBasica;
    }

    public String getMontoTotal() {
        return montoTotal;
    }

    public ArrayPeriodosType getPeriodos() {
        return periodos;
    }

    public String getTipo() {
        return tipo;
    }

    
    
}
