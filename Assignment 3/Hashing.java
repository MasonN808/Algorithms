import java.util.Arrays;
import java.io.FileReader;
import java.io.BufferedReader;

public class Hashing {
    public final String FILE_NAME = "Assignment 3/magicitems";
    public final int LINES_IN_FILE = 666;
    public final int HASH_TABLE_SIZE = 250;
    int comparisons = 0;



    public int doHashCode(String str) {
        str = str.toUpperCase();
        int length = str.length();
        int letterTotal = 0;

        // Iterate over all letters in the string, totalling their ASCII values.
        for (int i = 0; i < length; i++) {
            char thisLetter = str.charAt(i);
            int thisNum = (int)thisLetter;
            letterTotal += thisNum;
        }

        // Scale letterTotal to fit in HASH_TABLE_SIZE by taking the letterTotal mod HASH_TABLE_SIZE
        int hashCode = (letterTotal) % HASH_TABLE_SIZE;

        return hashCode;
    }

    public void analyzeHashValues(int[] hashValues) {
        System.out.println("\nHash Table Usage:");

        // Sort the hash values.
        Arrays.sort(hashValues);

        int asteriskCount = 0;
        int[] bucketCount = new int[HASH_TABLE_SIZE];
        int totalCount = 0;
        int arrayIndex = 0;

        for (int i = 0; i < HASH_TABLE_SIZE; i++) {
            System.out.format("%03d ", i);
            asteriskCount = 0;
            while ((arrayIndex < LINES_IN_FILE) && (hashValues[arrayIndex] == i)) {
                System.out.print("*");
                asteriskCount = asteriskCount + 1;
                arrayIndex = arrayIndex + 1;
            }
            System.out.print(" ");
            System.out.println(asteriskCount);
            bucketCount[i] = asteriskCount;
            totalCount = totalCount + asteriskCount;
        }
    }

    public int populate_retrieveTargets(int[] targets_hashValues, int[] hashValues){
        // 1) Populate the Hash table first
        Arrays.sort(hashValues);
        //convert hashValues to an array of linked lists (hashValues ---> hashValues_asNodes)
        Node[] hashValues_asNodes = new Node[LINES_IN_FILE];
        for (int i = 0; i < LINES_IN_FILE; i++){
            Node node = new Node();
            node.index = i;
            node.next = null;
            node.hashValue = -1;
            hashValues_asNodes[i] = node;
        }
        int arrayIndex = 0;
        for (int i=0; i < HASH_TABLE_SIZE; i++) {
            System.out.format("%03d ", i);
            // This will terminate
            while ( (arrayIndex < LINES_IN_FILE) && (hashValues_asNodes[arrayIndex].index == i) ) {
                Node node = new Node();
                node.next = null;
                node.hashValue = hashValues[arrayIndex];
                hashValues_asNodes[arrayIndex].next = node;
                arrayIndex = arrayIndex + 1;
            }
        }
        // 2) Retrieve target values
        for(int i: targets_hashValues){
            while()
        }

        return 1;
    }


//
//        System.out.print("Average load (count): ");
//        float averageLoad = (float) totalCount / HASH_TABLE_SIZE;
//        System.out.format("%.2f%n", averageLoad);
//        System.out.print("Average load (calc) : ");
//        averageLoad = (float) LINES_IN_FILE / HASH_TABLE_SIZE;
//        System.out.format("%.2f%n", averageLoad);
//
//        System.out.print("Standard Deviation: ");
//        // TODO: Refactor this into its own method.
//        double sum = 0;
//        for (int i=0; i < HASH_TABLE_SIZE; i++) {
//            // For each value in the array...
//            // ... subtract the mean from each one ...
//            double result = bucketCount[i] - averageLoad;
//            // ... and square the result.
//            double square = result * result;
//            // Sum all of those squares.
//            sum = sum + square;
//        }
//        // Divide the sum by the number of values ...
//        double temp = sum / HASH_TABLE_SIZE;
//        // ... and take the square root of that.
//        double stdDev = Math.sqrt(temp);
//        System.out.format("%.2f%n", stdDev);


//    private static populateHashTable()




             /*
        Public
      */

    public void main(String[] args) {
        System.out.println("Hash code tests and analysis.");
        System.out.println("-----------------------------");

        String[] magicItems = new String[LINES_IN_FILE];
        int[] hashValues = new int[LINES_IN_FILE];

        // Read the contents of FILE_NAME into our array of size LINES_IN_FILE.
        int index = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
            String line = "";
            line = br.readLine();
            while (line != null) {
                magicItems[index] = line;
                index = index + 1;
                line = br.readLine();
            }
            br.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // Print the array and hash values.
        int hashCode = 0;
        for (int i = 0; i < LINES_IN_FILE; i++) {
            System.out.print(i);
            System.out.print(". " + magicItems[i] + " - ");
            hashCode = doHashCode(magicItems[i]);
            System.out.format("%03d%n", hashCode);
            hashValues[i] = hashCode;
        }

        // Analyze the distribution of hash values.
        analyzeHashValues(hashValues);
    }

}