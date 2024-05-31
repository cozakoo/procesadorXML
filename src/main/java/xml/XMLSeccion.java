package xml;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.bind.JAXBException;

public abstract class XMLSeccion {

    protected static final int LONGITUD_CUIT = 11;
    protected static final int LONGITUD_PERIODO = 4;
    protected static final String NOMBRE_PREDEFINIDO = "_presentacion_";
    protected static final int LONGITUD_NUM_ENVIO = 3;

    private String periodo;

    private static final String FORMATO_ARCHIVO_REGEX = "^\\d{" + LONGITUD_CUIT + "}_\\d{" + LONGITUD_PERIODO + "}" + NOMBRE_PREDEFINIDO + "\\d{" + LONGITUD_NUM_ENVIO + "}\\.xml$";

    public static boolean esNombreValido(String nombre) {
        Pattern pattern = Pattern.compile(FORMATO_ARCHIVO_REGEX);
        Matcher matcher = pattern.matcher(nombre);

        return matcher.matches();
    }

    public XMLSeccion(String fileName) throws JAXBException {
        if (!esNombreValido(fileName)) {
            throw new IllegalArgumentException("El nombre del archivo no es válido.");
        }
        this.periodo = extractPeriodo(fileName);
    }

    private String extractPeriodo(String fileName) {
        String[] parts = fileName.split("_");
        if (parts.length > 1) {
            return parts[1];
        }
        throw new IllegalArgumentException("No se pudo extraer el periodo del nombre del archivo.");
    }

    public String getPeriodo() {
        return periodo;
    }

    
    public void validarPresentacion() throws JAXBException {

    }
}
