package OtherFunctions;

public class Rider{
    private String name;
    private int height; //in inches

    public Rider(String n, int height){
        name = n;
        this.height = height;
    }

    public String getName(){
        return name;
    }

    public int getHeight(){
        return height;
    }
}