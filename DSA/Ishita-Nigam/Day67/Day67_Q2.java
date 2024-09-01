import java.util.ArrayList;
import java.util.List;

public class Day67_Q2 {
    public ArrayList<Integer> list;

    public void fun(TreeNode root) {
        if (root == null) {
            return;
        }
        fun(root.left);
        list.add(root.val);
        fun(root.right);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        list = new ArrayList<>();
        fun(root);
        return list;
    }

    public static void main(String[] args) {
        // Example usage of the inorderTraversal method
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        Day67_Q2 solution = new Day67_Q2();
        List<Integer> result = solution.inorderTraversal(root);

        System.out.println(result); // Output: [1, 3, 2]
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
