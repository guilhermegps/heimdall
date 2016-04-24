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
import static java.awt.image.ImageObserver.WIDTH;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author guilherme
 */
public class JNovaSenha extends javax.swing.JDialog {
    
    private Usuario usuario;

    /**
     * Creates new form JNovaSenha
     */
    public JNovaSenha(Usuario user) {
        setModal(true); //Faz com que o sistema aguarde a conclusão do JDialog para seguir com a execução. 
        usuario = user;
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pfRepeteSenha = new javax.swing.JPasswordField();
        pfNovaSenha = new javax.swing.JPasswordField();
        pfSenhaAtual = new javax.swing.JPasswordField();
        bConfirma = new javax.swing.JButton();
        bCancela = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Redefinir a Senha de Usuário");
        setResizable(false);

        jLabel1.setText("Senha atual:");

        jLabel2.setText("Nova Senha:");

        jLabel3.setText("Repetir Senha:");

        bConfirma.setText("Confirmar");
        bConfirma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bConfirmaActionPerformed(evt);
            }
        });

        bCancela.setText("Cancelar");
        bCancela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pfNovaSenha)
                            .addComponent(pfRepeteSenha)
                            .addComponent(pfSenhaAtual, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(bConfirma)
                        .addGap(18, 18, 18)
                        .addComponent(bCancela)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(pfSenhaAtual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pfNovaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(pfRepeteSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bConfirma)
                    .addComponent(bCancela))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bCancelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelaActionPerformed
        int resp = JOptionPane.showConfirmDialog(null,"Você tem certeza que deseja cancelar as alterações feitas?","Tem certeza?",JOptionPane.YES_NO_OPTION);
        if(resp==0){
            dispose();
        }
    }//GEN-LAST:event_bCancelaActionPerformed

    private void bConfirmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bConfirmaActionPerformed
        alterarSenha();
    }//GEN-LAST:event_bConfirmaActionPerformed

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
            java.util.logging.Logger.getLogger(JNovaSenha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JNovaSenha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JNovaSenha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JNovaSenha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JNovaSenha dialog = new JNovaSenha(new Usuario());
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
    
    private void alterarSenha(){
        ExecutaSQL sql = new ExecutaSQL();
        SenhaAutomatica encript = new SenhaAutomatica(WIDTH);
        TratarEntrada trata = new TratarEntrada();
        String senhaAtual = new String(pfSenhaAtual.getPassword());
        String novaSenha = new String(pfNovaSenha.getPassword());
        String repeteSenha = new String(pfRepeteSenha.getPassword());

        if(!trata.whiteList(senhaAtual) || !trata.whiteList(novaSenha) || !trata.whiteList(repeteSenha)){
            JOptionPane.showMessageDialog(null, "A senha contem caracteres inválidos ou está vazia. Por favor, digite novamente.");
            return;
        }

        ArrayList<Usuario> user = sql.SELECT_USUARIO_ATIVO("id_usuario", Integer.toString(usuario.getId()));
        if(user.size()==1){
            usuario = user.get(0);
            senhaAtual = encript.encripta(usuario.getLogin()+senhaAtual);

            if(senhaAtual.compareTo(usuario.getSenha())!=0){
                JOptionPane.showMessageDialog(null, "A senha atual está incorreta.");
                return;
            }

            if(novaSenha.compareTo(repeteSenha)==0){    
                Usuario aux = usuario;
                aux.setSenha(encript.encripta(usuario.getLogin()+novaSenha));

                int resp = JOptionPane.showConfirmDialog(null,"Você tem certeza que deseja alterar a senha?","Tem certeza?",JOptionPane.YES_NO_OPTION);
                if(resp==0){
                    if(sql.UPDATE_USUARIO(aux)){
                        JOptionPane.showMessageDialog(null,"Senha alterada com sucesso");
                        usuario = aux;
                        dispose();
                    }else{
                        JOptionPane.showMessageDialog(null,"Falha na alteração da senha.");
                    }
                }
            } else{
                JOptionPane.showMessageDialog(null, "A nova senha e a confirmação da senha não são iguais. Favor, tentar novamente.");
            }
        } else{
            new JErro(true, "Houve um problema ao tentar encontrar este usuário.\n"
                    + "Favor, verificar o banco de dados.", true, false, true);
            return;            
        }   
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCancela;
    private javax.swing.JButton bConfirma;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField pfNovaSenha;
    private javax.swing.JPasswordField pfRepeteSenha;
    private javax.swing.JPasswordField pfSenhaAtual;
    // End of variables declaration//GEN-END:variables
}
