package B.Wrappers;

import B.Burger;

public class Cheese extends BurgerWrapper {
    private double cheeseCost = 20;

    public Cheese(Burger burger){
        this.burger = burger;
    }

    @Override
    public String description() {
        return burger.description() + ", cheese";
    }

    @Override
    public double cost() {
        return burger.cost() + cheeseCost;
    }
}
