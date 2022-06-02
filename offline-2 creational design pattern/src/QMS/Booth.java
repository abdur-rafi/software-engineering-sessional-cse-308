package QMS;

import java.util.ArrayList;

public class Booth {

    private ArrayList<Part> parts;
    private int yearlyCost;
    public Booth() {
        parts = new ArrayList<>();
    }

    public void show(){
        for(Part p : parts){
            System.out.println(p.describe());
        }
    }

    public void addPart(Part p){
        parts.add(p);
    }

    public void setYearlyCost(int cost){
        this.yearlyCost = cost;
    }
}
