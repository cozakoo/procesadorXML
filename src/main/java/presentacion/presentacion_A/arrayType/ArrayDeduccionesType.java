package presentacion_A.arrayType;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import presentacion.presentacion_A.type.ConceptoType;
import util.XmlUtils;

@XmlAccessorType(XmlAccessType.FIELD)
public class ArrayDeduccionesType {

    @XmlElement(name = "deduccion")
    private List<ConceptoType> deduccion = new ArrayList<>();

    @Override

    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (ConceptoType concepto : deduccion) {
            sb.append("------------DEDUCCION-------------------- \n");
            sb.append("tipo: ").append(concepto.getTipo()).append("\n");
            sb.append("tipoDoc: ").append(concepto.getTipoDoc()).append("\n");
            sb.append("nroDoc: ").append(concepto.getNroDoc()).append("\n");
            sb.append("denominacion: ").append(concepto.getDenominacion()).append("\n");
            sb.append("descBasica: ").append(concepto.getDescBasica()).append("\n");
            sb.append("montoTotal: ").append(concepto.getMontoTotal()).append("\n");

            sb.append("----------- PERIODOS ----------- \n");
            if(XmlUtils.ExisteEtiqueta(concepto.getPeriodos()))
               sb.append(concepto.getPeriodos().toString()).append("\n");
            

            sb.append("----------- DETALLES ----------- \n");
            if(XmlUtils.ExisteEtiqueta(concepto.getDetalles())){
              System.out.println("detalles distinto de null");
              sb.append(concepto.getDetalles().toString()).append("\n");
            }
            
            sb.append("---------------------------------------------- \n");
        }

        return sb.toString();
    }

    public List<ConceptoType> getDeduccion() {
        return deduccion;
    }
    
}
