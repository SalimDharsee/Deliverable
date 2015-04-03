/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deliverable;

import java.io.File;

/**
 *
 * @author John
 */
public class Champion {

    private String name;
    private double HP, HG, AD, ADL, AS, ASL, AR, ARL, MR, MRL;
    private int MS, Range;
    
    public Champion(){
        //default case in the event that no arguments are given
        name = "";
        HP = -1;
        HG = -1;
        AD = -1;
        ADL = 0;
        AS = -1;
        ASL = 0;
        AR = -1;
        ARL = 0;
        MR = -1;
        MRL = 0;
        MS = -1;
        Range = -1;
    }

    //sets the stats otherwise
    public Champion(String name, double HP, double HG, double AD, double ADL, double AS, double ASL, double AR, double ARL, double MR, double MRL, int MS, int Range) {
        this.name = name;
        this.HP = HP;
        this.HG = HG;
        this.AD = AD;
        this.ADL = ADL;
        this.AS = AS;
        this.ASL = ASL;
        this.AR = AR;
        this.ARL = ARL;
        this.MR = MR;
        this.MRL = MRL;
        this.MS = MS;
        this.Range = Range;
    }

    //returns an array of the stats
    public String[] getStats() {
        String returnArray[] = {name, getString(HP), getString(HG), getString(AD),
            getString(ADL), getString(AS), getString(ASL), getString(AR), getString(ARL),
            getString(MR), getString(MRL), getString(MS), getString(Range)};

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
    
    //returns the file location of the champion's picture
    public String picLocation(){
        String temp = System.getProperty("user.dir") + File.separatorChar + "bin" + File.separatorChar + name + "Square.png";
        return temp;
    }
    
    //returns the name of the champion
    public String getName(){
        return name;
    }
    
    //returns the ad for the given level of a champion
    //base ad + (ad per level * the level)
    //level - 1 because base stats are at level one so the amount above that
    //is one below the level
    public int getAD(int lvl){
    	String effectiveAD = (Math.round(AD + (ADL*(lvl-1))) + "");
    	return Integer.parseInt(effectiveAD);
    }
    
    //same as the getAD method, but for AR
    public int getAR(int lvl){
    	String effectiveAR = (Math.round(AR + (ARL*(lvl-1))) + "");
    	return Integer.parseInt(effectiveAR);
    }
    
    //same as the two preceding methods, but for MR
    public int getMR(int lvl){
    	String effectiveMR = (Math.round(MR + (MRL*(lvl-1))) + "");
    	return Integer.parseInt(effectiveMR);
    }

}