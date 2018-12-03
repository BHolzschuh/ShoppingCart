package cop4331.client;

import java.io.Serializable;

/**
 * @author Brian Holzschuh
 * An abstract User class
 */
public abstract class User implements Serializable {

    /**
     * Constructs a user
     * @param userName the username for the user
     * @param password the password for the user
     */
    public User(String userName, String password){
        this.userName = userName;
        this.password = password;
    }

    /**
     * Gets the string representation of a user
     * @return string representation of user
     */
    public String toString(){
        return "username: " + userName + ", password: " + password;
    }

    /**
     * Gets the username
     * @return username
     */
    public String getUserName(){
        return userName;
    }

    /**
     * Gets the password
     * @return password
     */
    public String getPassword(){
        return password;
    }

    private String userName;
    private String password;

}
