package cop4331.client;

/**
 * @author Brian Holzschuh
 * Products in a shopping system
 */
public class Product implements Item {

    public Product(int ID, String name, double sellPrice, double invoicePrice, String description, int quantity){
        this.ID = ID;
        this.name = name;
        this.sellPrice = sellPrice;
        this.invoicePrice = invoicePrice;
        this.description = description;
        this.quantity = quantity;
    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getSellPrice() {
        return sellPrice;
    }

    @Override
    public double getInvoicePrice() {
        return invoicePrice;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public void increment() {
        quantity++;
    }

    @Override
    public String toString(){
        return description;
    }

    private String name;
    private String description;
    private double sellPrice;
    private double invoicePrice;
    private int quantity;
    private int ID;

}
