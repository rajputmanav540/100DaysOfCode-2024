class Solution {
public:
    vector<vector<int>> generate(int numRows) {
        vector<vector<int>> ans;

        for (int i=0; i<numRows; i++) {
            //creating a vector named "row" of i+1 size & storing the value "1" in it by default
            vector<int> row(i+1, 1);
            for (int j=1; j<i; j++) {
                row[j] = ans[i-1][j] + ans[i-1][j-1];
            }
            ans.push_back(row);
        }
        return ans;
    }
};
