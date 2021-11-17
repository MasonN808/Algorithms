public class Outputs {

    /**
     * This method is used to print all adjacency matrices given the lines in the file
     * @param lines an array of every line in the file
     * @return prints matrices
     */
    public int[][] adjacency_matrix(String[] lines){
        // don't need rows and columns since adjacency matrix is symmetric ==> rows = columns
        int rows_columns = 0;
        // get indices for for loop for edges
        int index_start = 0;
        for (String line : lines) {
            index_start += 1;
            // case for line is a comment
            if (line.charAt(1) == '-' & line.charAt(0) == '-') {
                // skip the line
                continue;
            }
            // make an array of the words from the line
            String[] words = line.split(" ");
            // case for declaring new graph
            if (words[0].equals("new")) {
                //skip the line
                continue;
            }
            // case for adding vertex
            if (words[0].equals("add") & words[1].equals("vertex")) {
                rows_columns += 1;
                continue;
            }
            //check if hit edge case
            if (words[0].equals("add") & words[1].equals("edge")) {
                index_start -=1;
                break;
            }

        }
        // create instance of matrix given number of vertices declared
        int index_end = index_start + 1;
        int[][] matrix = new int[rows_columns][rows_columns];
        // use index to continue in the for loop
        for (int i = index_start; i < index_end; i++) {
            String line = lines[i];
            String[] words = line.split(" ");
            // case for adding edge
            System.out.println(line);
            if (line.isBlank()){
                break;
            }
            if (words[0].equals("add") & words[1].equals("edge")){
                index_end += 1;
                // use Integer.parseInt to convert string to int
                // subtract 1 to keep indices same
                matrix[Integer.parseInt(words[2])-1][Integer.parseInt(words[4])-1] = 1;
                // do it twice for the symmetric matrix with indices flipped
                matrix[Integer.parseInt(words[4])-1][Integer.parseInt(words[2])-1] = 1;
            }
        }
        return matrix;
    }
}
