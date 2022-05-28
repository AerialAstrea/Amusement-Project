package src;

import java.util.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import src.Rides.*;
import src.Foods.*;
import src.Drinks.*;
import src.OtherFunctions.*;

public class beParkGoer {
    //attractions in demo
    private static ArrayList<Food> foods = new ArrayList<Food>();
    private static ArrayList<Drink> drinks = new ArrayList<Drink>();
    private static Attraction basicBuggy = new Attraction();
    private static Attraction relativelyExtrema = new Attraction(10, 2.0, 1.0, 1.75/60.00, 50); //maxRider, ticketPrice, runCost, rideLen, minH
    private static Rollercoaster coasterToaster = new Rollercoaster();
    private static ConcessionStand fantasyFlare = new ConcessionStand("Fantasy Flare",100,getFood(),getDrink());
    
    private static ImageIcon my_icon = new ImageIcon("Images/disney_world_logo.png");
    
    //options that are used throughout the class
    private static String [] yn_options = {"Yes!", "No"};
    private static String [] be_options = {"Main Menu", "Back"};
    private static String [] attractions = {"Back","Basic Buggy","Relatively Extrema","Coaster Toaster"};
    private static boolean leave = false;
    private static boolean justEntered = true;
    private static int result = 0;
    
    //the "user"
    private static Ticket t;
    
    public static void demo(){
        while(!leave){
            String [] btn_options = {"Leave","Purchase a Ticket","See Attraction List"};

            if(justEntered){
                result = JOptionPane.showOptionDialog(null, "Welcome to the park! What would you like to do?", "Main Menu",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, my_icon, btn_options, 2);
                justEntered = false;
            }
            else
                result = JOptionPane.showOptionDialog(null, "What would you like to do?", "Main Menu",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, my_icon, btn_options, 2);
                
            if(result == 0){//leave option
                JOptionPane.showMessageDialog(null, "Thank you for visiting!", "DisneyLand",JOptionPane.INFORMATION_MESSAGE,my_icon);
                leave = true;
            }
            else if(result == 1){//purchase a ticket option
                makeTicket(); //creates the ticket
                
                mainMenu(); //present the user with the main menu
            }
            else if(result == 2)//see attraction opton
                seeList();
        }
    } 
    private static ArrayList<Food> getFood(){
        foods.add(new Hamburger()); foods.add(new ChickenTenders()); foods.add(new HotDog()); foods.add(new Fries());
        return foods;
    }
    
    private static ArrayList<Drink> getDrink(){
        drinks.add(new Soda("Coca Cola",16,true,false,4.5)); drinks.add(new Tea("Iced Tea",8,true,true,5.0)); drinks.add(new Coffee("Mickey's Coffee Delight",8,false,true,true,6.0)); 
        return drinks;
    }
    
    public static void makeTicket(){
        //get an ArrayList of the party
        int partySize = Integer.valueOf(JOptionPane.showInputDialog("How many people are in your party?"));
        String name; int height;
        ArrayList<Rider> riders = new ArrayList<Rider>();
        for(int i = 0; i < partySize; i++){
            JOptionPane.showMessageDialog(null,"Enter Party Member " + (i+1) + " Information", "DisneyLand", JOptionPane.PLAIN_MESSAGE);
            name = JOptionPane.showInputDialog("Name:");
            height = Integer.valueOf(JOptionPane.showInputDialog("Height(in inches):"));
        }
              
        //get whether the party purchase the fast pass
        result = JOptionPane.showOptionDialog(null, "Would you like to get a fast pass?", null, JOptionPane.YES_NO_OPTION,
        JOptionPane.INFORMATION_MESSAGE,my_icon, yn_options,1);
        boolean hasFP = false;
        if(result == 0)
            hasFP = true;
        
        //get the starting balance
        double balance = Double.valueOf(JOptionPane.showInputDialog("Please enter your starting balance"));

        //make the ticket
        t = new Ticket(riders,hasFP,balance);
    }
    
    public static void fillRide(){ //randomly fill the ride with users (options of names and stuff)

    }
    
    public static void mainMenu(){ //this is the call for the main menu
        while(!leave){
            String [] btn_options = {"Leave","Check Ticket","See Attraction List", "Get Food"};
            
            result = JOptionPane.showOptionDialog(null, "What would you like to do next?", "Main Menu",
            JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, my_icon, btn_options, 2);
            
            if(result == 0){//see attraction option
                leavePark();
            }
            else if(result == 1){//check ticket option
                checkTicket();
                }
            else if(result == 2){//see attraction option
                seeList();
            }
            else//get food option
                toCS();
        }
    }
    
    public static void leavePark(){//if user leaves park
        JOptionPane.showMessageDialog(null, "Thank you for visiting!", "DisneyLand",JOptionPane.INFORMATION_MESSAGE,my_icon);
        leave = true;
    }
    
    public static void checkTicket(){
        boolean looking = true; //to keep track if the user is still looking at the check ticket menu
                        
        while(looking){
            String [] options = {"Back","Deposit","Withdraw"};
            if(!t.hasFastPass()){//add the option to get fast pass if the user does not have one
                String [] temp = {"Back","Deposit","Withdraw", "Get Fast Pass"};
                options = temp;
            }
                            
            result = JOptionPane.showOptionDialog(null, "What would you like to do?", "DisneyWorld",
            JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, my_icon, options, 0);
                            
            if(result == 0) //Back option ("ends" the method)
                looking = false;
            else if(result == 1){//Deposit option
                double value = Double.valueOf(JOptionPane.showInputDialog("How much would you like to deposit?"));
                t.deposit(value);
                JOptionPane.showMessageDialog(null, "Your balance is now $" + t.getBalance(), "DisneyLand",JOptionPane.INFORMATION_MESSAGE,null);
            }
            else if(result == 2){//Withdraw option
                double value = Double.valueOf(JOptionPane.showInputDialog("How much would you like to deposit?"));
                if(t.getBalance() - value < 0)
                    JOptionPane.showMessageDialog(null, "Sorry, you can not withdraw $" + value + ". Your current balance is $" + t.getBalance(), "DisneyLand",JOptionPane.INFORMATION_MESSAGE,null);
                else{
                    t.withdraw(value); 
                    JOptionPane.showMessageDialog(null, "Your balance is now $" + t.getBalance(), "DisneyLand",JOptionPane.INFORMATION_MESSAGE,null);
                }
                }
                else if(result == 3){//Get Fast Pass option
                    t.getFastPass();
            }
        }
    }
    
    public static void seeList(){
        boolean looking = true; //true = still looking at attractions
                
        while(looking){
            result = JOptionPane.showOptionDialog(null, "Here is a list of our attractions!", "DisneyWorld",
            JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, my_icon, attractions, 0);
                                
            if(result == 0)
                looking = false;
            else if(result == 1){//Basic Buggy
                result = JOptionPane.showOptionDialog(null, "Basic Buggy\n" + basicBuggy.getInfo(), null, JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE,my_icon, be_options,1);
                if(result == 0){
                    looking = false;
                }
            }
            else if(result == 2){//Relatively Extrema
                result = JOptionPane.showOptionDialog(null, "Relatively Extrema\n" + relativelyExtrema.getInfo(), null, JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE,my_icon, be_options,1);
                if(result == 0){
                    looking = false;
                }
            }
            else if(result == 3){//Coaster Toaster
                result = JOptionPane.showOptionDialog(null, "Coaster Toaster\n" + coasterToaster.getInfo(), null, JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE,my_icon, be_options,1);
                if(result == 0){
                    looking = false;
                }
            }
        }
    }
    
    public static void toCS(){        
        String [] food_options = fantasyFlare.getFoodOpt();
        String [] options = {"Done","Get Food Only", "Get Drink Only", "Get Combo (1 Food, 1 Drink)"};
        boolean looking = true;
        boolean justEntered = true;
        
        while(looking){
            if(justEntered){
                JOptionPane.showMessageDialog(null, "Welcome to Fantasy Flare", "Fantasy Flare",JOptionPane.INFORMATION_MESSAGE,null);
                justEntered = false;
            }
            
            result = JOptionPane.showOptionDialog(null, "What would you like to do?", null, JOptionPane.YES_NO_OPTION,
            JOptionPane.INFORMATION_MESSAGE,null, options,0); 
            
            if(result == 0){
                JOptionPane.showMessageDialog(null, "Thank you for coming to Fantasy Flare!", "DisneyLand",JOptionPane.INFORMATION_MESSAGE,null);
                looking = false;
            }
            else if(result == 1){//food
                Food f = foodSelect();
                if(f != null){
                    while(t.getBalance() < f.getPrice()){
                        result = JOptionPane.showOptionDialog(null, "Your ticket's balance is too low. Would you like to reload?", null, JOptionPane.YES_NO_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,null, yn_options,1); 
                        if(result == 0){//yes option
                            double value = Double.valueOf(JOptionPane.showInputDialog("How much would you like to deposit?"));
                            t.deposit(value);
                            JOptionPane.showMessageDialog(null, "Your balance is now $" + t.getBalance(), "Fantasy Flare",JOptionPane.INFORMATION_MESSAGE,null);
                        }
                        else{//no option
                            JOptionPane.showMessageDialog(null, "Thank you for coming to Fantasy Flare! We hope to see you again soon!", "Fantasy Flare",JOptionPane.INFORMATION_MESSAGE,null);
                            looking = false;
                            break;
                        }
                    }
                    if(t.getBalance() >= f.getPrice()){
                        fantasyFlare.buyFood(t,f);   
                        result = JOptionPane.showOptionDialog(null, "Thank you for your purchase! Your balance is now $" + t.getBalance() + ". Would you like to purchase another item?", null, JOptionPane.YES_NO_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,null, yn_options,1); 
                        if(result == 1)
                        looking = false; //done with purchase
                    }
                }
            }
            else if(result == 2){//drink
                Drink d = drinkSelect();
                if(d != null){
                    while(t.getBalance() < d.getPrice()){
                        result = JOptionPane.showOptionDialog(null, "Your ticket's balance is too low. Would you like to reload?", null, JOptionPane.YES_NO_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,null, yn_options,1); 
                        if(result == 0){//yes option
                            double value = Double.valueOf(JOptionPane.showInputDialog("How much would you like to deposit?"));
                            t.deposit(value);
                            JOptionPane.showMessageDialog(null, "Your balance is now $" + t.getBalance(), "Fantasy Flare",JOptionPane.INFORMATION_MESSAGE,null);
                        }
                        else{//no option
                            JOptionPane.showMessageDialog(null, "Thank you for coming to Fantasy Flare! We hope to see you again soon!", "Fantasy Flare",JOptionPane.INFORMATION_MESSAGE,null);
                            looking = false;
                            break;
                        }
                    }
                    if(t.getBalance() >= d.getPrice()){
                        fantasyFlare.buyDrink(t,d);   
                        result = JOptionPane.showOptionDialog(null, "Thank you for your purchase! Your balance is now $" + t.getBalance() + ". Would you like to purchase another item?", null, JOptionPane.YES_NO_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,null, yn_options,1); 
                        if(result == 1)
                        looking = false; //done with purchase
                    }
                }
            }
            else{//get combo
                getCombo();
            }
        }
    }
    
    public static Drink drinkSelect(){
        boolean looking = true;
        String [] drink_options = fantasyFlare.getDrinkOpt();
        Food f;
        while(looking){
            result = JOptionPane.showOptionDialog(null, "What drink item would you like?", null, JOptionPane.YES_NO_OPTION,
            JOptionPane.INFORMATION_MESSAGE,null, drink_options,0); 
            
            if(result == 0){//back option
                looking = false;
                return null;
            }
            else if(result == 1){//coca colla
                return new Soda("Coca Cola",16,true,false,4.5);
            }
            else if(result == 2){//iced tea
                return new Tea("Iced Tea",8,true,true,5.0);
            }
            else if(result == 3){//mickey's coffee delight
                return new Coffee("Mickey's Coffee Delight",8,false,true,true,6.0);
            }
        }
        return null;
    }
    
    public static Food foodSelect(){
        boolean looking = true;
        String [] food_options = fantasyFlare.getFoodOpt();
        Food f;
        while(looking){
            result = JOptionPane.showOptionDialog(null, "What food item would you like?", null, JOptionPane.YES_NO_OPTION,
            JOptionPane.INFORMATION_MESSAGE,null, food_options,0); 
            
            if(result == 0){//back option
                looking = false;
                return null;
            }
            else if(result == 1){//hamburger
                return new Hamburger();
            }
            else if(result == 2){//chicken tenders
                return new ChickenTenders();
            }
            else if(result == 3){//hot dog
                return new HotDog();
            }
            else if(result == 4){//fries
                return new Fries();
            }
        }
        return null;
    }
    
    public static void getCombo(){
        boolean looking = true;
        boolean foodSelected = false;
        boolean drinkSelected = false;
        Food f = foodSelect(); //food items of choice
        Drink d = drinkSelect(); //drink item of choice
        
        while(d == null){
            f = foodSelect();//when the user hit back, it should take them back to the food item selection again
            d = drinkSelect();
            
            String [] confirm_opt = {"Confirm","Change Order"};
            if(d != null){
                result = JOptionPane.showOptionDialog(null, "Please confirm your order: " + f.getName() + " & " + d.getName(), null, JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE,null, confirm_opt,0); 
            }
        }
    }
}