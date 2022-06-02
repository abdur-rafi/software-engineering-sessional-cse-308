import QMS.Booth;
import QMS.BuilderFactory;
import QMS.Builders.IBuilder;
import QMS.Director;

import java.util.Scanner;

public class main {

    public static void ShowQms(){
        Director director = new Director();
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.print("Enter package type / enter \"exit\" to exit: ");
            String pkg = scanner.next();
            if(pkg.equalsIgnoreCase("exit")){
                break;
            }
            System.out.print("Enter communication channel type : ");

            String commChannel = scanner.next();
            System.out.print("Number of display units: ");
            int numberOfDisplayUnits = scanner.nextInt();

            IBuilder builder = BuilderFactory.getFactory().getBuilder(pkg, commChannel, numberOfDisplayUnits);
            director.Construct(builder);
            Booth product = builder.getProduct();
            product.show();

        }
    }

    public static void main(String[] args){
        ShowQms();
    }
}
