//LEETCODE PROBLEM 946
//Given two integer arrays pushed and popped each with distinct values,
//return true if this could have been the result of a sequence of push and pop operations on an initially empty stack,or false otherwise.

#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool validateStackSequences(vector<int>& pushed, vector<int>& popped) {
        stack<int> st;
        int j=0;
        for(int i=0;i<pushed.size();i++){
            st.push(pushed[i]);
            while(!st.empty() && j!=popped.size()){
                if(st.top()==popped[j]){
                    st.pop();
                    j++;
                }
                else{
                    break;
                }
            }
        }
        return st.empty();

    }
};

int main(){
    Solution s;
    vector<int> arr1={1,2,3,4,5};
    vector<int> arr2={4,5,3,2,1};
    cout << s.validateStackSequences(arr1,arr2);
    return 0;
}