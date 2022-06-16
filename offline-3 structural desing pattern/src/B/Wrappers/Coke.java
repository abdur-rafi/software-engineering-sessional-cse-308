package B.Wrappers;

import B.Burger;

public class Coke extends BurgerWrapper {
    private double cokeCost = 20;


    public Coke(Burger burger){
        this.burger = burger;
    }


    @Override
    public String description() {
        return burger.description() + ", coke";
    }

    @Override
    public double cost() {
        return burger.cost() + cokeCost;
    }
}

