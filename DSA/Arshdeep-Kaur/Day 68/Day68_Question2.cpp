class Solution {
public:
    void preOrder(TreeNode* node, vector<int> &ans) {
        //base case 
        if (node == NULL) {
            return;
        }

        ans.push_back(node -> val);
        preOrder(node -> left, ans);
        preOrder(node -> right, ans);
    }

    vector<int> preorderTraversal(TreeNode* root) {
        vector<int> ans;

        preOrder(root, ans);
        return ans;
    }
};
