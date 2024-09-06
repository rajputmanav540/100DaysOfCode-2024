//LEETCODE PROBLEM 155
//Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

#include<bits/stdc++.h>
using namespace std;

class MinStack {
public:
    stack<pair<int, int>> st;

    MinStack() {}

    void push(int val) {
        if (st.empty()) {
            st.push({val, val});
        } else {
            int currentMin = st.top().second;
            st.push({val, min(val, currentMin)});
        }
    }

    void pop() {
        if (!st.empty()) {
            st.pop();
        }
    }

    int top() {
        if (!st.empty()) {
            return st.top().first;
        }
        return -1;
    }

    int getMin() {
        if (!st.empty()) {
            return st.top().second;
        }
        return -1;
    }
};

int main(){
    MinStack minStack;
    minStack.push(5);
    minStack.push(3);
    minStack.push(7);
    minStack.push(2);
    minStack.push(8);
    cout << "Minimum element: " << minStack.getMin() << endl;
    return 0;
}