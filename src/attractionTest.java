package src;

import java.util.*;
import src.Rides.*;
import src.OtherFunctions.*;
import src.Foods.*;
import src.Drinks.*;

/**
 * Write a description of class attractionTest here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class attractionTest
{
    public static void attractionTest()
    {
        //testing ArrayList
        ArrayList<Rider> party1 = new ArrayList<Rider>();
        party1.add(new Rider("Josie",48)); party1.add(new Rider("Lauren",56)); party1.add(new Rider("Alyssa",47)); party1.add(new Rider("Chloe",49)); 
        ArrayList<Rider> party2 = new ArrayList<Rider>();
        party2.add(new Rider("Maddy",51)); party2.add(new Rider("Eva",63)); party2.add(new Rider("Molly",39)); 
        ArrayList<Rider> party3 = new ArrayList<Rider>();
        party3.add(new Rider("Virginia",33)); party3.add(new Rider("Freya",44)); party3.add(new Rider("Anna",50));
        party3.add(new Rider("Yanka",45)); party3.add(new Rider("Mary",61)); party3.add(new Rider("Elizabeth",56)); 
        ArrayList<Rider> party4 = new ArrayList<Rider>();
        party4.add(new Rider("Julia",50)); party4.add(new Rider("Emery",56));party4.add(new Rider("Jasmine",55)); party4.add(new Rider("Piper",51)); 
        ArrayList<Rider> party5 = new ArrayList<Rider>();
        party5.add(new Rider("Alana",44)); party5.add(new Rider("Tess",41)); party5.add(new Rider("Nnenna",45)); party5.add(new Rider("Sadie",39));
        
        Ticket p1 = new Ticket(party1, true, 130.00);
        Ticket p2 = new Ticket(party2, false, 80.00);
        Ticket p3 = new Ticket(party3, true, 110.00);
        Ticket p4 = new Ticket(party4, false, 2.00); //not enough money, need 4.00 to ride
        
        Attraction a1 = new Attraction();
        a1.getInLine(p1); a1.getInLine(p2); a1.getInLine(p3); a1.getInLine(p4);
        a1.printLine();
        /* Expected Name Print:
         * Josie Lauren Chloe 
         * Anna Mary Elizabeth 
         * Maddy Eva 
         * Julia Emery Jasmine Piper
         */
        System.out.println("----");
        a1.run();
        a1.printLine();
        /* Expected Name Print:
         * --- none names
         */
    
    }
    
    public static void rollercoasterTest()
    {
        //testing ArrayList
        ArrayList<Rider> party1 = new ArrayList<Rider>();
        party1.add(new Rider("Josie",48)); party1.add(new Rider("Lauren",56)); party1.add(new Rider("Alyssa",47)); party1.add(new Rider("Chloe",49)); 
        ArrayList<Rider> party2 = new ArrayList<Rider>();
        party2.add(new Rider("Maddy",51)); party2.add(new Rider("Eva",63)); party2.add(new Rider("Molly",39)); 
        ArrayList<Rider> party3 = new ArrayList<Rider>();
        party3.add(new Rider("Virginia",33)); party3.add(new Rider("Freya",44)); party3.add(new Rider("Anna",50));
        party3.add(new Rider("Yanka",45)); party3.add(new Rider("Mary",61)); party3.add(new Rider("Elizabeth",56)); 
        ArrayList<Rider> party4 = new ArrayList<Rider>();
        party4.add(new Rider("Julia",50)); party4.add(new Rider("Emery",56));party4.add(new Rider("Jasmine",55)); party4.add(new Rider("Piper",51)); 
        ArrayList<Rider> party5 = new ArrayList<Rider>();
        party5.add(new Rider("Alana",44)); party5.add(new Rider("Tess",41)); party5.add(new Rider("Nnenna",45)); party5.add(new Rider("Sadie",39));
        
        Ticket p1 = new Ticket(party1, true, 130.00);
        Ticket p2 = new Ticket(party2, false, 80.00);
        Ticket p3 = new Ticket(party3, true, 110.00);
        Ticket p4 = new Ticket(party4, false, 2.00); //not enough money, need 4.00 to ride
        
        Rollercoaster r1 = new Rollercoaster();
        r1.getInLine(p1); r1.getInLine(p2); r1.getInLine(p3); r1.getInLine(p4);
        r1.printLine();
        /* Expected Name Print:
         * Fast Pass Line:
         * Josie Lauren Chloe 
         * Anna Mary Elizabeth 
         *
         * Regular Pass Line:
         * Maddy Eva 
         * Julia Emery Jasmine Piper
         */
        
        System.out.println("----");
        r1.run();//run somehow activate the scanner shark was here :)
        r1.printLine();
        /* Expected Name Print:
         * Fast Pass Line:
         * Anna Mary Elizabeth 
         *
         * Regular Pass Line:
         * Julia Emery Jasmine Piper
         */
        
    }
    
    public static void itsASmallWOrldTest(){
        ArrayList<Rider> party1 = new ArrayList(); 
        party1.add(new Rider("bob", 70)); party1.add(new Rider("lucy",  65));
        Ticket t1 = new Ticket(party1, true, 200);
        ArrayList<Rider> party2 = new ArrayList(); 
        party2.add(new Rider("karen", 66)); party2.add(new Rider("charle",  72));
        Ticket t2 = new Ticket(party2, false, 45);
        
        itsASmallWorld s1 = new itsASmallWorld();
        s1.scanTicket(t1);
        s1.go();
    }
    
    public static void concessionTest(){
        ArrayList<Food> foods = new ArrayList<Food>();
        foods.add(new Hamburger()); foods.add(new ChickenTenders()); foods.add(new HotDog()); foods.add(new Fries());
        ArrayList<Drink> drinks = new ArrayList<Drink>();
        drinks.add(new Soda("Coca Cola",16,true,false,4.5)); drinks.add(new Tea("Iced Tea",8,true,true,5.0)); drinks.add(new Coffee("Mickey's Coffee Delight",8,false,true,true,6.0)); 
        
        ConcessionStand s1 = new ConcessionStand("Fantasy Flare",100,foods,drinks);
    }
}
