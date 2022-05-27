package Rides;

import OtherFunctions.Ticket;
import OtherFunctions.Rider;
import java.util.*;

public class Attraction {
    //instance variable to be set in constructor
    protected int maxRiders;
    protected double ticketPrice;
    protected double runningCost; // 1 = 1 million
    protected double rideLength; // in terms of hours
    protected int minHeight; // in inches

    //instance variables to be tracked in the class
    protected ArrayList<Ticket> inLine = new ArrayList<Ticket>(); //number of peole in line
    protected int totalRiders; //number of people riding attraction
    protected int totalRides; //number of rides (for the specific attraction)

    //park hours: 6AM - 9PM
    private final double openTime = 6.0;
    protected final double closeTime = 21.0;

    //class instance variables
    private static int numAttractions;
    protected static double time = 6.00; // 9:00 = 9.0, 15:00(3:00PM) = 15.0 (static because time should be the same for all objects)

    //class constructor
    public Attraction(){
        maxRiders = 20;
        ticketPrice = 1.00;
        runningCost = 5.0; //average Disney ride cost $5 million to operate
        rideLength = 2.0/60.0; //default = 2 min ride
        minHeight = 48;
        numAttractions ++;
    }

    public Attraction(int m, double t, double rC, double rL, int minH){
        maxRiders = m;
        ticketPrice = t;
        runningCost = rC;
        rideLength = rL;
        minHeight = minH;
        numAttractions ++;
    }

    //attraction running methods
    public void getInLine(Ticket t){//accepts ticket if meet minHeight
        Ticket temp = new Ticket(checkTicket(t), t.hasFastPass(), t.getBalance());
        
        if(ticketPrice*temp.getRiders().size() > t.getBalance()){
            Scanner s = new Scanner(System.in);
            while(t.getBalance() < ticketPrice*temp.getRiders().size()){
                System.out.println("Sorry, your balance is too low. Would you like to reload it? (y/n)");
                String response = s.nextLine();
                if(response.equals("y")){
                    System.out.println("How much would you like to reload?");
                    Scanner i = new Scanner(System.in);
                    double reload = i.nextDouble();
                    t.deposit(reload);
                    temp.deposit(reload);//make depos into temp
                }
                else{
                    System.out.println("Please exit the line");
                    break;
                }
            }
        }
        if(ticketPrice*temp.getRiders().size() <= t.getBalance()){
            t.withdraw(ticketPrice*t.getRiders().size());
            temp.withdraw(ticketPrice*t.getRiders().size());
            inLine.add(temp);
            System.out.println("Welcome!");
        }
    }
    
    public void printLine(){
        for(int i = 0; i < inLine.size(); i++){
            inLine.get(i).printParty();
            if(i != inLine.size()-1)
            System.out.println();
        }
        
        if(inLine.size()==0)
            System.out.println("Line is empty.");
        else
            System.out.println();
    }

    public void run(){ //if irl, this command runs everytime the operator press the button to run the ride
        int currentNumRider = 0;
        if(time + rideLength <= closeTime){ //the ride will not run if it will past closing
            int counter = 0;
            while(currentNumRider < maxRiders && counter < inLine.size()){
                int partySize = inLine.get(counter).getPartySize();
                if(partySize + currentNumRider < maxRiders){
                    currentNumRider += partySize;
                    inLine.remove(counter);
                }
                else
                    counter++;
            }
        }
        totalRiders += currentNumRider;
        time += rideLength;
    }
    
    public ArrayList<Rider> checkTicket(Ticket t){
        ArrayList<Rider> party = t.getRiders();
        ArrayList<Rider> validRiders = new ArrayList();
        for(Rider rider : party){
            if(rider.getHeight() < minHeight)
                System.out.println("Sorry, you do not meet the height requirement for this ride.");
            else if (t.getPartySize()>1){
                System.out.println("Please wait until all tickets are scanned");
                validRiders.add(rider); 
            }
            else
                validRiders.add(rider);
        }
        return validRiders;
    }
    
    public boolean checkBalance(Ticket t){
        boolean enoughMoney;
        if(ticketPrice*t.getRiders().size() <= t.getBalance()){
            enoughMoney = true;
            t.withdraw(ticketPrice*t.getRiders().size());
        }
        else{
            Scanner s = new Scanner(System.in);
            while(t.getBalance() < ticketPrice*t.getRiders().size()){
                System.out.println("Sorry, your balance is too low. Would you like to reload it? (y/n)");
                String response = s.nextLine();
                if(response.equals("y")){
                    System.out.println("How much would you like to reload?");
                    double reload = s.nextDouble();
                    t.deposit(reload);//make depos into temp
                }
                else{
                    System.out.println("Please exit the line");
                    break;
                }
            }
            enoughMoney = true;
            t.withdraw(ticketPrice*t.getRiders().size());
        }
        return enoughMoney;
    }
    //other methods
    public void incTicketPrice(double num){
        ticketPrice += num;
    }
    
    public double totalProft(){
        return totalRiders*ticketPrice - runningCost;
    }

    public int getTotalRiders(){
        return totalRiders;
    }

    public int getNumAttractions(){
        return numAttractions;
    }

    public int getNumInLine(ArrayList<Ticket> line){
        int numInLine = 0;
        for(Ticket party : line)
            numInLine += party.getPartySize();
        return numInLine;
    }

    public double getWaitTime(){//wait time displayed at the start of the ride for people to decide whether to get in line or not
        return (double)getNumInLine(inLine)/maxRiders*rideLength;
    }
    
    public String getInfo(){
        return "Max Riders: " + maxRiders + "\nTicket Price: $" + ticketPrice + "\nRide Length: " + rideLength*60.0 + " minutes" +
        "\nMin. Required Height: " + minHeight + " inches" + "\nCurrent Wait Time: " + getWaitTime();
    }
}