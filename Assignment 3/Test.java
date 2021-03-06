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
        float total_comparisons_linear = 0;
        for(String i: random_words){
            Linear linear = new Linear();
            // search for target i
            linear.linear_search(sorted_words0, i);
            System.out.println(linear.comparisons);
            total_comparisons_linear += linear.comparisons;
        }
        System.out.println("Average number of Comparisons for Linear Search:" + total_comparisons_linear/42);

        //getting comparisons for binary search
        float total_comparisons_binary = 0;
        for(String i: random_words){
            Binary binary = new Binary();
            // start recursion with entire sorted_words0 array of Strings
            binary.binary_search(sorted_words0, 0, sorted_words0.length-1, i);
            System.out.println(binary.comparisons);
            total_comparisons_binary += binary.comparisons;
        }
        System.out.println("Average number of Comparisons for Binary Search:" + total_comparisons_binary/42);

        // Hash Testing
        // Print the array and hash values.
        Hashing hashing = new Hashing();
        int[] hashValues = new int[hashing.LINES_IN_FILE];
        int hashCode = 0;
        for (int i = 0; i < hashing.LINES_IN_FILE; i++) {
//            System.out.print(i);
//            System.out.print(". " + copy_words0[i] + " - ");
            hashCode = hashing.doHashCode(copy_words0[i]);
//            System.out.format("%03d%n", hashCode);
            hashValues[i] = hashCode;
        }
        // get the hash values for target values
        int[] target_hashValues = new int[random_words.length];
        for (int i = 0; i < random_words.length; i++) {
            // Get the hash code for the target String
//            System.out.print(i);
//            System.out.print(". " + random_words[i] + " - ");
            hashCode = hashing.doHashCode(random_words[i]);
//            System.out.format("%03d%n", hashCode);
            target_hashValues[i] = hashCode;
        }
        //Testing for relative sorting in Hashing Class
//        RelativeInsertionSort relativeInsertionSort = new RelativeInsertionSort();
//        relativeInsertionSort.relative_insertionSort(hashValues, copy_words0);
//        for (int i: hashValues){
//            System.out.println(i);
//        }
//        for (String j: copy_words0){
//            System.out.println(j);
//        }

        hashing.populate_retrieveTargets(target_hashValues, random_words, hashValues, copy_words0);
        System.out.println(hashing.comparisons);

        // Analyze the distribution of hash values.
//        hashing.analyzeHashValues(hashValues);
    }
}