package cop4331.client;

import java.io.Serializable;

/**
 * @author Brian Holzschuh
 * Items in a shopping system
 */
public interface Item extends Serializable {
    /**
     * Gets the unique ID of the item
     * @return the ID
     */
    int getID();

    /**
     * Gets the name of the item
     * @return the name
     */
    String getName();

    /**
     * Gets the selling price of the item
     * @return the sell price
     */
    double getSellPrice();

    /**
     * Gets the invoice price of the item
     * @return the invoice price
     */
    double getInvoicePrice();

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

    /**
     * Sets the quantity of the item
     */
    void setQuantity(int quantity);

    /**
     * Increments quantity of the item
     */
    void increment();

}
