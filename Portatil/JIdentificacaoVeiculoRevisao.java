/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heimdall.Portatil;

import heimdall.ExecutaSQL;
import heimdall.Util.ComponenteRevisado;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import static java.lang.System.in;
import static java.lang.System.out;
import java.net.Socket;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author guilherme
 */
public class JIdentificacaoVeiculoRevisao extends javax.swing.JDialog {
    private boolean identificado=false;
    private String idVeiculo;
    private boolean killThread = false;
    private Socket socket;

    /**
     * Creates new form JVeiculoRevisao
     */
    public JIdentificacaoVeiculoRevisao() {
        setModal(true);
        initComponents();
        new ComunicacaoRFID().start();
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
        tfPlaca = new javax.swing.JTextField();
        bOk = new javax.swing.JButton();
        bCancelar = new javax.swing.JButton();
        tbRFID = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Identificação do Veículo da Revisão");
        setResizable(false);

        jLabel1.setText("Placa do Veículo:");

        bOk.setText("Ok");
        bOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bOkActionPerformed(evt);
            }
        });

        bCancelar.setText("Cancelar");
        bCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelarActionPerformed(evt);
            }
        });

        tbRFID.setText("Identifica RFID");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tbRFID)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                        .addComponent(bOk, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfPlaca)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bOk)
                    .addComponent(bCancelar)
                    .addComponent(tbRFID))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_bCancelarActionPerformed

    private void bOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bOkActionPerformed
        if(!tfPlaca.getText().matches("[a-zA-Z]{3,3}-\\d{4,4}")){
            JOptionPane.showMessageDialog(null, "Esta placa não está em um formato válido");
            return;
        }
        idVeiculo = tfPlaca.getText().toUpperCase();
        identificado = true;
        killThread = true;
            try {
                socket.close();
                dispose();
            } catch (IOException ex) {
                Logger.getLogger(JIdentificacaoVeiculoRevisao.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_bOkActionPerformed

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
            java.util.logging.Logger.getLogger(JIdentificacaoVeiculoRevisao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JIdentificacaoVeiculoRevisao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JIdentificacaoVeiculoRevisao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JIdentificacaoVeiculoRevisao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JIdentificacaoVeiculoRevisao dialog = new JIdentificacaoVeiculoRevisao();
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

    public boolean isIdentificado() {
        return identificado;
    }

    public void setIdentificado(boolean identificado) {
        this.identificado = identificado;
    }

    public String getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(String idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCancelar;
    private javax.swing.JButton bOk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JToggleButton tbRFID;
    private javax.swing.JTextField tfPlaca;
    // End of variables declaration//GEN-END:variables

    public class ComunicacaoRFID extends Thread{
            
        public ComunicacaoRFID(){
            try {
                socket = new Socket("192.168.100.8", 2020);
            } catch (IOException ex) {
                
            }
        }
        
        public void run(){
            DataOutputStream esc = new DataOutputStream(out);
            DataInputStream ler = new DataInputStream(in);

            while(!killThread){
                try {
                    if(socket!=null && !socket.isClosed() && tbRFID.isSelected()){
                        esc = new DataOutputStream(socket.getOutputStream());
                        ler = new DataInputStream(socket.getInputStream());

                        esc.writeBytes("ping");
                        byte b[] = new byte[11];
                        ler.read(b);//Para receber em bytes
                        String rfid = new String(b);
                        if(rfid != null && rfid.compareTo("")!=0){
                            idVeiculo = rfid;
                            identificado = true;
                            esc.close();
                            ler.close();
                            socket.close();
                            dispose();
                            return;
                        }
                    }
                }
                catch(Exception ex){
                    System.out.println(ex.getMessage());
                }
            }
            try {
                esc.close();
                ler.close();
                socket.close();
                dispose();
            } catch (IOException ex) {
                Logger.getLogger(JIdentificacaoVeiculoRevisao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
