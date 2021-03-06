import java.util.ArrayList;
public class Outputs {
    /**
     * This method is used to print all adjacency matrices given the lines in the file
     *
     * @param lines an array of every line in the file
     */
    public void adjacency_matrix(String[] lines) {
        // use these indices throughout for loops
        int index_start;
        int index_end = 0;
        // for printing purposes
        int graph_id = 0;
        // for vertex starting index
        boolean indexIs0 = false;
        while (index_end <= lines.length) {
            graph_id += 1;
            index_start = index_end;
            // don't need rows and columns since adjacency matrix is symmetric ==> rows = columns
            int rows_columns = 0;
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
                    rows_columns += 1;
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

            // create instance of matrix given number of vertices declared
            index_end = index_start + 1;
            int[][] matrix = new int[rows_columns][rows_columns];
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
                // case for adding edge
                if (words[0].equals("add") & words[1].equals("edge")) {
                    index_end += 1;
                    // use Integer.parseInt to convert string to int

                    if (indexIs0) {// if index starts at 0 don't subtract 1
                        matrix[Integer.parseInt(words[2])][Integer.parseInt(words[4])] = 1;
                        // do it twice since undirected
                        matrix[Integer.parseInt(words[4])][Integer.parseInt(words[2])] = 1;
                    } else {// subtract 1 to keep indices same
                        matrix[Integer.parseInt(words[2]) - 1][Integer.parseInt(words[4]) - 1] = 1;
                        // do it twice since undirected
                        matrix[Integer.parseInt(words[4]) - 1][Integer.parseInt(words[2]) - 1] = 1;
                    }
                }
            }

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public void adjacency_list(String[] lines) {
        // use these indices throughout for loops
        int index_start;
        int index_end = 0;
        // for printing purposes
        int graph_id = 0;
        // for vertex starting index
        boolean indexIs0 = false;
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

            // create first vertex objects in array
            if (indexIs0) {
                for (int i = 0; i < adj_list_length; i++) {
                    // from Vertex class
                    Vertex vertex = new Vertex();
                    vertex.label = i;
                    vertex.next = null;
                    array[i] = vertex;
                }
            } else {// shift index by 1
                for (int i = 1; i < adj_list_length + 1; i++) {
                    Vertex vertex = new Vertex();
                    vertex.label = i;
                    vertex.next = null;
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

                // case for adding edge
                if (words[0].equals("add") & words[1].equals("edge")) {
                    index_end += 1;
                    // you need to define vertex1 and vertex2 since not doing so creates a pointer infinitely pointing to itself
                    if (indexIs0) {// if index starts at 0 don't subtract 1
                        Vertex vertex1 = new Vertex();
                        // use Integer.parseInt to convert string to int
                        vertex1.origin_vertex = Integer.parseInt(words[2]);
                        vertex1.connecting_vertex = Integer.parseInt(words[4]);
                        vertex1.next = null;
                        Vertex head = array[vertex1.origin_vertex];
                        while (head.next != null) {
                            head = head.next;
                        }
                        head.next = vertex1;

                        Vertex vertex2 = new Vertex();
                        vertex2.origin_vertex = Integer.parseInt(words[2]);
                        vertex2.connecting_vertex = Integer.parseInt(words[4]);
                        vertex2.next = null;
                        // do it twice since undirected
                        Vertex head1 = array[vertex2.connecting_vertex];
                        while (head1.next != null) {
                            head1 = head1.next;
                        }
                        head1.next = vertex2;
                    } else {// subtract 1 to keep indices same
                        Vertex vertex1 = new Vertex();
                        vertex1.origin_vertex = Integer.parseInt(words[2]);
                        vertex1.connecting_vertex = Integer.parseInt(words[4]);
                        vertex1.next = null;
                        Vertex head = array[vertex1.origin_vertex - 1];
                        while (head.next != null) {
                            head = head.next;
                        }
                        head.next = vertex1;

                        // do it twice since undirected
                        Vertex vertex2 = new Vertex();
                        vertex2.origin_vertex = Integer.parseInt(words[2]);
                        vertex2.connecting_vertex = Integer.parseInt(words[4]);
                        vertex2.next = null;
                        Vertex head1 = array[vertex2.connecting_vertex - 1];
                        while (head1.next != null) {
                            head1 = head1.next;
                        }
                        head1.next = vertex2;
                    }

                }

            }

            for (Vertex vertex : array) {
                System.out.print("[" + vertex.label + "]" + " ");
                if (vertex.next != null) {
                    Vertex temp_vertex = vertex.next;
                    //check if we print connecting_vertex or origin_vertex
                    while (temp_vertex != null) {
                        if (temp_vertex.connecting_vertex != vertex.label) {
                            System.out.print(temp_vertex.connecting_vertex + " ");
                        }
                        if (temp_vertex.origin_vertex != vertex.label) {
                            System.out.print(temp_vertex.origin_vertex + " ");
                        }
                        temp_vertex = temp_vertex.next;
                    }
                }
                System.out.println();
            }
        }
    }

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
                    vertex.neighbors = new ArrayList<Vertex>();
                    array[i] = vertex;
                }

            } else {// shift index by 1
                for (int i = 1; i < adj_list_length + 1; i++) {
                    Vertex vertex = new Vertex();
                    vertex.connecting_vertex = i;
                    vertex.label = i;
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

                // case for adding edge
                if (words[0].equals("add") & words[1].equals("edge")) {
                    index_end += 1;
                    // you need to define vertex1 and vertex2 since not doing so creates a pointer infinitely pointing to itself
                    if (indexIs0) {// if index starts at 0 don't subtract 1
                        Vertex vertex1 = new Vertex();
                        vertex1.origin_vertex = Integer.parseInt(words[2]);
                        vertex1.connecting_vertex = Integer.parseInt(words[4]);
                        vertex1.label = vertex1.connecting_vertex;
                        vertex1.neighbors = array[vertex1.connecting_vertex].neighbors;
                        Vertex head = array[vertex1.origin_vertex];
                        // add vertex to neighbors attribute
                        head.neighbors.add(vertex1);

                        // do it twice since undirected
                        Vertex vertex2 = new Vertex();
                        vertex2.origin_vertex = Integer.parseInt(words[2]);
                        vertex2.connecting_vertex = Integer.parseInt(words[4]);
                        vertex2.label = vertex1.origin_vertex;
                        vertex2.neighbors = array[vertex2.origin_vertex].neighbors;
                        Vertex head1 = array[vertex2.connecting_vertex];
                        head1.neighbors.add(vertex2);

                    } else {// subtract 1 to keep indices same
                        Vertex vertex1 = new Vertex();
                        vertex1.origin_vertex = Integer.parseInt(words[2]);
                        vertex1.connecting_vertex = Integer.parseInt(words[4]);
                        vertex1.label = vertex1.connecting_vertex;
                        vertex1.neighbors = array[vertex1.connecting_vertex - 1].neighbors;
                        Vertex head = array[vertex1.origin_vertex - 1];
                        // add vertex to neighbors attribute
                        head.neighbors.add(vertex1);

                        // do it twice since undirected
                        Vertex vertex2 = new Vertex();
                        vertex2.origin_vertex = Integer.parseInt(words[2]);
                        vertex2.connecting_vertex = Integer.parseInt(words[4]);
                        vertex2.label = vertex1.origin_vertex;
                        vertex2.neighbors = array[vertex2.origin_vertex - 1].neighbors;
                        Vertex head1 = array[vertex2.connecting_vertex - 1];
                        head1.neighbors.add(vertex2);
                    }

                }

            }
            Vertex[] copy_vertexes = array.clone();
            Vertex[] copy_vertexes1 = array.clone();
            Search search = new Search();
            Search search1 = new Search();
            System.out.print("Depth First: ");
            search1.depth_first(copy_vertexes1[0], array);
            System.out.println();
            System.out.print("Breadth First: ");
            search.breadth_first(copy_vertexes[0], array);
            System.out.println();



        }
    }
}
