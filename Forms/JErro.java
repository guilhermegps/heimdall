/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heimdall.Forms;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guilherme
 */
public class JErro extends javax.swing.JDialog {
    
    private String icone = "", mensagemDetalhes, tituloJanela, mensagemJanela; 
    private boolean gerarLog, isError /*true = erro, false = Alerta*/, gerarJanela, sairSistema /*Sai do sistema após encerrar a janela*/;

    /**
     * Creates new form JErro
     */
    public JErro(boolean janela, Throwable exception, boolean log, boolean isError, boolean sair) {
        this.gerarLog = log;
        this.isError = isError;
        this.gerarJanela = janela;
        this.sairSistema = sair;     
        this.mensagemDetalhes = getStack(exception); 
        
        initialize();
    }
    
    public JErro(boolean janela, String mensagem, boolean log, boolean isError, boolean sair) {
        this.mensagemDetalhes = mensagem;
        this.gerarLog = log;
        this.isError = isError;
        this.gerarJanela = janela;
        this.sairSistema = sair;       
        
        initialize();
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
        bFecharErro = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle(this.tituloJanela);
        setResizable(false);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText(mensagemDetalhes);
        jScrollPane1.setViewportView(jTextArea1);

        bFecharErro.setText("Fechar");
        bFecharErro.setPreferredSize(new java.awt.Dimension(75, 30));
        bFecharErro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bFecharErroActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource(this.icone)));
        jLabel1.setMaximumSize(new java.awt.Dimension(80, 80));
        jLabel1.setMinimumSize(new java.awt.Dimension(80, 80));
        jLabel1.setPreferredSize(new java.awt.Dimension(80, 80));

        jLabel2.setText(mensagemJanela);
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel2.setFocusable(false);

        jLabel3.setText("<html> <b><font color=\"red\" align=\"justify\">O sistema será encerrado</font></b>");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bFecharErro, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bFecharErro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bFecharErroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bFecharErroActionPerformed
        if(sairSistema){
            System.exit(0);
        }
        
        dispose();
    }//GEN-LAST:event_bFecharErroActionPerformed
    
    private void initialize(){        
        setModal(true); //Faz com que o sistema aguarde a conclusão do JDialog para seguir com a execução. 
        
        if(mensagemDetalhes == null){
            mensagemDetalhes = "Um erro foi identificado, mas não possui detalhes especificados.";
        }
        
        if(isError){
            tituloJanela = "ERRO";
            mensagemJanela = "<html> <b><font color=\"red\" align=\"justify\">Houve um erro no sistema ao tentar realizar uma operação.<br/> Favor, entrar em contato com o suporte. <br/> Detalhes do erro a seguir: </font></b>";
            icone = "/heimdall/img/icons 80x80/error.png";
        } else {
            tituloJanela = "ALERTA";
            mensagemJanela = "<html> <b><font color=\"red\" align=\"justify\"> <font size=\"6\">Atenção!</font> <br/> Este é um alerta do sistema. <br/> Detalhes do alerta a seguir: </font></b>";
            icone = "/heimdall/img/icons 80x80/warning.png";
        }
        
        initComponents();
        jLabel3.setVisible(sairSistema);
        setVisible(gerarJanela);        
    }
    
    private void geraLog(){
        
    }
    
    public static String getStack(Throwable exception) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        exception.printStackTrace(pw);
        return (sw.toString());
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bFecharErro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
