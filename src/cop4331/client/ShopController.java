package cop4331.client;

import cop4331.gui.Screen;

import javax.swing.*;
import java.util.ArrayList;


public class ShopController {

    Inventory inv;


    ShopController(Screen sc){

        inv = Inventory.getInstance();

        System.out.println(printInventory());
       // sc.getInventoryLabel().setText("" + inv.getInventoryList().size());

        for(int i = 0; i < inv.getInventorySize(); i++){

            Item item = inv.getInventoryList().get(i);
           sc.getItemNames().add(new JLabel(item.getName()));
           sc.getItemPrice().add(new JLabel("" + item.getSellPrice()));
           sc.getItemQuantity().add(new JLabel("" + item.getQuantity()));

        }

        sc.loadDisplay();
        
        System.out.println(sc.getItemNames().get(3).getText());


    }

    public String printInventory(){
        return inv.getInventoryList().toString();
    }



}
