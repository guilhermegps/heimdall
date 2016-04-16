/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heimdall.Forms;

import heimdall.ExecutaSQL;
import heimdall.Util.Usuario;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author guilherme
 */
public class JConfigurarUsuario extends javax.swing.JDialog {

    /**
     * Creates new form JDesabilitarUsuario
     */
    public JConfigurarUsuario() {
        setModal(true);
        initComponents();
        initTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tUsuario = new javax.swing.JTable();
        bDesativar = new javax.swing.JButton();
        bRemove = new javax.swing.JButton();
        bAtivar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Configurar Usuário");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 115, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 195, Short.MAX_VALUE)
        );

        tUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Usuário", "CPF", "Ativo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tUsuario);
        if (tUsuario.getColumnModel().getColumnCount() > 0) {
            tUsuario.getColumnModel().getColumn(0).setPreferredWidth(120);
            tUsuario.getColumnModel().getColumn(1).setPreferredWidth(150);
            tUsuario.getColumnModel().getColumn(2).setResizable(false);
            tUsuario.getColumnModel().getColumn(2).setPreferredWidth(100);
        }

        bDesativar.setText("Desativar");
        bDesativar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDesativarActionPerformed(evt);
            }
        });

        bRemove.setText("Remover");
        bRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRemoveActionPerformed(evt);
            }
        });

        bAtivar.setText("Ativar");
        bAtivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAtivarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bDesativar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bAtivar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bRemove, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bAtivar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bDesativar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bRemove)
                        .addGap(22, 22, 22)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bAtivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAtivarActionPerformed
        enabledUsuario(true);
    }//GEN-LAST:event_bAtivarActionPerformed

    private void bDesativarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDesativarActionPerformed
        enabledUsuario(false);
    }//GEN-LAST:event_bDesativarActionPerformed

    private void bRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRemoveActionPerformed
            removeUsuario();
    }//GEN-LAST:event_bRemoveActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JConfigurarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JConfigurarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JConfigurarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JConfigurarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JConfigurarUsuario dialog = new JConfigurarUsuario();
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    
    public void enabledUsuario(boolean status){
        String cpf = selectedUsuario();
        
        if(cpf.equals("")){
            JOptionPane.showMessageDialog(null, "É necessário selecionar um usuário.");
            return;
        }
        
        ExecutaSQL sql = new ExecutaSQL();
        ArrayList<Usuario> usuario = sql.SELECT_USUARIO("vc_cpf_usuario", '\''+cpf+'\'');
        
        if(usuario.size()!=1){
            new JErro(true, "Há um conflito de registros relacionado a este usuário.", true, false, false);
            return;
        }
        
        if(usuario.get(0).isAtivo() && status){
            JOptionPane.showMessageDialog(null, "Este usuário já se encontra ativado.");
            return;
        } else if(!usuario.get(0).isAtivo() && !status){
            JOptionPane.showMessageDialog(null, "Este usuário já se encontra desativado.");
            return;
        }
        
        usuario.get(0).setAtivo(status);
        if(sql.UPDATE_USUARIO(usuario.get(0))){
            JOptionPane.showMessageDialog(null, "Status do usuário alterado com sucesso.");
        } else{
            JOptionPane.showMessageDialog(null, "O status do usuário não pode ser alterado.");
        }
        
        initTable();
    }
    
    public String selectedUsuario(){        
        if(tUsuario.getSelectedRow()<0)
            return "";
        
        return (String)tUsuario.getValueAt(tUsuario.getSelectedRow(), 1);
    }
    
    public void removeUsuario(){
        String cpf = selectedUsuario();
        
        if(cpf.equals("")){
            JOptionPane.showMessageDialog(null, "É necessário selecionar um usuário.");
            return;
        }
        
        ExecutaSQL sql = new ExecutaSQL();
        ArrayList<Usuario> usuario = sql.SELECT_USUARIO("vc_cpf_usuario", '\''+cpf+'\'');
        
        if(usuario.size()!=1){
            new JErro(true, "Há um conflito de registros relacionado a este usuário.", true, false, false);
            return;
        }
        
        int resp = JOptionPane.showConfirmDialog(null,"Você tem certeza que deseja remover este usuário?","Tem certeza?",JOptionPane.YES_NO_OPTION);
        if(resp==0){
            if(sql.DELETE_USUARIO(usuario.get(0).getId())){
                JOptionPane.showMessageDialog(null, "Usuário removido com sucesso.");
            } else{
                JOptionPane.showMessageDialog(null, "Este usuário não pode ser removido.");
            }
        
            initTable();
        }
    }
    
    private void initTable(){
        ExecutaSQL sql = new ExecutaSQL();
        ArrayList<Usuario> usuarios = sql.SELECT_ALL_USUARIO();
        DefaultTableModel dtm = (DefaultTableModel) tUsuario.getModel();
        
        while(dtm.getRowCount()>0){
            dtm.removeRow(0);
        }
        
        for(int i=0; i<usuarios.size(); i++){            
            dtm.addRow(new Object[] {
                usuarios.get(i).getLogin(),
                usuarios.get(i).getCpf(),
                usuarios.get(i).isAtivo()}
            );
        }     
        tUsuario.setModel(dtm);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAtivar;
    private javax.swing.JButton bDesativar;
    private javax.swing.JButton bRemove;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tUsuario;
    // End of variables declaration//GEN-END:variables
}
