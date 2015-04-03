
package deliverable;

import java.io.File;


public class Item {

    private String name;
    private double HP, HG, AD, ADL, AS, ASL, AR, ARL, MR, MRL;
    private int MS, Range;

    //in case no arguments are given, initial stats are set
    public Item(){
        name = "";
        HP = -1;
        HG = -1;
        AD = -1;
        ADL = -1;
        AS = -1;
        ASL = -1;
        AR = -1;
        ARL = -1;
        MR = -1;
        MRL = -1;
    }
    
    //stats are set otherwise
    public Item(String name, double HG, double AD, double ADL, double AS, double ASL, double AR, double ARL, double MR, int MS) {
        this.name = name;
        this.HG = HG;
        this.AD = AD;
        this.ADL = ADL;
        this.AS = AS;
        this.ASL = ASL;
        this.AR = AR;
        this.ARL = ARL;
        this.MR = MR;
        this.MS = MS;

    }

    //returns an array of the stats
    public String[] getStats() {
        String returnArray[] = {name, getString(HP), getString(HG), getString(AD),
            getString(ADL), getString(AS), getString(ASL), getString(AR), getString(ARL),
            getString(MR), getString(MRL), getString(MS), getString(Range), getString(MS)};

        return returnArray;
    }

    //simple method to get a string from a double
    private String getString(double d) {
        return d + "";
    }

    //simple method to get a string from an int
    private String getString(int i) {
        return i + "";
    }
    
    //returns the file location of the item's picture
    public String picLocation(){
        String temp = System.getProperty("user.dir") + File.separatorChar + "bin" + File.separatorChar + name + ".png";
        return temp;
    }
    
    //returns the name of the item
    public String getName(){
        return name;
    }
    
    //returns the AD the item gives
    public int getAD(){
    	return Integer.parseInt(Math.round(AD) + "");
    }
    //returns the AR the item gives
    public int getAR(){
    	return Integer.parseInt(Math.round(AR) + "");
    }
    //returns the MR the item gives
    public int getMR(){
    	return Integer.parseInt(Math.round(MR) + "");
    }

}
