package presentacion;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class PresentacionType {

    @XmlElement(name = "periodo")
    private int periodo;

    @XmlElement(name = "nroPresentacion")
    private int nroPresentacion;

    @XmlElement(name = "fechaPresentacion")
    private String fechaPresentacion;

    @XmlElement(name = "empleado")
    private EmpleadoType empleado;

    public int getPeriodo() {
        return periodo;
    }

    public int getNroPresentacion() {
        return nroPresentacion;
    }

    public String getFechaPresentacion() {
        return fechaPresentacion;
    }

    public EmpleadoType getEmpleado() {
        return empleado;
    }

    protected void imprimirCabecera() {
        System.out.println("-------- CABECERA --------------- ");
        System.out.println("Periodo: " + this.getPeriodo());
        System.out.println("nroPresentacion: " + this.getNroPresentacion());
        System.out.println("fechaPresentacion: " + this.getFechaPresentacion());
        this.getEmpleado().imprimirDatos();

    }

}