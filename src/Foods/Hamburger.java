package src.Foods;

import java.util.*;

public class Hamburger extends Food{
    private boolean extraPatty;
    private boolean hasPickles;
    private boolean hasTomatoes;
    private boolean hasCheese;

    public Hamburger(){
        name = "Hamburger";
        price = 2.00;
        extraPatty = false;
        hasPickles = false;
        hasTomatoes = false;
        hasCheese = false;
    }
    public Hamburger(String n, double p, ArrayList<Sauce> s, boolean pickles, boolean tomatoes, boolean cheese){
        super(n,p,s);
        extraPatty = false;
        hasPickles = pickles;
        hasTomatoes = tomatoes;
        hasCheese = cheese;
    }

    public void addExtraPatty(){
        extraPatty = true;
        price += .5;
    }
}