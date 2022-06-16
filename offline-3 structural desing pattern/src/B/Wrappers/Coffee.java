package B.Wrappers;

import B.Burger;

public class Coffee extends BurgerWrapper {
    private double coffeeCost = 30;

    public Coffee(Burger burger){
        this.burger = burger;
    }

    @Override
    public String description() {
        return burger.description() + ", coffee";
    }

    @Override
    public double cost() {
        return burger.cost() + coffeeCost;
    }
}

