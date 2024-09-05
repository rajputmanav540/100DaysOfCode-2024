class Solution
{
    // Function to return the lowest common ancestor in a Binary Tree.
    Node lca(Node root, int n1, int n2)
    {
        // Base case: if the root is null, return null
        if (root == null) {
            return null;
        }
        
        // If either n1 or n2 matches with root's key, return root
        if (root.data == n1 || root.data == n2) {
            return root;
        }
        
        // Recur for left and right subtrees
        Node leftLCA = lca(root.left, n1, n2);
        Node rightLCA = lca(root.right, n1, n2);
        
        // If both of the above calls return non-null, then one key
        // is present in one subtree and the other is present in the other subtree
        // So this node is the LCA
        if (leftLCA != null && rightLCA != null) {
            return root;
        }
        
        // Otherwise check if left subtree or right subtree is the LCA
        return (leftLCA != null) ? leftLCA : rightLCA;
    }
}
