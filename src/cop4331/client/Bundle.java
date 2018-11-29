package cop4331.client;

import java.util.ArrayList;

/**
 * @author Brian Holzschuh
 * Bundles of products in shopping system
 */
public class Bundle implements Item {

    public Bundle() { items = new ArrayList<>(); }

    public void add(Item item) { items.add(item); }

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
        return 0;
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
}
