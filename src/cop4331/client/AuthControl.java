package cop4331.client;


import cop4331.gui.LoginView;
import cop4331.gui.RegisterView;

import javax.swing.*;
import java.awt.*;

public class AuthControl {

    private JPanel panelCont = new JPanel();
    private CardLayout cl = new CardLayout();

    public AuthControl(){

        LoginView login = new LoginView();
        RegisterView register = new RegisterView();

        JButton registerButton = login.getRegisterButton();
        JButton submitButton = register.getSubmitButton();

        panelCont.setLayout(cl);

        //L = Login Reference
        //R = Register Reference
        panelCont.add(login.getView(),"L");
        panelCont.add(register.getView(),"R");

        //view starts on Login
        cl.show(panelCont,"L");

        //control current view
        registerButton.addActionListener(e -> cl.show(panelCont,"R"));
        submitButton.addActionListener(e -> cl.show(panelCont,"L"));

        JFrame frame = new JFrame("Shopping Extravaganza");
        frame.add(panelCont);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }



}