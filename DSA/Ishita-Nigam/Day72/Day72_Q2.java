//Vertical Order Traversal of a Binary Tree
import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class Day72_Q2 {
    
    Map<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map;
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        map = new TreeMap<>();
        dfs(root, 0, 0);
        List<List<Integer>> res = new LinkedList<>();
        for (int key : map.keySet()){
            List<Integer> list = new LinkedList<>();
            TreeMap<Integer, PriorityQueue<Integer>> tm = map.get(key);
            for (int k : tm.keySet()){
                PriorityQueue<Integer> pq = tm.get(k);
                while (!pq.isEmpty()){
                    list.add(pq.poll());
                }
            }
            res.add(list);
        }
        return res;
    }
    
    private void dfs(TreeNode root, int index, int level){
        if (root == null)
            return;
        
        map.putIfAbsent(index, new TreeMap<>());
        map.get(index).putIfAbsent(level, new PriorityQueue<>());
        map.get(index).get(level).add(root.val);
        dfs(root.left, index - 1, level + 1);
        dfs(root.right, index + 1, level + 1);
    }

    public static void main(String[] args) {
        // Create the binary tree
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        // Create an instance of Day72_Q2 and call the verticalTraversal method
        Day72_Q2 solution = new Day72_Q2();
        List<List<Integer>> result = solution.verticalTraversal(root);

        // Print the result
        for (List<Integer> level : result) {
            System.out.println(level);
        }
    }
}
