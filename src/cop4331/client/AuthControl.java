package cop4331.client;

import cop4331.gui.Screen;

import javax.swing.*;

public class AuthControl {

    private JPanel panelCont = new JPanel();
    private Screen screen;

    public AuthControl(Screen sc){
        screen = sc;

        //control current view
        sc.getRegisterButton().addActionListener(e -> sc.ShowRegister());
        sc.getSubmitButton().addActionListener(e -> sc.SubmitLogin());
        sc.getLoginButton().addActionListener(e -> System.out.println(sc.getUserForm().getText() + " " + sc.getPwdForm().getText()));
    }



}