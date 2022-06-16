import A.BlankSeparatorAdapter;
import B.Burger;
import B.Burgers.BeefBurger;
import B.Burgers.VeggiBurger;
import B.WrapperFactory;
import B.WrapperType;

import java.util.Scanner;

public class main {

    public static void demoA(){
        System.out.print("Enter file Name: ");
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.next();
        BlankSeparatorAdapter adapter = new BlankSeparatorAdapter();
        System.out.println( "Sum: " + adapter.calculateSum(fileName));

    }

    public static void demoB(){
        WrapperFactory factory = new WrapperFactory();
        Burger beefBurger = new BeefBurger();
        beefBurger = factory.getWrapper(beefBurger, WrapperType.FrenchFries);
        System.out.println("Order description: " + beefBurger.description());
        System.out.println("Cost: " + beefBurger.cost());

        Burger veggi = new VeggiBurger();
        veggi = factory.getWrapper(veggi, WrapperType.OnionRings);
        veggi = factory.getWrapper(veggi, WrapperType.Water);

        System.out.println("Order description: " + veggi.description());
        System.out.println("Cost: " + veggi.cost());

        Burger veggi2 = new VeggiBurger();
        veggi2 = factory.getWrapper(veggi2, WrapperType.FrenchFries);
        veggi2 = factory.getWrapper(veggi2, WrapperType.Coke);
        System.out.println("Order description: " + veggi2.description());
        System.out.println("Cost: " + veggi2.cost());

        Burger veggi3 = new VeggiBurger();
        veggi3 = factory.getWrapper(veggi3, WrapperType.OnionRings);
        veggi3 = factory.getWrapper(veggi3, WrapperType.Coffee);
        veggi3 = factory.getWrapper(veggi3, WrapperType.Water);
        System.out.println("Order description: " + veggi3.description());
        System.out.println("Cost: " + veggi3.cost());


        Burger beefBurger2 = new BeefBurger();
        System.out.println("Order description: " + beefBurger2.description());
        System.out.println("Cost: " + beefBurger2.cost());


    }

    public static void main(String[] args){
//        demoA();
        demoB();
    }
}
