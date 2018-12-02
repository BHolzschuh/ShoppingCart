package cop4331.gui;

import cop4331.client.Inventory;
import cop4331.client.Item;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class InventoryView {

    private JPanel invList;
    private JPanel vendorPanel;
    private JButton reportButton;
    private JButton updateButton;
    private JButton addButton;
    private ArrayList<JButton> deleteButtons;
    private ArrayList<JTextField> quantityFields;
    private ArrayList<JPanel> rows;
    private GridBagConstraints c;
    private int y;

    public InventoryView(){
        deleteButtons = new ArrayList<>();
        quantityFields = new ArrayList<>();
        rows = new ArrayList<>();

        vendorPanel = new JPanel();
        vendorPanel.setLayout(new BorderLayout());

        invList = new JPanel();
        invList.setLayout(new GridBagLayout());

        addRows();

        // Buttons
        reportButton = new JButton("Report");
        updateButton = new JButton("Update");
        addButton = new JButton("Add Item");

        // Buttons Panel
        JPanel buttons = new JPanel();
        buttons.setLayout(new FlowLayout());
        buttons.add(reportButton);
        buttons.add(addButton);
        buttons.add(updateButton);

        // Final panel adds
        vendorPanel.add(invList, BorderLayout.CENTER);
        vendorPanel.add(buttons, BorderLayout.SOUTH);
    }

    public JPanel getView(){
        return vendorPanel;
    }

    public JButton getReportButton() {
        return reportButton;
    }

    public JButton getUpdateButton() {
        return updateButton;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public ArrayList getDeleteButtons() { return deleteButtons; }

    public ArrayList getQuantityFields() { return quantityFields; }

    public void addRefresh(){
        addRow();
        vendorPanel.revalidate();
    }

    public void deleteRefresh(){
        vendorPanel.revalidate();
    }

    public void addRow(){
        Item item = Inventory.getInstance().getInventoryList().get(Inventory.getInstance().getInventoryList().size()-1);

        c.gridx = 0;
        c.gridy = y;
        JLabel nameLabel = new JLabel(item.getName());
        invList.add(nameLabel, c);

        c.gridx = 1;
        String cost = "$" + String.valueOf(item.getPrice());
        JLabel priceLabel = new JLabel(cost);
        invList.add(priceLabel, c);

        c.gridx = 2;
        JTextField quantityField = new JTextField();
        quantityField.setColumns(3);
        String amount = String.valueOf(item.getQuantity());
        quantityField.setText(amount);
        invList.add(quantityField, c);
        quantityFields.add(quantityField);

        c.gridx = 3;
        JButton deleteButton = new JButton("X");
        invList.add(deleteButton, c);
        deleteButtons.add(deleteButton);

        y++;
    }

    private void addRows(){
        ArrayList<Item> list = Inventory.getInstance().getInventoryList();

        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10,10,10,10);
        y = 0;
        for(Item item: list){
            JPanel row = new JPanel();
            row.setLayout(new GridBagLayout());

            c.gridx = 0;
            c.gridy = y;
            JLabel nameLabel = new JLabel(item.getName());
            row.add(nameLabel, c);

            c.gridx = 1;
            String cost = "$" + String.valueOf(item.getPrice());
            JLabel priceLabel = new JLabel(cost);
            row.add(priceLabel, c);

            c.gridx = 2;
            JTextField quantityField = new JTextField();
            quantityField.setColumns(3);
            String amount = String.valueOf(item.getQuantity());
            quantityField.setText(amount);
            row.add(quantityField, c);
            quantityFields.add(quantityField);

            c.gridx = 3;
            JButton deleteButton = new JButton("X");
            row.add(deleteButton, c);
            deleteButtons.add(deleteButton);

            c.gridx = 0;
            c.gridy = y;
            invList.add(row, c);
            rows.add(row);

            y++;
        }
    }
}
