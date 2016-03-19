/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package heimdall.Forms;

import heimdall.ExecutaSQL;
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
public class JVeiculo extends javax.swing.JDialog {

    /**
     * Creates new form JVeiculo
     */
    
    private ArrayList<Modelo> m;
    private ArrayList<Cor> cor;
    private int operacao = 0; // 1 = Novo registro; 2 = Atualizar um registro
    private boolean killThread = false;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
    
    public JVeiculo() {
        setModal(true); //Faz com que o sistema aguarde a conclusão do JDialog para seguir com a execução. 
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

        lpIdtVeiculo = new javax.swing.JLayeredPane();
        jLabel1 = new javax.swing.JLabel();
        tfVeiculo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tpObs = new javax.swing.JTextPane();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfPlaca = new javax.swing.JTextField();
        cbCor = new javax.swing.JComboBox();
        cbModelo = new javax.swing.JComboBox();
        bCustomModelo = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        tfKm = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tfCodigo = new javax.swing.JTextField();
        lpCondVeiculo = new javax.swing.JLayeredPane();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tfTagRfid = new javax.swing.JTextField();
        tfDataCdt = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        tbVeiculo = new javax.swing.JToolBar();
        bSaveCdtVeiculo = new javax.swing.JButton();
        bNewCdtVeiculo = new javax.swing.JButton();
        bEditCdtVeiculo = new javax.swing.JButton();
        bDeleteCdtVeiculo = new javax.swing.JButton();
        bRefreshCdtVeiculo = new javax.swing.JButton();
        bCancelCdtVeiculo = new javax.swing.JButton();
        tbHelpCdtVeiculo = new javax.swing.JToggleButton();
        tpVeiculo = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        tfLinhasTabela = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tVeiculo = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Cadastrar Veículo");
        setResizable(false);

        lpIdtVeiculo.setBorder(javax.swing.BorderFactory.createTitledBorder("Informações do Veículo"));
        lpIdtVeiculo.setToolTipText("");
        lpIdtVeiculo.setName(""); // NOI18N
        lpIdtVeiculo.setPreferredSize(new java.awt.Dimension(400, 200));

        jLabel1.setText("Modelo*:");

        tfVeiculo.setToolTipText("Escreva o nome do veiculo. EX: Onibus 05");

        jLabel2.setText("Observação: ");

        jLabel3.setText("Veículo*:");

        tpObs.setPreferredSize(new java.awt.Dimension(5, 25));
        jScrollPane1.setViewportView(tpObs);

        jLabel5.setText("Placa*:");

        jLabel6.setText("Cor:");

        tfPlaca.setColumns(5);
        tfPlaca.setToolTipText("Número da placa. EX: ABC-1234");
        tfPlaca.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        cbCor.setModel(new javax.swing.DefaultComboBoxModel(carregarCores()));
        cbCor.setToolTipText("Escolha a cor do veículo");
        cbCor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCorActionPerformed(evt);
            }
        });

        cbModelo.setModel(new javax.swing.DefaultComboBoxModel(carregarModelos()));
        cbModelo.setToolTipText("Escolha o modelo do veículo");

        bCustomModelo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/heimdall/img/icons 32x32/Customize.png"))); // NOI18N
        bCustomModelo.setToolTipText("Customizar Modelos");
        bCustomModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCustomModeloActionPerformed(evt);
            }
        });

        jLabel4.setText("Quilometragem:");

        jLabel10.setText("Código*:");

        lpIdtVeiculo.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpIdtVeiculo.setLayer(tfVeiculo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpIdtVeiculo.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpIdtVeiculo.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpIdtVeiculo.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpIdtVeiculo.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpIdtVeiculo.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpIdtVeiculo.setLayer(tfPlaca, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpIdtVeiculo.setLayer(cbCor, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpIdtVeiculo.setLayer(cbModelo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpIdtVeiculo.setLayer(bCustomModelo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpIdtVeiculo.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpIdtVeiculo.setLayer(tfKm, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpIdtVeiculo.setLayer(jLabel10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpIdtVeiculo.setLayer(tfCodigo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout lpIdtVeiculoLayout = new javax.swing.GroupLayout(lpIdtVeiculo);
        lpIdtVeiculo.setLayout(lpIdtVeiculoLayout);
        lpIdtVeiculoLayout.setHorizontalGroup(
            lpIdtVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lpIdtVeiculoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(lpIdtVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jLabel2)
                    .addGroup(lpIdtVeiculoLayout.createSequentialGroup()
                        .addGroup(lpIdtVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(lpIdtVeiculoLayout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel6))
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10))
                        .addGap(3, 3, 3)
                        .addGroup(lpIdtVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(lpIdtVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cbCor, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tfPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addGroup(lpIdtVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(lpIdtVeiculoLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfKm, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(lpIdtVeiculoLayout.createSequentialGroup()
                                .addGroup(lpIdtVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(lpIdtVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(lpIdtVeiculoLayout.createSequentialGroup()
                                        .addComponent(cbModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(4, 4, 4)
                                        .addComponent(bCustomModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(tfVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        lpIdtVeiculoLayout.setVerticalGroup(
            lpIdtVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lpIdtVeiculoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(lpIdtVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel10)
                    .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(lpIdtVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bCustomModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(lpIdtVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel5)
                        .addComponent(tfPlaca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(lpIdtVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(tfKm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                .addContainerGap())
        );

        lpCondVeiculo.setBorder(javax.swing.BorderFactory.createTitledBorder("Informações do Cadastro"));

        jLabel7.setText("Tag RFID:");

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
                .addGap(22, 22, 22)
                .addGroup(lpCondVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
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

        jTextPane1.setEditable(false);
        jScrollPane2.setViewportView(jTextPane1);

        tbVeiculo.setFloatable(false);
        tbVeiculo.setRollover(true);

        bSaveCdtVeiculo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/heimdall/img/icons 50x50/save.png"))); // NOI18N
        bSaveCdtVeiculo.setToolTipText("Salvar Alterações");
        bSaveCdtVeiculo.setFocusable(false);
        bSaveCdtVeiculo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bSaveCdtVeiculo.setPreferredSize(new java.awt.Dimension(50, 50));
        bSaveCdtVeiculo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bSaveCdtVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSaveCdtVeiculoActionPerformed(evt);
            }
        });
        tbVeiculo.add(bSaveCdtVeiculo);

        bNewCdtVeiculo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/heimdall/img/icons 50x50/new-file.png"))); // NOI18N
        bNewCdtVeiculo.setToolTipText("Novo Cadastro");
        bNewCdtVeiculo.setFocusable(false);
        bNewCdtVeiculo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bNewCdtVeiculo.setPreferredSize(new java.awt.Dimension(50, 50));
        bNewCdtVeiculo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bNewCdtVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNewCdtVeiculoActionPerformed(evt);
            }
        });
        tbVeiculo.add(bNewCdtVeiculo);

        bEditCdtVeiculo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/heimdall/img/icons 50x50/TextEdit.png"))); // NOI18N
        bEditCdtVeiculo.setToolTipText("Editar Cadastro");
        bEditCdtVeiculo.setFocusable(false);
        bEditCdtVeiculo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bEditCdtVeiculo.setPreferredSize(new java.awt.Dimension(50, 50));
        bEditCdtVeiculo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bEditCdtVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEditCdtVeiculoActionPerformed(evt);
            }
        });
        tbVeiculo.add(bEditCdtVeiculo);

        bDeleteCdtVeiculo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/heimdall/img/icons 50x50/delete.png"))); // NOI18N
        bDeleteCdtVeiculo.setToolTipText("Deletar Cadastro");
        bDeleteCdtVeiculo.setFocusable(false);
        bDeleteCdtVeiculo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bDeleteCdtVeiculo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tbVeiculo.add(bDeleteCdtVeiculo);

        bRefreshCdtVeiculo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/heimdall/img/icons 50x50/refresh.png"))); // NOI18N
        bRefreshCdtVeiculo.setToolTipText("Atualizar Lista");
        bRefreshCdtVeiculo.setFocusable(false);
        bRefreshCdtVeiculo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bRefreshCdtVeiculo.setPreferredSize(new java.awt.Dimension(50, 50));
        bRefreshCdtVeiculo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bRefreshCdtVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRefreshCdtVeiculoActionPerformed(evt);
            }
        });
        tbVeiculo.add(bRefreshCdtVeiculo);

        bCancelCdtVeiculo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/heimdall/img/icons 50x50/cancel.png"))); // NOI18N
        bCancelCdtVeiculo.setFocusable(false);
        bCancelCdtVeiculo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bCancelCdtVeiculo.setPreferredSize(new java.awt.Dimension(50, 50));
        bCancelCdtVeiculo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bCancelCdtVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelCdtVeiculoActionPerformed(evt);
            }
        });
        tbVeiculo.add(bCancelCdtVeiculo);

        tbHelpCdtVeiculo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/heimdall/img/icons 50x50/help.png"))); // NOI18N
        tbHelpCdtVeiculo.setFocusable(false);
        tbHelpCdtVeiculo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tbHelpCdtVeiculo.setPreferredSize(new java.awt.Dimension(50, 50));
        tbHelpCdtVeiculo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tbVeiculo.add(tbHelpCdtVeiculo);

        tfLinhasTabela.setEditable(false);

        jLabel9.setText("Nº");

        tVeiculo.setAutoCreateRowSorter(true);
        tVeiculo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Modelo", "Placa", "Cor", "Código RFID", "Km", "Registro"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tVeiculo.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tVeiculo.setAutoscrolls(false);
        tVeiculo.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane7.setViewportView(tVeiculo);
        if (tVeiculo.getColumnModel().getColumnCount() > 0) {
            tVeiculo.getColumnModel().getColumn(0).setPreferredWidth(100);
            tVeiculo.getColumnModel().getColumn(1).setPreferredWidth(100);
            tVeiculo.getColumnModel().getColumn(2).setPreferredWidth(100);
            tVeiculo.getColumnModel().getColumn(3).setPreferredWidth(100);
            tVeiculo.getColumnModel().getColumn(4).setPreferredWidth(100);
            tVeiculo.getColumnModel().getColumn(5).setPreferredWidth(130);
            tVeiculo.getColumnModel().getColumn(6).setPreferredWidth(100);
            tVeiculo.getColumnModel().getColumn(7).setPreferredWidth(150);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(713, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfLinhasTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 785, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 162, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfLinhasTabela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 32, Short.MAX_VALUE)))
        );

        tpVeiculo.addTab("Veículos", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tbVeiculo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tpVeiculo)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lpIdtVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 474, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lpCondVeiculo)
                            .addComponent(jScrollPane2))
                        .addGap(18, 18, 18))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tbVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lpIdtVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lpCondVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tpVeiculo)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(816, 581));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bCustomModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCustomModeloActionPerformed
        new JModelo(true).setVisible(true);
        cbModelo.setModel(new javax.swing.DefaultComboBoxModel(carregarModelos()));
    }//GEN-LAST:event_bCustomModeloActionPerformed

    private void bCancelCdtVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelCdtVeiculoActionPerformed
        int resp = JOptionPane.showConfirmDialog(null,"Você tem certeza que deseja cancelar as alterações feitas?","Tem certeza?",JOptionPane.YES_NO_OPTION);
        if(resp==0){
            sair();
        }
    }//GEN-LAST:event_bCancelCdtVeiculoActionPerformed

    private void tfDataCdtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDataCdtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfDataCdtActionPerformed

    private void bNewCdtVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNewCdtVeiculoActionPerformed
        operacao = 1;
        liberarCampos(true);        
    }//GEN-LAST:event_bNewCdtVeiculoActionPerformed

    private void bRefreshCdtVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRefreshCdtVeiculoActionPerformed
        
    }//GEN-LAST:event_bRefreshCdtVeiculoActionPerformed

    private void bSaveCdtVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSaveCdtVeiculoActionPerformed
        switch (operacao) {
            case 1:
                cadastrarNovo();
                break;
            case 2:
                
                break;
        }
    }//GEN-LAST:event_bSaveCdtVeiculoActionPerformed

    private void bEditCdtVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEditCdtVeiculoActionPerformed
        new JErro(true, "Mensagem de teste da janela de erro", false, true, false);
    }//GEN-LAST:event_bEditCdtVeiculoActionPerformed

    private void cbCorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCorActionPerformed

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
            java.util.logging.Logger.getLogger(JVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JVeiculo().setVisible(true);
            }
        });
    }
    
    private Modelo[] carregarModelos(){
        ExecutaSQL sql = new ExecutaSQL();
        m = new ArrayList<Modelo>();
        m = sql.SELECT_ALL_MODELO_VEICULO();
        Modelo[] modelos = new Modelo[m.size()+1];
        
        modelos[0] = null;
        for(int i=1; i<=m.size(); i++){
            modelos[i] = m.get(i-1);
        }
        
        return modelos;
    }
    
    private Cor[] carregarCores(){
        ExecutaSQL sql = new ExecutaSQL();
        cor = new ArrayList<Cor>();
        cor = sql.SELECT_ALL_COR();
        Cor[] cores = new Cor[cor.size()+1];
        
        cores[0] = null;
        for(int i=1; i<=cor.size(); i++){
            cores[i] = cor.get(i-1);
        }
        
        return cores;
    }
    
    private void sair(){
        killThread = true;
        dispose();
    }
    
    private void cadastrarNovo(){
        ExecutaSQL sql = new ExecutaSQL();
        Veiculo veiculo = new Veiculo();
        Modelo modelo = (Modelo) cbModelo.getSelectedItem();
        Cor cor = (Cor) cbCor.getSelectedItem();
        Float km = (tfKm.getText().compareTo("")==0) ? null : Float.parseFloat(tfKm.getText());
        
        if(modelo != null){
            veiculo.setModelo(modelo);
            veiculo.setCor(cor);
            veiculo.setNome(tfVeiculo.getText());
            veiculo.setPlaca(tfPlaca.getText());
            if(km != null)
                veiculo.setKm(km);
            veiculo.setObservacao(tpObs.getText());
            veiculo.setRfid(tfTagRfid.getText());
            veiculo.setRegistro(new Timestamp(new Date().getTime()));
            
            if(!sql.INSERT_VEICULO(veiculo)){
                JOptionPane.showMessageDialog(null,"Cadastrado com sucesso");
                liberarCampos(false);
            }else{
                JOptionPane.showMessageDialog(null,"Falha no cadastrado.");
            }
        }else{
            JOptionPane.showMessageDialog(null,"Escolha o modelo do seu veículo");
            return;
        }
        
        initTable();
    }
    
    private void initTable(){
        ExecutaSQL sql = new ExecutaSQL();
        ArrayList<Veiculo> aux = new ArrayList<Veiculo>();
        DefaultTableModel dtm = (DefaultTableModel) tVeiculo.getModel();
        
        while(dtm.getRowCount()>0){
            dtm.removeRow(0);
        }
        
        aux = sql.SELECT_ALL_VEICULO();
        for(int i=0; i<aux.size(); i++){
            String registro = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(aux.get(i).getRegistro());
            String cor = (aux.get(i).getCor() != null) ? aux.get(i).getCor().getCor() : null;
            String modelo = (aux.get(i).getModelo() != null) ? aux.get(i).getModelo().getModelo() : null;
            
            dtm.addRow(new Object[] {
                aux.get(i).getCodigo(),
                aux.get(i).getNome(),
                modelo,
                aux.get(i).getPlaca(),
                cor,
                aux.get(i).getRfid(),                    
                aux.get(i).getKm(),
                registro}
            );
        }     
        tVeiculo.setModel(dtm);
        tfLinhasTabela.setText(Integer.toString(dtm.getRowCount()));
    }
    
    private void liberarCampos(boolean b){
        tfCodigo.setText("");
        tfVeiculo.setText("");
        tfPlaca.setText("");
        tfTagRfid.setText("");
        tfKm.setText("");
        tpObs.setText("");
        cbModelo.setSelectedItem(null);
        cbCor.setSelectedItem(null);
        
        tfCodigo.setEnabled(b);
        tfVeiculo.setEnabled(b);
        tfPlaca.setEnabled(b);
        tfTagRfid.setEnabled(b);
        tfKm.setEnabled(b);
        tpObs.setEnabled(b);
        cbModelo.setEnabled(b);
        cbCor.setEnabled(b);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCancelCdtVeiculo;
    private javax.swing.JButton bCustomModelo;
    private javax.swing.JButton bDeleteCdtVeiculo;
    private javax.swing.JButton bEditCdtVeiculo;
    private javax.swing.JButton bNewCdtVeiculo;
    private javax.swing.JButton bRefreshCdtVeiculo;
    private javax.swing.JButton bSaveCdtVeiculo;
    private javax.swing.JComboBox cbCor;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JLayeredPane lpCondVeiculo;
    private javax.swing.JLayeredPane lpIdtVeiculo;
    private javax.swing.JTable tVeiculo;
    private javax.swing.JToggleButton tbHelpCdtVeiculo;
    private javax.swing.JToolBar tbVeiculo;
    private javax.swing.JTextField tfCodigo;
    private javax.swing.JTextField tfDataCdt;
    private javax.swing.JTextField tfKm;
    private javax.swing.JTextField tfLinhasTabela;
    private javax.swing.JTextField tfPlaca;
    private javax.swing.JTextField tfTagRfid;
    private javax.swing.JTextField tfVeiculo;
    private javax.swing.JTextPane tpObs;
    private javax.swing.JTabbedPane tpVeiculo;
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
            Cor cor = (Cor) cbCor.getSelectedItem();
            int aux = tfVeiculo.getText().compareTo("");
            aux *= tfPlaca.getText().compareTo("");
            aux *= tfCodigo.getText().compareTo("");
            if(aux==0 || modelo==null || !tfPlaca.getText().matches("[a-zA-Z]{3,3}-\\d{4,4}")){
                bSaveCdtVeiculo.setEnabled(false);
            }else{
                bSaveCdtVeiculo.setEnabled(true);
            }
        }
    }

}
