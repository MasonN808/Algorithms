import java.io.*;
import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        String[] words = {};
        // Testing for List class and Node class
        Node person1 = new Node();
        person1.name = "Jhon Von Neumann";
        person1.next = null;
        Node person2 = new Node();
        person2.name = "Paul Erdos";
        person2.next = null;
        person1.next = person2;
        Node person3 = new Node();
        person3.name = "Carl Gauss";
        person3.next = null;
        person2.next = person3;
        Node person4 = new Node();
        person4.name = "Aristotle";
        person4.next = null;
        person3.next = person4;

        List people = new List();
        people.head = person1;
        System.out.println("List:");
        people.show();
        System.out.println();

        Stack stacked_people = new Stack();
        stacked_people.top = person1;
        System.out.println("Stack:");
        stacked_people.show();
        System.out.println();


        Queue queued_people = new Queue();
        queued_people.head = person1;
        queued_people.tail = person4;
        System.out.println("Queue:");
        queued_people.show();
        System.out.println();

        // Read line by line the txt file using File reader
        String fileName = "Assignment 1/magicitems";
        File file = new File(fileName);
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                // add strings from txt file line by line into array words
                words = Arrays.copyOf(words, words.length + 1); //extends memory
                words[words.length - 1] = line; //adds word to extra memory
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int times = 0;
        for (String i : words) {
            // initialize stack and queue for each line of words
            Stack sword = new Stack();
            Queue qword = new Queue();
            // make all letters lowercase
            i = i.toLowerCase();
            // remove all spaces
            i = i.replaceAll(" ", "");
            // push every character into the stack and enqueue into a queue as strings
            for(int j = 0; j < i.length(); j++){
                //get every character from every line
                char k = i.charAt(j);
                // convert characters to strings
                String string_char = Character.toString(k);
                sword.push(string_char);
                qword.enqueue(string_char);
            }
            // initialize reversed words as empty strings
            String reversed_word_stack = "";
            String word_queue = "";
            // pop every element in the stack to get the reversed word and dequeue in the queue
            for(int k = 0; k < i.length(); k++){
                word_queue += qword.dequeue();
                reversed_word_stack += sword.pop();
            }
            // see if reversed word is equal to dequeued word(i.e. a palindrome)
            if (reversed_word_stack.equals(word_queue)){
                // print word if palindrome
                System.out.println(reversed_word_stack);
                times += 1;
            }
        }
        System.out.println("Number of Palindromes: " + times);
    }
}

