package xml;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class XMLSeccion {
    protected static final int LONGITUD_CUIT = 11;
    protected static final int LONGITUD_PERIODO = 4;
    protected static final String NOMBRE_PREDEFINIDO = "_presentacion_";
    protected static final int LONGITUD_NUM_ENVIO = 3;

    private static final String FORMATO_ARCHIVO_REGEX = "^\\d{" + LONGITUD_CUIT + "}_\\d{" + LONGITUD_PERIODO + "}" + NOMBRE_PREDEFINIDO + "\\d{" + LONGITUD_NUM_ENVIO + "}\\.xml$";

    public static boolean esNombreValido(String nombre) {
        Pattern pattern = Pattern.compile(FORMATO_ARCHIVO_REGEX);
        Matcher matcher = pattern.matcher(nombre);
        return matcher.matches();
    }
    
}
