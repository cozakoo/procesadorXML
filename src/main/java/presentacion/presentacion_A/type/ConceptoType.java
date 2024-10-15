package presentacion.presentacion_A.type;

import presentacion_A.arrayType.ArrayPeriodosType;
import presentacion.presentacion_A.arrayType.ArrayDetallesType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class ConceptoType {

    @XmlAttribute(name = "tipo")
    private int tipo;

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

    public int getTipo() {
        return tipo;
    }

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

    public String getDescAdicional() {
        return descAdicional;
    }

    public String getMontoTotal() {
        return montoTotal;
    }

    public ArrayPeriodosType getPeriodos() {
        return periodos;
    }

    public ArrayDetallesType getDetalles() {
        return detalles;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("----Detalle retPerPago---- {\n")
                .append("    tipo: ").append(tipo).append("\n")
                .append("    tipoDoc: ").append(tipoDoc).append("\n")
                .append("    nroDoc: ").append(nroDoc).append("\n")
                .append("    denominacion: ").append(denominacion).append("\n")
                .append("    descBasica: ").append(descBasica).append("\n")
                .append("    descAdicional: ").append(descAdicional).append("\n")
                .append("    montoTotal: ").append(montoTotal).append("\n")
                .append(periodos.toString()).append("\n")
                .append(detalles.toString()).append("\n")
                .append("--------------------- {\n");

        return sb.toString();
    }

}
