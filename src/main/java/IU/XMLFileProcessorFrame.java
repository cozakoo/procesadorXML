package IU;

import java.awt.Rectangle;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.bind.JAXBException;
import main.DataBasePostGre;
import static util.FileUtils.esSeccionA;
import static util.FileUtils.esSeccionB;
import util.Mensaje;
import xml.XMLSeccion;
import xml.XMLSeccionA;
import xml.XMLSeccionB;

public class XMLFileProcessorFrame extends javax.swing.JFrame {

    public XMLFileProcessorFrame() {
        initComponents();
        setLocationRelativeTo(null); // Centra la ventana
        setResizable(false); // No permite redimensionar la ventana
//        setExtendedState(JFrame.MAXIMIZED_BOTH); // Permite maximizar la ventana
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButtonOpenFile = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaOutput = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nombreArchivo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabelCantArchivos = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFocusCycleRoot(false);
        setLocationByPlatform(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jButton1.setText("Actualizar declaracion");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 500, 250, -1));

        jButtonOpenFile.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jButtonOpenFile.setText("Cargar Archivo");
        jButtonOpenFile.setToolTipText("");
        jButtonOpenFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOpenFileActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonOpenFile, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 69, 238, -1));

        jTextAreaOutput.setBackground(new java.awt.Color(51, 51, 51));
        jTextAreaOutput.setColumns(20);
        jTextAreaOutput.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jTextAreaOutput.setForeground(new java.awt.Color(255, 255, 255));
        jTextAreaOutput.setRows(5);
        jTextAreaOutput.setToolTipText("");
        jScrollPane1.setViewportView(jTextAreaOutput);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 129, 659, 356));

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel1.setText("DGC - ACTUALIZACION DE DECLARACIONES");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 24, 388, 27));

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel2.setText("Nombre archivo:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 107, -1, -1));
        jPanel1.add(nombreArchivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 107, 517, -1));

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel3.setText("Total archivos: ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(518, 107, -1, 20));
        jPanel1.add(jLabelCantArchivos, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 107, 80, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonOpenFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOpenFileActionPerformed
        try {
            selectAndProcessXMLFile();
        } catch (JAXBException ex) {
            Logger.getLogger(XMLFileProcessorFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(XMLFileProcessorFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(XMLFileProcessorFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(XMLFileProcessorFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonOpenFileActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed
    
     private void addJtextArea(String text){
        String espaciado = "\n";
        jTextAreaOutput.setText(jTextAreaOutput.getText()+espaciado+text );
    }
    
    private int recorrerArchivos(File carpeta, String extension) {
        int count = 0;
        File[] archivos = carpeta.listFiles();

        if (archivos != null) {
            for (File archivo : archivos) {
                if (archivo.isFile()) {
                   if (archivo.isFile() && archivo.getName().toLowerCase().endsWith(extension)) {
                    count++;
                    addJtextArea("Archivo: " + archivo.getAbsolutePath());
                    System.out.println("Archivo: " + archivo.getAbsolutePath());
                   }
                } else if (archivo.isDirectory()) {
                    System.out.println("Carpeta: " + archivo.getAbsolutePath());
                    // Llamada recursiva para la carpeta encontrada
                    count += recorrerArchivos(archivo, extension);
                }
            }
        }
        return count;
    }

    private void cargarOneElement() throws JAXBException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("XML Files", "xml");
        fileChooser.setFileFilter(filter);

        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            try {
                this.nombreArchivo.setText("");
                File selectedFile = fileChooser.getSelectedFile();
                String fileName = selectedFile.getName(); // Obtiene solo el nombre del archivo
                processSeccion(selectedFile);
                this.nombreArchivo.setText(fileName);
                SwingUtilities.invokeLater(() -> {
                    this.nombreArchivo.requestFocusInWindow(); // Asegurarse de que el JTextArea tenga el foco
                    this.nombreArchivo.scrollRectToVisible(new Rectangle(0, 0, 1, 1)); // Desplazar al inicio
                });

            } catch (IllegalArgumentException ex) {
                Logger.getLogger(XMLFileProcessorFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvocationTargetException ex) {
                Logger.getLogger(XMLFileProcessorFrame.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    private void cargarManyElement() throws JAXBException, NoSuchMethodException, InstantiationException, IllegalAccessException {
         JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        FileNameExtensionFilter filter = new FileNameExtensionFilter("XML Files", "xml");
        fileChooser.setFileFilter(filter);

        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            // Obtener la carpeta seleccionada
            File carpetaSeleccionada = fileChooser.getSelectedFile();
            System.out.println("Carpeta seleccionada: " + carpetaSeleccionada.getAbsolutePath());

            // Recorrer archivos dentro de la carpeta
            int cantArchivos = recorrerArchivos(carpetaSeleccionada, ".xml");
            
            jLabelCantArchivos.setText(Integer.toString(cantArchivos));
            System.out.println("total archivos encontrados: " + cantArchivos);
        } else {
            System.out.println("No se seleccionó ninguna carpeta.");
        }
    }
   
    
   
    private void selectAndProcessXMLFile() throws JAXBException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        jLabelCantArchivos.setText("0");
        //cargarManyElement();
         cargarOneElement();
    }

    private <T extends XMLSeccion> void processSeccion(File selectedFile) throws JAXBException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        String nombre = selectedFile.getName();

        // Verifica la validez del nombre de archivo
        if (!XMLSeccionA.esNombreValido(nombre) && !XMLSeccionB.esNombreValido(nombre)) {
            Mensaje.error("El nombre del archivo XML no es válido");
            return; // Salir si el nombre no es válido
        }

        // Procesa según el tipo de sección
        if (XMLSeccionA.esNombreValido(nombre)) {
            XMLSeccionA xml = new XMLSeccionA(selectedFile);
            //xml.validarPresentacion();
            this.jTextAreaOutput.removeAll();
            this.jTextAreaOutput.setText(xml.toString());
            this.nombreArchivo.setText(nombre);
            System.out.println(xml.toString());
            try {
                if (xml.esPresentacionActualizable()) {
                    xml.insertarEnBD(DataBasePostGre.getInstance(true));
                    return;
                }
                // Puedes hacer algo con el objeto xml aquí si es necesario
            } catch (SQLException ex) {
                Logger.getLogger(XMLFileProcessorFrame.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        if (XMLSeccionB.esNombreValido(nombre)) {
            XMLSeccionB xml = new XMLSeccionB(selectedFile);

            //        xml.validarPresentacion();
            this.jTextAreaOutput.setText(xml.toString());

        }
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(XMLFileProcessorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(XMLFileProcessorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(XMLFileProcessorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(XMLFileProcessorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new XMLFileProcessorFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonOpenFile;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelCantArchivos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaOutput;
    private javax.swing.JLabel nombreArchivo;
    // End of variables declaration//GEN-END:variables
}
