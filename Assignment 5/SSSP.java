import java.util.ArrayList;

public class SSSP {
    static void bellman_ford(int[][] graph, int V, int E, int src) {
        // Initialize distance of all vertices as very big value.
        // get list of paths for output
        String[] paths = new String[V];
        int[] dis = new int[V];
        Predecessor[] predecessor = new Predecessor[V];
        for (int i = 0; i < V; i++) {
            Predecessor predecessor1 = new Predecessor();
            predecessor1.value = -1;
            dis[i] = Integer.MAX_VALUE;
            predecessor[i] = predecessor1;
        }

        // initialize distance of source as 0
        dis[src-1] = 0;

        // RELAX
        for (int i = 0; i < V; i++) {
//            ArrayList<Predecessor> predecessors = new ArrayList<>();
            for (int j = 0; j < E; j++) {
                // subtract 1 if !indexis0
                if (dis[graph[j][0]-1] != Integer.MAX_VALUE && dis[graph[j][0]-1] + graph[j][2] < dis[graph[j][1]-1]) {
                    dis[graph[j][1]-1] = dis[graph[j][0]-1] + graph[j][2];
                    // keep track of path
                    if (predecessor[graph[j][1]-1].value != -1){
                        Predecessor new_predecessor = new Predecessor();
                        new_predecessor.value = graph[j][0];
                        predecessor[graph[j][1]-1].next = new_predecessor;
                    }
                    else{
                        predecessor[graph[j][1]-1].value = graph[j][0];
                    }
                }
            }

            String path = Integer.toString(src);
            int v = predecessor[i].value;
            while (v != -1){
                path += " -> " + (v+1);
                if (predecessor[i].next != null){
                    predecessor[i] = predecessor[i].next;
                    v = predecessor[i].value;
                }
                else{
                    break;
                }
            }
//            for (int k: predecessor){
//                System.out.println(k);
//            }
//            System.out.println("--------");
            paths[i] = path;
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

//        System.out.println("Vertex \t\t\t Cost");
        for (int i = 0; i < V; i++)
            System.out.println(src + " -----> " + (i+1) + " cost is " + dis[i] + "; path: " + paths[i]);
    }

//    void printPath(int predecessor[], int j)
//    {
//        // Base Case : If j is source
//        String path = Integer.toString();
//        if (predecessor[j]==-1)
//            return;
//
//        printPath(predecessor, predecessor[j]);
//
//        path += " -> " + (v+1);
//    }


}
