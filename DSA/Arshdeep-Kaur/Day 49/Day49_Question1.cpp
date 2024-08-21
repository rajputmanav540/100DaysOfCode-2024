class Solution {
  public:
    int rowWithMax1s(vector<vector<int> > &arr) {
        int i=0, j=arr[0].size()-1, ans=-1;
        
        while(i<arr.size() && j>=0) {
            if(!arr[i][j]) {
                i++;
            }
            else {
                ans = i;
                j--;
            }
        }
        
        return ans;
    }
};
