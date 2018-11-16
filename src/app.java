import cop4331.client.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class app {
    public static void main(String[] args){
        Shopper brian = new Shopper("brian", "holzschuh");
        Vendor ben = new Vendor("ben", "shapiro");
        User[] users = new User[]{brian, ben};
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("test.dat"));
            out.writeObject(users);
            out.close();
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("test.dat"));
            User[] readUsers = (User[]) in.readObject();
            in.close();
            for(User user: readUsers){
                System.out.println(user.getUserName());
                System.out.println(user.getPassword());
                System.out.println(" ");
            }
        }
        catch (Exception e){
            System.out.println("Problem with the file");
        }
    }
}
