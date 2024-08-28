//Binary Tree Preorder Traversal
import java.util.List;
import java.util.ArrayList;

public class Day68_2 {
    List<Integer> ans = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        preorder(root);
        return ans;
    }

    public void preorder(TreeNode node) {
        if (node == null) {
            return;
        }
        ans.add(node.val);
        preorder(node.left);
        preorder(node.right);
    }

    public static void main(String[] args) {
        // Example usage of the TreeNode and preorderTraversal
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        Day68_2 solution = new Day68_2();
        List<Integer> result = solution.preorderTraversal(root);

        System.out.println(result); // Output: [1, 2, 3]
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
