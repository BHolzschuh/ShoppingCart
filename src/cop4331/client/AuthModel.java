package cop4331.client;

import java.io.*;
import java.util.Hashtable;
import java.util.Scanner;

/**
 * @author Ben Shapiro
 */
public class AuthModel {

    private Hashtable<String, User> readUsers;
    private boolean vendorFlag;

    /**
     * Constructs the model
     */
    public AuthModel() {

        vendorFlag = false;

        try {

            ObjectInputStream in = new ObjectInputStream(new FileInputStream("users.dat"));

            readUsers = (Hashtable<String, User>) in.readObject();
            in.close();

        }catch(FileNotFoundException e) {System.out.println("File not found.");
        }catch (Exception e) { System.out.println("Problem with the file.");
        }
    }

    /**
     * Prints the users in the system
     */
    public void getUsers() {
        System.out.println(readUsers);
    }

    /**
     * Determines if the user is a vendor
     * @return if vendor or not
     */
    public boolean getVendorFlag(){ return vendorFlag; }


    /**
     * Determines if a user is in the system
     * @param username unique username
     * @return whether or not in system
     */
    public boolean findUser(String username) {
        if (readUsers.containsKey(username)) return true;
        return false;
    }

    /**
     * Registers a user in the system
     * @param name username
     * @param pw password
     */
    public void registerShopper(String name, String pw) {

        Shopper customer = new Shopper(name, pw);
        readUsers.put(customer.getUserName(), customer);

        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("users.dat"));
            out.writeObject(readUsers);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Authenticates a user in the system
     * @param n username
     * @param pw password
     * @return whether or not they are a user
     */
    public User authenticate(String n, String pw) {

        if(findUser(n) && pw.equals(readUsers.get(n).getPassword())) {
            if(readUsers.get(n).getClass().getSimpleName().equals("Shopper"))
                return readUsers.get(n);
            else if(readUsers.get(n).getClass().getSimpleName().equals("Vendor"))
                System.out.println("vendor login detected");
                vendorFlag = true;
        }

        return null;

    }

}
