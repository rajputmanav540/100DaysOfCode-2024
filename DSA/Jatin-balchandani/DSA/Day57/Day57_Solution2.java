import java.util.*;
public class Day57_Solution2 {
    boolean isPalindrome(Node head)
    {
        //Your code here
        Node slow=head;
        Node fast=head;
        while(fast != null && fast.next !=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        Node prev=null;
        Node next;
        Node current=slow;
        while(current !=null)
        {
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        fast=head;
        while(prev !=null)
        {
            if(fast.data != prev.data)
            {
                return false;
            }
            fast=fast.next;
            prev=prev.next;


        }
        return true;
    }

}
