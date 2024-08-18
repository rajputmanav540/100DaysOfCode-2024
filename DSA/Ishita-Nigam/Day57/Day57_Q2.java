// Palindrome Linked List

class Day57_Q2 {
    
    // Definition for singly-linked list node
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    Node reverse_list(Node head) {
        Node prev = null;
        Node curr = head;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
    boolean is_identical(Node n1, Node n2) {
        for (; n1 != null && n2 != null; n1 = n1.next, n2 = n2.next) {
            if (n1.data != n2.data) return false;
        }
        return true;
    }

    boolean isPalindrome(Node head) {
        int size = 0;
        Node ptr;
        for (ptr = head; ptr != null; ptr = ptr.next) size++;

        if (size < 2) return true;

        ptr = head;
        int mid_pt = (size - 1) / 2;
        while (mid_pt > 0) {
            ptr = ptr.next;
            mid_pt--;
        }
        Node head2 = ptr.next;
        ptr.next = null;

        head2 = reverse_list(head2);

        boolean ret = is_identical(head, head2);

    
        head2 = reverse_list(head2);
        ptr.next = head2;
        return ret;
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);

        System.out.println("Original Linked List:");
        printList(head);

        Day57_Q2 solution = new Day57_Q2();
        boolean isPalindrome = solution.isPalindrome(head);

        System.out.println("Is the linked list a palindrome? " + isPalindrome);
    }
}
