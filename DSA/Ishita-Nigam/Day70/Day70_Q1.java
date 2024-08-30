// Populating Next Right Pointers in Each Node

public class Day70_Q1 {
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public static class Solution {
        private void helper(Node root, Node parent) {
            if (root == null) return;
            if (parent != null) parent.left.next = parent.right;
            if (parent != null && parent.next != null) parent.right.next = parent.next.left;
            if (root.left == null && root.right == null) return;
            helper(root.left, root);
            helper(root.right, root);
        }

        public Node connect(Node root) {
            helper(root, null);
            return root;
        }
    }

    public static void main(String[] args) {
        // Example usage
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Solution solution = new Solution();
        solution.connect(root);

        // Print the next pointers
        printNextPointers(root);
    }

    private static void printNextPointers(Node root) {
        if (root == null) return;
        System.out.print("Node " + root.val + " next -> ");
        if (root.next != null) {
            System.out.println(root.next.val);
        } else {
            System.out.println("null");
        }
        printNextPointers(root.left);
        printNextPointers(root.right);
    }
}
