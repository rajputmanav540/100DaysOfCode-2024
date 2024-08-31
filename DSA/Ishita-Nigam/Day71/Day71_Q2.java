//Left View of Binary Tree
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Day71_Q2 {
    // Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node curr = q.poll();
                if (i == 0) {
                    res.add(curr.data);
                }
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
        return res;
    }

    // Node class definition
    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        Day71_Q2 tree = new Day71_Q2();

        // Example tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // Get the left side view
        ArrayList<Integer> result = tree.leftView(root);

        // Print the result
        System.out.println(result); // Output should be [1, 2, 4]
    }
}
