import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.ArrayList;

public class DuplicateRemover {
    private LinkedList<String> uniqueWords  = new LinkedList<String>();
    private ArrayList<String> repeated = new ArrayList<>();
    private int j,i;
    PrintWriter outFile;
    Scanner inFile;
    /*
    * Create a utility class called DuplicateRemover.
    *  Create an instance method called remove that takes a single parameter called dataFile (representing
    * the path to a text file) and uses a Set of Strings to eliminate duplicate words from dataFile.
    *
    *  The unique words should be stored in an instance variable called uniqueWords.
    *
    * Create an instance method called write that takes a single parameter called outputFile (representing
    * the path to a text file) and writes the words contained in uniqueWords to the file pointed to by outputFile.
    *
    *  The output file should be overwritten if it already exists, and created if it does not exist.
    * */

   public void remove(FileInputStream dataFile) throws IOException {

       inFile = new Scanner(dataFile);
       String temp;
       i = 0;
        while(inFile.hasNextLine()) {
            temp = inFile.nextLine();
            uniqueWords.add(temp);
        }
        for (i=0; i < uniqueWords.size(); i++){
            String repetition = uniqueWords.get(i);
            for (j=0; j <i; j++){
                if (uniqueWords.get(j).equals(repetition)){
                    repeated.add(uniqueWords.get(i));
                }
            }
        }
        for (i=0; i < repeated.size(); i++){
            uniqueWords.remove(repeated.get(i));
        }
        for(i=0; i < uniqueWords.size(); i++) {
            System.out.println(uniqueWords.get(i));
        }
       System.out.println("Closing In file");
       dataFile.close();
    }

   public void write (FileOutputStream outputFile) throws IOException {
       outFile = new PrintWriter(outputFile);
       for(i=0; i < uniqueWords.size(); i++) {
           outFile.println(uniqueWords.get(i));
       }
       outFile.flush();
         System.out.println("Closing Out file");
         outputFile.close();

   }

}
