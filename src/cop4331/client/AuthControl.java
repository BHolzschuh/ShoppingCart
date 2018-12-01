package cop4331.client;

import cop4331.gui.Screen;

public class AuthControl {


    public AuthControl(Screen sc, AuthModel au){

        //control the view

        //register button
        sc.getRegisterButton().addActionListener(e -> sc.showRegister());

        sc.getRegisterButton().addActionListener(e ->
                System.out.println(sc.getRegisterUserForm().getText() +
                        " " + sc.getRegisterPwdForm().getText() +
                        " " + sc.getRegisterPwdConfirmForm())
        );

        //register submit
        sc.getRegisterSubmitButton().addActionListener(e -> {
            au.getUsers();
            System.out.println(sc.getRegisterUserForm().getText() + " " +
                    sc.getRegisterPwdForm().getText() + " " +
                    sc.getRegisterPwdConfirmForm().getText());
            sc.showLogin();
        });

        //login
        sc.getLoginButton().addActionListener(e -> {
            au.getUsers();
            if (au.authenticate(sc.getLoginUserForm().getText(),sc.getLoginPwdForm().getText())) {
                sc.showShop();

            }
        });

        sc.getLoginButton().addActionListener(e ->
                System.out.println(sc.getLoginUserForm().getText() + " " + sc.getLoginPwdForm().getText())
        );

        sc.getRegisterSubmitButton().addActionListener(e ->
        {
            if(sc.getRegisterPwdForm().getText().equals(sc.getRegisterPwdConfirmForm().getText()))
            au.registerShopper(sc.getRegisterUserForm().getText(), sc.getRegisterPwdForm().getText());

        });
        sc.getLoginButton().addActionListener(e -> au.registerShopper(sc.getLoginPwdForm().getText(),sc.getLoginPwdForm().getText()));

        // Back Button
        sc.getBackButton().addActionListener(e -> sc.showLogin());
    }



}