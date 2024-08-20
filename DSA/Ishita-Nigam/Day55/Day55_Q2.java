//Reverse a Linked List in Groups
// Day55_Q2.java

class Node {
    int data;
    Node next;

    Node() {
    }

    Node(int data) {
        this.data = data;
    }

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

public class Day55_Q2 {
    public static void main(String[] args) {
        // Example usage
        Node head = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, new Node(6))))));
        int k = 3;

        Solution solution = new Solution();
        Node reversedHead = solution.reverse(head, k);

        // Print reversed linked list
        printList(reversedHead);
    }

    // Utility method to print the linked list
    private static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

class Solution {
    public static Node reverse(Node node, int k) {
        Node curr = node, prev = null, next = null;
        int count = 0;

        // Reverse the first k nodes of the list
        while (curr != null && count < k) {
            next = curr.next; // Mark the next node
            curr.next = prev; // Reverse the link
            prev = curr; // Update prev
            curr = next; // Move to the next node
            count++;
        }

        // next is now pointing to (k+1)th node, recurse for the list starting from next
        if (next != null) {
            node.next = reverse(next, k); // Reverse the rest of the list and connect it
        }

        // prev is the new head of the reversed list
        return prev;
    }
}
