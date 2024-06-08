package visao;

/**
 * Cria um dialog de confirmação de exclusão.
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        DEConfirmar = new java.awt.Button();
        DECancelar = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(64, 64, 64));
        jPanel1.setMaximumSize(new java.awt.Dimension(450, 300));
        jPanel1.setMinimumSize(new java.awt.Dimension(450, 300));

        jLabel1.setFont(new java.awt.Font("Fira Sans", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(229, 164, 11));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Tem certeza de que deseja excluir este item?");

        DEConfirmar.setActionCommand("Button1");
        DEConfirmar.setBackground(new java.awt.Color(255, 187, 0));
        DEConfirmar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        DEConfirmar.setForeground(new java.awt.Color(64, 64, 64));
        DEConfirmar.setLabel("Confirmar");
        DEConfirmar.setName(""); // NOI18N
        DEConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DEConfirmarActionPerformed(evt);
            }
        });

        DECancelar.setBackground(new java.awt.Color(64, 64, 64));
        DECancelar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        DECancelar.setForeground(new java.awt.Color(255, 187, 0));
        DECancelar.setLabel("Cancelar");
        DECancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DECancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(DECancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                .addComponent(DEConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(89, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(DEConfirmar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DECancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                .addGap(56, 56, 56))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    public static void main(String args[]) {



        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DialogExclucao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button DECancelar;
    private java.awt.Button DEConfirmar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
