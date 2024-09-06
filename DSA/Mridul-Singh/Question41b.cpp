// LEETCODE PROBLEM 891
// The width of a sequence is the difference between the maximum and minimum elements in the sequence.
// Given an array of integers nums, return the sum of the widths of all the non-empty subsequences of nums. Since the answer may be very large, return it modulo 109 + 7.
// A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].

#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    int sumSubseqWidths(vector<int>& nums) {    //time complexity O(nlogn) and space complexity O(n)
        sort(nums.begin(), nums.end());
        long ans = 0;
        long mod = 1000000007;
        int n = nums.size();
        vector<long> pow(n);
        pow[0] = 1;
        for (int i = 1; i < n; i++) {
            pow[i] = (pow[i-1] * 2) % mod;
        }
        for (int i = 0; i < n; i++) {
            ans = (ans + nums[i] * (pow[i] - pow[n-1-i])) % mod;
        }
        return (ans + mod) % mod;
    }
};


int main(){
    Solution s;
    vector<int> arr={10,2,3,4,7};
    cout << s.sumSubseqWidths(arr);
    return 0;
}