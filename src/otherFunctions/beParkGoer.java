import java.util.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class beParkGoer {
    public static void main(){
        attraction basicBuggy = new attraction();
        attraction relativelyExtrema = new attraction(10, 2.0, 1.0, 1.75/60.00, 50); //maxRider, ticketPrice, runCost, rideLen, minH
        rollercoaster coasterToaster = new rollercoaster();
        
        ImageIcon my_icon = new ImageIcon("./Images/disney_world_logo.png");

        String [] btn_options = {"Leave","Purchase a Ticket","See Attraction List"};
        String [] btn_options2 = {"Leave","Check Ticket","See Attraction List"};
        String [] yn_options = {"Yes!", "No"};
        String [] be_options = {"Main Menu", "Back"};
        String [] attractions = {"Back","Basic Buggy","Relatively Extrema","Coaster Toaster"};
        boolean leave = false;
        boolean justEntered = true;
        int result = 0;
        
        while(!leave){
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
                int partySize = Integer.valueOf(JOptionPane.showInputDialog("How many people are in your party?"));
                ArrayList<Rider> riders = new ArrayList<Rider>();
                for(int i = 0; i < partySize; i++){
                    JOptionPane.showMessageDialog(null,"Enter Party Member " + (i+1) + " Information", "DisneyLand", JOptionPane.PLAIN_MESSAGE);
                    String name = JOptionPane.showInputDialog("Name:");
                    int height = Integer.valueOf(JOptionPane.showInputDialog("Height(in inches):"));
                }
                result = JOptionPane.showOptionDialog(null, "Would you like to get a fast pass?", null, JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE,my_icon, yn_options,1);
                boolean hasFP = false;
                if(result == 0)
                hasFP = true;
                double balance = Double.valueOf(JOptionPane.showInputDialog("Please enter your starting balance"));
                
                Ticket t = new Ticket(riders,hasFP,balance);
                t.printParty();
                while(!leave){
                    result = JOptionPane.showOptionDialog(null, "What would you like to do next?", "Main Menu",
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, my_icon, btn_options2, 2);
                    if(result == 0){//see attraction option
                        JOptionPane.showMessageDialog(null, "Thank you for visiting!", "DisneyLand",JOptionPane.INFORMATION_MESSAGE,my_icon);
                        leave = true;
                    }
                    else if(result == 1){//check ticket option
                        boolean looking = true;
                        
                        while(looking){
                            String [] options = {"Back","Deposit","Withdraw"};
                            if(!t.hasFastPass()){
                                String [] temp = {"Back","Deposit","Withdraw", "Get Fast Pass"};
                                options = temp;
                            }
                            
                            result = JOptionPane.showOptionDialog(null, "What would you like to do?", "DisneyWorld",
                            JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, my_icon, options, 0);
                            
                            if(result == 0)
                                looking = false;
                            else if(result == 1){//Deposit option
                                double value = Double.valueOf(JOptionPane.showInputDialog("How much would you like to deposit?"));
                                t.deposit(value);
                            }
                            else if(result == 2){//Withdraw option
                                double value = Double.valueOf(JOptionPane.showInputDialog("How much would you like to deposit?"));
                                t.withdraw(value);
                            }
                            else if(result == 3){//Get Fast Pass option
                                t.getFastPass();
                            }
                        }
                    }
                    else{//see attraction option
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
                }
            }
            else if(result == 2){//user selected leave
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
        }
    }  
}