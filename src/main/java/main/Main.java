package main;

import com.formdev.flatlaf.FlatIntelliJLaf;
import IU.XMLFileProcessorFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {

    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(new FlatIntelliJLaf());

        java.awt.EventQueue.invokeLater(() -> {
            new XMLFileProcessorFrame().setVisible(true);
        });
    }

}
