package cop4331.client;

/**
 * @author Brian Holzschuh
 * Products in a shopping system
 */
public class Product implements Item {

    public Product(String name, double price, String description){
        this.name = name;
        this.price = price;
        this.description = description;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public int getQuantity() {
        return 0;
    }

    @Override
    public String toString(){
        return description;
    }

    private String name;
    private String description;
    private double price;

}
