package cop4331.gui;

import javax.swing.*;
import java.awt.*;

public class RegisterView {

    private GridBagConstraints gridC;
    private JPanel registerPanel;
    private JPanel gridPanel;
    private JButton backButton;
    private JButton submitButton;
    private JTextField usrForm;
    private JTextField pwdForm;
    private JTextField pwdConfirmForm;
    private JLabel error;

    public RegisterView(){

        registerPanel = new JPanel();
        registerPanel.setLayout(new BorderLayout());

        gridPanel = new JPanel();
        gridPanel.setLayout(new GridBagLayout());
        gridC = new GridBagConstraints();
        gridC.fill = GridBagConstraints.HORIZONTAL;
        gridC.insets = new Insets(7,7,7,7);

        // Username Label
        JLabel usr = new JLabel("Set username: ");
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

        // Back Button
        backButton = new JButton("Cancel");
        add(backButton, 0, 3);

        // Submit Button
        submitButton = new JButton("Submit");
        add(submitButton, 1, 3);

        registerPanel.add(gridPanel, BorderLayout.CENTER);

        // Error label
        error = new JLabel(" ");
        error.setHorizontalAlignment(JLabel.CENTER);
        registerPanel.add(error, BorderLayout.SOUTH);
    }

    public JPanel getView(){ return registerPanel; }

    public JButton getSubmitButton() { return submitButton; }

    public JButton getBackButton() { return backButton; }

    public JTextField getUserForm() { return usrForm; }

    public JTextField getPwdForm() { return pwdForm; }

    public JTextField getPwdConfirmForm() { return pwdConfirmForm; }

    public JLabel getErrorLabel() { return error; }

    public void add(JComponent j, int x, int y){
        gridC.gridx = x;
        gridC.gridy = y;
        gridPanel.add(j,gridC);
    }
}
