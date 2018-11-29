package cop4331.client;

import cop4331.gui.Screen;

public class AuthControl {

    private final Screen screen;

    public AuthControl(Screen sc){
        screen = sc;

        //control current view
        sc.getRegisterButton().addActionListener(e -> sc.ShowRegister());
        sc.getSubmitButton().addActionListener(e -> {
            System.out.println(sc.getRegisterUserForm().getText() + " " +
                    sc.getRegisterPwdForm().getText() + " " +
                    sc.getRegisterPwdConfirmForm().getText());
            sc.SubmitLogin();
        });
        sc.getLoginButton().addActionListener(e ->
                System.out.println(sc.getLoginUserForm().getText() + " " + sc.getLoginPwdForm().getText())
        );
    }



}