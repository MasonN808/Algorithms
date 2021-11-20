public class Binary_Search_Tree {
    int comparisons;
    Node first_root;
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
            System.out.print(" " + "L");
        }
        else{ // go down right side if word > root.name
            root.right = populateBST(root.right, word);
            System.out.print(" " + "R");
        }
        return root;
    }

    public Node makeBST(String[] words)
    {
        Node root = null;
        boolean gotroot = false;
        // go through all words and populate BST using method populateBST
        for (String word: words) {
            if (!gotroot){
                gotroot = true;
                Node temp_first_root = new Node();
                temp_first_root.name = word;
                first_root = temp_first_root;
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

    public Node search(Node root, String target){
        if (root.name.equals(target) | root == null){
            comparisons += 1;
            return root;
        }

        if (target.compareTo(root.name) >= 0){
            comparisons += 1;
            System.out.print(" " + "L");
            return search(root.left, target);

        }

        else{
            comparisons += 1;
            System.out.print(" " + "R");
            return search(root.right, target);

        }
    }
}
