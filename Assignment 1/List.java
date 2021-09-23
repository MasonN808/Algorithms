public class List {
    Node head;
    String show;

    public boolean isEmpty(){
        return(head == null);
    }
     // show the elements in the list
    public void show(){
        Node init = head;
        while(!isEmpty()){
            System.out.print(head.name + " | ");
            head = head.next;
        }
    }
}
