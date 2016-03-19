/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heimdall.Portatil;

import heimdall.EncriptaDecriptaAES;
import heimdall.ExecutaSQL;
import heimdall.Util.ComponenteRevisao;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import static java.lang.System.in;
import static java.lang.System.out;
import java.net.Socket;
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
public class JIRevisao extends javax.swing.JInternalFrame {
    private ArrayList<ComponenteRevisao> componentesRevisao;
    private boolean killThread = false;
    private JIdentificacaoVeiculoRevisao jveiculo;
    private DataOutputStream esc = new DataOutputStream(out);
    private DataInputStream ler = new DataInputStream(in);
    private Socket socket;

    /**
     * Creates new form JIRevisao
     */
    public JIRevisao() {
        componentesRevisao = new ArrayList<ComponenteRevisao>();
        jveiculo = new JIdentificacaoVeiculoRevisao();
        jveiculo.setVisible(true);
        if(!jveiculo.isIdentificado()){
            JOptionPane.showMessageDialog(null, "Não foi possivel iniciar uma revisão pois não foi fornecido uma dientificaçã do veículo.");
            return;
        }
        System.out.println(jveiculo.getIdVeiculo());
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

        bCancelar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tComponentesRevisao = new javax.swing.JTable();
        bTodos = new javax.swing.JButton();
        tfLinhasTabela = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        bExcluirVerificaoes = new javax.swing.JButton();
        bConcluirRevisao = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(400, 502));

        bCancelar.setText("Cancelar");
        bCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tComponentesRevisao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Número RFID", "Verificado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tComponentesRevisao);
        if (tComponentesRevisao.getColumnModel().getColumnCount() > 0) {
            tComponentesRevisao.getColumnModel().getColumn(0).setPreferredWidth(50);
            tComponentesRevisao.getColumnModel().getColumn(1).setPreferredWidth(300);
            tComponentesRevisao.getColumnModel().getColumn(2).setPreferredWidth(100);
        }

        bTodos.setText("Todos");
        bTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTodosActionPerformed(evt);
            }
        });

        tfLinhasTabela.setEditable(false);

        jLabel9.setText("Nº");

        bExcluirVerificaoes.setText("Excluir Verificações");
        bExcluirVerificaoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bExcluirVerificaoesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bTodos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addComponent(bExcluirVerificaoes)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfLinhasTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(tfLinhasTabela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bExcluirVerificaoes))
                    .addComponent(bTodos))
                .addContainerGap())
        );

        bConcluirRevisao.setText("Concluir Revisão");
        bConcluirRevisao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bConcluirRevisaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bConcluirRevisao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bCancelar)
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bCancelar)
                    .addComponent(bConcluirRevisao))
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed
        sair();
    }//GEN-LAST:event_bCancelarActionPerformed

    private void bExcluirVerificaoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bExcluirVerificaoesActionPerformed
        deleteRows();
    }//GEN-LAST:event_bExcluirVerificaoesActionPerformed

    private void bConcluirRevisaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bConcluirRevisaoActionPerformed
        if(componentesRevisao.size()<1){
            JOptionPane.showMessageDialog(null, "Não há componentes identificados nessa revisão.");
            return;
        }
        int resp = JOptionPane.showConfirmDialog(null,"Você tem certeza de que deseja concluir essa revisão?","Concluir revisão",JOptionPane.YES_NO_OPTION);
        if(resp==0){
            gerarArquivo();
            sair();
        }
    }//GEN-LAST:event_bConcluirRevisaoActionPerformed

    private void bTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTodosActionPerformed
        
    }//GEN-LAST:event_bTodosActionPerformed

    private void deleteRows(){ // Não pode haver linhas com Código RFID repetido  
        for(int i=0;i<tComponentesRevisao.getRowCount();i++){ // Percorre a tabela
            if((boolean)tComponentesRevisao.getValueAt(i,0) == true){ // Verificar se a caixa está marcada naquela linha
                for(int f=0; f<componentesRevisao.size(); f++){ // Percorre a lista de componentes
                    if(componentesRevisao.get(f).getRFID().compareTo((String)tComponentesRevisao.getValueAt(i,1))==0){ // Verifica se o componente é o mesmo da linha da tabela
                        componentesRevisao.remove(f); // Remove o componente da lista
                        break;
                    }
                }
            }
        }
        initTable();
    }
    
    private void initTable(){        
        DefaultTableModel dtm = (DefaultTableModel) tComponentesRevisao.getModel();
        
        while(dtm.getRowCount()>0){
            dtm.removeRow(0);
        }
                
        for(int i=0;i<componentesRevisao.size();i++){
            ImageIcon icone = new ImageIcon();
            
            if(componentesRevisao.get(i).isVerificado())
                icone = new ImageIcon(getClass().getResource("/heimdall/img/icons 16x16/accept.png"));
            else
                icone = new ImageIcon(getClass().getResource("/heimdall/img/icons 16x16/cancel.png"));
            
            dtm.addRow(new Object[] {false, componentesRevisao.get(i).getRFID(), icone});   
        }
        
        TableColumnModel columnModel = tComponentesRevisao.getColumnModel();
        JTableRenderer renderer = new JTableRenderer();
        columnModel.getColumn(2).setCellRenderer(renderer);
        
        tComponentesRevisao.setModel(dtm);
        tfLinhasTabela.setText(Integer.toString(dtm.getRowCount()));
    }
    
    private void gerarArquivo(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss"); 
        EncriptaDecriptaAES AES = new EncriptaDecriptaAES();
        String idVeiculo = jveiculo.getIdVeiculo().replaceAll(" ", "_").replaceAll("-", "_");
        File f = new File("revisoes/"+idVeiculo+"_heimdallrevisao_"+sdf.format(new Date())+".rev");
        
        try {
            if(f.isFile())
                f.delete();
            new File("revisoes/").mkdir();
            FileOutputStream arquivo = new FileOutputStream(f);
            ObjectOutputStream objGravar = new ObjectOutputStream(arquivo);
            
            objGravar.writeObject(componentesRevisao); //Gera Arquivo temporario
            objGravar.close();
            arquivo.close();
            
            byte[] arquivoBytes = AES.getBytesFile(f);
            f.delete(); // Apaga arquivo temporario
            arquivo = new FileOutputStream(f);
            arquivo.write(AES.encriptaAES(arquivoBytes));
            arquivo.close();
            
        } catch (IOException ex) {
            Logger.getLogger(JIRevisao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void sair(){
        componentesRevisao = new ArrayList<ComponenteRevisao>();
        killThread = true;
        try {
            esc.close();
            ler.close();
            socket.close();
            dispose();
        } catch (IOException ex) {
            Logger.getLogger(JIRevisao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void mostraDadosArquivo(){ // Para testes
        EncriptaDecriptaAES AES = new EncriptaDecriptaAES();
        String nomeArquivo = JOptionPane.showInputDialog("Nome do arquivo");
        File f = new File("revisoes/"+nomeArquivo);
        byte bytesArquivo[];
        
        try {
            if(f.exists() && f.isFile()){
                bytesArquivo = AES.getBytesFile(f);
                f = new File("revisoes/temporario.temp");
                
                FileOutputStream esc = new FileOutputStream(f);
                esc.write(AES.decriptaAES(bytesArquivo));
                esc.close();
                
                FileInputStream ler = new FileInputStream(f);
                ObjectInputStream objLer = new ObjectInputStream(ler);
                ArrayList<ComponenteRevisao> aux = (ArrayList<ComponenteRevisao>) objLer.readObject();
                f.delete();
                
                for(int i=0; i<aux.size(); i++){
                    System.out.println(aux.get(i).getRFID());
                }
            }
            else {
                System.out.println("Arquivo não encontrado");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JIRevisao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JIRevisao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JIRevisao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCancelar;
    private javax.swing.JButton bConcluirRevisao;
    private javax.swing.JButton bExcluirVerificaoes;
    private javax.swing.JButton bTodos;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tComponentesRevisao;
    private javax.swing.JTextField tfLinhasTabela;
    // End of variables declaration//GEN-END:variables

    
    public class ComunicacaoRFID extends Thread{
            
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
                        if(rfid != null && rfid.compareTo("")!=0 && !existeComponente(rfid) && rfid.compareTo(jveiculo.getIdVeiculo())!=0){
                            componentesRevisao.add(new ComponenteRevisao(rfid, jveiculo.getIdVeiculo(), true, "", new ExecutaSQL().ConvertStringTimestamp(new Date().toString())));
                            initTable();
                        }
                    }
                }
                catch(Exception ex){
                    System.out.println(ex.getMessage());
                }
            }
        }
        
        private boolean existeComponente(String RFID){
            for(int i=0; i<componentesRevisao.size(); i++){
                if(componentesRevisao.get(i).getRFID().compareTo(RFID)==0){
                    return true;
                }
            }
            return false;
        }
    }
}