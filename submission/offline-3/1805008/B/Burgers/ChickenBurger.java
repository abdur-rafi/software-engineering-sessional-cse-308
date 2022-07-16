package B.Burgers;

import B.Burger;

public class ChickenBurger implements Burger {
    @Override
    public String description() {
        return "Chicken Burger";
    }

    @Override
    public double cost() {
        return 80;
    }
    @Override
    public boolean appetizerAdded() {
        return false;
    }

}
