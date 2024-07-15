class Solution {
public:
    vector<int> sortedSquares(vector<int>& nums) {
        vector<int> ans;

        for (int i:nums) {
            int temp = i*i;
            ans.push_back(temp);
        }
        sort(ans.begin(), ans.end());

        return ans;
    }
};
