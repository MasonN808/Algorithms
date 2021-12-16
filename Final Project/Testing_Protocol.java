import java.text.DecimalFormat;

public class Testing_Protocol {

    // number of tests needed
    int total_tests = 0;

    /**
     * Gets the first and last name of this Student.
     * @param people The number of people to be tested
     * @param group_size The group size for initial pooled test
     * @param infection_rate The rate at which the population is being infected
     * @param print_expected Prints the expected number of occurrences of each case and number of tests
     */
    public void pooled(int people, int group_size, double infection_rate, boolean print_expected){
        // Define number of groups
        double num_groups = (double)people/group_size;
        boolean isdivisible = people % group_size == 0;
        // Initialize an array of length "people"
        // All values in "infected" are set to false by default
        boolean[] infected = new boolean[people];
        // infect infection_rate*people number of people
        // take floor if infection_rate*people is rational
        // convert double to int
        int infected_end = (int)Math.floor(infection_rate*people);
        for(int i = 0; i < infected_end; i++){
            infected[i] = true;
        }

        // Knuth shuffle array, infected
        Shuffle shuffle = new Shuffle();
        shuffle.shuffle(infected);

        // Check the pools for infected of size "group_size"
        // if pool has infected, split pool in two and test if each pool has infected
        // then do individual test for each two pools that has infected
        // start index for pooled group
        int start_index = 0;
        // end index for pooled group
        // delete 1 to group_size to convert from type size to type index
        int end_index = group_size;
        // number of loops of pooled testing in the population of people
        int loops = 1;

        //TESTING
//        infected[0] = true;
//        infected[5] = true;
//        infected[6] = true;
//        infected[7] = true;
//        infected[8] = true;
//        infected[12] = true;

        while(start_index < people){
            loops += 1;
            // test the whole pool
            total_tests += 1;
            // linear search through pool
            for (int i = start_index; i < end_index; i++) {
                // if someone is infected, then split pool in two
                if (infected[i]) {
                    // Subtract half of group_size from end_index to get get an about halved value between start and end index
                    // Use the ceiling method to take into account case when group_size is odd
                    // Need the (int) and (double) to make it compatible with ceiling method
                    // TODO: TEST that the method below works as intended
                    int half_end_index = (int) Math.ceil(end_index - (double)group_size/2);
                    // Test first half of test pool
                    total_tests += 1;
                    for (int j = start_index; j < half_end_index; j++) {
                        // Test if someone is infected in half pool size
                        if (infected[j]) {
//                            //TESTING
//                            System.out.print("["+ start_index + "," + half_end_index+ "] " );
//                            //TESTING
//                            System.out.print("FIRST HALF: ");
                            // Test everyone in the half pool size
                            for (int k = start_index; k < half_end_index; k++) {
                                total_tests += 1;
//                                //TESTING
//                                System.out.print(k + " ");
                            }
//                            //TESTING
//                            System.out.println();
                            // break out of outer for loop to stop linear search, since the pool of size group_size/2 has already been tested on
                            break;
                        }
                    }
                    // test second half of test pool
                    total_tests += 1;
                    for (int j = half_end_index; j < end_index; j++) {
                        // test if someone is infected in half pool size
                        if (infected[j]) {
                            // TODO this for-loop only loops three times not four
//                            //TESTING
//                            System.out.print("["+ half_end_index + "," + end_index + "] " );
//                            //TESTING
//                            System.out.print("SECOND HALF: ");
                            // test everyone in the half pool size
                            for (int k = half_end_index; k < end_index; k++) {
                                total_tests += 1;
//                                //TESTING
//                                System.out.print(k + " ");
                            }
//                            //TESTING
//                            System.out.println();
                            // break out of outer for loop to stop linear search, since the pool of size group_size/2 has already been tested on
                            break;
                        }
                    }
                    // break out of outer for loop to stop linear search, since the pool of size group_size has already been tested on
                    break;
                }
            }
            // move to next testing pool
            start_index = end_index;
            // Case when people % group_size != 0
            if (group_size * loops > people){
                end_index = people;
            }
            else{
                end_index = group_size*loops;
            }
        }

        if (print_expected) {
            // Find the expected percentage of occurrences
            double case1 = Math.pow(1 - infection_rate, group_size);
            double case3 = Math.pow(infection_rate, 2);
            double case2 = 1 - case1 - case3;

            // Find the expected number of tests needed in pooled testing
            int test1 = (int) Math.ceil(num_groups * case1);
            // Initialize test2 and test3
            // Since taking the ceiling of a number less than one will be one
            int test2, test3;
            if (num_groups * case2 < 1){
                test2 = (int) Math.ceil(num_groups * case2) * 7;
            }
            else{
                test2 = (int) Math.ceil(num_groups * case2 * 7);
            }
            // since taking the ceiling of a number less than one will be one
            if (num_groups * case3 < 1){
                test3 = (int) Math.ceil(num_groups * case3) * 11;
            }
            else{
                test3 = (int) Math.ceil(num_groups * case3 * 11);
            }

            // For printing a certain number of decimals
            DecimalFormat numberFormat = new DecimalFormat("#.00000");
            System.out.println("Case 1");
            System.out.println("Expected Percentage of Total Occurrences: " + numberFormat.format(case1));
            // take ceiling to err on the side of caution and convert from double to integer
            System.out.println("Expected Number of Tests: " + test1);

            System.out.println("------------");
            System.out.println("Case 2");
            System.out.println("Expected Number of Occurrences: " + numberFormat.format(case2));
            System.out.println("Expected Number of Tests: " + test2);

            System.out.println("------------");
            System.out.println("Case 3");
            System.out.println("Expected Number of Occurrences: " + numberFormat.format(case3));
            System.out.println("Expected Number of Tests: " + test3);

            System.out.println("------------");
            System.out.println("Total Expected Number of Tests: " + (test1 + test2 + test3));
            System.out.println("------------");

        }
    }
}
