//LEETCODE PROBLEM 509
// The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
// F(0) = 0, F(1) = 1
// F(n) = F(n - 1) + F(n - 2), for n > 1.
// Given n, calculate F(n).

#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    int fib(int n) {        //time complexity O(2**n) and space complexity O(1)
        if(n==1) return 1;
        if(n==0) return 0;
        return fib(n-1)+fib(n-2);
    }
};

//Alternative Approach in time complexity O(n) and space complexity O(n)
// class Solution {
// public:
//     int fib(int n) {
//         int f[n+1];
//         if (n == 1 || n == 0) return n;
//         f[0] = 0;
//         f[1] = 1; 
//         for (int i=2; i<=n; i++) {
//             f[i] = f[i-1] + f[i-2];
//         }
//         return f[n];
//     }
// };

int main(){
    Solution s;
    cout << s.fib(6);
    return 0;
}