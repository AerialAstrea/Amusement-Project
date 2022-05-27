package Drinks;

public class Coffee extends Drink
{
    //instance variables
    private boolean cream,sugar;
    private static int numCoffees = 0;
    
    //constructor
    public Coffee(String n, int o, boolean i, boolean c, boolean s, double p)
    {
        super (n,o,i,p);
        cream = c;
        sugar = s;
        numCoffees ++;
    }
    
    //methods
    public static int getNumCoffees()
    {
        return numCoffees;
    }
    public double getPrice()
    {
        if(cream && sugar)
        return super.getPrice() + 0.20;
        else if(cream || sugar)
        return super.getPrice() + 0.10;
        else
        return super.getPrice();
    }
}
