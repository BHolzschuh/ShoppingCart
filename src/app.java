import cop4331.gui.*;

import javax.swing.*;

public class app {
    public static void main(String[] args){
        LoginView login = new LoginView();

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(login.getPanel());
        frame.pack();
        frame.setVisible(true);
    }
}
