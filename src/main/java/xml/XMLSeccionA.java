package xml;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import presentacion.presentacion_A.type.presentacionTypeSeccionA;

@XmlRootElement(name = "presentacion")
@XmlAccessorType(XmlAccessType.FIELD)
public class XMLSeccionA extends XMLSeccion {

    @XmlElement(name = "presentacion")
    private presentacionTypeSeccionA presentacion;

    public XMLSeccionA(File selectedFile) throws JAXBException {
        super(selectedFile); // Llama al constructor de la clase base para validar y extraer el periodo
        JAXBContext jaxbContext = JAXBContext.newInstance(presentacionTypeSeccionA.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        this.presentacion = (presentacionTypeSeccionA) unmarshaller.unmarshal(selectedFile);
    }


    @Override
    public String toString() {
        return presentacion.toString();
    }

    @Override
    public void validarPresentacion() throws JAXBException {
        this.presentacion.validar(getPeriodo());
    }

}
