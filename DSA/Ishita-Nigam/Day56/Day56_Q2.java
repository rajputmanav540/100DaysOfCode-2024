// Merge Sort for Linked List

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Day56_Q2 {

    public static void main(String[] args) {
        // Example usage
        Node head = new Node(4);
        head.next = new Node(2);
        head.next.next = new Node(1);
        head.next.next.next = new Node(3);

        Solution solution = new Solution();
        head = solution.mergeSort(head);

        // Print the sorted linked list
        printList(head);
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
    // Function to sort the given linked list using Merge Sort.
    public static Node mergeSort(Node head) {
        if (head == null || head.next == null) return head;

        // Splitting the list into two halves.
        Node middle = getMiddle(head);
        Node nextofmiddle = middle.next;
        middle.next = null;

        // Recursively sorting both halves.
        Node left = mergeSort(head);
        Node right = mergeSort(nextofmiddle);

        // Merging the sorted halves.
        Node sortedlist = sortedMerge(left, right);
        return sortedlist;
    }

    // Function to merge two halves of the list.
    public static Node sortedMerge(Node a, Node b) {
        Node result = null;

        // Base cases when either of the halves is null.
        if (a == null) return b;
        if (b == null) return a;

        // Comparing data in both halves and storing the smaller in result.
        if (a.data <= b.data) {
            result = a;
            result.next = sortedMerge(a.next, b);
        } else {
            result = b;
            result.next = sortedMerge(a, b.next);
        }

        // Returning the resultant list.
        return result;
    }

    // Function to find the middle of the list.
    public static Node getMiddle(Node h) {
        if (h == null) return h;

        // Using two pointers to find the midpoint of the list.
        Node fastptr = h.next;
        Node slowptr = h;

        // Fast pointer moves 2 nodes and slow pointer moves 1 node in each iteration.
        while (fastptr != null) {
            fastptr = fastptr.next;
            if (fastptr != null) {
                slowptr = slowptr.next;
                fastptr = fastptr.next;
            }
        }
        // Slow pointer will be pointing to the node just before the midpoint.
        return slowptr;
    }
}
