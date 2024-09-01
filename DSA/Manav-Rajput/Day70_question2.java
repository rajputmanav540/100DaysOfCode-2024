
class Solution {
    int[] answer, count;
    List<List<Integer>> tree;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        tree = new ArrayList<>();
        answer = new int[n];
        count = new int[n];

        // Initialize the tree as an adjacency list
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }

        // Build the tree
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        // Run post-order DFS to calculate counts and initial answer for the root
        dfsPostOrder(0, -1);
        
        // Run pre-order DFS to adjust the answer for all nodes
        dfsPreOrder(0, -1);

        return answer;
    }

    private void dfsPostOrder(int node, int parent) {
        count[node] = 1;  // Each node counts itself
        for (int neighbor : tree.get(node)) {
            if (neighbor == parent) continue;  // Skip the parent to prevent backtracking
            dfsPostOrder(neighbor, node);
            count[node] += count[neighbor];
            answer[node] += answer[neighbor] + count[neighbor];
        }
    }

    private void dfsPreOrder(int node, int parent) {
        for (int neighbor : tree.get(node)) {
            if (neighbor == parent) continue;
            // Adjust the answer for the child node
            answer[neighbor] = answer[node] - count[neighbor] + (count.length - count[neighbor]);
            dfsPreOrder(neighbor, node);
        }
    }
}
