/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heimdall.Forms;

import heimdall.ExecutaSQL;
import heimdall.Util.Componente;
import heimdall.Util.Cor;
import heimdall.Util.Modelo;
import heimdall.Util.Veiculo;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author guilherme
 */
public class JComponente extends javax.swing.JDialog {

    private ArrayList<Modelo> m;
    private DefaultTableModel dtm;
    private int operacao = 0; // 1 = Novo registro; 2 = Atualizar um registro
    private Veiculo veiculo;
    private boolean killThread = false;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
    
    /**
     * Creates new form JComponente
     */
    public JComponente(Veiculo veiculo) {
        setModal(true); //Faz com que o sistema aguarde a conclusão do JDialog para seguir com a execução. 
        this.veiculo = veiculo;
        initComponents();
        initTable();
        new Campos().start();
        liberarCampos(false); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lpIdtComponente = new javax.swing.JLayeredPane();
        jLabel1 = new javax.swing.JLabel();
        tfComponente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tpDescComponente = new javax.swing.JTextPane();
        cbModelo = new javax.swing.JComboBox();
        bCustomModelo = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        tfDataValComponente = new javax.swing.JTextField();
        tfCodigo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tpComponente = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        tfLinhasTabela = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tComponente = new javax.swing.JTable();
        tbVeiculo = new javax.swing.JToolBar();
        bSaveCdtComponente = new javax.swing.JButton();
        bNewCdtComponente = new javax.swing.JButton();
        bEditCdtComponente = new javax.swing.JButton();
        bDeleteCdtComponente = new javax.swing.JButton();
        bRefreshCdtComponente = new javax.swing.JButton();
        bCancelCdtComponente = new javax.swing.JButton();
        tbHelpCdtComponente = new javax.swing.JToggleButton();
        lpCondVeiculo = new javax.swing.JLayeredPane();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tfTagRfid = new javax.swing.JTextField();
        tfDataCdt = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tfNomeVeiculo = new javax.swing.JTextField();
        tfPlacaVeiculo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Cadastrar Componente");

        lpIdtComponente.setBorder(javax.swing.BorderFactory.createTitledBorder("Informações do Componente"));
        lpIdtComponente.setToolTipText("");
        lpIdtComponente.setName(""); // NOI18N
        lpIdtComponente.setPreferredSize(new java.awt.Dimension(400, 200));

        jLabel1.setText("Modelo*:");

        tfComponente.setToolTipText("Escreva o nome do componente. EX: Radiador");

        jLabel2.setText("Descrição: ");

        jLabel3.setText("Nome*:");

        tpDescComponente.setPreferredSize(new java.awt.Dimension(5, 25));
        jScrollPane1.setViewportView(tpDescComponente);

        cbModelo.setModel(new javax.swing.DefaultComboBoxModel(carregarModelos()));
        cbModelo.setToolTipText("Escolha o modelo do veículo");

        bCustomModelo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/heimdall/img/icons 32x32/Customize.png"))); // NOI18N
        bCustomModelo.setToolTipText("Customizar Modelos");
        bCustomModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCustomModeloActionPerformed(evt);
            }
        });

        jLabel4.setText("Data Validade:");

        tfDataValComponente.setToolTipText("Escreva o nome do veiculo. EX: Onibus 05");
        tfDataValComponente.setEnabled(false);

        tfCodigo.setToolTipText("Escreva o nome do veiculo. EX: Onibus 05");

        jLabel5.setText("Código*:");

        lpIdtComponente.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpIdtComponente.setLayer(tfComponente, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpIdtComponente.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpIdtComponente.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpIdtComponente.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpIdtComponente.setLayer(cbModelo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpIdtComponente.setLayer(bCustomModelo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpIdtComponente.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpIdtComponente.setLayer(tfDataValComponente, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpIdtComponente.setLayer(tfCodigo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpIdtComponente.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout lpIdtComponenteLayout = new javax.swing.GroupLayout(lpIdtComponente);
        lpIdtComponente.setLayout(lpIdtComponenteLayout);
        lpIdtComponenteLayout.setHorizontalGroup(
            lpIdtComponenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lpIdtComponenteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(lpIdtComponenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(lpIdtComponenteLayout.createSequentialGroup()
                        .addGroup(lpIdtComponenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(lpIdtComponenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(lpIdtComponenteLayout.createSequentialGroup()
                                .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfComponente, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(lpIdtComponenteLayout.createSequentialGroup()
                                .addComponent(cbModelo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bCustomModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(lpIdtComponenteLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(lpIdtComponenteLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfDataValComponente)))
                .addGap(18, 18, 18))
        );
        lpIdtComponenteLayout.setVerticalGroup(
            lpIdtComponenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lpIdtComponenteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(lpIdtComponenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lpIdtComponenteLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(lpIdtComponenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(bCustomModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(lpIdtComponenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1))))
                    .addGroup(lpIdtComponenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(tfComponente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)))
                .addGap(11, 11, 11)
                .addGroup(lpIdtComponenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfDataValComponente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tfLinhasTabela.setEditable(false);

        jLabel10.setText("Nº");

        tComponente.setAutoCreateRowSorter(true);
        tComponente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Modelo", "Código RFID", "Descrição", "Validade", "Registro"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tComponente.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tComponente.setAutoscrolls(false);
        tComponente.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane7.setViewportView(tComponente);
        if (tComponente.getColumnModel().getColumnCount() > 0) {
            tComponente.getColumnModel().getColumn(0).setPreferredWidth(80);
            tComponente.getColumnModel().getColumn(1).setPreferredWidth(100);
            tComponente.getColumnModel().getColumn(2).setPreferredWidth(100);
            tComponente.getColumnModel().getColumn(3).setPreferredWidth(130);
            tComponente.getColumnModel().getColumn(4).setPreferredWidth(200);
            tComponente.getColumnModel().getColumn(5).setPreferredWidth(150);
            tComponente.getColumnModel().getColumn(6).setPreferredWidth(150);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfLinhasTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 753, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfLinhasTabela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addContainerGap())
        );

        tpComponente.addTab("Componente", jPanel2);

        tbVeiculo.setFloatable(false);
        tbVeiculo.setRollover(true);

        bSaveCdtComponente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/heimdall/img/icons 50x50/save.png"))); // NOI18N
        bSaveCdtComponente.setToolTipText("Salvar Alterações");
        bSaveCdtComponente.setFocusable(false);
        bSaveCdtComponente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bSaveCdtComponente.setPreferredSize(new java.awt.Dimension(50, 50));
        bSaveCdtComponente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bSaveCdtComponente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSaveCdtComponenteActionPerformed(evt);
            }
        });
        tbVeiculo.add(bSaveCdtComponente);

        bNewCdtComponente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/heimdall/img/icons 50x50/new-file.png"))); // NOI18N
        bNewCdtComponente.setToolTipText("Novo Cadastro");
        bNewCdtComponente.setFocusable(false);
        bNewCdtComponente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bNewCdtComponente.setPreferredSize(new java.awt.Dimension(50, 50));
        bNewCdtComponente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bNewCdtComponente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNewCdtComponenteActionPerformed(evt);
            }
        });
        tbVeiculo.add(bNewCdtComponente);

        bEditCdtComponente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/heimdall/img/icons 50x50/TextEdit.png"))); // NOI18N
        bEditCdtComponente.setToolTipText("Editar Cadastro");
        bEditCdtComponente.setFocusable(false);
        bEditCdtComponente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bEditCdtComponente.setPreferredSize(new java.awt.Dimension(50, 50));
        bEditCdtComponente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bEditCdtComponente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEditCdtComponenteActionPerformed(evt);
            }
        });
        tbVeiculo.add(bEditCdtComponente);

        bDeleteCdtComponente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/heimdall/img/icons 50x50/delete.png"))); // NOI18N
        bDeleteCdtComponente.setToolTipText("Deletar Cadastro");
        bDeleteCdtComponente.setFocusable(false);
        bDeleteCdtComponente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bDeleteCdtComponente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tbVeiculo.add(bDeleteCdtComponente);

        bRefreshCdtComponente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/heimdall/img/icons 50x50/refresh.png"))); // NOI18N
        bRefreshCdtComponente.setToolTipText("Atualizar Lista");
        bRefreshCdtComponente.setFocusable(false);
        bRefreshCdtComponente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bRefreshCdtComponente.setPreferredSize(new java.awt.Dimension(50, 50));
        bRefreshCdtComponente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bRefreshCdtComponente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRefreshCdtComponenteActionPerformed(evt);
            }
        });
        tbVeiculo.add(bRefreshCdtComponente);

        bCancelCdtComponente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/heimdall/img/icons 50x50/cancel.png"))); // NOI18N
        bCancelCdtComponente.setFocusable(false);
        bCancelCdtComponente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bCancelCdtComponente.setPreferredSize(new java.awt.Dimension(50, 50));
        bCancelCdtComponente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bCancelCdtComponente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelCdtComponenteActionPerformed(evt);
            }
        });
        tbVeiculo.add(bCancelCdtComponente);

        tbHelpCdtComponente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/heimdall/img/icons 50x50/help.png"))); // NOI18N
        tbHelpCdtComponente.setFocusable(false);
        tbHelpCdtComponente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tbHelpCdtComponente.setPreferredSize(new java.awt.Dimension(50, 50));
        tbHelpCdtComponente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tbVeiculo.add(tbHelpCdtComponente);

        lpCondVeiculo.setBorder(javax.swing.BorderFactory.createTitledBorder("Informações do Cadastro"));

        jLabel7.setText("Tag RFID*:");

        jLabel8.setText("Data Cdt.:");

        tfDataCdt.setEditable(false);
        tfDataCdt.setFocusable(false);
        tfDataCdt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDataCdtActionPerformed(evt);
            }
        });

        lpCondVeiculo.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpCondVeiculo.setLayer(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpCondVeiculo.setLayer(tfTagRfid, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpCondVeiculo.setLayer(tfDataCdt, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout lpCondVeiculoLayout = new javax.swing.GroupLayout(lpCondVeiculo);
        lpCondVeiculo.setLayout(lpCondVeiculoLayout);
        lpCondVeiculoLayout.setHorizontalGroup(
            lpCondVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lpCondVeiculoLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(lpCondVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(24, 24, 24)
                .addGroup(lpCondVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfTagRfid)
                    .addComponent(tfDataCdt, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE))
                .addContainerGap())
        );
        lpCondVeiculoLayout.setVerticalGroup(
            lpCondVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lpCondVeiculoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(lpCondVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tfTagRfid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(lpCondVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tfDataCdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Informações do Veículo"));

        jLabel6.setText("Veículo:");

        jLabel9.setText("Placa:");

        tfNomeVeiculo.setEditable(false);
        tfNomeVeiculo.setText(this.veiculo.toString());

        tfPlacaVeiculo.setEditable(false);
        tfPlacaVeiculo.setText(this.veiculo.getPlaca());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfNomeVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfPlacaVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tfNomeVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(tfPlacaVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tbVeiculo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tpComponente, javax.swing.GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lpIdtComponente, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lpCondVeiculo)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tbVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lpCondVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lpIdtComponente, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(tpComponente)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bNewCdtComponenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNewCdtComponenteActionPerformed
        operacao = 1;
        liberarCampos(true);  
    }//GEN-LAST:event_bNewCdtComponenteActionPerformed

    private void bRefreshCdtComponenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRefreshCdtComponenteActionPerformed

    }//GEN-LAST:event_bRefreshCdtComponenteActionPerformed

    private void bCancelCdtComponenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelCdtComponenteActionPerformed
        int resp = JOptionPane.showConfirmDialog(null,"Você tem certeza que deseja cancelar as alterações feitas?","Tem certeza?",JOptionPane.YES_NO_OPTION);
        if(resp==0){
            sair();
        }
    }//GEN-LAST:event_bCancelCdtComponenteActionPerformed

    private void bEditCdtComponenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEditCdtComponenteActionPerformed
        
    }//GEN-LAST:event_bEditCdtComponenteActionPerformed

    private void tfDataCdtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDataCdtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfDataCdtActionPerformed

    private void bCustomModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCustomModeloActionPerformed
        new JModelo(false).setVisible(true);
        cbModelo.setModel(new javax.swing.DefaultComboBoxModel(carregarModelos()));
    }//GEN-LAST:event_bCustomModeloActionPerformed

    private void bSaveCdtComponenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSaveCdtComponenteActionPerformed
        switch (operacao) {
            case 1:
            cadastrarNovo();
            break;
            case 2:

            break;
        }
    }//GEN-LAST:event_bSaveCdtComponenteActionPerformed

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
            java.util.logging.Logger.getLogger(JComponente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JComponente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JComponente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JComponente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JComponente(new Veiculo()).setVisible(true);
            }
        });
    }
    
    private Modelo[] carregarModelos(){
        ExecutaSQL sql = new ExecutaSQL();
        m = new ArrayList<Modelo>();
        m = sql.SELECT_MODELO_TIPO_CLASSE(false);
        Modelo[] modelos = new Modelo[m.size()+1];
        
        modelos[0] = null;
        for(int i=1; i<=m.size(); i++){
            modelos[i] = m.get(i-1);
        }
        
        return modelos;
    }
    
    private void sair(){
        killThread = true;
        dispose();
    }
    
    
    private void cadastrarNovo(){
        ExecutaSQL sql = new ExecutaSQL();
        Modelo modelo = (Modelo) cbModelo.getSelectedItem();
        
        if(this.veiculo == null){
            new JErro(true, "Este componente não pode ser cadastrado pois não existe um veículo vinculado a ele.", true, false, false);
            sair();
            return;
        }
        
        if(modelo != null){
            Componente componente = new Componente(
                    0,
                    modelo,
                    this.veiculo,
                    Integer.parseInt(tfCodigo.getText()),
                    tfTagRfid.getText().trim(),
                    tfComponente.getText().trim(),
                    tpDescComponente.getText(),
                    new Timestamp(new Date().getTime()),
                    new Timestamp(new Date().getTime())
            );
            
            if(sql.INSERT_COMPONENTE(componente)){
                JOptionPane.showMessageDialog(null,"Cadastrado com sucesso");
                liberarCampos(false);
            }else{
                JOptionPane.showMessageDialog(null,"Falha no cadastrado.");
            }
        }else{
            JOptionPane.showMessageDialog(null,"Escolha o modelo do seu componente");
            return;
        }
        
        initTable();
    }
    
    private void initTable(){
        ExecutaSQL sql = new ExecutaSQL();
        ArrayList<Componente> aux = new ArrayList<Componente>();
        DefaultTableModel dtm = (DefaultTableModel) tComponente.getModel();
        
        while(dtm.getRowCount()>0){
            dtm.removeRow(0);
        }
        
        aux = sql.SELECT_COMPONENTE("veiculo_id_veiculo", Integer.toString(veiculo.getId()));
        for(int i=0; i<aux.size(); i++){
            String registro = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(aux.get(i).getRegistro());
            String validade = new SimpleDateFormat("dd/MM/yyyy").format(aux.get(i).getValidade());
            String modelo = (aux.get(i).getModelo() != null) ? aux.get(i).getModelo().getModelo() : null;
            
            dtm.addRow(new Object[] {
                aux.get(i).getCodigo(),
                aux.get(i).getNome(),
                modelo,
                aux.get(i).getRfid(),                    
                aux.get(i).getDescricao(),
                validade,
                registro}
            );
        }     
        tComponente.setModel(dtm);
        tfLinhasTabela.setText(Integer.toString(dtm.getRowCount()));
    }
    
    private void liberarCampos(boolean b){
        tfCodigo.setText("");
        tfComponente.setText("");
        tfTagRfid.setText("");
        tfDataValComponente.setText("");
        tpDescComponente.setText("");
        cbModelo.setSelectedItem(null);
        
        tfCodigo.setEnabled(b);
        tfComponente.setEnabled(b);
        tfTagRfid.setEnabled(b);
        tfDataValComponente.setEnabled(b);
        tpDescComponente.setEnabled(b);
        cbModelo.setEnabled(b);
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCancelCdtComponente;
    private javax.swing.JButton bCustomModelo;
    private javax.swing.JButton bDeleteCdtComponente;
    private javax.swing.JButton bEditCdtComponente;
    private javax.swing.JButton bNewCdtComponente;
    private javax.swing.JButton bRefreshCdtComponente;
    private javax.swing.JButton bSaveCdtComponente;
    private javax.swing.JComboBox cbModelo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JLayeredPane lpCondVeiculo;
    private javax.swing.JLayeredPane lpIdtComponente;
    private javax.swing.JTable tComponente;
    private javax.swing.JToggleButton tbHelpCdtComponente;
    private javax.swing.JToolBar tbVeiculo;
    private javax.swing.JTextField tfCodigo;
    private javax.swing.JTextField tfComponente;
    private javax.swing.JTextField tfDataCdt;
    private javax.swing.JTextField tfDataValComponente;
    private javax.swing.JTextField tfLinhasTabela;
    private javax.swing.JTextField tfNomeVeiculo;
    private javax.swing.JTextField tfPlacaVeiculo;
    private javax.swing.JTextField tfTagRfid;
    private javax.swing.JTabbedPane tpComponente;
    private javax.swing.JTextPane tpDescComponente;
    // End of variables declaration//GEN-END:variables

    public class Campos extends Thread{
        public void run(){
            while(!killThread){
                verificarCampos();
                try{
                    tfDataCdt.setText(sdf.format(new Date()));                    
                }catch(Exception ex){
                    new JErro(true, ex.getMessage(), true, true, false);
                }
            }
        }
        
        public void verificarCampos(){
            Modelo modelo = (Modelo) cbModelo.getSelectedItem();
            
            int aux = tfNomeVeiculo.getText().compareTo("");
            aux *= tfTagRfid.getText().compareTo("");
            aux *= tfCodigo.getText().compareTo("");
            if(aux==0 || modelo==null){
                bSaveCdtComponente.setEnabled(false);
            }else{
                bSaveCdtComponente.setEnabled(true);
            }
        }
    }
}
