package presentacion_A;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
class ArrayRetPerPagosType {

    @XmlElement(name = "deduccion")
    private List<ConceptoType> deduccion = new ArrayList<>();

}
