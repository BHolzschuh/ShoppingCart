package cop4331.gui;

import javax.swing.*;
import java.awt.*;

public class RegisterView {

    GridBagLayout gl = new GridBagLayout();
    private GridBagConstraints gridC = new GridBagConstraints();
    private JPanel registerPanel = new JPanel();

    public RegisterView(){

        GridBagLayout gl = new GridBagLayout();
        registerPanel.setLayout(gl);
        gridC.fill = GridBagConstraints.HORIZONTAL;
        gridC.insets = new Insets(7,7,7,7);

        gridC.gridx = 0;
        gridC.gridy = 0;

        JLabel usr = new JLabel(" Set username: ");
        registerPanel.add(usr,gridC);

        gridC.gridx = 1;
        gridC.gridy = 0;

        JTextField usrForm = new JTextField();
        usrForm.setColumns(10);
        registerPanel.add(usrForm,gridC);

        gridC.gridx = 0;
        gridC.gridy = 1;
        JLabel pwd = new JLabel("Set password: ");

        registerPanel.add(pwd,gridC);

        gridC.gridx = 1;
        gridC.gridy = 1;
        JPasswordField pwdForm = new JPasswordField();
        pwdForm.setColumns(10);
        registerPanel.add(pwdForm,gridC);

        gridC.gridx = 0;
        gridC.gridy = 2;
        JLabel pwdConfirmTF = new JLabel("Confirm password");
        registerPanel.add(pwdConfirmTF,gridC);

        gridC.gridx = 1;
        gridC.gridy = 2;
        JPasswordField pwdConfirmForm = new JPasswordField();
        pwdConfirmForm.setColumns(10);
        registerPanel.add(pwdConfirmForm,gridC);
    }

   public JPanel getView(){
        return registerPanel;
    }

   public void add(JComponent j, int x, int y){

        gridC.gridx = x;
        gridC.gridy = y;
        registerPanel.add(j,gridC);
    }

}
