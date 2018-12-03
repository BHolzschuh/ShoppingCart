package cop4331.client;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Brian Holzschuh
 * Stores a list of products in the users cart
 */
public class Cart implements Serializable {

    /**
     * Constructs a cart list
     */
    public Cart(){
        cartList = new ArrayList<>();
    }

    /**
     * Adds an item to the cart
     * @param item to be added
     */
    public void addItem(Item item){

        cartList.add(item);
    }

    /**
     * Removes an item from the cart
     * @param item to be removed
     */
    public void removeItem(Item item){
        cartList.removeIf(ci -> ci.getName().equals(item.getName()));
    }

    /**
     * Updates the quantity of the product
     * @param item to be updated
     * @param quantity amount to update
     */
    public void updateQuantity(Item item, int quantity){
        for(Item ci: cartList){
            if(item.getName().equals(ci.getName())) ci.setQuantity(quantity);
        }
    }

    public void printCart(){

        for(Item item: cartList)
            System.out.println(item.getName() + "----" + item.getQuantity());
    }

    private ArrayList<Item> cartList;
}
