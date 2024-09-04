//LEETCODE PROBLEM 1339

#include <iostream>
#include <vector>
using namespace std;
const int MOD = 1e9 + 7;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};

class Solution {
public:
    long long totalSum = 0;
    long long maxProductVal = 0;

    long long calculateTotalSum(TreeNode* root) {
        if (!root) return 0;
        return root->val + calculateTotalSum(root->left) + calculateTotalSum(root->right);
    }

    long long findMaxProduct(TreeNode* root) {
        if (!root) return 0;
        long long subtreeSum = root->val + findMaxProduct(root->left) + findMaxProduct(root->right);
        maxProductVal = max(maxProductVal, subtreeSum * (totalSum - subtreeSum));
        return subtreeSum;
    }

    int maxProduct(TreeNode* root) {
        totalSum = calculateTotalSum(root);
        findMaxProduct(root);
        return maxProductVal % MOD;
    }
};

int main() {
    TreeNode* root = new TreeNode(1);
    root->left = new TreeNode(2);
    root->right = new TreeNode(3);
    root->left->left = new TreeNode(4);
    root->left->right = new TreeNode(5);
    root->right->left = new TreeNode(6);
    Solution solution;
    cout << "Max Product: " << solution.maxProduct(root) << endl; // Output should be 110
    return 0;
}
