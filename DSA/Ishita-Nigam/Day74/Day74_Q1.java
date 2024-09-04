//Maximum Product of Splitted Binary Tree
import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
    }
}

public class Day74_Q1 {
    public int maxProduct(TreeNode root) {
        final int kMod = 1_000_000_007;
        long ans = 0;
        List<Integer> allSums = new ArrayList<>();
        final long totalSum = treeSum(root, allSums);

        for (final long sum : allSums)
            ans = Math.max(ans, sum * (totalSum - sum));

        return (int) (ans % kMod);
    }

    private int treeSum(TreeNode root, List<Integer> allSums) {
        if (root == null)
            return 0;

        final int leftSum = treeSum(root.left, allSums);
        final int rightSum = treeSum(root.right, allSums);
        final int sum = root.val + leftSum + rightSum;
        allSums.add(sum);
        return sum;
    }

    public static void main(String[] args) {
        // Example usage:
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        Day74_Q1 solution = new Day74_Q1();
        System.out.println(solution.maxProduct(root));  // Output will depend on the tree structure
    }
}
