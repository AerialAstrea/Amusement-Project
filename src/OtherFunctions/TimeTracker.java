package src.OtherFunctions;

import java.util.*;

public class TimeTracker
{
    private double time;
    private int hr,min,sec;
    
    public TimeTracker(){
        var current = new Date();
        hr = current.getHours();
        min = current.getMinutes();
        sec = current.getSeconds();
        time = hr + min/60.0 + sec/60.00/60.00;
    }
    
    public void updateTime(){
        var current = new Date();
        hr = current.getHours();
        min = current.getMinutes();
        sec = current.getSeconds();
        time = hr + min/60.0 + sec/60.00/60.00;
    }
    
    public double getTime(){
        updateTime();
        return time;
    }
    
    public String toString(){
        return "The time is : " + time;
    }
    
    public static void main(){
        System.out.println(new TimeTracker());
    }
}
