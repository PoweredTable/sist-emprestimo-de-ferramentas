package visao;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import controle.FerramentaControle;
import controle.EmprestimoControle;
import controle.AmigoControle;
import modelo.Emprestimo;
import dao.ExceptionDAO;

/**
 * Exibe tela principal, seus respectivos relatórios, sua tabela de controle e filtro de empréstimos.
 */
public class TelaPrincipal extends javax.swing.JFrame {

    private JTable tabelaAtiva;

    private void setTabelaAtiva(JTable tabela) {
        this.tabelaAtiva = tabela;
    }

    public TelaPrincipal() {
        initComponents();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                carregaTabelaTodos();
                try {
                    atualizarLabelQuantidadeDeEmprestimos();
                    atualizarLabelQuantidadeDeFerramentas();
                    atualizarLabelQuantidadeDeAmigos();
                } catch (ExceptionDAO ex) {
                    Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BG = new javax.swing.JPanel();
        jContainerPrincipal = new javax.swing.JPanel();
        jBExcluir = new javax.swing.JButton();
        jBConfirmar = new javax.swing.JButton();
        jBotoes = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jBFerramentas = new javax.swing.JButton();
        jBAmigos = new javax.swing.JButton();
        jTabbedDash = new javax.swing.JTabbedPane();
        jAbaTodos = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableTodos = new javax.swing.JTable();
        jAbaEmDia = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableEmDia = new javax.swing.JTable();
        jAbaAtrasados = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableAtrasados = new javax.swing.JTable();
        jAbaAtivos = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableAtivos = new javax.swing.JTable();
        jContaienrInformativos = new javax.swing.JPanel();
        jPEmprestimos = new javax.swing.JPanel();
        jLEmprestimos = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPFerramentas = new javax.swing.JPanel();
        jLFerramentas = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPAmigos = new javax.swing.JPanel();
        jLAmigos = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Relatório de Empréstimos");
        setBackground(java.awt.Color.white);
        setLocation(new java.awt.Point(0, 0));
        setMinimumSize(new java.awt.Dimension(1000, 800));
        setMaximumSize(new java.awt.Dimension(1000, 800));
        setMinimumSize(new java.awt.Dimension(1000, 900));
        setPreferredSize(new java.awt.Dimension(1280, 900));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        BG.setBackground(new java.awt.Color(46, 46, 46));
        BG.setPreferredSize(new java.awt.Dimension(1000, 800));
        BG.setRequestFocusEnabled(false);
        BG.setVerifyInputWhenFocusTarget(false);

        jContainerPrincipal.setBackground(new java.awt.Color(46, 46, 46));
        jContainerPrincipal.setMaximumSize(new java.awt.Dimension(332767, 332767));

        jBExcluir.setBackground(new java.awt.Color(46, 46, 46));
        jBExcluir.setFont(new java.awt.Font("Fira Sans", 1, 14)); // NOI18N
        jBExcluir.setForeground(new java.awt.Color(229, 164, 11));
        jBExcluir.setText("Excluir");
        jBExcluir.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(115, 115, 115), 2, true));
        jBExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBExcluirActionPerformed(evt);
            }
        });

        jBConfirmar.setBackground(new java.awt.Color(46, 46, 46));
        jBConfirmar.setFont(new java.awt.Font("Fira Sans", 1, 14)); // NOI18N
        jBConfirmar.setForeground(new java.awt.Color(229, 164, 11));
        jBConfirmar.setText("Confirmar");
        jBConfirmar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(115, 115, 115), 2, true));
        jBConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBConfirmarActionPerformed(evt);
            }
        });

        jBotoes.setBackground(new java.awt.Color(46, 46, 46));
        jBotoes.setForeground(new java.awt.Color(194, 194, 194));
        jBotoes.setLayout(new java.awt.GridLayout(3, 3, 0, 50));

        jButton1.setBackground(new java.awt.Color(46, 46, 46));
        jButton1.setFont(new java.awt.Font("Fira Sans", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(229, 164, 11));
        jButton1.setText("<html><center>"+"Adicionar"+"<br>"+"empréstimo"+"</center></html>");
        jButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(115, 115, 115), 2, true));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jBotoes.add(jButton1);

        jBFerramentas.setBackground(new java.awt.Color(46, 46, 46));
        jBFerramentas.setFont(new java.awt.Font("Fira Sans", 1, 14)); // NOI18N
        jBFerramentas.setForeground(new java.awt.Color(229, 164, 11));
        jBFerramentas.setText("Ferramentas");
        jBFerramentas.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(115, 115, 115), 2, true));
        jBFerramentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBFerramentasActionPerformed(evt);
            }
        });
        jBotoes.add(jBFerramentas);

        jBAmigos.setBackground(new java.awt.Color(46, 46, 46));
        jBAmigos.setFont(new java.awt.Font("Fira Sans", 1, 14)); // NOI18N
        jBAmigos.setForeground(new java.awt.Color(229, 164, 11));
        jBAmigos.setText("Amigos");
        jBAmigos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(115, 115, 115), 2, true));
        jBAmigos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAmigosActionPerformed(evt);
            }
        });
        jBotoes.add(jBAmigos);

        jTabbedDash.setForeground(new java.awt.Color(229, 164, 11));
        jTabbedDash.setFont(new java.awt.Font("Fira Sans", 1, 14)); // NOI18N
        jTabbedDash.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedDashStateChanged(evt);
                statusMudança(evt);
            }
        });

        jScrollPane2.setForeground(new java.awt.Color(102, 102, 102));

        jTableTodos.setBackground(new java.awt.Color(255, 255, 255));
        jTableTodos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Data Empréstimo", "Data Prazo", "Nome", "Ferramenta", "Devolução"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableTodos.setSelectionBackground(new java.awt.Color(197, 131, 0));
        jTableTodos.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportView(jTableTodos);

        javax.swing.GroupLayout jAbaTodosLayout = new javax.swing.GroupLayout(jAbaTodos);
        jAbaTodos.setLayout(jAbaTodosLayout);
        jAbaTodosLayout.setHorizontalGroup(
            jAbaTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 801, Short.MAX_VALUE)
        );
        jAbaTodosLayout.setVerticalGroup(
            jAbaTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jTabbedDash.addTab("Todos", jAbaTodos);

        jTableEmDia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Data Empréstimo", "Data Prazo", "Nome", "Ferramenta"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableEmDia.setSelectionBackground(new java.awt.Color(197, 131, 0));
        jTableEmDia.setSelectionForeground(new java.awt.Color(201, 201, 201));
        jScrollPane1.setViewportView(jTableEmDia);

        javax.swing.GroupLayout jAbaEmDiaLayout = new javax.swing.GroupLayout(jAbaEmDia);
        jAbaEmDia.setLayout(jAbaEmDiaLayout);
        jAbaEmDiaLayout.setHorizontalGroup(
            jAbaEmDiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 801, Short.MAX_VALUE)
        );
        jAbaEmDiaLayout.setVerticalGroup(
            jAbaEmDiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jAbaEmDiaLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedDash.addTab("Em Dia", jAbaEmDia);

        jTableAtrasados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Data Empréstimo", "Data Prazo", "Nome", "Ferramenta"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableAtrasados.setSelectionBackground(new java.awt.Color(197, 131, 0));
        jTableAtrasados.setSelectionForeground(new java.awt.Color(201, 201, 201));
        jScrollPane3.setViewportView(jTableAtrasados);

        javax.swing.GroupLayout jAbaAtrasadosLayout = new javax.swing.GroupLayout(jAbaAtrasados);
        jAbaAtrasados.setLayout(jAbaAtrasadosLayout);
        jAbaAtrasadosLayout.setHorizontalGroup(
            jAbaAtrasadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 801, Short.MAX_VALUE)
        );
        jAbaAtrasadosLayout.setVerticalGroup(
            jAbaAtrasadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
        );

        jTabbedDash.addTab("Atrasados", jAbaAtrasados);

        jTableAtivos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Data Empréstimo", "Data Prazo", "Nome", "Ferramenta"
            }
        ));
        jTableAtivos.setSelectionBackground(new java.awt.Color(197, 131, 0));
        jTableAtivos.setSelectionForeground(new java.awt.Color(201, 201, 201));
        jScrollPane4.setViewportView(jTableAtivos);

        javax.swing.GroupLayout jAbaAtivosLayout = new javax.swing.GroupLayout(jAbaAtivos);
        jAbaAtivos.setLayout(jAbaAtivosLayout);
        jAbaAtivosLayout.setHorizontalGroup(
            jAbaAtivosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 801, Short.MAX_VALUE)
        );
        jAbaAtivosLayout.setVerticalGroup(
            jAbaAtivosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jAbaAtivosLayout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedDash.addTab("Ativos", jAbaAtivos);

        javax.swing.GroupLayout jContainerPrincipalLayout = new javax.swing.GroupLayout(jContainerPrincipal);
        jContainerPrincipal.setLayout(jContainerPrincipalLayout);
        jContainerPrincipalLayout.setHorizontalGroup(
            jContainerPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jContainerPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jContainerPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jContainerPrincipalLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jBExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTabbedDash))
                .addGap(18, 18, 18)
                .addComponent(jBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        jContainerPrincipalLayout.setVerticalGroup(
            jContainerPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jContainerPrincipalLayout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(jContainerPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jContainerPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedDash, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBotoes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        jContaienrInformativos.setBackground(new java.awt.Color(46, 46, 46));
        jContaienrInformativos.setLayout(new java.awt.GridLayout(1, 3, 50, 0));

        jPEmprestimos.setBackground(new java.awt.Color(46, 46, 46));
        jPEmprestimos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(229, 164, 11), 2, true));

        jLEmprestimos.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLEmprestimos.setForeground(new java.awt.Color(229, 164, 11));
        jLEmprestimos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLEmprestimos.setFocusable(false);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(229, 164, 11));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("N° Empréstimos");

        javax.swing.GroupLayout jPEmprestimosLayout = new javax.swing.GroupLayout(jPEmprestimos);
        jPEmprestimos.setLayout(jPEmprestimosLayout);
        jPEmprestimosLayout.setHorizontalGroup(
            jPEmprestimosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPEmprestimosLayout.createSequentialGroup()
                .addGroup(jPEmprestimosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPEmprestimosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE))
                    .addComponent(jLEmprestimos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPEmprestimosLayout.setVerticalGroup(
            jPEmprestimosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPEmprestimosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLEmprestimos, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jContaienrInformativos.add(jPEmprestimos);

        jPFerramentas.setBackground(new java.awt.Color(46, 46, 46));
        jPFerramentas.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(229, 164, 11), 2, true));

        jLFerramentas.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLFerramentas.setForeground(new java.awt.Color(229, 164, 11));
        jLFerramentas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(229, 164, 11));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("N° Ferramentas");

        javax.swing.GroupLayout jPFerramentasLayout = new javax.swing.GroupLayout(jPFerramentas);
        jPFerramentas.setLayout(jPFerramentasLayout);
        jPFerramentasLayout.setHorizontalGroup(
            jPFerramentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLFerramentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPFerramentasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPFerramentasLayout.setVerticalGroup(
            jPFerramentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPFerramentasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLFerramentas, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jContaienrInformativos.add(jPFerramentas);

        jPAmigos.setBackground(new java.awt.Color(46, 46, 46));
        jPAmigos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(229, 164, 11), 2, true));

        jLAmigos.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLAmigos.setForeground(new java.awt.Color(229, 164, 11));
        jLAmigos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(229, 164, 11));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("N° Amigos");

        javax.swing.GroupLayout jPAmigosLayout = new javax.swing.GroupLayout(jPAmigos);
        jPAmigos.setLayout(jPAmigosLayout);
        jPAmigosLayout.setHorizontalGroup(
            jPAmigosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLAmigos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPAmigosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPAmigosLayout.setVerticalGroup(
            jPAmigosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPAmigosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLAmigos, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jContaienrInformativos.add(jPAmigos);

        jLabel4.setFont(new java.awt.Font("Fira Sans", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(229, 164, 11));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Relatório de Empréstimos");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout BGLayout = new javax.swing.GroupLayout(BG);
        BG.setLayout(BGLayout);
        BGLayout.setHorizontalGroup(
            BGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(BGLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jContainerPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jContaienrInformativos, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        BGLayout.setVerticalGroup(
            BGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BGLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jContaienrInformativos, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jContainerPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(BG);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void atualizarLabelQuantidadeDeAmigos() throws ExceptionDAO {
        int quantidade = AmigoControle.quantidadeAmigos();
        jLAmigos.setText(String.valueOf(quantidade));
    }

    private void atualizarLabelQuantidadeDeFerramentas() throws ExceptionDAO {
        int quantidade = FerramentaControle.quantidadeFerramentas();
        jLFerramentas.setText(String.valueOf(quantidade));
    }

    private void atualizarLabelQuantidadeDeEmprestimos() throws ExceptionDAO {
        int quantidade = EmprestimoControle.quantidadeEmprestimos();
        jLEmprestimos.setText(String.valueOf(quantidade));
    }
    private void jBAmigosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAmigosActionPerformed
        TelaAmigo amigos = new TelaAmigo();
        amigos.setVisible(true);
        setEnabled(false);
        amigos.setLocationRelativeTo(null);
        amigos.carregaTabelaAmigos();
        amigos.apresentaMaiorUtilizador();
        amigos.apresentaQuantidadeAmigos();

        amigos.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                // Quando a tela de amigos for fechada, atualiza o painel de amigos
                setEnabled(true);
                toFront();
                try {
                    atualizarLabelQuantidadeDeAmigos();
                } catch (ExceptionDAO ex) {
                    Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        ;
    });
    }//GEN-LAST:event_jBAmigosActionPerformed

    private void jBFerramentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBFerramentasActionPerformed
        TelaFerramenta ferramentas = new TelaFerramenta();
        ferramentas.setVisible(true);
        setEnabled(false);

        ferramentas.setLocationRelativeTo(null);
        ferramentas.carregaTabelaFerramentas();
        ferramentas.apresentaPrecoTotal();
        ferramentas.apresentaTotalFerramentas();

        ferramentas.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                // Quando a tela de ferramentas for fechada, atualiza o painel das ferramentas
                setEnabled(true);
                toFront();
                try {
                    atualizarLabelQuantidadeDeFerramentas();
                } catch (ExceptionDAO ex) {
                    Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        ;
    });
    }//GEN-LAST:event_jBFerramentasActionPerformed

    private void jBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirActionPerformed
        if (tabelaAtiva == null) {
            return;
        }

        int selectedRow = tabelaAtiva.getSelectedRow();
        if (selectedRow == -1) {
            DialogErroTabela SelecioneLinha = new DialogErroTabela();
            SelecioneLinha.setVisible(true);
            return;
        }

        DialogConfirmarExclusao dialog = new DialogConfirmarExclusao(this, true);
        DialogErroConfirmacao erro = new DialogErroConfirmacao();
        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                boolean exclusao = dialog.getConfirmarExclusaoF();
                if (exclusao) {
                    Object idObjeto = tabelaAtiva.getValueAt(selectedRow, 0);
                    int id = Integer.parseInt(idObjeto.toString());
                    try {
                        EmprestimoControle.excluir(id);

                        carregaTabelaSelecionada();

                        atualizarLabelQuantidadeDeEmprestimos();
                        jTabbedDash.revalidate();
                        jTabbedDash.repaint();
                    } catch (ExceptionDAO ex) {
                        erro.setVisible(true);
                        Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        dialog.setVisible(true);
    }//GEN-LAST:event_jBExcluirActionPerformed

    private void jTabbedDashStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedDashStateChanged
        carregaTabelaSelecionada();
    }//GEN-LAST:event_jTabbedDashStateChanged


    private void jBConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBConfirmarActionPerformed
        if (tabelaAtiva == null) {
            return;
        }
        int selectedRow = tabelaAtiva.getSelectedRow();

        if (selectedRow == -1) {
            DialogErroTabela SelecioneLinha = new DialogErroTabela();
            SelecioneLinha.setVisible(true);
            return;
        }

        DialogConfirmar dialog = new DialogConfirmar(this, true);
        DialogErroConfirmacao erro = new DialogErroConfirmacao();

        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                boolean confirmado = dialog.isConfirmado();
                if (confirmado) {
                    Object idObjeto = tabelaAtiva.getValueAt(selectedRow, 0);
                    int id = Integer.parseInt(idObjeto.toString());

                    try {
                        EmprestimoControle.confirmarDevolucao(id);
                        carregaTabelaSelecionada();

                        atualizarLabelQuantidadeDeEmprestimos();

                        jTabbedDash.revalidate();
                        jTabbedDash.repaint();
                    } catch (ExceptionDAO ex) {
                        erro.setVisible(true);
                        Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        dialog.setVisible(true);
    }//GEN-LAST:event_jBConfirmarActionPerformed

    public void carregaTabelaTodos() {
        DefaultTableModel modelo = (DefaultTableModel) this.jTableTodos.getModel();
        setTabelaAtiva(jTableTodos);
        modelo.setNumRows(0); //Posiciona na primeira linha da tabela
        //Carrega a lista de objetos aluno
        //TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modelo);
        //jTable1Amigos.setRowSorter(sorter);
        try {
            ArrayList<Emprestimo> lista = EmprestimoControle.buscarTudo();

            Collections.sort(lista, new Comparator<Emprestimo>() {
                @Override
                public int compare(Emprestimo a1, Emprestimo a2) {
                    return Long.compare(a1.getId(), a2.getId());
                }
            });

            for (Emprestimo f : lista) {
                modelo.addRow(new Object[]{
                    f.getId(),
                    f.getDataInicialFormatada(),
                    f.getDataPrazoFormatada(),
                    f.getAmigo().getNome(),
                    f.getFerramenta().getNome(),
                    f.getDataDevolucaoFormatada()
                });
            }
        } catch (ExceptionDAO e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void carregaTabelaEmDia() {
        DefaultTableModel modelo = (DefaultTableModel) this.jTableEmDia.getModel();
        setTabelaAtiva(jTableEmDia);
        modelo.setNumRows(0); //Posiciona na primeira linha da tabela
        //Carrega a lista de objetos aluno
        //TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modelo);
        //jTable1Amigos.setRowSorter(sorter);
        try {
            ArrayList<Emprestimo> lista = EmprestimoControle.buscarEmDia();

            Collections.sort(lista, new Comparator<Emprestimo>() {
                @Override
                public int compare(Emprestimo a1, Emprestimo a2) {
                    return Long.compare(a1.getId(), a2.getId());
                }
            });

            for (Emprestimo f : lista) {
                modelo.addRow(new Object[]{
                    f.getId(),
                    f.getDataInicialFormatada(),
                    f.getDataPrazoFormatada(),
                    f.getAmigo().getNome(),
                    f.getFerramenta().getNome(),
                    f.getDataDevolucao()
                });
            }
        } catch (ExceptionDAO e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void carregaTabelaAtrasados() {
        DefaultTableModel modelo = (DefaultTableModel) this.jTableAtrasados.getModel();
        setTabelaAtiva(jTableAtrasados);
        modelo.setNumRows(0); //Posiciona na primeira linha da tabela
        //Carrega a lista de objetos aluno
        //TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modelo);
        //jTable1Amigos.setRowSorter(sorter);
        try {
            ArrayList<Emprestimo> lista = EmprestimoControle.buscarAtrasados();

            Collections.sort(lista, new Comparator<Emprestimo>() {
                @Override
                public int compare(Emprestimo a1, Emprestimo a2) {
                    return Long.compare(a1.getId(), a2.getId());
                }
            });

            for (Emprestimo f : lista) {
                modelo.addRow(new Object[]{
                    f.getId(),
                    f.getDataInicialFormatada(),
                    f.getDataPrazoFormatada(),
                    f.getAmigo().getNome(),
                    f.getFerramenta().getNome(),
                    f.getDataDevolucao()
                });
            }
        } catch (ExceptionDAO e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void carregaTabelaAtivos() {
        DefaultTableModel modelo = (DefaultTableModel) this.jTableAtivos.getModel();
        setTabelaAtiva(jTableAtivos);
        modelo.setNumRows(0); //Posiciona na primeira linha da tabela
        //Carrega a lista de objetos aluno
        //TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modelo);
        //jTable1Amigos.setRowSorter(sorter);
        try {
            ArrayList<Emprestimo> lista = EmprestimoControle.buscarAtivos();

            Collections.sort(lista, new Comparator<Emprestimo>() {
                @Override
                public int compare(Emprestimo a1, Emprestimo a2) {
                    return Long.compare(a1.getId(), a2.getId());
                }
            });

            for (Emprestimo f : lista) {
                modelo.addRow(new Object[]{
                    f.getId(),
                    f.getDataInicialFormatada(),
                    f.getDataPrazoFormatada(),
                    f.getAmigo().getNome(),
                    f.getFerramenta().getNome(),
                    f.getDataDevolucao()
                });
            }
        } catch (ExceptionDAO e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void jButtonEmDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEmDiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonEmDiaActionPerformed

    private void jButtonNewAmigosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewAmigosActionPerformed
        // TODO add your handling code here:
        TelaAmigo amigos = new TelaAmigo();
        amigos.setVisible(true);
        setEnabled(false);
        amigos.setLocationRelativeTo(null);
        amigos.carregaTabelaAmigos();
        amigos.apresentaMaiorUtilizador();
        amigos.apresentaQuantidadeAmigos();

        amigos.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                // Quando a tela de amigos for fechada, atualiza o painel de amigos
                setEnabled(true);
                toFront();
                try {
                    atualizarLabelQuantidadeDeAmigos();
                } catch (ExceptionDAO ex) {
                    Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        ;
    });
    }//GEN-LAST:event_jButtonNewAmigosActionPerformed

    private void statusMudança(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_statusMudança

        if (jTabbedDash.getSelectedIndex() == 0) { // Se "Todos" é a primeira guia
            // Desabilite o botão "Confirmar" quando a guia "Todos" estiver ativa
            jBConfirmar.setEnabled(false);
        } else {
            // Caso contrário, habilite o botão "Confirmar"
            jBConfirmar.setEnabled(true);
        }
    }//GEN-LAST:event_statusMudança

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        DialogEmprestimo dialog = new DialogEmprestimo(this, true);
        dialog.carregaFerramenta();
        dialog.carregaAmigo();
        dialog.setVisible(true);

        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                try {
                    // Quando a dialog de emprestimos for fechada, atualiza as informações da tela principal
                    carregaTabelaSelecionada();
                    atualizarLabelQuantidadeDeEmprestimos();
                } catch (ExceptionDAO ex) {
                    Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        ;
    });
    }//GEN-LAST:event_jButton1ActionPerformed
    private void carregaTabelaSelecionada() {
        int selectedIndex = jTabbedDash.getSelectedIndex();
        switch (selectedIndex) {
            case 0 ->
                carregaTabelaTodos();
            case 1 ->
                carregaTabelaEmDia();
            case 2 ->
                carregaTabelaAtrasados();
            case 3 ->
                carregaTabelaAtivos();
        }
    }

    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BG;
    private javax.swing.JPanel jAbaAtivos;
    private javax.swing.JPanel jAbaAtrasados;
    private javax.swing.JPanel jAbaEmDia;
    private javax.swing.JPanel jAbaTodos;
    private javax.swing.JButton jBAmigos;
    private javax.swing.JButton jBConfirmar;
    private javax.swing.JButton jBExcluir;
    private javax.swing.JButton jBFerramentas;
    private javax.swing.JPanel jBotoes;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jContaienrInformativos;
    private javax.swing.JPanel jContainerPrincipal;
    private javax.swing.JLabel jLAmigos;
    private javax.swing.JLabel jLEmprestimos;
    private javax.swing.JLabel jLFerramentas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPAmigos;
    private javax.swing.JPanel jPEmprestimos;
    private javax.swing.JPanel jPFerramentas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedDash;
    private javax.swing.JTable jTableAtivos;
    private javax.swing.JTable jTableAtrasados;
    private javax.swing.JTable jTableEmDia;
    private javax.swing.JTable jTableTodos;
    // End of variables declaration//GEN-END:variables
}
