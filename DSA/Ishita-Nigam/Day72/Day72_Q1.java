//Bottom View of Binary Tree
import java.util.ArrayList;
import java.util.Arrays;

public class Day72_Q1 {

    // Function to return a list containing the bottom view of the given tree.
    public ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> answer = new ArrayList<>();
        int n = countNodes(root);
        int vec[] = new int[2 * n + 1];
        Arrays.fill(vec, Integer.MIN_VALUE);
        int vec1[] = new int[2 * n + 1];
        Arrays.fill(vec1, Integer.MIN_VALUE);
        int mid = n, horizontalDistance = 0, priority = 0;
        int leftIndex = 0, rightIndex = 0;

        bottomViewHelper(root, vec, vec1, horizontalDistance, priority, mid, leftIndex, rightIndex);
        for (int a : vec) {
            if (a != Integer.MIN_VALUE) {
                answer.add(a);
            }
        }

        return answer;
    }

    private static void bottomViewHelper(Node root, int[] vec, int[] vec1, int horizontalDistance, int priority, int mid, int leftIndex, int rightIndex) {
        if (root == null) {
            return;
        }

        // Update the left index.
        if (horizontalDistance < leftIndex) {
            leftIndex = horizontalDistance;
        }
        // Update the right index.
        if (horizontalDistance > rightIndex) {
            rightIndex = horizontalDistance;
        }
        // If no node is already present at that horizontal distance, add the current one.
        if (vec[mid + horizontalDistance] == Integer.MIN_VALUE) {
            vec[mid + horizontalDistance] = root.data;
            vec1[mid + horizontalDistance] = priority;
        }
        // Else compare the priority of the already existing and current node.
        else if (vec1[mid + horizontalDistance] <= priority) {
            vec[mid + horizontalDistance] = root.data;
            vec1[mid + horizontalDistance] = priority;
        }
        // Recur for left subtree.
        bottomViewHelper(root.left, vec, vec1, horizontalDistance - 1, priority + 1, mid, leftIndex, rightIndex);
        // Recur for right subtree.
        bottomViewHelper(root.right, vec, vec1, horizontalDistance + 1, priority + 1, mid, leftIndex, rightIndex);
    }

    private static int countNodes(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
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
        Day72_Q1 tree = new Day72_Q1();

        // Example tree
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(25);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        // Get the bottom view
        ArrayList<Integer> result = tree.bottomView(root);

        // Print the result
        System.out.println(result); // Expected output: [5, 10, 3, 14, 25]
    }
}

