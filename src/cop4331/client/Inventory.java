package cop4331.client;

import java.util.ArrayList;

/**
 * @author Brian Holzschuh
 * Stores a list of products in the inventory using Singleton pattern
 */
public class Inventory {

    private static Inventory instance = null;

    /**
     * Constructs a single instance ArrayList
     */
    private Inventory(){
        inventoryList = new ArrayList<>();
        Product hammer = new Product("Hammer", 5.00, "Great at nailing things");
        Product nails = new Product("Nails", 3.20, "50 count of nails");
        Bundle bundle = new Bundle();
        bundle.add(hammer);
        bundle.add(nails);
        DiscountedItem dbundle = new DiscountedItem(bundle, 20);
        inventoryList.add(new Product("Pickles", 4.50, "Nice and sour"));
        inventoryList.add(hammer);
        inventoryList.add(nails);
        inventoryList.add(dbundle);
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
