// Day73_Q2.java

class Day73_Q2 {
    private static final int MOD = 1000000007;

    // Node class definition
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // Helper method to calculate the product recursively
    private long helper(Node root1, Node root2) {
        if (root1 == null || root2 == null) {
            return 0;
        }

        long product = (1L * root1.data * root2.data) % MOD;
        product = (product + helper(root1.left, root2.right)) % MOD;
        product = (product + helper(root1.right, root2.left)) % MOD;

        return product;
    }

    // Method to calculate the image multiplication
    public long imgMultiply(Node root) {
        if (root == null) {
            return 0;
        }

        long result = (1L * root.data * root.data) % MOD;
        result = (result + helper(root.left, root.right)) % MOD;

        return result;
    }

    public static void main(String[] args) {
        // Example usage:
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(4);
        root.right.right = new Node(3);

        Day73_Q2 solution = new Day73_Q2();
        long result = solution.imgMultiply(root);
        System.out.println("Image Multiplication Result: " + result);
    }
}
