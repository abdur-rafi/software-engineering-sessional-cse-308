import A.DemoA;
import B.DemoB;

import java.util.InputMismatchException;
import java.util.Scanner;

public class main {

    public static void main(String[] args){
        try {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("Assignment No: ");
                int t = scanner.nextInt();
                if (t == 1) {
                    DemoA.demo();
                } else if (t == 2) {
                    DemoB.demo();
                } else break;
            }
        } catch (InputMismatchException e){
            e.printStackTrace();
        }
    }
}
