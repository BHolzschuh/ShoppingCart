package cop4331.client;

public class Vendor extends User{
    public Vendor(String userName, String password, String name, String answer){
        super(userName, password);
        this.name = name;
        this.answer = answer;
    }

    public String getName(){
        return name;
    }

    public String getAnswer() { return answer; }

    private String name;
    private String answer;
}
