//LEETCODE PROBLEM 41
// Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.
// You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.
// Example 1:
// Input: nums = [1,2,0]
// Output: 3
// Explanation: The numbers in the range [1,2] are all in the array.

#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    int firstMissingPositive(vector<int>& nums) {       //time complexity O(n) and space complexity O(1)
       int n= size(nums);
        for(int i=0;i<n;i++){
            int x=nums[i]; 
            while(x>=1 && x<=n && x!=i+1 && nums[x-1]!=x){
                swap(nums[x-1],nums[i]);
                x=nums[i];
            }
        }
        for(int i=0;i<n;i++){
            if(nums[i] == i+1)continue;
                return i+1;       
            
        }
        return n+1;
    }
};

int main(){
    Solution s;
    vector<int> arr={1,2,3,4};
    cout << s.firstMissingPositive(arr);
    return 0;
}