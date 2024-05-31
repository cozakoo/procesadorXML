package main;

import com.formdev.flatlaf.FlatIntelliJLaf;
import IU.XMLFileProcessorFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {

    public static void main(String[] args) throws UnsupportedLookAndFeelException, Exception {
        UIManager.setLookAndFeel(new FlatIntelliJLaf());

        DataBase db = DataBase.getInstance(true);
        db.inicializar("cliente");

        java.awt.EventQueue.invokeLater(() -> {
            new XMLFileProcessorFrame().setVisible(true);
        });
    }

}
