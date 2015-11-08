/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package heimdall;

import heimdall.Forms.JNovoUsuario;
import heimdall.Forms.JLogin;
import heimdall.Forms.JVeiculo;
import heimdall.Util.Usuario;

/**
 *
 * @author guilherme
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    
    private Boolean logado = false;
    private JLogin login;
    private JVeiculo novoVeiculo = new JVeiculo();
    private Usuario usuario;
    private JNovoUsuario newUser = new JNovoUsuario();
    
    public Principal() { //Guilherme
        initComponents();
        logando();
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
        menuArq = new javax.swing.JMenu();
        miNewVeicle = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        miLogout = new javax.swing.JMenuItem();
        miExit = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        menuUsuarios = new javax.swing.JMenu();
        miNewUser = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
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
        jLayeredPane1.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jToolBar1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        menuArq.setIcon(new javax.swing.ImageIcon(getClass().getResource("/heimdall/img/icons 16x16/page.png"))); // NOI18N
        menuArq.setText("Arquivos");

        miNewVeicle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/heimdall/img/icons 16x16/car_add.png"))); // NOI18N
        miNewVeicle.setText("Veículo");
        miNewVeicle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miNewVeicleActionPerformed(evt);
            }
        });
        menuArq.add(miNewVeicle);
        menuArq.add(jSeparator3);

        miLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/heimdall/img/icons 16x16/status_offline.png"))); // NOI18N
        miLogout.setText("Logout");
        miLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miLogoutActionPerformed(evt);
            }
        });
        menuArq.add(miLogout);

        miExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/heimdall/img/icons 16x16/cross.png"))); // NOI18N
        miExit.setText("Sair");
        miExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miExitActionPerformed(evt);
            }
        });
        menuArq.add(miExit);
        menuArq.add(jSeparator1);
        menuArq.add(jSeparator2);

        jMenuBar1.add(menuArq);

        menuUsuarios.setText("Usuários");

        miNewUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/heimdall/img/icons 16x16/user_add.png"))); // NOI18N
        miNewUser.setText("Novo usuário");
        miNewUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miNewUserActionPerformed(evt);
            }
        });
        menuUsuarios.add(miNewUser);

        jMenuItem2.setText("jMenuItem2");
        menuUsuarios.add(jMenuItem2);

        jMenuItem3.setText("jMenuItem3");
        menuUsuarios.add(jMenuItem3);

        jMenuBar1.add(menuUsuarios);

        jMenu3.setText("Exibir");
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

    private void miNewVeicleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miNewVeicleActionPerformed
        novoVeiculo.setVisible(true);
    }//GEN-LAST:event_miNewVeicleActionPerformed

    private void miLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miLogoutActionPerformed
        logado = false;
        fecharJanelas();
        dispose();
        new Relogar();
    }//GEN-LAST:event_miLogoutActionPerformed

    private void miExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_miExitActionPerformed

    private void miNewUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miNewUserActionPerformed
        newUser = new JNovoUsuario(usuario);
        newUser.setVisible(true);
    }//GEN-LAST:event_miNewUserActionPerformed

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
        login = new JLogin(new javax.swing.JFrame(), true);
        login.setVisible(true);
        while(!logado){
            logado = login.getLogado();
        }
        usuario = login.getUsuario();
        setVisible(logado);
    }
    
    private void fecharJanelas(){
        novoVeiculo.fecharJanelas();
        newUser.fecharJanelas();
        dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenu menuArq;
    private javax.swing.JMenu menuUsuarios;
    private javax.swing.JMenuItem miExit;
    private javax.swing.JMenuItem miLogout;
    private javax.swing.JMenuItem miNewUser;
    private javax.swing.JMenuItem miNewVeicle;
    private javax.swing.JTable tPrincipal;
    // End of variables declaration//GEN-END:variables
}