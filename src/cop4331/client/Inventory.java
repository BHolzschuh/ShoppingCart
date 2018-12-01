package cop4331.client;

import java.io.Serializable;
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
    }

    /**
     * Create instance of Inventory
     * @return instance of inventory
     */
    public static Inventory getInstance() {
        if(instance == null) instance = new Inventory();
        return instance;
    }

    public void addItemForm(String name, double price, String description, int quantity){
        for(Item item: inventoryList){
            if(item.getName().equals(name)) {
                for(int i = 0; i < quantity; i++) {
                    item.increment();
                }
                return;
            }
        }
        inventoryList.add(new Product(name, price, description, quantity));
    }

    public void addItems(Item...items){
        inventoryList.addAll(Arrays.asList(items));
    }

    public void removeItem(String name){
        inventoryList.removeIf(item -> item.getName().equals(name));
    }

    public void printInv(){
        for(Item item: inventoryList){
            System.out.println(item.getName() + " " + item.getQuantity());
            item.increment();
        }
    }

    private ArrayList<Item> inventoryList;
}
