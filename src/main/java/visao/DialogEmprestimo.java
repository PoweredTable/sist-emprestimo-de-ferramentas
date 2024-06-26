package visao;

import java.awt.*;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;

import dao.ExceptionDAO;
import modelo.Ferramenta;
import modelo.Amigo;
import controle.AmigoControle;
import controle.FerramentaControle;
import controle.EmprestimoControle;
import visao.swingcomponents.CheckableModelItem;
import visao.swingcomponents.CheckedComboBox;
import visao.swingcomponents.ModelItem;


/**
 * Abre um formulário para cadastro de um empréstimo.
 */
public class DialogEmprestimo extends javax.swing.JDialog {

    private DefaultComboBoxModel<CheckableModelItem<Ferramenta>> modeloFerramenta;
    private DefaultComboBoxModel<ModelItem<Amigo>> modeloAmigo;
    private JDateChooser dateChooser;

    public DialogEmprestimo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.modeloFerramenta = new DefaultComboBoxModel<>();
        this.modeloAmigo = new DefaultComboBoxModel<>();
        this.dateChooser = new JDateChooser();
        initComponents();
        setLocationRelativeTo(parent);
    }

    public void carregaFerramenta() {
        try {
            ArrayList<Ferramenta> lista = FerramentaControle.buscarFerramentasDisponiveis();
            for (Ferramenta l : lista) {
                CheckableModelItem<Ferramenta> checkable = new CheckableModelItem<>(l.getNome(), l);
                modeloFerramenta.addElement(checkable);
            }

        } catch (Exception e) {
        }
    }

    public void carregaAmigo() {
        try {
            ArrayList<Amigo> lista = AmigoControle.buscarTudo();
            for (Amigo l : lista) {
                ModelItem item = new ModelItem(l.getNome(), l);
                modeloAmigo.addElement(item);
            }

        } catch (Exception e) {

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BG = new JPanel();
        jPanel1 = new JPanel();
        jLabelTitleDialog = new JLabel();
        jPanel4 = new JPanel();
        jPanel2 = new JPanel();
        jPanel3 = new JPanel();
        jButtonCalcelar = new JButton();
        jButtonSalvar = new JButton();

        CheckedComboBox<CheckableModelItem<Ferramenta>> comboBoxFerramenta = new CheckedComboBox<>(modeloFerramenta);

        jPanel2.add(comboBoxFerramenta);
        JComboBox<ModelItem<Amigo>> comboboxAmigo = new JComboBox<>(modeloAmigo);
        jPanel2.add(comboboxAmigo);
        jPanel2.add(dateChooser);

        dateChooser.setLocale(Locale.forLanguageTag("pt-BR"));
        dateChooser.setFont(new Font("Arial", Font.PLAIN, 14));
        dateChooser.getJCalendar().setWeekOfYearVisible(false);
        dateChooser.getJCalendar().setTodayButtonVisible(true);
        dateChooser.getJCalendar().setTodayButtonText("Hoje");
        dateChooser.getJCalendar().setDecorationBackgroundVisible(true);
        dateChooser.getJCalendar().setDecorationBordersVisible(true);

        // Customizing colors
        dateChooser.setBackground(new Color(255, 255, 255));
        dateChooser.setForeground(new Color(0, 0, 0));
        dateChooser.getJCalendar().setBackground(new Color(245, 245, 245));
        dateChooser.getJCalendar().setSundayForeground(new Color(255, 99, 71));
        dateChooser.getJCalendar().setWeekdayForeground(new Color(70, 130, 180));


        // Customizing the date editor
        dateChooser.getDateEditor().getUiComponent().setBackground(new Color(255, 255, 255));
        dateChooser.getDateEditor().getUiComponent().setForeground(new Color(0, 0, 0));
        dateChooser.getDateEditor().getUiComponent().setFont(new Font("Arial", Font.PLAIN, 14));


        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new Dimension(550, 350));
        setPreferredSize(new Dimension(550, 350));
        setResizable(false);

        BG.setBackground(new Color(64, 64, 64));

        jPanel1.setBackground(new Color(64, 64, 64));
        jPanel1.setLayout(new GridLayout());

        jLabelTitleDialog.setBackground(new Color(64, 64, 64));
        jLabelTitleDialog.setFont(new Font("Arial Black", 1, 24)); // NOI18N
        jLabelTitleDialog.setForeground(new Color(255, 187, 0));
        jLabelTitleDialog.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelTitleDialog.setText("Cadastro");
        jPanel1.add(jLabelTitleDialog);

        jPanel4.setBackground(new Color(64, 64, 64));

        jPanel2.setBackground(new Color(64, 64, 64));
        jPanel2.setLayout(new GridLayout(3, 0, 0, 20));

        jPanel3.setBackground(new Color(64, 64, 64));
        jPanel3.setLayout(new GridLayout(1, 0, 30, 0));

        jButtonCalcelar.setBackground(new Color(156, 156, 156));
        jButtonCalcelar.setFont(new Font("Arial Black", 1, 14)); // NOI18N
        jButtonCalcelar.setForeground(new Color(64, 64, 64));
        jButtonCalcelar.setText("Cancelar");
        jButtonCalcelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonCalcelarActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonCalcelar);

        jButtonSalvar.setBackground(new Color(156, 156, 156));
        jButtonSalvar.setFont(new Font("Arial Black", 1, 14)); // NOI18N
        jButtonSalvar.setForeground(new Color(64, 64, 64));
        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonSalvar);

        GroupLayout jPanel4Layout = new GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(115, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 318, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, 318, GroupLayout.PREFERRED_SIZE))
                .addGap(105, 105, 105))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
        );

        GroupLayout BGLayout = new GroupLayout(BG);
        BG.setLayout(BGLayout);
        BGLayout.setHorizontalGroup(
            BGLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, BGLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        BGLayout.setVerticalGroup(
            BGLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(BGLayout.createSequentialGroup()
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(24, 24, 24))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(BG, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(BG, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCalcelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCalcelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButtonCalcelarActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        // TODO add your handling code here:
        ModelItem<Amigo> amigoModelItem = (ModelItem<Amigo>) modeloAmigo.getSelectedItem();
        Amigo amigo = amigoModelItem.getItem();
        try {
            if(AmigoControle.amigoPossuiEmprestimoAtivo(amigo)){
                int resposta = JOptionPane.showConfirmDialog(null,"Amigo já possui um emprestimo ativo, deseja continuar?", "Selecionar uma opção", JOptionPane.YES_NO_OPTION);
                if(resposta == JOptionPane.NO_OPTION){
                    return;
                }
            }
        } catch (ExceptionDAO e) {
            JOptionPane.showMessageDialog(null, e);
            return;
        }

        Date dataSelecionada = dateChooser.getDate();
        //SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        //String dataFormatada = sdf.format(dataSelecionada);

        LocalDate localDate = dataSelecionada.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        for (int i = 0; i < modeloFerramenta.getSize(); i++) {
            // retorna o item utilizando o index
            CheckableModelItem<Ferramenta> item = modeloFerramenta.getElementAt(i);
            // verifica se o item está selecionado
            if (item.isSelected()) {
                Ferramenta ferramenta = item.getItem();
                try {
                    EmprestimoControle.cadastrar(ferramenta.getId(),amigo.getId(),LocalDate.now(),localDate);
                    this.dispose();
                }catch (Exception e){
                    JOptionPane.showMessageDialog(null, e);
                }

            }
        }
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    public static void main(String args[]) {

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogEmprestimo dialog = new DialogEmprestimo(new javax.swing.JFrame(), true);
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
}
