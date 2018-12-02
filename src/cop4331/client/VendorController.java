package cop4331.client;

import cop4331.gui.Screen;

import javax.swing.*;

/**
 * @author Brian Holzschuh
 */
public class VendorController {

    private Screen sc;
    private int updateCount;
    private int deleteCount;
    private Inventory inventory;

    public VendorController(Screen sc){
        this.sc = sc;
        inventory = Inventory.getInstance();

        // Inventory add item button
        sc.getInventoryAddButton().addActionListener(e -> sc.showAddItemWindow());

        // Inventory report button
        sc.getInventoryReportButton().addActionListener(e -> sc.showReportWindow());

        // Inventory update button
        sc.getInventoryUpdateButton().addActionListener(e -> {
            System.out.println("Updating quantity");
        });

        // Inventory delete buttons
        deleteCount = 0;
        for(JButton button: sc.getInventoryDeleteButtons()){
            final Item item = inventory.getInventoryList().get(deleteCount);
            final int current = deleteCount;
            button.addActionListener(e -> {
                System.out.println(item.getName());
                inventory.removeItem(item.getName());
                JPanel panel = sc.getInventoryRows().get(current);
                sc.inventoryDeleteRefresh(panel);
            });
            deleteCount++;
        }

        // Report ok button
        sc.getReportOkButton().addActionListener(e -> sc.closeReportFrame());

        // Add item ok button
        sc.getAddItemBackButton().addActionListener(e -> sc.closeAddItemFrame());

        // Add item submit button
        sc.getAddItemSubmitButton().addActionListener(e -> {
            try{
                String itemName = sc.getItemNameField().getText();
                double itemPrice = Double.parseDouble(sc.getItemCostField().getText());
                int itemQuantity = Integer.parseInt(sc.getItemQuantityField().getText());
                String itemDescription = sc.getItemDescriptionField().getText();

                deleteCount = inventory.getInventoryList().size() - 1;
                Inventory.getInstance().addItemForm(itemName, itemPrice, itemDescription, itemQuantity);
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
        final Item item = inventory.getInventoryList().get(inventory.getInventoryList().size() - 1);
        newDelete.addActionListener(e -> {
            System.out.println(item.getName());
            inventory.removeItem(item.getName());
            JPanel panel = sc.getInventoryRows().get(sc.getInventoryRows().size() - 1);
            sc.inventoryDeleteRefresh(panel);
        });
    }


}
