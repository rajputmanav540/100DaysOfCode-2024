// File: Day59_Q2.java

class Day59_Q2 {

    // Definition for singly-linked list node
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Function to reverse the linked list
    static Node reverseList(Node head) {
        if (head == null || head.next == null)
            return head;
        Node prev = null;
        Node cur = head;
        while (cur != null && cur.next != null) {
            Node temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        cur.next = prev;
        return cur;
    }

    // Function to add two numbers represented by linked lists
    static Node addTwoLists(Node l1, Node l2) {
        int carry = 0;

        // Reverse both linked lists to handle addition from the least significant digit
        l1 = reverseList(l1);
        l2 = reverseList(l2);

        Node curr1 = l1, curr2 = l2, prev = null;
        Node temp1 = curr1, temp2 = curr2;
        boolean switched = false;

        // Traverse both linked lists and calculate the sum digit by digit
        while (curr1 != null || curr2 != null) {
            int v1 = (curr1 != null) ? curr1.data : 0;
            int v2 = (curr2 != null) ? curr2.data : 0;
            int sum = v1 + v2 + carry;
            carry = sum / 10;

            // Update the current node's data with the remainder (current digit)
            if (curr1 != null) {
                curr1.data = sum % 10;
                prev = curr1;
            } else {
                switched = true;
                prev.next = curr2;
                curr2.data = sum % 10;
                prev = curr2;
            }

            // Move to the next nodes
            if (curr1 != null)
                curr1 = curr1.next;
            if (curr2 != null)
                curr2 = curr2.next;
        }

        // If there's still a carry after the final addition, add a new node
        if (carry == 1) {
            prev.next = new Node(1);
        }

        // Reverse the result list back to its original order
        Node result = reverseList(temp1);

        // Remove leading zeroes (if any) from the result
        while (result.next != null && result.data == 0) {
            result = result.next;
        }

        return result;
    }

    // Utility function to print the linked list
    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    // Main method to test the addTwoLists function
    public static void main(String[] args) {
        Day59_Q2 solution = new Day59_Q2();

        // Create first number: 342 (3 -> 4 -> 2)
        Node l1 = new Node(3);
        l1.next = new Node(4);
        l1.next.next = new Node(2);

        // Create second number: 465 (4 -> 6 -> 5)
        Node l2 = new Node(4);
        l2.next = new Node(6);
        l2.next.next = new Node(5);

        // Add the two lists and get the result
        Node result = solution.addTwoLists(l1, l2);

        // Print the resulting list
        System.out.print("Result: ");
        solution.printList(result);
    }
}
