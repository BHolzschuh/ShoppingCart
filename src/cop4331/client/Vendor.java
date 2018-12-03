package cop4331.client;

/**
 * @author Brian Holzschuh
 * Vendor subclass of User
 */
public class Vendor extends User{
    /**
     * Constructs a Vendor
     * @param userName vendors username
     * @param password vendors password
     * @param name vendors name
     * @param answer vendors security answer
     */
    public Vendor(String userName, String password, String name, String answer){
        super(userName, password);
        this.name = name;
        this.answer = answer;
    }

    /**
     * Gets the vendors name
     * @return name
     */
    public String getName(){
        return name;
    }

    /**
     * Gets the security answer
     * @return answer
     */
    public String getAnswer() { return answer; }

    private String name;
    private String answer;
}
