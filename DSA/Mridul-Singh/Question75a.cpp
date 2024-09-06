//GFG QUESTION -> LCA in Binary Tree

#include <iostream>
using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};

class Solution {
public:
    TreeNode* findLCA(TreeNode* root, int n1, int n2) {
        if (root == nullptr || root->val == n1 || root->val == n2) {
            return root;
        }
        TreeNode* leftLCA = findLCA(root->left, n1, n2);
        TreeNode* rightLCA = findLCA(root->right, n1, n2);
        if (leftLCA && rightLCA) {
            return root;
        }
        return (leftLCA != nullptr) ? leftLCA : rightLCA;
    }
};

int main() {
    TreeNode* root = new TreeNode(3);
    root->left = new TreeNode(5);
    root->right = new TreeNode(1);
    root->left->left = new TreeNode(6);
    root->left->right = new TreeNode(2);
    root->right->left = new TreeNode(0);
    root->right->right = new TreeNode(8);
    root->left->right->left = new TreeNode(7);
    root->left->right->right = new TreeNode(4);
    Solution solution;
    int n1 = 5, n2 = 4;
    TreeNode* lca = solution.findLCA(root, n1, n2);
    if (lca) {
        cout << "LCA of " << n1 << " and " << n2 << " is: " << lca->val << endl;
    } else {
        cout << "One or both nodes are not present in the tree." << endl;
    }
    return 0;
}
