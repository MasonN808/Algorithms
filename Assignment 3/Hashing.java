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

    public void populate_retrieveTargets(int[] targets_hashValues, String[] targets, int[] hashValues, String[] hashOriginalStrings){
        // 1) Populate the Hash table first
        // sort hashValues, then sort hashOriginalStrings the SAME way (RELATIVE SORTING)
        RelativeInsertionSort relativeInsertionSort = new RelativeInsertionSort();
        relativeInsertionSort.relative_insertionSort(hashValues, hashOriginalStrings);
//        Arrays.sort(hashValues);
        //convert hashValues to an array of linked lists (hashValues ---> hashValues_asNodes)
        Node[] hashValues_asNodes = new Node[LINES_IN_FILE];
        for (int i = 0; i < LINES_IN_FILE; i++){
//            List list = new List();
            Node node = new Node();
            node.index = i;
            node.next = null;
            node.hashValue = hashValues[i];
            node.name = null;
//            list.head = node;
//            list.head = node;
            // linear: 0,1,2,3,4,...,665
            hashValues_asNodes[i] = node;
        }
        int arrayIndex = 0;
        for (int i=0; i < HASH_TABLE_SIZE; i++) {
//            System.out.format("%03d ", i);
            // This will terminate
            // go through each index and append a pointer to a node if such a hashValue exists
            int asteriskCount = 0;
            while ( (arrayIndex < LINES_IN_FILE) && (hashValues_asNodes[arrayIndex].hashValue == i) ) {
//                System.out.print("*");
//                asteriskCount = asteriskCount + 1;
                Node node = new Node();
                node.next = null;
                node.hashValue = hashValues[arrayIndex];
                //node.name --> String
                node.name = hashOriginalStrings[arrayIndex];
                hashValues_asNodes[i].next = node;
                arrayIndex += 1;
            }
//            System.out.print(" ");
//            System.out.println(asteriskCount);
        }
//        System.out.println("passed point A");
        // 2) Retrieve target values
        for(int i = 0; i < targets.length; i++){
//            String output = "Target not in hashtable";
            // search the linked list at index=target_hashValue
//            if (hashValues_asNodes[targets_hashValues[i]].index == targets_hashValues[i])
//                System.out.println("testing");
//            System.out.println(hashValues_asNodes[targets_hashValues[i]].index);
            Node head = hashValues_asNodes[targets_hashValues[i]].next;
            int output = 0;
            while(head != null){
                // compare here
//                System.out.println(targets[i]);
                comparisons += 1;
                // compare target string to all node.names in the linked list
                //NO clue why this does not work, but next if statement does
                if(targets[i].equals(head.name)){
//                    output += 1;
                    System.out.println(targets[i]);
                    break;
                }
//                if(targets_hashValues[i] == (head.hashValue)){
////                    output = "Target Found2";
//                    System.out.println(targets[i]);
//                    break;
//                }
//                System.out.println(head.name);
                head = head.next;
            }
//            System.out.println(output);
        }
    }

}