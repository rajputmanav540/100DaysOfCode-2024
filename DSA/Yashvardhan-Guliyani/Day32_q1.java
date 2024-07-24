class Solution {
    public Node RemoveHalfNodes(Node root) {
        if (root == null)
            return null;
  
        root.left = RemoveHalfNodes(root.left);
        root.right = RemoveHalfNodes(root.right);
  
        
        if (root.left == null && root.right == null)
            return root;
  
        
        if (root.left == null) 
        {
            Node new_root = root.right;
            return new_root;
        }
  
        
        if (root.right == null) 
        {
            Node new_root = root.left;
            return new_root;
        }
  
        return root;
    }
}
