/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package IU.Forms;

import IU.Buttons.Modificar.ModificarButton_conceptos;
import Interfaz.IConsultaSql;
import Interfaz.UpdateListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import main.ConcepParam;
import main.DataBase;
import main.DataBasePostGre;
import util.Mensaje;

/**
 *
 * @author dgc06
 */
public class ConcParamForm extends javax.swing.JFrame {

    /**
     * Creates new form AbmConcParam
     */
    private int ley;
    private int concepto;
    private ConcepParam concP;
    private boolean isEdicion;
    private DataBase db;
    private UpdateListener update;

    public ConcParamForm(boolean isEdicion, DataBase db, UpdateListener update) {
        initComponents();
        this.db = db;
        this.isEdicion = isEdicion;
        this.update = update;
        jButton.setText(isEdicion ? "MODIFICAR DATOS" : "CREAR REGISTRO");

        cargarComboBox();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        concjTextF = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tipoConcejCBox = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        tipoRemunjCBox = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        tipoIIGGjCBox = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        leyjTextF = new javax.swing.JTextField();
        descripjTextF = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        iiggCBox = new javax.swing.JCheckBox();
        jButton = new javax.swing.JButton();
        librajCheckBox = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        tipoLibramCoBox = new javax.swing.JComboBox<>();
        sicossjCheckBox = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        tipoSicossjComboBox = new javax.swing.JComboBox<>();
        sicorejCheckBox = new javax.swing.JCheckBox();
        jLabel10 = new javax.swing.JLabel();
        tipoSicorejComboBox = new javax.swing.JComboBox<>();
        agregarTipoIIGGLabel = new javax.swing.JLabel();
        agregarTipoLibraLabel1 = new javax.swing.JLabel();
        agregarTipoSicossLabel = new javax.swing.JLabel();
        agregarTipoSicoreLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Tipo IIGG:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 450, -1, -1));

        concjTextF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                concjTextFActionPerformed(evt);
            }
        });
        concjTextF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                concjTextFKeyTyped(evt);
            }
        });
        jPanel1.add(concjTextF, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, 86, -1));

        jLabel2.setText("N° de concepto:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, -1, -1));

        tipoConcejCBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                tipoConcejCBoxItemStateChanged(evt);
            }
        });
        tipoConcejCBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoConcejCBoxActionPerformed(evt);
            }
        });
        jPanel1.add(tipoConcejCBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 100, -1));

        jLabel3.setText("Tipo concepto:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, -1, -1));

        tipoRemunjCBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoRemunjCBoxActionPerformed(evt);
            }
        });
        jPanel1.add(tipoRemunjCBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 210, 100, 20));

        jLabel4.setText("Tipo remuneracion:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 190, -1, -1));

        tipoIIGGjCBox.setEnabled(false);
        jPanel1.add(tipoIIGGjCBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 470, 90, -1));

        jLabel5.setText("Ley: ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, -1, -1));

        leyjTextF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leyjTextFActionPerformed(evt);
            }
        });
        leyjTextF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                leyjTextFKeyTyped(evt);
            }
        });
        jPanel1.add(leyjTextF, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 86, -1));

        descripjTextF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descripjTextFActionPerformed(evt);
            }
        });
        jPanel1.add(descripjTextF, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 270, -1));

        jLabel6.setText("Descripcion");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, -1, -1));

        iiggCBox.setText("IIGG");
        iiggCBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iiggCBoxActionPerformed(evt);
            }
        });
        jPanel1.add(iiggCBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 460, -1, -1));

        jButton.setBackground(new java.awt.Color(0, 102, 204));
        jButton.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jButton.setForeground(new java.awt.Color(255, 255, 255));
        jButton.setText("CREAR NUEVO CONCEPTO");
        jButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActionPerformed(evt);
            }
        });
        jPanel1.add(jButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 530, -1, 40));

        librajCheckBox.setText("libramiento");
        librajCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                librajCheckBoxActionPerformed(evt);
            }
        });
        jPanel1.add(librajCheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, -1, -1));

        jLabel7.setText("Tipo libramiento:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 260, -1, -1));

        tipoLibramCoBox.setEnabled(false);
        jPanel1.add(tipoLibramCoBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 280, 90, -1));

        sicossjCheckBox.setText("SICOSS");
        sicossjCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sicossjCheckBoxActionPerformed(evt);
            }
        });
        jPanel1.add(sicossjCheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, -1, -1));

        jLabel9.setText("Tipo SICOSS:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 320, -1, -1));

        tipoSicossjComboBox.setEnabled(false);
        jPanel1.add(tipoSicossjComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 340, 90, -1));

        sicorejCheckBox.setText("SICORE");
        sicorejCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sicorejCheckBoxActionPerformed(evt);
            }
        });
        jPanel1.add(sicorejCheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 400, -1, -1));

        jLabel10.setText("Tipo SICORE:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 390, -1, -1));

        tipoSicorejComboBox.setEnabled(false);
        jPanel1.add(tipoSicorejComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 410, 90, -1));

        agregarTipoIIGGLabel.setIcon(new javax.swing.ImageIcon("C:\\Users\\dgc06\\Documents\\Proyectos Java Netbeans\\procesadorXML\\images\\agregar.png")); // NOI18N
        agregarTipoIIGGLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                agregarTipoIIGGLabelMousePressed(evt);
            }
        });
        jPanel1.add(agregarTipoIIGGLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 470, -1, -1));

        agregarTipoLibraLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\dgc06\\Documents\\Proyectos Java Netbeans\\procesadorXML\\images\\agregar.png")); // NOI18N
        agregarTipoLibraLabel1.setToolTipText("Crear nuevo tipo");
        agregarTipoLibraLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                agregarTipoLibraLabel1MousePressed(evt);
            }
        });
        jPanel1.add(agregarTipoLibraLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 260, -1, -1));

        agregarTipoSicossLabel.setIcon(new javax.swing.ImageIcon("C:\\Users\\dgc06\\Documents\\Proyectos Java Netbeans\\procesadorXML\\images\\agregar.png")); // NOI18N
        agregarTipoSicossLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                agregarTipoSicossLabelMousePressed(evt);
            }
        });
        jPanel1.add(agregarTipoSicossLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 330, -1, -1));

        agregarTipoSicoreLabel.setIcon(new javax.swing.ImageIcon("C:\\Users\\dgc06\\Documents\\Proyectos Java Netbeans\\procesadorXML\\images\\agregar.png")); // NOI18N
        agregarTipoSicoreLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                agregarTipoSicoreLabelMousePressed(evt);
            }
        });
        jPanel1.add(agregarTipoSicoreLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 400, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void CargarDatosModificacion(int ley, int concepto) {
        this.ley = ley;
        this.concepto = concepto;
        recuperarInformacion();
        cargarComboBox();
        cargarDatosEnFom();
        
    }

    private void concjTextFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_concjTextFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_concjTextFActionPerformed

    private void leyjTextFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leyjTextFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_leyjTextFActionPerformed

    private void descripjTextFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descripjTextFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_descripjTextFActionPerformed

    private void tipoRemunjCBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoRemunjCBoxActionPerformed
        // TODO add your handling code here:
        obtenerTiposIIGG();
    }//GEN-LAST:event_tipoRemunjCBoxActionPerformed

    private void actulizarEstadoCombox(JComboBox<String> comBox, boolean state) {
        comBox.setEnabled(state);
    }

    private void librajCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_librajCheckBoxActionPerformed
        // TODO add your handling code here:
        actulizarEstadoCombox(tipoLibramCoBox, librajCheckBox.isSelected());
    }//GEN-LAST:event_librajCheckBoxActionPerformed

    private void sicossjCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sicossjCheckBoxActionPerformed
        // TODO add your handling code here:
        actulizarEstadoCombox(tipoSicossjComboBox, sicossjCheckBox.isSelected());
    }//GEN-LAST:event_sicossjCheckBoxActionPerformed

    private void preparateCombo(JComboBox<String> cbox) {
        cbox.removeAllItems();
        //cbox.setEnabled(true);

    }

    private void obtenerTiposSicoss() {
        try {
            String tipoConc = getTipoConc();
            String tipoRem = getTipoRemun();
            String sql = "select DISTINCT tiposicoss from concparam "
                       + "where tipoconc = '" + tipoConc + "' and tiporemun = '" + tipoRem + "'";
            ResultSet result = DataBasePostGre.getInstance(true).consulta(sql);
            ArrayList<String> listRemun = new ArrayList<>();
            preparateCombo(tipoSicossjComboBox);
            while (result.next()) {
                String item = result.getString(1);
                tipoSicossjComboBox.addItem(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConcParamForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void obtenerTiposRemun(String seleccionado) throws SQLException {
        String sql = "select DISTINCT tiporemun from concparam "
                + "where tipoconc = '" + seleccionado + "'";
        ResultSet result = DataBasePostGre.getInstance(true).consulta(sql);
        ArrayList<String> listRemun = new ArrayList<>();
        while (result.next()) {
            String item = result.getString(1);
            listRemun.add(item);
        }

        if (listRemun.size() != 0) {
            preparateCombo(tipoRemunjCBox);
            for (String item : listRemun) {
                tipoRemunjCBox.addItem(item);
            }
        }
    }

    private void obtenerTiposLibram() throws SQLException {
        String sql = "Select distinct tipolibra from concparam "
                + "where libra = 1";
        ResultSet result = DataBasePostGre.getInstance(true).consulta(sql);
        ArrayList<String> listLibra = new ArrayList<>();
        while (result.next()) {
            String item = result.getString(1);
            listLibra.add(item);
        }
        preparateCombo(tipoLibramCoBox);
        if (!listLibra.isEmpty()) {
            for (String item : listLibra) {
                tipoLibramCoBox.addItem(item);
            }
        }
    }

    private void tipoConcejCBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoConcejCBoxActionPerformed
        try {
            // TODO add your handling code here:
            String seleccionado = (String) tipoConcejCBox.getSelectedItem();
            obtenerTiposRemun(seleccionado);
            obtenerTiposIIGG();
            obtenerTiposSicoss();
            obtenerTipoSicore();
            obtenerTiposLibram();

        } catch (SQLException ex) {
            Logger.getLogger(ConcParamForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_tipoConcejCBoxActionPerformed

    private void tipoConcejCBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tipoConcejCBoxItemStateChanged
//        try {
//            // TODO add your handling code here:
//            String seleccionado = (String) tipoConcejCBox.getSelectedItem();
//            obteneTiposRemun(seleccionado);
//        } catch (SQLException ex) {
//            Logger.getLogger(AbmConcParam.class.getName()).log(Level.SEVERE, null, ex);
//        }

    }//GEN-LAST:event_tipoConcejCBoxItemStateChanged

    private String getTipoConc() {
        return (String) tipoConcejCBox.getSelectedItem();
    }

    private String getTipoRemun() {
        return (String) tipoRemunjCBox.getSelectedItem();
    }

    private void obtenerTipoSicore() {
        try {
            String tipoConc = getTipoConc();
            String tipoRem = getTipoRemun();
            String sql = "select DISTINCT tiposicore from concparam "
                    + "where tipoconc = '" + tipoConc + "' and tiporemun = '" + tipoRem + "'";
            ResultSet result = DataBasePostGre.getInstance(true).consulta(sql);
            ArrayList<String> listRemun = new ArrayList<>();
            preparateCombo(tipoSicorejComboBox);
            while (result.next()) {
                String item = result.getString(1);
                tipoSicorejComboBox.addItem(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConcParamForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void obtenerTiposIIGG() {

        try {
            String tipoConc = getTipoConc();
            String tipoRem = getTipoRemun();
            String sql = "select DISTINCT tipoigg from concparam "
                    + "where tipoconc = '" + tipoConc + "' and tiporemun = '" + tipoRem + "'";
            ResultSet result = DataBasePostGre.getInstance(true).consulta(sql);
            ArrayList<String> listRemun = new ArrayList<>();
            preparateCombo(tipoIIGGjCBox);
            while (result.next()) {
                String item = result.getString(1);
                tipoIIGGjCBox.addItem(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConcParamForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    private void iiggCBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iiggCBoxActionPerformed
        // TODO add your handling code here:
        boolean state = false;
        if (iiggCBox.isSelected()) {
            state = true;
        }
        tipoIIGGjCBox.setEnabled(state);

    }//GEN-LAST:event_iiggCBoxActionPerformed

    private void insertarNuevoConcepto(ConcepParam conceptos) {
        try {
            String sql = "INSERT INTO concparam (ley, conc, descrip, tipoconc, tiporemun, libra, tipolibra, sicoss, tiposicoss, iigg, tipoigg, sicore, tiposicore) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement pstmt = DataBasePostGre.getInstance(true).getPreparedStatement(sql);
            int i = 1;
            pstmt.setInt(i, conceptos.getLey());
            pstmt.setInt(++i, conceptos.getConc());
            pstmt.setString(++i, conceptos.getDescrip());
            pstmt.setString(++i, conceptos.getTipoConc());
            pstmt.setString(++i, conceptos.getTipoRemun());
            pstmt.setInt(++i, conceptos.getLibra());
            pstmt.setString(++i, conceptos.getTipoLibra());
            pstmt.setInt(++i, conceptos.getSicoss());
            pstmt.setString(++i, conceptos.getTipoSicoss());
            pstmt.setInt(++i, conceptos.getIigg());
            pstmt.setString(++i, conceptos.getTipoiigg());
            pstmt.setInt(++i, conceptos.getSicore());
            pstmt.setString(++i, conceptos.getTipoSicore());

            pstmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ConcParamForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private int resultadoEntero(boolean bool) {
        return bool ? 1 : 0;
    }

    private ConcepParam obtenerConceptos() {
        ConcepParam obj = new ConcepParam();
        obj.setLey((Integer.parseInt(leyjTextF.getText())));
        obj.setConc(Integer.parseInt(concjTextF.getText()));
        obj.setDescrip(descripjTextF.getText());
        obj.setTipoConc((String) tipoConcejCBox.getSelectedItem());
        obj.setTipoRemun((String) tipoRemunjCBox.getSelectedItem());
        obj.setLibra(resultadoEntero(librajCheckBox.isSelected()));
        obj.setTipoLibra((String) tipoLibramCoBox.getSelectedItem());
        obj.setSicoss(resultadoEntero(sicossjCheckBox.isSelected()));
        obj.setTipoSicoss((String) tipoSicossjComboBox.getSelectedItem());
        obj.setIigg(resultadoEntero(iiggCBox.isSelected()));
        obj.setTipoiigg((String) tipoIIGGjCBox.getSelectedItem());
        obj.setSicore(resultadoEntero(sicorejCheckBox.isSelected()));
        obj.setTipoSicore((String) tipoSicorejComboBox.getSelectedItem());

        return obj;

    }

    private void crearConcParam() {
        if (!existenCamposVacios()) {

            try {
                if (!existeLeyConcept()) {
                    ConcepParam concepto = obtenerConceptos();
                    insertarNuevoConcepto(concepto);
                    this.setVisible(false);
                    update.updateTableData();
                    Mensaje.exito("Creado con exito");
                    this.dispose();
                    return;
                }

                Mensaje.error("Ya existe un registro con la misma ley y N° concepto");
                return;
            } catch (SQLException ex) {
                Logger.getLogger(ConcParamForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        Mensaje.advertencia("complete todos los campos");
    }

    private boolean update(ConcepParam concP) {
        try {
            String sql = "UPDATE concParam SET descrip = ? , tipoconc = ? ,"
                    + " tiporemun = ? , libra = ? , tipolibra = ? , sicoss = ? , tiposicoss = ? ,"
                    + " iigg = ? , tipoigg = ? ,  sicore = ? , tiposicore = ?"
                    + " WHERE ley = ? and conc = ? ";

            PreparedStatement pstmt = db.getPreparedStatement(sql);
            int i = 0;
            pstmt.setString(++i, concP.getDescrip());
            pstmt.setString(++i, concP.getTipoConc());
            pstmt.setString(++i, concP.getTipoRemun());
            pstmt.setInt(++i, concP.getLibra());
            pstmt.setString(++i, concP.getTipoLibra());
            pstmt.setInt(++i, concP.getSicoss());
            pstmt.setString(++i, concP.getTipoSicoss());
            pstmt.setInt(++i, concP.getIigg());
            pstmt.setString(++i, concP.getTipoiigg());
            pstmt.setInt(++i, concP.getSicore());
            pstmt.setString(++i, concP.getTipoSicore());
            //condicional
            pstmt.setInt(++i, concP.getLey());
            pstmt.setInt(++i, concP.getConc());

            System.out.println("consulta ->" + pstmt.toString());
            int executeUpdate = pstmt.executeUpdate();
            return executeUpdate > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ConcParamForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    private void modificarConParam() {

        ConcepParam concepto = obtenerConceptos();

        boolean updateResult = update(concepto);

        this.setVisible(false);

        if (updateResult) {
            update.updateTableData();
            Mensaje.exito("Registro actualizado con exito");

            this.dispose();
            return;
        }

        Mensaje.error("Registro actualizado con exito");

    }

    private void jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActionPerformed
        // TODO add your handling code here:
        if (!isEdicion) {
            crearConcParam();
            return;
        }

        modificarConParam();


    }//GEN-LAST:event_jButtonActionPerformed

    private void sicorejCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sicorejCheckBoxActionPerformed
        // TODO add your handling code here:
        boolean state = sicorejCheckBox.isSelected();
        tipoSicorejComboBox.setEnabled(state);


    }//GEN-LAST:event_sicorejCheckBoxActionPerformed

    private void leyjTextFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_leyjTextFKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume(); // Evita que se ingrese el carácter
        }
    }//GEN-LAST:event_leyjTextFKeyTyped

    private void concjTextFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_concjTextFKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume(); // Evita que se ingrese el carácter
        }
    }//GEN-LAST:event_concjTextFKeyTyped
    
    private void creacionTipo(JComboBox<String> comboBox){
        new CreateTipoForm(comboBox).setVisible(true);
    }
    
    private void agregarTipoLibraLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agregarTipoLibraLabel1MousePressed
        // TODO add your handling code here:
        creacionTipo(tipoLibramCoBox);
        
    }//GEN-LAST:event_agregarTipoLibraLabel1MousePressed

    private void agregarTipoSicossLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agregarTipoSicossLabelMousePressed
        // TODO add your handling code here:
        creacionTipo(tipoSicossjComboBox);
    }//GEN-LAST:event_agregarTipoSicossLabelMousePressed

    private void agregarTipoSicoreLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agregarTipoSicoreLabelMousePressed
        // TODO add your handling code here:
        creacionTipo(tipoSicorejComboBox);
    }//GEN-LAST:event_agregarTipoSicoreLabelMousePressed

    private void agregarTipoIIGGLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agregarTipoIIGGLabelMousePressed
        // TODO add your handling code here:
        creacionTipo(tipoIIGGjCBox);
    }//GEN-LAST:event_agregarTipoIIGGLabelMousePressed

    private ArrayList<String> obtnerTipoConcepos() throws SQLException {
        String sql = "select tipoconc from concparam "
                + "group by tipoconc";
        ArrayList<String> listConc = new ArrayList<>();
        ResultSet result = DataBasePostGre.getInstance(true).consulta(sql);
        int columnaConc = 1;

        while (result.next()) {
            String item = result.getString(columnaConc);
            listConc.add(item);
        }

        return listConc;

    }

    private void cargarComboBox() {
        try {
            ArrayList<String> conceptos = obtnerTipoConcepos();
            for (String concepto : conceptos) {
                tipoConcejCBox.addItem(concepto);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConcParamForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JLabel agregarTipoIIGGLabel;
    javax.swing.JLabel agregarTipoLibraLabel1;
    javax.swing.JLabel agregarTipoSicoreLabel;
    javax.swing.JLabel agregarTipoSicossLabel;
    javax.swing.JTextField concjTextF;
    javax.swing.JTextField descripjTextF;
    javax.swing.JCheckBox iiggCBox;
    javax.swing.JButton jButton;
    javax.swing.JLabel jLabel1;
    javax.swing.JLabel jLabel10;
    javax.swing.JLabel jLabel2;
    javax.swing.JLabel jLabel3;
    javax.swing.JLabel jLabel4;
    javax.swing.JLabel jLabel5;
    javax.swing.JLabel jLabel6;
    javax.swing.JLabel jLabel7;
    javax.swing.JLabel jLabel9;
    javax.swing.JTextField leyjTextF;
    javax.swing.JCheckBox librajCheckBox;
    javax.swing.JCheckBox sicorejCheckBox;
    javax.swing.JCheckBox sicossjCheckBox;
    javax.swing.JComboBox<String> tipoConcejCBox;
    javax.swing.JComboBox<String> tipoIIGGjCBox;
    javax.swing.JComboBox<String> tipoLibramCoBox;
    javax.swing.JComboBox<String> tipoRemunjCBox;
    javax.swing.JComboBox<String> tipoSicorejComboBox;
    javax.swing.JComboBox<String> tipoSicossjComboBox;
    // End of variables declaration//GEN-END:variables

    private boolean existenCamposVacios() {
        return (leyjTextF.getText().isEmpty() || concjTextF.getText().isEmpty() || descripjTextF.getText().isEmpty());
    }

    private boolean existeLeyConcept() throws SQLException {
        String ley = leyjTextF.getText();
        String concepto = concjTextF.getText();

        String sql = "select * from concparam "
                + "where ley = " + ley + " and conc = " + concepto;

        ResultSet result = DataBasePostGre.getInstance(true).consulta(sql);

        if (result.next()) {
            return true;
        }

        return false;
    }

    private void recuperarInformacion() {
        try {
            String sql = "select * from concparam "
                    + "where ley = " + ley + " and conc = " + concepto;

            ResultSet result = DataBasePostGre.getInstance(true).consulta(sql);

            concP = new ConcepParam();
            while (result.next()) {
                concP.setLey(ley);
                concP.setConc(concepto);
                concP.setDescrip(result.getString("descrip"));
                concP.setTipoConc(result.getString("tipoconc"));
                concP.setTipoRemun(result.getString("tiporemun"));
                concP.setLibra(result.getInt("libra"));
                concP.setTipoLibra(result.getString("tipolibra"));
                concP.setSicoss(result.getInt("sicoss"));
                concP.setTipoSicoss(result.getString("tiposicoss"));
                concP.setIigg(result.getInt("iigg"));
                concP.setTipoiigg(result.getString("tipoigg"));
                concP.setSicore(result.getInt("sicore"));
                concP.setTipoSicore(result.getString("tiposicore"));
            }
            //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        } catch (SQLException ex) {
            Logger.getLogger(ConcParamForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
   
    private void  habilitarCboxSeleccionados(){
        tipoLibramCoBox.setEnabled(librajCheckBox.isSelected());
        tipoSicossjComboBox.setEnabled(sicossjCheckBox.isSelected());
        tipoSicorejComboBox.setEnabled(sicorejCheckBox.isSelected());
        tipoIIGGjCBox.setEnabled(iiggCBox.isSelected());
        
    }
    
   
    
    private void cargarDatosEnFom() {
        leyjTextF.setText(Integer.toString(concP.getLey()));
        concjTextF.setText(Integer.toString(concP.getConc()));
        descripjTextF.setText(concP.getDescrip());
        tipoConcejCBox.setSelectedItem(concP.getTipoConc());
        tipoRemunjCBox.setSelectedItem(concP.getTipoRemun());
        
        librajCheckBox.setSelected(concP.getLibra() == 1 ? true : false);
        tipoLibramCoBox.setSelectedItem(concP.getTipoLibra());
        
        sicossjCheckBox.setSelected(concP.getSicoss() == 1 ? true : false);
        tipoSicossjComboBox.setSelectedItem(concP.getTipoSicoss());
        
        sicorejCheckBox.setSelected(concP.getSicore() == 1 ? true : false);
        tipoSicorejComboBox.setSelectedItem(concP.getTipoSicore());
        
        iiggCBox.setSelected(concP.getIigg() == 1 ? true : false);
        tipoIIGGjCBox.setSelectedItem(concP.getTipoiigg());
        
        habilitarCboxSeleccionados();
    }

}