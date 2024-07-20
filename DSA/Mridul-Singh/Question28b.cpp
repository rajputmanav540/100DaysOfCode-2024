//LEETCODE PROBLEM 118
// Given an integer numRows, return the first numRows of Pascal's triangle.
// In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
// Example 1:
// Input: numRows = 5
// Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<vector<int>> generate(int numRows) {        //time complexity O(n2) and space O(1)
        vector<vector<int>> ans;
        for(int i=1;i<=numRows;i++){
            vector<int> temp;
            temp.push_back(1);
            int res=1;
            for(int j=1;j<i;j++){
                res=res*(i-j);
                res=res/j;
                temp.push_back(res);
            }
            ans.push_back(temp);
        }
        return ans;
    }
};

int main()
{
    int row = 5;
    int col = 3;
    Solution solution;
    cout << "\nPascal Tree for " << row << " rows looks like : " << endl;
    vector<vector<int>> tree = solution.generate(row);
    for (auto &row : tree)
    {
        for (auto &column : row)
        {
            cout << column << " ";
        }
        cout << endl;
    }
    return 0;
}