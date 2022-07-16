package A;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BlankSeparator implements BlankSeparatorInterface {

    @Override
    public double calculateSum(String fileName) {
        double s = 0;

        Scanner scanner;

        try{
            scanner = new Scanner(new File(fileName));
        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
            e.printStackTrace();
            return 0;
        }
        try {

            while (scanner.hasNextDouble()) {

                s += scanner.nextDouble();
            }
            scanner.close();
        }
        catch (InputMismatchException e){
            System.out.println("File contains invalid content");
        }
        return s;

    }
}
