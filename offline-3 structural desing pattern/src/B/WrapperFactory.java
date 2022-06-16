package B;

import B.Wrappers.*;

public class WrapperFactory {

    public BurgerWrapper getWrapper(Burger b, WrapperType type){
        if(type == WrapperType.Cheese)
            return new Cheese(b);
        else if(type == WrapperType.Coffee)
            return new Coffee(b);
        else if(type == WrapperType.Water)
            return new Water(b);
        else if(type == WrapperType.Coke)
            return new Coke(b);
        else if (type == WrapperType.OnionRings)
            return new OnionRings(b);
        else if(type == WrapperType.FrenchFries)
            return new FrenchFries(b);
        return null;
    }
}
