class Solution {
  public:
    Node *RemoveHalfNodes(Node *root) {
        if (!root) {
            return NULL;
        }
        
        Node* l = RemoveHalfNodes(root->left);
        Node* r = RemoveHalfNodes(root->right);
        
        root->left = l;
        root->right = r;
        
        if(!root->left && root->right) {
            return root->right;
        }
        
        if(root->left && !root->right) {
            return root->left;
        }
        
        return root;
    }
};
