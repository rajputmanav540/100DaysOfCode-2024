//LEETCODE PROBLEM 1007
// In a row of dominoes, tops[i] and bottoms[i] represent the top and bottom halves of the ith domino. (A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)
// We may rotate the ith domino, so that tops[i] and bottoms[i] swap values.
// Return the minimum number of rotations so that all the values in tops are the same, or all the values in bottoms are the same.
// If it cannot be done, return -1.

#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    int minDominoRotations(vector<int>& tops, vector<int>& bottoms) {       //time complexity O(n) and space complexity O(1)
        vector<int> countTop(7),countBottom(7),countSame(7);
        int n=tops.size();
        for(int i=0;i<n;i++){
            countTop[tops[i]]++;
            countBottom[bottoms[i]]++;
            if(tops[i]==bottoms[i])countSame[tops[i]]++;
        }
        int ans=n;
        for(int i=1;i<7;i++){
            if(countTop[i]+countBottom[i]-countSame[i]==n){
                int minSwap=min(countTop[i],countBottom[i])-countSame[i];
                ans=min(ans,minSwap);
            }
        }
        return ans==n?-1:ans;
    }
};

int main(){
    Solution s;
    vector<int> top={2,1,2,4,2,2};
    vector<int> bottom={5,2,6,2,3,2};
    cout << s.minDominoRotations(top,bottom);
    return 0;
}