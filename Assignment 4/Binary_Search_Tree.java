public class Binary_Search_Tree {

    public void BST(String[] words){
        Node root = new Node();
        root.name = words[0];
        int index = 1;
        while (index < words.length){

            if (words[index].compareTo(root.name) > 0){
                Node node = new Node();
                node.name = words[index];
                root.left = node;
            }
            index += 1;


        }
    }
}
