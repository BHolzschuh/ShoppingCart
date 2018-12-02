package cop4331.client;

import org.junit.Assert;
import org.junit.Test;

import javax.print.DocFlavor;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * @author Brian Holzschuh
 * Tester for the Inventory class
 */
public class InventoryTest {

    @Test
    public void testgetInstance() {
        System.out.println("run test getInstance");
        Inventory inv1 = Inventory.getInstance();
        Inventory inv2 = Inventory.getInstance();

        Assert.assertEquals(inv1, inv2);
    }

    @Test
    public void testaddItemForm() {
        System.out.println("run test addItemForm");
        Product testProduct = new Product(100, "bike", 12.00, 8.00, "goes fast", 1);
        Inventory inv = Inventory.getInstance();

        inv.addItemForm("bike", 12.00, 4.00, "goes fast", 1);
        Item invProd = inv.getInventoryList().get(inv.getInventoryList().size() - 1);

        Assert.assertEquals(testProduct.getName(), invProd.getName());
    }

    @Test
    public void testremoveItem() {
        System.out.println("run test removeItem");
        Inventory inv = Inventory.getInstance();
        ArrayList<Item> test1 = inv.getInventoryList();

        test1.removeIf(item -> item.getID() == 1);
        inv.removeItem(1);
        ArrayList<Item> test2 = inv.getInventoryList();

        Assert.assertArrayEquals(test1.toArray(), test2.toArray());
    }
}