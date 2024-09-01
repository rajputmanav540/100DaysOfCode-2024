class Solution {
    public Node connect(Node root) {
        if (root == null) return null;

        Node leftmost = root;

        while (leftmost.left != null) {
            Node head = leftmost;

            while (head != null) {
                // Connect left child to right child
                head.left.next = head.right;

                // Connect right child to the next left child
                if (head.next != null) {
                    head.right.next = head.next.left;
                }

                // Move to the next node on the same level
                head = head.next;
            }

            // Move to the next level
            leftmost = leftmost.left;
        }

        return root;
    }
}
