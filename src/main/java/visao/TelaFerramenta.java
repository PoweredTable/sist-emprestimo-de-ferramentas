package visao;

import java.awt.*;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import modelo.Ferramenta;
import controle.FerramentaControle;
import dao.ExceptionDAO;
import visao.swingcomponents.PlaceholderTextField;

/**
 * Exibe tela de ferramentas e seus respectivos relatórios.
 */
public class TelaFerramenta extends javax.swing.JFrame {
    
    private DialogFerramenta dialog;
    private DialogConfirmarExclusao dialogEx;

    public TelaFerramenta() {
        setLocationRelativeTo(null);
        this.dialog = new DialogFerramenta(this, true);
        this.dialogEx = new DialogConfirmarExclusao(this, true);
        initComponents();
        initCustomComponents();

        //Espera a dialog fechar para atualizar a tabela de ferramentas
        dialog.addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent e) {
                carregaTabelaFerramentas();
            }
        });
        //Espera a dialog fechar para efetuar a exclusão de uma ferramenta
        dialogEx.addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent e) {
                if (dialogEx.getConfirmarExclusaoF()){
                    excluirFerramenta();
                    carregaTabelaFerramentas();
                    apresentaPrecoTotal();
                    apresentaTotalFerramentas();
                }
            }
        });
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BG = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jButtonPesquisar = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jButtonCadastrar = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableFerramentas = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabelPrecoTotal = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabelQuantidadeFerramentas = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jButtonVoltar = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jButtonEditar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1280, 900));
        setPreferredSize(new java.awt.Dimension(1280, 900));

        BG.setBackground(new java.awt.Color(64, 64, 64));

        jPanel2.setBackground(new java.awt.Color(64, 64, 64));
        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        jLabel1.setBackground(new java.awt.Color(46, 46, 46));
        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 187, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ferramentas");
        jPanel2.add(jLabel1);

        jPanel5.setBackground(new java.awt.Color(64, 64, 64));

        jPanel3.setBackground(new java.awt.Color(64, 64, 64));
        jPanel3.setLayout(new java.awt.GridLayout(1, 2, 20, 0));

        UIManager.put("ToolTip.background", new Color(0x565656)); // c8
        UIManager.put("ToolTip.foreground", new Color(0xFFBB00)); // p1
        UIManager.put("ToolTip.font", new Font("Arial Black", Font.BOLD, 14));
        UIManager.put("ToolTip.border", BorderFactory.createLineBorder(new Color(0x565656), 2));

        jPanel4.setBackground(new java.awt.Color(64, 64, 64));
        jPanel4.setLayout(new java.awt.GridLayout(1, 0, 20, 0));

        jButtonPesquisar.setBackground(new java.awt.Color(156, 156, 156));
        jButtonPesquisar.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jButtonPesquisar.setForeground(new java.awt.Color(64, 64, 64));
        jButtonPesquisar.setText("Pesquisar");
        jButtonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarActionPerformed(evt);
            }
        });
        jPanel4.add(jButtonPesquisar);

        jPanel7.setBackground(new java.awt.Color(64, 64, 64));
        jPanel7.setLayout(new java.awt.GridLayout(1, 0, 20, 0));

        jPanel6.setBackground(new java.awt.Color(64, 64, 64));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 173, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 46, Short.MAX_VALUE)
        );

        jPanel7.add(jPanel6);

        jPanel8.setBackground(new java.awt.Color(64, 64, 64));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 173, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 46, Short.MAX_VALUE)
        );

        jPanel7.add(jPanel8);

        jButtonCadastrar.setBackground(new java.awt.Color(255, 187, 0));
        jButtonCadastrar.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jButtonCadastrar.setForeground(new java.awt.Color(64, 64, 64));
        jButtonCadastrar.setText("Cadastrar");
        jButtonCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarActionPerformed(evt);
            }
        });
        jPanel7.add(jButtonCadastrar);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(621, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 54, Short.MAX_VALUE))
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
                    .addContainerGap()))
        );

        jPanel9.setBackground(new java.awt.Color(156, 156, 156));

        jTableFerramentas.setBackground(new java.awt.Color(255, 255, 255));
        jTableFerramentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Marca", "Preço"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableFerramentas.setSelectionBackground(new java.awt.Color(197, 131, 0));
        jTableFerramentas.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jTableFerramentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableFerramentasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableFerramentas);

        jPanel1.setBackground(new java.awt.Color(156, 156, 156));

        jLabel4.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel4.setText("Valor total gasto:");

        jLabelPrecoTotal.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabelPrecoTotal.setForeground(new java.awt.Color(255, 187, 0));
        jLabelPrecoTotal.setText("-");

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel2.setText("Quantidade total:");

        jLabelQuantidadeFerramentas.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabelQuantidadeFerramentas.setForeground(new java.awt.Color(255, 187, 0));
        jLabelQuantidadeFerramentas.setText("-");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelQuantidadeFerramentas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelPrecoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelQuantidadeFerramentas))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jLabelPrecoTotal)))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1256, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel10.setBackground(new java.awt.Color(64, 64, 64));
        jPanel10.setMaximumSize(new java.awt.Dimension(100, 100));
        jPanel10.setPreferredSize(new java.awt.Dimension(1280, 900));

        jPanel11.setBackground(new java.awt.Color(64, 64, 64));
        jPanel11.setLayout(new java.awt.GridLayout(1, 0));

        jButtonVoltar.setBackground(new java.awt.Color(156, 156, 156));
        jButtonVoltar.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jButtonVoltar.setForeground(new java.awt.Color(64, 64, 64));
        jButtonVoltar.setText("Voltar");
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });
        jPanel11.add(jButtonVoltar);

        jPanel12.setBackground(new java.awt.Color(64, 64, 64));
        jPanel12.setLayout(new java.awt.GridLayout(1, 0, 20, 0));

        jButtonEditar.setBackground(new java.awt.Color(156, 156, 156));
        jButtonEditar.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jButtonEditar.setForeground(new java.awt.Color(64, 64, 64));
        jButtonEditar.setText("Editar");
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });
        jPanel12.add(jButtonEditar);

        jButtonExcluir.setBackground(new java.awt.Color(156, 156, 156));
        jButtonExcluir.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jButtonExcluir.setForeground(new java.awt.Color(64, 64, 64));
        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });
        jPanel12.add(jButtonExcluir);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout BGLayout = new javax.swing.GroupLayout(BG);
        BG.setLayout(BGLayout);
        BGLayout.setHorizontalGroup(
            BGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(BGLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, 1268, Short.MAX_VALUE))
                .addContainerGap())
        );
        BGLayout.setVerticalGroup(
            BGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BGLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void initCustomComponents(){
        jTextFieldPesquisar = new PlaceholderTextField("");;
        
        jTextFieldPesquisar.setBackground(new java.awt.Color(156, 156, 156));
        jTextFieldPesquisar.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jTextFieldPesquisar.setForeground(new java.awt.Color(64, 64, 64));
        jTextFieldPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPesquisarActionPerformed(evt);
            }
        });
        jPanel3.add(jTextFieldPesquisar);
        jTextFieldPesquisar.setPlaceholder("Pesquisar nome");
    }    
    
     private void jTextFieldPesquisarActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        // TODO add your handling code here:
    }         
    
    private void jButtonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarActionPerformed
        // TODO add your handling code here:
        dialog.setTitleDialog("Cadastro");
        dialog.setSalvarButtonSalvar("Salvar");
        dialog.setNome("");
        dialog.setMarca("");
        dialog.setPreco("");
        dialog.setVisible(true);
        apresentaPrecoTotal();
        apresentaTotalFerramentas();
    }//GEN-LAST:event_jButtonCadastrarActionPerformed

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
        // TODO add your handling code here:
        this.dispose();

    }//GEN-LAST:event_jButtonVoltarActionPerformed
    
    public void apresentaTotalFerramentas(){
        try {
            String quantidadeFerramentas = String.valueOf(FerramentaControle.quantidadeFerramentas());
            jLabelQuantidadeFerramentas.setText(quantidadeFerramentas);
        } catch (ExceptionDAO e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void apresentaPrecoTotal(){
        try {
            String precoTotal = String.valueOf(FerramentaControle.getCustoTotal());
            jLabelPrecoTotal.setText(precoTotal);
            jLabelPrecoTotal.setToolTipText(precoTotal);
        } catch (ExceptionDAO e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void carregaTabelaFerramentas() {
        DefaultTableModel modelo = (DefaultTableModel) this.jTableFerramentas.getModel();

        modelo.setNumRows(0); //Posiciona na primeira linha da tabela
        //Carrega a lista de objetos aluno
        //TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modelo);
        //jTable1Amigos.setRowSorter(sorter);
        try {
            ArrayList<Ferramenta> lista = FerramentaControle.buscarTudo();

            Collections.sort(lista, new Comparator<Ferramenta>() {
                @Override
                public int compare(Ferramenta a1, Ferramenta a2) {
                    return Long.compare(a1.getId(), a2.getId());
                }
            });

            for (Ferramenta f : lista) {
                modelo.addRow(new Object[]{
                    f.getId(),
                    f.getNome(),
                    f.getMarca(),
                    f.getPreco()
                });
            }
        } catch (ExceptionDAO e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void carregaTabelaFiltrada() {
        DefaultTableModel modelo = (DefaultTableModel) this.jTableFerramentas.getModel();

        modelo.setNumRows(0); //Posiciona na primeira linha da tabela

        try {
            String nome = jTextFieldPesquisar.getText();
            ArrayList<Ferramenta> lista = FerramentaControle.buscarNome(nome);

            for (Ferramenta f : lista) {
                modelo.addRow(new Object[]{
                    f.getId(),
                    f.getNome(),
                    f.getMarca(),
                    f.getPreco()
                });
            }
        } catch (ExceptionDAO e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
    public void excluirFerramenta() {
        int id = dialog.getId();
        try {
            FerramentaControle.excluir(id);
            apresentaTotalFerramentas();
            apresentaPrecoTotal();

        } catch (ExceptionDAO e) {
            JOptionPane.showMessageDialog(null, e);
        }
        dialogEx.setConfirmarExclusaoF(false);
    }
    
    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        // TODO add your handling code here:
        dialog.setTitleDialog("Editar");
        dialog.setSalvarButtonSalvar("Editar");

    // Preencher os campos com as informações da ferramenta a ser editada
        String nomeFerramenta = dialog.getNome(); // Substitua isso com o nome da ferramenta que você deseja editar
        String marcaFerramenta = dialog.getMarca(); // Substitua isso com a descrição da ferramenta que você deseja editar
        String precoFerramenta = dialog.getPreco(); // Substitua isso com a categoria da ferramenta que você deseja editar

        dialog.setNome(nomeFerramenta);
        dialog.setMarca(marcaFerramenta);
        dialog.setPreco(precoFerramenta);
        dialog.setVisible(true);
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jTableFerramentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableFerramentasMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 1) { // Verifica se o clique foi único
            int index = jTableFerramentas.getSelectedRow();
            if (index != -1) { // Verifica se uma linha está selecionada
                int id = Integer.parseInt(jTableFerramentas.getValueAt(index, 0).toString());
                String nome = jTableFerramentas.getValueAt(index, 1).toString();
                String marca = jTableFerramentas.getValueAt(index, 2).toString();
                String preco = jTableFerramentas.getValueAt(index, 3).toString();

                dialog.setId(id);
                dialog.setNome(nome);
                dialog.setMarca(marca);
                dialog.setPreco(preco);

            }
        }
    }//GEN-LAST:event_jTableFerramentasMouseClicked

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        // TODO add your handling code here:
        dialogEx.setVisible(true);

    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
        // TODO add your handling code here:
        if (jTextFieldPesquisar.getText().equals("")) {
            carregaTabelaFerramentas();
        } else {
                carregaTabelaFiltrada();
        }
    }//GEN-LAST:event_jButtonPesquisarActionPerformed

    public static void main(String args[]) {



        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaFerramenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BG;
    private javax.swing.JButton jButtonCadastrar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelPrecoTotal;
    private javax.swing.JLabel jLabelQuantidadeFerramentas;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableFerramentas;
    // End of variables declaration//GEN-END:variables
    private PlaceholderTextField jTextFieldPesquisar;
}