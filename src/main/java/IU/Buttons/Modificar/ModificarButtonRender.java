package IU.Buttons.Modificar;

import static Interfaz.iCargaImagenes.url_imagen_borrar;
import static Interfaz.iCargaImagenes.url_imagen_editar;
import java.awt.Component;
import java.io.File;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ModificarButtonRender extends DefaultTableCellRenderer {

    private JButton button;

    public ModificarButtonRender() {
        button = new JButton();
        button.setName("Modificar");
        //button.setText("Modificar");
        String dirActual = System.getProperty("user.dir");
        button.setIcon(new javax.swing.ImageIcon(dirActual + url_imagen_editar));
        
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        return button;
    }
}
