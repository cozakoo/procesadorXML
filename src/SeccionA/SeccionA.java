package SeccionA;

import Formulario572.Formulario572SeccionA;

public class SeccionA {
    
    final int LONGITUD_CUIT = 11;
    final int LONGITUD_PERIODO = 4;
    final String NOMBRE_PREDEFINIDO = "_presentacion_";
    
    private String nombreArchivo;
    private String cuit;
    private int anio;
    private int nroEnvio = 1;
    
    private Formulario572SeccionA archivoXml;

    public SeccionA(Formulario572SeccionA archivoXml) {
    }
    
    
    
    
    // Se agrega un método para generar el nombre del archivo según las especificaciones dadas
    public String generarNombreArchivo() {
        return String.format("%s_%04d%s%d.xml", cuit, anio, NOMBRE_PREDEFINIDO, nroEnvio);
    }
    
}
