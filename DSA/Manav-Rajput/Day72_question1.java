class Solution {
    // Function to return a list containing the bottom view of the given tree.
    public ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;

        // Map to store the bottom view (HD -> Node data)
        TreeMap<Integer, Integer> map = new TreeMap<>();
        // Queue for level order traversal, storing pair of node and its horizontal distance
        Queue<Pair> queue = new LinkedList<>();
        
        // Starting with the root node at HD 0
        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair temp = queue.poll();
            Node currentNode = temp.node;
            int hd = temp.hd;

            // Update the map with the current node at horizontal distance 'hd'
            map.put(hd, currentNode.data);

            // If the node has a left child, add it to the queue with HD - 1
            if (currentNode.left != null) {
                queue.add(new Pair(currentNode.left, hd - 1));
            }

            // If the node has a right child, add it to the queue with HD + 1
            if (currentNode.right != null) {
                queue.add(new Pair(currentNode.right, hd + 1));
            }
        }

        // Collecting the bottom view from the map
        for (Integer value : map.values()) {
            result.add(value);
        }

        return result;
    }

    // Pair class to store a node and its horizontal distance
    class Pair {
        Node node;
        int hd;

        public Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }
}
