import java.lang.reflect.Array;
import java.util.ArrayList;

public class LinkedObjects {
    ArrayList<Integer> num_vertices = new ArrayList<>();
    public void linked_objects(String[] lines) {
        // use these indices throughout for loops
        int index_start;
        int index_end = 0;
        // for printing purposes
        int graph_id = 0;
        // for vertex starting index
        boolean indexIs0 = false;
        // Read the lines up to add edge case
        while (index_end <= lines.length) {
            graph_id += 1;
            index_start = index_end;
            int adj_list_length = 0;
            // get indices for for loop for edges
            for (int i = index_start; i < lines.length; i++) {
                String line = lines[i];
                index_start += 1;
                // case for line is blank;
                if (line.isBlank()) {
                    // skip the line
                    continue;
                }
                // case for line is a comment
                if (line.charAt(1) == '-' & line.charAt(0) == '-') {
                    // skip the line
                    continue;
                }
                // make an array of the words from the line
                String[] words = line.split(" ");
                // case for declaring new graph
                if (words[0].equals("new")) {
                    // print graph_id
                    System.out.println("Graph Number: " + graph_id);
                    //skip the line
                    continue;
                }
                // case for adding vertex
                if (words[0].equals("add") & words[1].equals("vertex")) {
                    adj_list_length += 1;
                    if (words[2].equals("0")) {
                        indexIs0 = true;
                    }
                    continue;
                }
                //check if hit edge case
                if (words[0].equals("add") & words[1].equals("edge")) {
                    // subtract an index since we previously added it but didn't need to since we entered the edge case
                    index_start -= 1;
                    break;
                }

            }

            // create instance of array given number of vertices declared
            index_end = index_start + 1;
            //make array of vertex objects
            Vertex[] array = new Vertex[adj_list_length];
            // check starting index

            // create first vertex objects in array given index
            if (indexIs0) {
                for (int i = 0; i < adj_list_length; i++) {
                    // from Vertex class
                    Vertex vertex = new Vertex();
                    vertex.connecting_vertex = i;
                    vertex.label = i;
                    vertex.next = null;
                    vertex.neighbors = new ArrayList<Vertex>();
                    array[i] = vertex;
                }

            } else {// shift index by 1
                for (int i = 1; i < adj_list_length + 1; i++) {
                    Vertex vertex = new Vertex();
                    vertex.connecting_vertex = i;
                    vertex.label = i;
                    vertex.next = null;
                    vertex.neighbors = new ArrayList<Vertex>();
                    array[i - 1] = vertex;
                }
            }

            // use index_start to continue in the for loop
            for (int i = index_start; i < index_end; i++) {
                // case if reached to end of file/(array of lines)
                if (lines.length < index_end) {
                    break;
                }
                String line = lines[i];
                String[] words = line.split(" ");
                // check if line is blank; if so, move to next graph
                if (line.isBlank()) {
                    break;
                }

                // check if there are two spaces between the weight and the connecting vertex
                // if so, move up an index
                if (words[5].equals("")){
                    words[5] = words[6];
                }

                // case for adding edge
                if (words[0].equals("add") & words[1].equals("edge")) {
                    index_end += 1;
                    // you need to define vertex1 and vertex2 since not doing so creates a pointer infinitely pointing to itself
                    if (indexIs0) {// if index starts at 0 don't subtract 1
                        Vertex vertex1 = new Vertex();
                        vertex1.origin_vertex = Integer.parseInt(words[2]);
                        vertex1.connecting_vertex = Integer.parseInt(words[4]);
                        vertex1.weight = Integer.parseInt(words[5]);
                        vertex1.label = vertex1.connecting_vertex;
                        Vertex head1 = array[vertex1.origin_vertex - 1];
                        while (head1.next != null) {
                            head1 = head1.next;
                        }
                        head1.next = vertex1;

                    } else {// subtract 1 to keep indices same
                        Vertex vertex1 = new Vertex();
                        vertex1.origin_vertex = Integer.parseInt(words[2]);
                        vertex1.connecting_vertex = Integer.parseInt(words[4]);
                        vertex1.weight = Integer.parseInt(words[5]);
                        vertex1.label = vertex1.connecting_vertex;
                        Vertex head1 = array[vertex1.origin_vertex - 1];
                        while (head1.next != null) {
                            head1 = head1.next;
                        }
                        head1.next = vertex1;
                    }
                }
            }


            Vertex[] copy_vertexes = array.clone();
            for(Vertex i: copy_vertexes){
                System.out.print("[" + i.label+ "]" + " ");
                while (i.next != null){
                    i = i.next;
                    System.out.print(i.connecting_vertex + "(" + i.weight + ")" + " ");
                }
                System.out.println();
            }

        }
    }

    // to insert row into 2-D array in
    public int[][] insertRow(int[][] m, int r, int[] data) {
        int[][] out = new int[m.length + 1][];
        for (int i = 0; i < r; i++) {
            out[i] = m[i];
        }
        out[r] = data;
        for (int i = r + 1; i < out.length; i++) {
            out[i] = m[i - 1];
        }
        return out;
    }

    public ArrayList<int[][]> matrices(String[] lines) {
        // use these indices throughout for loops
        int index_start;
        int index_end = 0;
        // for printing purposes
        int graph_id = 0;
        // for vertex starting index
        boolean indexIs0 = false;
        ArrayList<int[][]> matrices = new ArrayList<>();
        while (index_end <= lines.length) {
            graph_id += 1;
            index_start = index_end;
            // don't need rows and columns since adjacency matrix is symmetric ==> rows = columns
            int vertices = 0;
            // get indices for for loop for edges
            for (int i = index_start; i < lines.length; i++) {
                String line = lines[i];
                index_start += 1;
                // case for line is blank;
                if (line.isBlank()) {
                    // skip the line
                    continue;
                }
                // case for line is a comment
                if (line.charAt(1) == '-' & line.charAt(0) == '-') {
                    // skip the line
                    continue;
                }
                // make an array of the words from the line
                String[] words = line.split(" ");
                // case for declaring new graph
                if (words[0].equals("new")) {
                    // print graph_id
                    System.out.println("Graph Number: " + graph_id);
                    //skip the line
                    continue;
                }
                // case for adding vertex
                if (words[0].equals("add") & words[1].equals("vertex")) {
                    vertices += 1;
                    if (words[2].equals("0")) {
                        indexIs0 = true;
                    }
                    continue;
                }
                //check if hit edge case
                if (words[0].equals("add") & words[1].equals("edge")) {
                    index_start -= 1;
                    break;
                }

            }
            // add number of vertices to list
            num_vertices.add(vertices);
            // create instance of matrix
            index_end = index_start + 1;
            int[][] matrix = new int[0][3];
            // use index_start to continue in the for loop
            for (int i = index_start; i < index_end; i++) {
                // case if reached to end of file/(array of lines)
                if (lines.length < index_end) {
                    break;
                }
                String line = lines[i];
                String[] words = line.split(" ");
                // check if line is blank; if so, move to next graph
                if (line.isBlank()) {
                    break;
                }

                // check if there are two spaces between the weight and the connecting vertex
                // if so, move up an index
                if (words[5].equals("")){
                    words[5] = words[6];
                }

                // case for adding edge
                if (words[0].equals("add") & words[1].equals("edge")) {
                    index_end += 1;
                    // use Integer.parseInt to convert string to int
                    if (indexIs0) {// if index starts at 0 don't subtract 1
                        // make array of data for added edge
                        int[] newData = new int[]{Integer.parseInt(words[2]), Integer.parseInt(words[4]), Integer.parseInt(words[5])};
                        // append the array to the matrix
                        matrix = insertRow(matrix, matrix.length, newData);

                    } else {// subtract 1 to keep indices same
                        // make array of data for added edge
                        int[] newData = new int[]{Integer.parseInt(words[2]), Integer.parseInt(words[4]), Integer.parseInt(words[5])};
                        // append the array to the matrix
                        matrix = insertRow(matrix, matrix.length, newData);
                    }
                }
            }

//            for (int i = 0; i < matrix.length; i++) {
//                for (int j = 0; j < matrix[i].length; j++) {
//                    System.out.print(matrix[i][j] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();
            matrices.add(matrix);
        }
        return matrices;
    }
}
