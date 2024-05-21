package presentacion_A;

import javax.xml.bind.annotation.*;
import util.Persona;

@XmlAccessorType(XmlAccessType.FIELD)
public class CargaFamilia extends Persona{

    @XmlElement(name = "nroDoc")
    private String nroDoc;

    @XmlElement(name = "fechaNac")
    private String fechaNac;
        
    @XmlElement(name = "mesDesde")
    private short mesDesde;

    @XmlElement(name = "mesHasta")
    private short mesHasta;

    @XmlElement(name = "parentesco")
    private short parentesco;
    
    @XmlElement(name = "vigenteProximosPeriodos")
    private String vigenteProximosPeriodos;
    
    @XmlElement(name = "fechaLimite")
    private String fechaLimite;
        
    @XmlElement(name = "porcentajeDeduccion")
    private short porcentajeDeduccion;

    public String getNroDoc() {
        return nroDoc;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public short getMesDesde() {
        return mesDesde;
    }

    public short getMesHasta() {
        return mesHasta;
    }

    public short getParentesco() {
        return parentesco;
    }

    public String getVigenteProximosPeriodos() {
        return vigenteProximosPeriodos;
    }

    public short getPorcentajeDeduccion() {
        return porcentajeDeduccion;
    }

    
    
}
