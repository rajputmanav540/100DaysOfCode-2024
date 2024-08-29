//Binary Tree Level Order Traversal
import java.util.ArrayList;
import java.util.List;

public class Day69_Q1 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> al = new ArrayList<>();
        pre(root, 0, al);
        return al;
    }

    public static void pre(TreeNode root, int l, List<List<Integer>> al) {
        if (root == null) {
            return;
        }
        if (al.size() == l) {
            List<Integer> li = new ArrayList<>();
            li.add(root.val);
            al.add(li);
        } else {
            al.get(l).add(root.val);
        }
        pre(root.left, l + 1, al);
        pre(root.right, l + 1, al);
    }

    public static void main(String[] args) {
        
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        Day69_Q1 solution = new Day69_Q1();
        List<List<Integer>> result = solution.levelOrder(root);

        System.out.println(result); 
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
