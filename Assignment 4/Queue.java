public class Queue {
    Vertex head, tail;

    public boolean isEmpty(){
        return(head == null);
    }

    public void enqueue(Vertex s){
        Vertex oldTail = tail;
        tail = new Vertex();
        tail = s;
        tail.next = null;
        if(isEmpty()){
            head = tail;
        }else{
            oldTail.next = tail;
        }
    }

    public Vertex dequeue(){
        Vertex retval;
        if(!isEmpty()){
            retval = head;
            head = head.next;
            if(isEmpty()){
                tail = null;
            }
        }else{
            retval = null;
        }
        return retval;
    }

//    public void show(){
//        while(!isEmpty()){
//            if(head.next == null){
//                System.out.print(head.name);
//            }else {
//                System.out.print(head.name + " | ");
//            }
//            head = head.next;
//        }
//    }

}
