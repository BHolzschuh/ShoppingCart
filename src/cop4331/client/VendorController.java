package cop4331.client;

import cop4331.gui.Screen;

import javax.swing.*;
import java.text.DecimalFormat;

/**
 * @author Brian Holzschuh
 */
public class VendorController {

    private Screen sc;
    private Inventory inventory;
    private Report report;

    public VendorController(Screen sc){
        this.sc = sc;
        inventory = Inventory.getInstance();
        report = Report.getInstance();

        // Inventory add item button
        sc.getInventoryAddButton().addActionListener(e -> sc.showAddItemWindow());

        // Inventory report button
        sc.getInventoryReportButton().addActionListener(e -> {
            DecimalFormat df = new DecimalFormat("#.##");
            String cost = "$" + df.format(report.getCost());
            String profit = "$" + df.format(report.getProfits());
            String revenue = "$" + df.format(report.getRevenue());
            sc.getReportCosts().setText(cost);
            sc.getReportProfits().setText(profit);
            sc.getReportRevenue().setText(revenue);
            sc.showReportWindow();
        });

        // Inventory update button
        sc.getInventoryUpdateButton().addActionListener(e -> {
            try {
                int count = 0;
                for (JTextField quantityField : sc.getInventoryQuantityFields()) {
                    inventory.updateQuantity(count, Integer.parseInt(quantityField.getText()));
                    count++;
                }
            } catch (Exception ex){
                System.out.println("Invalid quantity values");
            }
        });

        // Inventory delete buttons
        for(JButton button: sc.getInventoryDeleteButtons()){
            button.addActionListener(e -> {
                int count = 0;
                for(JButton button1: sc.getInventoryDeleteButtons()){
                    if(button1 == button) break;
                    count++;
                }
                System.out.println("index of button: " + count);
                Item item = inventory.getInventoryList().get(count);
                System.out.println(item.getName());
                inventory.removeItem(item.getID());
                sc.inventoryDeleteRefresh(count);
            });
        }

        // Report ok button
        sc.getReportOkButton().addActionListener(e -> sc.closeReportFrame());

        // Add item ok button
        sc.getAddItemBackButton().addActionListener(e -> sc.closeAddItemFrame());

        // Add item submit button
        sc.getAddItemSubmitButton().addActionListener(e -> {
            try{
                String itemName = sc.getItemNameField().getText();
                double itemSellPrice = Double.parseDouble(sc.getItemSellCostField().getText());
                double itemInvoicePrice = Double.parseDouble(sc.getItemInvoiceCostField().getText());
                int itemQuantity = Integer.parseInt(sc.getItemQuantityField().getText());
                String itemDescription = sc.getItemDescriptionField().getText();
                resetForm();

                inventory.addItemForm(itemName, itemSellPrice, itemInvoicePrice, itemDescription, itemQuantity);
                sc.inventoryAddRefresh();
                sc.closeAddItemFrame();
                updateDeleteButtons();

            } catch (Exception ex){
                System.out.println("Form Invalid");
            }
        });
    }

    private void updateDeleteButtons(){
        JButton newDelete = sc.getInventoryDeleteButtons().get(sc.getInventoryDeleteButtons().size() - 1);
        newDelete.addActionListener(e -> {
            int count = 0;
            for(JButton button1: sc.getInventoryDeleteButtons()){
                if(button1 == newDelete) break;
                count++;
            }
            System.out.println("index of button: " + count);
            Item item = inventory.getInventoryList().get(count);
            System.out.println(item.getName());
            inventory.removeItem(item.getID());
            sc.inventoryDeleteRefresh(count);
        });
    }

    private void resetForm(){
        sc.getItemNameField().setText("");
        sc.getItemSellCostField().setText("");
        sc.getItemInvoiceCostField().setText("");
        sc.getItemQuantityField().setText("");
        sc.getItemDescriptionField().setText("");
    }


}
