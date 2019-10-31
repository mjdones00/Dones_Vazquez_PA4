import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class Application {
    /*
     Create a separate class called Application that contains a main method which illustrates the use of
    * DuplicateRemover by calling both the remove and write methods.
    * Your input file must be called problem1.txt and your output file must be called unique_words.txt.
    * You will not receive credit if you use different file names,
    *  as my graders will not modify your code to make it work with their test files.
     */
    public static void main(String[] args)throws IOException {
        DuplicateRemover dupRemov = new DuplicateRemover();
        FileInputStream fileInByteStream;
        FileOutputStream fileOutByteStream;

        System.out.println("opening In file");
        fileInByteStream = new FileInputStream("problem1.txt");

        dupRemov.remove(fileInByteStream);

        System.out.println("Opening Out file");
        fileOutByteStream = new FileOutputStream("unique_words.txt",false);

        dupRemov.write(fileOutByteStream);

    }
}
