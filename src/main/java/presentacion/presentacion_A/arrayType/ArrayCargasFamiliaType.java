package presentacion.presentacion_A.arrayType;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import presentacion.presentacion_A.type.CargaFamilia;

@XmlAccessorType(XmlAccessType.FIELD)
public class ArrayCargasFamiliaType {

    @XmlElement(name = "cargaFamilia")
    private List<CargaFamilia> cargasFamilia = new ArrayList<>();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (CargaFamilia cargaFamilia : cargasFamilia) {
            sb.append("-------- CARGA FAMILIA --------------- \n");
            sb.append("tipoDoc: ").append(cargaFamilia.getTipoDoc()).append("\n");
            sb.append("nroDoc: ").append(cargaFamilia.getNroDoc()).append("\n");
            sb.append("apellido: ").append(cargaFamilia.getApellido()).append("\n");
            sb.append("nombre: ").append(cargaFamilia.getNombre()).append("\n");
            sb.append("fechaNac: ").append(cargaFamilia.getFechaNac()).append("\n");
            sb.append("mesDesde: ").append(cargaFamilia.getMesDesde()).append("\n");
            sb.append("mesHasta: ").append(cargaFamilia.getMesHasta()).append("\n");
            sb.append("parentesco: ").append(cargaFamilia.getParentesco()).append("\n");
            sb.append("vigenteProximosPeriodos: ").append(cargaFamilia.getVigenteProximosPeriodos()).append("\n");
            sb.append("fechaLimite: ").append(cargaFamilia.getFechaLimite()).append("\n");
            sb.append("porcentajeDeduccion: ").append(cargaFamilia.getPorcentajeDeduccion()).append("\n");
            
           
        }

        return sb.toString();
    }

    public List<CargaFamilia> getCargasFamilia() {
        return cargasFamilia;
    }
    
    
}
