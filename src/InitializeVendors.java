import cop4331.client.Vendor;

import java.io.*;

public class InitializeVendors{
    public static void main(String[] args){
        Vendor v1 = new Vendor("vendor1", "password");
        v1.setInventory1();
        Vendor v2 = new Vendor("vendor2", "password");
        v2.setInventory2();
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("vendors.dat"));
            out.writeObject(v1);
            out.close();
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("vendors.dat"));
            Vendor vread = (Vendor)in.readObject();
            in.close();
            vread.printInventory();
        } catch (Exception e){
            System.out.println("IOException");
        }
    }
}
