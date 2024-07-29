//GFG Question -> Form a palindrome
//Given a string, find the minimum number of characters to be inserted to convert it to a palindrome.
// Examples :
// Input: str = "abcd"
// Output: 3
// Explanation: Inserted character marked with bold characters in dcbabcd, here we need minimum three characters to make it palindrome.

#include<bits/stdc++.h>
using namespace std;

int countMin(string str) {
    int n = str.length();
    vector<vector<int>> dp(n, vector<int>(n, 0));
    for (int gap = 1; gap < n; ++gap) {
        for (int l = 0, h = gap; h < n; ++l, ++h) {
            if (str[l] == str[h]) {
                dp[l][h] = dp[l + 1][h - 1];
            } else {
                dp[l][h] = 1 + min(dp[l][h - 1], dp[l + 1][h]);
            }
        }
    }
    return dp[0][n - 1];
}

int main(){
    cout << countMin("aabb");
    return 0;
}