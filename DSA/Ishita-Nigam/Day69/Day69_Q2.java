//Binary Search Tree to Greater Sum Tree
public class Day69_Q2 {
    private int sum = 0;
    
    public TreeNode bstToGst(TreeNode root) {
        reverseInorderTraversal(root);
        return root;
    }
    
    private void reverseInorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        reverseInorderTraversal(node.right);
        sum += node.val;
        node.val = sum;
        reverseInorderTraversal(node.left);
    }

    public static void main(String[] args) {
        
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);

        Day69_Q2 solution = new Day69_Q2();
        TreeNode result = solution.bstToGst(root);

    
        printInorder(result);

    public static void printInorder(TreeNode node) {
        if (node == null) {
            return;
        }
        printInorder(node.left);
        System.out.print(node.val + " ");
        printInorder(node.right);
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}
