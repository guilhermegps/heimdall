/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heimdall.Portatil;

import heimdall.ExecutaSQL;
import heimdall.Forms.JErro;
import heimdall.Forms.JLogin;
import heimdall.Forms.JSelecionaItem;
import heimdall.Util.Usuario;
import heimdall.Util.Veiculo;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author guilherme
 */
public class PrincipalPortatil extends javax.swing.JFrame {
    private Usuario usuario;
    private Boolean logado = false;

    /**
     * Creates new form Principal
     */
    public PrincipalPortatil() {
        logando();
        initComponents();
        setVisible(logado);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        bRevisao = new javax.swing.JButton();
        dpPrincipal = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Leitora Portátil");

        jToolBar1.setFloatable(false);

        bRevisao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/heimdall/img/icons 50x50/sherlock.png"))); // NOI18N
        bRevisao.setFocusable(false);
        bRevisao.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bRevisao.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bRevisao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRevisaoActionPerformed(evt);
            }
        });
        jToolBar1.add(bRevisao);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addComponent(dpPrincipal)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dpPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bRevisaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRevisaoActionPerformed
        try{
            JSelecionaItem selecionaItem = new JSelecionaItem("Selecione um Veículo", "Código", "Veículo", true);

            ExecutaSQL sql = new ExecutaSQL();
            ArrayList<Veiculo> veiculo = sql.SELECT_ALL_VEICULO();
            for(int i=0; i<veiculo.size(); i++)
                selecionaItem.add(veiculo.get(i).getCodigo(), veiculo.get(i).toString(), veiculo.get(i));

            selecionaItem.setVisible(true);

            if(selecionaItem.getObjetoSelecionado()==null)
                return;

            new JRevisao((Veiculo)selecionaItem.getObjetoSelecionado(), usuario).setVisible(true);
        } catch (Exception ex) {
            new JErro(true, ex, true, true, false);
        }
    }//GEN-LAST:event_bRevisaoActionPerformed

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
            java.util.logging.Logger.getLogger(PrincipalPortatil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalPortatil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalPortatil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalPortatil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalPortatil().setVisible(true);
            }
        });
    }
    
    private void logando(){
        while(!logado){
            JLogin login = new JLogin();
            login.setVisible(true);

            usuario = login.getUsuario();
            logado = login.getLogado();
        }            
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bRevisao;
    private javax.swing.JDesktopPane dpPrincipal;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
