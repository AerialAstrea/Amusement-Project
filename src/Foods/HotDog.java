package src.Foods;

import java.util.*;

public class HotDog extends Food{
    private String meatType;
    
    public HotDog(){
        name = "HotDog";
        price = 1.0;
        meatType = "Beef";
    }
    
    public HotDog(String n, double p, ArrayList<Sauce> s, String m){
        super(n,p,s);
        meatType = m;
    }
    
    public void changeMeat(String m){
        meatType = m;
    }
}