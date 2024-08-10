// //LEETCODE PROBLEM 1011
// A conveyor belt has packages that must be shipped from one port to another within days days.
// The ith package on the conveyor belt has a weight of weights[i].
// Each day, we load the ship with packages on the conveyor belt (in the order given by weights).
// We may not load more weight than the maximum weight capacity of the ship.
// Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within days days.

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int check(vector<int>& weights, int cap){
        int days=1;
        int load=0;
        for(int i=0;i<weights.size();i++){
            if(weights[i]+load>cap){
                days+=1;
                load=weights[i];
            }
            else{
                load+=weights[i];
            }
        }
        return days;
    }
    int shipWithinDays(vector<int>& weights, int days) {    //time complexity O(n log n) and sapce complexity O(1)
        int n=weights.size();
        int sum = 0, max = weights[0];
        for(int i=0; i<n; i++){
            sum += weights[i];
            if(weights[i]>max) max = weights[i];
        }
        int lo = max, hi = sum;
        while(lo<=hi){
            int mid = lo + (hi-lo)/2;
            int noOfDays=check(weights,mid);
            if(noOfDays<=days){
                hi=mid-1;
            }
            else{
                lo=mid+1;
            }
        }
        return lo;
    }
};

int main(){
    Solution s;
    vector<int> weights={1,2,3,4,5,6,7,8,9,10};
    cout << s.shipWithinDays(weights,5);
    return 0;
}