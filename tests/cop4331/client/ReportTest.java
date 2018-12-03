package cop4331.client;

import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * @author Brian Holzschuh
 * Tester for report class
 */
public class ReportTest {

    @Test
    public void getCost() {
        System.out.println("getCost test");
        ArrayList<Item> test;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("report.dat"));
            test = (ArrayList<Item>) in.readObject();
        } catch (Exception e){
            System.out.println("Problem with the file.");
            test = new ArrayList<>();
        }

        double cost = 0;
        for(Item item: test){
            cost += item.getInvoicePrice() * item.getQuantity();
        }
        Report testReport = Report.getInstance();
        Assert.assertEquals(testReport.getCost(), cost, 0.0);
    }

    @Test
    public void getRevenue() {
        System.out.println("getRevenue test");
        ArrayList<Item> test;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("report.dat"));
            test = (ArrayList<Item>) in.readObject();
        } catch (Exception e){
            System.out.println("Problem with the file.");
            test = new ArrayList<>();
        }

        double revenue = 0;
        for(Item item: test){
            revenue += item.getSellPrice() * item.getQuantity();
        }
        Report testReport = Report.getInstance();
        Assert.assertEquals(testReport.getRevenue(), revenue, 0.0);
    }

    @Test
    public void getProfits() {
        System.out.println("getProfit test");
        ArrayList<Item> test;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("report.dat"));
            test = (ArrayList<Item>) in.readObject();
        } catch (Exception e){
            System.out.println("Problem with the file.");
            test = new ArrayList<>();
        }

        double profit = 0;
        for(Item item: test){
            profit += (item.getSellPrice() - item.getInvoicePrice()) * item.getQuantity();
        }
        Report testReport = Report.getInstance();
        Assert.assertEquals(testReport.getProfits(), profit, 0.01);
    }

    @Test
    public void addItem() {
        System.out.println("addItem test");
        ArrayList<Item> test;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("report.dat"));
            test = (ArrayList<Item>) in.readObject();
        } catch (Exception e){
            System.out.println("Problem with the file.");
            test = new ArrayList<>();
        }

        Report testReport = Report.getInstance();

        Product testProduct = new Product(20, "testy", 120, 20, "$$$", 3);
        test.add(testProduct);
        testReport.addItem(testProduct);

        double cost = 0;
        for(Item item: test){
            cost += item.getInvoicePrice() * item.getQuantity();
        }

        Assert.assertEquals(testReport.getCost(), cost, 0.01);
    }
}