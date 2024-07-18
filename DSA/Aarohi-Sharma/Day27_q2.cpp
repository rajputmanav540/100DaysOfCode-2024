class Solution {
public:
    vector<int> majorityElement(vector<int>& nums) {
        unordered_map<int, int> Map;
        vector<int> ans;
        int n = nums.size();
        for (int i : nums) {
            Map[i]++;
        }
        for (const auto& pair : Map) {
            if (pair.second > n / 3) {
                ans.push_back(pair.first);
            }
        }
        return ans;
    }
};
