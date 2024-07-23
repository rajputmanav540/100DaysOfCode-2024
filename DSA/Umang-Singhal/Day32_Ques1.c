#include <stdio.h>
#include <stdlib.h>
#define MAX_NODES 100
int values[MAX_NODES];
int left[MAX_NODES];
int right[MAX_NODES];
void readTree(int n) {
    for (int i = 0; i < n; i++) {
        printf("Enter value for node %d: ", i);
        scanf("%d", &values[i]);
        printf("Enter left child index for node %d (-1 if no left child): ", i);
        scanf("%d", &left[i]);
        printf("Enter right child index for node %d (-1 if no right child): ", i);
        scanf("%d", &right[i]);
    }
}
int removeHalfNodes(int node) {
    if (node == -1) {
        return -1;
    }
    left[node] = removeHalfNodes(left[node]);
    right[node] = removeHalfNodes(right[node]);
    if (left[node] == -1 && right[node] == -1) {
        return node;
    }
    if (left[node] == -1) {
        return right[node];
    }
    if (right[node] == -1) {
        return left[node];
    }
    return node;
}
void inorderTraversal(int node) {
    if (node == -1) {
        return;
    }
    inorderTraversal(left[node]);
    printf("%d ", values[node]);
    inorderTraversal(right[node]);
}
int main() {
    int n;
    printf("Enter the number of nodes in the tree: ");
    scanf("%d", &n);
    readTree(n);
    int root;
    printf("Enter the index of the root node: ");
    scanf("%d", &root);
    root = removeHalfNodes(root);
    printf("Inorder traversal of the modified tree: ");
    inorderTraversal(root);
    printf("\n");
    return 0;
}
