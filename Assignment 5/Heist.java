import java.util.ArrayList;

public class Heist {
    public static void spice_heist(String[] lines) {
        // use these indices throughout for loops
        final int NUMBER_OF_SPICES = 4;
        final int NUMBER_OF_KNAPSACKS = 5;
        int index_start = 0;
        int index_end = 0;
        int spice_index = 0;
        boolean onKnapsack = false;
        Spice[] spices = new Spice[NUMBER_OF_SPICES];
        // use unit_prices to sort the spices array
        float[] unit_prices = new float[NUMBER_OF_SPICES];
        int[] knapsack_capacities = new int[NUMBER_OF_KNAPSACKS];
//        while (index_end <= lines.length) {
//            index_start = index_end;
        for (int i = index_start; i < lines.length; i++) {
            String line = lines[i];
            index_start += 1;
            // case for line is blank;
            if (line.isBlank()) {
                // skip the line
                continue;
            }
            // case for line is a comment
            if (line.charAt(0) == '-' & line.charAt(1) == '-') {
                // skip the line
                continue;
            }
            // make an array of the words from the line separated by ";"
            String[] words = line.split(";");
            // attributes for Spice object
            String[] spice_attributes = new String[3];
            for (int j = 0; j < words.length; j++) {
                words[j] = words[j].replaceAll("\\s", "");
                // separate the words in each element of words by "="
                String[] subwords = words[j].split("=");
                if (subwords[0].equals("knapsackcapacity")) {
                    onKnapsack = true;
                }
                if (!onKnapsack) {
                    // populate the spice attributes
                    spice_attributes[j] = subwords[1];
                }
            }
            if (!onKnapsack) {
                Spice new_spice = new Spice();
                new_spice.color = spice_attributes[0];
                new_spice.total_price = Float.parseFloat(spice_attributes[1]);
                new_spice.quantity = Integer.parseInt(spice_attributes[2]);
                //append the unit_price to array
                unit_prices[spice_index] = new_spice.total_price / new_spice.quantity;
                new_spice.unit_price = unit_prices[spice_index];
                //append the Spice object in an array
                spices[spice_index] = new_spice;
                spice_index += 1;
            }
        }
        RelativeInsertionSort_Decreasing RIS = new RelativeInsertionSort_Decreasing();
        // relatively sort unit_prices and spices
        RIS.relative_insertionSort_decreasing(unit_prices, spices);
        /* Debugging
        for (Spice i: spices){
            System.out.println(i.color);
        }
        */
        }
    }
