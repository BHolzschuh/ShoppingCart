package cop4331.client;

import cop4331.gui.Screen;

import javax.swing.*;

public class VendorController {

    private Screen sc;
    private int deleteCount;

    public VendorController(Screen sc){
        this.sc = sc;

        // Inventory add item button
        sc.getInventoryAddButton().addActionListener(e -> sc.showAddItemWindow());

        // Inventory report button
        sc.getInventoryReportButton().addActionListener(e -> sc.showReportWindow());

        // Inventory delete buttons
        int count = 0;
        for(JButton button: sc.getInventoryDeleteButtons()){
            final Item item = Inventory.getInstance().getInventoryList().get(count);
            button.addActionListener(e -> {
                System.out.println(item.getName());
                Inventory.getInstance().removeItem(item.getName());
                sc.inventoryDeleteRefresh();
            });
            count++;
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
        final Item item = Inventory.getInstance().getInventoryList().get(Inventory.getInstance().getInventoryList().size() - 1);
        newDelete.addActionListener(e -> {
            System.out.println(item.getName());
            Inventory.getInstance().removeItem(item.getName());
            sc.inventoryDeleteRefresh();
        });
    }


}
