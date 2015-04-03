package deliverable;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SearchChampion {

    private char separator = File.separatorChar;
    private String championName;
    private boolean championExists;
    private Scanner championScanner;
    private String filePath = System.getProperty("user.dir") + separator + "src" + separator + "deliverable" + separator + "ChampionInfo.csv";
    private BufferedReader reader;
    public String[][] myChampionArray = new String[123][19];
    private int rowCounter = 0;
    private String error = "champion not found";
    private Champion[] champions;

    //Checks the text file or array to see if the champion exists 
    public SearchChampion() {
        try {
            //instantiates the buffered reader
            reader = new BufferedReader(new FileReader(filePath));
            String line;
            //Loops through the text file until the line is empty, prints each line
            while ((line = reader.readLine()) != null) {
                //Stores the champion info in an array
                String[] InArray = line.split(",");
                for (int x = 0; x < InArray.length; x++) {
                    myChampionArray[rowCounter][x] = InArray[x];
                }
                rowCounter++;
            }
            champions = new Champion[myChampionArray.length-1];
            for (int i = 0; i < myChampionArray.length-1; i++) {	
                champions[i] = new Champion(myChampionArray[i][0], Double.parseDouble(myChampionArray[i][1]), Double.parseDouble(myChampionArray[i][2]),
                        Double.parseDouble(myChampionArray[i][9]), Double.parseDouble(myChampionArray[i][10]), Double.parseDouble(myChampionArray[i][11]),
                        Double.parseDouble(myChampionArray[i][12]), Double.parseDouble(myChampionArray[i][13]), Double.parseDouble(myChampionArray[i][14]),
                        Double.parseDouble(myChampionArray[i][15]), Double.parseDouble(myChampionArray[i][16]), Integer.parseInt(myChampionArray[i][17]),
                        Integer.parseInt(myChampionArray[i][18]));
            }

            //Wrong filename exception
        } catch (FileNotFoundException e) {

            e.printStackTrace();
            //ReadLine error catch
        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    //Returns the stored champion name to the user
    public Champion getChampion(String checkText) {
        for (Champion c : champions){
            if(c.getName().equals(checkText)){
                return c;
            }
        }
        return null;
    }

}
