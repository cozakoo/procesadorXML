package IU.Buttons.Eliminar;

import Interfaz.UpdateListener;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import main.DataBase;
import util.Mensaje;

public class EliminarButtonEditorConcepto extends DefaultCellEditor {

    private JButton button;
    private String label;
    private boolean isPushed;
    private int clickedRow;
    private int clickedColumn;
    private JTable table;
    private UpdateListener update;
    private DataBase db;

    public EliminarButtonEditorConcepto(DataBase db) {
        super(new JCheckBox());
        button = new JButton();
        this.db = db;

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
                eliminar();

            }
        });
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
    }

    private void eliminar() {
        String ley = table.getValueAt(clickedRow, 0).toString();
        String concepto = table.getValueAt(clickedRow, 1).toString();
        if (Mensaje.confirmar("¿Seguro de que quiere eliminar al concepto con ley " + ley + " y N° concepto " + concepto, "Confirmar Baja")) {
            try {
                 eliminarEnbase(ley, concepto);
                 update.updateTableData();
                 Mensaje.exito("Registro eliminado con exito");
            } catch (SQLException ex) {
                Mensaje.error("No se pudo eliminar el registro");
                Logger.getLogger(EliminarButtonEditorConcepto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       
        //update.updateTableData();

    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        this.table = table;
        label = (String) value;
        button.setText(label);
        isPushed = true;
        clickedRow = row;
        clickedColumn = column;
        return button;
    }

    @Override
    public Object getCellEditorValue() {
        isPushed = false;
        return label;
    }

    @Override
    public boolean stopCellEditing() {
        isPushed = false;
        return super.stopCellEditing();
    }

    @Override
    protected void fireEditingStopped() {
        super.fireEditingStopped();
    }

    public void addlistener(UpdateListener listener) {
        this.update = listener;
    }

//    private void eliminarEnbase(String userName) {
//        DataBase.getInstance(true).consulta("DELETE FROM usuario WHERE username = '" + userName + "'");
//    }
    private void eliminarEnbase(String ley, String concepto) throws SQLException {
        int leyInt = Integer.parseInt(ley);
        int concInt = Integer.parseInt(concepto);
        String queryDelete = "DELETE FROM concparam WHERE ley = ? and conc = ?";
        PreparedStatement psDelete = db.getPreparedStatement(queryDelete);
        psDelete.setInt(1, leyInt);
        psDelete.setInt(2, concInt);
        int rs = psDelete.executeUpdate();

        if (rs > 0) {
            return;
        } 
        
        throw new SQLException();
        

    }
}
