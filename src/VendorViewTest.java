import cop4331.client.VendorController;
import cop4331.gui.Screen;


public class VendorViewTest {
    public static void main(String[] args){
        Screen sc = new Screen();
        sc.showInventory();
        VendorController vc = new VendorController(sc);
    }
}
