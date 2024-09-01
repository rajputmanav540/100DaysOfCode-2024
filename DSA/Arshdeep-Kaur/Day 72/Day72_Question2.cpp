class Solution {
public:
    vector<vector<int>> verticalTraversal(TreeNode* root) {
        map<int, map<int, vector<int>>> nodes; // change multiset to vector
        queue<pair<TreeNode*, pair<int,int>>> q;
        vector<vector<int>> ans;
            
        if(root == NULL) {
            return ans;
        }
                
        q.push(make_pair(root, make_pair(0, 0)));
            
        while(!q.empty()) {
            pair<TreeNode*, pair<int,int>> temp = q.front();
            q.pop();
            TreeNode* frontNode = temp.first;
            int hd = temp.second.first;
            int lvl = temp.second.second;
                
            nodes[hd][lvl].push_back(frontNode->val);
            
            if(frontNode->left) {
                q.push(make_pair(frontNode->left, make_pair(hd-1, lvl+1)));
            }
                    
            if(frontNode->right) {
                q.push(make_pair(frontNode->right, make_pair(hd+1, lvl+1)));
            }
        }
            
        for(auto &col : nodes) {
            vector<int> colVec;
            for(auto &row : col.second) {
                // Sort the vector of nodes at the same position (row, col)
                sort(row.second.begin(), row.second.end());
                colVec.insert(colVec.end(), row.second.begin(), row.second.end());
            }
            ans.push_back(colVec);
        }

        return ans;
    }
};
