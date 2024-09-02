public class Day73_Solution1 {
        public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
            TreeNode[] red = new TreeNode[1];
            findNode(root, x, red);
            int[] countLeft = new int[1], countRight = new int[1];
            countNodes(red[0].left, countLeft);
            countNodes(red[0].right, countRight);

            int l = countLeft[0], r = countRight[0];

            return l > n - l || r > n - r || l + r + 1 < n - l - r - 1;
        }

        private void countNodes(TreeNode node, int[] count) {
            if (node == null) return;

            count[0]++;
            countNodes(node.left, count);
            countNodes(node.right, count);
        }

        private void findNode(TreeNode node, int x, TreeNode[] res) {
            if (node == null) return;

            if (node.val == x) {
                res[0] = node;
                return;
            }

            findNode(node.left, x, res);
            findNode(node.right, x, res);
        }
    }

