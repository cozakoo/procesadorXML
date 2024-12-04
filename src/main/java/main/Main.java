package main;

import IU.Forms.ImportacionFondosForm;
import IU.Forms.MenuPrincipal;
import IU.Forms.ViewConcParam;
import IU.Forms.ViewTableGeneric;
//import IU.NewJFrame;
import com.formdev.flatlaf.FlatIntelliJLaf;
import IU.Forms.XMLFileProcessorFrame;
import com.sun.media.jfxmedia.events.NewFrameEvent;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {

    public static void main(String[] args) throws UnsupportedLookAndFeelException, Exception {
        UIManager.setLookAndFeel(new FlatIntelliJLaf());

        DataBasePostGre db = DataBasePostGre.getInstance(true);
        db.inicializar("cliente");
        new ImportacionFondosForm().setVisible(true);
        //new ViewTableGeneric("TABLA REMUNERA","remunera", db).setVisible(true);
//
//        java.awt.EventQueue.invokeLater(() -> {
//            new XMLFileProcessorFrame().setVisible(true);
//        });
        // new ViewConcParam(db).setVisible(true);
        //new AltaConcParam().setVisible(true);
        new MenuPrincipal(db).setVisible(true);
        //new MenuPrincipalForm().setVisible(true);

    }

}
