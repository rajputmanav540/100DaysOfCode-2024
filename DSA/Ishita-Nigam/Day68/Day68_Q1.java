//Binary Tree Postorder Traversal
import java.util.List;
import java.util.ArrayList;

public class Day68_Q1 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        fun(root, result);
        return result;
    }

    private void fun(TreeNode root, List<Integer> result) {
        if (root != null) {
            fun(root.left, result);
            fun(root.right, result);
            result.add(root.val);
        }
    }

    public static void main(String[] args) {
        // Example usage of the TreeNode and postorderTraversal
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        Day68_Q1 solution = new Day68_Q1();
        List<Integer> result = solution.postorderTraversal(root);

        System.out.println(result); // Output: [3, 2, 1]
    }
}

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}
