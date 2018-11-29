package cop4331.gui;

import javax.swing.*;
import java.awt.*;

public class RegisterView {

    GridBagLayout gl = new GridBagLayout();
    private GridBagConstraints gridC = new GridBagConstraints();
    private JPanel registerPanel;
    private JButton submitButton;
    private JTextField usrForm;
    private JTextField pwdForm;
    private JTextField pwdConfirmForm;

    public RegisterView(){

        GridBagLayout gl = new GridBagLayout();
        registerPanel = new JPanel();
        registerPanel.setLayout(gl);
        gridC.fill = GridBagConstraints.HORIZONTAL;
        gridC.insets = new Insets(7,7,7,7);

        // Username Label
        JLabel usr = new JLabel(" Set username: ");
        add(usr, 0, 0);

        // Username Field
        usrForm = new JTextField();
        usrForm.setColumns(10);
        add(usrForm, 1, 0);

        // Password Label
        JLabel pwd = new JLabel("Set password: ");
        add(pwd, 0, 1);

        // Password Field
        pwdForm = new JPasswordField();
        pwdForm.setColumns(10);
        add(pwdForm, 1, 1);

        // Confirm Password Label
        JLabel pwdConfirmTF = new JLabel("Confirm password");
        add(pwdConfirmTF, 0, 2);

        // Confirm Password Field
        pwdConfirmForm = new JPasswordField();
        pwdConfirmForm.setColumns(10);
        add(pwdConfirmForm, 1, 2);

        // Submit Button
        submitButton = new JButton("Submit");
        add(submitButton, 0, 3);
    }

    public JPanel getView(){ return registerPanel; }

    public JButton getSubmitButton() { return submitButton; }

    public JTextField getUserForm() { return usrForm; }

    public JTextField getPwdForm() { return pwdForm; }

    public JTextField getPwdConfirmForm() { return pwdConfirmForm; }

    public void add(JComponent j, int x, int y){
        gridC.gridx = x;
        gridC.gridy = y;
        registerPanel.add(j,gridC);
    }
}
