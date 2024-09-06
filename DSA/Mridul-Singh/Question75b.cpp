//LEETCODE PROBLEM 979

#include <iostream>
using namespace std;

struct TreeNode {
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};

class Solution {
public:
    int moves = 0;
    
    int distributeCoins(TreeNode* root) {
        dfs(root);
        return moves;
    }
    
    int dfs(TreeNode* node) {
        if (!node) return 0;
        int leftExcess = dfs(node->left);
        int rightExcess = dfs(node->right);
        int totalExcess = node->val + leftExcess + rightExcess - 1;
        moves += abs(leftExcess) + abs(rightExcess);
        return totalExcess;
    }
};

int main() {
    TreeNode* root = new TreeNode(3);
    root->left = new TreeNode(0);
    root->right = new TreeNode(0);
    Solution solution;
    cout << "Minimum number of moves: " << solution.distributeCoins(root) << endl;
    return 0;
}
