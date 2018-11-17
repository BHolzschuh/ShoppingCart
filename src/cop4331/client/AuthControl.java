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

        JButton buttonOne = new JButton("Register");
       // login.add(buttonOne,0,2);

        JButton buttonTwo = new JButton("Submit");
        register.add(buttonTwo,0,3);

        panelCont.setLayout(cl);

        //L = Login Reference
        //R = Register Reference
        panelCont.add(login.getView(),"L");
        panelCont.add(register.getView(),"R");

        //view starts on Login
        cl.show(panelCont,"L");

        //control current view
        buttonOne.addActionListener(e -> cl.show(panelCont,"R"));
        buttonTwo.addActionListener(e -> cl.show(panelCont,"L"));

        JFrame frame = new JFrame("Shopping Extravaganza");
        frame.add(panelCont);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }



}