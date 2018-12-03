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
     * @precondition inventory data file exists
     * @postcondition inventoryList is initialized
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
     * @precondition none
     * @postcondition instance is initialized
     */
    public static Inventory getInstance() {
        if(instance == null) instance = new Inventory();
        return instance;
    }

    /**
     * Adds an item to the inventory
     * @param name the name of the item
     * @param sellPrice the sell price of the item
     * @param invoicePrice the invoice price of the item
     * @param description the item description
     * @param quantity the item quantity
     * @precondition inventoryList is initialized
     * @postcondition inventoryList isn't empty
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
     * @precondition inventoryList is initialized
     * @postcondition the data file exists
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
     * Removes an item from the inventory using the ID
     * @param ID the item ID number
     * @precondition inventoryList is initialized
     * @postcondition the item is removed
     */
    public void removeItem(int ID){
        inventoryList.removeIf(item -> item.getID() == ID);
        updateData();
    }

    /**
     * Updates the quantity of an item in the inventory
     * @param index item index in the array
     * @param quantity amount to be changed
     * @precondition inventoryList is initialized
     * @postcondition quantity is updated
     */
    public void updateQuantity(int index, int quantity){
        inventoryList.get(index).setQuantity(quantity);
        updateData();
    }

    /**
     * Gets a clone of the inventory array
     * @return inventory array
     * @precondition inventoryList is initialized
     * @postcondition none
     */
    public ArrayList<Item> getInventoryList(){
        return (ArrayList<Item>) inventoryList.clone();
    }

    /**
     * Gets the size of the inventory
     * @return the size of the inventory
     * @precondition inventoryList is initialized
     * @postcondition none
     */
    public int getInventorySize(){
        return inventoryList.size();
    }

    private ArrayList<Item> inventoryList;
}
