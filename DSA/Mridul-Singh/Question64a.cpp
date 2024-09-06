//LEETCODE PROBLEM 316

#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    string removeDuplicateLetters(string s) {
        int n=s.size();
        vector<int> lastIndex(26,-1);
        stack<char> st;
        vector<bool> seen(26,false);
        for(int i=0;i<n;i++){
            lastIndex[s[i]-'a']=i;
        }
        for(int i=0;i<n;i++){
            int curr=s[i]-'a';
            if(seen[curr])continue;
            while(!st.empty() && st.top()>s[i] && i< lastIndex[st.top()-'a']){
                seen[st.top()-'a']=false;
                st.pop();
            }
            st.push(s[i]);
            seen[curr]=true;
        }
        string ans;
        while(!st.empty()){
            ans+=st.top();
            st.pop();
        }
        reverse(ans.begin(),ans.end());
        return ans;
    }
};

int main() {
    Solution sol;
    string s = "cbacdcbc";
    string result = sol.removeDuplicateLetters(s);
    cout << "Result: " << result << endl;
    return 0;
}