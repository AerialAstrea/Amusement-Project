package Rides;

import java.util.ArrayList;

public class itsASmallWorld extends Attraction  
{
    private boolean singing;
    private boolean firstHalfRide;
    private boolean secondHalfRide;
    
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
    
    public itsASmallWorld(){
        super();
        ticketPrice = 1.50; 
        maxRiders = 15;
        rideLength = 5.00 /60.00; //ride is 5 mins long 
        isSingingSection();
    }
}