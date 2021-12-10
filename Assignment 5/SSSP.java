import java.util.ArrayList;

public class SSSP {
    static void BellmanFord(int[][] graph, int V, int E, int src) {
        // Initialize distance of all vertices as very big value.
        int[] dis = new int[V];
        for (int i = 0; i < V; i++)
            dis[i] = Integer.MAX_VALUE;

        // initialize distance of source as 0
        dis[src-1] = 0;

        // RELAX
        for (int i = 0; i < V - 1; i++) {
            for (int j = 0; j < E; j++) {
                // subtract 1 if !indexis0
                if (dis[graph[j][0]-1] != Integer.MAX_VALUE && dis[graph[j][0]-1] + graph[j][2] < dis[graph[j][1]-1]) {
                    dis[graph[j][1]-1] = dis[graph[j][0]-1] + graph[j][2];
                }
            }
        }
        // check if there is an infinite cycle
        for (int i = 0; i < E; i++) {
            int x = graph[i][0];
            int y = graph[i][1];
            int weight = graph[i][2];
            if (dis[x-1] != Integer.MAX_VALUE && dis[x-1] + weight < dis[y-1]) {
                System.out.println("Graph contains negative weight cycle");
            }
        }

        System.out.println("Vertex \t\t Distance from Source");
        for (int i = 0; i < V; i++)
            System.out.println(i+1 + "\t\t\t " + dis[i]);
    }
}
