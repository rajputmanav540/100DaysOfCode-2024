class Solution {
    // Function to add two numbers represented by linked list.
    static Node addTwoLists(Node num1, Node num2) {
        // Reverse both lists to start addition from the least significant digit
        num1 = reverseList(num1);
        num2 = reverseList(num2);
        
        Node dummyHead = new Node(0);
        Node current = dummyHead;
        int carry = 0;
        
        // Traverse both lists
        while (num1 != null || num2 != null) {
            int sum = carry;
            
            if (num1 != null) {
                sum += num1.data;
                num1 = num1.next;
            }
            
            if (num2 != null) {
                sum += num2.data;
                num2 = num2.next;
            }
            
            // Calculate carry for the next iteration
            carry = sum / 10;
            sum = sum % 10;
            
            // Create a new node with the sum and attach to the result list
            current.next = new Node(sum);
            current = current.next;
        }
        
        // If there's any carry left, add it as a new node
        if (carry > 0) {
            current.next = new Node(carry);
        }
        
        // Reverse the resultant list to restore the proper order
        return reverseList(dummyHead.next);
    }
    
    // Helper method to reverse the linked list
    static Node reverseList(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;
        
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        return prev;
    }
}
