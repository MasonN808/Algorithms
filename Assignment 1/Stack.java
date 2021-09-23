public class Stack {
    Node top;
    // set private to avoid being accessed outside of class
    private String setVal;

    public boolean isEmpty(){
        return(top == null);
    }

    public void push(String s){
        Node oldTop = top;
        top = new Node();
        top.name = s;
        top.next = oldTop;
    }

    public String pop(){
        if(!isEmpty()){
            setVal = top.name;
            top = top.next;
        }else{
            return ("");
        }
        return setVal;
    }

    public String peek(){
        if(!isEmpty()){
            setVal = top.name;
        }else{
            return ("");
        }
        return setVal;
    }

    public void show(){
        while(!isEmpty()){
            if(top.next == null){
                System.out.print(top.name);
            }else {
                System.out.print(top.name + " | ");
            }
            top = top.next;
        }
    }
}
