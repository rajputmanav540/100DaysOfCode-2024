#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<int> asteroidCollision(vector<int>& asteroids) {
        stack<int> st;
        for(int i=0;i<asteroids.size();i++){
            bool collision = true;
            while(!st.empty() && st.top() > 0 && asteroids[i] < 0) {
                int diff = asteroids[i] + st.top();
                if (diff > 0) {
                    collision = false;
                    break;
                } else if (diff < 0) {
                    st.pop();
                } else {
                    st.pop();
                    collision = false;
                    break;
                }
            }
            if (collision) {
                st.push(asteroids[i]);
            }
        }
        vector<int> res;
        while(!st.empty()){
            res.push_back(st.top());
            st.pop();
        }
        reverse(res.begin(), res.end());
        return res;
    }
};

int main(){
    Solution s;
    vector<int> arr={5,10,-5};
    vector<int> res=s.asteroidCollision(arr);
    for(int i=0;i<res.size();i++){
        cout << res[i] << " ";
    }
    return 0;
}