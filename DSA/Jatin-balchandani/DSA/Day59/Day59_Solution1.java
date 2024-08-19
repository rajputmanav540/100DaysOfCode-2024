import java.util.*;
public class Day59_Solution1 {
        Node compute(Node head) {
            head = reverse(head);

            Node ans = head;
            Node temp = head;

            while (temp != null && temp.next != null) {
                if (temp.data > temp.next.data) {
                    temp.next = temp.next.next;
                } else {
                    temp = temp.next;
                }
            }

            return reverse(ans);
        }

        public Node reverse(Node head) {
            Node prev = null;
            Node curr = head;

            while (curr != null) {
                Node next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            return prev;
        }
    }

