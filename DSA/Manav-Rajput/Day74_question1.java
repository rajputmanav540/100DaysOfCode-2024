class Solution {
    private long totalSum = 0;
    private long maxProduct = 0;
    private final int MOD = 1_000_000_007;

    public int maxProduct(TreeNode root) {
        // First pass: calculate the total sum of the tree
        totalSum = calculateSum(root);
        
        // Second pass: find the maximum product
        calculateSumAndMaxProduct(root);
        
        return (int)(maxProduct % MOD);
    }

    private long calculateSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return node.val + calculateSum(node.left) + calculateSum(node.right);
    }

    private long calculateSumAndMaxProduct(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        long subTreeSum = node.val + calculateSumAndMaxProduct(node.left) + calculateSumAndMaxProduct(node.right);
        
        // Calculate the product of this subtree and the rest of the tree
        long product = subTreeSum * (totalSum - subTreeSum);
        
        // Update the maximum product
        maxProduct = Math.max(maxProduct, product);
        
        return subTreeSum;
    }
}
