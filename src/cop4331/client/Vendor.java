package cop4331.client;

public class Vendor extends User{
    public Vendor(String userName, String password, String name){
        super(userName, password);
        this.name = name;
    }

    public String getName(){
        return name;
    }

    private String name;
}
