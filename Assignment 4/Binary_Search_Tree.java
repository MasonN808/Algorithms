public class Binary_Search_Tree {
    int i = 0;
    String path;
    int comparisons;
//    Node first_root;
    public Node populateBST(Node root, String word){

        // if there is no root to begin with or it hits a terminal node
        if (root == null){
//            comparisons += 1;
            Node node = new Node();
            node.name = word;
//            System.out.println(node.name +": " + path);
//            System.out.println(" " + "Comparisons: " + comparisons);
            return node;
        }
        // go down the left side if word <= root.name
        else if (word.compareTo(root.name) >= 0){
//            comparisons += 1;
            root.left = populateBST(root.left, word);
//            path += " " + "L";
            System.out.print(" " + "L");
        }
        else{ // go down right side if word > root.name
//            comparisons += 1;
            root.right = populateBST(root.right, word);
//            path += " " + "R";
            System.out.print(" " + "R");
        }
//        System.out.println();
//        comparisons = 0;
        return root;
    }

    public Node makeBST(String[] words)
    {
        Node root = null;
        boolean gotroot = false;
        // go through all words and populate BST using method populateBST
        for (String word: words) {
            //reset path
//            path = "";
            if (!gotroot){
                gotroot = true;
                Node temp_first_root = new Node();
                temp_first_root.name = word;
//                first_root = temp_first_root;
            }
            System.out.println(word + ": ");
            root = populateBST(root, word);
            System.out.println();
        }
        // if there are no words
        return root;
    }

    public void inorder(Node root)
    {
        if (root == null) {
            return;
        }

        // go to the left child
        inorder(root.left);
        // print the current root name
        System.out.println(root.name);
        // go to the right child
        inorder(root.right);
    }

}
