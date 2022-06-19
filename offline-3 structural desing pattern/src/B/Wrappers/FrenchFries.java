package B.Wrappers;

import B.Burger;
import B.MultipleAppetizer;

public class FrenchFries extends BurgerWrapper {
    private double frenchFriesCost = 25;



    public FrenchFries(Burger burger) throws MultipleAppetizer {
        if(burger.appetizerAdded()){
            throw new MultipleAppetizer("Appetizer added already");
        }
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
    @Override
    public boolean appetizerAdded() {
        return true;
    }
}

