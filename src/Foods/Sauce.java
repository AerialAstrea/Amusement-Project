package src.Foods;

public class Sauce{
    private String name;
    private double price;

    public Sauce(){
        name = "ketchup";
        price = 0.5;
    }

    public Sauce(String n, double p){
        name = n;
        price = p;
    }
    
    public double getPrice(){
        return price;
    }
}