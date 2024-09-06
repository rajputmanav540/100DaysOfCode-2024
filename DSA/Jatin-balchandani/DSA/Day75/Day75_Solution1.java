public class Day75_Solution1 {

        // Function to return the lowest common ancestor in a Binary Tree.
        Node lca(Node root, int n1, int n2) {
            // Base case: if root is null, return null
            if (root == null) {
                return null;
            }

            // If the root matches either n1 or n2, return root
            if (root.data == n1 || root.data == n2) {
                return root;
            }

            // Recur for left and right subtrees
            Node leftLCA = lca(root.left, n1, n2);
            Node rightLCA = lca(root.right, n1, n2);

            // If both left and right calls returned non-null, root is the LCA
            if (leftLCA != null && rightLCA != null) {
                return root;
            }

            // Otherwise, return the non-null child
            return (leftLCA != null) ? leftLCA : rightLCA;
        }
    }