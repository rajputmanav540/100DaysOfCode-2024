class Solution {
public:
    void postOrder(TreeNode* node, vector<int> &ans) {
        //base case 
        if (node == NULL) {
            return;
        }

        postOrder(node -> left, ans);
        postOrder(node -> right, ans);
        ans.push_back(node -> val);
    }

    vector<int> postorderTraversal(TreeNode* root) {
        vector<int> ans;

        postOrder(root, ans);
        return ans;
    }
};
