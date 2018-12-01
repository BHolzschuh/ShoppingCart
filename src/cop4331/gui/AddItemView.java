package cop4331.gui;

import javax.swing.*;
import java.awt.*;

public class AddItemView {

    private JPanel addItemPanel;
    private JPanel formPanel;
    GridBagConstraints c;

    public AddItemView(){
        addItemPanel = new JPanel();
        addItemPanel.setLayout(new BorderLayout());

        formPanel = new JPanel();
        formPanel.setLayout(new GridBagLayout());
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(7,7,7,7);

        JLabel nameLabel = new JLabel("Item name: ");
        add(nameLabel, 0, 0);

        JTextField nameField = new JTextField();
        nameField.setColumns(10);
        add(nameField, 1, 0);

        JLabel costLabel = new JLabel("Item cost: ");
        add(costLabel, 0, 1);

        JTextField costField = new JTextField();
        costField.setColumns(10);
        add(costField, 1, 1);

        JLabel quantityLabel = new JLabel("Item quantity: ");
        add(quantityLabel, 0, 2);

        JTextField quantityField = new JTextField();
        quantityField.setColumns(10);
        add(quantityField, 1, 2);

        JButton submitButton = new JButton("Submit");
        JButton backButton = new JButton("Cancel");

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout());
        buttonsPanel.add(backButton);
        buttonsPanel.add(submitButton);

        addItemPanel.add(formPanel, BorderLayout.CENTER);
        addItemPanel.add(buttonsPanel, BorderLayout.SOUTH);
    }

    public JPanel getView(){
        return addItemPanel;
    }

    public void add(JComponent comp, int x, int y){
        c.gridx = x;
        c.gridy = y;
        formPanel.add(comp, c);
    }
}
