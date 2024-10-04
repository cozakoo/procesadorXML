package presentacion.presentacion_A.type;

import presentacion.presentacion_A.arrayType.ArrayIngresosAporteType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class EmpleadorEntidadType {

    @XmlElement(name = "cuit")
    private String cuit;

    @XmlElement(name = "denominacion")
    private String denominacion;

    @XmlElement(name = "ingresosAportes")
    private ArrayIngresosAporteType ingresosAportes;

    @XmlElement(name = "convenioColectivo")
    private String convenioColectivo;

    @XmlElement(name = "transporteLargaDist")
    private String transporteLargaDist;

    @XmlElement(name = "transporteTerrLargaDist")
    private String transporteTerrLargaDist;

    public String getCuit() {
        return cuit;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public ArrayIngresosAporteType getIngresosAportes() {
        return ingresosAportes;
    }

    public void setIngresosAportes(ArrayIngresosAporteType ingresosAportes) {
        this.ingresosAportes = ingresosAportes;
    }

    public String getConvenioColectivo() {
        return convenioColectivo;
    }

    public void setConvenioColectivo(String convenioColectivo) {
        this.convenioColectivo = convenioColectivo;
    }

    public String getTransporteLargaDist() {
        return transporteLargaDist;
    }

    public void setTransporteLargaDist(String transporteLargaDist) {
        this.transporteLargaDist = transporteLargaDist;
    }
   
}
