package cop4331.client;

import java.io.Serializable;

public class User implements Serializable {

    public User(String userName, String password){
        this.userName = userName;
        this.password = password;
    }

    public String toString(){
        return "username: " + userName + ", password: " + password;
    }

    public String getUserName(){
        return userName;
    }

    public String getPassword(){
        return password;
    }

    private String userName;
    private String password;

}
