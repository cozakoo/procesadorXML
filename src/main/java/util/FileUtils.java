package util;

public class FileUtils {

    public static boolean esSeccionA(String nombreArchivo) {
        // Lógica para determinar si es Sección A
        return !nombreArchivo.toLowerCase().contains("_b");
    }

    public static boolean esSeccionB(String nombreArchivo) {
        // Lógica para determinar si es Sección B
        return nombreArchivo.toLowerCase().contains("_b");
    }

}
