package presentacion_A.arrayType;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import presentacion_A.type.ConceptoType;

@XmlAccessorType(XmlAccessType.FIELD)
public class ArrayRetPerPagosType {

    @XmlElement(name = "deduccion")
    private List<ConceptoType> deduccion = new ArrayList<>();

}
