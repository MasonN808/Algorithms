import javax.swing.plaf.synth.SynthUI;
import java.io.*;
import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        String[] words = {};
        // Read line by line the txt file using File reader
        String fileName = "Assignment 1/magicitems";
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
        // Start of testing for sorting
        // Testing of selection sort algorithm
        String[] copy_words0 = words.clone();
        SelectionSort s_sort = new SelectionSort();
        for (String i : s_sort.selectionSort(copy_words0)) {
//            System.out.println(i);
        }
        System.out.println("Number of Comparisons for Selection Sort: " + s_sort.comparisons);

        // Testing of insertion sort algorithm
        String[] copy_words1 = words.clone();
        InserstionSort i_sort = new InserstionSort();
        for (String i : i_sort.insertionSort(copy_words1)) {
//            System.out.println(i);
        }
        System.out.println("Number of Comparisons for Insertion Sort: " + i_sort.comparisons);

        // Testing of insertion sort algorithm
        String[] copy_words2 = words.clone();
        InserstionSort m_sort = new InserstionSort();
        for (String i : i_sort.insertionSort(copy_words1)) {
//            System.out.println(i);
        }
        System.out.println("Number of Comparisons for Insertion Sort: " + i_sort.comparisons);


//        for (String i : (words)) {
//            System.out.println(i);
//        }
    }
}
