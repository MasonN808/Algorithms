import java.util.ArrayList;

public class Search {
    ArrayList<Integer> processed = new ArrayList<>();
    public void depth_first(Vertex v){
        if(!processed.contains(v.label)){
            System.out.print(v.label + " ");
            processed.add(v.label);
        }
        for (Vertex neighbor: v.neighbors){
            if (!processed.contains(neighbor.label)){
                depth_first(neighbor);
            }
        }
    }

//    public void depth_first(Vertex v){
//        if(!v.processed){
//            System.out.print(v.label);
//            v.processed = true;
//
//        }
//        for (Vertex neighbor: v.neighbors){
//            if (!neighbor.processed){
//                depth_first(neighbor);
//            }
//        }
//    }


    public void breadth_first(Vertex v){
        Queue queue = new Queue();
        queue.enqueue(v);
        v.processed = true;
        while (!queue.isEmpty()){
            int data = queue.dequeue();
            System.out.print(data);
            if (v.neighbors != null) {
                for (Vertex neighbor : v.neighbors) {
                    if (!neighbor.processed) {
                        queue.enqueue(neighbor);
                        neighbor.processed = true;
                    }
                }
            }
        }

    }
}
