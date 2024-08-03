//GFG Question -> Minimum swaps and K together
// Given an array arr of n positive integers and a number k. One can apply a swap operation on the array any number of times,
// i.e choose any two index i and j (i < j) and swap arr[i] , arr[j] .
// Find the minimum number of swaps required to bring all the numbers less than or equal to k together,
// i.e. make them a contiguous subarray.

#include<bits/stdc++.h>
using namespace std;

class Solution
{
public:
    int minSwap(int arr[], int n, int k) {     //time complexity O(n) and space complexity O1
        int count=0;
        for(int i=0;i<n;i++){
            if(arr[i]<=k){
                count++;
            }
        }
        int bad=0;
        for(int i=0;i<count;i++){
            if(arr[i]>k){
                bad++;
            }
        }
        int minSwap=bad;
        for(int i=0,j=count;j<n;j++,i++){
            if(arr[i]>k){
                bad--;
            }
            if(arr[j]>k){
                bad++;
            }
            minSwap=min(minSwap,bad);
        }
        return minSwap;
    }
};

int main(){
    Solution s;
    int arr[6]={2,3,8,9,7,4};
    cout << s.minSwap(arr,6,6);
    return 0;
}