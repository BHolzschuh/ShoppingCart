package cop4331.gui;

import javax.swing.*;

public class RegisterView {
    public RegisterView(){
        JPanel registerPanel = new JPanel();
        registerPanel.setLayout(new BoxLayout(registerPanel, BoxLayout.LINE_AXIS));

        JPanel titlePanel = new JPanel();
        titlePanel.add(new JLabel("Register"));
    }
}
