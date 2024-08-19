class Solution {
    Node compute(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        // Reverse the linked list
        head = reverseList(head);
        
        // Traverse the reversed list and keep track of the max value
        Node maxNode = head;
        Node current = head;
        
        while (current != null && current.next != null) {
            if (current.next.data < maxNode.data) {
                // Remove the node
                current.next = current.next.next;
            } else {
                // Move to the next node
                current = current.next;
                maxNode = current;
            }
        }
        
        // Reverse the list again to restore the original order
        head = reverseList(head);
        
        return head;
    }
    
    // Helper method to reverse the linked list
    Node reverseList(Node head) {
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
