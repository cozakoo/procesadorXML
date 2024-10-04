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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("-------- CABECERA --------------- \n");
        sb.append("Periodo: ").append(this.getPeriodo()).append("\n");
        sb.append("nroPresentacion: ").append(this.getNroPresentacion()).append("\n");
        sb.append("fechaPresentacion: ").append(this.getFechaPresentacion()).append("\n");

        // Asumiendo que `empleado.imprimirDatos()` también puede ser un `toString()` o retornar un String
        sb.append(this.getEmpleado().toString()).append("\n");

        return sb.toString();
    }

    public void validar(String periodo) {
        this.validarPeriodo(periodo);
    }

    private void validarPeriodo(String periodo) {

        if (Integer.parseInt(periodo) == this.periodo) {

        }
        System.out.println("-------------");
        System.out.println("SOY EL PERIODO");
        System.out.println(this.periodo);
        System.out.println("-------------");
    }

}
