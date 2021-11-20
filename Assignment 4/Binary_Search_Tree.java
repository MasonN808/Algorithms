public class Binary_Search_Tree {
    int i = 0;
    public Node populateBST(Node root, String word){
        // if there is no root to begin with or it hits a terminal node
        if (root == null){
            Node node = new Node();
            node.name = word;
            return node;
        }
        // go down the left side if word <= root.name
        else if (word.compareTo(root.name) >= 0){
            root.left = populateBST(root.left, word);
        }
        else{ // go down right side if word > root.name
            root.right = populateBST(root.right, word);
        }
        return root;
    }

    public Node makeBST(String[] words)
    {
        Node root = null;
        // go through all words and populate BST using method populateBST
        for (String word: words) {
            root = populateBST(root, word);
        }
        // if there are no words
        return root;
    }

}
