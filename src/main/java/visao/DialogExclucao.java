/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package visao;

/**
 *
 * @author LUCAS PEIXER
 */
public class DialogExclucao extends javax.swing.JFrame {

    private boolean exclusao = false;
    
     public boolean Exclusao() {
        return exclusao;
    }
     
    public void setExclusao(boolean exclusao) {
        this.exclusao = exclusao;
    }
    
    public DialogExclucao() {
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        DECancelar = new java.awt.Button();
        DEConfirmar = new java.awt.Button();
        jLabelTitleDialog4 = new javax.swing.JLabel();
        jLabelTitleDialog5 = new javax.swing.JLabel();
        jLabelTitleDialog3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(64, 64, 64));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(64, 64, 64));
        jPanel1.setMaximumSize(new java.awt.Dimension(450, 300));
        jPanel1.setMinimumSize(new java.awt.Dimension(450, 300));

        jPanel2.setBackground(new java.awt.Color(64, 64, 64));
        jPanel2.setLayout(new java.awt.GridLayout(1, 0, 30, 0));

        DECancelar.setBackground(new java.awt.Color(156, 156, 156));
        DECancelar.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        DECancelar.setForeground(new java.awt.Color(64, 64, 64));
        DECancelar.setLabel("Cancelar");
        DECancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DECancelarActionPerformed(evt);
            }
        });
        jPanel2.add(DECancelar);

        DEConfirmar.setActionCommand("Button1");
        DEConfirmar.setBackground(new java.awt.Color(156, 156, 156));
        DEConfirmar.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        DEConfirmar.setForeground(new java.awt.Color(64, 64, 64));
        DEConfirmar.setLabel("Confirmar");
        DEConfirmar.setName(""); // NOI18N
        DEConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DEConfirmarActionPerformed(evt);
            }
        });
        jPanel2.add(DEConfirmar);

        jLabelTitleDialog4.setBackground(new java.awt.Color(64, 64, 64));
        jLabelTitleDialog4.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabelTitleDialog4.setForeground(new java.awt.Color(255, 187, 0));
        jLabelTitleDialog4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitleDialog4.setText("Exclusão");

        jLabelTitleDialog5.setBackground(new java.awt.Color(64, 64, 64));
        jLabelTitleDialog5.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabelTitleDialog5.setForeground(new java.awt.Color(255, 187, 0));
        jLabelTitleDialog5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTitleDialog5.setText("Tem certeza que deseja que deseja excluir esse item?");

        jLabelTitleDialog3.setBackground(new java.awt.Color(64, 64, 64));
        jLabelTitleDialog3.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabelTitleDialog3.setForeground(new java.awt.Color(255, 187, 0));
        jLabelTitleDialog3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTitleDialog3.setText("Você está prestes a efetuar uma exclusão!");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelTitleDialog4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTitleDialog3)
                    .addComponent(jLabelTitleDialog5)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabelTitleDialog4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jLabelTitleDialog5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelTitleDialog3)
                .addGap(28, 28, 28)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(102, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void DEConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DEConfirmarActionPerformed
        setExclusao(true);
        dispose();
    }//GEN-LAST:event_DEConfirmarActionPerformed

    private void DECancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DECancelarActionPerformed
        setExclusao(false);
        dispose();
    }//GEN-LAST:event_DECancelarActionPerformed

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
            java.util.logging.Logger.getLogger(DialogExclucao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogExclucao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogExclucao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogExclucao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DialogExclucao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button DECancelar;
    private java.awt.Button DEConfirmar;
    private javax.swing.JLabel jLabelTitleDialog3;
    private javax.swing.JLabel jLabelTitleDialog4;
    private javax.swing.JLabel jLabelTitleDialog5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
