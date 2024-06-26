package visao.swingcomponents;

import javax.swing.*;
import java.awt.*;

import modelo.Ferramenta;

public class ExemploFerramenta {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Checked ComboBox Exemple");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());

            // cria um modelo de comboBox, que é utilizado para carregar uma comboBox com dados
            DefaultComboBoxModel<CheckableModelItem<Ferramenta>> model = getCheckableItemDefaultComboBoxModel();

            // inicializa uma CheckedComboBox com o modelo
            CheckedComboBox<CheckableModelItem<Ferramenta>> comboBox = new CheckedComboBox<>(model);

            // cria um botão para mostrar os dados
            JButton button = new JButton("print");
            // adiciona uma ação ao clicar no botão
            button.addActionListener(e -> {
                // itera sobre todos os items do modelo
                for (int i = 0; i < model.getSize(); i++) {
                    // retorna o item utilizando o index
                    CheckableModelItem<Ferramenta> item = model.getElementAt(i);
                    // verifica se o item está selecionado
                    if (item.isSelected()) {
                        Ferramenta ferramenta = item.getItem();
                        System.out.println(ferramenta.toString());
                    }
                }
            });

            frame.add(button, BorderLayout.SOUTH);
            frame.add(comboBox, BorderLayout.NORTH);
            frame.pack();
            frame.setVisible(true);
        });
    }

    private static DefaultComboBoxModel<CheckableModelItem<Ferramenta>> getCheckableItemDefaultComboBoxModel() {
        // cria duas instâncias de Ferramenta
        Ferramenta f1 = new Ferramenta(1, "Marreta", "Marca A", 45.0);
        Ferramenta f2 = new Ferramenta(2, "Chave", "Marca B", 56.7);
        Ferramenta f3 = new Ferramenta(3, "Serrote", "Marca A", 56.6);

        // cria duas instâncias de CheckableItem<Ferramenta>
        CheckableModelItem<Ferramenta> checkablef1 = new CheckableModelItem<>(f1.getNome(), f1);
        CheckableModelItem<Ferramenta> checkablef2 = new CheckableModelItem<>(f2.getNome(), f2);
        // cria uma instância de um CheckableItem já selecionado
        CheckableModelItem<Ferramenta> checkablef3 = new CheckableModelItem<>(f3.getNome(), f3, true);

        // cria um ComboBoxModel com CheckableItems de ferramenta
        DefaultComboBoxModel<CheckableModelItem<Ferramenta>> model = new DefaultComboBoxModel<>();

        // adiciona os itens ao modelo
        model.addElement(checkablef1);
        model.addElement(checkablef2);
        model.addElement(checkablef3);
        return model;
    }
}
