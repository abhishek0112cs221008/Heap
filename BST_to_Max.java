
/*class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}*/

class Solution {
    static int index; // Tracks position in sorted 'in' list

    // Step 1: Inorder traversal (left-root-right) of BST gives sorted elements
    private static void inorder(Node root, ArrayList<Integer> in) {
        if (root == null) 
            return;

        inorder(root.left, in);      // Traverse left subtree
        in.add(root.data);           // Visit root
        inorder(root.right, in);     // Traverse right subtree
    }

    // Step 2: Postorder traversal (left-right-root) to build Max Heap from sorted list
    private static void postOrder(Node root, ArrayList<Integer> in) {
        if (root == null) 
            return;

        postOrder(root.left, in);     // Left subtree
        postOrder(root.right, in);    // Right subtree

        // Replace node data from sorted list (largest values assigned last = root)
        root.data = in.get(index++);
    }

    // Main method to initiate conversion
    public static void convertToMaxHeapUtil(Node root) {
        ArrayList<Integer> in = new ArrayList<>();

        // Get sorted list of node values
        inorder(root, in);

        // Reset index and assign values using postorder traversal
        index = 0;
        postOrder(root, in);
    }
}
