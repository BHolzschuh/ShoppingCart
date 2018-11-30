package cop4331.gui;

import javax.swing.*;
import java.awt.*;

public class ShopView {


    private JPanel shopPanel = new JPanel();
    private GridBagConstraints gridC = new GridBagConstraints();


    ShopView(){

        GridBagLayout gl = new GridBagLayout();
        shopPanel.setLayout(gl);
        gridC.fill = GridBagConstraints.HORIZONTAL;
        gridC.insets = new Insets(7,7,7,7);

        // Username Label
        JLabel usr = new JLabel("You made it. Welcome to the shop!!!!!!");
        gridC.gridx = 0;
        gridC.gridy = 0;
        shopPanel.add(usr,gridC);

    }


    public JPanel getView(){ return shopPanel; }
}

