package src.Rides;

import java.util.ArrayList;
import java.util.Scanner;
import src.OtherFunctions.*;

public class itsASmallWorld extends Attraction{
    protected boolean singing;
    protected boolean firstHalfRide;
    protected boolean secondHalfRide;
    protected boolean startOfRide;
    protected boolean loadChair;
    protected int maxBoats = 7;
    protected int currentBoats;
    protected boolean emergencyStop;
    public boolean endOfRiver;
    ArrayList<Rider> bob = new ArrayList();
    Ticket p = new Ticket(bob, true, 250.00); 
    public itsASmallWorld(){
        super();
        ticketPrice = 1.50;
        maxRiders = 15;
        rideLength = 5.00 /60.00; //ride is 5 mins long
        isSingingSection();
    } 
    
    public void makeLyrics1(){
        ArrayList <String> lyrics1 = new ArrayList<String>();
        lyrics1.add("It's a world of laughter");
        lyrics1.add("A world of tears");
        lyrics1.add("It's a world of hopes");
        lyrics1.add("And a world of fears");
        lyrics1.add("There's so much that we share");
        lyrics1.add("That it's time we're aware");
        lyrics1.add("It's a small world after all");
        for(String s1: lyrics1)
        System.out.println(s1);
    } 
    
    public void makeLyrics2(){
        ArrayList <String> lyrics2 = new ArrayList<String>();
        lyrics2.add("There is just one moon");
        lyrics2.add("And one golden sun");
        lyrics2.add("And a smile means");
        lyrics2.add("Friendship to ev'ryone");
        lyrics2.add("Though the mountains divide");
        lyrics2.add("And the oceans are wide");
        lyrics2.add("It's a small world after all");
        for(String s: lyrics2)
        System.out.println(s);
    }
    
    public void makeChorus(){
        ArrayList <String> chorus = new ArrayList<String>();
        chorus.add("It's a small world after all");
        chorus.add("It's a small world after all");
        chorus.add("It's a small world after all");
        chorus.add("It's a small, small world");
        for(String c: chorus)
        System.out.println(c);
    } 
    
    public void isSingingSection(){
        if(singing && firstHalfRide){
        makeLyrics1();
        makeChorus();
        }
        else if (singing && secondHalfRide){
        makeLyrics2();
        makeChorus();
        }
    } 
    
    public void scanTicket(Ticket t1){
        Scanner read = new Scanner(System.in);
        System.out.println("How many people are in your party?");
        int partySize = read.nextInt();
        ArrayList<Rider> r = new ArrayList<Rider>();
        for(int i = 0; i < partySize; i++){
        System.out.println("What is rider " + (i+1)+ "'s name?");
        String name = read.nextLine();
        System.out.println("What is rider " + (i+1)+ "'s height?");
        int height = read.nextInt();
        r.add(new Rider(name,height));
        }
        System.out.println("Would you like to get a fast pass? (y/n)");
        String response = read.nextLine();
        boolean hasFP = false;
        if(response.equals("y"))
        hasFP = true; System.out.println("What is your starting balance?");
        double b = read.nextDouble(); Ticket t = new Ticket(r, hasFP, b);
        getInLine(t1);
    } 
    
    public void numBoats(){
        if(currentBoats < maxBoats){
        scanTicket(p);
        currentBoats ++;
        numBoats();
        System.out.println("next boat please!");
        }
        else
        System.out.println("please wait your turn, thank you");
    } 
    
    public void outOfBoat(){
        if(endOfRiver == true){
        System.out.println("time to get out of the boat, the ride is over");
        currentBoats = 0;//all boats return to empty so ride can start again
        }
    } 
    
    public void go(){
        if(time<closeTime){
        numBoats();
        isSingingSection();
        time += rideLength;
        }
        if(time == rideLength){//irl there would be time tracker that increase time over time
        endOfRiver = true;
        outOfBoat();
        }
    }
}

