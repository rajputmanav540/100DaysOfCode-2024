class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorderHelper(root, result);
        return result;
    }
    
    private void postorderHelper(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        
        // Recurse on the left subtree
        postorderHelper(node.left, result);
        
        // Recurse on the right subtree
        postorderHelper(node.right, result);
        
        // Visit the root node
        result.add(node.val);
    }
}
