package A;

import java.io.*;

public class BlankSeparatorAdapter implements TildeSeparatorInterface {

    private final BlankSeparator blankSeparator;

    public BlankSeparatorAdapter() {
        this.blankSeparator = new BlankSeparator();
    }

    @Override
    public double calculateSum(String fileName) {

        try {
//            File tmpFile = File.createTempFile("___", ".tmp");
            FileReader fileReader = new FileReader(fileName);
            File tmpFile = new File("___.txt");
            FileWriter fileWriter = new FileWriter(tmpFile);
            char[] buffer = new char[1000];
            while(true){
                int c = fileReader.read(buffer);
                if(c == -1) break;
                String t = new String(buffer, 0, c);
                t = t.replace("~", " ");
                fileWriter.write(t);
            }
            fileWriter.flush();
            fileWriter.close();
            double s = blankSeparator.calculateSum(tmpFile.getName());
            fileReader.close();
            tmpFile.delete();
            return s;
        } catch (IOException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
        return 0;
    }
}
