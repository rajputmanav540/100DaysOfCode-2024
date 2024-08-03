// LLETCODE PROBLEM 849
// You are given an array representing a row of seats where seats[i] = 1 represents a person sitting in the ith seat, and seats[i] = 0 represents that the ith seat is empty (0-indexed).
// There is at least one empty seat, and at least one person sitting.
// Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized. 
// Return that maximum distance to the closest person.

#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    int maxDistToClosest(vector<int>& seats) {  //time complextion O(n) and space complexity O(1)
        int l=-1;
        int maxDis=0;
        int n=seats.size();
        for(int i=0;i<n;i++){
            if(seats[i]==1){
                if(l==-1){
                    maxDis=i;
                }
                else{
                maxDis=max(maxDis,(i-l)/2);
                }
                l=i;
            }
        }
        if(seats[n-1]==0){
            maxDis=max(maxDis,n-1-l);
        }
        return maxDis;
    }
};

int main(){
    Solution s;
    vector<int> arr={1,0,0,0,1,0,1};
    cout << s.maxDistToClosest(arr);
    return 0;
}