package util;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileUtils {
   
    public static boolean esSeccionA(String nombreArchivo) {
        // Lógica para determinar si es Sección A
        return !nombreArchivo.toLowerCase().contains("_b");
        
    }

    public static boolean esSeccionB(String nombreArchivo) {
        // Lógica para determinar si es Sección B
        return nombreArchivo.toLowerCase().contains("_b");
    }
    
     public static File obtenerFile( String extension, String descripcion) {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(descripcion, extension);
        fileChooser.setFileFilter(filter);

        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile();
        }

        return null;
    }

}
