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

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButtonOpenFile = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaOutput = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFocusCycleRoot(false);
        setLocationByPlatform(true);

        jButton1.setText("Actualizar declaracion");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButtonOpenFile.setText("Cargar Archivo");
        jButtonOpenFile.setToolTipText("");
        jButtonOpenFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOpenFileActionPerformed(evt);
            }
        });

        jTextAreaOutput.setBackground(new java.awt.Color(51, 51, 51));
        jTextAreaOutput.setColumns(20);
        jTextAreaOutput.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jTextAreaOutput.setForeground(new java.awt.Color(255, 255, 255));
        jTextAreaOutput.setRows(5);
        jTextAreaOutput.setToolTipText("");
        jScrollPane1.setViewportView(jTextAreaOutput);

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel1.setText("DGC - ACTUALIZACION DE DECLARACIONES");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addComponent(jButtonOpenFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(221, 221, 221))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1)
                .addGap(10, 10, 10))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(184, 184, 184))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
                .addGap(133, 133, 133))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonOpenFile)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void selectAndProcessXMLFile() throws JAXBException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("XML Files", "xml");
        fileChooser.setFileFilter(filter);

        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            try {
                File selectedFile = fileChooser.getSelectedFile();
                String fileName = selectedFile.getName(); // Obtiene solo el nombre del archivo
                processSeccion(selectedFile);
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(XMLFileProcessorFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvocationTargetException ex) {
                Logger.getLogger(XMLFileProcessorFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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
//        xml.validarPresentacion();
        this.jTextAreaOutput.removeAll();
        this.jTextAreaOutput.setText(xml.toString());
        System.out.println(xml.toString());
        // Puedes hacer algo con el objeto xml aquí si es necesario
    } else if (XMLSeccionB.esNombreValido(nombre)) {
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaOutput;
    // End of variables declaration//GEN-END:variables
}
