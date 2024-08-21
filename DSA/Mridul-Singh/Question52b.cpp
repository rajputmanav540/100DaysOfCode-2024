//LEETCODE PROBLEM 786
// You are given a sorted integer array arr containing 1 and prime numbers,
// where all the integers of arr are unique. You are also given an integer k.
// For every i and j where 0 <= i < j < arr.length, we consider the fraction arr[i] / arr[j].
// Return the kth smallest fraction considered.
// Return your answer as an array of integers of size 2, where answer[0] == arr[i] and answer[1] == arr[j].

#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    pair<int, int> countFractionsLessThanOrEqualToMid(const vector<int>& arr, double mid, int& count) {
        int n = arr.size();
        int numerator = 0, denominator = 1;
        count = 0;
        for (int j = 1, i = 0; j < n; ++j) {
            while (i < j && arr[i] <= mid * arr[j]) {
                ++i;
            }
            count += i;
            if (i > 0 && arr[i - 1] * denominator > numerator * arr[j]) {
                numerator = arr[i - 1];
                denominator = arr[j];
            }
        }
        return {numerator, denominator};
    }

    vector<int> kthSmallestPrimeFraction(vector<int>& arr, int k) {     //time complexity O(n log n)
        double low = 0.0, high = 1.0;
        vector<int> result(2);
        while (low < high) {
            double mid = (low + high) / 2;
            int count = 0;
            auto [numerator, denominator] = countFractionsLessThanOrEqualToMid(arr, mid, count);
            if (count == k) {
                result[0] = numerator;
                result[1] = denominator;
                return result;
            } else if (count < k) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return result;
    }
};

int main() {
    Solution solution;
    vector<int> arr = {1, 2, 3, 5};
    int k = 3;
    vector<int> result = solution.kthSmallestPrimeFraction(arr, k);
    cout << "[" << result[0] << ", " << result[1] << "]" << endl;
    return 0;
}
