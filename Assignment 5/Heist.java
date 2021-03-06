import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Heist implements Cloneable{
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
        ArrayList<Integer> knapsack_capacities = new ArrayList<>();
//        while (index_end <= lines.length) {
//            index_start = index_end;
        int last_index = 0;
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
                    last_index = index_start;
                    break;
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
            }else{
                break;
            }
        }

        for (int i = last_index-1; i < lines.length; i++){
            String line = lines[i];
            String[] words = line.split(";");
            // attributes for Spice object
//            String[] spice_attributes = new String[3];
            for (int j = 0; j < words.length; j++) {
                words[j] = words[j].replaceAll("\\s", "");
                // separate the words in each element of words by "="
                String[] subwords = words[j].split("=");
                if (subwords[0].equals("knapsackcapacity")) {
                    knapsack_capacities.add(Integer.parseInt(subwords[1]));
                }
                else{
                    System.out.println("ERROR in Heist line 82");
                }
            }
        }
        RelativeInsertionSort_Decreasing RIS = new RelativeInsertionSort_Decreasing();
        // relatively sort unit_prices and spices
        RIS.relative_insertionSort_decreasing(unit_prices, spices);
        // start filling each knapsack and print results
        int out_index = 0;
        for (int i=0; i < knapsack_capacities.size(); i++){
            onKnapsack = false;
            index_start = 0;
            spice_index = 0;
            Spice[] spices2 = new Spice[NUMBER_OF_SPICES];
            // use unit_prices to sort the spices array
            unit_prices = new float[NUMBER_OF_SPICES];
            for (int k = index_start; k < lines.length; k++) {
                String line = lines[k];
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
                        last_index = index_start;
                        break;
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
                    spices2[spice_index] = new_spice;
                    spice_index += 1;
                }else{
                    break;
                }
            }


            Spice[] copy_spices = spices2.clone();

            RelativeInsertionSort_Decreasing RIS2 = new RelativeInsertionSort_Decreasing();
            // relatively sort unit_prices and spices
            RIS2.relative_insertionSort_decreasing(unit_prices, copy_spices);


            int sack_size = knapsack_capacities.get(i);
            // how much the knapsack is worth
            float worth = 0;
            // how many differing color spices were used
            int red = 0, green = 0, blue = 0, orange = 0;
            int index = 0;
            int j = 0;
            while (sack_size != 0 && copy_spices[copy_spices.length-1].quantity != 0){
                while (copy_spices[j].quantity != 0){
//                for (int j = 0; j < copy_spices.length; j++){
                    index += 1;
//                    if(copy_spices[j].quantity != 0){
                        sack_size -= 1;
                        worth += copy_spices[j].unit_price;
                        copy_spices[j].quantity -= 1;
//                        System.out.println(copy_spices[1].quantity);
                        switch (copy_spices[j].color) {
                            case "red" -> red += 1;
                            case "green" -> green += 1;
                            case "blue" -> blue += 1;
                            case "orange" -> orange += 1;
                        }
                        if (sack_size == 0){
                            break;
                        }
//                    }
//                    if(index == 3){
//                        break;
//                    }
                }
                j+=1;

            }
            int index1 = 0;
            int[] amounts = new int[]{red, green, blue, orange};
            String[] colors = new String[]{"red", "green", "blue", "orange"};
            String amount = "";
            for (int p=0; p< amounts.length; p++){
                int times = 0;
                while (amounts[p] != 0){
                    amounts[p] -= 1;
                    times += 1;
                }
                amount += " " + times + " scoops of " + colors[index1] + ",";
                index1 += 1;
            }

            System.out.println("Knapsack of capacity " + knapsack_capacities.get(i) + " is worth " + worth + " and " +
                    "contains " + amount);
            out_index += 1;
        }
    }


}
