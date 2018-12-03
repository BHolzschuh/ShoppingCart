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


    public void getUsers() {
        System.out.println(readUsers);
    }

    public boolean getVendorFlag(){ return vendorFlag; }


    public boolean findUser(String username) {
        if (readUsers.containsKey(username)) return true;
        return false;
    }


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
