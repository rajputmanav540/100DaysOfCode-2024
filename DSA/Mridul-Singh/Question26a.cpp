//LEETCODE PROBLEM 9
// Given an integer x, return true if x is a palindrome, and false otherwise.

#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        long long rev=0;
        int temp=x;
        while(x>0){
            int lastdigit=x%10;
            rev=(rev*10)+lastdigit;
            x=x/10;
        }
        if(rev==temp){
            return true;
        }
        return false;
    }
};

int main(){
    Solution solution;
    cout << solution.isPalindrome(121);
    return 0;
}