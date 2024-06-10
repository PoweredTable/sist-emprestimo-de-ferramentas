package visao;

import javax.swing.JOptionPane;

import modelo.Ferramenta;
import controle.FerramentaControle;
import dao.ExceptionDAO;
import visao.swingcomponents.PlaceholderTextField;

/**
 * Abre um modal de cadastro e edição de ferramentas.
 */
public class DialogFerramenta extends javax.swing.JDialog {
    private int id;

    public DialogFerramenta(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        initCustomComponents();
        setLocationRelativeTo(parent);
    }
    public void setTitleDialog(String texto){
        jLabelTitleDialog.setText(texto);
    }
    
    public void setSalvarButtonSalvar(String text) {
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


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BG = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabelTitleDialog = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
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

    public void initCustomComponents(){
        jTextFieldNome = new PlaceholderTextField("");
        jTextFieldMarca = new PlaceholderTextField("");
        jTextFieldPreco = new PlaceholderTextField("");
        
        
        jTextFieldNome.setBackground(new java.awt.Color(156, 156, 156));
        jTextFieldNome.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jTextFieldNome.setForeground(new java.awt.Color(64, 64, 64));
        jTextFieldNome.setPlaceholder("Nome");
        jPanel2.add(jTextFieldNome);

        jTextFieldMarca.setBackground(new java.awt.Color(156, 156, 156));
        jTextFieldMarca.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jTextFieldMarca.setForeground(new java.awt.Color(64, 64, 64));
        jTextFieldMarca.setPlaceholder("Marca");
        jPanel2.add(jTextFieldMarca);

        jTextFieldPreco.setBackground(new java.awt.Color(156, 156, 156));
        jTextFieldPreco.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jTextFieldPreco.setForeground(new java.awt.Color(64, 64, 64));
        jTextFieldPreco.setPlaceholder("Preço");
        jPanel2.add(jTextFieldPreco);
    }
    
    private void jButtonCalcelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCalcelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButtonCalcelarActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        // TODO add your handling code here:
        if (jButtonSalvar.getText().equals("Salvar")) {
        // Lógica para cadastrar nova ferramenta
        cadastrarFerramenta();
        this.dispose();
        
        }else if (jButtonSalvar.getText().equals("Editar")) {
        // Lógica para editar ferramenta
        editarFerramenta();
        this.dispose();
        }
    }//GEN-LAST:event_jButtonSalvarActionPerformed
    
    public void cadastrarFerramenta() {
        try {
            String nome = getNome();
            String marca = getMarca();
            Double preco = Double.parseDouble(getPreco());

            FerramentaControle.cadastrar(nome, marca, preco);
        } catch (ExceptionDAO e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void editarFerramenta() {
        try {
            int id = getId();
            String nome = getNome();
            String marca = getMarca();
            Double preco = Double.parseDouble(getPreco());
            Ferramenta ferramenta = new Ferramenta(id, nome, marca, preco);
            FerramentaControle.alterar(ferramenta);

        } catch (ExceptionDAO e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogFerramenta dialog = new DialogFerramenta(new javax.swing.JFrame(), true);
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
    // End of variables declaration//GEN-END:variables
    private PlaceholderTextField jTextFieldMarca;
    private PlaceholderTextField jTextFieldNome;
    private PlaceholderTextField jTextFieldPreco;
}
