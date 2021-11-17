public class Outputs {

    /**
     * This method is used to print all adjacency matrices given the lines in the file
     * @param lines an array of every line in the file
     * @return prints matrices
     */
    public void adjacency_matrix(String[] lines) {
        int index_start = 0;
        int index_end = 0;
        while (index_end <= lines.length) {
            // don't need rows and columns since adjacency matrix is symmetric ==> rows = columns
            int rows_columns = 0;
            // get indices for for loop for edges
            for (String line : lines) {
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
                    index_start -= 1;
                    break;
                }

            }
            // create instance of matrix given number of vertices declared
            index_end = index_start + 1;
            int[][] matrix = new int[rows_columns][rows_columns];
            // use index_start to continue in the for loop
            for (int i = index_start; i < index_end; i++) {
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
                    // subtract 1 to keep indices same
                    matrix[Integer.parseInt(words[2]) - 1][Integer.parseInt(words[4]) - 1] = 1;
                    // do it twice for the symmetric matrix with indices flipped
                    matrix[Integer.parseInt(words[4]) - 1][Integer.parseInt(words[2]) - 1] = 1;
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
}
