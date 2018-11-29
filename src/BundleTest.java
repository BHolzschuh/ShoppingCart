import cop4331.client.Bundle;
import cop4331.client.DiscountedItem;
import cop4331.client.Product;

public class BundleTest {
    public static void main(String[] args){
        Product hammer = new Product("Hammer", 6.55, "A mighty fine hammer");
        Product nails = new Product("50 Nails", 3.00, "50 nails for hammering");
        Bundle bundle = new Bundle();
        bundle.add(hammer);
        bundle.add(nails);
        System.out.println(bundle.getName());
        System.out.println(bundle.getPrice());
        System.out.println(bundle.toString() + "\n");

        DiscountedItem di = new DiscountedItem(bundle, 50);
        System.out.println(di.getName());
        System.out.println(di.getPrice());
        System.out.println(di.toString());
    }
}
