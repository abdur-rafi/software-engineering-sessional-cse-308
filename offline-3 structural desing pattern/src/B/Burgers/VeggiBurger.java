package B.Burgers;

import B.Burger;

public class VeggiBurger implements Burger {
    @Override
    public String description() {
        return "Veggi Burger";
    }

    @Override
    public double cost() {
        return 60;
    }
    @Override
    public boolean appetizerAdded() {
        return false;
    }

}

