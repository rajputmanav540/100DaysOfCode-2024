//GFG Question -> Kth smallest element
// Given an array arr[] and an integer k where k is smaller than the size of the array,
// the task is to find the kth smallest element in the given array. It is given that all array elements are distinct.
// Note:-  l and r denotes the starting and ending index of the array.

#include<bits/stdc++.h>
using namespace std;

class Solution{
    public:
    int kthSmallest(int arr[], int l, int r, int k) {      //time complexity O(n) and space O(1)       
        std::priority_queue<int> pq;
        for (int i = 0; i < k; i++) {
            pq.push(arr[i]);
        }
        for (int i = k; i < r+1; i++) {
            if (arr[i] < pq.top()) {
                pq.pop();
                pq.push(arr[i]);
            }
        }
        return pq.top();
    }
};

int main()
{
    Solution s;
    int arr[5]={3,6,2,1,10};
    cout << s.kthSmallest(arr,0,4,2);
    return 0;
}