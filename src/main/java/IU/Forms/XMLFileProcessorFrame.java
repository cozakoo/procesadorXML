package IU.Forms;

import java.awt.Rectangle;
import java.awt.event.WindowAdapter;

import java.awt.event.WindowEvent;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
import main.ConfigDB;
import main.DataBase;
import util.DetalleNota;
import util.NotaList;

public class XMLFileProcessorFrame extends JFrame {

    private ResultadoProcesoXmlForm resultadosForm;
    private int anioDeTrabajo = 0;
    private File file;
    private boolean isCarpetaSeleccionda = false;
    public XMLFileProcessorFrame() {
        initComponents();
        setLocationRelativeTo(null); // Centra la ventana
        setResizable(false); // No permite redimensionar la ventana
        anioDeTrabajo = ConfigDB.getInstance().getAnio();
        anioDeclaracionesJlabel.setText("AÑO: " + anioDeTrabajo);
//      setExtendedState(JFrame.MAXIMIZED_BOTH); // Permite maximizar la ventana
    }

    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinner1 = new javax.swing.JSpinner();
        jPanel1 = new javax.swing.JPanel();
        viewResultButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaOutput = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        tipoArchivoLabel = new javax.swing.JLabel();
        rutaArchivoLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        SelectedFileBotton = new javax.swing.JLabel();
        jLabelCantArchivos = new javax.swing.JLabel();
        SelectedFolderButton = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        anioDeclaracionesJlabel = new javax.swing.JLabel();
        iniciarImportacionBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocationByPlatform(true);
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 0, 0));

        viewResultButton.setBackground(new java.awt.Color(0, 204, 0));
        viewResultButton.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        viewResultButton.setForeground(new java.awt.Color(255, 255, 255));
        viewResultButton.setText("VER RESULTADOS");
        viewResultButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 0), 2, true));
        viewResultButton.setEnabled(false);
        viewResultButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewResultButtonActionPerformed(evt);
            }
        });

        jTextAreaOutput.setEditable(false);
        jTextAreaOutput.setBackground(new java.awt.Color(51, 51, 51));
        jTextAreaOutput.setColumns(20);
        jTextAreaOutput.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jTextAreaOutput.setForeground(new java.awt.Color(255, 255, 255));
        jTextAreaOutput.setRows(5);
        jTextAreaOutput.setToolTipText("");
        jTextAreaOutput.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        jScrollPane1.setViewportView(jTextAreaOutput);

        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 153, 255));
        jLabel1.setText("IMPORTACION DE DECLARACIONES - XML");

        tipoArchivoLabel.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        tipoArchivoLabel.setText("seleccionado");

        rutaArchivoLabel.setText(".");

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel3.setText("Total archivos: ");

        SelectedFileBotton.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        SelectedFileBotton.setIcon(new javax.swing.ImageIcon("C:\\Users\\dgc06\\Documents\\Proyectos Java Netbeans\\procesadorXML\\images\\importar.png")); // NOI18N
        SelectedFileBotton.setText("cargar archivo");
        SelectedFileBotton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                SelectedFileBottonMousePressed(evt);
            }
        });

        jLabelCantArchivos.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N

        SelectedFolderButton.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        SelectedFolderButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\dgc06\\Documents\\Proyectos Java Netbeans\\procesadorXML\\images\\importar.png")); // NOI18N
        SelectedFolderButton.setText("cargar carpeta");
        SelectedFolderButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                SelectedFolderButtonMousePressed(evt);
            }
        });

        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel7MousePressed(evt);
            }
        });

        anioDeclaracionesJlabel.setBackground(new java.awt.Color(255, 255, 255));
        anioDeclaracionesJlabel.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        anioDeclaracionesJlabel.setForeground(new java.awt.Color(51, 51, 51));
        anioDeclaracionesJlabel.setText("       AÑO: 2024");
        anioDeclaracionesJlabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        iniciarImportacionBtn.setBackground(new java.awt.Color(0, 153, 255));
        iniciarImportacionBtn.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        iniciarImportacionBtn.setForeground(new java.awt.Color(255, 255, 255));
        iniciarImportacionBtn.setText("INICIAR IMPORTACION");
        iniciarImportacionBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 255), 2, true));
        iniciarImportacionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarImportacionBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addComponent(anioDeclaracionesJlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(419, 419, 419)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelCantArchivos, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1)))
                        .addGap(284, 284, 284)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(121, 121, 121)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(SelectedFileBotton)
                                        .addGap(77, 77, 77)
                                        .addComponent(SelectedFolderButton)
                                        .addGap(22, 22, 22))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(tipoArchivoLabel)
                                .addGap(18, 18, 18)
                                .addComponent(rutaArchivoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(iniciarImportacionBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(viewResultButton, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(387, 387, 387)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(523, 523, 523)
                .addComponent(jLabel7)
                .addGap(41, 128, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(anioDeclaracionesJlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SelectedFileBotton)
                    .addComponent(SelectedFolderButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rutaArchivoLabel)
                    .addComponent(tipoArchivoLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCantArchivos, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(iniciarImportacionBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(viewResultButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addJtextArea(String text) {
        String espaciado = "\n";
        jTextAreaOutput.setText(jTextAreaOutput.getText() + espaciado + text);
        jTextAreaOutput.setCaretPosition(jTextAreaOutput.getDocument().getLength());
    }


    private void viewResultButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewResultButtonActionPerformed
        // TODO add your handling code here:
        if (viewResultButton.isEnabled()) {
            if (resultadosForm != null) {
                resultadosForm.setVisible(true);
                return;
            }

            resultadosForm = new ResultadoProcesoXmlForm(NotaList.getIntance());
            resultadosForm.setVisible(true);
        }
    }//GEN-LAST:event_viewResultButtonActionPerformed

    private void jLabel7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MousePressed
        // TODO add your handling code here:
        new SettingFrame(this).setVisible(true);
        // this.setOpacity(10);
        this.setEnabled(false);

    }//GEN-LAST:event_jLabel7MousePressed

    private File obtenerFile() {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("XML Files", "xml");
        fileChooser.setFileFilter(filter);

        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile();
        }

        return null;
    }

    private void cleanTextAreaOpt() {
        jTextAreaOutput.setText("");
    }

    private void inicializarAjustesDeCarga(String nameArchivo) {
        cleanTextAreaOpt();
        addJtextArea(nameArchivo);
        viewResultButton.setEnabled(false);
        setEnableBotonesCarga(false);
    }

    private void inicializarFormResultados() {
        resultadosForm = new ResultadoProcesoXmlForm(NotaList.getIntance());
        viewResultButton.setEnabled(true);
        setEnableBotonesCarga(true);
    }

    private void iniciarCargaArchivoUnico() {
        if (!SelectedFileBotton.isEnabled()) {
            return;
        }
        try {
            // TODO add your handling code here:
                if (file != null) {
                inicializarAjustesDeCarga(file.getName());
                cargarOneElement(file);
                inicializarFormResultados();

            }
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

    }

    private void SelectedFileBottonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SelectedFileBottonMousePressed

        if (!SelectedFileBotton.isEnabled()) {
            return;
        }
      
            // TODO add your handling code here:
            file = obtenerFile();
            
            rutaArchivoLabel.setText(file.getName());

    }//GEN-LAST:event_SelectedFileBottonMousePressed

    private File obtenerCarpeta() {
        
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        FileNameExtensionFilter filter = new FileNameExtensionFilter("XML Files", "xml");
        fileChooser.setFileFilter(filter);

        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile();
        }

        return null;
    }

    void setEnableBotonesCarga(boolean state) {
        SelectedFileBotton.setEnabled(state);
        SelectedFolderButton.setEnabled(state);
    }

    private void SelectedFolderButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SelectedFolderButtonMousePressed

        if (!SelectedFolderButton.isEnabled()) {
            return;
        }

        File carpeta = obtenerCarpeta();

        if (carpeta != null) {
            inicializarAjustesDeCarga(carpeta.getPath());
            new Thread(() -> {

                try {
                    cargarManyElement(carpeta);
                    // resultadosForm = new ResultadoProcesoXmlForm(NotaList.getIntance());
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
                inicializarFormResultados();
            }).start();
        }

    }//GEN-LAST:event_SelectedFolderButtonMousePressed
   
    private void iniciarCargaCarpeta(){
       
    }
    
    
    private void iniciarImportacionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciarImportacionBtnActionPerformed
        // TODO add your handling code here:
        if(file == null) return;
        
        if(!isCarpetaSeleccionda){
           System.out.println("inicio importacion xml");
           iniciarCargaArchivoUnico();
           viewResultButton.setEnabled(true);
        }
        
        
        
    }//GEN-LAST:event_iniciarImportacionBtnActionPerformed

    public void setAnioPresentacion(String anio) {
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
                        addJtextArea("Archivo pasado : " + archivo.getName());
                        System.out.println("Archivo: " + archivo.getAbsolutePath());
                    }
                } else if (archivo.isDirectory()) {
                    System.out.println("Carpeta: " + archivo.getAbsolutePath());
                    // Llamada recursiva para la carpeta encontrada
                    count += recorrerArchivos(archivo, extension);
                }
            }
        }

        System.out.println("actualizados" + NotaList.getIntance().getActualizados().size());
        System.out.println("NO actualizados" + NotaList.getIntance().getNoActualizados().size());
        System.out.println("ERRORES" + NotaList.getIntance().getConErrores().size());
        return count;
    }

    private void actualizarFuente(String tipo, String ruta) {
        tipoArchivoLabel.setText(tipo);
        rutaArchivoLabel.setText(ruta);
    }

    private void cargarOneElement(File selectedFile) throws JAXBException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

        limpiarListas();
        String fileName = selectedFile.getName(); // Obtiene solo el nombre del archivo
        System.out.println(selectedFile.getAbsoluteFile());
        System.out.println(selectedFile.getAbsolutePath());
        System.out.println(selectedFile.getPath());
        actualizarFuente("Archivo Cargado:", selectedFile.getAbsolutePath());
        processSeccion(selectedFile);
        jLabelCantArchivos.setText("1");
    }

    private void cargarManyElement(File carpetaSeleccionada) throws JAXBException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

        actualizarFuente("Carpeta cargada: ", carpetaSeleccionada.getAbsolutePath());

        limpiarListas();
        // Recorrer archivos dentro de la carpeta
        ArrayList<Object> listaNopasados = new ArrayList<>();
        int cantArchivos = recorrerArchivos(carpetaSeleccionada, ".xml");

        //addJtextArea(NotaList.getIntance().toString());
        jLabelCantArchivos.setText(Integer.toString(cantArchivos));
        System.out.println("total archivos encontrados: " + cantArchivos);

    }

    private <T extends XMLSeccion> void processSeccion(File selectedFile) throws JAXBException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        String nombre = selectedFile.getName();
        DataBase db = DataBasePostGre.getInstance(true);
        // Verifica la validez del nombre de archivo
        if (!XMLSeccionA.esNombreValido(nombre) && !XMLSeccionB.esNombreValido(nombre)) {
            NotaList.getIntance().addNotaConErrores(selectedFile.getName(), "Nombre de presentacion incorrecto");
            Mensaje.error("El nombre del archivo XML no es válido");
            return; // Salir si el nombre no es válido
        }

        try {

            if (XMLSeccionA.esNombreValido(nombre)) {
                XMLSeccionA xml = new XMLSeccionA(selectedFile);

                System.out.println(xml.toString());

                if (xml.existeAgente(db)) {
                    if (xml.esPresentacionActualizable(db)) {
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
                    return;
                }
                //No existe agente
                NotaList.getIntance().addNotaConErrores(
                        nombre, "| ERROR: el agente no existe"
                );
                //Puedes hacer algo con el objeto xml aquí si es necesario
                return;
            }

            if (XMLSeccionB.esNombreValido(nombre)) {
                XMLSeccionB xml = new XMLSeccionB(selectedFile);

                if (xml.existeAgente(db)) {
                    if (xml.esPresentacionActualizable(db)) {
                        xml.insertarEnBD(db);
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
                    return;
                }
                NotaList.getIntance().addNotaConErrores(
                        nombre, "| ERROR: el agente no existe"
                );

            }
        } catch (SQLException ex) {
            Logger.getLogger(XMLFileProcessorFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel SelectedFileBotton;
    private javax.swing.JLabel SelectedFolderButton;
    private javax.swing.JLabel anioDeclaracionesJlabel;
    private javax.swing.JButton iniciarImportacionBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelCantArchivos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTextArea jTextAreaOutput;
    private javax.swing.JLabel rutaArchivoLabel;
    private javax.swing.JLabel tipoArchivoLabel;
    private javax.swing.JButton viewResultButton;
    // End of variables declaration//GEN-END:variables

    private void limpiarListas() {
        NotaList nota = NotaList.getIntance();
        nota.getActualizados().clear();
        nota.getConErrores().clear();
        nota.getNoActualizados().clear();
    }

}
