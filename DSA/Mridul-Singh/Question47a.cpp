//LEETCODE PROBLEM 74
// You are given an m x n integer matrix matrix with the following two properties:
// Each row is sorted in non-decreasing order.
// The first integer of each row is greater than the last integer of the previous row.
// Given an integer target, return true if target is in matrix or false otherwise.

#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {       //time complexity O(n) and space complexity O(1)
        int col=matrix[0].size();
        int row=matrix.size();
        int start=matrix[0][0];
        int searchRow=-1;
        for(int i=0;i<row;i++){
            if(target>=matrix[i][0] && target<=matrix[i][col-1]){
                searchRow=i;
                break;
            }
        }
        if(searchRow==-1){
            return false;
        }
        for(int j=0;j<col;j++){
            if(target==matrix[searchRow][j]){
                return true;
            }
        }
        return false;
    }
};

int main(){
    Solution s;
    vector<vector<int>> matrix={{1,3,5,7},{10,11,16,20},{23,30,34,60}};
    cout << s.searchMatrix(matrix,3);
    return 0;
}
