import java.io.*;
import java.util.Arrays;
import java.util.Random;

public class Test {

    public static void main(String[] args) {
        String[] lines = {};
        // Read line by line the txt file using File reader
        String fileName = "Assignment 4/graphs1.txt";  //REMEMBER TO NOT HARDCODE
        File file = new File(fileName);
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                // add strings from txt file line by line into array words
                lines = Arrays.copyOf(lines, lines.length + 1); //extends memory
                lines[lines.length - 1] = line; //adds line to extra memory
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] copy_graphs0 = lines.clone();

        Outputs out = new Outputs();
        // outputs matrices
//        out.adjacency_matrix(copy_graphs0);
        // outputs adjacency lists
//        out.adjacency_list(copy_graphs0);
//        out.linked_objects(copy_graphs0);


        // Binary Search Tree population and traversal
        String[] lines1 = {};
        // Read line by line the txt file using File reader
        String fileName1 = "Assignment 4/magicitems.txt";  //REMEMBER TO NOT HARDCODE
        File file1 = new File(fileName1);
        try {
            FileReader fr = new FileReader(file1);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                // add strings from txt file line by line into array words
                lines1 = Arrays.copyOf(lines1, lines1.length + 1); //extends memory
                lines1[lines1.length - 1] = line; //adds line to extra memory
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] lines2 = {};
        // Read line by line the txt file using File reader
        String fileName2 = "Assignment 4/magicitems-find-in-bst.txt";  //REMEMBER TO NOT HARDCODE
        File file2 = new File(fileName2);
        try {
            FileReader fr = new FileReader(file2);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                // add strings from txt file line by line into array words
                lines2 = Arrays.copyOf(lines2, lines2.length + 1); //extends memory
                lines2[lines2.length - 1] = line; //adds line to extra memory
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // copy_words2 -> magicitems-find-in-bst.txt
        // copy_words1 -> magicitems.txt
        String[] copy_words2 = lines2.clone();
        String[] copy_words1 = lines1.clone();

        Binary_Search_Tree bst = new Binary_Search_Tree();
        System.out.println("BINARY SEARCH TREE POPULATING: ");
        Node root = bst.makeBST(copy_words1);
        System.out.println("BINARY SEARCH TREE IN-ORDER TRAVERSAL: ");
        bst.inorder(root);



    }
}