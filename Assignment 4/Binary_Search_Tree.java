public class Binary_Search_Tree {
    int i = 0;
    String path;
    public Node populateBST(Node root, String word){
        // if there is no root to begin with or it hits a terminal node
        if (root == null){
            Node node = new Node();
            node.name = word;
//            System.out.println(node.name +": " + path);
            return node;
        }
        // go down the left side if word <= root.name
        else if (word.compareTo(root.name) >= 0){
            root.left = populateBST(root.left, word);
//            path += " " + "L";
            System.out.print(" " + "L");
        }
        else{ // go down right side if word > root.name
            root.right = populateBST(root.right, word);
//            path += " " + "R";
            System.out.print(" " + "R");
        }
        System.out.println();
        return root;
    }

    public Node makeBST(String[] words)
    {
        Node root = null;
        // go through all words and populate BST using method populateBST
        for (String word: words) {
            //reset path
//            path = "";
            System.out.println(word + ": ");
            root = populateBST(root, word);
        }
        // if there are no words
        return root;
    }

}
