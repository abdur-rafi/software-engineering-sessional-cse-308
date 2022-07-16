package A;

import java.util.Scanner;

public class DemoA {

    public static void demo(){
        System.out.print("Enter file Name: ");
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.next();
        BlankSeparatorAdapter adapter = new BlankSeparatorAdapter();
        System.out.println( "Sum: " + adapter.calculateSum(fileName));

    }

}
