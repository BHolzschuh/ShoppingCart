package cop4331.client;

import cop4331.gui.Screen;

import javax.swing.*;
import java.util.ArrayList;


public class ShopController {

    Inventory inv;


    ShopController(Screen sc){

        inv = Inventory.getInstance();

        System.out.println(printInventory());
        sc.getInventoryLabel().setText("" + inv.getInventoryList().size());

        for(int i = 0; i < inv.getInventorySize(); i++){
            //System.out.println("adding " + inv.getInventoryList().get(i).getName());
           sc.getItemNames().add(new JLabel("hi"));

        }

        sc.getItemPanel().revalidate();
        
        System.out.println(sc.getItemNames().get(3).getText());

    }

    public String printInventory(){
;
        return inv.getInventoryList().toString();
    }



}
