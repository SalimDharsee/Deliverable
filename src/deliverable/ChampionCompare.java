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

@SuppressWarnings("serial")
public class ChampionCompare extends JFrame {

	// This classes goal is to take in and compute all the champion compare logic throw from the GUI
	
	// Initializes the variables that are used for the championCompare Interface 
	
    private JPanel contentPane;
    private JTextField championSearch;
    private JTextField championLevel;
    private JLabel champOne = new JLabel();
    private JLabel champTwo = new JLabel();
    
    private Champion comparingTo;
   
    // This constructor  method is used to create the instance of the interface that is displayed to the user
    public ChampionCompare(Champion c) {
    	
        comparingTo = c;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Setting the size of the compare frame 
        
        setBounds(100, 100, 545, 332);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        // The action listener which is used by the button "x" to close the current frame 
        
        JButton closeButton = new JButton("X");
        closeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
            }

        });
        
        // Attaching the close button 
        closeButton.setBounds(0, 0, 50, 22);
        contentPane.add(closeButton);

        // Creating text fields for the input of the champions name 
        championSearch = new JTextField();
        championSearch.setBounds(54, 0, 95, 22);
        contentPane.add(championSearch);
        championSearch.setColumns(10);
        
        // Creating a text field for the input of the champions level 
        championLevel = new JTextField();
        championLevel.setBounds(156, 0, 90, 22);
        contentPane.add(championLevel);
        championLevel.setColumns(10);
        
        //Attaching labels/headers to the champion compare frame  
        JLabel champHeader = new JLabel("Champion Name");
        champHeader.setBounds(54, 10, 150, 50);
        contentPane.add(champHeader);
        
      //Attaching labels/headers to the champion compare frame  
        JLabel champLevel = new JLabel("Champion Level");
        champLevel.setBounds(155, 10, 150, 50);
        contentPane.add(champLevel);

      //Attaching labels/headers to the champion compare frame  
        final JLabel championLabel = new JLabel("");
        championLabel.setBounds(360, 57, 103, 18);
        contentPane.add(championLabel);
        
        // The button that is responsible for executing the comparison code 
        JButton searchButton = new JButton("GO");
        searchButton.addMouseListener(new MouseAdapter() {
        	
            SearchChampion aChampion = new SearchChampion();
            JLabel pictureLabel = new JLabel("");
     
            public void mouseClicked(MouseEvent arg0) {
            	// The actions performed after the button is clicked, mostly calls methods from the SearchChampion class

                String checkText = championSearch.getText();
                int level = Integer.parseInt(championLevel.getText());
                championLevel.setText("");
                championSearch.setText("");
                Champion champ = aChampion.getChampion(checkText);
                championLabel.setText(champ.getName());
                pictureLabel.setBounds(360, 10, 174, 275);
                pictureLabel.setIcon(new ImageIcon(champ.picLocation()));
                contentPane.add(pictureLabel);
                
                compareChamps(champ, level);
                
                // Refreshing the frame so the picture is visible 
                
                contentPane.setVisible(false);
                contentPane.setVisible(true);
            }
        });
        
        // Setting the parameters for the buttons and attaching it to the frame 
        searchButton.setBounds(260, 0, 60, 22);
        contentPane.add(searchButton);

     // Refreshing the frame
        contentPane.setVisible(false);
        contentPane.setVisible(true);
    }
    
    // This method contains most of the logic that is being used when we are comparing champions to one another 
    
    private void compareChamps(Champion champ, int lvl){
    	// getting the two champion names from the program 
        champOne.setText(champ.getName());
        champTwo.setText(comparingTo.getName());
        
        // Setting up the lables 
        JLabel HP = new JLabel("HP");
        JLabel AD = new JLabel("AD");
        JLabel AS = new JLabel("AS");
        JLabel AR = new JLabel("AR");
        JLabel MR = new JLabel("MR");
        JLabel MS = new JLabel("MS");
        JLabel R = new JLabel("R");
        
        // Getting the stats from the accessor methods 
        String[] tempOne = champ.getStats();
        String[] tempTwo = comparingTo.getStats();
        
        // Removing the Champion name from the array so we only have to deal with the doubles 
        double[] statsOne = new double[tempOne.length-1];
        double[] statsTwo = new double[tempTwo.length-1];
        
        for(int i = 1; i < tempOne.length; i++){
            statsOne[i-1] = Double.parseDouble(tempOne[i]);
        }
        for(int i = 1; i < tempTwo.length; i++){
            statsTwo[i-1] = Double.parseDouble(tempTwo[i]);
        }
        
        // The logic for the champion attack speed, since it changes based on a percent instead of a base amout 
        
        String tempAS1 = (statsOne[4]*(((statsOne[5]*lvl) + 100)/100)) + "";
        String tempAS2 = (statsTwo[4]*(((statsTwo[5]*lvl) + 100)/100)) + "";
        tempAS1 = tempAS1.substring(0, 5);
        tempAS2 = tempAS2.substring(0, 5);
        
        // The rest of the stats that use base amounts or the stats that do note change
        // The stats are changed based on the champion level that was given by the user
        // For Champion 1 
        JTextField HP1 = new JTextField((Math.round((statsOne[0]) + ((statsOne[1]*(lvl-1))))) + "");
        JTextField AD1 = new JTextField((Math.round((statsOne[2]) + ((statsOne[3]*(lvl-1))))) + "");
        JTextField AS1 = new JTextField(tempAS1);
        JTextField AR1 = new JTextField((Math.round((statsOne[6]) + ((statsOne[7]*(lvl-1))))) + "");
        JTextField MR1 = new JTextField((Math.round((statsOne[8]) + ((statsOne[9]*(lvl-1))))) + "");
        JTextField MS1 = new JTextField(Math.round(statsOne[10]) + "");
        JTextField R1 = new JTextField(Math.round(statsOne[11]) + "");
        
        // For champion 2 
        JTextField HP2 = new JTextField((Math.round((statsTwo[0]) + ((statsTwo[1]*(lvl-1))))) + "");
        JTextField AD2 = new JTextField((Math.round((statsTwo[2]) + ((statsTwo[3]*(lvl-1))))) + "");
        JTextField AS2 = new JTextField(tempAS2);
        JTextField AR2 = new JTextField((Math.round((statsTwo[6]) + ((statsTwo[7]*(lvl-1))))) + "");
        JTextField MR2 = new JTextField((Math.round((statsTwo[8]) + ((statsTwo[9]*(lvl-1))))) + "");
        JTextField MS2 = new JTextField(Math.round(statsTwo[10]) + "");
        JTextField R2 = new JTextField(Math.round(statsTwo[11]) + "");
        
        // These are just setting the parameter and bounds for the fields, labels and buttons 
        champOne.setBounds(75, 50, 50, 20);
        contentPane.add(champOne);
        champTwo.setBounds(175, 50, 50, 20);
        contentPane.add(champTwo);
        
     // These are just setting the parameter and bounds for the fields, labels and buttons 
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
        R1.setBounds(75, 190, 50, 20);
        contentPane.add(R1);
        R2.setBounds(175, 190, 50, 20);
        contentPane.add(R2);
        R.setBounds(20, 190, 50, 20);
        contentPane.add(R);
        
        
        // Refreshes the frame 
        contentPane.setVisible(false);
        contentPane.setVisible(true);
    }
}
