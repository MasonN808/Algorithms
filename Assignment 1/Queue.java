public class Queue {
    Node head, tail;

    public boolean isEmpty(){
        return(head == null);
    }

    public void enqueue(String s){
        Node oldTail = tail;
        tail = new Node();
        tail.name = s;
        tail.next = null;
        if(isEmpty()){
            head = tail;
        }else{
            oldTail.next = tail;
        }
    }

    public String dequeue(){
        String retval;
        if(!isEmpty()){
            retval = head.name;
            head = head.next;
            if(isEmpty()){
                tail = null;
            }
        }else{
            retval = "";
        }
        return retval;
    }

    public void show(){
        while(!isEmpty()){
            if(head.next == null){
                System.out.print(head.name);
            }else {
                System.out.print(head.name + " | ");
            }
            head = head.next;
        }
    }

}
