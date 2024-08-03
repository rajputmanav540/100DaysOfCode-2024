class Solution {
  public:
    int rowWithMax1s(vector<vector<int>> &arr) {
        int rows = arr.size();
        int cols = arr[0].size();
        int count = 0;
        vector<int> temp(rows, 0);
        
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(arr[i][j] == 1) {
                    count++;
                }
            }
            temp[i] = count;
            count = 0;
        }
        
        int ans = -1;
        int maxi = 0;
        for(int i=0; i<temp.size(); i++) {
            if (temp[i] > maxi) {
                maxi = temp[i];
                ans = i;
            }
        }
        return ans;
    }
};
