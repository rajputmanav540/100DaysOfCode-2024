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
public:
    int numberOfElement(TreeNode *root){
        if(root){
            return 1+ numberOfElement(root->left)+numberOfElement(root->right);
        }
        return 0;
    }
    bool btreeGameWinningMove(TreeNode* root, int n, int x) {
        if(root){
            if(root->val == x){
                int left = numberOfElement(root->left);
                int right = numberOfElement(root->right);
                int upper = n-left-right-1;
                if(upper>left+right+1||left>n/2 || right>n/2){
                    return true;
                }else{
                    return false;
                }
            }
            return btreeGameWinningMove(root->left,n,x)||btreeGameWinningMove(root->right,n,x);
        }
        return false;
    }
};
