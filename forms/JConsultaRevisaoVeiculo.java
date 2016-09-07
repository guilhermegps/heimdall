/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heimdall.forms;

import heimdall.ExecutaSQL;
import heimdall.util.Revisao;
import heimdall.util.Veiculo;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author guilherme
 */
public class JConsultaRevisaoVeiculo extends javax.swing.JDialog {
    private static final Logger logger = LogManager.getLogger(JConsultaRevisaoVeiculo.class.getName());

    private Veiculo veiculo;
    private ExecutaSQL sql = new ExecutaSQL();
    private ArrayList<Revisao> cacheRevisao;
            
    /**
     * Creates new form JConsultaRevisao
     */
    public JConsultaRevisaoVeiculo() {
        setModal(true);
        cacheRevisao = new ArrayList<Revisao>();
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

        tpComponente = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        tfLinhasTabela = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tRevisao = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        tfDescricaoVeiculo = new javax.swing.JTextField();
        tfCodigoVeiculo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        bBuscaVeiculo = new javax.swing.JButton();
        ftfDataInicial = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        ftfDataFinal = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        bPesquisa = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        bDetalha = new javax.swing.JButton();
        bSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta de Revisões por Veículo");

        tfLinhasTabela.setEditable(false);

        jLabel10.setText("Nº");

        tRevisao.setAutoCreateRowSorter(true);
        tRevisao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Número", "Data da Revisão", "Revisor", "Descrição", "Completa"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
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
        tRevisao.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tRevisao.setAutoscrolls(false);
        tRevisao.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane7.setViewportView(tRevisao);
        if (tRevisao.getColumnModel().getColumnCount() > 0) {
            tRevisao.getColumnModel().getColumn(0).setPreferredWidth(100);
            tRevisao.getColumnModel().getColumn(1).setPreferredWidth(150);
            tRevisao.getColumnModel().getColumn(2).setPreferredWidth(300);
            tRevisao.getColumnModel().getColumn(3).setPreferredWidth(200);
            tRevisao.getColumnModel().getColumn(4).setPreferredWidth(80);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(499, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfLinhasTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane7)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfLinhasTabela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addContainerGap())
        );

        tpComponente.addTab("Revisões", jPanel2);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados de Pesquisa das Revisões"));

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tfDescricaoVeiculo.setEditable(false);

        tfCodigoVeiculo.setEditable(false);

        jLabel1.setText("Veículo*:");

        bBuscaVeiculo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/heimdall/img/icons 32x32/search.png"))); // NOI18N
        bBuscaVeiculo.setToolTipText("Customizar Modelos");
        bBuscaVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBuscaVeiculoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bBuscaVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfCodigoVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfDescricaoVeiculo))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bBuscaVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfDescricaoVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfCodigoVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        try {
            ftfDataInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftfDataInicial.setToolTipText("Ex: 10/02/2015");
        ftfDataInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ftfDataInicialKeyPressed(evt);
            }
        });

        jLabel2.setText("Data Inicial*:");

        try {
            ftfDataFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftfDataFinal.setToolTipText("Ex: 10/02/2015");
        ftfDataFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ftfDataFinalKeyPressed(evt);
            }
        });

        jLabel3.setText("Data Final*:");

        bPesquisa.setText("Pesquisar");
        bPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPesquisaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ftfDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ftfDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bPesquisa)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ftfDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(ftfDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bPesquisa))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bDetalha.setText("Detalhar");
        bDetalha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDetalhaActionPerformed(evt);
            }
        });

        bSair.setText("Sair");
        bSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bDetalha, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
            .addComponent(bSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(bDetalha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 254, Short.MAX_VALUE)
                .addComponent(bSair))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tpComponente, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tpComponente)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bBuscaVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBuscaVeiculoActionPerformed
        buscaVeiculo();
    }//GEN-LAST:event_bBuscaVeiculoActionPerformed

    private void bPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPesquisaActionPerformed
        pesquisarRevisoes();
    }//GEN-LAST:event_bPesquisaActionPerformed

    private void ftfDataInicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ftfDataInicialKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
             pesquisarRevisoes();
        }
    }//GEN-LAST:event_ftfDataInicialKeyPressed

    private void ftfDataFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ftfDataFinalKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
             pesquisarRevisoes();
        }
    }//GEN-LAST:event_ftfDataFinalKeyPressed

    private void bSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSairActionPerformed
        dispose();
    }//GEN-LAST:event_bSairActionPerformed

    private void bDetalhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDetalhaActionPerformed
        Revisao revisao = selectedLine();
        
        if(revisao==null){
            logger.info("É necessário selecionar uma das revisões da tabela.");
            JOptionPane.showMessageDialog(null, "É necessário selecionar uma das revisões da tabela.");
            return;
        } else{
            new JDetalhaRevisaoVeiculo(revisao).setVisible(true);
        }
    }//GEN-LAST:event_bDetalhaActionPerformed

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
            java.util.logging.Logger.getLogger(JConsultaRevisaoVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JConsultaRevisaoVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JConsultaRevisaoVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JConsultaRevisaoVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JConsultaRevisaoVeiculo dialog = new JConsultaRevisaoVeiculo();
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
    
    private void buscaVeiculo(){
        JSelecionaItem selecionaItem = new JSelecionaItem("Selecione um Veículo", "Código", "Veículo", true);
        
        ArrayList<Veiculo> veiculos = sql.SELECT_ALL_VEICULO();
        for(int i=0; i<veiculos.size(); i++)
            selecionaItem.add(veiculos.get(i).getCodigo(), veiculos.get(i).toString(), veiculos.get(i));
        
        selecionaItem.setVisible(true);
        
        if(selecionaItem.getObjetoSelecionado()!=null){
            veiculo = (Veiculo)selecionaItem.getObjetoSelecionado();
            tfCodigoVeiculo.setText(Integer.toString(veiculo.getCodigo()));
            tfDescricaoVeiculo.setText(veiculo.toString());
        }
    }
    
    private void pesquisarRevisoes(){
        if(veiculo==null){
            logger.info("O campo [Veiculo] está vazio.");
            JOptionPane.showMessageDialog(null, "O campo [Veiculo] está vazio.");
            return;
        }
        
        if(!dataValida(ftfDataInicial.getText())){
            logger.info("O campo [Data Inicial] está vazio ou contem uma data inválida.");
            JOptionPane.showMessageDialog(null, "O campo [Data Inicial] está vazio ou contem uma data inválida.");
            return;
        }
        
        if(!dataValida(ftfDataFinal.getText())){
            logger.info("O campo [Data Final] está vazio ou contem uma data inválida.");
            JOptionPane.showMessageDialog(null, "O campo [Data Final] está vazio ou contem uma data inválida.");
            return;
        }
        
        String dataIni[] = ftfDataInicial.getText().split("/");
        Timestamp dataInicial = sql.ConvertStringTimestamp(dataIni[2]+'-'+dataIni[1]+'-'+dataIni[0]);
        String dataFin[] = ftfDataFinal.getText().split("/");
        Timestamp dataFinal = sql.ConvertStringTimestamp(dataFin[2]+'-'+dataFin[1]+'-'+dataFin[0]);
        
        if(new Date(dataFinal.getTime()).before(new Date(dataInicial.getTime()))){
            logger.info("A [Data Final] não pode ser menor que a [Data Inicial].");
            
            JOptionPane.showMessageDialog(null, "A [Data Final] não pode ser menor que a [Data Inicial].");
            return;
        }
        
        cacheRevisao = sql.SELECT_REVISAO_CONSULTA(veiculo.getId(), dataInicial, dataFinal);
        initTable();
    }
    
    private boolean dataValida(String data){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);

        try {
          sdf.parse(data);
        } catch(ParseException e) {
          return false;
        }
        return true;
    }
    
    private void initTable(){        
        DefaultTableModel dtm = (DefaultTableModel) tRevisao.getModel();
        
        while(dtm.getRowCount()>0){
            dtm.removeRow(0);
        }
                
        for(int i=0;i<cacheRevisao.size();i++){
            boolean completa = sql.SELECT_VERIFICA_REVISAO_COMPLETA(cacheRevisao.get(i).getId());
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
            dtm.addRow(
                    new Object[] {
                        cacheRevisao.get(i).getNumero(),
                        sdf.format(cacheRevisao.get(i).getRegistro()), 
                        cacheRevisao.get(i).getUsuarioRevisao().toString(), 
                        cacheRevisao.get(i).getDescricao(),
                        completa
                    }
            );   
        }
        
        tRevisao.setModel(dtm);
        tfLinhasTabela.setText(Integer.toString(dtm.getRowCount()));
    }
    
    public Revisao selectedLine(){
        if(tRevisao.getSelectedRow()<0)
            return null;
        
        for(int i=0; i<cacheRevisao.size(); i++){
            if(cacheRevisao.get(i).getNumero() == (int)tRevisao.getValueAt(tRevisao.getSelectedRow(), 0)) 
                return cacheRevisao.get(i);
        }
        
        return null;
    }
    
    /*private int pesquisaCache(String rfid){
        for(int i=0; i<cacheRevisao.size(); i++){
            if(rfid.equals(cacheRevisao.get(i).getComponente().getRfid())){
                return i;
            }
        }
        
        return -1;
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bBuscaVeiculo;
    private javax.swing.JButton bDetalha;
    private javax.swing.JButton bPesquisa;
    private javax.swing.JButton bSair;
    private javax.swing.JFormattedTextField ftfDataFinal;
    private javax.swing.JFormattedTextField ftfDataInicial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTable tRevisao;
    private javax.swing.JTextField tfCodigoVeiculo;
    private javax.swing.JTextField tfDescricaoVeiculo;
    private javax.swing.JTextField tfLinhasTabela;
    private javax.swing.JTabbedPane tpComponente;
    // End of variables declaration//GEN-END:variables

}
