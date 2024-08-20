class Solution {
    // Function to merge two sorted linked lists
    Node mergeTwoLists(Node a, Node b) {
        // If either list is empty, return the other list
        if (a == null) return b;
        if (b == null) return a;
        
        Node result;
        
        // Compare the data in both nodes and recurse
        if (a.data < b.data) {
            result = a;
            result.bottom = mergeTwoLists(a.bottom, b);
        } else {
            result = b;
            result.bottom = mergeTwoLists(a, b.bottom);
        }
        
        return result;
    }

    // Function to flatten the linked list
    Node flatten(Node root) {
        // Base case: If the root is null or there's no next node
        if (root == null || root.next == null) {
            return root;
        }
        
        // Recur for list on the right
        root.next = flatten(root.next);
        
        // Merge this list with the flattened next list
        root = mergeTwoLists(root, root.next);
        
        return root;
    }
}
