package main;

import IU.Forms.GenerarFondosForm;
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

//        DataBasePostGre db = DataBasePostGre.getInstance(true);
//        db.inicializar("cliente");
//        new GenerarFondosForm().setVisible(true);
//        new MenuPrincipal(db).setVisible(true);
         
          DataBase db400 = DataBaseAS400.getInstance(true);
          db400.inicializar("cliente");
          new ViewTableGeneric("TABLA CONCPARAM", "DBGAN24X.CONCPARAM", db400).setVisible(true);

        //new MenuPrincipalForm().setVisible(true);

    }

}
