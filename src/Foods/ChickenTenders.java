package src.Foods;

import java.util.*;

public class ChickenTenders extends Food{
    private boolean isSpicy;
    private boolean extraCrispy;
    private int pieces;

    public ChickenTenders(){
        name = "Regular Chicken Tenders";
        price = 4.00;
        pieces = 3;
        isSpicy = false;
        extraCrispy = false;
        ArrayList<Sauce> s = new ArrayList<>();
        s.add(new Sauce());
        sauces = s;
    }

    public ChickenTenders(String n, double p, ArrayList<Sauce> sa, int pi, boolean s, boolean c){
        super(n,p,sa);
        pieces = pi;
        isSpicy = s;
        extraCrispy = c;
    }
    
    public void makeSpicy(){
        isSpicy = true;
    }

    public void makeExtraCrispy(){
        extraCrispy = true;
    }
}