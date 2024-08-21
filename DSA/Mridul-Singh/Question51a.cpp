// LEETCODE PROBLEM -> 1283 Find the Smallest Divisor Given a Threshold
// Given an array of integers nums and an integer threshold, we will choose a positive integer divisor, divide all the array by it, and sum the division's result.
// Find the smallest divisor such that the result mentioned above is less than or equal to threshold.
// Each result of the division is rounded to the nearest integer greater than or equal to that element. (For example: 7/3 = 3 and 10/2 = 5).
// The test cases are generated so that there will be an answer.

#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool check(vector<int> nums,int threshold,int mid){
        int ans=0;
        for(int num:nums){
            ans+=(num+mid-1)/mid;
        }
        return ans<=threshold;
    }
    int smallestDivisor(vector<int>& nums, int threshold) {     //time complexity O(nlog n)  and space complexity O(1)
        int n=nums.size();
        sort(nums.begin(),nums.end());      //you can also use high= *max_element(nums.begin(), nums.end());
        int low=1;
        int high=nums[n-1];
        while(low<=high){
            int mid=(high+low)/2;
            if(check(nums,threshold,mid)){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
};

int main(){
    Solution s;
    vector<int> arr={1,2,5,9};
    int th=6;
    cout << s.smallestDivisor(arr, th);
    return 0;
}