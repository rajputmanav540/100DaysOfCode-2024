//GFG Question -> Row with max 1s
// Given a boolean 2D array, consisting of only 1's and 0's, where each row is sorted.
// Return the 0-based index of the first row that has the most number of 1s. If no such row exists, return -1.

#include <iostream>
#include <vector>
using namespace std;

int rowWithMax1s(vector<vector<int>> &arr) {       //time complexity O(n) and space O(1)
    int maxRowIndex = -1;
    int row = 0;
    int col = arr[0].size() - 1;
    while (row < arr.size() && col >= 0) {
        if (arr[row][col] == 1) {
            maxRowIndex = row;
            col--;
        } else {
            row++;
        }
    }
    return maxRowIndex;
}

int main() {
    int t;
    cout << "Enter number of test cases: ";
    cin >> t;
    while (t--) {
        int rows, cols;
        cout << "Enter number of rows and columns: ";
        cin >> rows >> cols;
        vector<vector<int>> arr(rows, vector<int>(cols));
        cout << "Enter the elements of the matrix:" << endl;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cin >> arr[i][j];
            }
        }
        int result = rowWithMax1s(arr);
        if (result != -1) {
            cout << "The row with the maximum number of 1s is: " << result << endl;
        } else {
            cout << "No 1s found in the matrix." << endl;
        }
    }
    return 0;
}