class Solution {
    // Function to sort the given linked list using Merge Sort.
  static Node mergeSort(Node head) {
        // Base case: if head is null or there is only one element
        if (head == null || head.next == null) {
            return head;
        }

        // Step 1: Split the list into two halves
        Node[] split = splitList(head);
        Node left = split[0];
        Node right = split[1];

        // Step 2: Recursively sort each half
        left = mergeSort(left);
        right = mergeSort(right);

        // Step 3: Merge the sorted halves
        return merge(left, right);
    }

    // Function to split the list into two halves
    static Node[] splitList(Node head) {
        if (head == null || head.next == null) {
            return new Node[]{head, null};
        }

        Node slow = head;
        Node fast = head;
        Node prev = null;

        // Move fast by 2 and slow by 1
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Split the list into two halves
        prev.next = null;
        return new Node[]{head, slow};
    }

    // Function to merge two sorted lists
    static Node merge(Node left, Node right) {
        Node dummy = new Node(-1);
        Node current = dummy;

        while (left != null && right != null) {
            if (left.data <= right.data) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }

        // Append the remaining nodes
        if (left != null) {
            current.next = left;
        }
        if (right != null) {
            current.next = right;
        }

        return dummy.next;
    }
}
