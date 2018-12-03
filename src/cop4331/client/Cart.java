package cop4331.client;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Brian Holzschuh, Ben Shapiro
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
        for(Item ci: cartList){
            if(ci.getName().equals(item.getName())) ci.increment();
            return;
        }
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
    public boolean updateQuantity(Item item, int quantity){

        for(Item ci: cartList){
            if(ci.getName().equals(item.getName())){
                ci.setQuantity(quantity);
                return false;
            }
        }
        cartList.add(item);
        return true;

    }

    /**
     * Searches the cart for an item
     * @param name item name
     * @return whether item is found or not
     */
    public int search(String name) {

        int i = 0;

        for (Item ci : cartList) {
            if(ci.getName().equals(name))
                return i;
        }

            return 200;
    }

    /**
     * Prints the contents of the cart
     */
    public void printCart(){

        for(Item item: cartList)
            System.out.println(item.getName());
    }

    public ArrayList<Item> getContents(){return cartList;}

    private ArrayList<Item> cartList;
}
