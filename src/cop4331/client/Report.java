package cop4331.client;

import java.io.*;
import java.util.ArrayList;

/**
 * @author Brian Holzschuh
 * A report that calculates the revenues, costs, and profits of items sold
 */
public class Report implements Serializable {

    private static Report instance = null;

    /**
     * Constructs a single instance ArrayList
     * @precondition report.data file exists
     * @postcondition soldItems is initialized
     */
    private Report(){
        soldItems = new ArrayList<>();
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("report.dat"));
            soldItems = (ArrayList<Item>) in.readObject();
        } catch (Exception e){
            System.out.println("Problem with the file.");
            soldItems = new ArrayList<>();
        }
    }

    /**
     * Create instance of report
     * @return instance of report
     * @precondition none
     * @postcondition instance is initialized
     */
    public static Report getInstance(){
        if(instance == null) instance = new Report();
        return instance;
    }

    /**
     * Gets the costs of the items
     * @return costs of items
     * @precondition none
     * @postcondition none
     */
    public double getCost(){
        double costs = 0;
        for(Item item: soldItems){
            costs += (item.getInvoicePrice() * item.getQuantity());
        }
        return costs;
    }

    /**
     * Gets the revenue of items
     * @return revenue of items
     * @precondition none
     * @postcondition none
     */
    public double getRevenue(){
        double revenue = 0;
        for(Item item: soldItems){
            revenue += (item.getSellPrice() * item.getQuantity());
        }
        return revenue;
    }

    /**
     * Gets the profits of items
     * @return profits of items
     * @precondition none
     * @postcondition none
     */
    public double getProfits(){
        return getRevenue() - getCost();
    }

    /**
     * Adds sold items to the report
     * @param item the item sold
     * @precondition soldItems is initialized
     * @postcondition soldItems isn't empty
     */
    public void addItem(Item item){
        for(Item ai: soldItems){
            if(ai.getID() == item.getID()){
                ai.setQuantity(ai.getQuantity() + item.getQuantity());
                updateData();
                return;
            }
        }
        soldItems.add(item);
        updateData();
    }

    /**
     * Writes the current report to the data file
     * @precondition soldItems is initialized
     * @postcondition the data file exists
     */
    public void updateData(){
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("report.dat"));
            out.writeObject(soldItems);
            out.close();
        } catch (Exception e){
            System.out.println("File error");
        }
    }

    ArrayList<Item> soldItems;

}
