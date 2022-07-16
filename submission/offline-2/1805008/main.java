import Editor.Editor;
import QMS.Booth;
import QMS.BuilderFactory;
import QMS.Builders.IBuilder;
import QMS.Director;

import java.util.Scanner;

public class main {

    public static void ShowQms(){
        Director director = new Director();
        Scanner scanner = new Scanner(System.in);
        BuilderFactory builderFactory = new BuilderFactory();
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

            IBuilder builder = builderFactory.getBuilder(pkg, commChannel, numberOfDisplayUnits);
            director.Construct(builder);
            Booth product = builder.getProduct();
            product.show();

        }
    }

    public static void ShowEditor(){
        Editor editor = Editor.getEditor();
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("Enter filename: ");
            String fileName = scanner.next();
            if(fileName.equalsIgnoreCase("exit"))
                break;
            editor.Parse(fileName);
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("QMS: 1, Editor: other");
        int what = scanner.nextInt();
        if(what == 1){
            ShowQms();
        }
        else{
            ShowEditor();
        }
    }
}
