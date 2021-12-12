public class Testing_Protocol {

    // number of tests needed
    int total_tests = 0;

    /**
     * Gets the first and last name of this Student.
     * @param people The number of people to be tested
     * @param group_size The group size for initial pooled test
     * @param infection_rate The rate at which the population is being infected
     */
    public void pooled(int people, int group_size, double infection_rate){
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
        int end_index = group_size-1;
        // number of loops of pooled testing in the population of people
        int loops = 1;
        //TODO implement recursion
        //TODO take into account that the last pooled group is not of length group_size
        while(start_index < people){
            loops += 1;
            // test the whole pool
            total_tests += 1;
            // linear search through pool
            for(int i = start_index; i < end_index; i++){
                // if someone is infected, then split pool in two
                if(infected[i]){
                    //TODO make sure half_end_index takes into account odd test size (not needed for this project)
                    //add 1 to end_index to convert from type index to type size, then delete 1 to convert to type index
                    int half_end_index = (end_index + 1)/2 - 1;
                    // test first half of test pool
                    total_tests += 1;
                    for(int j = start_index; j < half_end_index; j++){
                        // if someone is infected, then test everyone in the half pool size
                        if(infected[j]){
                            for(int k = start_index; k < half_end_index; k++){
                                // if someone is infected, then test everyone in the half pool size
                                if(infected[k]){
                                    total_tests += 1;
                                }
                            }
                        }
                    }
                    // test second half of test pool
                    total_tests += 1;
                    for(int j = half_end_index + 1; j < end_index; j++){
                        // if someone is infected, then test everyone in the half pool size
                        if(infected[j]){
                            for(int k = half_end_index + 1; k < half_end_index; k++){
                                // if someone is infected, then test everyone in the half pool size
                                if(infected[k]){
                                    total_tests += 1;
                                }
                            }
                        }
                    }
                }

            }
            start_index = end_index;
            end_index = end_index*loops;
        }



//        for (boolean j: infected){
//            System.out.println(j);
//        }
    }
}
