import cop4331.client.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Hashtable;
import java.util.Scanner;

public class app {
    public static void main(String[] args) {
        /*
        Shopper brian = new Shopper("brian", "holzschuh");
        Vendor ben = new Vendor("ben", "shapiro");
        Hashtable<String, User> users = new Hashtable();
        users.put(brian.getUserName(), brian);
        users.put(ben.getUserName(), ben);
        */
        try {
            /*
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("test.dat"));
            out.writeObject(users);
            out.close();
            */
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("test.dat"));
            Hashtable<String, User> readUsers = (Hashtable<String, User>) in.readObject();
            in.close();

            System.out.println(readUsers);

            System.out.println("Check if user in system: ");
            Scanner input = new Scanner(System.in);
            User current = null;
            boolean notFound = true;
            while(notFound){
                String username = input.next();
                if(readUsers.containsKey(username)){
                    System.out.println("Found a user");
                    current = readUsers.get(username);
                    notFound = false;
                }
                else{
                    System.out.println("No user");
                }
            }
            System.out.println(current);

        } catch (Exception e) {
            System.out.println("Problem with the file");
        }
    }
}
