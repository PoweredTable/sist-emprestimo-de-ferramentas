package visao;



/**
*Abre um modal solicitando sobre a confirmação da devolução do empréstimo.
 */
public class DialogConfirmado extends javax.swing.JFrame {

    private boolean confirmado = false;
    
     public boolean isConfirmado() {
        return confirmado;
    }
     
    public void setConfirmado(boolean confirmado) {
        this.confirmado = confirmado;
    }
    
    public DialogConfirmado() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        DCConfirmar = new java.awt.Button();
        DCCancelar = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(0, 0));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(64, 64, 64));
        jPanel1.setMaximumSize(new java.awt.Dimension(450, 300));
        jPanel1.setMinimumSize(new java.awt.Dimension(450, 300));
        jPanel1.setPreferredSize(new java.awt.Dimension(450, 300));

        jLabel1.setFont(new java.awt.Font("Fira Sans", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(229, 164, 11));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Tem certeza de que deseja confirmar a devolução deste item?");

        DCConfirmar.setActionCommand("Button1");
        DCConfirmar.setBackground(new java.awt.Color(255, 187, 0));
        DCConfirmar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        DCConfirmar.setForeground(new java.awt.Color(64, 64, 64));
        DCConfirmar.setLabel("Confirmar");
        DCConfirmar.setName(""); // NOI18N
        DCConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DCConfirmarActionPerformed(evt);
            }
        });

        DCCancelar.setBackground(new java.awt.Color(64, 64, 64));
        DCCancelar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        DCCancelar.setForeground(new java.awt.Color(255, 187, 0));
        DCCancelar.setLabel("Cancelar");
        DCCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DCCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(DCCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                .addComponent(DCConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(DCConfirmar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DCCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void DCConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DCConfirmarActionPerformed
        setConfirmado(true);
        dispose();
      
    }//GEN-LAST:event_DCConfirmarActionPerformed

    private void DCCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DCCancelarActionPerformed
       setConfirmado(false);
       dispose();
    }//GEN-LAST:event_DCCancelarActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DialogConfirmado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button DCCancelar;
    private java.awt.Button DCConfirmar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
