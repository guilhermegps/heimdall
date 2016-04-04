/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package heimdall;

import heimdall.Forms.*;
import heimdall.Util.Usuario;
import heimdall.Util.Veiculo;
import java.util.ArrayList;

/**
 *
 * @author Guilherme de Paiva
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    
    private Boolean logado = false;
    private JLogin login;
    private Usuario usuario;
    
    public Principal() { 
        try{
            initComponents();
            logando();
            //new JRevisao().setVisible(true);//Teste da janela
        }catch(Exception ex){
            new JErro(true, ex, false, true, false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        tPrincipal = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        jMenuBar1 = new javax.swing.JMenuBar();
        miLofout = new javax.swing.JMenu();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        miLogout = new javax.swing.JMenuItem();
        miSair = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenu1 = new javax.swing.JMenu();
        miVeiculo = new javax.swing.JMenuItem();
        miComponente = new javax.swing.JMenuItem();
        menuUsuarios = new javax.swing.JMenu();
        miNovoUsuario = new javax.swing.JMenuItem();
        miAlterarSenha = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Heimdall");
        setExtendedState(MAXIMIZED_BOTH);
        setPreferredSize(new java.awt.Dimension(850, 545));

        tPrincipal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "N°", "Veículo", "Placa", "Ult. Revisão", "Status Comp."
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tPrincipal.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(tPrincipal);
        if (tPrincipal.getColumnModel().getColumnCount() > 0) {
            tPrincipal.getColumnModel().getColumn(0).setResizable(false);
            tPrincipal.getColumnModel().getColumn(0).setPreferredWidth(5);
        }

        jToolBar1.setBackground(new java.awt.Color(254, 254, 254));
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jLayeredPane1.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jToolBar1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        miLofout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/heimdall/img/icons 16x16/cog.png"))); // NOI18N
        miLofout.setText("Sistema");
        miLofout.add(jSeparator3);

        miLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/heimdall/img/icons 16x16/status_offline.png"))); // NOI18N
        miLogout.setText("Logout");
        miLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miLogoutActionPerformed(evt);
            }
        });
        miLofout.add(miLogout);

        miSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/heimdall/img/icons 16x16/door_in.png"))); // NOI18N
        miSair.setText("Sair");
        miSair.setToolTipText("");
        miSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSairActionPerformed(evt);
            }
        });
        miLofout.add(miSair);
        miLofout.add(jSeparator1);
        miLofout.add(jSeparator2);

        jMenuBar1.add(miLofout);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/heimdall/img/icons 16x16/lorry.png"))); // NOI18N
        jMenu1.setText("Frota");

        miVeiculo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/heimdall/img/icons 16x16/car_add.png"))); // NOI18N
        miVeiculo.setText("Veículo");
        miVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miVeiculoActionPerformed(evt);
            }
        });
        jMenu1.add(miVeiculo);

        miComponente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/heimdall/img/icons 16x16/brick_add.png"))); // NOI18N
        miComponente.setText("Componente");
        miComponente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miComponenteActionPerformed(evt);
            }
        });
        jMenu1.add(miComponente);

        jMenuBar1.add(jMenu1);

        menuUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/heimdall/img/icons 16x16/group.png"))); // NOI18N
        menuUsuarios.setText("Usuários");

        miNovoUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/heimdall/img/icons 16x16/user_add.png"))); // NOI18N
        miNovoUsuario.setText("Novo usuário");
        miNovoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miNovoUsuarioActionPerformed(evt);
            }
        });
        menuUsuarios.add(miNovoUsuario);

        miAlterarSenha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/heimdall/img/icons 16x16/key_go.png"))); // NOI18N
        miAlterarSenha.setText("Alterar Senha");
        miAlterarSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAlterarSenhaActionPerformed(evt);
            }
        });
        menuUsuarios.add(miAlterarSenha);

        jMenuItem3.setText("jMenuItem3");
        menuUsuarios.add(jMenuItem3);

        jMenuBar1.add(menuUsuarios);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/heimdall/img/icons 16x16/page.png"))); // NOI18N
        jMenu3.setText("Relatórios");
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
        );

        setSize(new java.awt.Dimension(860, 591));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void miVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miVeiculoActionPerformed
        new JVeiculo().setVisible(true);
    }//GEN-LAST:event_miVeiculoActionPerformed

    private void miLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miLogoutActionPerformed
        logado = false;
        usuario = null;
        dispose();
        new Principal();
    }//GEN-LAST:event_miLogoutActionPerformed

    private void miSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_miSairActionPerformed

    private void miNovoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miNovoUsuarioActionPerformed
        new JNovoUsuario(usuario).setVisible(true);
    }//GEN-LAST:event_miNovoUsuarioActionPerformed

    private void miAlterarSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAlterarSenhaActionPerformed
        JNovaSenha novaSenha = new JNovaSenha(usuario);
        novaSenha.setVisible(true);
        usuario = novaSenha.getUsuario();
    }//GEN-LAST:event_miAlterarSenhaActionPerformed

    private void miComponenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miComponenteActionPerformed
        JSelecionaItem selecionaItem = new JSelecionaItem("Selecione um Veículo", "Código", "Veículo", true);
        
        ExecutaSQL sql = new ExecutaSQL();
        ArrayList<Veiculo> veiculo = sql.SELECT_ALL_VEICULO();
        for(int i=0; i<veiculo.size(); i++)
            selecionaItem.add(veiculo.get(i).getCodigo(), veiculo.get(i).toString(), veiculo.get(i));
        
        selecionaItem.setVisible(true);
        
        if(selecionaItem.getObjetoSelecionado()!=null)
            new JComponente((Veiculo)selecionaItem.getObjetoSelecionado()).setVisible(true);
    }//GEN-LAST:event_miComponenteActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal();
            }
        });
    }
    
    private void logando(){
        login = new JLogin();
        login.setVisible(true);
        
        usuario = login.getUsuario();
        logado = login.getLogado();
        setVisible(logado);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenu menuUsuarios;
    private javax.swing.JMenuItem miAlterarSenha;
    private javax.swing.JMenuItem miComponente;
    private javax.swing.JMenu miLofout;
    private javax.swing.JMenuItem miLogout;
    private javax.swing.JMenuItem miNovoUsuario;
    private javax.swing.JMenuItem miSair;
    private javax.swing.JMenuItem miVeiculo;
    private javax.swing.JTable tPrincipal;
    // End of variables declaration//GEN-END:variables
}
