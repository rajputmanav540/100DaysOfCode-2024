//  Reverse Linked List

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Day55_Q1 {
    public static void main(String[] args) {
        // Example usage
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));

        Solution solution = new Solution();
        ListNode reversedHead = solution.reverseList(head);

        // Print reversed linked list
        printList(reversedHead);
    }

    // Utility method to print the linked list
    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode next = null;
        ListNode curr = head;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
