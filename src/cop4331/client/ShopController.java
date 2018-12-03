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
                System.out.println(j.getText());
                if (!j.getText().equals("0")) {
                    if(usr.getCart().updateQuantity(inv.getInventoryList().get(i),Integer.parseInt(j.getText()))) {
                        sc.getCartItemName().add(new JLabel(inv.getInventoryList().get(i).getName()));
                        sc.getCartItemQuantity().add(new JLabel(j.getText()));
                    }
                    else{
                        int index = usr.getCart().search(j.getText());
                        if(index!=200) {
                            sc.getCartItemName().set(index, new JLabel(inv.getInventoryList().get(i).getName()));
                            sc.getCartItemQuantity().set(index, new JLabel(j.getText()));
                        }
                    }
                }
            i++;

        }

        usr.getCart().printCart();
            sc.fillCart();
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
