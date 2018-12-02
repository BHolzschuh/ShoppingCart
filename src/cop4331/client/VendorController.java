package cop4331.client;

import cop4331.gui.Screen;

import javax.swing.*;

public class VendorController {

    public VendorController(Screen sc){
        Inventory inv = Inventory.getInstance();

        // Inventory add item button
        sc.getInventoryAddButton().addActionListener(e -> sc.showAddItemWindow());

        // Inventory report button
        sc.getInventoryReportButton().addActionListener(e -> sc.showReportWindow());

        // Inventory delete buttons
        int count = 0;
        for(JButton button: sc.getInventoryDeleteButtons()){
            System.out.println(count);
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

                System.out.println(itemName);
                System.out.println(itemPrice);
                System.out.println(itemQuantity);
                System.out.println(itemDescription);
                inv.addItemForm(itemName, itemPrice, itemDescription, itemQuantity);
                sc.addRows();
                sc.closeAddItemFrame();

            } catch (Exception ex){
                System.out.println("Form Invalid");
            }
        });
    }

}
