package cop4331.client;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Brian Holzschuh
 * Stores a list of products in the inventory using Singleton pattern
 */
public class Inventory implements Serializable {

    private static Inventory instance = null;

    /**
     * Constructs a single instance ArrayList
     */
    private Inventory(){
        inventoryList = new ArrayList<>();
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("inventory.dat"));
            inventoryList = (ArrayList<Item>) in.readObject();
        } catch (Exception e){
            System.out.println("Problem with the file.");
        }
    }

    /**
     * Create instance of Inventory
     * @return instance of inventory
     */
    public static Inventory getInstance() {
        if(instance == null) instance = new Inventory();
        return instance;
    }

    /**
     *
     * @param name
     * @param sellPrice
     * @param invoicePrice
     * @param description
     * @param quantity
     */
    public void addItemForm(String name, double sellPrice, double invoicePrice, String description, int quantity){
        for(Item item: inventoryList){
            if(item.getName().equals(name)) {
                for(int i = 0; i < quantity; i++) {
                    item.increment();
                }
                updateData();
                return;
            }
        }
        inventoryList.add(new Product(inventoryList.size() + 1, name, sellPrice, invoicePrice, description, quantity));
        updateData();
    }

    /**
     * Writes the current inventory to the data file
     */
    private void updateData(){
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("inventory.dat"));
            out.writeObject(inventoryList);
            out.close();
        } catch (Exception e){
            System.out.println("File error");
        }
    }

    /**
     *
     * @param ID
     */
    public void removeItem(int ID){
        inventoryList.removeIf(item -> item.getID() == ID);
        updateData();
    }

    public void updateQuantity(int index, int quantity){
        inventoryList.get(index).setQuantity(quantity);
        updateData();
    }

    public ArrayList<Item> getInventoryList(){
        return (ArrayList<Item>) inventoryList.clone();
    }

    private ArrayList<Item> inventoryList;
}
