/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heimdall;

import heimdall.Util.Veiculo;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author guilherme
 */
public class ConfiguraTabelaPadrao implements Serializable {

    private String cols[];
    private boolean canEdit[];
    private Class types[];
    private DefaultTableModel dtm;

    public ConfiguraTabelaPadrao(String[] colunas, final boolean[] campoEdit, final Class[] tipos) {
        this.cols = colunas;
        this.canEdit = campoEdit;
        this.types = tipos;
                
        this.dtm = new DefaultTableModel(colunas,0) {
            Class[] types = tipos;
                    
            boolean[] canEdit = campoEdit;

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        };       
    }
    
    public void addLinha(Object val[]){
        this.dtm.addRow(val);
    }

    public String[] getCols() {
        return cols;
    }

    public void setCols(String[] cols) {
        this.cols = cols;
    }

    public boolean[] getCanEdit() {
        return canEdit;
    }

    public void setCanEdit(boolean[] canEdit) {
        this.canEdit = canEdit;
    }

    public Class[] getTypes() {
        return types;
    }

    public void setTypes(Class[] types) {
        this.types = types;
    }

    public DefaultTableModel getDtm() {
        return dtm;
    }
}
