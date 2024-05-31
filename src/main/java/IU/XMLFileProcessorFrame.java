package IU;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.bind.JAXBException;
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

        jButtonOpenFile = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaOutput = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonOpenFile.setText("Abrir Archivo");
        jButtonOpenFile.setToolTipText("");
        jButtonOpenFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOpenFileActionPerformed(evt);
            }
        });

        jTextAreaOutput.setColumns(20);
        jTextAreaOutput.setRows(5);
        jScrollPane1.setViewportView(jTextAreaOutput);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(jButtonOpenFile)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addComponent(jButtonOpenFile)
                .addGap(65, 65, 65)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonOpenFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOpenFileActionPerformed
        selectAndProcessXMLFile();
    }//GEN-LAST:event_jButtonOpenFileActionPerformed

    private void selectAndProcessXMLFile() {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("XML Files", "xml");
        fileChooser.setFileFilter(filter);

        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String fileName = selectedFile.getName(); // Obtiene solo el nombre del archivo
            processXMLFile(fileName);
        }
    }

    private void processXMLFile(String fileName) {
        try {
            if (esSeccionA(fileName)) {
                processSeccion(fileName, XMLSeccionA.class);
            } else if (esSeccionB(fileName)) {
                processSeccion(fileName, XMLSeccionB.class);
            } else {
                Mensaje.error("El nombre del archivo no corresponde a una sección válida.");
            }
        } catch (JAXBException e) {
            e.printStackTrace();
            Mensaje.error("Error processing the XML file.");
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

    private <T extends XMLSeccion> void processSeccion(String fileName, Class<T> clazz) throws JAXBException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (clazz.equals(XMLSeccionA.class) && !XMLSeccionA.esNombreValido(fileName)) {
            Mensaje.error("El nombre del archivo no es válido para Seccion A.");
            return;
        }
        if (clazz.equals(XMLSeccionB.class) && !XMLSeccionB.esNombreValido(fileName)) {
            Mensaje.error("El nombre del archivo no es válido para Seccion B.");
            return;
        }

        T seccion = clazz.getConstructor(String.class).newInstance(fileName);
        seccion.validarPresentacion();
//    jTextAreaOutput.setText(seccion.toString());
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
    private javax.swing.JButton jButtonOpenFile;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaOutput;
    // End of variables declaration//GEN-END:variables
}
