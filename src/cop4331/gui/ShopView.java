package cop4331.gui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * @author Ben Shapiro
 */
public class ShopView {


    private JPanel shopPanel = new JPanel();
    private JPanel itemPanel = new JPanel();
    private JPanel cartPanel = new JPanel();
    private GridBagConstraints gridC = new GridBagConstraints();
    private ArrayList<JLabel> itemNames;
    private ArrayList<JLabel> itemPrice;
    private ArrayList<JLabel> itemQuantity;
    private ArrayList<JLabel> cartItemName;
    private ArrayList<JLabel> cartItemQuantity;
    private ArrayList<JTextField> getQuantities;

    //  private ArrayList<JButton> addButtons;
    private JButton update;
    private JButton checkOut;


    ShopView(){

        shopPanel.setLayout(new BorderLayout());
        GridBagLayout gl = new GridBagLayout();
        itemPanel.setLayout(gl);
        cartPanel.setLayout(gl);
        gridC.fill = GridBagConstraints.HORIZONTAL;
        gridC.insets = new Insets(7,7,7,7);

        JLabel title = new JLabel("You are logged in.");

        itemNames = new ArrayList<>();
        itemPrice = new ArrayList<>();
        itemQuantity = new ArrayList<>();
        getQuantities = new ArrayList<>();

        update = new JButton("add");
        checkOut = new JButton("Check Out Cart");
        checkOut.setBackground(Color.green);
        checkOut.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        checkOut.setOpaque(true);

        addItem(itemPanel,new JLabel("Please make a selection:"),0,0);

        addItem(itemPanel,new JLabel("Item"),0,2);
        addItem(itemPanel,new JLabel("Cost"),1,2);
        addItem(itemPanel,new JLabel("Quantity"),2,2);
        addItem(itemPanel,new JLabel("In Stock"),3,2);

        cartItemName = new ArrayList<>();
        cartItemQuantity = new ArrayList<>();

        addItem(cartPanel,new JLabel("CART"),5,0);
        addItem(cartPanel,new JLabel("Item"),5,2);
        addItem(cartPanel,new JLabel("Quantity"),6,2);

        cartPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        shopPanel.add(title,BorderLayout.NORTH);
        shopPanel.add(itemPanel,BorderLayout.CENTER);
        shopPanel.add(cartPanel,BorderLayout.EAST);
        shopPanel.add(checkOut,BorderLayout.SOUTH);

    }

    public void load(){
        populate();
        itemPanel.revalidate();
    }

    public void fillCart(){

        int i = 3;
        for(JLabel j: cartItemName){
            addItem(cartPanel,j,5,i);
            i++;
        }

        i = 3;
        for(JLabel j: cartItemQuantity){
            addItem(cartPanel,j,6,i);
            i++;
        }
    }


    public void populate(){

        int i = 3;
        for(JLabel j: itemNames){
            getQuantities.add(new JTextField("0"));
            addItem(itemPanel,j,0,i);
            i++;
        }

        i = 3;
        for(JLabel j: itemPrice){
            addItem(itemPanel,j,1,i);
            i++;
        }

        i = 3;
        for(JLabel j: itemQuantity){
            addItem(itemPanel,j,3,i);
            i++;
        }

        addItem(itemPanel,update,2,i);

        i = 3;
        for(JTextField t: getQuantities){

            addItem(itemPanel,t,2,i);
            i++;
        }

    }


    private void addItem(JPanel panel, JComponent j, int x, int y){
        gridC.gridx = x;
        gridC.gridy = y;
        panel.add(j,gridC);
    }


    public JPanel getView(){ return shopPanel; }
    public JPanel getItemPanel() { return itemPanel; }
    public ArrayList<JLabel> getItemNames(){ return itemNames; }
    public ArrayList<JLabel> getItemPrice(){ return itemPrice; }
    public ArrayList<JLabel> getItemQuantity(){ return itemQuantity; }
    public ArrayList<JTextField> getQuantities(){ return getQuantities; }
    public ArrayList<JLabel> getCartItemName(){ return cartItemName; }
    public ArrayList<JLabel> getCartItemQuantity(){ return cartItemQuantity; }
    public JButton updateQuantity(){ return update; }

}