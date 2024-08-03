class Solution {
public:
    int numTimesAllBlue(vector<int>& flips) {
        int n=flips.size();
        int ans=0, mx=INT_MIN;
        for(int i = 0; i < n; i++) {
            int a=flips[i];
            mx=max(mx, a);
            if(mx<=i+1){
                ans++;
            }
        }
        return ans;
    }
};
