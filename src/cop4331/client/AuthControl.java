package cop4331.client;

import cop4331.gui.Screen;

public class AuthControl {


    public AuthControl(Screen sc, AuthModel au){

        //control the view

        //register button
        sc.getRegisterButton().addActionListener(e -> sc.showRegister());

        //register submit
        sc.getRegisterSubmitButton().addActionListener(e -> {

        });

        //login
        sc.getLoginButton().addActionListener(e -> {
            au.getUsers();
            if (au.authenticate(sc.getLoginUserForm().getText().toLowerCase(),sc.getLoginPwdForm().getText())) {
                sc.showShop();
            }
        });


        sc.getRegisterSubmitButton().addActionListener(e ->
        {
            String username = sc.getRegisterUserForm().getText();
            username = username.toLowerCase();
            String password = sc.getRegisterPwdForm().getText();
            username = username.replaceAll("[^A-Za-z0-9]", " ");
            password = password.replaceAll("[^A-Za-z0-9]", " ");
            boolean valid = true;

            if(username.length() < 5 || password.length() < 5) valid = false;

            if(valid) {
                for (char c : username.toCharArray()) {
                    if (c == ' ') {
                        valid = false;
                        break;
                    }
                }
            }
            if(valid){
                for(char c: password.toCharArray()){
                    if(c == ' '){
                        valid = false;
                        break;
                    }
                }
            }
            if(valid){
                if(sc.getRegisterPwdForm().getText().equals(sc.getRegisterPwdConfirmForm().getText())) {
                    if(!au.findUser(username)){
                        au.registerShopper(username, password);
                        au.getUsers();
                        sc.showLogin();
                    }
                    else{
                        System.out.println("Username is taken");
                        sc.getErrorLabel().setText("Username is taken.");
                    }
                }
                else{
                    System.out.println("Passwords don't match");
                    sc.getErrorLabel().setText("Passwords don't match.");
                }
            }
            else{
                System.out.println("Invalid username/password");
                sc.getErrorLabel().setText("Invalid username/password.");
            }

        });

        // Back Button
        sc.getBackButton().addActionListener(e -> sc.showLogin());
    }



}