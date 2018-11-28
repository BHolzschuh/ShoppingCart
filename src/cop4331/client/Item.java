package cop4331.client;

public class Item {

    public Item(String name, double cost, int quantity){
        this.name = name;
        this.cost = cost;
        this.quantity = quantity;
    }

    public String getName(){
        return name;
    }

    public double getCost(){
        return cost;
    }

    public int getQuantity(){
        return quantity;
    }

    private String name;
    private double cost;
    private int quantity;

}
