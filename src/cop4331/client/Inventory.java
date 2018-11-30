package cop4331.client;

import java.io.Serializable;
import java.util.ArrayList;

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

    public ArrayList<Item> inventoryList;

}
