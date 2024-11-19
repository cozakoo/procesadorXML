/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IU.Buttons.Modificar;

import IU.Forms.ConcParamForm;

import main.DataBase;
import main.DataBasePostGre;
import util.Mensaje;

/**
 *
 * @author dgc06
 */
public class ModificarButton_conceptos extends ModificarButtonEditor {

    @Override
    public void modificar() {

        int ley = Integer.parseInt(getTable().getValueAt(getClickedRow(), 0).toString());
        int concepto = Integer.parseInt(getTable().getValueAt(getClickedRow(), 1).toString());

        ConcParamForm concePF = new ConcParamForm(true, DataBasePostGre.getInstance(true), this.getUpdate());
        concePF.CargarDatosModificacion(ley, concepto);
        concePF.setVisible(true);
        //Mensaje.exito(("Editado con exito ley "+ley+ " concepto "+concepto ));
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
