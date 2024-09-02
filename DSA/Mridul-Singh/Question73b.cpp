//GFG QUESTION -> Image Multiplication

#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    const int MOD = 1000000007;
    long long helper(Node* root1, Node* root2) {
        if (root1 == nullptr || root2 == nullptr) {
            return 0;
        }
        long long product = (1LL * root1->data * root2->data) % MOD;
        product = (product + helper(root1->left, root2->right)) % MOD;
        product = (product + helper(root1->right, root2->left)) % MOD;
        return product;
    }
    long long imgMultiply(Node* root) {
        if (root == nullptr) {
            return 0;
        }
        long long result = (1LL * root->data * root->data) % MOD;
        result = (result + helper(root->left, root->right)) % MOD;
        return result;
    }
};
