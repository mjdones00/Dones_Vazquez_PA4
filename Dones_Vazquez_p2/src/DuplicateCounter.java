import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Scanner;

public class DuplicateCounter {
    Scanner scnr;
    HashMap <String, Integer> wordCount = new HashMap<String, Integer>();
    int i;
    PrintWriter outFile;

    public void count (FileInputStream dataFile) throws IOException {
        scnr = new Scanner(dataFile);
        String tempString;
        while (scnr.hasNext()){
            tempString =  scnr.next();

          if (wordCount.containsKey(tempString)) {
              Integer count = wordCount.get(tempString);
              wordCount.put(tempString, count + 1);
          }
          else
              wordCount.put(tempString,1);

      }
        System.out.println("Closing In file");
        dataFile.close();
    }

    public void write (FileOutputStream outputFile) throws IOException {
        outFile = new PrintWriter(outputFile);
        for(Object set : wordCount.keySet()){
            outFile.print(set);
            outFile.println(" " + wordCount.get(set));
        }
        outFile.flush();

        System.out.println("Closing Out file");
        outputFile.close();
    }
}
