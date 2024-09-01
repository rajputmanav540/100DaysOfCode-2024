class Solution {
public:
    void inorder(TreeNode* node, vector<int> &ans) {
        if (node == NULL) {
            return;
        }

        inorder(node -> left, ans);
        ans.push_back(node -> val);
        inorder(node -> right, ans);
    }

    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> ans;

        inorder(root, ans);
        return ans;
    }
};
