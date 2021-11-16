import java.io.*;
import java.util.Arrays;
import java.util.Random;

public class Test {

    public static void main(String[] args) {
        String[] words = {};
        // Read line by line the txt file using File reader
        String fileName = "Assignment 3/magicitems";
        File file = new File(fileName);
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                // add strings from txt file line by line into array words
                words = Arrays.copyOf(words, words.length + 1); //extends memory
                words[words.length - 1] = line; //adds word to extra memory
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] copy_words0 = words.clone();
        //Sort the words using insertion sort

    }
}