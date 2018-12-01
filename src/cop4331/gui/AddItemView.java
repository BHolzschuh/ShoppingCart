package cop4331.gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class AddItemView {

    private JPanel addItemPanel;
    private JPanel formPanel;
    private GridBagConstraints c;
    private JButton backButton;
    private JButton submitButton;
    private JTextField nameField;
    private JTextField costField;
    private JTextField quantityField;
    private JTextArea descriptionField;

    public AddItemView(){
        addItemPanel = new JPanel();
        addItemPanel.setLayout(new BorderLayout());

        formPanel = new JPanel();
        formPanel.setLayout(new GridBagLayout());
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(7,7,7,7);

        // Name label
        JLabel nameLabel = new JLabel("Item name: ");
        add(nameLabel, 0, 0);

        // Name field
        nameField = new JTextField();
        nameField.setColumns(10);
        add(nameField, 1, 0);

        // Cost label
        JLabel costLabel = new JLabel("Item cost: ");
        add(costLabel, 0, 1);

        // Cost field
        costField = new JTextField();
        costField.setColumns(10);
        add(costField, 1, 1);

        // Quantity label
        JLabel quantityLabel = new JLabel("Item quantity: ");
        add(quantityLabel, 0, 2);

        // Quantity field
        quantityField = new JTextField();
        quantityField.setColumns(10);
        add(quantityField, 1, 2);

        // Description label
        JLabel descriptionLabel = new JLabel("Item Description: ");
        add(descriptionLabel, 0, 3);

        // Description field
        descriptionField = new JTextArea();
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        descriptionField.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(7, 7, 7, 7)));
        descriptionField.setLineWrap(true);
        descriptionField.setWrapStyleWord(true);
        descriptionField.setColumns(10);
        descriptionField.setRows(3);
        add(descriptionField, 1, 3);

        // Buttons
        submitButton = new JButton("Submit");
        backButton = new JButton("Cancel");

        // Button Panel
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout());
        buttonsPanel.add(backButton);
        buttonsPanel.add(submitButton);

        // Title Panel
        JLabel title = new JLabel("Add a new item");
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout());
        titlePanel.add(title);

        addItemPanel.add(titlePanel, BorderLayout.NORTH);
        addItemPanel.add(formPanel, BorderLayout.CENTER);
        addItemPanel.add(buttonsPanel, BorderLayout.SOUTH);
    }

    public JPanel getView(){
        return addItemPanel;
    }

    public JButton getBackButton() { return backButton; }

    public JButton getSubmitButton() { return submitButton; }

    public JTextField getNameField() { return nameField; }

    public JTextField getCostField() { return costField; }

    public JTextField getQuantityField() { return quantityField; }

    public JTextArea getDescriptionField() { return descriptionField; }

    public void add(JComponent comp, int x, int y){
        c.gridx = x;
        c.gridy = y;
        formPanel.add(comp, c);
    }
}
