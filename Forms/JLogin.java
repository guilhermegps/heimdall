/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package heimdall.Forms;

import heimdall.ExecutaSQL;
import heimdall.SenhaAutomatica;
import heimdall.TratarEntrada;
import heimdall.Util.Usuario;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author guilherme
 */
public class JLogin extends javax.swing.JDialog {

    /**
     * Creates new form JLogin
     */
    
    private boolean logado=false;
    private Usuario usuario;
    private TratarEntrada trata;
    
    public JLogin() {
        setModal(true);
        this.trata = new TratarEntrada();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pLogin = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfUser = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        lImgLogin = new javax.swing.JLabel();
        bLogin = new javax.swing.JButton();
        pfSenha = new javax.swing.JPasswordField();
        bCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Login");
        setResizable(false);

        pLogin.setBackground(new java.awt.Color(255, 255, 255));
        pLogin.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pLogin.setPreferredSize(new java.awt.Dimension(400, 200));

        jLabel1.setText("Usuário: ");

        tfUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfUserActionPerformed(evt);
            }
        });
        tfUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfUserKeyPressed(evt);
            }
        });

        jLabel2.setText("Senha: ");

        lImgLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/heimdall/img/heimdall_login.png"))); // NOI18N

        bLogin.setText("Entrar");
        bLogin.setToolTipText("Clique nessa merda");
        bLogin.setPreferredSize(new java.awt.Dimension(120, 30));
        bLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLoginActionPerformed(evt);
            }
        });
        bLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bLoginKeyPressed(evt);
            }
        });

        pfSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pfSenhaKeyPressed(evt);
            }
        });

        bCancel.setText("Cancelar");
        bCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pLoginLayout = new javax.swing.GroupLayout(pLogin);
        pLogin.setLayout(pLoginLayout);
        pLoginLayout.setHorizontalGroup(
            pLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pLoginLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(tfUser)
                    .addComponent(jLabel2)
                    .addComponent(pfSenha)
                    .addGroup(pLoginLayout.createSequentialGroup()
                        .addComponent(bLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lImgLogin)
                .addContainerGap())
        );
        pLoginLayout.setVerticalGroup(
            pLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pLoginLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(bCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lImgLogin))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tfUserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfUserKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            logando();
        }
    }//GEN-LAST:event_tfUserKeyPressed

    private void bLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLoginActionPerformed
        logando();
    }//GEN-LAST:event_bLoginActionPerformed

    private void bLoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bLoginKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            logando();
        }
    }//GEN-LAST:event_bLoginKeyPressed

    private void pfSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pfSenhaKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            logando();
        }
    }//GEN-LAST:event_pfSenhaKeyPressed

    private void bCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelActionPerformed
        System.exit(0);
    }//GEN-LAST:event_bCancelActionPerformed

    private void tfUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfUserActionPerformed

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
            java.util.logging.Logger.getLogger(JLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JLogin dialog = new JLogin();
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
    
    private void logando(){
        ExecutaSQL sql = new ExecutaSQL();
        ArrayList<Usuario> user = new ArrayList<Usuario>();
        String login = tfUser.getText();
        String senha = new String(pfSenha.getPassword());
        int comp1, comp2;
        comp1 = comp2 = 0;
        
        if(!trata.whiteList(login)){
            JOptionPane.showMessageDialog(null,"O usuário contem caracteres inválidos ou está vazio.");
        } else if(!trata.whiteList(senha)){
            JOptionPane.showMessageDialog(null,"A senha contem caracteres inválidos ou está vazia. Por favor, digite novamente.");
        } else{
            user = sql.SELECT_USUARIO_ATIVO("vc_login_usuario", "\'"+login+"\'");
            if(user.size()==1){
                SenhaAutomatica aux = new SenhaAutomatica(WIDTH);
                senha = login + senha;
                senha = aux.encripta(senha);

                comp1 = user.get(0).getLogin().compareTo(login);
                comp2 = user.get(0).getSenha().compareTo(senha);
                
                if(comp1==0 && comp2==0){
                    logado = true;
                    usuario = user.get(0);
                    dispose();
                } else{
                    JOptionPane.showMessageDialog(null,"Login incorreto");
                    return;
                }
            } else if(user.size()==0){
                JOptionPane.showMessageDialog(null,"Login incorreto");
                return;
            } else{
                new JErro(true, new Exception("Houve um problema ao tentar encontrar este usuário.\n"
                        + "Favor, verificar o banco de dados."), true, false, false);
                return;
            }
        }
        
        
    }

    public boolean getLogado() {
        return logado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCancel;
    private javax.swing.JButton bLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lImgLogin;
    private javax.swing.JPanel pLogin;
    private javax.swing.JPasswordField pfSenha;
    private javax.swing.JTextField tfUser;
    // End of variables declaration//GEN-END:variables
}
