package B.Burgers;

import B.Burger;

public class BeefBurger implements Burger {
    @Override
    public String description() {
        return "Beef Burger";
    }

    @Override
    public double cost() {
        return 120;
    }
}
