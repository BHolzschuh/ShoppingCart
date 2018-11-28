package cop4331.gui;

import javax.swing.*;
import java.awt.*;

public class LoginView {

    private JPanel logicPanel = new JPanel();
    private JLabel welcomePanel = new JLabel();
    private JPanel formPanel = new JPanel();

    private GridBagConstraints gridC = new GridBagConstraints();

    public LoginView(){

        //logicPanel setup
        logicPanel.setLayout(new BoxLayout(logicPanel,BoxLayout.PAGE_AXIS));
        JLabel label = new JLabel();
        logicPanel.add(label);
        JLabel greetIn = new JLabel("Hey there. Welcome to the shop. Where you can be you.");


        //formPanel setup
        GridBagLayout gl = new GridBagLayout();
        formPanel.setLayout(gl);
        gridC.fill = GridBagConstraints.HORIZONTAL;
        gridC.insets = new Insets(7,7,7,7);


        gridC.gridx = 0;
        gridC.gridy = 0;

        JLabel usr = new JLabel("Username: ");
        formPanel.add(usr,gridC);

        gridC.gridx = 1;
        gridC.gridy = 0;

        JTextField usrForm = new JTextField();
        usrForm.setColumns(10);
        formPanel.add(usrForm,gridC);

        gridC.gridx = 0;
        gridC.gridy = 1;
        JLabel pwd = new JLabel("Password:             ");
        formPanel.add(pwd,gridC);

        gridC.gridx = 1;
        gridC.gridy = 1;
        JPasswordField pwdForm = new JPasswordField();
        pwdForm.setColumns(10);
        formPanel.add(pwdForm,gridC);

        gridC.gridx = 1;
        gridC.gridy = 2;
        JButton loginButton = new JButton("Login");
        formPanel.add(loginButton,gridC);

        //logicPanel.add(greetIn);
        logicPanel.add(formPanel);

    }

    public JPanel getView(){
        return logicPanel;
    }

    public void add(JComponent j, int x, int y){

        gridC.gridx = x;
        gridC.gridy = y;
        formPanel.add(j,gridC);

    }

}