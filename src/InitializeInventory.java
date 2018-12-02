import cop4331.client.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

public class InitializeInventory{
    public static void main(String[] args){
        Vendor vendor = new Vendor("vendor", "password", "OwlPatrol", "owl");
        Hashtable<String, User> users = new Hashtable<>();
        users.put(vendor.getUserName(), vendor);
        Product hammer = new Product("Hammer", 5.25, "Great at nailing things", 3);
        Product nails = new Product("Nails", 3.27, "50 count of nails", 3);
        Product pickles = new Product("Pickles", 2.99, "Sweet and Sour", 5);
        DiscountedItem dbundle = new DiscountedItem(new Bundle(1, hammer, nails), 20, 1);
        Product bike = new Product("Bicycle", 129.99, "Need to get around town?", 2);
        Product helmet = new Product("Helmet", 24.99, "To protect your noggin", 9);
        Product pump = new Product("Air Pump", 12.99, "To keep you going", 3);
        DiscountedItem dbundle2 = new DiscountedItem(new Bundle(1, bike, helmet, pump), 10, 2);
        Item[] items = new Item[]{hammer, nails, pickles, bike, helmet, pump, dbundle, dbundle2};
        ArrayList<Item> inventory = new ArrayList<>(Arrays.asList(items));
        try {

            ObjectOutputStream out1 = new ObjectOutputStream(new FileOutputStream("users.dat"));
            out1.writeObject(users);
            out1.close();

            ObjectOutputStream out2 = new ObjectOutputStream(new FileOutputStream("inventory.dat"));
            out2.writeObject(inventory);
            out2.close();

            System.out.println("Everything is initialized!");

        } catch (Exception e){
            System.out.println("IOException");
        }
    }
}
