package OtherFunctions;

import Foods.Food;
import Drinks.Drink;
import java.util.*;

public class concessionStand{
    private double runningCost;
    private String name; //name of the concession stand
    private double gain; //money gained from purchase
    private ArrayList<Food> foods = new ArrayList<Food>(); //array of all the food they are serving
    private ArrayList<Drink> drinks = new ArrayList<Drink>(); //array of all the food they are serving

    public concessionStand(){
        name = "Concession Stand";
        runningCost = 1;
    }

    public concessionStand(String n, double rC, ArrayList<Food> f, ArrayList<Drink> d){
        name = n;
        runningCost = rC;
        foods = f;
        drinks = d;
    }

    public void displayMenu(){
        System.out.println("Food Items:");
        for(Food food : foods){
            System.out.println(food.getName() + " Price: $" + food.getPrice());
        }

        System.out.println("\nDrink Items:");
        for(Drink drink : drinks){
            System.out.println(drink.getName() + " Price: $" + drink.getPrice());
        }
    }
    public void buyFood(Ticket t, Food f){
        t.withdraw(f.getPrice());
        gain += f.getPrice();
    }

    public void buyDrink(Ticket t, Drink d){
        t.withdraw(d.getPrice());
        gain += d.getPrice();
    }

    public void buyCombo(Ticket t, Food f, Drink d){ //a combo cost less than if buy each item separately
        t.withdraw(f.getPrice()*.8 + d.getPrice()*.2);
        gain += f.getPrice()*.8 + d.getPrice()*.2;
    }

    public double totalProfit(){
        return gain - runningCost;
    }
}
