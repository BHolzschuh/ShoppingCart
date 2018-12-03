package cop4331.gui;

import javax.swing.*;
import java.awt.*;

/**
 * @author Ben Shapiro
 */
public class LoginView {

    private JPanel loginPanel;
    private JPanel formPanel;
    private JButton registerButton;
    private JButton loginButton;
    private JTextField usrForm;
    private JTextField pwdForm;

    private GridBagConstraints gridC;

    public LoginView(){

        //loginPanel setup
        loginPanel = new JPanel();
        loginPanel.setLayout(new BorderLayout());
        JLabel greetIn = new JLabel("Welcome to the shop, where you can be you");
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout());
        titlePanel.add(greetIn);
        loginPanel.add(titlePanel, BorderLayout.NORTH);

        //formPanel setup
        formPanel = new JPanel();
        formPanel.setLayout(new GridBagLayout());
        gridC = new GridBagConstraints();
        gridC.fill = GridBagConstraints.HORIZONTAL;
        gridC.insets = new Insets(7,7,7,7);
        gridC.weightx = 1.0;

        // Username Label
        JLabel usr = new JLabel("Username: ");
        add(usr, 0, 0);

        // Username Field
        usrForm = new JTextField();
        usrForm.setColumns(10);
        add(usrForm, 1, 0);

        // Password Label
        JLabel pwd = new JLabel("Password: ");
        add(pwd, 0, 1);

        // Password Field
        pwdForm = new JPasswordField();
        pwdForm.setColumns(10);
        add(pwdForm, 1, 1);

        // Register Button
        registerButton = new JButton("Register");
        add(registerButton, 0, 2);

        // Login Button
        loginButton = new JButton("Login");
        add(loginButton, 1, 2);

        //logicPanel.add(greetIn);
        loginPanel.add(formPanel, BorderLayout.CENTER);

    }

    public JPanel getView(){
        return loginPanel;
    }

    public JButton getLoginButton() { return loginButton; }

    public JButton getRegisterButton() { return  registerButton; }

    public JTextField getUserForm() { return usrForm; }

    public JTextField getPwdForm() { return pwdForm; }

    private void add(JComponent j, int x, int y){
        gridC.gridx = x;
        gridC.gridy = y;
        formPanel.add(j,gridC);
    }

}