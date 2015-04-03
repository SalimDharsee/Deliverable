
package deliverable;


public class Item {

    private String name;
    private double HP, HG, AD, ADL, AS, ASL, AR, ARL, MR, MRL;
    private int MS, Range;

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

    public String[] getStats() {
        String returnArray[] = {name, getString(HP), getString(HG), getString(AD),
            getString(ADL), getString(AS), getString(ASL), getString(AR), getString(ARL),
            getString(MR), getString(MRL), getString(MS), getString(Range), getString(MS)};

        return returnArray;
    }

    private String getString(double d) {
        return d + "";
    }

    private String getString(int i) {
        return i + "";
    }
    
    public String picLocation(){
        String temp = System.getProperty("user.dir") + "//bin//" + name + ".png";
        return temp;
    }
    
    public String getName(){
        return name;
    }
    
    public int getAD(){
    	return Integer.parseInt(Math.round(AD) + "");
    }
    public int getAR(){
    	return Integer.parseInt(Math.round(AR) + "");
    }
    public int getMR(){
    	return Integer.parseInt(Math.round(MR) + "");
    }

}
