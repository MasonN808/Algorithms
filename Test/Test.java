
public class Test{
    public static void main(String[] args){
        // Testing for List class and Node class
        Node person1 = new Node();
        person1.name = "Jhon Von Neumann";
        person1.next = null;
        Node person2 = new Node();
        person2.name = "Paul Erdos";
        person2.next =  null;
        person1.next = person2;
        Node person3 = new Node();
        person3.name = "Carl Gauss";
        person3.next =  null;
        person2.next = person3;
        Node person4 = new Node();
        person4.name = "Aristotle";
        person4.next = null;
        person3.next = person4;
        List people = new List();
        people.head = person1;
        System.out.println(people);
        people.show();
    }
}

