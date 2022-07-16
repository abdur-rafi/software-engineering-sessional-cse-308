package B.Wrappers;

import B.Burger;
import B.MultipleAppetizer;

public class OnionRings extends BurgerWrapper {
    private double onionRingCost = 20;



    public OnionRings(Burger burger) throws MultipleAppetizer {
        if(burger.appetizerAdded()){
            throw new MultipleAppetizer("Appetizer added already");
        }
        this.burger = burger;
     }


    @Override
    public String description() {
        return burger.description() + ", onion rings";
    }

    @Override
    public double cost() {
        return burger.cost() + onionRingCost ;
    }
    @Override
    public boolean appetizerAdded() {
        return true;
    }
}

