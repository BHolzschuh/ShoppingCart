package cop4331.client;

/**
 * @author Brian Holzschuh
 * Items in a shopping system
 */
public interface Item {
    /**
     * Gets the name of the item
     * @return the name
     */
    String getName();

    /**
     * Gets the price of the item
     * @return the price
     */
    double getPrice();

    /**
     * Gets the description of the item
     * @return the description
     */
    String toString();

    /**
     * Gets the quantity of the item
     * @return the quantity
     */
    int getQuantity();

}
