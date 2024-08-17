class GfG {
   public static Node quickSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node[] partitioned = partition(head);
        Node less = quickSort(partitioned[0]);
        Node pivot = partitioned[1];
        Node more = quickSort(partitioned[2]);

        return concatenate(less, pivot, more);
    }

    private static Node[] partition(Node head) {
        Node pivot = head;
        Node lessHead = null, lessTail = null;
        Node equalHead = null, equalTail = null;
        Node moreHead = null, moreTail = null;

        Node curr = head;
        while (curr != null) {
            if (curr.data < pivot.data) {
                if (lessHead == null) {
                    lessHead = lessTail = curr;
                } else {
                    lessTail.next = curr;
                    lessTail = curr;
                }
            } else if (curr.data == pivot.data) {
                if (equalHead == null) {
                    equalHead = equalTail = curr;
                } else {
                    equalTail.next = curr;
                    equalTail = curr;
                }
            } else {
                if (moreHead == null) {
                    moreHead = moreTail = curr;
                } else {
                    moreTail.next = curr;
                    moreTail = curr;
                }
            }
            curr = curr.next;
        }

        if (lessTail != null) lessTail.next = null;
        if (equalTail != null) equalTail.next = null;
        if (moreTail != null) moreTail.next = null;

        return new Node[]{lessHead, equalHead, moreHead};
    }

    private static Node concatenate(Node less, Node pivot, Node more) {
        Node head = less;

        if (head == null) {
            head = pivot;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = pivot;
        }

        if (pivot != null) {
            Node temp = pivot;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = more;
        }

        return head;
    }
}
