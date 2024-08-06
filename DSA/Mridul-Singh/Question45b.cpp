// LEETCODE PROBLME 899
// You are given a string s and an integer k. You can choose one of the first k letters of s and append it at the end of the string.
// Return the lexicographically smallest string you could have after applying the mentioned step any number of moves.

#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    string orderlyQueue(string s, int k) {      //time complexity O(n) and space complexity O(1)
        if(k>1){
            sort(s.begin(),s.end());
            return s;
        }
        string s_min=s;
        for(int i=0;i<s.size();i++){
            s=s.substr(1)+s[0];
            s_min=min(s,s_min);
        }
        return s_min;
    }
};

int main(){
    Solution s;
    cout << s.orderlyQueue("cba",1);
    return 0;
}