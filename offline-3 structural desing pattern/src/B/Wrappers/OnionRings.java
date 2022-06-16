package B.Wrappers;

import B.Burger;

public class OnionRings extends BurgerWrapper {
    private double onionRingCost = 20;



    public OnionRings(Burger burger){
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
}

