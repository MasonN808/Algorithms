import java.text.DecimalFormat;

public class Testing_Protocol {

    // number of tests needed
    int total_tests = 0;
    int case1_tests = 0;
    int case2_tests = 0;
    int case3_tests = 0;
    int case1 = 0;
    int case2 = 0;
    int case3 = 0;



    /**
     * Gets the first and last name of this Student.
     * @param people The number of people to be tested
     * @param group_size The group size for initial pooled test
     * @param infection_rate The rate at which the population is being infected
     * @param show_expected Prints the expected number of occurrences of each case and number of tests
     */
    public void pooled(int people, int group_size, double infection_rate, boolean show_expected){
        // Define number of groups
        double num_groups = (double)people/group_size;
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
//        for (boolean i: infected){
//            if(i){
//                System.out.print(1);
//            }else System.out.print(0);
//        }
        // Check the pools for infected of size "group_size"
        // if pool has infected, split pool in two and test if each pool has infected
        // then do individual test for each two pools that has infected
        // start index for pooled group
        int start_index = 0;
        // end index for pooled group
        // delete 1 to group_size to convert from type size to type index
        int end_index = group_size-1;
        // number of loops of pooled testing in the population of people
        int loops = 1;
        //TODO implement recursion
        //TODO take into account that the last pooled group is not of length group_size
        while(start_index < people){
            loops += 1;
            // test the whole pool
            total_tests += 1;
            case1_tests += 1;
            // linear search through pool
            for(int i = start_index; i < end_index; i++){
                // if someone is infected, then split pool in two
                if(infected[i]){
                    //TODO make sure half_end_index takes into account odd test size (not needed for this project)
                    //add 1 to end_index to convert from type index to type size, then delete 1 to convert to type index
                    int half_end_index = end_index-group_size/2;
//                    System.out.println(start_index + ":" + half_end_index + ":" + end_index);
                    // test first half of test pool
                    total_tests += 1;
                    case2_tests += 1;
                    for(int j = start_index; j < half_end_index; j++){
                        // test if someone is infected in half pool size
                        if(infected[j]){
                            // test everyone in the half pool size
                            for(int k = start_index; k < half_end_index; k++){
                                total_tests += 1;
                                case3_tests += 1;
                            }
                        }
                    }
                    // test second half of test pool
                    total_tests += 1;
                    case2_tests += 1;
                    // TODO HERE
//                    System.out.println(start_index + ":" + half_end_index + ":" + end_index);
                    for(int j = half_end_index + 1; j < end_index; j++){
                        // test if someone is infected in half pool size
                        if(infected[j]){
                            // test everyone in the half pool size
                            for(int k = half_end_index + 1; k < end_index; k++){
                                total_tests += 1;
                                case3_tests += 1;
                            }
                        }
                    }
                    // break out of outer for loop to stop linear search, since the pool of size group_size has already been tested on
                    break;
                }

            }
            // move to next pool
            start_index = end_index;
            end_index = group_size*loops;
        }

        if (show_expected) {
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
