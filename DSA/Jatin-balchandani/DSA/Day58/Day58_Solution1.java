public class Day58_Solution1 {
    static Node Segment(Node head) {
        // add your code here
        Node zero = new Node(-1);
        Node one = new Node(-1);
        Node two = new Node(-1);

        Node zeroHead = zero;
        Node oneHead = one;
        Node twoHead = two;

        Node temp = head;
        while(temp!=null){
            if(temp.data == 0){
                zero.next = temp;
                zero = temp;
            }else if(temp.data == 1){
                one.next = temp;
                one = temp;
            }else{
                two.next = temp;
                two = temp;
            }
            temp = temp.next;
        }

        zero.next = oneHead.next != null ? oneHead.next : twoHead.next;
        one.next = twoHead.next ;
        two.next = null;

        return zeroHead.next;
    }
}
