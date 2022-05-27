package Foods;

import java.util.*;

public class Fries extends Food{
    private boolean hasSalt;
    public Fries(String n, double p, ArrayList<Sauce> s, boolean salted){
        super(n,p,s);
        hasSalt = salted;
    }

    public void addSalt(){
        hasSalt = true;
    }
}