package xml;

import Interfaz.IConsultaSql;
import java.io.File;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.bind.JAXBException;
import main.DataBase;
import main.DataBasePostGre;

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

    public XMLSeccion(File selectedFile) throws JAXBException {

//        System.out.println("name:"+ selectedFile.getName());
//        if (!esNombreValido(selectedFile.getName())) {
//            throw new IllegalArgumentException("El nombre del archivo no es válido.");
//        }
        this.periodo = extractPeriodo(selectedFile.getName());
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
    

    static void limpiarDatosAnteriores(BigDecimal nrodocumento, DataBase db) throws SQLException {
        Statement stat = db.creatStatement();
        stat.addBatch(IConsultaSql.consulta_deduccion_delete + nrodocumento);
        stat.addBatch(IConsultaSql.consulta_familiares_delete + nrodocumento);
        stat.addBatch(IConsultaSql.consulta_ganLiqOtrosEmpl_delete + nrodocumento);
        stat.addBatch(IConsultaSql.consulta_retPerPagos_delete + nrodocumento);
        int[] resultados = stat.executeBatch();
        System.out.println("Registros eliminados: " + resultados.length);

    }

    static ResultSet obtenerUltimaPresentacionVigente(DataBase db , BigDecimal nroDocumento) {
        String query = IConsultaSql.consulta_utlima_preentacion + nroDocumento;
        return db.consulta(query);
    }

    public abstract boolean esPresentacionActualizable(DataBase db) throws SQLException;
    //verificar en AS400 si la fecha del xml es posterior a la que figura en la base datos

    public abstract void insertarEnBD(DataBase db);
    
}
