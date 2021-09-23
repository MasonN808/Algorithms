public class Stack {
    Node top;
    String setVal;

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
}
