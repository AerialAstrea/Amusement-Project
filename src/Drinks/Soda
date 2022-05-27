package Drinks;

public class Soda extends Drink
{
    //instance variables
    private boolean diet;
    private static int numSodas = 0;
    private static int numDietSodas = 0;
    
    //constructor
    public Soda(String n, int o, boolean i, boolean d, double p)
    {
        super(n,o,i,p);
        diet = d;
        numSodas ++;
        if(diet)
        numDietSodas ++;
    }
    
    //methods
    public static int getNumSodas()
    {
        return numSodas;
    }
    public static int getNumDietSodas()
    {
        return numDietSodas;
    }
    public double getPrice()
    {//calculated by multiplying the number of oz by $0.25
        return oz*0.25;
    }
}
