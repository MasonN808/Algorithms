public class Outputs {

    /**
     * This method is used to print all adjacency matrices given the lines in the file
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
                    if (words[2].equals("0")){
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
                if (lines.length <= index_end) {
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

                    if (indexIs0){// if index starts at 0 don't subtract 1
                        matrix[Integer.parseInt(words[2])][Integer.parseInt(words[4])] = 1;
                        // do it twice since undirected
                        matrix[Integer.parseInt(words[4])][Integer.parseInt(words[2])] = 1;
                    }else{// subtract 1 to keep indices same
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

    public void adjacency_list(String[] lines){
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
                if (lines.length <= index_end) {
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
                    // use Vertex class
                    Vertex vertex = new Vertex();
                    // use Integer.parseInt to convert string to int
                    vertex.origin_vertex = Integer.parseInt(words[2]);
                    vertex.connecting_vertex = Integer.parseInt(words[4]);
                    vertex.next = null;
                    if (indexIs0) {// if index starts at 0 don't subtract 1
                        Vertex temp = array[vertex.origin_vertex];
                        temp.next = vertex;
                        temp = temp.next;



                        // do it twice since undirected
                        array[vertex.connecting_vertex].next = vertex;
                        array[vertex.connecting_vertex] = array[vertex.connecting_vertex].next;
                    } else {// subtract 1 to keep indices same
                        array[vertex.origin_vertex - 1].next = vertex;
                        array[vertex.origin_vertex - 1] = array[vertex.origin_vertex - 1].next;
                        // do it twice since undirected
                        array[vertex.connecting_vertex - 1].next = vertex;
                        array[vertex.connecting_vertex - 1] = array[vertex.connecting_vertex - 1].next;
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
                        temp_vertex = temp_vertex.next;
                    }
                    System.out.println();
                }
                System.out.println();
            }
        }
    }
}
