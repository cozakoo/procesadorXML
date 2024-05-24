package presentacion_A.arrayType;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import presentacion_A.type.ConceptoType;

@XmlAccessorType(XmlAccessType.FIELD)
public class ArrayDeduccionesType {

    @XmlElement(name = "deduccion")
    private List<ConceptoType> deduccion = new ArrayList<>();

    @Override
    public String toString() {

        for (ConceptoType concepto : deduccion) {
            System.out.print("--- DEDUCCION ");
            System.out.println("tipo: " + concepto.getTipo());
            System.out.println("tipoDoc: " + concepto.getTipoDoc());
            System.out.println("nroDoc: " + concepto.getNroDoc());
            System.out.println("denominacion: " + concepto.getDenominacion());
            System.out.println("descBasica: " + concepto.getDescBasica());
            System.out.println("montoTotal: " + concepto.getMontoTotal());
            
            System.out.println("----------- PERIODOS ----------- ");
            concepto.getPeriodos().toString();
        }
        return null;
    }

}
