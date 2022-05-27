package Rides;

import OtherFunctions.Ticket;
import OtherFunctions.Rider;
import java.util.*;

public class Rollercoaster extends Attraction {
    private ArrayList<Ticket> regLine = new ArrayList<Ticket>();
    private ArrayList<Ticket> fastLine = new ArrayList<Ticket>();
    private boolean end;
    private boolean restraint; //true = restraints down, false = restraints up

    //class constructor
    public Rollercoaster(){
        super();
        maxRiders = 6;
    }

    public Rollercoaster(double t, double rC, double rL, int minH){
        super(6, t, rC, rL, minH);
    }

    public void getInLine(Ticket t){
        Ticket temp = new Ticket(checkTicket(t), t.hasFastPass(), t.getBalance());
        
        if(ticketPrice*temp.getPartySize() > t.getBalance()){//if their balance is too low-
            Scanner s = new Scanner(System.in);
            while(t.getBalance() < ticketPrice*temp.getPartySize()){
                System.out.println("Sorry, your balance is too low. Would you like to reload it? (y/n)");
                String response = s.nextLine();
                if(response.equals("y")){
                    System.out.println("How much would you like to reload?");
                    double reload = s.nextDouble();
                    t.deposit(reload);
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
            if(t.hasFastPass())
                fastLine.add(temp);
            else
                regLine.add(temp);
            System.out.println("Welcome!");    
        }
    }
    
    public void printLine(){
        System.out.println("Fast Pass Line:");
        for(int i = 0; i < fastLine.size(); i++){
            fastLine.get(i).printParty();
            if(i != fastLine.size()-1)
            System.out.println();
        }
        System.out.println("\n");
        System.out.println("Regular Line:");
        for(int i = 0; i < regLine.size(); i++){
            regLine.get(i).printParty();
            if(i != regLine.size()-1)
            System.out.println();
        }
        
        if(regLine.size()==0 && fastLine.size()==0)
            System.out.println("Both lines are empty.");
        else if(regLine.size()==0)
            System.out.println("Regular line is empty.");
        else if(fastLine.size()==0)
            System.out.println("Fast Pass line is empty.");
        System.out.println();
    }
    
    public void run(){ //line ratio fast:reg, 2:1 (idea: do a tracker for 1-3 and if odd: take fast party, even: take reg party)
        int currentNumRider = 0;
        int tracker = 1;
        if(time + rideLength <= closeTime){ //the ride will not run if it will past closing
            int counter = 0;
            while(currentNumRider < maxRiders && counter < fastLine.size() && counter < regLine.size()){//run until the cart is filled (reach maxRider)
                if(tracker % 2 != 0){ //when odd, take party from fast lane
                    int partySize = fastLine.get(counter).getPartySize();
                    if(partySize + currentNumRider <= maxRiders){//add the party if does not exceed maxRider
                        currentNumRider += partySize;
                        fastLine.remove(counter);
                        //counter not increase because arraylist is shifted
                    }
                    else//update if a working party if not found
                        counter++;
                    tracker++;
                }
                else if(tracker % 2 == 0){ //when even, take party from reg line
                    int partySize = regLine.get(counter).getPartySize();
                    if(partySize + currentNumRider <= maxRiders){//add the party if does not exceed maxRider
                        currentNumRider += partySize;
                        regLine.remove(counter);
                    }
                    else//update if a working party if not found
                        counter++;
                    tracker++;
                }
                if(tracker == 3)//reset the tracker
                tracker = 1;
            }
        }
        totalRiders += currentNumRider;
        time += rideLength;
        end = false; //ride started so shouldn't end
        restraint = true;
    }

    public double getWaitTime(){//wait time displayed at the start of the ride for people to decide whether to get in line or not
        return (double)(getNumInLine(fastLine)+getNumInLine(regLine))/maxRiders*rideLength;
    }
    
    public void end(){
        end = true; //when the switch on the rollercoaster is hit/switched
        restraint = false;
    }
}