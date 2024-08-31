//Binary Tree Right Side View
import java.util.ArrayList;
import java.util.List;

public class Day71_Q1 {
    int maxlevel = 0;

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        right(root, 1, list);
        return list;
    }

    void right(TreeNode root, int level, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (maxlevel < level) {
            list.add(root.val);
            maxlevel = level;
        }
        right(root.right, level + 1, list);
        right(root.left, level + 1, list);
    }

    // TreeNode class definition
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        Day71_Q1 solution = new Day71_Q1();

        // Example tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        // Get the right side view
        List<Integer> result = solution.rightSideView(root);

        // Print the result
        System.out.println(result); // Output should be [1, 3, 4]
    }
}
