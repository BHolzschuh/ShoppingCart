package cop4331.client;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.util.Hashtable;
import java.util.Scanner;

public class AuthModel {

    private Hashtable<String, User> readUsers;


    public AuthModel(){

        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("test.dat"));
            readUsers = (Hashtable<String, User>) in.readObject();
            in.close();

        }catch (Exception e) {
            System.out.println("Problem with the file");
        }



    }


    public void getUsers(){System.out.println(readUsers);}

    public void findUser(){

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

    }
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


