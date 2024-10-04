package presentacion.presentacion_A.type;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import presentacion.presentacion_A.arrayType.ArrayIngresoAporteDetalleType;


@XmlAccessorType(XmlAccessType.FIELD)
public class ingresoAporteType {

    @XmlAttribute(name = "mes")
    private int mes;

    @XmlAttribute(name = "regimen")
    private String regimen;

    @XmlElement(name = "obraSoc")
    private double obraSoc;

    @XmlElement(name = "segSoc")
    private double segSoc;

    @XmlElement(name = "sind")
    private double sind;

    @XmlElement(name = "ganBrut")
    private double ganBrut;

    @XmlElement(name = "retGan")
    private double retGan;

    @XmlElement(name = "retriNoHab")
    private double retriNoHab;

    @XmlElement(name = "ajuste")
    private double ajuste ;

    @XmlElement(name = "exeNoAlc")
    private double exeNoAlc;

    @XmlElement(name = "sac")
    private double sac;

    @XmlElement(name = "horasExtGr")
    private double horasExtGr;

    @XmlElement(name = "horasExtEx")
    private double horasExtEx;

    @XmlElement(name = "matDid")
    private double matDid;

    @XmlElement(name = "gastosMovViat")
    private double gastosMovViat;

    @XmlElement(name = "movilidad")
    private double movilidad;

    @XmlElement(name = "viaticos")
    private double viaticos;

    @XmlElement(name = "otrosConAn")
    private double otrosConAn;

    @XmlElement(name = "otrosConAnDetalle")
    private ArrayIngresoAporteDetalleType otrosConAnDetalle;

    @XmlAttribute(name = "bonosProd")
    private double bonosProd;

    @XmlElement(name = "bonosProdDetalle")
    private ArrayIngresoAporteDetalleType bonosProdDetalle;

    @XmlElement(name = "fallosCaja")
    private double fallosCaja;

    @XmlElement(name = "fallosCajaDetalle")
    private ArrayIngresoAporteDetalleType fallosCajaDetalle;

    @XmlElement(name = "conSimNat")
    private double conSimNat;

//    @XmlAttribute(name = "conSimNatDetalle")
//    private ArrayIngresoAporteDetalleType conSimNatDetalle;

    @XmlAttribute(name = "remunExentaLey27549")
    private double remunExentaLey27549;

    @XmlAttribute(name = "suplemParticLey19101")
    private double suplemParticLey19101;

    @XmlAttribute(name = "teletrabajoExento")
    private double teletrabajoExento;

    public int getMes() {
        return mes;
    }

    public String getRegimen() {
        return regimen;
    }

    public double getObraSoc() {
        return obraSoc;
    }

    public double getSegSoc() {
        return segSoc;
    }

    public double getSind() {
        return sind;
    }

    public double getGanBrut() {
        return ganBrut;
    }

    public double getRetGan() {
        return retGan;
    }

    public double getRetriNoHab() {
        return retriNoHab;
    }

    public double getAjuste() {
        return ajuste;
    }

    public double getExeNoAlc() {
        return exeNoAlc;
    }

    public double getSac() {
        return sac;
    }

    public double getHorasExtGr() {
        return horasExtGr;
    }

    public double getHorasExtEx() {
        return horasExtEx;
    }

    public double getMatDid() {
        return matDid;
    }

    public double getGastosMovViat() {
        return gastosMovViat;
    }

    public double getMovilidad() {
        return movilidad;
    }

    public double getViaticos() {
        return viaticos;
    }

    public double getOtrosConAn() {
        return otrosConAn;
    }

    public double getBonosProd() {
        return bonosProd;
    }

    public double getFallosCaja() {
        return fallosCaja;
    }

    public double getConSimNat() {
        return conSimNat;
    }

    public double getRemunExentaLey27549() {
        return remunExentaLey27549;
    }

    public double getSuplemParticLey19101() {
        return suplemParticLey19101;
    }

    public double getTeletrabajoExento() {
        return teletrabajoExento;
    }

    public ArrayIngresoAporteDetalleType getOtrosConAnDetalle() {
        return otrosConAnDetalle;
    }

    public ArrayIngresoAporteDetalleType getBonosProdDetalle() {
        return bonosProdDetalle;
    }

    public ArrayIngresoAporteDetalleType getFallosCajaDetalle() {
        return fallosCajaDetalle;
    }

    
    
    
   
}
