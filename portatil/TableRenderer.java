/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heimdall.portatil;

import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author guilherme
 */
public class TableRenderer extends DefaultTableCellRenderer {
    
    public TableRenderer(){
        this.setHorizontalAlignment(CENTER);
    }
 
    protected void setValue(Object value) {
        if (value instanceof ImageIcon) {
            if (value != null) {
                ImageIcon d = (ImageIcon) value;
                setIcon(d);
            } else {
                setText("");
                setIcon(null);
            }
        } else {
            super.setValue(value);
        }
    }
}