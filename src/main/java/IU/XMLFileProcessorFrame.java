package IU;

import java.awt.Rectangle;
import java.awt.event.WindowAdapter;

import java.awt.event.WindowEvent;
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
import javax.swing.JFrame;
import util.DetalleNota;
import util.NotaList;

public class XMLFileProcessorFrame extends JFrame {

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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaOutput = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        tipoArchivoLabel = new javax.swing.JLabel();
        rutaArchivoLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabelCantArchivos = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        anioDeclaracionesJlabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocationByPlatform(true);
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 0, 0));

        jButton1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jButton1.setText("Actualizar declaracion");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextAreaOutput.setBackground(new java.awt.Color(51, 51, 51));
        jTextAreaOutput.setColumns(20);
        jTextAreaOutput.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jTextAreaOutput.setForeground(new java.awt.Color(255, 255, 255));
        jTextAreaOutput.setRows(5);
        jTextAreaOutput.setToolTipText("");
        jTextAreaOutput.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 1, true));
        jScrollPane1.setViewportView(jTextAreaOutput);

        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 153, 255));
        jLabel1.setText("DGC - ACTUALIZACION DE DECLARACIONES");

        tipoArchivoLabel.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        tipoArchivoLabel.setText("ffffffffff");

        rutaArchivoLabel.setText(".");

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel3.setText("Total archivos: ");

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\dgc06\\Documents\\Proyectos Java Netbeans\\procesadorXML\\src\\main\\java\\images\\importar.png")); // NOI18N
        jLabel5.setText("cargar archivo");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel5MousePressed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\dgc06\\Documents\\Proyectos Java Netbeans\\procesadorXML\\src\\main\\java\\images\\importar.png")); // NOI18N
        jLabel6.setText("cargar carpeta");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel6MousePressed(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\Users\\dgc06\\Documents\\Proyectos Java Netbeans\\procesadorXML\\src\\main\\java\\images\\setting.png")); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel7MousePressed(evt);
            }
        });

        anioDeclaracionesJlabel.setBackground(new java.awt.Color(255, 255, 255));
        anioDeclaracionesJlabel.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        anioDeclaracionesJlabel.setForeground(new java.awt.Color(51, 51, 51));
        anioDeclaracionesJlabel.setText("       AÑO: 2024");
        anioDeclaracionesJlabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 1, true));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 633, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jButton1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(530, 530, 530)
                        .addComponent(jLabel3)
                        .addGap(7, 7, 7)
                        .addComponent(jLabelCantArchivos, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(150, 150, 150)
                        .addComponent(jLabel7))
                    .addComponent(anioDeclaracionesJlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(58, 58, 58)
                            .addComponent(tipoArchivoLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rutaArchivoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(120, 120, 120)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(anioDeclaracionesJlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(tipoArchivoLabel))
                    .addComponent(rutaArchivoLabel))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel5)
                        .addGap(40, 40, 40)
                        .addComponent(jLabel6)
                        .addGap(50, 50, 50)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCantArchivos, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MousePressed
        // TODO add your handling code here:
          new SettingFrame(this).setVisible(true);
       // this.setOpacity(10);
        this.setEnabled(false);
    }//GEN-LAST:event_jLabel7MousePressed

    private void jLabel5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MousePressed
        try {
            // TODO add your handling code here:
            cargarOneElement();
        } catch (JAXBException ex) {
            Logger.getLogger(XMLFileProcessorFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(XMLFileProcessorFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(XMLFileProcessorFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(XMLFileProcessorFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel5MousePressed

    private void jLabel6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MousePressed
        try {
            // TODO add your handling code here:

            cargarManyElement();
        } catch (JAXBException ex) {
            Logger.getLogger(XMLFileProcessorFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(XMLFileProcessorFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(XMLFileProcessorFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(XMLFileProcessorFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(XMLFileProcessorFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(XMLFileProcessorFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel6MousePressed
    
     private void addJtextArea(String text){
        String espaciado = "\n";
        jTextAreaOutput.setText(jTextAreaOutput.getText()+espaciado+text );
    }
    
    public void setAnioPresentacion(String anio){
        anioDeclaracionesJlabel.setText(anio);
    } 
     
     
    private int recorrerArchivos(File carpeta, String extension) throws JAXBException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int count = 0;
        File[] archivos = carpeta.listFiles();

        if (archivos != null) {
            for (File archivo : archivos) {
                if (archivo.isFile()) {
                   if (archivo.isFile() && archivo.getName().toLowerCase().endsWith(extension)) {
                    count++;
                    processSeccion(archivo);
                     //  addJtextArea("PRESENTACION A - CORRECTA");
                    addJtextArea("Archivo: " + archivo.getName());
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
    
    private void actualizarFuente(String tipo, String ruta){
        tipoArchivoLabel.setText(tipo);
        rutaArchivoLabel.setText(ruta);
    }
    
    private void cargarOneElement() throws JAXBException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("XML Files", "xml");
        fileChooser.setFileFilter(filter);
        
        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            try {
                
                File selectedFile = fileChooser.getSelectedFile();
                String fileName = selectedFile.getName(); // Obtiene solo el nombre del archivo
                System.out.println(selectedFile.getAbsoluteFile());
                System.out.println(selectedFile.getAbsolutePath());
                System.out.println(selectedFile.getPath());
                actualizarFuente("Archivo Cargado:", selectedFile.getAbsolutePath());
                processSeccion(selectedFile);
                
                SwingUtilities.invokeLater(() -> {
                    this.rutaArchivoLabel.requestFocusInWindow(); // Asegurarse de que el JTextArea tenga el foco
                    this.rutaArchivoLabel.scrollRectToVisible(new Rectangle(0, 0, 1, 1)); // Desplazar al inicio
                });

            } catch (IllegalArgumentException ex) {
                Logger.getLogger(XMLFileProcessorFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvocationTargetException ex) {
                Logger.getLogger(XMLFileProcessorFrame.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    private void cargarManyElement() throws JAXBException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
         JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        FileNameExtensionFilter filter = new FileNameExtensionFilter("XML Files", "xml");
        fileChooser.setFileFilter(filter);

        int returnValue = fileChooser.showOpenDialog(null);
        
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            // Obtener la carpeta seleccionada
            File carpetaSeleccionada = fileChooser.getSelectedFile();
            actualizarFuente("Carpeta cargada: " , carpetaSeleccionada.getAbsolutePath());
            
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
            NotaList.getIntance().addNotaConErrores(selectedFile.getName(), "Nombre de presentacion incorrecto");
            Mensaje.error("El nombre del archivo XML no es válido");
            return; // Salir si el nombre no es válido
        }

        // Procesa según el tipo de sección
        if (XMLSeccionA.esNombreValido(nombre)) {
            XMLSeccionA xml = new XMLSeccionA(selectedFile);
            //xml.validarPresentacion();
            //this.jTextAreaOutput.removeAll();
            //this.jTextAreaOutput.setText(xml.toString());
          
            System.out.println(xml.toString());
            try {
                if (xml.esPresentacionActualizable()) {
                    xml.insertarEnBD(DataBasePostGre.getInstance(true));
                    NotaList.getIntance().addNotaActualizados(
                      selectedFile.getName(),
                      "Presentacion actulizada con exito"
                    );
                    return;
                }
               
                NotaList.getIntance().addNotaNoActualizados(
                           selectedFile.getName(),
                           "Ya existe un presentacion mas reciente"
                        );
                
                        
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
    private javax.swing.JLabel anioDeclaracionesJlabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelCantArchivos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaOutput;
    private javax.swing.JLabel rutaArchivoLabel;
    private javax.swing.JLabel tipoArchivoLabel;
    // End of variables declaration//GEN-END:variables
}
