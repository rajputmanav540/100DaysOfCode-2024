// LEETCODE PROBLEM 680
// Given a string s, return true if the s can be palindrome after deleting at most one character from it.
// Example 1:
// Input: s = "aba"
// Output: true

# include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool checkPalindrome(string str,int s,int e){
        while(s<=e){
            if(str[s]!=str[e]) return false;
            s++;
            e--;
        }
        return true;
    }
    bool validPalindrome(string s) {    //time complexity O(n) and space complexity O(1)
        int count =0;
        int n=s.size();
        int l=0,h=n-1;
        while(l<=h){
            if(s[l]==s[h]){
                l++;
                h--;
            }
            else{
                return (checkPalindrome(s,l+1,h)) || checkPalindrome(s,l,h-1);
            }
        }
        return true;
    }
};

int main(){
    Solution s;
    cout << s.validPalindrome("abba");
    return 0;
}