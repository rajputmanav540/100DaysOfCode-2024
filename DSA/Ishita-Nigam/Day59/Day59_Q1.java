// Delete nodes having greater value on right

class Day59_Q1 {

    // Definition for singly-linked list node
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node compute(Node head) {
        // Base case: If the list has only one node, return the head
        if (head == null || head.next == null) {
            return head;
        }

        // Recursively process the rest of the list
        head.next = compute(head.next);

        // If the next node's data is greater than the current node's data, return the next node
        if (head.data < head.next.data) {
            return head.next;
        }

        // Otherwise, return the current node
        return head;
    }

    // Utility function to print the linked list
    void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Main method to test the compute function
    public static void main(String[] args) {
        Day59_Q1 solution = new Day59_Q1();

        // Creating a sample linked list
        Node head = new Node(12);
        head.next = new Node(15);
        head.next.next = new Node(10);
        head.next.next.next = new Node(11);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next.next = new Node(3);

        System.out.println("Original Linked List:");
        solution.printList(head);

        // Compute the new linked list by removing nodes with smaller values on the left
        head = solution.compute(head);

        System.out.println("Modified Linked List after compute:");
        solution.printList(head);
    }
}
