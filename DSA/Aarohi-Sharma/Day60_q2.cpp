class Solution {
public:
    vector<int> nextGreaterElements(vector<int>& nums) {
        int n = nums.size();
        vector<int> ans(n, -1);
        stack<int> stk;
        for (int i = 0; i < 2 * n; ++i) {
            while (!stk.empty() && nums[i % n] > nums[stk.top()]) {
                int idx = stk.top();
                stk.pop();
                ans[idx] = nums[i % n];
            }
            if (i < n) {
                stk.push(i);
            }
        }
        return ans;
    }
};
