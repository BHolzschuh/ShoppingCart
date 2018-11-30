package cop4331.client;

public class Vendor extends User{
    public Vendor(String userName, String password){
        super(userName, password);
        inventory = Inventory.getInstance();
    }

    public void printInventory(){
        System.out.println(inventory.inventoryList);
    }

    public void setInventory1(){

        Product hammer = new Product("Hammer", 5.00, "Great at nailing things");
        Product nails = new Product("Nails", 3.20, "50 count of nails");
        Bundle bundle = new Bundle();
        bundle.add(hammer);
        bundle.add(nails);
        DiscountedItem dbundle = new DiscountedItem(bundle, 20);
        inventory.inventoryList.add(new Product("Pickles", 4.50, "Nice and sour"));
        inventory.inventoryList.add(hammer);
        inventory.inventoryList.add(nails);
        inventory.inventoryList.add(dbundle);

    }

    public void setInventory2(){

        Product bike = new Product("Bicycle", 129.99, "Need to get around town?");
        Product helmet = new Product("Helmet", 24.99, "To protect your noggin");
        Bundle bundle = new Bundle();
        bundle.add(bike);
        bundle.add(helmet);
        DiscountedItem dbundle = new DiscountedItem(bundle, 10);
        inventory.inventoryList.add(new Product("Air Pump", 12.99, "For when you have a flat"));
        inventory.inventoryList.add(bike);
        inventory.inventoryList.add(helmet);
        inventory.inventoryList.add(dbundle);

    }

    private Inventory inventory;
}
