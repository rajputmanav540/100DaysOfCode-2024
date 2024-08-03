class Solution {
public:
    int minSwap(int arr[], int n, int k) {
        int nums = 0;
        for(int i=0; i<n; i++) {
            if (arr[i] <= k) {
                nums++;
            }
        }
        
        int curr_wndw =  0;
        for(int i=0; i<nums; i++) {
            if(arr[i] <= k) {
                curr_wndw++;
            }
        }
        
        int ans = nums - curr_wndw;
        for(int i=nums; i<n; i++) {
            if (arr[i] <= k) {
                curr_wndw++;
            }
            if (arr[i-nums] <= k) {
                curr_wndw--;
            }
            
            ans = min(ans, nums - curr_wndw);
        }
        
        return ans;
    }
};
