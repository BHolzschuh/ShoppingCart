import cop4331.client.Bundle;
import cop4331.client.Product;

public class BundleTest {
    public static void main(String[] args){
        Product hammer = new Product("Hammer", 6.55, "A mighty fine hammer");
        Product nails = new Product("50 Nails", 3.00, "50 nails for hammering");
        Bundle handn = new Bundle();
        handn.add(hammer);
        handn.add(nails);
        System.out.println(handn.getName());
        System.out.println(handn.getPrice());
        System.out.println(handn.toString());
    }
}
