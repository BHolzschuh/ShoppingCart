package cop4331.client;

/**
 * @author Brian Holzschuh
 * A decorator for an item that applies a discount
 */
public class DiscountedItem implements Item {

    /**
     * Constructs a discounted item
     * @param item the item to be discounted
     * @param discount the discount percentage
     */
    public DiscountedItem(Item item, double discount){
        this.item = item;
        this.discount = discount;
    }

    @Override
    public String getName() {
        return item.getName() + " (Discount " + discount + "%)";
    }

    @Override
    public String toString() {
        return item.toString() + " (Discount " + discount + "%)";
    }

    @Override
    public double getPrice() {
        return item.getPrice() * (1 - discount / 100);
    }

    @Override
    public int getQuantity() {
        return 0;
    }

    private Item item;
    private double discount;
}
