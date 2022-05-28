package src.Drinks;

public class Tea extends Drink
{
    //instance variables
    private boolean sugar;
    private static int numTeas = 0;
    
    //constructor
    public Tea(String n, int o, boolean i, boolean s, double p)
    {
        super (n,o,i,p);
        sugar = s;
        numTeas ++;
    }
    
    //methods
    public static int getNumTeas()
    {
        return numTeas;
    }
}
