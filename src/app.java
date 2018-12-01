import cop4331.client.*;
import cop4331.gui.LoginView;
import cop4331.gui.RegisterView;
import cop4331.gui.Screen;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Hashtable;
import java.util.Scanner;

public class app {
    public static void main(String[] args) {

        Screen sc = new Screen();
        AuthModel au = new AuthModel();
        AuthControl start = new AuthControl(sc,au);
       //  au.getUsers();

        /*
        Shopper brian = new Shopper("brian", "holzschuh");
        Vendor ben = new Vendor("ben", "shapiro");
        Hashtable<String, User> users = new Hashtable();
        users.put(brian.getUserName(), brian);
        users.put(ben.getUserName(), ben);
        */


        /*
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("test.dat"));
        out.writeObject(users);
        out.close();
        */


    }
}
