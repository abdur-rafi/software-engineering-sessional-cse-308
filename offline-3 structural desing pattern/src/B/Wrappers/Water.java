package B.Wrappers;

import B.Burger;

public class Water extends BurgerWrapper {
    private double waterCost = 15;


    public Water(Burger b){
        this.burger = b;
    }

    @Override
    public String description() {
        return burger.description() + ", water";
    }

    @Override
    public double cost() {
        return burger.cost() + waterCost;
    }
    @Override
    public boolean appetizerAdded() {
        return burger.appetizerAdded();
    }
}

