// Binary Tree Coloring Game
public class Day73_Q1 {

    static int xkaleft;
    static int xkaright;
    
    // TreeNode class definition (non-public)
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        // Constructor for TreeNode
        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    // Method to calculate the size of the tree and track the sizes of the left and right subtrees of node x
    public static int size(TreeNode node, int x) {
        if (node == null) {
            return 0;
        }

        int ls = size(node.left, x);
        int rs = size(node.right, x);

        int ts = ls + rs + 1;

        if (node.val == x) {
            xkaleft = ls;
            xkaright = rs;
        }
        return ts;
    }

    // Method to determine if the second player can win the game
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        size(root, x);

        int otherside = n - (xkaleft + xkaright + 1);
        int maxofthree = Math.max(otherside, Math.max(xkaleft, xkaright));

        int rest = n - maxofthree;

        return maxofthree > rest;
    }

    // Main method for testing
    public static void main(String[] args) {
        // Example usage:
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        Day73_Q1 solution = new Day73_Q1();
        int n = 7; // Total number of nodes
        int x = 2; // Node selected by the first player

        boolean result = solution.btreeGameWinningMove(root, n, x);
        System.out.println("Can the second player win? " + result);
    }
}

