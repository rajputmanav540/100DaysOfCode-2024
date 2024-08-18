// Flattening a Linked List

class Day58_Q2 {
    static class Node {
        int data;
        Node next, bottom;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.bottom = null;
        }
    }

    Node merge(Node a, Node b) {
        if (a == null) return b;
        if (b == null) return a;

        Node result;
        if (a.data < b.data) {
            result = a;
            result.bottom = merge(a.bottom, b);
        } else {
            result = b;
            result.bottom = merge(a, b.bottom);
        }

        return result;
    }

    Node flatten(Node root) {
        if (root == null || root.next == null) return root;

        root.next = flatten(root.next);
        root = merge(root, root.next);

        return root;
    }
    void printFlattenedList(Node root) {
        Node temp = root;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.bottom;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Day58_Q2 solution = new Day58_Q2();
        Node root = new Node(5);
        root.next = new Node(10);
        root.next.next = new Node(19);
        root.next.next.next = new Node(28);

        root.bottom = new Node(7);
        root.bottom.bottom = new Node(8);
        root.bottom.bottom.bottom = new Node(30);

        root.next.bottom = new Node(20);

        root.next.next.bottom = new Node(22);
        root.next.next.bottom.bottom = new Node(50);

        root.next.next.next.bottom = new Node(35);
        root.next.next.next.bottom.bottom = new Node(40);
        root.next.next.next.bottom.bottom.bottom = new Node(45);
        root = solution.flatten(root);

        System.out.println("Flattened linked list:");
        solution.printFlattenedList(root);
    }
}
