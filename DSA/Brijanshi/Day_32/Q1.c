#include <stdio.h>
#include <stdlib.h>

struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
};

struct TreeNode* createTreeNode(int val) {
    struct TreeNode* node = (struct TreeNode*)malloc(sizeof(struct TreeNode));
    node->val = val;
    node->left = NULL;
    node->right = NULL;
    return node;
}

void inorderTraversal(struct TreeNode* root) {
    if (root == NULL) {
        return;
    }

    inorderTraversal(root->left);
    printf("%d ", root->val);
    inorderTraversal(root->right);
}

struct TreeNode* removeHalfNodes(struct TreeNode* root) {
    if (root == NULL) {
        return NULL;
    }

    root->left = removeHalfNodes(root->left);
    root->right = removeHalfNodes(root->right);

    if (root->left == NULL && root->right != NULL) {
        struct TreeNode* temp = root->right;
        free(root);
        return temp;
    }

    if (root->left != NULL && root->right == NULL) {
        struct TreeNode* temp = root->left;
        free(root);
        return temp;
    }

    return root;
}

int main() {
    struct TreeNode* root1 = createTreeNode(5);
    root1->left = createTreeNode(7);
    root1->right = createTreeNode(8);
    root1->left->left = createTreeNode(2);

    root1 = removeHalfNodes(root1);
    printf("Inorder traversal of modified tree: ");
    inorderTraversal(root1);
    printf("\n");

    struct TreeNode* root2 = createTreeNode(2);
    root2->left = createTreeNode(7);
    root2->right = createTreeNode(5);

    root2 = removeHalfNodes(root2);
    printf("Inorder traversal of modified tree: ");
    inorderTraversal(root2);
    printf("\n");

    return 0;
}
