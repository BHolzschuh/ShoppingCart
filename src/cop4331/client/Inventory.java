package cop4331.client;

import java.util.ArrayList;

/**
 * @author Brian Holzschuh
 * Stores a list of products in the inventory using Singleton
 */
public class Inventory {
    public static Inventory getInstance() { return instance; }

    private static Inventory instance = new Inventory();

    private ArrayList<Item> inventoryList;
}
