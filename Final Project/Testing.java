public class Testing {
    public static void main(String[] args) {
        final int ITERATIONS = 100;

        System.out.println();
        System.out.println();
        System.out.println("1,000 PEOPLE");
        System.out.println("------------");

        Testing_Protocol simulation = new Testing_Protocol();
        simulation.pooled(1000, 8, .02, true);
        System.out.println("Simulated total Tests: " + simulation.total_tests);

        // average the number of tests for n number of simulations/iterations
        int total_total_tests = 0;
        for (int i = 0; i < ITERATIONS; i++){
            Testing_Protocol simulation1 = new Testing_Protocol();
            simulation1.pooled(1000, 8, .02, false);
            total_total_tests += simulation1.total_tests;
//            System.out.println(simulation1.total_tests);
        }
        System.out.println("Averaged Tests over " + ITERATIONS + " iterations: " + total_total_tests/ITERATIONS);

        System.out.println();
        System.out.println();
        System.out.println("10,00 PEOPLE");
        System.out.println("------------");

        simulation.pooled(10000, 8, .02, true);
        System.out.println("Simulated total Tests: " + simulation.total_tests);

        // average the number of tests for n number of simulations/iterations
        total_total_tests = 0;
        for (int i = 0; i < ITERATIONS; i++){
            Testing_Protocol simulation1 = new Testing_Protocol();
            simulation1.pooled(10000, 8, .02, false);
            total_total_tests += simulation1.total_tests;
//            System.out.println(simulation1.total_tests);
        }
        System.out.println("Averaged Tests over " + ITERATIONS + " iterations: " + total_total_tests/ITERATIONS);

        System.out.println();
        System.out.println();
        System.out.println("100,000 PEOPLE");
        System.out.println("------------");

        simulation.pooled(100000, 8, .02, true);
        System.out.println("Simulated total Tests: " + simulation.total_tests);

        // average the number of tests for n number of simulations/iterations
        total_total_tests = 0;
        for (int i = 0; i < ITERATIONS; i++){
            Testing_Protocol simulation1 = new Testing_Protocol();
            simulation1.pooled(100000, 8, .02, false);
            total_total_tests += simulation1.total_tests;
//            System.out.println(simulation1.total_tests);
        }
        System.out.println("Averaged Tests over " + ITERATIONS + " iterations: " + total_total_tests/ITERATIONS);

        System.out.println();
        System.out.println();
        System.out.println("1M PEOPLE");
        System.out.println("------------");



        simulation.pooled(1000000, 8, .02, true);
        System.out.println("Simulated total Tests: " + simulation.total_tests);

        // average the number of tests for n number of simulations/iterations
        total_total_tests = 0;
        for (int i = 0; i < ITERATIONS; i++){
            Testing_Protocol simulation1 = new Testing_Protocol();
            simulation1.pooled(1000000, 8, .02, false);
            total_total_tests += simulation1.total_tests;
//            System.out.println(simulation1.total_tests);
        }
        System.out.println("Averaged Tests over " + ITERATIONS + " iterations: " + total_total_tests/ITERATIONS);


    }
}
