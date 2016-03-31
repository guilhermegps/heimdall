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
import javax.swing.JOptionPane;

/**
 *
 * @author guilherme
 */
public class JNovoUsuario extends javax.swing.JDialog {

    
    /**
     * Creates new form JNovoUsuario
     */
    
    private Usuario usuario;
    private TratarEntrada trata;

    public JNovoUsuario() {
        setModal(true); //Faz com que o sistema aguarde a conclusão do JDialog para seguir com a execução. 
        initComponents();
    }
    
    public JNovoUsuario(Usuario usuario) {
        setModal(true); //Faz com que o sistema aguarde a conclusão do JDialog para seguir com a execução. 
        this.usuario = usuario;
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        tfLogin = new javax.swing.JTextField();
        bCdtUsuario = new javax.swing.JButton();
        bCancelUsuario = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        tfCpf = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Novo Usuário");
        setPreferredSize(new java.awt.Dimension(395, 225));

        jLabel1.setText("Login de Usuário*: ");

        jLabel3.setText("Nome Completo*: ");

        tfNome.setToolTipText("Digite o nome completo do usuário");
        tfNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNomeActionPerformed(evt);
            }
        });
        tfNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfNomeKeyPressed(evt);
            }
        });

        tfLogin.setToolTipText("Digite o nome de login que será utilizado por esse usuário");
        tfLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfLoginKeyPressed(evt);
            }
        });

        bCdtUsuario.setText("Cadastrar Usuário");
        bCdtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCdtUsuarioActionPerformed(evt);
            }
        });

        bCancelUsuario.setText("Cancelar");
        bCancelUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelUsuarioActionPerformed(evt);
            }
        });

        jLabel2.setText("CPF*: ");

        tfCpf.setToolTipText("Digite o CPF do novo usuário");

        jLabel4.setText("<html>  <p><b><font color=\"red\" align=\"justify\">Não é permitido o uso de caracteres especiais ou  acentos no login de usuário, com excessão do  ponto (.) e underline (_).</font></b></p>");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bCdtUsuario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bCancelUsuario)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bCdtUsuario)
                    .addComponent(bCancelUsuario))
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(341, 244));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bCdtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCdtUsuarioActionPerformed
        cadastrar();
    }//GEN-LAST:event_bCdtUsuarioActionPerformed

    private void bCancelUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelUsuarioActionPerformed
        int resp = JOptionPane.showConfirmDialog(null,"Você tem certeza que deseja cancelar as alterações feitas?","Tem certeza?",JOptionPane.YES_NO_OPTION);
        if(resp==0){
            dispose();
        }
    }//GEN-LAST:event_bCancelUsuarioActionPerformed

    private void tfNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNomeKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            cadastrar();
        }
    }//GEN-LAST:event_tfNomeKeyPressed

    private void tfLoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfLoginKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            cadastrar();
        }
    }//GEN-LAST:event_tfLoginKeyPressed

    private void tfNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNomeActionPerformed
    
    public void cadastrar(){
        String array[] = tfNome.getText().trim().split(" ");
        String nome = "";
        
        for(int i=0; i<array.length; i++){
            if(array[i].compareTo("")!=0 && array[i]!=null){
                array[i] = array[i].replace('_', ' ');
                if(!trata.whiteList(array[i])){
                    JOptionPane.showMessageDialog(null,"Nome completo inválido.");
                    return;
                }
                nome += (nome.compareTo("")==0) ? array[i] : ' '+array[i];
            }
        }
        
        if(!trata.whiteList(tfLogin.getText())){
            JOptionPane.showMessageDialog(null,"O login contem caracteres inválidos ou está vazio. Por favor, digite novamente.");
            return;
        } else if(!trata.isValidCPF(tfCpf.getText())){
            JOptionPane.showMessageDialog(null,"CPF inválido ou está vazio. Por favor, digite novamente.");
            return;
        } else{
            int resp = JOptionPane.showConfirmDialog(null,"Você tem certeza que deseja cadastrar esse usuário?\nNome: "+nome+"\nLogin: "+tfLogin.getText()+"\nCPF: "+tfCpf.getText(),"Tem certeza?",JOptionPane.YES_NO_OPTION);
            if(resp==0){
                ExecutaSQL sql = new ExecutaSQL();
                SenhaAutomatica senha = new SenhaAutomatica(6);
                
                Usuario user = new Usuario(0, 
                        nome, 
                        senha.senhaSemiAutomatica(tfLogin.getText()), 
                        2, 
                        tfLogin.getText(), 
                        tfCpf.getText(), 
                        true, 
                        true);

                if(sql.SELECT_USUARIO_ATIVO("vc_login_usuario", '\''+user.getLogin()+'\'').size()>0){
                    JOptionPane.showMessageDialog(null,"Já existe alguém cadastrado com esse login. Tente outro.");
                    return;
                }

                sql = new ExecutaSQL();

                if(sql.INSERT_USUARIO(user)){
                    JOptionPane.showMessageDialog(null,"Cadastrado com sucesso\nLogin: "+user.getLogin()+"\nSenha: "+senha.getSenhaSimples());
                    dispose();
                }else{
                    JOptionPane.showMessageDialog(null,"Falha no cadastrado.");
                }
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCancelUsuario;
    private javax.swing.JButton bCdtUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField tfCpf;
    private javax.swing.JTextField tfLogin;
    private javax.swing.JTextField tfNome;
    // End of variables declaration//GEN-END:variables
}
