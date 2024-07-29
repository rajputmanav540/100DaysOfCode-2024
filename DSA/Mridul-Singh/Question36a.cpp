//LEETCODE PROBLEM 670
// You are given an integer num. You can swap two digits at most once to get the maximum valued number.
// Return the maximum valued number you can get.
// Example 1:
// Input: num = 2736
// Output: 7236
// Explanation: Swap the number 2 and the number 7.

#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    int maximumSwap(int num) {      //time complexity O(n) and space complexity O(n)
        int ans=num;
        vector<int>digits;
        while(num){
            int a=num%10;
            digits.push_back(a);
            num=num/10;
        }
        reverse(digits.begin(),digits.end());
        int n=digits.size();
        int el=digits[n-1];
        vector<int>maxi(n,0);
        for(int i=n-1;i>=0;i--){
            if(el>digits[i]){
                maxi[i]=el;
            }
            else{
                maxi[i]=digits[i];
                el=digits[i];
            }  
        }
        int val=-1;
        int ind1=-1;
        for(int i=0;i<n;i++){
        if(maxi[i]!=digits[i]){
            val=maxi[i];
            ind1=i;
            break;
            }
        }
        if(val==-1){
            return ans;
        }
        int ind2=-1;
        for(int i=0;i<n;i++){
            if(digits[i]==val){
                ind2=i;
            }
        }
        swap(digits[ind1],digits[ind2]);
        int sum=0;
        for(auto it:digits){
            sum+=(it*pow(10,n-1));
            n--;
        }
        return sum;
    }
};

int main(){
    Solution s;
    cout << s.maximumSwap(7920);
    return 0;
}