/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
int totalSum(TreeNode* root){
        if(!root){return 0;}
        return root->val+totalSum(root->left)+totalSum(root->right);
    }
    pair<int,unsigned long long> solve(TreeNode* root,unsigned long long &sum){
        if(!root){return {0,0};}
        pair<unsigned long long,unsigned long long> left=solve(root->left,sum);
        pair<unsigned long long,unsigned long long> right=solve(root->right,sum);
        return {root->val+left.first+right.first,max(max((sum-left.first)*left.first,(sum-right.first)*right.first),max(left.second,right.second))};
    }
public:
    int maxProduct(TreeNode* root){
        unsigned long long sum=totalSum(root);
        pair<unsigned long long,unsigned long long> ans=solve(root,sum);
        int mod_ans=ans.second%(int(1e9+7));
        return mod_ans;
        
    }
};
