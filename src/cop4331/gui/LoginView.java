package cop4331.gui;

import javax.swing.*;
import java.awt.*;

public class LoginView {

    private JPanel loginPanel = new JPanel();
    private JLabel welcomePanel = new JLabel();
    private JPanel formPanel = new JPanel();
    private JButton registerButton;
    private JButton loginButton;

    private GridBagConstraints gridC = new GridBagConstraints();

    public LoginView(){

        //logicPanel setup
        loginPanel.setLayout(new BoxLayout(loginPanel,BoxLayout.PAGE_AXIS));
        JLabel label = new JLabel();
        loginPanel.add(label);
        JLabel greetIn = new JLabel("Hey there. Welcome to the shop. Where you can be you.");


        //formPanel setup
        GridBagLayout gl = new GridBagLayout();
        formPanel.setLayout(gl);
        gridC.fill = GridBagConstraints.HORIZONTAL;
        gridC.insets = new Insets(7,7,7,7);

        // Username Label
        JLabel usr = new JLabel("Username: ");
        add(usr, 0, 0);

        // Username Field
        JTextField usrForm = new JTextField();
        usrForm.setColumns(10);
        add(usrForm, 1, 0);

        // Password Label
        JLabel pwd = new JLabel("Password:             ");
        add(pwd, 0, 1);

        // Password Field
        JPasswordField pwdForm = new JPasswordField();
        pwdForm.setColumns(10);
        add(pwdForm, 1, 1);

        // Register Button
        registerButton = new JButton("Register");
        add(registerButton, 0, 2);

        // Login Button
        loginButton = new JButton("Login");
        add(loginButton, 1, 2);

        //logicPanel.add(greetIn);
        loginPanel.add(formPanel);

    }

    public JPanel getView(){
        return loginPanel;
    }

    public JButton getLoginButton() { return loginButton; }

    public JButton getRegisterButton() { return  registerButton; }

    private void add(JComponent j, int x, int y){
        gridC.gridx = x;
        gridC.gridy = y;
        formPanel.add(j,gridC);

    }

}