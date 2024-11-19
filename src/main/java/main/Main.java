package main;


import IU.Forms.MenuPrincipal;
import IU.Forms.MenuPrincipalForm;
import IU.Forms.ViewConcParam;
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
//
//        java.awt.EventQueue.invokeLater(() -> {
//            new XMLFileProcessorFrame().setVisible(true);
//        });
       // new ViewConcParam(db).setVisible(true);
        //new AltaConcParam().setVisible(true);
        new MenuPrincipal().setVisible(true);
        //new MenuPrincipalForm().setVisible(true);
        
    }

}
