/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package heimdall.Forms;

import heimdall.ConfiguraTabelaPadrao;
import heimdall.ExecutaSQL;
import heimdall.Util.Classe;
import heimdall.Util.Modelo;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author guilherme
 */
public class JModelo extends javax.swing.JDialog {

    /**
     * Creates new form JModelo
     */
    
    private Boolean classe;
    private DefaultTableModel dtm;
    private ArrayList<Classe> classes;
    private int operacao = 0;
    private boolean killThread = false;
    
    public JModelo(Boolean classe) {
        setModal(true); //Faz com que o sistema aguarde a conclusão do JDialog para seguir com a execução. 
        this.classe = classe;
        initTable();
        initComponents();
        new Campos().start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tbModelo = new javax.swing.JToolBar();
        bSaveCdtModelo = new javax.swing.JButton();
        bNewCdtModelo = new javax.swing.JButton();
        bEditCdtModelo = new javax.swing.JButton();
        bDeleteCdtVeiculo = new javax.swing.JButton();
        bRefreshCdtModelo = new javax.swing.JButton();
        bCancelCdtModelo = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        tfModelo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        tfMarca = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cbClasse = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfLayout = new javax.swing.JTextField();
        tpModelo = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tModelo = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Customizar Modelo");
        setMinimumSize(new java.awt.Dimension(627, 353));
        setResizable(false);

        tbModelo.setFloatable(false);
        tbModelo.setRollover(true);

        bSaveCdtModelo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/heimdall/img/icons 50x50/save.png"))); // NOI18N
        bSaveCdtModelo.setToolTipText("Salvar Alterações");
        bSaveCdtModelo.setEnabled(false);
        bSaveCdtModelo.setFocusable(false);
        bSaveCdtModelo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bSaveCdtModelo.setPreferredSize(new java.awt.Dimension(50, 50));
        bSaveCdtModelo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bSaveCdtModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSaveCdtModeloActionPerformed(evt);
            }
        });
        tbModelo.add(bSaveCdtModelo);

        bNewCdtModelo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/heimdall/img/icons 50x50/new-file.png"))); // NOI18N
        bNewCdtModelo.setToolTipText("Novo Cadastro");
        bNewCdtModelo.setFocusable(false);
        bNewCdtModelo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bNewCdtModelo.setPreferredSize(new java.awt.Dimension(50, 50));
        bNewCdtModelo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bNewCdtModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNewCdtModeloActionPerformed(evt);
            }
        });
        tbModelo.add(bNewCdtModelo);

        bEditCdtModelo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/heimdall/img/icons 50x50/TextEdit.png"))); // NOI18N
        bEditCdtModelo.setToolTipText("Editar Cadastro");
        bEditCdtModelo.setFocusable(false);
        bEditCdtModelo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bEditCdtModelo.setPreferredSize(new java.awt.Dimension(50, 50));
        bEditCdtModelo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tbModelo.add(bEditCdtModelo);

        bDeleteCdtVeiculo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/heimdall/img/icons 50x50/delete.png"))); // NOI18N
        bDeleteCdtVeiculo.setToolTipText("Deletar Cadastro");
        bDeleteCdtVeiculo.setFocusable(false);
        bDeleteCdtVeiculo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bDeleteCdtVeiculo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tbModelo.add(bDeleteCdtVeiculo);

        bRefreshCdtModelo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/heimdall/img/icons 50x50/refresh.png"))); // NOI18N
        bRefreshCdtModelo.setToolTipText("Atualizar Lista");
        bRefreshCdtModelo.setFocusable(false);
        bRefreshCdtModelo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bRefreshCdtModelo.setPreferredSize(new java.awt.Dimension(50, 50));
        bRefreshCdtModelo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bRefreshCdtModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRefreshCdtModeloActionPerformed(evt);
            }
        });
        tbModelo.add(bRefreshCdtModelo);

        bCancelCdtModelo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/heimdall/img/icons 50x50/cancel.png"))); // NOI18N
        bCancelCdtModelo.setToolTipText("Cancelar e Sair");
        bCancelCdtModelo.setFocusable(false);
        bCancelCdtModelo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bCancelCdtModelo.setPreferredSize(new java.awt.Dimension(50, 50));
        bCancelCdtModelo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bCancelCdtModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelCdtModeloActionPerformed(evt);
            }
        });
        tbModelo.add(bCancelCdtModelo);

        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));

        tfModelo.setEnabled(false);

        jLabel1.setText("Modelo*: ");

        tfMarca.setEnabled(false);

        jLabel2.setText("Marca*: ");

        cbClasse.setModel(new javax.swing.DefaultComboBoxModel(carregarClasses(classe) ));
        cbClasse.setEnabled(false);

        jLabel4.setText("Classe*: ");

        jLabel3.setText("Layout*: ");

        tfLayout.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfMarca)
                    .addComponent(tfModelo, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfLayout)
                    .addComponent(cbClasse, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(tfLayout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(cbClasse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(tfMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tModelo.setAutoCreateRowSorter(true);
        tModelo.setModel(dtm);
        tModelo.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tModelo);

        tpModelo.addTab("Modelos", jScrollPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tbModelo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tpModelo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tbModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tpModelo, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                .addContainerGap())
        );

        tpModelo.getAccessibleContext().setAccessibleName("Modelos");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bCancelCdtModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelCdtModeloActionPerformed
        int resp = JOptionPane.showConfirmDialog(null,"Você tem certeza que deseja cancelar as alterações?","Tem certeza?",JOptionPane.YES_NO_OPTION);
        if(resp==0){
            dispose();
        }
    }//GEN-LAST:event_bCancelCdtModeloActionPerformed

    private void bNewCdtModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNewCdtModeloActionPerformed
        operacao = 1;
        liberarCampos(true);
    }//GEN-LAST:event_bNewCdtModeloActionPerformed

    private void bSaveCdtModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSaveCdtModeloActionPerformed
        switch (operacao) {
            case 1:
                ExecutaSQL sql = new ExecutaSQL();
                int aux = -1;
                Modelo m =  new Modelo();
                for(int i=0; i<classes.size(); i++){
                    if(classes.get(i).getNome().compareTo((String) cbClasse.getSelectedItem())==0){
                        aux=i;
                    }
                }
                if(aux>-1){
                    m.setLayout(tfLayout.getText());
                    m.setMarca(tfMarca.getText());
                    m.setModelo(tfModelo.getText());
                    m.setClasse(classes.get(aux));
                    if(!sql.INSERT_MODELO(m)){
                        JOptionPane.showMessageDialog(null,"Cadastrado com sucesso");
                        liberarCampos(false);
                    }else{
                        JOptionPane.showMessageDialog(null,"Falha no cadastrado.");
                    }
                    
                }else{
                    JOptionPane.showMessageDialog(null,"Escolha a classe do seu veículo");
                }
                break;
            case 2:
                
                break;
        }
        initTable();
        tModelo.setModel(dtm); 
    }//GEN-LAST:event_bSaveCdtModeloActionPerformed

    private void bRefreshCdtModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRefreshCdtModeloActionPerformed
        initTable();
        tModelo.setModel(dtm); 
    }//GEN-LAST:event_bRefreshCdtModeloActionPerformed
    
    public String[] carregarClasses(Boolean tipo){
        ExecutaSQL sql = new ExecutaSQL();
        classes = new ArrayList<Classe>();
        classes = sql.SELECT_CLASSE_TIPO(true);
        String c[] = new String[classes.size()+2];
        c[0] = "";
        for(int i=0;i<classes.size();i++){
            //System.out.println((i+1)+" - "+classes.get(i).getNome());
            c[i+1] = classes.get(i).getNome();
        }
        c[c.length-1] = "Outro";
        return c;
    }
    
    public void liberarCampos(boolean b){
        tfModelo.setText("");
        tfLayout.setText("");
        tfMarca.setText("");
        cbClasse.setSelectedItem("");
        
        tfModelo.setEnabled(b);
        tfLayout.setEnabled(b);
        tfMarca.setEnabled(b);
        cbClasse.setEnabled(b);
    }
    
    public void initTable(){
        ExecutaSQL sql = new ExecutaSQL();
        ArrayList<Modelo> aux = new ArrayList<Modelo>();
        ConfiguraTabelaPadrao confTabela = new ConfiguraTabelaPadrao(new String [] {"Modelo", "Marca", "Layout", "Classe"},
                new boolean [] {false, false, false, false},
                new Class [] {java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class}
        );
                
        aux = sql.SELECT_ALL_MODELO_VEICULO();
        Object valores[] = new Object[aux.size()];
        for(int i=0; i<aux.size(); i++){
            confTabela.addLinha(new Object[] {
                    aux.get(i).getModelo(),
                    aux.get(i).getMarca(),
                    aux.get(i).getLayout(),
                    aux.get(i).getClasse().getNome()}
            );
        }     
        dtm = confTabela.getDtm();
    }
    
    public void fecharJanelas(){
        dispose();
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCancelCdtModelo;
    private javax.swing.JButton bDeleteCdtVeiculo;
    private javax.swing.JButton bEditCdtModelo;
    private javax.swing.JButton bNewCdtModelo;
    private javax.swing.JButton bRefreshCdtModelo;
    private javax.swing.JButton bSaveCdtModelo;
    private javax.swing.JComboBox cbClasse;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tModelo;
    private javax.swing.JToolBar tbModelo;
    private javax.swing.JTextField tfLayout;
    private javax.swing.JTextField tfMarca;
    private javax.swing.JTextField tfModelo;
    private javax.swing.JTabbedPane tpModelo;
    // End of variables declaration//GEN-END:variables

    public class Campos extends Thread{
        public void run(){
            while(!killThread){
                verificarCampos();
            }
        }
        
        public void verificarCampos(){
            String classe = (String) cbClasse.getSelectedItem();
            int aux = tfModelo.getText().compareTo("");
            aux *= tfLayout.getText().compareTo("");
            aux *= tfMarca.getText().compareTo("");
            aux *= classe.compareTo("");
            if(aux==0){
                bSaveCdtModelo.setEnabled(false);
            }else{
                bSaveCdtModelo.setEnabled(true);
            }
        }
    }

}
