package OtherFunctions;

import java.util.*;

public class Ticket {//a ticket is a party of riders
    private ArrayList<Rider> riders;
    private boolean fastPass; //if the party has fast pass
    private double balance;

    public Ticket(ArrayList<Rider> r, boolean f, double b){
        riders = r;
        fastPass = f;
        balance = b;
    }

    //accessor methods
    public ArrayList<Rider> getRiders(){
        return riders;
    }

    public boolean hasFastPass(){
        return fastPass;
    }

    public double getBalance(){
        return balance;
    }

    public int getPartySize(){
        return riders.size();
    }

    //mutator methods
    public void deposit(double num){
        balance += num;
    }

    public void withdraw(double num){
        balance -= num;
    }

    public void getFastPass(){//run when customer buy a fast pass
        fastPass = true;
    }
    
    public void setBalance(double num){
        balance = num;
    }
    
    public void printParty(){
        for(Rider rider: riders){
            System.out.print(rider.getName() + " ");
        }
    }
}