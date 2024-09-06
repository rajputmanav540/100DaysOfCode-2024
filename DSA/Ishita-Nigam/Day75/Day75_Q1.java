//  LCA in Binary Tree

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

public class Day75_Q1 {
    // Function to return the lowest common ancestor in a Binary Tree.
    Node lca(Node root, int n1, int n2) {
        if (root == null)
            return null;

        // If either n1 or n2 matches with the data at the current node, we return root.
        if (root.data == n1 || root.data == n2)
            return root;

        // Recursively calling the lca function for left and right subtrees.
        Node leftLCA = lca(root.left, n1, n2);
        Node rightLCA = lca(root.right, n1, n2);

        // If both calls return non-null values, this node is the lowest common ancestor.
        if (leftLCA != null && rightLCA != null)
            return root;

        // Otherwise, we return whichever subtree contains the LCA.
        return (leftLCA != null) ? leftLCA : rightLCA;
    }

    // Main method for testing
    public static void main(String[] args) {
        Day75_Q1 tree = new Day75_Q1();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // Testing the LCA function
        Node lcaNode = tree.lca(root, 4, 5);
        if (lcaNode != null) {
            System.out.println("LCA(4, 5): " + lcaNode.data);  // Expected Output: 2
        } else {
            System.out.println("LCA not found");
        }
    }
}