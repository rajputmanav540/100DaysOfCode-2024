import java.util.*;
public class Day55_Solution2 {


/*node class of the linked list

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

*/

        public static Node reverse(Node node, int k) {
            // Your code here
            if(node == null){
                return null;
            }

            Node prev = null;
            Node curr = node;
            Node newNext = null;
            int size = 0;

            while(curr != null && size < k){

                newNext = curr.next;
                curr.next = prev;
                prev = curr;
                curr = newNext;
                size++;


            }
            if(newNext != null)
                node.next = reverse(newNext, k);

            return prev;
        }
    
    }


