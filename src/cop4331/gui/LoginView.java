package cop4331.gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class LoginView {

    private JPanel loginPanel;

    public LoginView(){
        loginPanel = new JPanel();
        loginPanel.setLayout(new BorderLayout());

        // Title panel
        JPanel titlePanel = new JPanel();
        titlePanel.add(new JLabel("Login"));

        // Label panel
        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.PAGE_AXIS));
        labelPanel.add(new JLabel("Username"));
        labelPanel.add(new JLabel("Password"));

        // Form panel
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.PAGE_AXIS));
        JTextField username = new JTextField();
        JTextField password = new JTextField();
        username.setPreferredSize(new Dimension(200, 30));
        password.setPreferredSize(new Dimension(200, 30));
        formPanel.add(username);
        formPanel.add(password);

        // Body panel
        JPanel bodyPanel = new JPanel();
        bodyPanel.setLayout(new BoxLayout(bodyPanel, BoxLayout.LINE_AXIS));
        bodyPanel.add(labelPanel);
        bodyPanel.add(formPanel);

        loginPanel.add(titlePanel, BorderLayout.NORTH);
        loginPanel.add(bodyPanel, BorderLayout.CENTER);
        loginPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
    }


    public JPanel getView(){
        return loginPanel;
    }
}
