public class SSSP {
    // see https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-greedy-algo-7/
    int minDistance(int[] dist, Boolean[] sptSet, int order){
        // Initialize min value as infinity
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < order; v++) {
            if (!sptSet[v] && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }
        }
        return min_index;
    }

    // A utility function to print the constructed distance array
    void printSolution(int[] dist, int order){
        System.out.println("Vertex \t\t Distance from Source");
        for (int i = 0; i < order; i++)
            System.out.println(i + " \t\t " + dist[i]);
    }

    // Function that implements Dijkstra's single source shortest path
    // algorithm for a graph represented using adjacency matrix
    // representation
    void sssp(int[][] graph, int src, int order){
        int[] dist = new int[order]; // The output array. dist[i] will hold
        // the shortest distance from src to i

        // processed[i] will true if vertex i is included in shortest
        // path tree or shortest distance from src to i is finalized
        Boolean[] processed = new Boolean[order];

        // Initialize all distances as INFINITE and stpSet[] as false
        for (int i = 0; i < order; i++){
            dist[i] = Integer.MAX_VALUE;
            processed[i] = false;
        }

        // Distance of source vertex from itself is always 0
        dist[src] = 0;

        // Find shortest path for all vertices
        for (int count = 0; count < order - 1; count++){
            // Pick the minimum distance vertex from the set of vertices
            // not yet processed. u is always equal to src in first
            // iteration.
            int u = minDistance(dist, processed, order);

            // Mark the picked vertex as processed
            processed[u] = true;

            // Update dist value of the adjacent vertices of the
            // picked vertex.
            for (int v = 0; v < order; v++){
                // Update dist[v] only if is not in processed, there is an
                // edge from u to v, and total weight of path from src to
                // v through u is smaller than current value of dist[v]
                if (!processed[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];
            }
        }
        // print the constructed distance array
        printSolution(dist, order);
    }
}
