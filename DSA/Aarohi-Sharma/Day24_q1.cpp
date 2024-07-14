class Solution {
public:
    vector<int> sortedSquares(vector<int>& nums) {
        int n=nums.size();
        vector<int> arr(n);
        for(int i=0; i<nums.size(); i++){
            arr[i]=pow(nums[i], 2);
        }
        sort(arr.begin(), arr.end());
        return arr;
    }
};
