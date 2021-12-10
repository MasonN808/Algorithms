import java.io.*;
import java.util.Arrays;

public class Test {



    public static void main(String[] args) {
        String[] lines = {};
        // Read line by line the txt file using File reader
        String fileName = "Assignment 5/graphs2";  //REMEMBER TO NOT HARDCODE
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

        LinkedObjects out = new LinkedObjects();
        // outputs matrices
        System.out.println("GRAPH AS LINKED OBJECTS TESTING: ");
        out.linked_objects(copy_graphs0);
//        System.out.println("Testing: matrix");
//        out.adjacency_matrix(copy_graphs0);
        SSSP short_path_algo = new SSSP();
        for (int[][] i: out.adjacency_matrix(copy_graphs0))
            short_path_algo.BellmanFord(i, i[0].length, , 1);


    }
}