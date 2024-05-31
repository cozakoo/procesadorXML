package xml;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import presentacion.presentacion_B.presentacionTypeSeccionB;

@XmlRootElement(name = "presentacion")
@XmlAccessorType(XmlAccessType.FIELD)
public class XMLSeccionB extends XMLSeccion {

    private static final String FORMATO_ARCHIVO_REGEX = "^\\d{" + LONGITUD_CUIT + "}_\\d{" + LONGITUD_PERIODO + "}" + NOMBRE_PREDEFINIDO + "\\d{" + LONGITUD_NUM_ENVIO + "}_b\\.xml$";

    @XmlElement(name = "presentacion")
    private presentacionTypeSeccionB presentacion;


    public XMLSeccionB(String nombreArchivo) throws JAXBException {
        super(nombreArchivo); // Llama al constructor de la clase base para validar y extraer el periodo
        JAXBContext jaxbContext = JAXBContext.newInstance(presentacionTypeSeccionB.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        this.presentacion = (presentacionTypeSeccionB) unmarshaller.unmarshal(new File(nombreArchivo));
    }

    public static boolean esNombreValido(String nombre) {
        Pattern pattern = Pattern.compile(FORMATO_ARCHIVO_REGEX);
        Matcher matcher = pattern.matcher(nombre);
        return matcher.matches();
    }

    @Override
    public String toString() {
        return presentacion.toString();

    }

    @Override
    public void validarPresentacion() throws JAXBException {
        // Validation logic for Seccion B
    }

}
