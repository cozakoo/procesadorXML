package presentacion;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class DireccionType {

    @XmlElement(name = "provincia")
    private short provincia;

    @XmlElement(name = "cp")
    private String cp;

    @XmlElement(name = "localidad")
    private String localidad;

    @XmlElement(name = "calle")
    private String calle;

    @XmlElement(name = "nro")
    private String nro;

    @XmlElement(name = "piso")
    private String piso;

    @XmlElement(name = "dtp")
    private String dtp;

    public String getCalle() {
        return calle;
    }

    public String getCp() {
        return cp;
    }

    public String getDtp() {
        return dtp;
    }

    public short getProvincia() {
        return provincia;
    }

    public String getLocalidad() {
        return localidad;
    }

    public String getNro() {
        return nro;
    }

    public String getPiso() {
        return piso;
    }

    public void mostrarDatos() {
        System.out.println("provincia: " + this.provincia);
        System.out.println("cp: " + this.cp);
        System.out.println("localidad: " + this.localidad);
        System.out.println("calle: " + this.calle);
        System.out.println("nro: " + this.nro);
    }
}
