// LEETCODE PROBLEM 829
// Given an integer n, return the number of ways you can write n as the sum of consecutive positive integers.
// Example 1:
// Input: n = 5
// Output: 2
// Explanation: 5 = 2 + 3

#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    int consecutiveNumbersSum(int n) {      //time complexity O(root(n)) and space complexity O(1)
        int count =0;
        for(int i=1;2*n>i*(i-1);i++){
            int num= n-(i*(i-1)/2);
            if(num%i==0){
                count++;
            }
        }
        return count;
    }
};

int main(){
    Solution s;
    cout << s.consecutiveNumbersSum(15);
    return 0;
}