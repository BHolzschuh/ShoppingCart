import cop4331.client.Inventory;
import cop4331.client.Item;

public class InventoryTest {
    public static void main(String[] args){
        Inventory single = Inventory.getInstance();
        for(Item item: single.inventoryList){
            System.out.println(item);
        }
    }
}
