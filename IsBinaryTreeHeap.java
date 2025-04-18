
/*
Node defined as
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/
class Solution {
    
    // Counts the total number of nodes in the binary tree
    int count(Node root) {
        if (root == null) {
            return 0;
        }
        // Total nodes = 1 (current node) + left subtree + right subtree
        return 1 + count(root.left) + count(root.right);
    }

    // Checks if the binary tree is a Complete Binary Tree (CBT)
    boolean isCBT(Node root, int i, int node_count) {
        if (root == null) {
            return true; // An empty tree is complete
        }

        // If index assigned to current node is more than or equal to number of nodes, it's not CBT
        if (i >= node_count) {
            return false;
        }

        // Recursively check left and right subtrees
        return isCBT(root.left, 2 * i + 1, node_count) &&
               isCBT(root.right, 2 * i + 2, node_count);
    }

    // Checks if the binary tree follows Max Heap property
    boolean maxHeap(Node root) {
        // Check left child
        if (root.left != null) {
            if (root.data < root.left.data) {
                return false; // Parent must be >= left child
            }

            // Recurse on left subtree
            if (!maxHeap(root.left)) {
                return false;
            }
        }

        // Check right child
        if (root.right != null) {
            if (root.data < root.right.data) {
                return false; // Parent must be >= right child
            }

            // Recurse on right subtree
            return maxHeap(root.right);
        }

        // If both children are null or checks pass, return true
        return true;
    }

    // Main function to check if the binary tree is a heap
    boolean isHeap(Node tree) {
        // Step 1: Count total nodes
        int nodes = count(tree);

        // Step 2: Check if it is Complete Binary Tree (CBT)
        if (!isCBT(tree, 0, nodes)) {
            return false;
        }

        // Step 3: Check Max Heap property
        return maxHeap(tree);
    }
}
