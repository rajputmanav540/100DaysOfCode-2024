//GFG Question -> Smallest number
// Given two integers s and d. The task is to find the smallest number such that the sum of its digits is s and the number of digits in the number are d. Return a string that is the smallest possible number. If it is not possible then return -1.
// Examples:
// Input: s = 9, d = 2
// Output: 18 
// Explanation: 18 is the smallest number possible with the sum of digits = 9 and total digits = 2.

#include <bits/stdc++.h>
using namespace std;

string smallestNumber(int s, int d) {       //time complexity O(n) and space complexity O(1)
    if (s > 9 * d || s < 1) {
        return "-1";
    }
    string result(d, '0');
    s -= 1; 
    for (int i = d - 1; i > 0; --i) {
        if (s > 9) {
            result[i] = '9';
            s -= 9;
        } else {
            result[i] = '0' + s;
            s = 0;
        }
    }
    result[0] = '1' + s; 
    return result;
}

int main() {
    int s=99, d=3;
    cout << smallestNumber(s, d) << endl;
    return 0;
}
