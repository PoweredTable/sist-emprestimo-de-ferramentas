/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package visao;

/**
 *
 * @author waldy
 */
public class DialogFerramentas extends javax.swing.JDialog {
    private int id;
    /**
     * Creates new form DialogFerramentas
     */
    public DialogFerramentas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
    }
    public void setTitleDialog(String texto){
        jLabelTitleDialog.setText(texto);
    }
    
    public void setSalvarButtonText(String text) {
        jButtonSalvar.setText(text);
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public int getId(){
        return this.id;
    }
     
    public void setNome(String nome) {
        jTextFieldNome.setText(nome);
    }
    
    public String getNome(){
        return jTextFieldNome.getText();
    }
    
    public void setMarca(String marca) {
        jTextFieldMarca.setText(marca);
    }
    
    public String getMarca(){
        return jTextFieldMarca.getText();
    }

    public void setPreco(String preco) {
        jTextFieldPreco.setText(preco);
    }
    public String getPreco(){
        return jTextFieldPreco.getText();
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
        jPanel1 = new javax.swing.JPanel();
        jLabelTitleDialog = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jTextFieldNome = new javax.swing.JTextField();
        jTextFieldMarca = new javax.swing.JTextField();
        jTextFieldPreco = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jButtonCalcelar = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(550, 350));
        setResizable(false);

        BG.setBackground(new java.awt.Color(64, 64, 64));

        jPanel1.setBackground(new java.awt.Color(64, 64, 64));
        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        jLabelTitleDialog.setBackground(new java.awt.Color(64, 64, 64));
        jLabelTitleDialog.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabelTitleDialog.setForeground(new java.awt.Color(255, 187, 0));
        jLabelTitleDialog.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitleDialog.setText("Cadastro");
        jPanel1.add(jLabelTitleDialog);

        jPanel4.setBackground(new java.awt.Color(64, 64, 64));

        jPanel2.setBackground(new java.awt.Color(64, 64, 64));
        jPanel2.setLayout(new java.awt.GridLayout(3, 0, 0, 20));

        jTextFieldNome.setBackground(new java.awt.Color(156, 156, 156));
        jTextFieldNome.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jTextFieldNome.setForeground(new java.awt.Color(64, 64, 64));
        jTextFieldNome.setText("Nome");
        jTextFieldNome.setToolTipText("");
        jPanel2.add(jTextFieldNome);

        jTextFieldMarca.setBackground(new java.awt.Color(156, 156, 156));
        jTextFieldMarca.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jTextFieldMarca.setForeground(new java.awt.Color(64, 64, 64));
        jTextFieldMarca.setText("Marca");
        jPanel2.add(jTextFieldMarca);

        jTextFieldPreco.setBackground(new java.awt.Color(156, 156, 156));
        jTextFieldPreco.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jTextFieldPreco.setForeground(new java.awt.Color(64, 64, 64));
        jTextFieldPreco.setText("Preço");
        jPanel2.add(jTextFieldPreco);

        jPanel3.setBackground(new java.awt.Color(64, 64, 64));
        jPanel3.setLayout(new java.awt.GridLayout(1, 0, 30, 0));

        jButtonCalcelar.setBackground(new java.awt.Color(156, 156, 156));
        jButtonCalcelar.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jButtonCalcelar.setForeground(new java.awt.Color(64, 64, 64));
        jButtonCalcelar.setText("Cancelar");
        jButtonCalcelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCalcelarActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonCalcelar);

        jButtonSalvar.setBackground(new java.awt.Color(156, 156, 156));
        jButtonSalvar.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jButtonSalvar.setForeground(new java.awt.Color(64, 64, 64));
        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonSalvar);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(115, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE))
                .addGap(105, 105, 105))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout BGLayout = new javax.swing.GroupLayout(BG);
        BG.setLayout(BGLayout);
        BGLayout.setHorizontalGroup(
            BGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BGLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        BGLayout.setVerticalGroup(
            BGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BGLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void jButtonCalcelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCalcelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButtonCalcelarActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        // TODO add your handling code here:
        if (jButtonSalvar.getText().equals("Salvar")) {
        // Lógica para cadastrar nova ferramenta
        }else if (jButtonSalvar.getText().equals("Editar")) {
        // Lógica para editar ferramenta
        }
    }//GEN-LAST:event_jButtonSalvarActionPerformed
    
    
    
    
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
            java.util.logging.Logger.getLogger(DialogFerramentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogFerramentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogFerramentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogFerramentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogFerramentas dialog = new DialogFerramentas(new javax.swing.JFrame(), true);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BG;
    private javax.swing.JButton jButtonCalcelar;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JLabel jLabelTitleDialog;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField jTextFieldMarca;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldPreco;
    // End of variables declaration//GEN-END:variables
}
