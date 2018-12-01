import cop4331.client.*;
import cop4331.gui.Screen;


public class app {
    public static void main(String[] args) {

        Screen sc = new Screen();
        AuthModel au = new AuthModel();
        AuthControl start = new AuthControl(sc,au);

    }
}
