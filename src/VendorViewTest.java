import cop4331.gui.AddItemView;
import cop4331.gui.InventoryView;
import cop4331.gui.ReportView;

import javax.swing.*;

public class VendorViewTest {
    public static void main(String[] args){
        InventoryView view1 = new InventoryView();
        JFrame frame1 = new JFrame("Shopping Extravaganza");
        frame1.add(view1.getView());
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.pack();
        frame1.setVisible(true);

        AddItemView view2 = new AddItemView();
        JFrame frame2 = new JFrame("Add");
        frame2.add(view2.getView());
        frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame2.pack();
        frame2.setVisible(true);

        ReportView view3 = new ReportView();
        JFrame frame3 = new JFrame("Report");
        frame3.add(view3.getView());
        frame3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame3.pack();
        frame3.setVisible(true);
    }
}
