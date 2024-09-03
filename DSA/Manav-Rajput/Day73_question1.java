class Solution {
    int leftSubtreeSize = 0;
    int rightSubtreeSize = 0;

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        // Find the sizes of the left and right subtrees of node x
        countSubtreeNodes(root, x);

        // The remaining nodes excluding the subtree rooted at x
        int rest = n - (leftSubtreeSize + rightSubtreeSize + 1);

        // Check if the second player can control more than half the nodes
        if (leftSubtreeSize > n / 2 || rightSubtreeSize > n / 2 || rest > n / 2) {
            return true;
        }

        return false;
    }

    private int countSubtreeNodes(TreeNode node, int x) {
        if (node == null) return 0;

        int left = countSubtreeNodes(node.left, x);
        int right = countSubtreeNodes(node.right, x);

        if (node.val == x) {
            leftSubtreeSize = left;
            rightSubtreeSize = right;
        }

        return left + right + 1;
    }
}
