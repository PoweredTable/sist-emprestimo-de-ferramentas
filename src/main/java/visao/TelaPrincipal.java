/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package visao;

/**
 *
 * @author LUCAS PEIXER
 */
public class TelaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        initComponents();
        jButtonTodos.setSvgImage("visao/Imagens/trash-xmark.svg",24,24);
        jButtonTodos.setBorder(null);
        jButtonEmDia.setSvgImage("visao/Imagens/check.svg",24,24);
        jButtonEmDia.setBorder(null);
        jButtonAtrasados.setSvgImage("visao/Imagens/play-pause.svg",24,24);
        jButtonAtrasados.setBorder(null);
        jButtonLixeira.setSvgImage("visao/Imagens/trash.svg",34,34);
        jButtonLixeira.setBorder(null);
        jButtonConfirmar.setSvgImage("visao/Imagens/check.svg",34,34);
        jButtonConfirmar.setBorder(null);
        jButtonNewEmprestimo.setSvgImage("visao/Imagens/play-pause.svg",24,24);
        jButtonNewEmprestimo.setBorder(null);
        jButtonNewFerramenta.setSvgImage("visao/Imagens/play-pause.svg",24,24);
        jButtonNewFerramenta.setBorder(null);
        jButtonNewAmigos.setSvgImage("visao/Imagens/play-pause.svg",24,24);
        jButtonNewAmigos.setBorder(null);
        
    }

    /** 
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BG = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        sVGLabel4 = new visao.SVGLabel();
        sVGLabel1 = new visao.SVGLabel();
        jPanel2 = new javax.swing.JPanel();
        sVGLabel2 = new visao.SVGLabel();
        sVGLabel5 = new visao.SVGLabel();
        jPanel3 = new javax.swing.JPanel();
        sVGLabel6 = new visao.SVGLabel();
        sVGLabel3 = new visao.SVGLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 20), new java.awt.Dimension(0, 20), new java.awt.Dimension(32767, 20));
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 32767));
        jPanel5 = new javax.swing.JPanel();
        jButtonNewEmprestimo = new visao.SVGImage();
        jButtonNewFerramenta = new visao.SVGImage();
        jButtonNewAmigos = new visao.SVGImage();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 50), new java.awt.Dimension(0, 50), new java.awt.Dimension(32767, 50));
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(32767, 10));
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jButtonTodos = new visao.SVGImage();
        jButtonEmDia = new visao.SVGImage();
        jButtonAtrasados = new visao.SVGImage();
        jPanel8 = new javax.swing.JPanel();
        jButtonLixeira = new visao.SVGImage();
        jButtonConfirmar = new visao.SVGImage();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(java.awt.Color.white);
        setMaximumSize(new java.awt.Dimension(1000, 800));
        setMinimumSize(new java.awt.Dimension(1280, 900));
        setPreferredSize(new java.awt.Dimension(1280, 900));

        BG.setBackground(new java.awt.Color(64, 64, 64));

        jPanel4.setBackground(new java.awt.Color(64, 64, 64));
        jPanel4.setLayout(new java.awt.GridLayout(0, 3, 120, 0));

        jPanel1.setBackground(new java.awt.Color(46, 46, 46));
        jPanel1.setLayout(new java.awt.GridLayout(2, 0));

        sVGLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sVGLabel4.setText("ICONE HERE");
        jPanel1.add(sVGLabel4);

        sVGLabel1.setForeground(new java.awt.Color(255, 187, 0));
        sVGLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sVGLabel1.setText("Nº EMPRESTIMOS");
        sVGLabel1.setToolTipText("");
        sVGLabel1.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jPanel1.add(sVGLabel1);

        jPanel4.add(jPanel1);

        jPanel2.setBackground(new java.awt.Color(46, 46, 46));
        jPanel2.setLayout(new java.awt.GridLayout(2, 0));

        sVGLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sVGLabel2.setText("ICONE HERE");
        jPanel2.add(sVGLabel2);

        sVGLabel5.setForeground(new java.awt.Color(255, 187, 0));
        sVGLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sVGLabel5.setText("Nº FERRAMENTAS");
        sVGLabel5.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jPanel2.add(sVGLabel5);

        jPanel4.add(jPanel2);

        jPanel3.setBackground(new java.awt.Color(46, 46, 46));
        jPanel3.setLayout(new java.awt.GridLayout(2, 0));

        sVGLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sVGLabel6.setText("ICONE HERE");
        jPanel3.add(sVGLabel6);

        sVGLabel3.setForeground(new java.awt.Color(255, 187, 0));
        sVGLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sVGLabel3.setText("Nº AMIGOS");
        sVGLabel3.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jPanel3.add(sVGLabel3);

        jPanel4.add(jPanel3);

        jPanel5.setBackground(new java.awt.Color(64, 64, 64));
        jPanel5.setMinimumSize(new java.awt.Dimension(100, 1080));
        jPanel5.setPreferredSize(new java.awt.Dimension(200, 400));
        jPanel5.setLayout(new java.awt.GridLayout(3, 0, 0, 80));

        jButtonNewEmprestimo.setBackground(new java.awt.Color(255, 187, 0));
        jButtonNewEmprestimo.setForeground(new java.awt.Color(0, 0, 0));
        jButtonNewEmprestimo.setText(" ADICIONAR EMPRÉSTIMO");
        jButtonNewEmprestimo.setToolTipText("");
        jButtonNewEmprestimo.setFont(new java.awt.Font("Arial Black", 0, 13)); // NOI18N
        jPanel5.add(jButtonNewEmprestimo);

        jButtonNewFerramenta.setBackground(new java.awt.Color(255, 187, 0));
        jButtonNewFerramenta.setForeground(new java.awt.Color(0, 0, 0));
        jButtonNewFerramenta.setText("FERRAMENTAS");
        jButtonNewFerramenta.setFont(new java.awt.Font("Arial Black", 1, 13)); // NOI18N
        jPanel5.add(jButtonNewFerramenta);

        jButtonNewAmigos.setBackground(new java.awt.Color(255, 187, 0));
        jButtonNewAmigos.setForeground(new java.awt.Color(0, 0, 0));
        jButtonNewAmigos.setText("AMIGOS");
        jButtonNewAmigos.setFont(new java.awt.Font("Arial Black", 1, 13)); // NOI18N
        jButtonNewAmigos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewAmigosActionPerformed(evt);
            }
        });
        jPanel5.add(jButtonNewAmigos);

        jPanel6.setBackground(new java.awt.Color(64, 64, 64));

        jTable2.setBackground(new java.awt.Color(89, 89, 89));
        jTable2.setForeground(new java.awt.Color(89, 89, 89));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nome", "Ferramenta", "Data do Emprestimo", "Data de Devolução"
            }
        ));
        jTable2.setGridColor(new java.awt.Color(251, 224, 52));
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(64, 64, 64));
        jPanel7.setLayout(new java.awt.GridLayout(1, 9, 20, 0));

        jButtonTodos.setBackground(new java.awt.Color(46, 46, 46));
        jButtonTodos.setForeground(new java.awt.Color(255, 187, 0));
        jButtonTodos.setText("TODOS");
        jButtonTodos.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jPanel7.add(jButtonTodos);
        jButtonTodos.getAccessibleContext().setAccessibleName("todos");
        jButtonTodos.getAccessibleContext().setAccessibleDescription("");

        jButtonEmDia.setBackground(new java.awt.Color(46, 46, 46));
        jButtonEmDia.setForeground(new java.awt.Color(255, 187, 0));
        jButtonEmDia.setText("EM DIA");
        jButtonEmDia.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jButtonEmDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEmDiaActionPerformed(evt);
            }
        });
        jPanel7.add(jButtonEmDia);

        jButtonAtrasados.setBackground(new java.awt.Color(46, 46, 46));
        jButtonAtrasados.setForeground(new java.awt.Color(255, 187, 0));
        jButtonAtrasados.setText("ATRASADOS");
        jButtonAtrasados.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jPanel7.add(jButtonAtrasados);

        jPanel8.setBackground(new java.awt.Color(64, 64, 64));
        jPanel8.setLayout(new java.awt.GridLayout(1, 0, 20, 0));

        jButtonLixeira.setBackground(new java.awt.Color(64, 64, 64));
        jButtonLixeira.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLixeiraActionPerformed(evt);
            }
        });
        jPanel8.add(jButtonLixeira);

        jButtonConfirmar.setBackground(new java.awt.Color(64, 64, 64));
        jPanel8.add(jButtonConfirmar);

        jSeparator1.setBackground(new java.awt.Color(156, 156, 156));
        jSeparator1.setForeground(new java.awt.Color(156, 156, 156));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout BGLayout = new javax.swing.GroupLayout(BG);
        BG.setLayout(BGLayout);
        BGLayout.setHorizontalGroup(
            BGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BGLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(147, 147, 147))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BGLayout.createSequentialGroup()
                .addGroup(BGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BGLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(BGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(BGLayout.createSequentialGroup()
                                .addGroup(BGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(BGLayout.createSequentialGroup()
                                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 731, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(BGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(filler3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(BGLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(filler4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(12, 12, 12)
                .addComponent(filler2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        BGLayout.setVerticalGroup(
            BGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BGLayout.createSequentialGroup()
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(BGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BGLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(BGLayout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(filler2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(BGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(BGLayout.createSequentialGroup()
                        .addComponent(filler3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13))
                    .addGroup(BGLayout.createSequentialGroup()
                        .addGroup(BGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                            .addComponent(jSeparator1)
                            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(BGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filler4, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(BG, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLixeiraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLixeiraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonLixeiraActionPerformed

    private void jButtonEmDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEmDiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonEmDiaActionPerformed

    private void jButtonNewAmigosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewAmigosActionPerformed
        // TODO add your handling code here:
        TelaAmigos amigos = new TelaAmigos();
        amigos.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButtonNewAmigosActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BG;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private visao.SVGImage jButtonAtrasados;
    private visao.SVGImage jButtonConfirmar;
    private visao.SVGImage jButtonEmDia;
    private visao.SVGImage jButtonLixeira;
    private visao.SVGImage jButtonNewAmigos;
    private visao.SVGImage jButtonNewEmprestimo;
    private visao.SVGImage jButtonNewFerramenta;
    private visao.SVGImage jButtonTodos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable2;
    private visao.SVGLabel sVGLabel1;
    private visao.SVGLabel sVGLabel2;
    private visao.SVGLabel sVGLabel3;
    private visao.SVGLabel sVGLabel4;
    private visao.SVGLabel sVGLabel5;
    private visao.SVGLabel sVGLabel6;
    // End of variables declaration//GEN-END:variables
}
