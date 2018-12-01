package cop4331.gui;

import javax.swing.*;
import java.awt.*;

public class Screen {
    private JPanel panelCont;
    private CardLayout cl;
    private LoginView loginView;
    private RegisterView registerView;
    private ShopView shopView;

    public Screen(){
        loginView = new LoginView();
        registerView = new RegisterView();
        shopView = new ShopView();
        panelCont = new JPanel();
        cl = new CardLayout();

        panelCont.setLayout(cl);

        /*
        L = Login Reference
        R = Register Reference
        S = Shop Reference
        */
        panelCont.add(loginView.getView(),"L");
        panelCont.add(registerView.getView(),"R");
        panelCont.add(shopView.getView(),"S");

        //view starts on Login
        cl.show(panelCont,"L");

        JFrame frame = new JFrame("Shopping Extravaganza");
        frame.add(panelCont);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public JButton getRegisterButton(){
        return loginView.getRegisterButton();
    }

    public JButton getLoginButton(){
        return loginView.getLoginButton();
    }

    public JButton getRegisterSubmitButton(){
        return registerView.getSubmitButton();
    }

    public JButton getBackButton() { return registerView.getBackButton(); }

    public void showRegister(){
        cl.show(panelCont,"R");
    }

    public void showLogin(){
        cl.show(panelCont,"L");
    }

    public void showShop(){
        cl.show(panelCont,"S");
    }

    public JTextField getLoginUserForm() { return loginView.getUserForm(); }

    public JTextField getLoginPwdForm() { return loginView.getPwdForm(); }

    public JTextField getRegisterUserForm() { return registerView.getUserForm(); }

    public JTextField getRegisterPwdForm() { return registerView.getPwdForm(); }

    public JTextField getRegisterPwdConfirmForm() { return registerView.getPwdConfirmForm(); }

    public JLabel getErrorLabel() { return registerView.getErrorLabel(); }

}
