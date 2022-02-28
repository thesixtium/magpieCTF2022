import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class main {

    static String[] mom;
    static String[] omni;

    private static String[] readFile(String filename) {

        // list that holds strings of a file
        List<String> listOfStrings = new ArrayList<String>();
        // load data from file
        BufferedReader bf;

        try {
            bf = new BufferedReader(new FileReader(filename + ".txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(filename + " not found, " + e.getMessage());
        }

        try {
            // read entire line as string
            String line = bf.readLine();

            // checking for end of file
            while (line != null) {
                listOfStrings.add(line.split("\t")[0]);
                line = bf.readLine();
            }
        } catch (Exception e){
            throw new RuntimeException("Error reading file, exception caught " + e.getMessage());
        }

        // closing bufferreader object
        try {
            bf.close();
        } catch (IOException e) {
            throw new RuntimeException("Error closing file, exception caught " + e.getMessage());
        }

        // storing the data in arraylist to array
        return listOfStrings.toArray(new String[0]);
    }

    public static void main(String[] args) {
        mom = readFile("mom");
        omni = readFile("omni");

        for(String x: mom){
            var printString = true;
            for(String y: omni){
                if (x.equals(y)) {
                    printString = false;
                    break;
                }
            }
            if(printString){System.out.println(x);
            }
        }
    }
}
