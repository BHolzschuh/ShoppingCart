package cop4331.gui;

import javax.swing.*;
import java.awt.*;

public class RegisterView {

    GridBagLayout gl = new GridBagLayout();
    private GridBagConstraints gridC = new GridBagConstraints();
    private JPanel registerPanel = new JPanel();
    private JButton submitButton;

    public RegisterView(){

        GridBagLayout gl = new GridBagLayout();
        registerPanel.setLayout(gl);
        gridC.fill = GridBagConstraints.HORIZONTAL;
        gridC.insets = new Insets(7,7,7,7);

        // Username Label
        JLabel usr = new JLabel(" Set username: ");
        add(usr, 0, 0);

        // Username Field
        JTextField usrForm = new JTextField();
        usrForm.setColumns(10);
        add(usrForm, 1, 0);

        // Password Label
        JLabel pwd = new JLabel("Set password: ");
        add(pwd, 0, 1);

        // Password Field
        JPasswordField pwdForm = new JPasswordField();
        pwdForm.setColumns(10);
        add(pwdForm, 1, 1);

        // Confirm Password Label
        JLabel pwdConfirmTF = new JLabel("Confirm password");
        add(pwdConfirmTF, 0, 2);

        // Confirm Password Field
        JPasswordField pwdConfirmForm = new JPasswordField();
        pwdConfirmForm.setColumns(10);
        add(pwdConfirmForm, 1, 2);

        // Submit Button
        submitButton = new JButton("Submit");
        add(submitButton, 0, 3);
    }

   public JPanel getView(){
        return registerPanel;
    }

    public JButton getSubmitButton() { return submitButton; }

   public void add(JComponent j, int x, int y){

        gridC.gridx = x;
        gridC.gridy = y;
        registerPanel.add(j,gridC);
    }

}
