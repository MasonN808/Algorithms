import java.util.ArrayList;

public class Search {
    ArrayList<Integer> processed = new ArrayList<>();

    public void depth_first(Vertex v, Vertex[] array) {
        if (!processed.contains(v.label)) {
            System.out.print(v.label + " ");
            processed.add(v.label);
        }
        for (Vertex neighbor : v.neighbors) {
            if (!processed.contains(neighbor.label)) {
                depth_first(neighbor, array);
            }
        }
        for (Vertex vertex: array){
            if (!processed.contains(vertex.label)){
                if (!processed.contains(vertex.label)) {
                    System.out.print(vertex.label + " ");
                    processed.add(vertex.label);
                }
                for (Vertex neighbor : vertex.neighbors) {
                    if (!processed.contains(neighbor.label)) {
                        depth_first(neighbor, array);
                    }
                }
            }
        }
    }


        public void breadth_first (Vertex v, Vertex[] array){
            Queue queue = new Queue();
            queue.enqueue(v);
            processed.add(v.label);
            while (!queue.isEmpty()) {
//                System.out.println("TEST");
                Vertex vertex = queue.dequeue();
                System.out.print(vertex.label + " ");
                for (Vertex neighbor: vertex.neighbors) {
                    if (!processed.contains(neighbor.label)) {
                        queue.enqueue(neighbor);
                        processed.add(neighbor.label);
                    }
                }
            }
            for (Vertex vertex: array){
                if (!processed.contains(vertex.label)){
                    Queue queue1 = new Queue();
                    queue1.enqueue(vertex);
                    processed.add(vertex.label);
                    while (!queue1.isEmpty()) {
                        Vertex vertex1 = queue1.dequeue();
                        System.out.print(vertex1.label + " ");
                        for (Vertex neighbor: vertex1.neighbors) {
                            if (!processed.contains(neighbor.label)) {
                                queue1.enqueue(neighbor);
                                processed.add(neighbor.label);
                            }
                        }
                    }
                }
                }

        }
    }
