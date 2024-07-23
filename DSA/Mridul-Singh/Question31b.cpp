// LEETCODE PROBLEM 238
// Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
// You must write an algorithm that runs in O(n) time and without using the division operation.
// Example 1:
// Input: nums = [1,2,3,4]
// Output: [24,12,8,6]

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {      //time complexity O(n) and space complexity O(n)
        int n = nums.size();
        vector<int> ans(n, 1);
        vector<int> left(n, 1);
        vector<int> right(n, 1);
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < n; i++) {
            ans[i] = left[i] * right[i];
        }
        return ans;
    }
};

int main(){
    vector<int> nums={10,2,3,5,15};
    Solution soultion;
    vector<int> ans=soultion.productExceptSelf(nums);
    for(int i=0;i<ans.size();i++){
        cout << ans[i] << " ";
    }
}