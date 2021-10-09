import javax.swing.plaf.synth.SynthUI;
import java.io.*;
import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        String[] words = {};
        // Read line by line the txt file using File reader
        String fileName = "Assignment 2/magicitems";
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
        Shuffle shuffler = new Shuffle();
        String[] copy_words0 = words.clone();
        //shuffle the words
        copy_words0 = shuffler.shuffle(copy_words0);
        SelectionSort s_sort = new SelectionSort();
        s_sort.selectionSort(copy_words0);
//        for (String i : s_sort.selectionSort(copy_words0)) {
//            System.out.println(i);
//        }
        System.out.println("Number of Comparisons for Selection Sort: " + s_sort.comparisons);

        // Testing of insertion sort algorithm
        String[] copy_words1 = words.clone();
        //shuffle the words
        copy_words1 = shuffler.shuffle(copy_words1);
        InserstionSort i_sort = new InserstionSort();
        i_sort.insertionSort(copy_words1);
//        for (String i : i_sort.insertionSort(copy_words1)) {
//            System.out.println(i);
//        }
        System.out.println("Number of Comparisons for Insertion Sort: " + i_sort.comparisons);

        // Testing of merge sort algorithm
        String[] copy_words2 = words.clone();
        //shuffle the words
        copy_words2 = shuffler.shuffle(copy_words2);
        MergeSort m_sort = new MergeSort();
        m_sort.mergeSort(copy_words2, copy_words2.length);
//        for (String i : copy_words2) {
//            System.out.println(i);
//        }
        System.out.println("Number of Comparisons for Merge Sort: " + m_sort.comparisons);

        // Testing of quick sort algorithm
        String[] copy_words3 = words.clone();
        //shuffle the words
        copy_words3 = shuffler.shuffle(copy_words3);
        QuickSort q_sort = new QuickSort();
        q_sort.quickSort(copy_words3, 1, copy_words3.length-1);
//        for (String i : copy_words3) {
//            System.out.println(i);
//        }
        System.out.println("Number of Comparisons for Quick Sort: " + q_sort.comparisons);

//      for (String i : (words)) {
//            System.out.println(i);
//        }

    }
}
