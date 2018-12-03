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
        Product hammer = new Product(1, "Hammer", 5.25, 3, "Great at nailing things", 3);
        Product nails = new Product(2, "Nails", 3.27, 1, "50 count of nails", 3);
        Product pickles = new Product(3, "Pickles", 2.99, 2, "Sweet and Sour", 5);
        DiscountedItem dbundle = new DiscountedItem(new Bundle(7, 1, hammer, nails), 20);
        Product bike = new Product(4, "Bicycle", 129.99, 60, "Need to get around town?", 2);
        Product helmet = new Product(5, "Helmet", 24.99, 10, "To protect your noggin", 9);
        Product pump = new Product(6, "Air Pump", 12.99, 7, "To keep you going", 3);
        DiscountedItem dbundle2 = new DiscountedItem(new Bundle(8, 1, bike, helmet, pump), 10);
        Item[] items = new Item[]{hammer, nails, pickles, bike, helmet, pump, dbundle, dbundle2};
        ArrayList<Item> inventory = new ArrayList<>(Arrays.asList(items));
        try {

            ObjectOutputStream out1 = new ObjectOutputStream(new FileOutputStream("users.dat"));
            out1.writeObject(users);
            out1.close();

            ObjectOutputStream out2 = new ObjectOutputStream(new FileOutputStream("inventory.dat"));
            out2.writeObject(inventory);
            out2.close();

            ObjectOutputStream out3 = new ObjectOutputStream(new FileOutputStream("report.dat"));
            out3.writeObject(inventory);
            out3.close();

            System.out.println("Everything is initialized!");

        } catch (Exception e){
            System.out.println("IOException");
        }
    }
}
