package cop4331.client;

import java.io.*;
import java.util.Hashtable;
import java.util.Scanner;

public class AuthModel {

    private Hashtable<String, User> readUsers;

    public AuthModel() {

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

    public void findUser() {

        System.out.println("Check if user in system: ");
        Scanner input = new Scanner(System.in);
        User current = null;
        boolean notFound = true;
        while (notFound) {
            String username = input.next();
            if (readUsers.containsKey(username)) {
                System.out.println("Found a user");
                current = readUsers.get(username);
                notFound = false;
            } else {
                System.out.println("No user");
            }
        }
        System.out.println(current);

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

    public boolean authenticate(String n, String pw) {return readUsers.containsKey(n) && pw.equals(readUsers.get(n).getPassword()); }

}

/*
    public void register(String name, String pw ){

        Customer registerer = new Customer(name,(pw.hashCode()*7)%100000);

        try {
            PrintWriter out = new PrintWriter("customers.txt");
            out.write(name + " " + (pw.hashCode()*7)%100000);
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }

        customers.add(registerer);

    }

    */


