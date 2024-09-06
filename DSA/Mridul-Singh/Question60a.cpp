#include <iostream>
#include <vector>
#include <stack>
using namespace std;

class Solution {
public:
    vector<int> nextGreaterElements(vector<int>& nums) {
        int n = nums.size();
        vector<int> res(n, -1);
        stack<int> st;
        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!st.empty() && st.top() <= nums[i % n]) {
                st.pop();
            }
            if (!st.empty()) {
                res[i % n] = st.top();
            }
            st.push(nums[i % n]);
        }
        return res;
    }
};

int main() {
    Solution sol;
    vector<int> nums = {1, 2, 1};
    vector<int> result = sol.nextGreaterElements(nums);
    cout << "Next greater elements in circular array: ";
    for (int i : result) {
        cout << i << " ";
    }
    cout << endl;
    return 0;
}
