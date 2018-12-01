package cop4331.gui;

import javax.swing.*;
import java.awt.*;

public class ReportView {

    private JPanel reportPanel;
    private JPanel centerPanel;
    private GridBagConstraints c;
    private JLabel costs;
    private JLabel profits;
    private JLabel revenue;
    private JButton okButton;

    public ReportView(){
        reportPanel = new JPanel();
        reportPanel.setLayout(new BorderLayout());

        // Title Panel
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout());
        JLabel title = new JLabel("Weekly Rundown");
        titlePanel.add(title);
        reportPanel.add(titlePanel, BorderLayout.NORTH);

        centerPanel = new JPanel();
        centerPanel.setLayout(new GridBagLayout());

        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(15,15,15,15);

        // Costs labels
        JLabel costsLabel = new JLabel("Costs: ");
        add(costsLabel, 0, 0);
        costs = new JLabel("$20");
        add(costs, 1, 0);

        // Profits labels
        JLabel profitsLabel = new JLabel("Profits: ");
        add(profitsLabel, 0, 1);
        profits = new JLabel("$100");
        add(profits, 1, 1);

        // Revenue Labels
        JLabel revenueLabel = new JLabel("Revenue: ");
        add(revenueLabel, 0, 2);
        revenue = new JLabel("$80");
        add(revenue, 1, 2);

        // Ok button
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());
        okButton = new JButton("Exit");
        bottomPanel.add(okButton);

        reportPanel.add(centerPanel, BorderLayout.CENTER);
        reportPanel.add(bottomPanel, BorderLayout.SOUTH);

        reportPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

    }

    public JPanel getView(){ return reportPanel; }

    public JLabel getCosts() { return costs; }
    public JLabel getProfits() { return profits; }
    public JLabel getRevenue() { return revenue; }
    public JButton getOkButton() { return okButton; }

    public void add(JComponent comp, int x, int y){
        c.gridx = x;
        c.gridy = y;
        centerPanel.add(comp, c);
    }

}
