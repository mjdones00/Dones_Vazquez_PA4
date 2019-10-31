import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Application {
    public static void main (String[] args) throws IOException {
        DuplicateCounter duplicateCounter = new DuplicateCounter();
        FileInputStream fileInByteStream;
        FileOutputStream fileOutByteStream;

        System.out.println("opening In file");
        fileInByteStream = new FileInputStream("problem2.txt");

        duplicateCounter.count(fileInByteStream);

        System.out.println("Opening Out file");
        fileOutByteStream = new FileOutputStream("unique_word_counts.txt",false);

        duplicateCounter.write(fileOutByteStream);


    }
}
