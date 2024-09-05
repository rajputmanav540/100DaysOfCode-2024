//Distribute Coins in Binary Tree
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class Day75_Q2 {
    private int steps = 0;

    // DFS helper function to calculate the required coin distribution steps.
    private int dfs(TreeNode node) {
        if (node == null) return 0;

        int leftReq = dfs(node.left);
        int rightReq = dfs(node.right);

        // Calculate the total steps required for the left and right subtrees.
        steps += Math.abs(leftReq) + Math.abs(rightReq);

        // Return the excess/deficit of coins at this node.
        return (node.val - 1) + leftReq + rightReq;
    }

    // Main function to initiate the coin distribution calculation.
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return steps;
    }

    // Main method for testing
    public static void main(String[] args) {
        Day75_Q2 tree = new Day75_Q2();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(0);
        root.right = new TreeNode(0);

        // Testing the distributeCoins function
        int result = tree.distributeCoins(root);
        System.out.println("Steps required to distribute coins: " + result);  // Expected Output: 2
    }
}