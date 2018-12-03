package cop4331.client;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProductTest {

    @Test
    public void getID() {
        System.out.println("getID test");
        int id = 99;
        Product test = new Product(id, "test", 2, 1, "a test", 1);

        Assert.assertEquals(id, test.getID());
    }

    @Test
    public void getName() {
        System.out.println("getName test");
        String name = "test";
        Product test = new Product(1, name, 2, 1, "a test", 1);

        Assert.assertEquals(name, test.getName());
    }

    @Test
    public void getSellPrice() {
        System.out.println("getSellPrice test");
        double sell = 3.00;
        Product test = new Product(1, "test", sell, 1, "a test", 1);

        Assert.assertEquals(sell, test.getSellPrice(), 0.0);
    }

    @Test
    public void getInvoicePrice() {
        System.out.println("getInvoicePrice test");
        double invoice = 3.00;
        Product test = new Product(1, "test", 4, invoice, "a test", 1);

        Assert.assertEquals(invoice, test.getInvoicePrice(), 0.0);
    }

    @Test
    public void getQuantity() {
        System.out.println("getQuantity test");
        int quantity = 2;
        Product test = new Product(1, "test", 4, 2, "a test", quantity);

        Assert.assertEquals(quantity, test.getQuantity());
    }

    @Test
    public void setQuantity() {
        System.out.println("setQuantity test");
        int quantity = 4;
        Product test = new Product(1, "test", 4, 2, "a test", 1);

        test.setQuantity(quantity);

        Assert.assertEquals(quantity, test.getQuantity());
    }

    @Test
    public void increment() {
        System.out.println("increment test");
        int quantity = 2;
        Product test = new Product(1, "test", 4, 2, "a test", 1);

        test.increment();

        Assert.assertEquals(test.getQuantity(), quantity);
    }

    @Test
    public void testToString() {
        System.out.println("toString test");
        String description = "test text";
        Product test = new Product(1, "test", 4, 2, description, 1);

        Assert.assertEquals(test.toString(), description);
    }
}