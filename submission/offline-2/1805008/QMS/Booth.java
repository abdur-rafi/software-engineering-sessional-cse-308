package QMS;

import java.util.ArrayList;

public class Booth {

    private ArrayList<Part> parts;
    private int yearlyCost;
    public Booth() {
        parts = new ArrayList<>();
    }

    public void show(){
        System.out.println("System parts:");
        int cost = 0;
        for(Part p : parts){
            System.out.println(p.describe());
            cost += p.getCost();
        }
        cost += yearlyCost;

        System.out.println("Total cost : " + cost);
    }

    public void addPart(Part p){
        parts.add(p);
    }

    public void setYearlyCost(int cost){
        this.yearlyCost = cost;
    }
}
