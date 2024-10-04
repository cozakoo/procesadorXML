package presentacion.presentacion_A.type;

import presentacion.presentacion_A.arrayType.ArrayDetallesType;
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

    public String getTipo() {
        return tipo;
    }

    public String getCuit() {
        return cuit;
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

    public ArrayDetallesType getDetalles() {
        return detalles;
    }

    @Override

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("DETALE AJUSTE \n")
                .append("    tipo: ").append(tipo).append("\n")
                .append("    cuit: ").append(cuit).append("\n")
                .append("    denominacion: ").append(denominacion).append("\n")
                .append("    descBasica: ").append(descBasica).append("\n")
                .append("    descAdicional: ").append(descAdicional).append("\n")
                .append("    montoTotal: ").append(montoTotal).append("\n")
                .append(detalles.toString()).append("\n")
                .append("-------------------------\n");

        return sb.toString();
    }

}
