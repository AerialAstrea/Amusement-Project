package Foods;

import java.util.*;

public class Food{
    protected String name;
    protected double price;
    protected ArrayList<Sauce> sauces = new ArrayList<Sauce>();

    public Food(){
        name = "item";
        price = 1.0;
    }
    public Food(String n, double p, ArrayList<Sauce> s){
        name = n;
        price = p;
        sauces = s;
    }
    
    public String getName(){
        return name;
    }

    public double getPrice(){
        return price;
    }

    public void addSauce(Sauce s){
        sauces.add(s);
        price += s.getPrice();
    }
}