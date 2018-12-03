package cop4331.gui;

import cop4331.client.Inventory;
import cop4331.client.Item;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * @author Brian Holzschuh
 */
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

        c = new GridBagConstraints();

        vendorPanel = new JPanel();
        vendorPanel.setLayout(new BorderLayout());

        invList = new JPanel();
        invList.setLayout(new GridBagLayout());

        // Title row
        JLabel name = new JLabel("Name");
        JLabel sellPrice = new JLabel("Sell");
        JLabel invoicePrice = new JLabel("Invoice");
        JLabel quantity = new JLabel("Quantity");
        JLabel delete = new JLabel("Delete");

        JPanel row = new JPanel();
        row.setLayout(new GridBagLayout());

        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10,10,10,10);

        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        row.add(name, c);
        c.weightx = 0;
        c.gridx = 1;
        row.add(sellPrice, c);
        c.gridx = 2;
        row.add(invoicePrice, c);
        c.gridx = 3;
        row.add(quantity, c);
        c.gridx = 4;
        row.add(delete, c);
        c.gridx = 0;
        c.gridy = 0;
        invList.add(row, c);

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

    public ArrayList<JButton> getDeleteButtons() { return deleteButtons; }

    public ArrayList<JTextField> getQuantityFields() { return quantityFields; }

    public ArrayList<JPanel> getRowPanels() { return rows; }

    public void addRefresh(){
        addRow();
        vendorPanel.revalidate();
    }

    public void deleteRefresh(int index){
        quantityFields.remove(index);
        deleteButtons.remove(index);
        invList.remove(index + 1);
        vendorPanel.revalidate();
    }

    public void addRow(){
        Item item = Inventory.getInstance().getInventoryList().get(Inventory.getInstance().getInventoryList().size()-1);

        JPanel row = new JPanel();
        row.setLayout(new GridBagLayout());

        c.gridx = 0;
        c.gridy = y;
        c.weightx = 1;
        JLabel nameLabel = new JLabel(item.getName());
        row.add(nameLabel, c);

        c.weightx = 0;
        c.gridx = 1;
        String sellcost = "$" + String.valueOf(item.getSellPrice());
        JLabel sellPriceLabel = new JLabel(sellcost);
        row.add(sellPriceLabel, c);

        c.gridx = 2;
        String invoicecost = "$" + String.valueOf(item.getInvoicePrice());
        JLabel invoicePriceLabel = new JLabel(invoicecost);
        row.add(invoicePriceLabel, c);

        c.gridx = 3;
        JTextField quantityField = new JTextField();
        quantityField.setColumns(3);
        String amount = String.valueOf(item.getQuantity());
        quantityField.setText(amount);
        row.add(quantityField, c);
        quantityFields.add(quantityField);

        c.gridx = 4;
        JButton deleteButton = new JButton("X");
        row.add(deleteButton, c);
        deleteButtons.add(deleteButton);

        c.gridx = 0;
        c.gridy = y;
        invList.add(row, c);
        rows.add(row);

        y++;
    }

    private void addRows(){
        ArrayList<Item> list = Inventory.getInstance().getInventoryList();

        y = 1;
        int i = 0;
        for(Item item: list){
            JPanel row = new JPanel();
            row.putClientProperty("id", i);
            row.setLayout(new GridBagLayout());

            c.weightx = 1;
            c.gridx = 0;
            c.gridy = y;
            JLabel nameLabel = new JLabel(item.getName());
            row.add(nameLabel, c);

            c.weightx = 0;
            c.gridx = 1;
            String sellcost = "$" + String.valueOf(item.getSellPrice());
            JLabel sellPriceLabel = new JLabel(sellcost);
            row.add(sellPriceLabel, c);

            c.gridx = 2;
            String invoicecost = "$" + String.valueOf(item.getInvoicePrice());
            JLabel invoicePriceLabel = new JLabel(invoicecost);
            row.add(invoicePriceLabel, c);

            c.gridx = 3;
            JTextField quantityField = new JTextField();
            quantityField.setColumns(3);
            String amount = String.valueOf(item.getQuantity());
            quantityField.setText(amount);
            row.add(quantityField, c);
            quantityFields.add(quantityField);

            c.gridx = 4;
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
