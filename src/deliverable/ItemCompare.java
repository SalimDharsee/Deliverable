package deliverable;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class ItemCompare extends JFrame {

    private JPanel contentPane;
    private JTextField ItemSearch;
    private JTextField ItemLevel;
    private JLabel champOne = new JLabel();
    private JLabel champTwo = new JLabel();

    private final Item comparingTo;

    /**
     * Launch the application.
     * @param c
     */
    /*
     * public static void main(String[] args) { EventQueue.invokeLater(new
     * Runnable() { public void run() { try { ItemCompare frame = new
     * ItemCompare(); frame.setVisible(true); } catch (Exception e) {
     * e.printStackTrace(); } } }); }
     */
    public ItemCompare(Item c) {
        comparingTo = c;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 545, 332);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton closeButton = new JButton("X");
        closeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
            }

        });
        closeButton.setBounds(0, 0, 50, 22);
        contentPane.add(closeButton);

        ItemSearch = new JTextField();
        ItemSearch.setBounds(54, 0, 95, 22);
        contentPane.add(ItemSearch);
        ItemSearch.setColumns(10);

        JLabel champHeader = new JLabel("Item Name");
        champHeader.setBounds(54, 10, 150, 50);
        contentPane.add(champHeader);

        final JLabel ItemLabel = new JLabel("");
        ItemLabel.setBounds(360, 57, 103, 18);
        contentPane.add(ItemLabel);

        JButton searchButton = new JButton("GO");
        searchButton.addMouseListener(new MouseAdapter() {
            SearchItem aItem = new SearchItem();
            JLabel pictureLabel = new JLabel("");

            @Override
            public void mouseClicked(MouseEvent arg0) {

                String checkText = ItemSearch.getText();
                ItemSearch.setText("");
                Item champ = aItem.getItem(checkText);
                if (!(champ == null)) {
                    ItemLabel.setText(champ.getName());
                    pictureLabel.setBounds(360, 10, 174, 275);
                    pictureLabel.setIcon(new ImageIcon(champ.picLocation()));
                    contentPane.add(pictureLabel);

                    compareChamps(champ);
                }

                contentPane.setVisible(false);
                contentPane.setVisible(true);
            }
        });
        searchButton.setBounds(260, 0, 60, 22);
        contentPane.add(searchButton);

        contentPane.setVisible(false);
        contentPane.setVisible(true);
    }

    private void compareChamps(Item champ) {
        champOne.setText(champ.getName());
        champTwo.setText(comparingTo.getName());

        JLabel HP = new JLabel("HP");
        JLabel AD = new JLabel("AD");
        JLabel AS = new JLabel("AS");
        JLabel AR = new JLabel("AR");
        JLabel MR = new JLabel("MR");
        JLabel MS = new JLabel("MS");

        String[] tempOne = champ.getStats();
        String[] tempTwo = champ.getStats();//comparingTo.getStats();

        JTextField HP1 = new JTextField(Math.round(Double.parseDouble(tempOne[2])) + "");
        JTextField AD1 = new JTextField(Math.round(Double.parseDouble(tempOne[3])) + "");
        JTextField AS1 = new JTextField(Math.round(Double.parseDouble(tempOne[5])) + "");
        JTextField AR1 = new JTextField(Math.round(Double.parseDouble(tempOne[7])) + "");
        JTextField MR1 = new JTextField(Math.round(Double.parseDouble(tempOne[9])) + "");
        JTextField MS1 = new JTextField(Math.round(Double.parseDouble(tempOne[13])) + "");

        JTextField HP2 = new JTextField(Math.round(Double.parseDouble(tempTwo[2])) + "");
        JTextField AD2 = new JTextField(Math.round(Double.parseDouble(tempTwo[3])) + "");
        JTextField AS2 = new JTextField(Math.round(Double.parseDouble(tempTwo[5])) + "");
        JTextField AR2 = new JTextField(Math.round(Double.parseDouble(tempTwo[7])) + "");
        JTextField MR2 = new JTextField(Math.round(Double.parseDouble(tempTwo[9])) + "");
        JTextField MS2 = new JTextField(Math.round(Double.parseDouble(tempTwo[13])) + "");

        champOne.setBounds(75, 50, 50, 20);
        contentPane.add(champOne);
        champTwo.setBounds(175, 50, 50, 20);
        contentPane.add(champTwo);

        HP1.setBounds(75, 70, 50, 20);
        contentPane.add(HP1);
        HP2.setBounds(175, 70, 50, 20);
        contentPane.add(HP2);
        HP.setBounds(20, 75, 30, 10);
        contentPane.add(HP);
        AD1.setBounds(75, 90, 50, 20);
        contentPane.add(AD1);
        AD2.setBounds(175, 90, 50, 20);
        contentPane.add(AD2);
        AD.setBounds(20, 90, 50, 20);
        contentPane.add(AD);
        AS1.setBounds(75, 110, 50, 20);
        contentPane.add(AS1);
        AS2.setBounds(175, 110, 50, 20);
        contentPane.add(AS2);
        AS.setBounds(20, 110, 50, 20);
        contentPane.add(AS);
        AR1.setBounds(75, 130, 50, 20);
        contentPane.add(AR1);
        AR2.setBounds(175, 130, 50, 20);
        contentPane.add(AR2);
        AR.setBounds(20, 130, 50, 20);
        contentPane.add(AR);
        MR1.setBounds(75, 150, 50, 20);
        contentPane.add(MR1);
        MR2.setBounds(175, 150, 50, 20);
        contentPane.add(MR2);
        MR.setBounds(20, 150, 50, 20);
        contentPane.add(MR);
        MS1.setBounds(75, 170, 50, 20);
        contentPane.add(MS1);
        MS2.setBounds(175, 170, 50, 20);
        contentPane.add(MS2);
        MS.setBounds(20, 170, 50, 20);
        contentPane.add(MS);

        contentPane.setVisible(false);
        contentPane.setVisible(true);
    }
}
