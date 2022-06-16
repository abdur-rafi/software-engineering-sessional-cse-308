package B.Wrappers;

import B.Burger;

public class FrenchFries extends BurgerWrapper {
    private double frenchFriesCost = 25;



    public FrenchFries(Burger burger){
        this.burger = burger;
    }


    @Override
    public String description() {

        return burger.description() + ", french fries";
    }

    @Override
    public double cost() {
        return burger.cost() + frenchFriesCost ;
    }
}

