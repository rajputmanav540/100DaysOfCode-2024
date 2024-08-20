// LEETCODE PROBLME  410 - >  Split Array Largest Sum
// Given an integer array nums and an integer k, 
// split nums into k non-empty subarrays such that the largest sum of any subarray is minimized.
// Return the minimized largest sum of the split.
// A subarray is a contiguous part of the array.

#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool check(vector<int>& nums, int k, int mid) { 
        int subCount = 1;
        int subSum = 0;
        for(int i = 0; i < nums.size(); i++) {
            if(subSum + nums[i] > mid) {
                subCount++;
                subSum = nums[i];
            } else {
                subSum += nums[i];
            }
        }
        return subCount <= k;
    }

    int splitArray(vector<int>& nums, int k) {      //time complexity O(n log n ) and space complexity O(1)
        int low = *max_element(nums.begin(), nums.end());
        int high = accumulate(nums.begin(), nums.end(), 0);
        int ans = -1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(check(nums, k, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
};


int main() {
    Solution solution;
    vector<int> nums = {7,2,5,10,8};
    int k = 2;
    int result = solution.splitArray(nums, k);
    cout << "The minimum largest subarray sum for splitting the array into " << k << " subarrays is: " << result << endl;
    return 0;
}