//LEETCODE PROBLEM 199 
//Given the root of a binary tree,imagine yourself standing on the right side of it,
//return the values of the nodes you can see ordered from top to bottom.

#include<bits/stdc++.h>
using namespace std;

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
    vector<int> ans;
    void right(TreeNode* root, int level){      //time complexity O(n) and space compexity O(Height of tree)
        if(root==NULL){
            return;
        }
        if(level==ans.size()){
            ans.push_back(root->val);
        }
        right(root->right,level+1);
        right(root->left,level+1);
    }
    vector<int> rightSideView(TreeNode* root) {
        right(root,0);
        return ans;
    }
};

// Another Solution using Queue
// vector<int> rightSideView(TreeNode* root) {
//         if(root==NULL) return {};
//         vector<int> ans;
//         queue<TreeNode*> q;
//         q.push(root);
//         while(!q.empty()){
//             int size = q.size();
//             for(int i=0; i<size; i++){
//                 TreeNode* node = q.front();
//                 q.pop();
//                 if(node->left) q.push(node->left);
//                 if(node->right) q.push(node->right);
//                 //only last size cuz bfs goes level wise, last size means rightmost
//                 if(i==size-1)
//                     ans.push_back(node->val);
//             }
//         }
//         return ans;
//     }