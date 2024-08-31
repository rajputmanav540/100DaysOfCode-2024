import java.util.*;

public class Day68_Solution2 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
        ArrayList<Integer> result = new ArrayList<>();
        public List<Integer> preorderTraversal(TreeNode root) {
            preOrder(root);
            return result;
        }
        public static void preorder(TreeNode node){
            if(node == null){
                return;
            }
            result.add(node.val);
            preOrder()
        }

    }
