package deliverable;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SearchItem {

    private String ItemName;
    private boolean ItemExists;
    private Scanner ItemScanner;
    private String filePath = System.getProperty("user.dir") + "//bin//deliverable//ItemInfo.csv";
    private BufferedReader reader;
    public String[][] myItemArray = new String[31][15];
    private int rowCounter = 0;
    private String error = "Item not found";
    private Item[] Items;

    //Checks the text file or array to see if the Item exists 
    public SearchItem() {
        try {
            //instantiates the buffered reader
            reader = new BufferedReader(new FileReader(filePath));
            String line;
            //Loops through the text file until the line is empty, prints each line
            while ((line = reader.readLine()) != null) {
                //Stores the Item info in an array
                String[] InArray = line.split(",");
                for (int x = 0; x < InArray.length; x++) {
                    myItemArray[rowCounter][x] = InArray[x];
                }
                rowCounter++;
            }
            Items = new Item[myItemArray.length-1];
            for (int i = 0; i < myItemArray.length-1; i++) {
                //System.out.println(myItemArray[i][14]);
                Items[i] = new Item(myItemArray[i][0], Double.parseDouble(myItemArray[i][1]), Double.parseDouble(myItemArray[i][5]),
                        Double.parseDouble(myItemArray[i][5]), Double.parseDouble(myItemArray[i][7]), Double.parseDouble(myItemArray[i][11]),
                        Double.parseDouble(myItemArray[i][4]), Double.parseDouble(myItemArray[i][13]), Double.parseDouble(myItemArray[i][2]),
                        Integer.parseInt(myItemArray[i][14]));
            }

            //Wrong filename exception
        } catch (FileNotFoundException e) {

            e.printStackTrace();
            //ReadLine error catch
        } catch (IOException e) {

            e.printStackTrace();
        }

    }
    //Returns the stored Item name to the user
    public Item getItem(String checkText) {
        
        for (Item c : Items){
            if(c.getName().equals(checkText)){
                return c;
            }
        }
        return null;
    }

}
