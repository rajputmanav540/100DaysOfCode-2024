//LEETCODE PROBLEM 1031
// Given an integer array nums and two integers firstLen and secondLen, return the maximum sum of elements in two non-overlapping subarrays with lengths firstLen and secondLen.
// The array with length firstLen could occur before or after the array with length secondLen, but they have to be non-overlapping.
// A subarray is a contiguous part of an array.

#include<bits/stdc++.h>
using namespace std;

class Solution {
    int n;
    vector<int> st;
    void build(vector<int> &nums){
        st=vector<int> (2*n,0);
        for(int i=n;i<2*n;i++){
            st[i]=nums[i-n];
        }
        for(int i=n-1;i>0;--i){
            st[i]=st[i<<1]+st[i<<1|1];
        }
    }
    int getSum(int l,int r){
        int res=0;
        for(l+=n,r+=n;l<r;l>>=1,r>>=1){
            if(l&1) res+=st[l++];
            if(r&1) res+=st[--r];
        }
        return res;
    }
public:
    int maxSumTwoNoOverlap(vector<int>& nums, int fl, int sl) {     //Time Complexity O(n**2) and space complexity O(1)
        n=nums.size();
        build(nums);
        int ans=0;
        for(int i=0;i<n-fl;i++){
            for(int j=i+fl;j<=n-sl;j++){
                ans=max(ans,getSum(i,i+fl)+getSum(j,j+sl));
            }
        }
        swap(fl,sl);
        for(int i=0;i<n-fl;i++){
            for(int j=i+fl;j<=n-sl;j++){
                ans=max(ans,getSum(i,i+fl)+getSum(j,j+sl));
            }
        }
        return ans;
    }
};