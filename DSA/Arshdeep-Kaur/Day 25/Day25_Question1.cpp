class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
        int start=0, end=nums.size()-1;
        
        while (start <= end) {
            while (start <= end && nums[start] != val) {
                start++;
            }
            while (start <= end && nums[end] == val) {
                end--;
            }
            if (start < end) {
                swap(nums[start++], nums[end--]);
            }
        }

        return start;
    }
};
