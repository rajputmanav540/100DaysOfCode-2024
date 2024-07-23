class Solution {

    public Node RemoveHalfNodes(Node root) {
        if (root == null) {
            return null;
        }
        root.left = RemoveHalfNodes(root.left);
        root.right = RemoveHalfNodes(root.right);
       
        if (root.left == null && root.right != null) {
            return root.right;
        }
        
        if (root.left != null && root.right == null) {
            return root.left;
        }
        return root;
    }
    void inorderTraversal(Node node) {
        if (node == null) {
            return;
        }
        
        inorderTraversal(node.left);
        System.out.print(node.data + " ");
        inorderTraversal(node.right);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Node root = new Node(5);
        root.left = new Node(7);
        root.right = new Node(8);
        root.left.left = new Node(2);
        
        root = solution.RemoveHalfNodes(root);
        solution.inorderTraversal(root);  
    }
}
