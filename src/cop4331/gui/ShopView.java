package cop4331.gui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ShopView {


    private JPanel shopPanel = new JPanel();
    private JPanel itemPanel = new JPanel();
    private GridBagConstraints gridC = new GridBagConstraints();
    private ArrayList<JLabel> itemNames;
    private ArrayList<JLabel> itemPrice;
    private ArrayList<JLabel> itemQuantity;
    private JButton update;
    private JButton checkOut;


    ShopView(){

        shopPanel.setLayout(new BorderLayout());
        GridBagLayout gl = new GridBagLayout();
        itemPanel.setLayout(gl);
        gridC.fill = GridBagConstraints.HORIZONTAL;
        gridC.insets = new Insets(7,7,7,7);

        JLabel title = new JLabel("You are logged in.");

        itemNames = new ArrayList<>();
        itemPrice = new ArrayList<>();
        itemQuantity = new ArrayList<>();

        update = new JButton("update");
        checkOut = new JButton("Check Out Cart");
        checkOut.setBackground(Color.green);
        checkOut.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        checkOut.setOpaque(true);

        addItem(new JLabel("Please make a selection:"),0,0);

        addItem(new JLabel("Item"),0,2);
        addItem(new JLabel("Cost"),1,2);
        addItem(new JLabel("Quantity"),2,2);
        addItem(new JLabel("In Stock"),3,2);

        shopPanel.add(title,BorderLayout.NORTH);
        shopPanel.add(itemPanel,BorderLayout.CENTER);
        shopPanel.add(checkOut,BorderLayout.SOUTH);

    }

    public void load(){
        populate();
        itemPanel.revalidate();
    }

    public void populate(){

        int i = 3;
        for(JLabel j: itemNames){
            addItem(j,0,i);
            i++;
        }

        i = 3;
        for(JLabel j: itemPrice){
            addItem(j,1,i);
            i++;
        }

        i = 3;
        for(JLabel j: itemQuantity){
            addItem(j,3,i);
            i++;
        }

        addItem(new JButton("add"),2,i);



        while(i>2){
            addItem(new JTextField("0"),2,i);
            i--;
        }


    }


    private void addItem(JComponent j, int x, int y){
        gridC.gridx = x;
        gridC.gridy = y;
        itemPanel.add(j,gridC);
    }


    public JPanel getView(){ return shopPanel; }
    public JPanel getItemPanel() { return itemPanel; }
    public ArrayList<JLabel> getItemNames(){ return itemNames; }
    public ArrayList<JLabel> getItemPrice(){ return itemPrice; }
    public ArrayList<JLabel> getItemQuantity(){ return itemQuantity; }

}