//LEETCODE PROBLEM 739
//Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i]
//is the number of days you have to wait after the ith day to get a warmer temperature.
//If there is no future day for which this is possible, keep answer[i] == 0 instead.

#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& temperatures) {
        int n=temperatures.size();
        stack<int> st;
        vector<int> res(n,0);
        int index;
        for(int i=0;i<n;i++){
            while(!st.empty() && temperatures[st.top()] < temperatures[i]){
                index=st.top();
                res[index]=i-index;
                st.pop();
            }
            st.push(i);
        }
        return res;
    }
};

int main() {
    Solution sol;
    vector<int> temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
    vector<int> result = sol.dailyTemperatures(temperatures);
    cout << "Days to wait for a warmer temperature: ";
    for (int i : result) {
        cout << i << " ";
    }
    cout << endl;
    return 0;
}