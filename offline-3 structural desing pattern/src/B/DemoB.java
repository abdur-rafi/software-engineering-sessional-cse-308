package B;

import B.Burgers.BeefBurger;
import B.Burgers.VeggiBurger;

public class DemoB {

    public static void demo(){
        try {
            WrapperFactory factory = new WrapperFactory();
//            order - 1
            Burger beefBurger = new BeefBurger();
            beefBurger = factory.getWrapper(beefBurger, WrapperType.FrenchFries);
            beefBurger = factory.getWrapper(beefBurger, WrapperType.Cheese);

            System.out.println("Order description: " + beefBurger.description());
            System.out.println("Cost: " + beefBurger.cost());

//            order - 2

            Burger veggi = new VeggiBurger();
            veggi = factory.getWrapper(veggi, WrapperType.OnionRings);
            veggi = factory.getWrapper(veggi, WrapperType.Water);

            System.out.println("Order description: " + veggi.description());
            System.out.println("Cost: " + veggi.cost());
//            order - 3

            Burger veggi2 = new VeggiBurger();
            veggi2 = factory.getWrapper(veggi2, WrapperType.FrenchFries);
            veggi2 = factory.getWrapper(veggi2, WrapperType.Coke);
            System.out.println("Order description: " + veggi2.description());
            System.out.println("Cost: " + veggi2.cost());
//            order - 4

            Burger veggi3 = new VeggiBurger();
            veggi3 = factory.getWrapper(veggi3, WrapperType.OnionRings);
            veggi3 = factory.getWrapper(veggi3, WrapperType.Coffee);
            veggi3 = factory.getWrapper(veggi3, WrapperType.Water);
            System.out.println("Order description: " + veggi3.description());
            System.out.println("Cost: " + veggi3.cost());

//            order - 5

            Burger beefBurger2 = new BeefBurger();
            System.out.println("Order description: " + beefBurger2.description());
            System.out.println("Cost: " + beefBurger2.cost());

        }
        catch (MultipleAppetizer e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
