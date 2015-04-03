package deliverable;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;

public class InitialFrame {

    // This class contains majority of the code that is used when viewing the GUI and branches off to other classes when
    // we need to get the logic computed 
    // All of the global variables that are used in the main functionality of our GUI
    private JFrame frame;
    private JTextField txtDamage;
    private JTextField searchTXT;
    private JTextField txtHP;
    private JTextField txtHL;
    private JTextField txtPassiveName;
    private JTextField txtAD;
    private JTextField txtADL;
    private JTextField txtQName;
    private JTextField txtQEffect;
    private JTextField txtASL;
    private JTextField txtWName;
    private JTextField txtWEffect;
    private JTextField txtAS;
    private JTextField txtAR;
    private JTextField txtARL;
    private JTextField txtEName;
    private JTextField txtEEffect;
    private JTextField txtMR;
    private JTextField txtRName;
    private JTextField txtSpeed;
    private JTextField txtMRL;
    private JTextField txtRange;
    private JTextField txtItemSearch;

    private char separator = File.separatorChar;

    // All of the global variables that are used in the main functionality of our GUI
    private JTextField txHP;
    private JTextField txHL;
    private JTextField txAD;
    private JTextField txAS;
    private JTextField txAR;
    private JTextField txMR;
    private JTextField txSpeed;
    private JTextField txRange;
    private JTextField txPassiveName;
    private JTextField c1item1;
    private JTextField c1item3;
    private JTextField c1item5;
    private JTextField c1item2;
    private JTextField c1item4;
    private JTextField c1item6;
    private JTextField c2item1;
    private JTextField c2item2;
    private JTextField c2item3;
    private JTextField c2item4;
    private JTextField c2item5;
    private JTextField c2item6;
    private JTextField champOne;
    private JTextField champTwo;

    private SearchChampion aChampion = new SearchChampion();
    private SearchItem aItem = new SearchItem();

    // The main function that in turn runs all of the code
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {

                    // Setting the frame visible to the user
                    InitialFrame window = new InitialFrame();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // Just a constructor method that will automatically run when the class is called 
    public InitialFrame() {
        initialize();
    }

    // This method contains all of the panels and there buttons, fields and labels 
    private void initialize() {

        // Creating an instance of JFrame 
        frame = new JFrame();
        frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 13));
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setForeground(Color.WHITE);
        frame.getContentPane().setForeground(Color.BLUE);
        frame.setBounds(100, 100, 1200, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        // The following is called when we need to show or grab pictures 
        String folder = System.getProperty("user.dir");
        Image champImg = new ImageIcon(folder + separator + "bin" + separator + "champImg.png")
                .getImage();
        Image itemImg = new ImageIcon(folder + separator + "bin" + separator + "itemImg.png").getImage();
        Image damageImg = new ImageIcon(folder + separator + "bin" + separator + "damageImg.png")
                .getImage();
        Image img = new ImageIcon(folder + separator + "bin" + separator + "banner.png").getImage();
        Image backimg = new ImageIcon(folder + separator + "bin" + separator + "back.png").getImage();

        // Setting up the panel for the item compare, champion compare, and damage calculator
        final JPanel itemPanel = new JPanel();
        itemPanel.setBackground(Color.WHITE);
        itemPanel.setBounds(0, 0, 1184, 661);
        frame.getContentPane().add(itemPanel);
        final JPanel champPanel = new JPanel();
        champPanel.setBackground(Color.WHITE);
        champPanel.setBounds(0, 0, 1184, 661);
        frame.getContentPane().add(champPanel);
        final JPanel damagePanel = new JPanel();
        damagePanel.setBackground(Color.WHITE);
        damagePanel.setBounds(0, 0, 1184, 661);
        frame.getContentPane().add(damagePanel);
        final JPanel InitialPanel = new JPanel();
        InitialPanel.setBackground(Color.WHITE);
        InitialPanel.setBounds(0, 0, 1184, 661);
        frame.getContentPane().add(InitialPanel);

        //Setting all of the panels visibility to false except for the initial panel
        damagePanel.setVisible(false);
        champPanel.setVisible(false);
        InitialPanel.setVisible(true);
        itemPanel.setVisible(false);

        // The following code is now the code for the item panel
        // This is a button when clicked returns us to the inital panel from the item panel 
        JButton itemPanelBACKButton = new JButton("");
        itemPanelBACKButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                // Swapping visiblities 
                InitialPanel.setVisible(true);
                itemPanel.setVisible(false);
            }
        });

        // Setting the layout and the parameters for the back button
        itemPanel.setLayout(null);
        itemPanelBACKButton.setBounds(0, 0, 237, 85);
        itemPanelBACKButton.setIcon(new ImageIcon(backimg));
        itemPanel.add(itemPanelBACKButton);

        // This button just refreshed the itemPanel that we are currently on 
        JButton itemPanelITEMButton = new JButton("");
        itemPanelITEMButton.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                itemPanel.setVisible(true);
            }
        });

        // Setting up the color for the buttons 
        itemPanelITEMButton.setBackground(Color.WHITE);
        itemPanelITEMButton.setForeground(Color.WHITE);
        itemPanelITEMButton.setBounds(0, 100, 80, 95);
        itemPanelITEMButton.setIcon(new ImageIcon(itemImg));
        itemPanel.add(itemPanelITEMButton);

        // This button is switching the panels from the Item to the Champion panel 
        JButton itemPanelCHAMPButton = new JButton("");
        itemPanelCHAMPButton.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {

                // Swapping visibilities 
                itemPanel.setVisible(false);
                champPanel.setVisible(true);

            }
        });

        // Finalizing the parameters for the champion panel button
        itemPanelCHAMPButton.setBackground(Color.WHITE);
        itemPanelCHAMPButton.setBounds(0, 250, 80, 95);
        itemPanelCHAMPButton.setIcon(new ImageIcon(champImg));
        itemPanel.add(itemPanelCHAMPButton);

        // Button that is used to switch from the item panel to the damage panel 
        JButton itemPanelDAMAGEButton = new JButton("");
        itemPanelDAMAGEButton.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                // Swapping visibilities 
                itemPanel.setVisible(false);
                damagePanel.setVisible(true);
            }
        });

        // Finalizing the parameters of the damage button
        itemPanelDAMAGEButton.setBackground(Color.WHITE);
        itemPanelDAMAGEButton.setBounds(0, 400, 80, 95);
        itemPanelDAMAGEButton.setIcon(new ImageIcon(damageImg));
        itemPanel.add(itemPanelDAMAGEButton);

        // The text field that is used to receive input from the user through the gui
        // This input is the name of the item they wish to view 
        txtItemSearch = new JTextField();
        txtItemSearch.setBounds(300, 115, 230, 40);
        itemPanel.add(txtItemSearch);
        txtItemSearch.setColumns(10);

        final JLabel lblItemName = new JLabel("");
        lblItemName.setBounds(700, 115, 180, 40);
        itemPanel.add(lblItemName);

        // This is the search button, when clicked it calls Champion to rigoursly look through the CSV of champions 
        JButton searchButton = new JButton("Search");
        searchButton.addMouseListener(new MouseAdapter() {
            JLabel picLabel = new JLabel("");

            public void mouseClicked(MouseEvent e) {

                String checkText = txtItemSearch.getText();
                txtItemSearch.setText("");
                Item item = aItem.getItem(checkText);
                // A check to see if the item returns a null from champion to stop any pointer errors 

                if (!(item == null)) {

                    // Else they set the lblItemName to the found item name and display the stats on the GUI
                    lblItemName.setText(item.getName());
                    picLabel.setBounds(1000, 115, 64, 64);
                    picLabel.setIcon(new ImageIcon(item.picLocation()));
                    itemPanel.add(picLabel);

                    String[] stats = item.getStats();

                    txHL.setText(Math.round(Double.parseDouble(stats[2])) + "");
                    txAD.setText(Math.round(Double.parseDouble(stats[3])) + "");
                    txAS.setText(Math.round(Double.parseDouble(stats[5])) + "");
                    txAR.setText(Math.round(Double.parseDouble(stats[7])) + "");
                    txMR.setText(Math.round(Double.parseDouble(stats[9])) + "");
                    txSpeed.setText(Math.round(Double.parseDouble(stats[11])) + "");

                }

                // refreshes to display the image
                itemPanel.setVisible(false);
                itemPanel.setVisible(true);
            }
        });
        searchButton.setBounds(548, 124, 89, 23);
        itemPanel.add(searchButton);

        JLabel itemHL = new JLabel();
        JLabel itemAD = new JLabel();
        JLabel itemAS = new JLabel();
        JLabel itemAR = new JLabel();
        JLabel itemMR = new JLabel();
        JLabel itemMS = new JLabel();
        JLabel itemP = new JLabel();

        // Just setting up the parameters for the labels defined above 
        itemHL.setText("Health Gain");
        itemHL.setBounds(289, 365, 87, 20);

        itemAD.setText("Attack Damage");
        itemAD.setBounds(439, 365, 87, 20);

        itemAS.setText("Attack Speed");
        itemAS.setBounds(589, 365, 87, 20);

        itemAR.setText("Armor");
        itemAR.setBounds(739, 365, 87, 20);

        itemMR.setText("Magic Resist");
        itemMR.setBounds(889, 365, 87, 20);

        itemMS.setText("Speed");
        itemMS.setBounds(1039, 365, 87, 20);

        // Adding said labels to the item panel
        itemPanel.add(itemHL);
        itemPanel.add(itemAD);
        itemPanel.add(itemAS);
        itemPanel.add(itemAR);
        itemPanel.add(itemMR);
        itemPanel.add(itemMS);
        itemPanel.add(itemP);

        // Creating new text fields for the user to view, basically shows what stats go where 
        txHL = new JTextField();

        txHL.setBounds(289, 382, 87, 20);
        itemPanel.add(txHL);
        txHL.setColumns(10);

        txAD = new JTextField();
        txAD.setBounds(439, 382, 87, 20);
        itemPanel.add(txAD);
        txAD.setColumns(10);

        txAS = new JTextField();
        txAS.setBounds(589, 382, 87, 20);
        itemPanel.add(txAS);
        txAS.setColumns(10);

        txAR = new JTextField();
        txAR.setBounds(739, 382, 87, 20);
        itemPanel.add(txAR);
        txAR.setColumns(10);

        txMR = new JTextField();
        txMR.setBounds(889, 382, 87, 20);
        itemPanel.add(txMR);
        txMR.setColumns(10);

        txSpeed = new JTextField();
        txSpeed.setBounds(1039, 382, 87, 20);
        itemPanel.add(txSpeed);
        txSpeed.setColumns(10);

        // The button that is used when the user wants to compare the current item to that of another
        JButton compareButton = new JButton("Compare");
        compareButton.addMouseListener(new MouseAdapter() {

            // Calls the ItemCompare class to calculate the logic for a given item
            public void mouseClicked(MouseEvent e) {
                if (!(aItem.getItem(lblItemName.getText()) == null)) {
                    ItemCompare aCompare = new ItemCompare(aItem.getItem(lblItemName.getText()));
                    aCompare.setVisible(true);
                }
                // Setting the visibility of the frame to be true

            }
        });

        compareButton.setBounds(700, 256, 117, 33);
        itemPanel.add(compareButton);

        // Now we are entering the code that is used for the champion panel 
        // This button would take us back to the initial panel from damage panel
        JButton champPanelBACKButton = new JButton("");
        champPanelBACKButton.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                InitialPanel.setVisible(true);
                champPanel.setVisible(false);
                // Swapping visibilities 
            }
        });

        champPanelBACKButton.setBackground(Color.WHITE);
        champPanelBACKButton.setBounds(0, 0, 237, 85);

        // Setting the back buttons image 
        champPanel.setLayout(null);
        champPanelBACKButton.setIcon(new ImageIcon(backimg));
        champPanel.add(champPanelBACKButton);

        // This button is just to refresh the champion panel page
        JButton champPanelCHAMPButton = new JButton("");
        champPanelCHAMPButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                champPanel.setVisible(true);

            }
        });

        champPanelCHAMPButton.setBackground(Color.WHITE);
        champPanelCHAMPButton.setForeground(Color.WHITE);
        champPanelCHAMPButton.setBounds(0, 250, 80, 95);
        champPanelCHAMPButton.setIcon(new ImageIcon(champImg));
        champPanel.add(champPanelCHAMPButton);

        // This button is used to switch from the champion panel to the item panel
        JButton champPanelITEMButton = new JButton("");
        champPanelITEMButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                champPanel.setVisible(false);
                itemPanel.setVisible(true);

            }
        });
        champPanelITEMButton.setBackground(Color.WHITE);
        champPanelITEMButton.setBounds(0, 100, 80, 95);
        champPanelITEMButton.setIcon(new ImageIcon(itemImg));
        champPanel.add(champPanelITEMButton);

        // This button is used to switch from the champion panel to the damage panel
        JButton champPanelDAMAGEButton = new JButton("");
        champPanelDAMAGEButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                champPanel.setVisible(false);
                damagePanel.setVisible(true);
            }
        });
        champPanelDAMAGEButton.setBackground(Color.WHITE);
        champPanelDAMAGEButton.setBounds(0, 400, 80, 95);
        champPanelDAMAGEButton.setIcon(new ImageIcon(damageImg));
        champPanel.add(champPanelDAMAGEButton);

        // Creating JLabel instances
        final JLabel nameLabel = new JLabel("");
        nameLabel.setBounds(700, 115, 180, 40);
        champPanel.add(nameLabel);

        // The text field that will be used by the user to retrieve the champion they wish to view
        searchTXT = new JTextField();
        searchTXT.setBounds(300, 115, 230, 40);
        champPanel.add(searchTXT);
        searchTXT.setColumns(10);

        // The button that handles the search functionality
        JButton search = new JButton("Search");
        search.addMouseListener(new MouseAdapter() {
            JLabel pictureLabel = new JLabel("");

            public void mouseClicked(MouseEvent arg0) {

                String checkText = searchTXT.getText();
                searchTXT.setText("");
                Champion champ = aChampion.getChampion(checkText);
                // Checks to make sure that the champions name recieved from Champion is not a null 
                if (!(champ == null)) {

                    // if it is not that than we can show the champion name along with its picture and stats
                    nameLabel.setText(champ.getName());
                    pictureLabel.setBounds(1000, 115, 174, 275);
                    pictureLabel.setIcon(new ImageIcon(champ.picLocation()));
                    champPanel.add(pictureLabel);

                    // Setting the text fields to show the appropriate output 
                    String[] stats = champ.getStats();
                    txtHP.setText(stats[1]);
                    txtHL.setText(stats[2]);
                    txtAD.setText(stats[3]);
                    txtADL.setText(stats[4]);
                    txtAS.setText(stats[5]);
                    txtASL.setText(stats[6]);
                    txtAR.setText(stats[7]);
                    txtARL.setText(stats[8]);
                    txtMR.setText(stats[9]);
                    txtMRL.setText(stats[10]);
                    txtSpeed.setText(stats[11]);
                    txtRange.setText(stats[12]);
                }

                // refreshes to display the image
                champPanel.setVisible(false);
                champPanel.setVisible(true);
            }
        });

        // The creating of the labels we use to display the content of the champion
        search.setBounds(548, 124, 89, 23);
        champPanel.add(search);

        JLabel labelHP = new JLabel();
        JLabel labelHL = new JLabel();
        JLabel labelAD = new JLabel();
        JLabel labelADL = new JLabel();
        JLabel labelAS = new JLabel();
        JLabel labelASL = new JLabel();
        JLabel labelAR = new JLabel();
        JLabel labelARL = new JLabel();
        JLabel labelMR = new JLabel();
        JLabel labelMRL = new JLabel();
        JLabel labelMS = new JLabel();
        JLabel labelRange = new JLabel();
        JLabel labelP = new JLabel();
        JLabel labelQ = new JLabel();
        JLabel labelW = new JLabel();
        JLabel labelE = new JLabel();
        JLabel labelR = new JLabel();

        // Setting each labels text
        labelHP.setText("Base Health");
        labelHP.setBounds(289, 365, 87, 20);

        labelHL.setText("Health Gain");
        labelHL.setBounds(289, 419, 87, 20);

        labelAD.setText("Attack Damage");
        labelAD.setBounds(439, 365, 87, 20);

        labelADL.setText("AD Gain");
        labelADL.setBounds(439, 419, 87, 20);

        labelAS.setText("Attack Speed");
        labelAS.setBounds(589, 365, 87, 20);

        labelASL.setText("AS Gain");
        labelASL.setBounds(589, 419, 87, 20);

        labelAR.setText("Armor");
        labelAR.setBounds(739, 365, 87, 20);

        labelARL.setText("Armor Gain");
        labelARL.setBounds(739, 419, 87, 20);

        labelMR.setText("Magic Resist");
        labelMR.setBounds(889, 365, 87, 20);

        labelMRL.setText("MR Gain");
        labelMRL.setBounds(889, 419, 87, 20);

        labelMS.setText("Speed");
        labelMS.setBounds(1039, 365, 87, 20);

        labelRange.setText("Attack Range");
        labelRange.setBounds(1039, 419, 87, 20);

        // Attaching said labels to the panel
        champPanel.add(labelHP);
        champPanel.add(labelHL);
        champPanel.add(labelAD);
        champPanel.add(labelADL);
        champPanel.add(labelAS);
        champPanel.add(labelASL);
        champPanel.add(labelAR);
        champPanel.add(labelARL);
        champPanel.add(labelMR);
        champPanel.add(labelMRL);
        champPanel.add(labelMS);
        champPanel.add(labelRange);

        // the comments between  each field show what stat is being set
        txtHP = new JTextField();
        // txtHP.setText("Base Health\r\n");
        txtHP.setBounds(289, 382, 87, 20);
        champPanel.add(txtHP);
        txtHP.setColumns(10);

        txtHL = new JTextField();
        // txtHL.setText("Health Gain");
        txtHL.setBounds(289, 436, 87, 20);
        champPanel.add(txtHL);
        txtHL.setColumns(10);

        txtAD = new JTextField();
        // txtAD.setText("Attack Damage");
        txtAD.setBounds(439, 382, 87, 20);
        champPanel.add(txtAD);
        txtAD.setColumns(10);

        txtADL = new JTextField();
        // txtADL.setText("AD Gain");
        txtADL.setBounds(439, 436, 87, 20);
        champPanel.add(txtADL);
        txtADL.setColumns(10);

        txtASL = new JTextField();
        // txtASL.setText("AS Gain");
        txtASL.setBounds(589, 436, 87, 20);
        champPanel.add(txtASL);
        txtASL.setColumns(10);

        txtAS = new JTextField();
        // txtAS.setText("Attack Speed\r\n");
        txtAS.setBounds(589, 382, 87, 20);
        champPanel.add(txtAS);
        txtAS.setColumns(10);

        txtAR = new JTextField();
        // txtAR.setText("Armor\r\n");
        txtAR.setBounds(739, 382, 87, 20);
        champPanel.add(txtAR);
        txtAR.setColumns(10);

        txtARL = new JTextField();
        // txtARL.setText("Armor Gain");
        txtARL.setBounds(739, 436, 87, 20);
        champPanel.add(txtARL);
        txtARL.setColumns(10);
        txtMR = new JTextField();
        // txtMR.setText("Magic Resist");
        txtMR.setBounds(889, 382, 87, 20);
        champPanel.add(txtMR);
        txtMR.setColumns(10);

        txtSpeed = new JTextField();
        // txtSpeed.setText("Speed");
        txtSpeed.setBounds(1039, 382, 87, 20);
        champPanel.add(txtSpeed);
        txtSpeed.setColumns(10);

        txtMRL = new JTextField();
        // txtMRL.setText("MR Gain");
        txtMRL.setBounds(889, 436, 87, 20);
        champPanel.add(txtMRL);
        txtMRL.setColumns(10);

        txtRange = new JTextField();
        // txtRange.setText("Range");
        txtRange.setBounds(1039, 436, 87, 20);
        champPanel.add(txtRange);
        txtRange.setColumns(10);

        // The compare button that will pop open a new frame that can serach for another champion and compare the their stats
        JButton btnNewButton_1 = new JButton("Compare");
        btnNewButton_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                // Calling the ChampionCompare frame and setting it visible
                if (!(aChampion.getChampion(nameLabel.getText()) == null)) {
                    ChampionCompare aCompare = new ChampionCompare(aChampion.getChampion(nameLabel.getText()));
                    aCompare.setVisible(true);
                }
            }
        });

        btnNewButton_1.setBounds(700, 256, 117, 33);
        champPanel.add(btnNewButton_1);

        // Swapping visibilities
        InitialPanel.setVisible(true);

        damagePanel.setVisible(false);

        damagePanel.setLayout(null);

        // The back button that will return us to the Initial panel
        JButton damagePanelBACKButton = new JButton("");
        damagePanelBACKButton.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {

                // Swapping Visibilities 
                InitialPanel.setVisible(true);
                damagePanel.setVisible(false);
            }
        });

        damagePanelBACKButton.setBackground(Color.WHITE);
        damagePanelBACKButton.setBounds(0, 0, 237, 85);

        damagePanel.setLayout(null);
        damagePanelBACKButton.setIcon(new ImageIcon(backimg));
        damagePanel.add(damagePanelBACKButton);

        // This button will switch the panel from the damage to the champion panel
        JButton damagePanelCHAMPButton = new JButton("");
        damagePanelCHAMPButton.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                // Swapping visibilities 
                damagePanel.setVisible(false);
                champPanel.setVisible(true);

            }
        });
        damagePanelCHAMPButton.setBackground(Color.WHITE);
        damagePanelCHAMPButton.setForeground(Color.WHITE);
        damagePanelCHAMPButton.setBounds(0, 250, 80, 95);
        damagePanelCHAMPButton.setIcon(new ImageIcon(champImg));
        damagePanel.add(damagePanelCHAMPButton);

        // This button will swap panels from the damage panel to the item panel
        JButton damagePanelITEMButton = new JButton("");
        damagePanelITEMButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Swapping panels
                damagePanel.setVisible(false);
                itemPanel.setVisible(true);
            }
        });
        damagePanelITEMButton.setBackground(Color.WHITE);
        damagePanelITEMButton.setBounds(0, 100, 80, 95);
        damagePanelITEMButton.setIcon(new ImageIcon(itemImg));
        damagePanel.add(damagePanelITEMButton);

        // This button will refresh the current damage panel
        JButton damagePanelDAMAGEButton = new JButton("");
        damagePanelDAMAGEButton.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                damagePanel.setVisible(true);
            }
        });

        damagePanelDAMAGEButton.setBackground(Color.WHITE);
        damagePanelDAMAGEButton.setBounds(0, 400, 80, 95);
        damagePanelDAMAGEButton.setIcon(new ImageIcon(damageImg));
        damagePanel.add(damagePanelDAMAGEButton);

        // Setting the TextFields for the first chosen champion and its given items
        // Also attaching said panels to the panels
        c1item1 = new JTextField();
        c1item1.setBounds(279, 293, 142, 33);
        damagePanel.add(c1item1);
        c1item1.setColumns(10);

        c1item3 = new JTextField();
        c1item3.setColumns(10);
        c1item3.setBounds(279, 362, 142, 33);
        damagePanel.add(c1item3);

        c1item5 = new JTextField();
        c1item5.setColumns(10);
        c1item5.setBounds(279, 431, 142, 33);
        damagePanel.add(c1item5);

        c1item2 = new JTextField();
        c1item2.setColumns(10);
        c1item2.setBounds(431, 293, 142, 33);
        damagePanel.add(c1item2);

        c1item4 = new JTextField();
        c1item4.setColumns(10);
        c1item4.setBounds(431, 362, 142, 33);
        damagePanel.add(c1item4);

        c1item6 = new JTextField();
        c1item6.setColumns(10);
        c1item6.setBounds(431, 431, 142, 33);
        damagePanel.add(c1item6);

        // Setting the  TextFields for the Second chosen champion and its given items
        // Also attaching said field to the panels
        c2item1 = new JTextField();
        c2item1.setColumns(10);
        c2item1.setBounds(689, 293, 142, 33);
        damagePanel.add(c2item1);

        c2item2 = new JTextField();
        c2item2.setColumns(10);
        c2item2.setBounds(841, 293, 142, 33);
        damagePanel.add(c2item2);

        c2item3 = new JTextField();
        c2item3.setColumns(10);
        c2item3.setBounds(689, 362, 142, 33);
        damagePanel.add(c2item3);

        c2item4 = new JTextField();
        c2item4.setColumns(10);
        c2item4.setBounds(841, 362, 142, 33);
        damagePanel.add(c2item4);

        c2item5 = new JTextField();
        c2item5.setColumns(10);
        c2item5.setBounds(689, 431, 142, 33);
        damagePanel.add(c2item5);

        c2item6 = new JTextField();
        c2item6.setColumns(10);
        c2item6.setBounds(841, 431, 142, 33);
        damagePanel.add(c2item6);

        // Labels to indicate where the user has to input the items for champion 1
        JLabel lblItem = new JLabel("Item 1");
        lblItem.setBounds(279, 268, 46, 14);
        damagePanel.add(lblItem);

        JLabel lblItem_1 = new JLabel("Item 2");
        lblItem_1.setBounds(431, 268, 46, 14);
        damagePanel.add(lblItem_1);

        JLabel lblItem_2 = new JLabel("Item 3");
        lblItem_2.setBounds(279, 337, 46, 14);
        damagePanel.add(lblItem_2);

        JLabel lblItem_3 = new JLabel("Item 5");
        lblItem_3.setBounds(279, 406, 46, 14);
        damagePanel.add(lblItem_3);

        JLabel lblItem_4 = new JLabel("Item 4");
        lblItem_4.setBounds(431, 337, 46, 14);
        damagePanel.add(lblItem_4);

        JLabel lblItem_5 = new JLabel("Item 6");
        lblItem_5.setBounds(431, 406, 46, 14);
        damagePanel.add(lblItem_5);

        // Labels to indicate where the user has to input the items for champion 2
        JLabel label = new JLabel("Item 1");
        label.setBounds(689, 268, 46, 14);
        damagePanel.add(label);

        JLabel label_1 = new JLabel("Item 2");
        label_1.setBounds(841, 268, 46, 14);
        damagePanel.add(label_1);

        JLabel label_2 = new JLabel("Item 3");
        label_2.setBounds(689, 337, 46, 14);
        damagePanel.add(label_2);

        JLabel label_3 = new JLabel("Item 4");
        label_3.setBounds(841, 337, 46, 14);
        damagePanel.add(label_3);

        JLabel label_4 = new JLabel("Item 5");
        label_4.setBounds(689, 406, 46, 14);
        damagePanel.add(label_4);

        JLabel label_5 = new JLabel("Item 6");
        label_5.setBounds(841, 406, 46, 14);
        damagePanel.add(label_5);

        // Indicates which champion was chosen by the user
        JLabel lblChampion = new JLabel("Champion 1");
        lblChampion.setBounds(279, 148, 100, 14);
        damagePanel.add(lblChampion);

        champOne = new JTextField();
        champOne.setColumns(10);
        champOne.setBounds(279, 173, 142, 33);
        damagePanel.add(champOne);

        // Indicates as to what the 2nd champion is 
        JLabel lblChampion_1 = new JLabel("Champion 2");
        lblChampion_1.setBounds(689, 148, 100, 14);
        damagePanel.add(lblChampion_1);

        champTwo = new JTextField();
        champTwo.setColumns(10);
        champTwo.setBounds(689, 173, 142, 33);
        damagePanel.add(champTwo);

        // Creating the GO button that will calculate everything for us
        JButton btnGo = new JButton("GO!!!");
        btnGo.setBounds(1029, 352, 125, 53);
        damagePanel.add(btnGo);

        // The field to choose what the champions lvls are 
        final JTextField champLevel = new JTextField();
        champLevel.setColumns(10);
        champLevel.setBounds(1029, 173, 125, 33);
        damagePanel.add(champLevel);

        final JTextField printer = new JTextField();
        printer.setColumns(10);
        printer.setBounds(279, 541, 704, 30);
        damagePanel.add(printer);

        JLabel lblLevel = new JLabel("Level");
        lblLevel.setBounds(1029, 148, 80, 14);
        damagePanel.add(lblLevel);

        // This action listen for the go button that will calculate their damage
        btnGo.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {

                // Creating instance of the SearchItem and SearchChampion for the calculation
                SearchItem searcher = new SearchItem();
                SearchChampion seeker = new SearchChampion();
                Calculator calc = new Calculator();
                Champion chp1 = seeker.getChampion(champOne.getText());
                Champion chp2 = seeker.getChampion(champTwo.getText());

                // Receiving that item from the fields and placing them in an array
                if (!((chp1 == null) || (chp2 == null))) {
                    int lvl = 1;
                    if (!(champLevel.getText().equals(""))) {
                        lvl = Integer.parseInt(champLevel.getText());
                    }
                    Item[] oneItems = {searcher.getItem(c1item1.getText()), searcher.getItem(c1item2.getText()),
                        searcher.getItem(c1item3.getText()), searcher.getItem(c1item4.getText()),
                        searcher.getItem(c1item5.getText()), searcher.getItem(c1item6.getText())};
                    Item[] twoItems = {searcher.getItem(c2item1.getText()), searcher.getItem(c2item2.getText()),
                        searcher.getItem(c2item3.getText()), searcher.getItem(c2item4.getText()),
                        searcher.getItem(c2item5.getText()), searcher.getItem(c2item6.getText())};

                    // Adding all the AD
                    int ad = 0;
                    for (Item i : oneItems) {
                        if (!(i == null)) {
                            ad += i.getAD();
                        }
                    }
                    // Adding all the Armor
                    int ar = 0;
                    for (Item i : twoItems) {
                        if (!(i == null)) {
                            ar += i.getAR();
                        }
                    }

                    // Receiving the lvl to caluclate the final stat
                    // Showing the damage champion 1 will do to champion 2 to the user through the GUI
                    ad += chp1.getAD(lvl);
                    ar += chp2.getAR(lvl);
                    int damage = Integer.parseInt(Math.round(calc.getPhysicalDamage(0, 1.0, ad, ar, 0, 0, 0, 0)) + "");
                    String line = chp1.getName() + " deals " + damage + " damage to " + chp2.getName() + " with each attack!";
                    printer.setText(line);
                }

                c1item1.setText("");
                c1item2.setText("");
                c1item3.setText("");
                c1item4.setText("");
                c1item5.setText("");
                c1item6.setText("");

                c2item1.setText("");
                c2item2.setText("");
                c2item3.setText("");
                c2item4.setText("");
                c2item5.setText("");
                c2item6.setText("");

                //Refreshing the damage panel 
                damagePanel.setVisible(false);
                damagePanel.setVisible(true);
            }
        });

        // The code that is used to display the initial panel
        InitialPanel.setLayout(null);
        JButton champButton = new JButton("");
        champButton.setBounds(50, 350, 85, 85);
        InitialPanel.add(champButton);

        // This button switches from the initial panel to the champion panel
        champButton.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {

                // Swapping visibilities
                InitialPanel.setVisible(false);
                champPanel.setVisible(true);

            }
        });
        champButton.setFont(new Font("Tahoma", Font.BOLD, 11));
        champButton.setBackground(Color.BLUE);
        champButton.setIcon(new ImageIcon(champImg));
        champButton.setForeground(Color.BLUE);

        // This button switching from the inital panel to the damage panel
        JButton damageButton = new JButton("");
        damageButton.setBounds(50, 500, 85, 85);
        InitialPanel.add(damageButton);
        damageButton.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                // Swapping visibilities

                InitialPanel.setVisible(false);
                damagePanel.setVisible(true);

            }
        });
        damageButton.setBackground(Color.BLUE);
        damageButton.setIcon(new ImageIcon(damageImg));
        damageButton.setForeground(Color.BLUE);

        // This button is responsible for changed from the initial panel to the item panel
        JButton itemButton = new JButton("");
        itemButton.setBounds(50, 200, 85, 85);
        InitialPanel.add(itemButton);

        itemButton.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent arg0) {
                // Swapping visibilities

                InitialPanel.setVisible(false);
                itemPanel.setVisible(true);

            }
        });
        itemButton.setBackground(Color.BLUE);
        itemButton.setIcon(new ImageIcon(itemImg));
        itemButton.setForeground(Color.BLUE);

        JLabel banner = new JLabel("");
        banner.setBounds(360, 0, 512, 205);
        InitialPanel.add(banner);
        banner.setIcon(new ImageIcon(img));

        // Setting the Txt Panels and fonts for each panel for the inital panel
        JTextPane txtpnChampionLibrary = new JTextPane();
        txtpnChampionLibrary.setBounds(200, 375, 120, 50);
        InitialPanel.add(txtpnChampionLibrary);
        txtpnChampionLibrary.setFont(new Font("Sitka Banner", Font.BOLD, 15));
        txtpnChampionLibrary.setText("Champion Library");

        JTextPane txtpnItemLibrary = new JTextPane();
        txtpnItemLibrary.setBounds(200, 225, 120, 50);
        InitialPanel.add(txtpnItemLibrary);
        txtpnItemLibrary.setFont(new Font("Sitka Banner", Font.BOLD, 15));
        txtpnItemLibrary.setText("Item Library");

        JTextPane txtpnDamageCalculator = new JTextPane();
        txtpnDamageCalculator.setBounds(200, 525, 125, 50);
        InitialPanel.add(txtpnDamageCalculator);
        txtpnDamageCalculator.setFont(new Font("Sitka Banner", Font.BOLD, 15));
        txtpnDamageCalculator.setText("Damage Calculator");

    }
}
