//GFG Question -> Kth element in Matrix
//Given a N x N matrix, where every row and column is sorted in non-decreasing order. Find the kth smallest element in the matrix.

#include <bits/stdc++.h>
using namespace std;
#define MAX 1000

int kthSmallest(int mat[MAX][MAX], int n, int k)
{
    priority_queue<pair<int, pair<int, int>>, vector<pair<int, pair<int, int>>>, greater<pair<int, pair<int, int>>>> minHeap;
    for (int i = 0; i < n; ++i) {
        minHeap.push({mat[i][0], {i, 0}});
    }
    int count = 0;
    int result = 0;
    while (count < k) {
        auto top = minHeap.top();
        minHeap.pop();
        result = top.first;
        int row = top.second.first;
        int col = top.second.second;
        if (col + 1 < n) {
            minHeap.push({mat[row][col + 1], {row, col + 1}});
        }
        count++;
    }
    return result;
}

int main() {
    int mat[MAX][MAX] = {
        {16, 28, 60, 64},
        {22, 41, 63, 91},
        {27, 50, 87, 93},
        {36, 78, 87, 94}
    };
    int n = 4;
    int k = 3;
    cout << "The " << k << "rd smallest element is " << kthSmallest(mat, n, k) << endl;
    return 0;
}
