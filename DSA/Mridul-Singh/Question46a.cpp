//LEETCODE PROBLEM 11
// You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
// Find two lines that together with the x-axis form a container, such that the container contains the most water.
// Return the maximum amount of water a container can store.

#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    int maxArea(vector<int>& height) {      //time complexity O(n) and space complexity O(1)
        int left=0;
        int right=height.size()-1;
        int max_water=INT_MIN;
        while(right>left){
            int curr=0;
            curr=(right-left)*std::min(height[left],height[right]);
            if(curr>max_water){
                max_water=curr;
            }
            if(height[left]<=height[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return max_water;
    }
};

int main(){
    Solution s;
    vector<int> arr={10,20,30,40};
    cout << s.maxArea(arr);
    return 0;
}