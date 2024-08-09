// LEETCODE PROBLEM 4
// Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
// The overall run time complexity should be O(log (m+n)).
// Example 1:
// Input: nums1 = [1,3], nums2 = [2]
// Output: 2.00000
// Explanation: merged array = [1,2,3] and median is 2.

#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {     //time complexity O(log(m+n)) and space complexity O(1)
        int n1 = nums1.size();
        int n2 = nums2.size();
        int n = n1 + n2;
        int i = 0, j = 0;
        int it = 0, ind1 = (n - 1) / 2, ind2 = n / 2;
        int ind1el = -1, ind2el = -1;
        while (it <= ind2) {
            int currentElement;
            if (i < n1 && (j >= n2 || nums1[i] <= nums2[j])) {
                currentElement = nums1[i];
                i++;
            } else {
                currentElement = nums2[j];
                j++;
            }
            if (it == ind1) ind1el = currentElement;
            if (it == ind2) ind2el = currentElement;
            it++;
        }
        if (n % 2 == 0) {
            return (double)(ind1el + ind2el) / 2.0;
        } else {
            return (double)ind2el;
        }
    }
};

int main(){
    Solution solution;
    vector<int> nums1 = {1, 3};
    vector<int> nums2 = {2};
    double result = solution.findMedianSortedArrays(nums1, nums2);
    cout << "Median of nums1: {1, 3} and nums2: {2} is " << result << endl;
    return 0;
}