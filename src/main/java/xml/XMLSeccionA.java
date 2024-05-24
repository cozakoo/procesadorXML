package xml;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import presentacion.presentacion_A.presentacionTypeSeccionA;

@XmlRootElement(name = "presentacion")
@XmlAccessorType(XmlAccessType.FIELD)
public class XMLSeccionA extends XMLSeccion {

    @XmlElement(name = "presentacion")
    private presentacionTypeSeccionA presentacion;

    public XMLSeccionA(String nombreArchivo) throws JAXBException {

        JAXBContext jaxbContext = JAXBContext.newInstance(presentacionTypeSeccionA.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        this.presentacion = (presentacionTypeSeccionA) unmarshaller.unmarshal(new File(nombreArchivo));

    }

    @Override
    public String toString() {
        return presentacion.toString();
    }

}
