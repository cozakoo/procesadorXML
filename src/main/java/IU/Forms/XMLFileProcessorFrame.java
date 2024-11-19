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

    public XMLFileProcessorFrame() {
        initComponents();
        setLocationRelativeTo(null); // Centra la ventana
        setResizable(false); // No permite redimensionar la ventana
        anioDeTrabajo = ConfigDB.getInstance().getAnio();
        anioDeclaracionesJlabel.setText("AÑO: " + anioDeTrabajo);
//        setExtendedState(JFrame.MAXIMIZED_BOTH); // Permite maximizar la ventana
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocationByPlatform(true);
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 0, 0));

        viewResultButton.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        viewResultButton.setText("Actualizar declaracion");
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
        jTextAreaOutput.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 1, true));
        jScrollPane1.setViewportView(jTextAreaOutput);

        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 153, 255));
        jLabel1.setText("IMPORTACION DE DECLARACIONES - XML");

        tipoArchivoLabel.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        tipoArchivoLabel.setText("ffffffffff");

        rutaArchivoLabel.setText(".");

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel3.setText("Total archivos: ");

        SelectedFileBotton.setText("cargar archivo");
        SelectedFileBotton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                SelectedFileBottonMousePressed(evt);
            }
        });

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
                            .addComponent(SelectedFileBotton)
                            .addComponent(SelectedFolderButton)
                            .addComponent(viewResultButton)))
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
                        .addComponent(SelectedFileBotton)
                        .addGap(40, 40, 40)
                        .addComponent(SelectedFolderButton)
                        .addGap(50, 50, 50)
                        .addComponent(viewResultButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
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
    private void SelectedFileBottonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SelectedFileBottonMousePressed

        if (!SelectedFileBotton.isEnabled()) {
            return;
        }
        try {
            // TODO add your handling code here:
            File archivo = obtenerFile();
            if (archivo != null) {
                inicializarAjustesDeCarga(archivo.getName());
                cargarOneElement(archivo);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelCantArchivos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
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
