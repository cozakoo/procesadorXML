package main;

import IU.NewJFrame;
import com.formdev.flatlaf.FlatIntelliJLaf;
import IU.XMLFileProcessorFrame;
import com.sun.media.jfxmedia.events.NewFrameEvent;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {

    public static void main(String[] args) throws UnsupportedLookAndFeelException, Exception {
        UIManager.setLookAndFeel(new FlatIntelliJLaf());

        DataBasePostGre db = DataBasePostGre.getInstance(true);
        db.inicializar("cliente");

        java.awt.EventQueue.invokeLater(() -> {
            new XMLFileProcessorFrame().setVisible(true);
        });
    }

}
