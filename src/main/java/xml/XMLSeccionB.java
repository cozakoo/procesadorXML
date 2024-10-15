package xml;

import java.io.File;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import main.DataBase;
import presentacion.presentacion_B.presentacionTypeSeccionB;

@XmlRootElement(name = "presentacion")
@XmlAccessorType(XmlAccessType.FIELD)
public class XMLSeccionB extends XMLSeccion {

    private static final String FORMATO_ARCHIVO_REGEX = "^\\d{" + LONGITUD_CUIT + "}_\\d{" + LONGITUD_PERIODO + "}" + NOMBRE_PREDEFINIDO + "\\d{" + LONGITUD_NUM_ENVIO + "}_b\\.xml$";

    @XmlElement(name = "presentacion")
    private presentacionTypeSeccionB presentacion;


    public XMLSeccionB(File selectedFile) throws JAXBException {
//        if(!esNombreValido(selectedFile.getName())){
//            throw new IllegalArgumentException("El nombre del archivo no es válido.");
//        }
        super(selectedFile);
        JAXBContext jaxbContext = JAXBContext.newInstance(presentacionTypeSeccionB.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        this.presentacion = (presentacionTypeSeccionB) unmarshaller.unmarshal(selectedFile);
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
    public boolean esPresentacionActualizable() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insertarEnBD(DataBase db) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

  
 

}
