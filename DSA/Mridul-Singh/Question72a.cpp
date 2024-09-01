//GFG QUESTION -> Bottom View of Binary Tree

#include<bits/stdc++.h>
using namespace std;

class Solution {
  public:
    vector <int> bottomView(Node *root) {
        vector<int> ans;
        if(root==nullptr)return ans;
        queue<pair<Node*,int>> q;
        map<int,int> mp;
        q.push({root,0});
        while(!q.empty()){
           auto p=q.front();
           q.pop();
           Node* node=p.first;
           int line=p.second;
           mp[line]=node->data;
           if(node->left){
               q.push({node->left,line-1});
           }
           if(node->right){
                q.push({node->right,line+1});
           }
        }
        for(auto p: mp){
            ans.push_back(p.second);
        }
        return ans;
    }
};