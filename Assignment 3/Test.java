import java.io.*;
import java.util.Arrays;
import java.util.Random;

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
        String[] copy_words0 = words.clone();
        //Sort the words using insertion sort
        InserstionSort i_sort = new InserstionSort();
        i_sort.insertionSort(copy_words0);
        // check if copy_words0 is sorted
//        for (String i: copy_words0){
//            System.out.println(i);
//        }
        // rename copy as sorted
        String[] sorted_words0 = copy_words0;
        // initialize random generator to generate random index from length of array
        Random generator = new Random();
        String[] random_words = {};
        for(int i = 0; i < 42; i++){
            int randomIndex = generator.nextInt(sorted_words0.length);
            random_words = Arrays.copyOf(random_words, random_words.length + 1); //extends memory
            random_words[random_words.length-1] = sorted_words0[randomIndex];
        }
        // test the 42 random words from sorted_words0
//        for(String i: random_words){
//            System.out.println(i);
//        }
        // getting comparisons for linear search
        int total_comparisons = 0;
        for(String i: random_words){
            Linear linear = new Linear();
            linear.linear_search(sorted_words0, i);
            System.out.println(linear.comparisons);
            total_comparisons += linear.comparisons;
        }
        System.out.println("Average number of Comparisons:" + total_comparisons/42);
    }
}