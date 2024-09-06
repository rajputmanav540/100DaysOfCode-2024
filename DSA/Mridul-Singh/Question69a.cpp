//LEETCODE PROBLEM 102

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

#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
       vector<vector<int>> ans;
        if (root == nullptr) return ans;
        queue<TreeNode*> q;
        q.push(root);
        while (!q.empty()) {
            vector<int> level;
            int s = q.size();
            for (int i = 0; i < s; i++) {
                TreeNode* Node = q.front();
                q.pop();
                if (Node->left != nullptr) q.push(Node->left);
                if (Node->right != nullptr) q.push(Node->right);
                level.push_back(Node->val);
            }
            ans.push_back(level);
        }
        return ans;
    }
};


//Another Apporach
// int height(struct node* node){
//     if(node==NULL){
//         return 0;
//     }
//     int lheight=height(node->left);
//     int rheight=height(node->right);
//     if(lheight>rheight){
//         return lheight+1;
//     }
//     else{
//         return rheight+1;
//     }
// }

// void printCurrentLevel(struct node* node,int level){
//     if(node==NULL){
//         return;
//     }
//     if(level==1){
//         printf("%d  ",node->data);
//     }
//     else if(level>1){
//         printCurrentLevel(node->left,level-1);
//         printCurrentLevel(node->right,level-1);
//     }
// }


// void printLevel(struct node* node){
//     for(int i=1;i<=height(node);i++){
//         printCurrentLevel(node,i);
//     }
// }