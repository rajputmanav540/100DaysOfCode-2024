class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;  // Initialize previous node as null
        ListNode curr = head;  // Initialize current node as head
        
        while (curr != null) {
            ListNode nextNode = curr.next;  // Store the next node
            curr.next = prev;  // Reverse the current node's pointer
            prev = curr;  // Move the previous node to current node
            curr = nextNode;  // Move to the next node in the list
        }
        
        return prev;  // prev will be the new head after reversal
    }
}
