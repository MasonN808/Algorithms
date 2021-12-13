public class Testing {
    public static void main(String[] args) {
        Testing_Protocol simulation = new Testing_Protocol();
        simulation.pooled(1000, 8, .02, true);

        // DEBUGGING
        // TODO: Find the bug that isn't making the simulated tests != expected tests
        System.out.println(simulation.total_tests);
        System.out.println(simulation.case1_tests);
        System.out.println(simulation.case2_tests);
        System.out.println(simulation.case3_tests);


        // average the number of tests for n number of simulations/iterations
        int total_total_tests = 0;
        final int ITERATIONS = 1000;
        for (int i = 0; i < ITERATIONS; i++){
            Testing_Protocol simulation1 = new Testing_Protocol();
            simulation1.pooled(1000, 8, .02, false);
            total_total_tests += simulation1.total_tests;
        }
        System.out.println("Averaged Tests over " + ITERATIONS + " iterations: " + total_total_tests/ITERATIONS);


    }
}
