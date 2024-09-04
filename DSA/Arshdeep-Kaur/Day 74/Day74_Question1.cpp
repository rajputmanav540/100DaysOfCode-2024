class Solution {
public:
    long long ans = 0, totalSum = 0;
    int maxProduct(TreeNode* root) {
        totalSum = dfs(root);
        dfs(root);
        return ans % int(1e9+7);
    }

    int dfs(TreeNode* root) {
        if (root == NULL) {
            return 0;
        }

        int currSum = dfs(root->left) + dfs(root->right) + root->val;
        ans = max(ans, (totalSum - currSum) * currSum);
        return currSum;
    }
};
