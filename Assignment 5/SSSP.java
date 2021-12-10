import java.util.ArrayList;

public class SSSP {
    //    // see https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-greedy-algo-7/
//    int minDistance(int[] dist, Boolean[] sptSet, int order){
//        // Initialize min value as infinity
//        int min = Integer.MAX_VALUE, min_index = -1;
//
//        for (int v = 0; v < order; v++) {
//            if (!sptSet[v] && dist[v] <= min) {
//                min = dist[v];
//                min_index = v;
//            }
//        }
//        return min_index;
//    }
//
//    // A utility function to print the constructed distance array
//    void printSolution(int[] dist, int order, ArrayList<Integer> path){
//        System.out.println("Vertex \t\t Minimum Distance from Source");
//        for (int i = 0; i < order; i++)
//            System.out.println(i+1 + " \t\t\t " + dist[i]);
//        int j=0;
//        while (j < path.size()){
//            System.out.println(path.get(j));
//            j+=1;
//        }
//    }
//
//    // Function that implements Dijkstra's single source shortest path
//    // algorithm for a graph represented using adjacency matrix
//    // representation
//    void sssp(int[][] graph, int src, int order){
//        int[] dist = new int[order];
//        ArrayList<Integer> path = new ArrayList<>();
//
//        Boolean[] processed = new Boolean[order];
//        // Initialize all distances as INFINITE and processed[] as false
//        for (int i = 0; i < order; i++){
//            dist[i] = Integer.MAX_VALUE;
//            processed[i] = false;
//        }
//
//        // Distance of source vertex from itself is always 0
//        dist[src-1] = 0;
//
//        // Find shortest path for all vertices
//        for (int count = 0; count < order - 1; count++){
//            // u is always equal to src in first iteration.
//            // u is the minimum distant vertex from the set of vertices
//            int u = minDistance(dist, processed, order);
//            path.add(u);
//
//            // Mark the picked vertex as processed
//            processed[u] = true;
//
//            // Update dist value of the adjacent vertices of the
//            // picked vertex.
//            for (int v = 0; v < order; v++){
//                // Update dist[v] only if is not in processed, there is an
//                // edge from u to v, and total weight of path from src to
//                // v through u is smaller than current value of dist[v]
//                if (!processed[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v])
//                    dist[v] = dist[u] + graph[u][v];
//            }
//        }
//        // print the constructed distance array
//        printSolution(dist, order, path);
//    }
//}
    static void BellmanFord(int graph[][], int V, int E, int src) {
        // Initialize distance of all vertices as infinite.
        int[] dis = new int[V];
        for (int i = 0; i < V; i++)
            dis[i] = Integer.MAX_VALUE;

        // initialize distance of source as 0
        dis[src] = 0;

        // Relax all edges |V| - 1 times. A simple
        // shortest path from src to any other
        // vertex can have at-most |V| - 1 edges
        for (int i = 0; i < V - 1; i++) {

            for (int j = 0; j < E; j++) {
                if (dis[graph[j][0]] != Integer.MAX_VALUE && dis[graph[j][0]] + graph[j][2] <
                        dis[graph[j][1]])
                    dis[graph[j][1]] =
                            dis[graph[j][0]] + graph[j][2];
            }
        }

        // check for negative-weight cycles.
        // The above step guarantees shortest
        // distances if graph doesn't contain
        // negative weight cycle. If we get a
        // shorter path, then there is a cycle.
        for (int i = 0; i < E; i++) {
            int x = graph[i][0];
            int y = graph[i][1];
            int weight = graph[i][2];
            if (dis[x] != Integer.MAX_VALUE &&
                    dis[x] + weight < dis[y])
                System.out.println("Graph contains negative"
                        + " weight cycle");
        }

        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < V; i++)
            System.out.println(i + "\t\t" + dis[i]);
    }
}
