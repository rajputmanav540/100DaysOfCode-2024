import java.util.*;

// Definition for a binary tree node.
class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class Pair {
    Node node;
    int pos;

    public Pair(Node node, int pos) {
        this.node = node;
        this.pos = pos;
    }
}

class Day72_Solution1 {
    public ArrayList<Integer> bottomView(Node root) {
        // Your Code Here
        if (root == null) return new ArrayList<>();  // Handle edge case for null root

        Queue<Pair> q = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>(); // Use TreeMap to keep the keys sorted
        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair temp = q.poll();
            Node node = temp.node;
            int line = temp.pos;

            // Update the bottom view (keep the latest node at each horizontal distance)
            map.put(line, node.data);

            if (node.left != null) q.add(new Pair(node.left, line - 1));
            if (node.right != null) q.add(new Pair(node.right, line + 1));
        }

        // Extract values from the map
        ArrayList<Integer> result = new ArrayList<>();
        for (int value : map.values()) {
            result.add(value);
        }

        return result;
    }
}
