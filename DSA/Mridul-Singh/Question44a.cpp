// GFG Question -> Minimize the Heights II
// Given an array arr[] denoting heights of N towers and a positive integer K.
// For each tower, you must perform exactly one of the following operations exactly once.
// Increase the height of the tower by K
// Decrease the height of the tower by K
// Find out the minimum possible difference between the height of the shortest and tallest towers after you have modified each tower.

#include <bits/stdc++.h>
using namespace std;

class Solution {
  public:
    int getMinDiff(int arr[], int n, int k) {    //time complexity O(nlogn) and space O(1)
        sort(arr,arr+n);
        int minEle;
        int maxEle;
        int result=arr[n-1]-arr[0];
        for(int i=1;i<=n-1;i++){
            if(arr[i]>=k){
                maxEle=max(arr[i-1]+k,arr[n-1]-k);
                minEle=min(arr[0]+k,arr[i]-k);
                result=min(result,maxEle-minEle);
            }
        }
        return result;
    }
};

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n, k;
        cin >> k;
        cin >> n;
        int arr[n];
        for (int i = 0; i < n; i++) {
            cin >> arr[i];
        }
        Solution ob;
        auto ans = ob.getMinDiff(arr, n, k);
        cout << ans << "\n";
    }
    return 0;
}