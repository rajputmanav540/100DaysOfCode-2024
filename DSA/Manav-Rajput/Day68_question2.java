 class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderHelper(root, result);
        return result;
    }
    
    private void preorderHelper(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        
        // Visit the root node
        result.add(node.val);
        
        // Recurse on the left subtree
        preorderHelper(node.left, result);
        
        // Recurse on the right subtree
        preorderHelper(node.right, result);
    }
}
