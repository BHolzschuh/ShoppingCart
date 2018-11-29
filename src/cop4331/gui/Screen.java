package cop4331.gui;

import javax.swing.*;
import java.awt.*;

public class Screen {
    private JPanel panelCont;
    private CardLayout cl;
    private LoginView loginView;
    private RegisterView registerView;

    public Screen(){
        loginView = new LoginView();
        registerView = new RegisterView();
        panelCont = new JPanel();
        cl = new CardLayout();

        panelCont.setLayout(cl);

        //L = Login Reference
        //R = Register Reference
        panelCont.add(loginView.getView(),"L");
        panelCont.add(registerView.getView(),"R");

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

    public JButton getSubmitButton(){
        return registerView.getSubmitButton();
    }

    public void ShowRegister(){
        cl.show(panelCont,"R");
    }

    public void SubmitLogin(){
        cl.show(panelCont,"L");
    }

}
