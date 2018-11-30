import cop4331.client.*;

import java.io.*;

public class InitializeInventory{
    public static void main(String[] args){
        Vendor vendor = new Vendor("vendor1", "password", "OwlPatrol", "owl");
        Product hammer = new Product("Hammer", 5.00, "Great at nailing things", 3);
        Product nails = new Product("Nails", 3.20, "50 count of nails", 3);
        Product pickles = new Product("Pickles", 2.99, "Sweet and Sour", 5);
        DiscountedItem dbundle = new DiscountedItem(new Bundle(1, hammer, nails), 20, 1);
        Product bike = new Product("Bicycle", 129.99, "Need to get around town?", 2);
        Product helmet = new Product("Helmet", 24.99, "To protect your noggin", 9);
        Product pump = new Product("Air Pump", 12.99, "To keep you going", 3);
        DiscountedItem dbundle2 = new DiscountedItem(new Bundle(1, bike, helmet, pump), 10, 2);
        Inventory inventory = Inventory.getInstance();
        inventory.addItems(hammer, nails, pickles, dbundle, bike, helmet, pump, dbundle2);

        try {

            ObjectOutputStream out1 = new ObjectOutputStream(new FileOutputStream("users.dat"));
            out1.writeObject(vendor);
            out1.close();

            ObjectOutputStream out2 = new ObjectOutputStream(new FileOutputStream("inventory.dat"));
            out2.writeObject(inventory);
            out2.close();

            ObjectInputStream in1 = new ObjectInputStream(new FileInputStream("users.dat"));
            Vendor rvend = (Vendor) in1.readObject();
            in1.close();

            ObjectInputStream in2 = new ObjectInputStream(new FileInputStream("inventory.dat"));
            Inventory rinv = (Inventory) in2.readObject();
            in2.close();

            System.out.println(rvend.getName());
            rinv.printInv();

        } catch (Exception e){
            System.out.println("IOException");
        }
    }
}
