//LEETCODE PROBLEM 1
/*Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.
*/

#include<bits/stdc++.h>
using namespace std;

vector<int> twoSum(vector<int>& nums, int target) {         //time complexity O(n) and space is O(n)
    int n=nums.size();
    unordered_map<int,int> mp;          //storing array with there index
    for(int i=0;i<n;i++){
        mp[nums[i]]=i;
    }
    for(int i=0;i<n;i++){
        int y=target-nums[i];
        if(mp.count(y) && mp[y]!=i){
            return {i, mp[y]};
        }
    }
    return {};
}

int main(){
    vector<int > nums={2,7,5,8,9};
    int target=9;
    vector<int> res=twoSum(nums,target);
    for(int i=0;i<res.size();i++){
        cout << res[i] << " ";
    }
    return 0;
}