package cop4331.client;

import cop4331.gui.Screen;

import javax.swing.*;
import java.util.ArrayList;


public class ShopController {

    Inventory inv;


    ShopController(Screen sc, Shopper usr){

        inv = Inventory.getInstance();

        System.out.println(printInventory());

        sc.addRequest().addActionListener(e -> {

            int i = 0;
            for (JTextField j : sc.getQuantityUpdate()){
                if (j.getText() != "0") {
                    usr.getCart().addItem(inv.getInventoryList().get(i));
                    usr.getCart().updateQuantity(inv.getInventoryList().get(i),3);

                }
            i++;

        }

        usr.getCart().printCart();
        });

        for(int i = 0; i < inv.getInventorySize(); i++){

            Item item = inv.getInventoryList().get(i);
           sc.getItemNames().add(new JLabel(item.getName()));
           sc.getItemPrice().add(new JLabel("" + item.getSellPrice()));
           sc.getItemQuantity().add(new JLabel("" + item.getQuantity()));

        }

        sc.loadDisplay();


    }

    public String printInventory(){
        return inv.getInventoryList().toString();
    }



}
