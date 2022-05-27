package src.otherFunctions;

import javax.swing.ImageIcon;

public class beParkGoer {
    public static void main(){
        Attraction a1 = new Attraction();
        Attraction a2 = new Attraction(10, 2.0, 1.0, 1.75/60.00, 50); //maxRider, ticketPrice, runCost, rideLen, minH

        ImageIcon my_icon = new ImageIon("./Images/disney_world_logo.png");

        String [] btn_options = {"See Attraction List", "Purchase/Check a Ticket", "Leave"};

        System.out.println("hi");

        JOptionPane.showOptionDialog(null, "Welcome to the park! What would you like to do?", "DisneyWorld",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, my_icon, btn_options, 2);
    }
}
