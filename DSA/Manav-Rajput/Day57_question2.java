class Solution {
   
    boolean isPalindrome(Node head) {
        if (head == null || head.next == null) {
            return true; 
        }
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node secondHalf = reverse(slow);
        Node firstHalf = head;
        Node firstPointer = firstHalf;
        Node secondPointer = secondHalf;
        boolean isPalindrome = true;
        while (secondPointer != null) {
            if (firstPointer.data != secondPointer.data) {
                isPalindrome = false;
                break;
            }
            firstPointer = firstPointer.next;
            secondPointer = secondPointer.next;
        }

        return isPalindrome;
    }

    Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
