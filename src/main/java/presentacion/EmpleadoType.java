package presentacion;

import javax.xml.bind.annotation.*;
import util.Persona;

@XmlAccessorType(XmlAccessType.FIELD)
public class EmpleadoType extends Persona{
    
    @XmlElement(name = "cuit")
    private long cuit;
    
    @XmlElement(name = "direccion")
    private DireccionType direccion;
    
    // Getters y setters
    public long getCuit() {
        return cuit;
    }

    public DireccionType getDireccion() {
        return direccion;
    }

    public void imprimirDatos() {
        System.out.println("-------- EMPLEADO --------------- ");
        System.out.println("cuit: " + this.cuit);
        System.out.println("tipoDoc: " + this.getTipoDoc());
        System.out.println("apellido: " + this.getApellido());
        System.out.println("nombre: " + this.getNombre());
        this.direccion.mostrarDatos();
    }

    
}