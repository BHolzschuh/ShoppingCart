package cop4331.client;

import cop4331.gui.Screen;

public class AuthControl {

    private final Screen screen;
    private final AuthModel auth;

    public AuthControl(Screen sc, AuthModel au){
        screen = sc;
        auth = au;

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
            System.out.println(sc.getRegisterUserForm().getText() + " " +
                    sc.getRegisterPwdForm().getText() + " " +
                    sc.getRegisterPwdConfirmForm().getText());
            sc.showLogin();
        });

        //login
        sc.getLoginButton().addActionListener(e -> {
            if (au.authenticate(sc.getLoginUserForm().getText()))
                sc.showShop();
        });

        sc.getLoginButton().addActionListener(e ->
                System.out.println(sc.getLoginUserForm().getText() + " " + sc.getLoginPwdForm().getText())
        );

        sc.getLoginButton().addActionListener(e -> au.registerShopper(sc.getLoginPwdForm().getText(),sc.getLoginPwdForm().getText()));

        // Back Button
        sc.getBackButton().addActionListener(e -> sc.showLogin());
    }



}