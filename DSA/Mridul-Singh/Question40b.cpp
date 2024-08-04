//LEETCODE PROBLEM 838
// There are n dominoes in a line, and we place each domino vertically upright.
// In the beginning, we simultaneously push some of the dominoes either to the left or to the right.
// Input: dominoes = "RR.L"
// Output: "RR.L"
// Explanation: The first domino expends no additional force on the second domino.

#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    string pushDominoes(string dominoes) {
        int n = dominoes.size();
        int i = 0, j = 0;
        while (j < n) {
            if (dominoes[j] == '.') {
                j++;
            } else if (dominoes[j] == 'L') {
                if (dominoes[i] == 'R') {
                    // R.....L condition
                    int s = i, e = j;
                    while (s < e) {
                        dominoes[s++] = 'R';
                        dominoes[e--] = 'L';
                    }
                } else {
                    // .......L condition
                    for (int x = i; x <= j; x++)
                        dominoes[x] = 'L';
                }
                i = j + 1;
                j = j + 2;
            } else {
                if (dominoes[i] == 'R') {
                    // R.....R condition
                    for (int x = i; x <= j; x++)
                        dominoes[x] = 'R';
                }
                i = j;
                j++;
            }
        }
        // Check if i-th pos was at R
        // if yes
        // .....R......[end]
        if (dominoes[i] == 'R') {
            for (int x = i; x < n; x++)
                dominoes[x] = 'R';
        }
        return dominoes;
    }
};

int main(){
    Solution s;
    cout << s.pushDominoes("L.RRR.....L.R");
    return 0;
}