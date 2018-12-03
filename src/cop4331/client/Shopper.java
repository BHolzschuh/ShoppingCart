package cop4331.client;

public class Shopper extends User{


    public Shopper(String userName, String password){
        super(userName, password);
        cart = new Cart();
    }

    public Cart getCart(){ return cart; }

    private Cart cart;

}
