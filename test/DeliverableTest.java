/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import deliverable.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
/**
 *
 * @author John
 */
public class DeliverableTest {

    @Test
    public void nullChamp(){
        Champion c = new Champion();
        assertEquals(c.getAD(1), -1); //default champion stats are -1 for all levels
        assertEquals(c.getMR(18), -1);
        assertEquals(c.getAR(3), -1);
        assertEquals(c.getName(), "");
    }
    
    @Test
    public void normalChamp(){
        //Ashe,527.72,79,5.42,0.55,231.8,35,6.97,0.4,51.088,2.85,0.658,4,21.212,3.4,30,0,325,600
        //Name  HP     HP HP5 HP5  MP    MP MP5  MP5   AD    ADL  AS  ASL  AR   ARL MR MRL MS Range
        SearchChampion s = new SearchChampion();
        Champion ashe = s.getChampion("Ashe");
        assertEquals(ashe.getAD(1), 51);
        
        //ensure the stats array contains the correct number of elements
        assertEquals(ashe.getStats().length, 13);
        
        //30 + 18*0 = 30
        assertEquals(ashe.getMR(18), 30);
        
        //21.212 + 4*3.4 = 34.812 ~= 35
        assertEquals(ashe.getAR(5), 35);
        
        assertNotNull(ashe.picLocation());
    }
    @Test
    public void testGUI(){
        InitialFrame test = new InitialFrame();
        assertNotNull(test);
        //GUI is instantiated correctly
    }
    @Test
    public void testChampPopup(){
        Champion c = new Champion();
        ChampionCompare test = new ChampionCompare(c);
        assertNotNull(test);
    }
    @Test
    public void testItemPopup(){
        Item i = new Item();
        ItemCompare test = new ItemCompare(i);
        SearchItem trial = new SearchItem();
        assertNotNull(test);
        
        //ensures items have the correct number of stats
        assertEquals(i.getStats().length, 14);
        
        //ensures the correct info is returned
        assertNotNull(i.picLocation());
        assertNotNull(i.getAD());
        assertNotNull(i.getMR());
        assertNotNull(i.getAR());
        assertNotNull(i.getName());
        assertNotNull(trial.getItem("B.F. Sword"));
    }
    @Test
    public void testCalc(){
        Calculator calc = new Calculator();
        int dmg = Integer.parseInt(Math.round(calc.getPhysicalDamage(0, 0, 0, 0, 0, 0, 0, 0)) + "");
        assertEquals(dmg, 0);
        dmg = Integer.parseInt(Math.round(calc.getMagicDamage(0, 0, 0, 0, 0, 0, 0, 0)) + "");
        assertEquals(dmg, 0);
    }
    
}
