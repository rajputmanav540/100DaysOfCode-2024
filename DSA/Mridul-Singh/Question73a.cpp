//LEETCODE PROBLEM 1145

#include<bits/stdc++.h>
using namespace syd;

 struct TreeNode {
     int val;
     TreeNode *left;
     TreeNode *right;
     TreeNode() : val(0), left(nullptr), right(nullptr) {}
     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 };

class Solution {
public:
    int countNode(TreeNode *root, TreeNode *NodeX){
        if(root == NULL || root == NodeX) return 0;
        int l = countNode(root->left, NodeX);
        int r = countNode(root->right, NodeX);
        return l + r + 1;
    }
    TreeNode *findNodeX(TreeNode *root, int x){
        if(root == NULL) return NULL;
        if(root->val == x) return root;
        TreeNode *l = findNodeX(root->left,x);
        TreeNode *r = findNodeX(root->right,x);
        if(l != NULL) return l;
        if(r != NULL) return r;
        return NULL;
    }
    bool btreeGameWinningMove(TreeNode* root, int n, int x) {
        TreeNode *NodeX = findNodeX(root, x);
        int p1 = countNode(NodeX->left, NULL);
        int p2 = countNode(NodeX->right, NULL);
        int p3 = countNode(root,NodeX);
        if(p1 > p2 && p1 > p3){
            return p1 > p2 + p3;
        }
        if(p2 > p1 && p2 > p3){
            return p2 > p1 + p3;
        }
        if(p3 > p1 && p3 > p2){
            return p3 > p1 + p2;
        }
        return false;
    }
};