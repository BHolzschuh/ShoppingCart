package cop4331.client;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Brian Holzschuh
 * Bundles of products in shopping system
 */
public class Bundle implements Item {

    public Bundle(int quantity, Item...items) {
        this.items = new ArrayList<>();
        this.items.addAll(Arrays.asList(items));
        this.quantity = quantity;
    }

    public void add(Item...items) {
        this.items.addAll(Arrays.asList(items));
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
    public double getPrice() {
        double price = 0;
        for(Item item: items){
            price += item.getPrice();
        }
        return price;
    }

    @Override
    public int getQuantity() {
        return quantity;
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
}
