//GFG Question -> Median in a row-wise sorted Matrix
//Given a row wise sorted matrix of size R*C where R and C are always odd, find the median of the matrix.
#include <bits/stdc++.h>
using namespace std;

class Solution {   
public:
    int median(vector<vector<int>> &mat, int R, int C) {    //time complexity O(n) and space complexity O(1)
        int start = 20000, end = 0, ans;
        for(int i = 0; i < R; i++) {
            start = min(start, mat[i][0]);
            end = max(end, mat[i][C-1]);
        }
        while(start <= end) {
            int mid = start + (end - start) / 2;
            int freq = 0;
            for(int i = 0; i < R; i++) {
                freq += countLessEqual(mat[i], mid);
            }            
            if(freq >= (R * C + 1) / 2) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
    
private:
    int countLessEqual(const vector<int>& row, int mid) {
        int count = 0;
        for(int num : row) {
            if(num <= mid) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }
};

int main() {
    int R, C;
    cout << "Enter the number of rows and columns: ";
    cin >> R >> C;
    vector<vector<int>> mat(R, vector<int>(C));
    cout << "Enter the elements of the matrix row-wise:" << endl;
    for(int i = 0; i < R; i++) {
        for(int j = 0; j < C; j++) {
            cin >> mat[i][j];
        }
    }
    Solution sol;
    int result = sol.median(mat, R, C);
    cout << "The median of the matrix is: " << result << endl;
    return 0;
}
