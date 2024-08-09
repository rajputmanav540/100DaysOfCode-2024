//GFG QUESTION -> Row with max 1s
// You are given a 2D array consisting of only 1's and 0's, where each row is sorted in non-decreasing order.
//You need to find and return the index of the first row that has the most number of 1s. If no such row exists, return -1.
// Note: 0-based indexing is followed.

#include <bits/stdc++.h>
using namespace std;

int first_occurrence(vector<int> arr, int c, int x) {
    int low = 0;
    int high = c - 1;
    int ans = c;
    while (low <= high) {
        int mid = (low + high) / 2;
        if (arr[mid] >= x) {
            ans = mid;
            high = mid - 1;
        } else {
            low = mid + 1;
        }
    }
    return ans;
}

int rowWithMax1s(vector<vector<int>> &arr) {       //time complexity O(r log c) and space complexity O(1)
    int r = arr.size();
    int c = arr[0].size();
    int final_count = 0;
    int index = -1;
    for (int i = 0; i < r; i++) {
        int count = c - first_occurrence(arr[i], c, 1);
        if (count > final_count) {
            final_count = count;
            index = i;
        }
    }
    return index;
}

int main() {
    vector<vector<int>> arr = {
        {0, 1, 1, 1},
        {0, 0, 1, 1},
        {1, 1, 1, 1},
        {0, 0, 0, 0}
    };
    int result = rowWithMax1s(arr);
    if (result != -1) {
        cout << "The index of the row with the most 1s is: " << result << endl;
    } else {
        cout << "No row contains 1s." << endl;
    }
    return 0;
}
