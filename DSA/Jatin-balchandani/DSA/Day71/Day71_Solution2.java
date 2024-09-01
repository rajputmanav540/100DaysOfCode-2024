import java.util.*;

public class Day71_Solution2 {

    // Definition for a binary tree node.
    class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    class Tree {
        // Function to return list containing elements of the left view of a binary tree.
        ArrayList<Integer> leftView(Node root) {
            ArrayList<Integer> leftview = new ArrayList<>();
            if (root == null) {
                return leftview;
            }
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                int levelSize = queue.size(); // Number of nodes at the current level
                for (int i = 0; i < levelSize; i++) {
                    Node currentNode = queue.poll();
                    // The first node of each level is the leftmost node
                    if (i == 0) {
                        leftview.add(currentNode.data);
                    }
                    if (currentNode.left != null) {
                        queue.add(currentNode.left);
                    }
                    if (currentNode.right != null) {
                        queue.add(currentNode.right);
                    }
                }
            }
            return leftview;
        }
    }

    // Sample usage of the code
    public static void main(String[] args) {
        Day71_Solution2 solution = new Day71_Solution2();
        Tree tree = solution.new Tree();

        // Creating a simple binary tree
        Node root = solution.new Node(1);
        root.left = solution.new Node(2);
        root.right = solution.new Node(3);
        root.left.left = solution.new Node(4);
        root.left.right = solution.new Node(5);
        root.right.right = solution.new Node(6);

        ArrayList<Integer> leftViewResult = tree.leftView(root);
        System.out.println("Left View of the Binary Tree: " + leftViewResult);
    }
}
