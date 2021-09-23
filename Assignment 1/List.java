public class List {
    Node head;

    public boolean isEmpty(){
        return(head == null);
    }
     // show the elements in the list
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
