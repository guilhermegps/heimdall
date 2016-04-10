/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heimdall.Portatil;

import heimdall.ExecutaSQL;
import heimdall.Forms.JErro;
import heimdall.Util.Componente;
import heimdall.Util.ComponenteRevisao;
import heimdall.Util.Revisao;
import heimdall.Util.Usuario;
import heimdall.Util.Veiculo;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import static java.lang.System.in;
import static java.lang.System.out;
import java.net.Socket;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author guilherme
 */
public class JRevisao extends javax.swing.JDialog {

    private DefaultTableModel dtm;
    private Veiculo veiculo;
    private Usuario usuario; 
    private DataOutputStream esc = new DataOutputStream(out);
    private DataInputStream ler = new DataInputStream(in);
    private Socket socket;
    private boolean killThread = false;
    private ArrayList<LeituraRFID> cacheComponentes;
    
    /**
     * Creates new form JRevisao
     */    
    public JRevisao(Veiculo veiculo, Usuario usuario){
        setModal(true);
        this.veiculo = veiculo;
        this.usuario = usuario;
        this.cacheComponentes = new ArrayList<LeituraRFID>();
        initComponents();
        initTable();
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

        bConcluirRevisao = new javax.swing.JButton();
        bCancelarRevisao = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tRevisaoComponentes = new javax.swing.JTable();
        tfLinhasTabela = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tfIdVeiculo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        taDescricao = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Revisão do Veículo");
        setResizable(false);

        bConcluirRevisao.setText("Concluir");
        bConcluirRevisao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bConcluirRevisaoActionPerformed(evt);
            }
        });

        bCancelarRevisao.setText("Cancelar");
        bCancelarRevisao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelarRevisaoActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tRevisaoComponentes.setAutoCreateRowSorter(true);
        tRevisaoComponentes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Número RFID", "Verificação", "Revisado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tRevisaoComponentes.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(tRevisaoComponentes);
        if (tRevisaoComponentes.getColumnModel().getColumnCount() > 0) {
            tRevisaoComponentes.getColumnModel().getColumn(0).setMinWidth(130);
            tRevisaoComponentes.getColumnModel().getColumn(1).setMinWidth(180);
            tRevisaoComponentes.getColumnModel().getColumn(2).setMinWidth(95);
        }

        tfLinhasTabela.setEditable(false);

        jLabel9.setText("Nº");

        tfIdVeiculo.setEditable(false);

        jLabel1.setText("Veículo:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(tfIdVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfLinhasTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(tfLinhasTabela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(tfIdVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jLabel2.setText("Descrição da Revisão:");

        taDescricao.setColumns(20);
        taDescricao.setRows(5);
        jScrollPane2.setViewportView(taDescricao);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bConcluirRevisao, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bCancelarRevisao, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bConcluirRevisao)
                    .addComponent(bCancelarRevisao))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bCancelarRevisaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarRevisaoActionPerformed
        int resp = JOptionPane.showConfirmDialog(null,"Você tem certeza que deseja cancelar esta revisão?","Tem certeza?",JOptionPane.YES_NO_OPTION);
        if(resp==0){
            closeConexao();
            dispose();
        }
    }//GEN-LAST:event_bCancelarRevisaoActionPerformed

    private void bConcluirRevisaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bConcluirRevisaoActionPerformed
        doConcluirRevisao();
    }//GEN-LAST:event_bConcluirRevisaoActionPerformed
    
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
            java.util.logging.Logger.getLogger(JRevisao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JRevisao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JRevisao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JRevisao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JRevisao(new Veiculo(), new Usuario()).setVisible(true);
            }
        });
    }
    
    private void initTable(){
        if(cacheComponentes.size()==0){
            ExecutaSQL sql = new ExecutaSQL();
            ArrayList<Componente> componentesVeiculo = sql.SELECT_COMPONENTE("veiculo_id_veiculo", Integer.toString(veiculo.getId()));
            for(int i=0; i<componentesVeiculo.size(); i++){
                cacheComponentes.add(new LeituraRFID(
                        componentesVeiculo.get(i), 
                        false, 
                        true,
                        null,
                        "") );
            }
        }
        
        DefaultTableModel dtm = (DefaultTableModel) tRevisaoComponentes.getModel();
        
        while(dtm.getRowCount()>0){
            dtm.removeRow(0);
        }
                
        for(int i=0;i<cacheComponentes.size();i++){
            ImageIcon icone = new ImageIcon();
            
            if(cacheComponentes.get(i).isLido() && cacheComponentes.get(i).isPertenceVeiculo()) //Existe no veículo e foi revisado
                icone = new ImageIcon(getClass().getResource("/heimdall/img/icons 16x16/accept.png"));
            else if(!cacheComponentes.get(i).isLido() && cacheComponentes.get(i).isPertenceVeiculo()) //Existe no veículo e não foi revisado
                icone = new ImageIcon(getClass().getResource("/heimdall/img/icons 16x16/cancel.png"));
            else //Não existe no veículo
               icone = new ImageIcon(getClass().getResource("/heimdall/img/icons 16x16/bullet_error.png")); 
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
            dtm.addRow(
                    new Object[] {cacheComponentes.get(i).getComponente().getRfid(), 
                        (cacheComponentes.get(i).isLido()==false) ? "" : sdf.format(cacheComponentes.get(i).getMomentoLeitura()), 
                        icone}
            );   
        }
        
        TableColumnModel columnModel = tRevisaoComponentes.getColumnModel();
        JTableRenderer renderer = new JTableRenderer();
        columnModel.getColumn(2).setCellRenderer(renderer);
        
        tfIdVeiculo.setText(veiculo.toString());
        tRevisaoComponentes.setModel(dtm);
        tfLinhasTabela.setText(Integer.toString(dtm.getRowCount()));
    }
    
    private int pesquisaCache(String rfid){
        for(int i=0; i<cacheComponentes.size(); i++){
            if(rfid.equals(cacheComponentes.get(i).getComponente().getRfid())){
                return i;
            }
        }
        
        return -1;
    }
    
    private boolean inserirRevisao(){
        boolean inseriu = false;
        try{
            ExecutaSQL sql = new ExecutaSQL();

            int idRevisao = sql.INSERT_REVISAO(new Revisao(
                    0, 
                    usuario, 
                    veiculo, 
                    new Timestamp(new Date().getTime()), 
                    taDescricao.getText() )
            );

            Revisao revisao = sql.SELECT_REVISAO("id_revisao", Integer.toString(idRevisao)).get(0);
            for(int i=0; i<cacheComponentes.size(); i++){
                if(!cacheComponentes.get(i).isPertenceVeiculo())
                    continue;

                sql.INSERT_COMPONENTE_REVISAO(new ComponenteRevisao(
                        cacheComponentes.get(i).getComponente(), 
                        revisao, 
                        (cacheComponentes.get(i).isLido() && cacheComponentes.get(i).isPertenceVeiculo()) ? true : false, 
                        cacheComponentes.get(i).getMomentoLeitura(), 
                        cacheComponentes.get(i).getMotivoNaoIdentificado() )
                );
                inseriu = true;
            }
        } catch(Exception ex){
            new JErro(true, ex, true, true, false);
            inseriu = false;
        }
        return inseriu;
    }
    
    private void doConcluirRevisao(){
        if(cacheComponentes.size()<=0){
            JOptionPane.showMessageDialog(null, "Não há componentes para serem revisados.");
            return;
        }
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
        boolean haComponentesRevisao = false;
        for(int i=0; i<cacheComponentes.size(); i++){
            
            if(cacheComponentes.get(i).isPertenceVeiculo())
                haComponentesRevisao = true;
            
            if(cacheComponentes.get(i).isLido())
                continue;
            
            JMotivoNaoRevisado motivoNaoRevisado = new JMotivoNaoRevisado(cacheComponentes.get(i).getComponente().getRfid());
            motivoNaoRevisado.setVisible(true);
            
            if(motivoNaoRevisado.isCancelado()){
                return;
            }
            
            cacheComponentes.get(i).setMotivoNaoIdentificado(motivoNaoRevisado.getMotivo());
        }
        
        if(!haComponentesRevisao){
            JOptionPane.showMessageDialog(null, "Não há componentes deste veículo para serem revisados.");
            return;
        }
        
        if(!inserirRevisao()){
            JOptionPane.showMessageDialog(null, "Não foi possível concluir a revisão");
            dispose();
        }
        
        closeConexao();
        JOptionPane.showMessageDialog(null, "Revisão concluida com sucesso.");
        dispose();
    }
    
    private void addCache(String rfid, Timestamp leitura){  
        if(rfid.equals(""))
            return;
        
        int posicao = pesquisaCache(rfid);
        
        if(posicao>=0){
            if(cacheComponentes.get(posicao).isLido()==false){
                cacheComponentes.get(posicao).setLido(true);
                cacheComponentes.get(posicao).setMomentoLeitura(leitura);
        
                initTable();
            }
        } else{
            Componente componente = new Componente(0, null, null, 0, rfid, "", "", null, null);
            cacheComponentes.add(new LeituraRFID(
                    componente, 
                    true, 
                    false,
                    leitura,
                    "") );
        
            initTable();
        }
    }
    
    private void closeConexao(){
        try {
            esc.close();
            ler.close();
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(JRevisao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCancelarRevisao;
    private javax.swing.JButton bConcluirRevisao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tRevisaoComponentes;
    private javax.swing.JTextArea taDescricao;
    private javax.swing.JTextField tfIdVeiculo;
    private javax.swing.JTextField tfLinhasTabela;
    // End of variables declaration//GEN-END:variables

    private class LeituraRFID{
        private Componente componente;
        private boolean lido;
        private boolean pertenceVeiculo;
        private Timestamp momentoLeitura;
        private String motivoNaoIdentificado;

        public LeituraRFID(Componente componente, boolean lido, boolean pertenceVeiculo, Timestamp momentoLeitura, String motivoNaoIdentificado) {
            this.componente = componente;
            this.lido = lido;
            this.pertenceVeiculo = pertenceVeiculo;
            this.momentoLeitura = momentoLeitura;
            this.motivoNaoIdentificado = motivoNaoIdentificado;
        }

        public Componente getComponente() {
            return componente;
        }

        public void setComponente(Componente componente) {
            this.componente = componente;
        }

        public boolean isLido() {
            return lido;
        }

        public void setLido(boolean lido) {
            this.lido = lido;
        }

        public boolean isPertenceVeiculo() {
            return pertenceVeiculo;
        }

        public void setPertenceVeiculo(boolean pertenceVeiculo) {
            this.pertenceVeiculo = pertenceVeiculo;
        }

        public Timestamp getMomentoLeitura() {
            return momentoLeitura;
        }

        public void setMomentoLeitura(Timestamp momentoLeitura) {
            this.momentoLeitura = momentoLeitura;
        }

        public String getMotivoNaoIdentificado() {
            return motivoNaoIdentificado;
        }

        public void setMotivoNaoIdentificado(String motivoNaoIdentificado) {
            this.motivoNaoIdentificado = motivoNaoIdentificado;
        }
    }
    
    private class ComunicacaoRFID extends Thread{
        public ComunicacaoRFID(){
            try {
                socket = new Socket("192.168.100.8", 2020);
            } catch (IOException ex) {
                
            }
        }
        
        public void run(){            
            while(!killThread){
                try {
                    if(socket!=null && !socket.isClosed()){
                        esc = new DataOutputStream(socket.getOutputStream());
                        ler = new DataInputStream(socket.getInputStream());

                        esc.writeBytes("ping");
                        byte b[] = new byte[11];
                        ler.read(b);//Para receber em bytes
                        String rfid = new String(b);
                        if(rfid != null && !rfid.equals("")){
                            addCache(rfid, new Timestamp(new Date().getTime()));
                        }
                    }
                }
                catch(Exception ex){
                    System.out.println(ex.getMessage());
                }
            }
            closeConexao();
        }
    }
}
