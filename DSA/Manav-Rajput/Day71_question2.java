class Tree {
    // Function to return list containing elements of the left view of binary tree.
    ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        // This map will store the first node of each level
        Map<Integer, Integer> levelMap = new HashMap<>();
        // Helper function to perform DFS
        dfs(root, 0, levelMap);

        // Extract values from the map, sorted by their levels
        for (int i = 0; i < levelMap.size(); i++) {
            result.add(levelMap.get(i));
        }

        return result;
    }

    // DFS Helper function
    private void dfs(Node node, int level, Map<Integer, Integer> levelMap) {
        if (node == null) {
            return;
        }

        // If this level is not yet in the map, add the node
        if (!levelMap.containsKey(level)) {
            levelMap.put(level, node.data);
        }

        // Traverse left subtree first
        dfs(node.left, level + 1, levelMap);
        // Traverse right subtree
        dfs(node.right, level + 1, levelMap);
    }
}
