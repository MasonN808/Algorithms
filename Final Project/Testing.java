public class Testing {
    public static void main(String[] args) {
        Testing_Protocol simulation = new Testing_Protocol();
        simulation.pooled(1000, 8, .2);
        System.out.println(simulation.total_tests);

    }
}
