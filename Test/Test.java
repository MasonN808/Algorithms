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


        String fileName = "Assignment 1/Test_Cases";
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
            //initialize original word
            String original_word = "";
            // push every character into the stack and enqueue into a queue as strings
            for(int j = 0; j < i.length(); j++){
                char k = i.charAt(j);
                String string_char = Character.toString(k);
                sword.push(string_char);

                // keep track of original word to compare to reversed word
                original_word += string_char;
            }
            // initialize reversed word
            String reversed_word = "";
            // pop every element in the stack to get the reversed word
            for(int k = 0; k < i.length(); k++){
                reversed_word += sword.pop();
            }
            // see if reversed word is equal to original word (i.e. a palindrome)
            if (reversed_word.equals(original_word)){
                // print word if palindrome
                System.out.println(original_word);
                times += 1;
            }
        }
        System.out.println("Number of Palindromes: " + times);
    }
}

