package cop4331.gui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * @author Brian Holzschuh, Ben Shapiro
 */
public class Screen {
    private JPanel panelCont;
    private CardLayout cl;
    private LoginView loginView;
    private RegisterView registerView;
    private ShopView shopView;
    private InventoryView inventoryView;
    private ReportView reportView;
    private AddItemView addItemView;
    private JFrame reportFrame;
    private JFrame addItemFrame;
    private JFrame mainFrame;

    public Screen(){
        loginView = new LoginView();
        registerView = new RegisterView();
        shopView = new ShopView();
        inventoryView = new InventoryView();
        reportView = new ReportView();
        addItemView = new AddItemView();
        panelCont = new JPanel();
        cl = new CardLayout();

        panelCont.setLayout(cl);

        /*
        L = Login Reference
        R = Register Reference
        S = Shop Reference
        I = Inventory Reference
        */
        panelCont.add(loginView.getView(),"L");
        panelCont.add(registerView.getView(),"R");
        panelCont.add(shopView.getView(),"S");
        panelCont.add(inventoryView.getView(),"I");

        //view starts on Login
        cl.show(panelCont,"L");


        mainFrame = new JFrame("Shopping Extravaganza");
        mainFrame.setLocationRelativeTo(null);
        mainFrame.add(panelCont);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    // Panel manipulation
    public void showRegister(){ cl.show(panelCont,"R"); }
    public void showLogin(){ cl.show(panelCont,"L"); }
    public void showShop(){ cl.show(panelCont,"S"); }
    public void showInventory() { cl.show(panelCont,"I"); }

    // Popup Windows
    public void showReportWindow(){
        reportFrame = new JFrame("Report Rundown");
        reportFrame.setLocationRelativeTo(null);
        reportFrame.add(reportView.getView());
        reportFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        reportFrame.pack();
        reportFrame.setVisible(true);
    }

    public void showAddItemWindow(){
        addItemFrame = new JFrame("Add Item");
        addItemFrame.setLocationRelativeTo(null);
        addItemFrame.add(addItemView.getView());
        addItemFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addItemFrame.pack();
        addItemFrame.setVisible(true);
    }

    public void closeReportFrame() { reportFrame.dispose(); }
    public void closeAddItemFrame() { addItemFrame.dispose(); }

    // Login getters
    public JButton getRegisterButton(){ return loginView.getRegisterButton(); }
    public JButton getLoginButton(){ return loginView.getLoginButton(); }
    public JTextField getLoginUserForm() { return loginView.getUserForm(); }
    public JTextField getLoginPwdForm() { return loginView.getPwdForm(); }

    // Register getters
    public JButton getRegisterSubmitButton(){ return registerView.getSubmitButton(); }
    public JButton getRegisterBackButton() { return registerView.getBackButton(); }
    public JTextField getRegisterUserForm() { return registerView.getUserForm(); }
    public JTextField getRegisterPwdForm() { return registerView.getPwdForm(); }
    public JTextField getRegisterPwdConfirmForm() { return registerView.getPwdConfirmForm(); }
    public JLabel getErrorLabel() { return registerView.getErrorLabel(); }

    // Inventory getters
    public ArrayList<JButton> getInventoryDeleteButtons(){ return inventoryView.getDeleteButtons(); }
    public ArrayList<JTextField> getInventoryQuantityFields() { return inventoryView.getQuantityFields(); }
    public JButton getInventoryReportButton() { return inventoryView.getReportButton(); }
    public JButton getInventoryAddButton() { return inventoryView.getAddButton(); }
    public JButton getInventoryUpdateButton() { return inventoryView.getUpdateButton(); }
    public ArrayList<JPanel> getInventoryRows() { return inventoryView.getRowPanels(); }
    public void inventoryAddRefresh() {
        inventoryView.addRefresh();
        mainFrame.pack();
    }
    public void inventoryDeleteRefresh(int index){
        inventoryView.deleteRefresh(index);
        mainFrame.pack();
    }

    // Report getters
    public JLabel getReportCosts() { return reportView.getCosts(); }
    public JLabel getReportProfits() { return reportView.getProfits(); }
    public JLabel getReportRevenue() { return reportView.getRevenue(); }
    public JButton getReportOkButton() { return reportView.getOkButton(); }

    // AddItem getters
    public JButton getAddItemBackButton() { return addItemView.getBackButton(); }
    public JButton getAddItemSubmitButton() { return addItemView.getSubmitButton(); }
    public JTextField getItemNameField() { return addItemView.getNameField(); }
    public JTextField getItemSellCostField() { return addItemView.getSellCostField(); }
    public JTextField getItemInvoiceCostField() { return addItemView.getInvoiceCostField(); }
    public JTextField getItemQuantityField() { return addItemView.getQuantityField(); }
    public JTextArea getItemDescriptionField() { return addItemView.getDescriptionField(); }

    public JPanel getItemPanel() { return shopView.getItemPanel(); }
    public ArrayList<JLabel> getItemNames(){ return shopView.getItemNames(); }
    public ArrayList<JLabel> getItemPrice(){ return shopView.getItemPrice(); }
    public ArrayList<JLabel> getItemQuantity(){ return shopView.getItemQuantity(); }
    public ArrayList<JTextField> getQuantityUpdate(){ return shopView.getQuantities(); }
    public JButton addRequest(){ return shopView.updateQuantity(); }
    public ArrayList<JLabel> getCartItemName(){ return shopView.getCartItemName(); }
    public ArrayList<JLabel> getCartItemQuantity(){ return shopView.getCartItemQuantity(); }
    public void loadDisplay() {
        shopView.load();
        mainFrame.pack();
    }
    public void fillCart() {
        shopView.fillCart();
        mainFrame.pack();
    }

}
