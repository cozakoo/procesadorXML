package presentacion_A.arrayType;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import presentacion_A.type.CargaFamilia;

@XmlAccessorType(XmlAccessType.FIELD)
public class ArrayCargasFamiliaType {

    @XmlElement(name = "cargaFamilia")
    private List<CargaFamilia> cargasFamilia = new ArrayList<>();

    @Override
    public String toString() {
        for (CargaFamilia cargaFamilia : cargasFamilia) {
            System.out.println("----------- CARGA FAMILIA ----------- ");
            System.out.println("tipoDoc: " + cargaFamilia.getTipoDoc());
            System.out.println("nroDoc: " + cargaFamilia.getNroDoc());
            System.out.println("apellido: " + cargaFamilia.getApellido());
            System.out.println("nombre: " + cargaFamilia.getNombre());
            System.out.println("fechaNac: " + cargaFamilia.getFechaNac());
            System.out.println("mesDesde: " + cargaFamilia.getMesDesde());
            System.out.println("mesHasta: " + cargaFamilia.getMesHasta());
            System.out.println("parentesco: " + cargaFamilia.getParentesco());
            System.out.println("vigenteProximosPeriodos: " + cargaFamilia.getVigenteProximosPeriodos());
            System.out.println("porcentajeDeduccion: " + cargaFamilia.getPorcentajeDeduccion());
        }
        return null;
    }
}
