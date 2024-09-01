//GFG QUESTION -> Left View of Binary Tree

#include<bits/stdc++.h>
using namespace std;

vector<int> leftView(Node *root){   //time complexity O(n) and space complexity O(n)
    if(root==NULL) return {};
    vector<int> ans;
    queue<Node*> q;
    q.push(root);
    while(!q.empty()){
        int size = q.size();
        for(int i=0; i<size; i++){
            Node* node = q.front();
            q.pop();
            if(node->left) q.push(node->left);
            if(node->right) q.push(node->right);
            if(i==0){
                ans.push_back(node->data);
            }
        }
    }
    return ans;
}

//Another Apporach
// class Solution {
// public:
//     vector<int> ans;
//     void right(TreeNode* root, int level){      //time complexity O(n) and space compexity O(Height of tree)
//         if(root==NULL){
//             return;
//         }
//         if(level==ans.size()){
//             ans.push_back(root->val);
//         }
//         right(root->left,level+1);
//         right(root->right,level+1);
//     }
//     vector<int> rightSideView(TreeNode* root) {
//         right(root,0);
//         return ans;
//     }
// };
