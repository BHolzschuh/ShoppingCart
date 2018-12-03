package cop4331.client;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Brian Holzschuh
 * Bundles of products in shopping system
 */
public class Bundle implements Item {

    /**
     * Constructs a bundled item
     * @param ID unique ID
     * @param quantity total amount
     * @param items
     */
    public Bundle(int ID, int quantity, Item...items) {
        this.ID = ID;
        this.items = new ArrayList<>();
        this.items.addAll(Arrays.asList(items));
        this.quantity = quantity;
    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public String getName() {
        StringBuilder name = new StringBuilder();
        for(int i = 0; i < items.size(); i++){
            if(i > 0) name.append("+");
            name.append(items.get(i).getName());
        }
        return name.toString();
    }

    @Override
    public double getSellPrice() {
        double price = 0;
        for(Item item: items){
            price += item.getSellPrice();
        }
        return price;
    }

    @Override
    public double getInvoicePrice() {
        double price = 0;
        for(Item item: items){
            price += item.getInvoicePrice();
        }
        return price;
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
        StringBuilder description = new StringBuilder("Bundle: ");
        for(int i = 0; i < items.size(); i++){
            if(i > 0) description.append(", ");
            description.append(items.get(i).toString());
        }
        return description.toString();
    }

    private ArrayList<Item> items;
    private int quantity;
    private int ID;
}
