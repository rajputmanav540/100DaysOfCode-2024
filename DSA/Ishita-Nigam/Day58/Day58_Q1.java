// Sort a linked list of 0s, 1s and 2s

class Day58_Q1 {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    static Node segregate(Node head) {
        if (head == null || head.next == null) return head;
        Node zeroD = new Node(0);
        Node oneD = new Node(0);
        Node twoD = new Node(0);
        Node zero = zeroD, one = oneD, two = twoD;
        Node curr = head;
        while (curr != null) {
            if (curr.data == 0) {
                zero.next = curr;
                zero = zero.next;
            } else if (curr.data == 1) {
                one.next = curr;
                one = one.next;
            } else {
                two.next = curr;
                two = two.next;
            }
            curr = curr.next;
        }
        zero.next = (oneD.next != null) ? oneD.next : twoD.next;
        one.next = twoD.next;
        two.next = null;
        head = zeroD.next;
        return head;
    }
    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(2);
        head.next = new Node(1);
        head.next.next = new Node(0);
        head.next.next.next = new Node(1);
        head.next.next.next.next = new Node(2);
        head.next.next.next.next.next = new Node(0);

        System.out.println("Original Linked List:");
        printList(head);

        head = segregate(head);

        System.out.println("Sorted Linked List:");
        printList(head);
    }
}
