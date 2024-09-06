class Solution {
    public:
    long long mod = 1000000007;
    
    void solve(Node* root,Node* root1,long long &sum) {
        if(!root || !root1) return;
        sum+=(root->data*root1->data);
        sum%=mod;
        solve(root->left,root1->right,sum);
        solve(root->right,root1->left,sum);
    }
    
    long long imgMultiply(Node *root) {
        long long sum=0;
        solve(root->left,root->right,sum);
        sum+=(root->data*root->data);
        sum%=mod;
        return sum;
    }
};
