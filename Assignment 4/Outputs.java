public class Outputs {

    public int[][] adjacency_matrix(String[] lines){
        // don't need rows and columns since adjacency matrix is symmetric ==> rows = columns
        int[][] init_matrix = new int[0][0];
        int rows_columns = 0;
        int index = 0;
        for (String line : lines) {
            index += 1;
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
                break;
            }
        }
        // create instance of matrix given number of vertices declared
        int[][] matrix = new int[rows_columns][rows_columns];
        // use index to continue in the for loop
        for (int i = index, linesLength = lines.length; i < linesLength; i++) {
            String line = lines[i];
            String[] words = line.split(" ");
            // case for adding edge
            if (words[0].equals("add") & words[1].equals("edge")){
                // use Integer.parseInt to convert string to int
                matrix[Integer.parseInt(words[2])][Integer.parseInt(words[4])] = 1;
                // do it twice for the symmetric matrix with indices flipped
                matrix[Integer.parseInt(words[4])][Integer.parseInt(words[2])] = 1;
            }
        }
        return matrix;
    }
}
