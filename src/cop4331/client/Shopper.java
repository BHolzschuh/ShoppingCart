package cop4331.client;

/**
 * @author Brian Holzschuh
 * Shopper sub class of User
 */
public class Shopper extends User{

    /**
     * Constructs a Shopper
     * @param userName shoppers username
     * @param password shoppers password
     */
    public Shopper(String userName, String password){
        super(userName, password);
        cart = new Cart();
    }

    /**
     * Gets the shoppers cart
     * @return the cart
     */
    public Cart getCart(){ return cart; }

    private Cart cart;

}
