package src.Drinks;

public class Drink
{
    //instance variables
    protected String name;
    protected int oz; 
    protected boolean iced;
    protected double price;
    private static int numDrinks;
    
    //constructor
    public Drink(String n, int o, boolean i, double p)
    {
        name = n;
        oz = o;
        iced = i;
        price = p;
        numDrinks++;
    }
    
    //#methods
    public String getName()
    {
        return name;
    }
    
    public double getPrice()
    {
        return price;
    }
    
    public static int getNumDrink()
    {
        return numDrinks;
    }
}
