/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package deliverable;

public class Calculator {
    
    public double getPhysicalDamage(int base, double ratio, int ad, int arm, int armpen, int armred, int armpenp, int armredp){
        //ability  base damage, ability AD scaling, user's attack damage, target's armor
        //user's flat armor pen, flat armor reduction, percent armor pen, percent armor reduction
        
        
        //get the target's effective armor
        double actualArmor = realArmor(arm, armpen, armred, armpenp, armredp);
        //get the damage multiplier based on their armor
        double multiplier = getMultiplier(actualArmor);
        
        //get the effective base damage based on the base damage plus the ratio times the user's attack damage
        double realBase = (double) base + (ad * ((double) ratio));
        //multiply the effective base by the overall multiplier to get the actual damage
        double totalDamage = realBase * multiplier;
        
        
        return totalDamage;
    }
    
        public double getMagicDamage(int base, double ratio, int ap, int mr, int magicPen, int magicRed, int magicPenP, int magicRedP){
        //ability  base damage, ability AD scaling, user's attack damage, target's armor
        //user's flat armor pen, flat armor reduction, percent armor pen, percent armor reduction
        
            
        //get the target's effective magic resist
        double actualMR = realMR(mr, magicPen, magicRed, magicPenP, magicRedP);
        //get the damage multiplier based on the target's MR
        double multiplier = getMultiplier(actualMR);
        
        //the effective base damage (base damage plus the ratio times the user's ability power
        double realBase = (double) base + (ap * ((double) ratio));
        //multiply the effective base damage by the multiplier
        double totalDamage = realBase * multiplier;
        
        
        return totalDamage;
    }
    
    private double realArmor(int arm, int armpen, int armred, int armpenp, int armredp){
        double armor, armorPen, armorRed, armorPenP, armorRedP;
        armor = arm;
        armorPen = armpen;
        armorRed = armred;
        armorPenP = armpenp;
        armorRedP = armredp;
        
        //effective armor is calculated by subtracting flat armor reduction, then percentage armor reduction
        //then percentage armor penetration, then flat armor penetration
        
        armor -= armorRed;
        armor *= ((100 - armorRedP)/100);
        armor *= ((100 - armorPenP)/100);
        armor -= armorPen;
        
        return armor;
    }
    
    private double getMultiplier(double resist){
        
        //formulae for calculating the multiplier if the target's armor/MR is above or below zero
        double multiplier;
        if(resist < 0){
            //below zero
            multiplier = (2 - (100/(100-resist)));
        }else{
            //above zero
            multiplier = (100/(100 + resist));
        }
        return multiplier;
    }
    
        private double realMR(int mr, int magicPen, int magicRed, int magicPenP, int magicRedP){
        double resist, realPen, realRed, realPenP, realRedP;
        resist = mr;
        realPen = magicPen;
        realRed = magicRed;
        realPenP = magicPenP;
        realRedP = magicRedP;
        
        //Magic reduction/penetration is calculated in the same manner as armor reduction/penetration
        
        resist -= realRed;
        resist *= ((100 - realRedP)/100);
        resist *= ((100 - realPenP)/100);
        resist -= realPen;
        
        return resist;
    }  
}