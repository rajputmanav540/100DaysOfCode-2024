class Solution {
public:
    int dominantIndex(vector<int>& nums) {
        int maxi = 0;
        int ans = 0;
        for (int i=0; i<nums.size(); i++) {
            if (nums[i] > maxi) {
                maxi = nums[i];
                ans = i;
            }
        }

        for(int i=0; i<nums.size(); i++) {
            if (nums[i] == maxi) {
                continue;
            }
            else {
                if (maxi >= 2*nums[i]) {
                    continue;
                }
                else {
                    return -1;
                }
            }
        }

        return ans;
    }
};
