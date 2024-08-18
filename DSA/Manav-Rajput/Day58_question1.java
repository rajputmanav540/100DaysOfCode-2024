class Solution {
    // Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head) {
        if (head == null || head.next == null) {
            return head; // List is already sorted
        }

        // Step 1: Count the number of 0s, 1s, and 2s
        int count0 = 0, count1 = 0, count2 = 0;
        Node temp = head;
        
        while (temp != null) {
            if (temp.data == 0) count0++;
            else if (temp.data == 1) count1++;
            else if (temp.data == 2) count2++;
            temp = temp.next;
        }
        
        // Step 2: Update the linked list based on counts
        temp = head;
        while (temp != null) {
            if (count0 > 0) {
                temp.data = 0;
                count0--;
            } else if (count1 > 0) {
                temp.data = 1;
                count1--;
            } else if (count2 > 0) {
                temp.data = 2;
                count2--;
            }
            temp = temp.next;
        }
        
        return head;
    }
}
